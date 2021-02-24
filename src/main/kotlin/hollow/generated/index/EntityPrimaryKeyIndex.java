package hollow.generated.index;

import hollow.generated.EntityApi;
import hollow.generated.Entity;
import hollow.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.index.AbstractHollowUniqueKeyIndex;
import com.netflix.hollow.api.consumer.index.HollowUniqueKeyIndex;
import com.netflix.hollow.core.schema.HollowObjectSchema;

/**
 * @deprecated see {@link com.netflix.hollow.api.consumer.index.UniqueKeyIndex} which can be built as follows:
 * <pre>{@code
 *     UniqueKeyIndex<Entity, K> uki = UniqueKeyIndex.from(consumer, Entity.class)
 *         .usingBean(k);
 *     Entity m = uki.findMatch(k);
 * }</pre>
 * where {@code K} is a class declaring key field paths members, annotated with
 * {@link com.netflix.hollow.api.consumer.index.FieldPath}, and {@code k} is an instance of
 * {@code K} that is the key to find the unique {@code Entity} object.
 */
@Deprecated
@SuppressWarnings("all")
public class EntityPrimaryKeyIndex extends AbstractHollowUniqueKeyIndex<EntityApi, Entity> implements HollowUniqueKeyIndex<Entity> {

    public EntityPrimaryKeyIndex(HollowConsumer consumer) {
        this(consumer, true);
    }

    public EntityPrimaryKeyIndex(HollowConsumer consumer, boolean isListenToDataRefresh) {
        this(consumer, isListenToDataRefresh, ((HollowObjectSchema)consumer.getStateEngine().getNonNullSchema("Entity")).getPrimaryKey().getFieldPaths());
    }

    public EntityPrimaryKeyIndex(HollowConsumer consumer, String... fieldPaths) {
        this(consumer, true, fieldPaths);
    }

    public EntityPrimaryKeyIndex(HollowConsumer consumer, boolean isListenToDataRefresh, String... fieldPaths) {
        super(consumer, "Entity", isListenToDataRefresh, fieldPaths);
    }

    @Override
    public Entity findMatch(Object... keys) {
        int ordinal = idx.getMatchingOrdinal(keys);
        if(ordinal == -1)
            return null;
        return api.getEntity(ordinal);
    }

}