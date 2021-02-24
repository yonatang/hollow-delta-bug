import com.netflix.hollow.api.consumer.HollowConsumer
import com.netflix.hollow.api.consumer.fs.HollowFilesystemBlobRetriever
import hollow.generated.Entity
import hollow.generated.EntityApi
import java.io.File

fun main() {
    val file = File("./output").toPath()
    val retriever = HollowFilesystemBlobRetriever(file)

    val consumer = HollowConsumer
        .newHollowConsumer<HollowConsumer.Builder<*>>()
        .withBlobRetriever(retriever)
        .withGeneratedAPIClass(EntityApi::class.java)
        .build()

    file.toFile().listFiles()
        .filter { it.name.contains("snapshot") }
        .map { it.name.substringAfterLast("-") }
        .map { it.toLong() }
        .sorted().forEach { version ->
            println("refresh to version $version")
            consumer.triggerRefreshTo(version)
            consumer.getAPI(EntityApi::class.java).allEntity
                .forEach { it.print() }
        }

}

fun Entity.print() {
    println("$id: $value")
}
