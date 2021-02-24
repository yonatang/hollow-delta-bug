package hollow.generated;

import hollow.generated.EntityApi;
import hollow.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.index.UniqueKeyIndex;
import com.netflix.hollow.api.objects.HollowObject;
import com.netflix.hollow.core.schema.HollowObjectSchema;

@SuppressWarnings("all")
public class Entity extends HollowObject {

    public Entity(EntityDelegate delegate, int ordinal) {
        super(delegate, ordinal);
    }

    public String getId() {
        return delegate().getId(ordinal);
    }

    public boolean isIdEqual(String testValue) {
        return delegate().isIdEqual(ordinal, testValue);
    }

    public HString getIdHollowReference() {
        int refOrdinal = delegate().getIdOrdinal(ordinal);
        if(refOrdinal == -1)
            return null;
        return  api().getHString(refOrdinal);
    }

    public String getValue() {
        return delegate().getValue(ordinal);
    }

    public boolean isValueEqual(String testValue) {
        return delegate().isValueEqual(ordinal, testValue);
    }

    public HString getValueHollowReference() {
        int refOrdinal = delegate().getValueOrdinal(ordinal);
        if(refOrdinal == -1)
            return null;
        return  api().getHString(refOrdinal);
    }

    public EntityApi api() {
        return typeApi().getAPI();
    }

    public EntityTypeAPI typeApi() {
        return delegate().getTypeAPI();
    }

    protected EntityDelegate delegate() {
        return (EntityDelegate)delegate;
    }

    /**
     * Creates a unique key index for {@code Entity} that has a primary key.
     * The primary key is represented by the class {@link String}.
     * <p>
     * By default the unique key index will not track updates to the {@code consumer} and thus
     * any changes will not be reflected in matched results.  To track updates the index must be
     * {@link HollowConsumer#addRefreshListener(HollowConsumer.RefreshListener) registered}
     * with the {@code consumer}
     *
     * @param consumer the consumer
     * @return the unique key index
     */
    public static UniqueKeyIndex<Entity, String> uniqueIndex(HollowConsumer consumer) {
        return UniqueKeyIndex.from(consumer, Entity.class)
            .bindToPrimaryKey()
            .usingPath("id", String.class);
    }

}