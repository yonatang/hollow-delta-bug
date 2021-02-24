package hollow.generated.core;

import hollow.generated.EntityApi;
import hollow.generated.core.*;

import com.netflix.hollow.api.custom.HollowObjectTypeAPI;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;

@SuppressWarnings("all")
public class EntityTypeAPI extends HollowObjectTypeAPI {

    private final EntityDelegateLookupImpl delegateLookupImpl;

    public EntityTypeAPI(EntityApi api, HollowObjectTypeDataAccess typeDataAccess) {
        super(api, typeDataAccess, new String[] {
            "id",
            "value"
        });
        this.delegateLookupImpl = new EntityDelegateLookupImpl(this);
    }

    public int getIdOrdinal(int ordinal) {
        if(fieldIndex[0] == -1)
            return missingDataHandler().handleReferencedOrdinal("Entity", ordinal, "id");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[0]);
    }

    public StringTypeAPI getIdTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public int getValueOrdinal(int ordinal) {
        if(fieldIndex[1] == -1)
            return missingDataHandler().handleReferencedOrdinal("Entity", ordinal, "value");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[1]);
    }

    public StringTypeAPI getValueTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public EntityDelegateLookupImpl getDelegateLookupImpl() {
        return delegateLookupImpl;
    }

    @Override
    public EntityApi getAPI() {
        return (EntityApi) api;
    }

}