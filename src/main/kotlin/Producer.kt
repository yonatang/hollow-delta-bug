import com.netflix.hollow.api.producer.HollowProducer
import com.netflix.hollow.api.producer.fs.HollowFilesystemPublisher
import records.Entity
import java.io.File

fun main() {

    val file = File("./output").toPath()
    val publisher = HollowFilesystemPublisher(file)
    val producer = HollowProducer
        .withPublisher(publisher)
        .build()

    producer.initializeDataModel(Entity::class.java)

    producer.runCycle { state -> state.add(generate(1, "en")) }

    producer.runCycle { state -> state.add(generate(1, "fr")) }


}

fun generate(i: Int, lang: String) = Entity("$i", lang)

