import com.netflix.hollow.api.codegen.HollowAPIGenerator
import com.netflix.hollow.core.write.HollowWriteStateEngine
import com.netflix.hollow.core.write.objectmapper.HollowObjectMapper
import records.Entity

fun main() {

    val engine = HollowWriteStateEngine()
    val mapper = HollowObjectMapper(engine)
    mapper.initializeTypeState(Entity::class.java)

    HollowAPIGenerator.Builder().withAPIClassname("EntityApi")
        .withPackageName("hollow.generated")
        .withDataModel(engine)
        .withPackageGrouping()
        .withErgonomicShortcuts()
        .withDestination("./src/main/kotlin")
        .build().generateSourceFiles()
}
