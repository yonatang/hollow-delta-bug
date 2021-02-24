package records

import com.netflix.hollow.core.write.objectmapper.HollowPrimaryKey

@HollowPrimaryKey(fields = ["id"])
data class Entity(
    val id: String,
    val value: String
)
