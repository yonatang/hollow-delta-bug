package hollow.generated.core;

import hollow.generated.core.*;

import com.netflix.hollow.api.objects.delegate.HollowObjectAbstractDelegate;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.core.schema.HollowObjectSchema;
import com.netflix.hollow.api.custom.HollowTypeAPI;
import com.netflix.hollow.api.objects.delegate.HollowCachedDelegate;

@SuppressWarnings("all")
public class EntityDelegateCachedImpl extends HollowObjectAbstractDelegate implements HollowCachedDelegate, EntityDelegate {

    private final String id;
    private final int idOrdinal;
    private final String value;
    private final int valueOrdinal;
    private EntityTypeAPI typeAPI;

    public EntityDelegateCachedImpl(EntityTypeAPI typeAPI, int ordinal) {
        this.idOrdinal = typeAPI.getIdOrdinal(ordinal);
        int idTempOrdinal = idOrdinal;
        this.id = idTempOrdinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(idTempOrdinal);
        this.valueOrdinal = typeAPI.getValueOrdinal(ordinal);
        int valueTempOrdinal = valueOrdinal;
        this.value = valueTempOrdinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(valueTempOrdinal);
        this.typeAPI = typeAPI;
    }

    public String getId(int ordinal) {
        return id;
    }

    public boolean isIdEqual(int ordinal, String testValue) {
        if(testValue == null)
            return id == null;
        return testValue.equals(id);
    }

    public int getIdOrdinal(int ordinal) {
        return idOrdinal;
    }

    public String getValue(int ordinal) {
        return value;
    }

    public boolean isValueEqual(int ordinal, String testValue) {
        if(testValue == null)
            return value == null;
        return testValue.equals(value);
    }

    public int getValueOrdinal(int ordinal) {
        return valueOrdinal;
    }

    @Override
    public HollowObjectSchema getSchema() {
        return typeAPI.getTypeDataAccess().getSchema();
    }

    @Override
    public HollowObjectTypeDataAccess getTypeDataAccess() {
        return typeAPI.getTypeDataAccess();
    }

    public EntityTypeAPI getTypeAPI() {
        return typeAPI;
    }

    public void updateTypeAPI(HollowTypeAPI typeAPI) {
        this.typeAPI = (EntityTypeAPI) typeAPI;
    }

}