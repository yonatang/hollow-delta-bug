package hollow.generated.accessor;

import hollow.generated.EntityApi;
import hollow.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.data.AbstractHollowDataAccessor;
import com.netflix.hollow.core.index.key.PrimaryKey;
import com.netflix.hollow.core.read.engine.HollowReadStateEngine;

@SuppressWarnings("all")
public class StringDataAccessor extends AbstractHollowDataAccessor<HString> {

    public static final String TYPE = "String";
    private EntityApi api;

    public StringDataAccessor(HollowConsumer consumer) {
        super(consumer, TYPE);
        this.api = (EntityApi)consumer.getAPI();
    }

    public StringDataAccessor(HollowReadStateEngine rStateEngine, EntityApi api) {
        super(rStateEngine, TYPE);
        this.api = api;
    }

    public StringDataAccessor(HollowReadStateEngine rStateEngine, EntityApi api, String ... fieldPaths) {
        super(rStateEngine, TYPE, fieldPaths);
        this.api = api;
    }

    public StringDataAccessor(HollowReadStateEngine rStateEngine, EntityApi api, PrimaryKey primaryKey) {
        super(rStateEngine, TYPE, primaryKey);
        this.api = api;
    }

    @Override public HString getRecord(int ordinal){
        return api.getHString(ordinal);
    }

}