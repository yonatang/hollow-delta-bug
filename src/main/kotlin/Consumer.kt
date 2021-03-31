import com.netflix.hollow.api.consumer.HollowConsumer
import com.netflix.hollow.api.consumer.fs.HollowFilesystemBlobRetriever
import hollow.generated.Entity
import hollow.generated.EntityApi
import java.io.File
import java.io.OutputStream
import java.io.PrintStream

fun main() {
    System.setErr(PrintStream(OutputStream.nullOutputStream())) // 2> /dev/null

    val file = File("./output")
    val retriever = HollowFilesystemBlobRetriever(file.toPath())

    val consumer = HollowConsumer
            .newHollowConsumer<HollowConsumer.Builder<*>>()
            .withBlobRetriever(retriever)
            .withGeneratedAPIClass(EntityApi::class.java)
            .build()


    val versions = file.listFiles()
            .filter { it.name.contains("snapshot") }
            .map { it.name.substringAfterLast("-") }
            .map { it.toLong() }
            .sorted()



    println("This should show 'en' and 'fr', because it will get a new HollowAPI instance each time:")
    versions.forEach {
        println("\trefresh to version $it")
        consumer.triggerRefreshTo(it)
        consumer.getAPI(EntityApi::class.java).allEntity.forEach { it.print() }
    }

    println("\n\nThis will show 'en' and 'en', although it should show 'en and 'fr', because no delta file exists and EntityApi is reused:\t")
    executeWithCachedApi(versions, consumer)

    // Enabling the delta files
    val missingDelta = File(file, "missing-delta-20210224060440001-20210224060441002")
    val delta = File(file, "delta-20210224060440001-20210224060441002")
    val missingRevDelta = File(file, "missing-reversedelta-20210224060441002-20210224060440001")
    val revDelta = File(file, "reversedelta-20210224060441002-20210224060440001")
    try {
        missingDelta.renameTo(delta)
        missingRevDelta.renameTo(revDelta)
        println("\n\nThis will show 'en' and 'fr' although EntityApi is reused because delta files exists:")
        executeWithCachedApi(versions, consumer)
    } finally {
        delta.renameTo(missingDelta)
        revDelta.renameTo(missingRevDelta)
    }

}

fun executeWithCachedApi(versions: List<Long>, consumer: HollowConsumer) {
    var api: EntityApi? = null

    fun getCachedApi(): EntityApi {
        if (api == null) {
            api = consumer.getAPI(EntityApi::class.java)
        }
        return api!!
    }
    versions.forEach {
        println("\trefresh to version $it")
        consumer.triggerRefreshTo(it)
        getCachedApi().allEntity.forEach { it.print() }

    }
}

fun Entity.print() {
    println("\t$id: $value")
}
