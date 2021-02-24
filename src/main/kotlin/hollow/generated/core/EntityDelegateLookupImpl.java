package hollow.generated.core;

import hollow.generated.core.*;

import com.netflix.hollow.api.objects.delegate.HollowObjectAbstractDelegate;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.core.schema.HollowObjectSchema;

@SuppressWarnings("all")
public class EntityDelegateLookupImpl extends HollowObjectAbstractDelegate implements EntityDelegate {

    private final EntityTypeAPI typeAPI;

    public EntityDelegateLookupImpl(EntityTypeAPI typeAPI) {
        this.typeAPI = typeAPI;
    }

    public String getId(int ordinal) {
        ordinal = typeAPI.getIdOrdinal(ordinal);
        return ordinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(ordinal);
    }

    public boolean isIdEqual(int ordinal, String testValue) {
        ordinal = typeAPI.getIdOrdinal(ordinal);
        return ordinal == -1 ? testValue == null : typeAPI.getAPI().getStringTypeAPI().isValueEqual(ordinal, testValue);
    }

    public int getIdOrdinal(int ordinal) {
        return typeAPI.getIdOrdinal(ordinal);
    }

    public String getValue(int ordinal) {
        ordinal = typeAPI.getValueOrdinal(ordinal);
        return ordinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(ordinal);
    }

    public boolean isValueEqual(int ordinal, String testValue) {
        ordinal = typeAPI.getValueOrdinal(ordinal);
        return ordinal == -1 ? testValue == null : typeAPI.getAPI().getStringTypeAPI().isValueEqual(ordinal, testValue);
    }

    public int getValueOrdinal(int ordinal) {
        return typeAPI.getValueOrdinal(ordinal);
    }

    public EntityTypeAPI getTypeAPI() {
        return typeAPI;
    }

    @Override
    public HollowObjectSchema getSchema() {
        return typeAPI.getTypeDataAccess().getSchema();
    }

    @Override
    public HollowObjectTypeDataAccess getTypeDataAccess() {
        return typeAPI.getTypeDataAccess();
    }

}