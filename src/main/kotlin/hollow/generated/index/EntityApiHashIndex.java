package hollow.generated.index;

import hollow.generated.EntityApi;
import hollow.generated.Entity;
import hollow.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.core.index.HollowHashIndexResult;
import java.util.Collections;
import java.lang.Iterable;
import com.netflix.hollow.api.consumer.index.AbstractHollowHashIndex;
import com.netflix.hollow.api.consumer.data.AbstractHollowOrdinalIterable;


/**
 * @deprecated see {@link com.netflix.hollow.api.consumer.index.HashIndex} which can be built as follows:
 * <pre>{@code
 *     HashIndex<HString, K> uki = HashIndex.from(consumer, HString.class)
 *         .usingBean(k);
 *     Stream<HString> results = uki.findMatches(k);
 * }</pre>
 * where {@code K} is a class declaring key field paths members, annotated with
 * {@link com.netflix.hollow.api.consumer.index.FieldPath}, and {@code k} is an instance of
 * {@code K} that is the query to find the matching {@code HString} objects.
 */
@Deprecated
@SuppressWarnings("all")
public class EntityApiHashIndex extends AbstractHollowHashIndex<EntityApi> {

    public EntityApiHashIndex(HollowConsumer consumer, String queryType, String selectFieldPath, String... matchFieldPaths) {
        super(consumer, true, queryType, selectFieldPath, matchFieldPaths);
    }

    public EntityApiHashIndex(HollowConsumer consumer, boolean isListenToDataRefresh, String queryType, String selectFieldPath, String... matchFieldPaths) {
        super(consumer, isListenToDataRefresh, queryType, selectFieldPath, matchFieldPaths);
    }

    public Iterable<HString> findStringMatches(Object... keys) {
        HollowHashIndexResult matches = idx.findMatches(keys);
        if(matches == null) return Collections.emptySet();

        return new AbstractHollowOrdinalIterable<HString>(matches.iterator()) {
            public HString getData(int ordinal) {
                return api.getHString(ordinal);
            }
        };
    }

    public Iterable<Entity> findEntityMatches(Object... keys) {
        HollowHashIndexResult matches = idx.findMatches(keys);
        if(matches == null) return Collections.emptySet();

        return new AbstractHollowOrdinalIterable<Entity>(matches.iterator()) {
            public Entity getData(int ordinal) {
                return api.getEntity(ordinal);
            }
        };
    }

}