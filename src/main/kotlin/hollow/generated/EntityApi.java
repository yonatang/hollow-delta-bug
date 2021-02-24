package hollow.generated;

import hollow.generated.core.*;

import java.util.Objects;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.Map;
import com.netflix.hollow.api.consumer.HollowConsumerAPI;
import com.netflix.hollow.api.custom.HollowAPI;
import com.netflix.hollow.core.read.dataaccess.HollowDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowTypeDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowListTypeDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowSetTypeDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowMapTypeDataAccess;
import com.netflix.hollow.core.read.dataaccess.missing.HollowObjectMissingDataAccess;
import com.netflix.hollow.core.read.dataaccess.missing.HollowListMissingDataAccess;
import com.netflix.hollow.core.read.dataaccess.missing.HollowSetMissingDataAccess;
import com.netflix.hollow.core.read.dataaccess.missing.HollowMapMissingDataAccess;
import com.netflix.hollow.api.objects.provider.HollowFactory;
import com.netflix.hollow.api.objects.provider.HollowObjectProvider;
import com.netflix.hollow.api.objects.provider.HollowObjectCacheProvider;
import com.netflix.hollow.api.objects.provider.HollowObjectFactoryProvider;
import com.netflix.hollow.api.sampling.HollowObjectCreationSampler;
import com.netflix.hollow.api.sampling.HollowSamplingDirector;
import com.netflix.hollow.api.sampling.SampleResult;
import com.netflix.hollow.core.util.AllHollowRecordCollection;

@SuppressWarnings("all")
public class EntityApi extends HollowAPI  {

    private final HollowObjectCreationSampler objectCreationSampler;

    private final StringTypeAPI stringTypeAPI;
    private final EntityTypeAPI entityTypeAPI;

    private final HollowObjectProvider stringProvider;
    private final HollowObjectProvider entityProvider;

    public EntityApi(HollowDataAccess dataAccess) {
        this(dataAccess, Collections.<String>emptySet());
    }

    public EntityApi(HollowDataAccess dataAccess, Set<String> cachedTypes) {
        this(dataAccess, cachedTypes, Collections.<String, HollowFactory<?>>emptyMap());
    }

    public EntityApi(HollowDataAccess dataAccess, Set<String> cachedTypes, Map<String, HollowFactory<?>> factoryOverrides) {
        this(dataAccess, cachedTypes, factoryOverrides, null);
    }

    public EntityApi(HollowDataAccess dataAccess, Set<String> cachedTypes, Map<String, HollowFactory<?>> factoryOverrides, EntityApi previousCycleAPI) {
        super(dataAccess);
        HollowTypeDataAccess typeDataAccess;
        HollowFactory factory;

        objectCreationSampler = new HollowObjectCreationSampler("String","Entity");

        typeDataAccess = dataAccess.getTypeDataAccess("String");
        if(typeDataAccess != null) {
            stringTypeAPI = new StringTypeAPI(this, (HollowObjectTypeDataAccess)typeDataAccess);
        } else {
            stringTypeAPI = new StringTypeAPI(this, new HollowObjectMissingDataAccess(dataAccess, "String"));
        }
        addTypeAPI(stringTypeAPI);
        factory = factoryOverrides.get("String");
        if(factory == null)
            factory = new StringHollowFactory();
        if(cachedTypes.contains("String")) {
            HollowObjectCacheProvider previousCacheProvider = null;
            if(previousCycleAPI != null && (previousCycleAPI.stringProvider instanceof HollowObjectCacheProvider))
                previousCacheProvider = (HollowObjectCacheProvider) previousCycleAPI.stringProvider;
            stringProvider = new HollowObjectCacheProvider(typeDataAccess, stringTypeAPI, factory, previousCacheProvider);
        } else {
            stringProvider = new HollowObjectFactoryProvider(typeDataAccess, stringTypeAPI, factory);
        }

        typeDataAccess = dataAccess.getTypeDataAccess("Entity");
        if(typeDataAccess != null) {
            entityTypeAPI = new EntityTypeAPI(this, (HollowObjectTypeDataAccess)typeDataAccess);
        } else {
            entityTypeAPI = new EntityTypeAPI(this, new HollowObjectMissingDataAccess(dataAccess, "Entity"));
        }
        addTypeAPI(entityTypeAPI);
        factory = factoryOverrides.get("Entity");
        if(factory == null)
            factory = new EntityHollowFactory();
        if(cachedTypes.contains("Entity")) {
            HollowObjectCacheProvider previousCacheProvider = null;
            if(previousCycleAPI != null && (previousCycleAPI.entityProvider instanceof HollowObjectCacheProvider))
                previousCacheProvider = (HollowObjectCacheProvider) previousCycleAPI.entityProvider;
            entityProvider = new HollowObjectCacheProvider(typeDataAccess, entityTypeAPI, factory, previousCacheProvider);
        } else {
            entityProvider = new HollowObjectFactoryProvider(typeDataAccess, entityTypeAPI, factory);
        }

    }

    public void detachCaches() {
        if(stringProvider instanceof HollowObjectCacheProvider)
            ((HollowObjectCacheProvider)stringProvider).detach();
        if(entityProvider instanceof HollowObjectCacheProvider)
            ((HollowObjectCacheProvider)entityProvider).detach();
    }

    public StringTypeAPI getStringTypeAPI() {
        return stringTypeAPI;
    }
    public EntityTypeAPI getEntityTypeAPI() {
        return entityTypeAPI;
    }
    public Collection<HString> getAllHString() {
        HollowTypeDataAccess tda = Objects.requireNonNull(getDataAccess().getTypeDataAccess("String"), "type not loaded or does not exist in dataset; type=String");
        return new AllHollowRecordCollection<HString>(tda.getTypeState()) {
            protected HString getForOrdinal(int ordinal) {
                return getHString(ordinal);
            }
        };
    }
    public HString getHString(int ordinal) {
        objectCreationSampler.recordCreation(0);
        return (HString)stringProvider.getHollowObject(ordinal);
    }
    public Collection<Entity> getAllEntity() {
        HollowTypeDataAccess tda = Objects.requireNonNull(getDataAccess().getTypeDataAccess("Entity"), "type not loaded or does not exist in dataset; type=Entity");
        return new AllHollowRecordCollection<Entity>(tda.getTypeState()) {
            protected Entity getForOrdinal(int ordinal) {
                return getEntity(ordinal);
            }
        };
    }
    public Entity getEntity(int ordinal) {
        objectCreationSampler.recordCreation(1);
        return (Entity)entityProvider.getHollowObject(ordinal);
    }
    public void setSamplingDirector(HollowSamplingDirector director) {
        super.setSamplingDirector(director);
        objectCreationSampler.setSamplingDirector(director);
    }

    public Collection<SampleResult> getObjectCreationSamplingResults() {
        return objectCreationSampler.getSampleResults();
    }

}
