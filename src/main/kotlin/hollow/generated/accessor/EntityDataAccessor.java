package hollow.generated.accessor;

import hollow.generated.EntityApi;
import hollow.generated.Entity;
import hollow.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.data.AbstractHollowDataAccessor;
import com.netflix.hollow.core.index.key.PrimaryKey;
import com.netflix.hollow.core.read.engine.HollowReadStateEngine;

@SuppressWarnings("all")
public class EntityDataAccessor extends AbstractHollowDataAccessor<Entity> {

    public static final String TYPE = "Entity";
    private EntityApi api;

    public EntityDataAccessor(HollowConsumer consumer) {
        super(consumer, TYPE);
        this.api = (EntityApi)consumer.getAPI();
    }

    public EntityDataAccessor(HollowReadStateEngine rStateEngine, EntityApi api) {
        super(rStateEngine, TYPE);
        this.api = api;
    }

    public EntityDataAccessor(HollowReadStateEngine rStateEngine, EntityApi api, String ... fieldPaths) {
        super(rStateEngine, TYPE, fieldPaths);
        this.api = api;
    }

    public EntityDataAccessor(HollowReadStateEngine rStateEngine, EntityApi api, PrimaryKey primaryKey) {
        super(rStateEngine, TYPE, primaryKey);
        this.api = api;
    }

    @Override public Entity getRecord(int ordinal){
        return api.getEntity(ordinal);
    }

}