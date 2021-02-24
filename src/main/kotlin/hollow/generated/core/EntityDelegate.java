package hollow.generated.core;

import hollow.generated.core.*;

import com.netflix.hollow.api.objects.delegate.HollowObjectDelegate;


@SuppressWarnings("all")
public interface EntityDelegate extends HollowObjectDelegate {

    public String getId(int ordinal);

    public boolean isIdEqual(int ordinal, String testValue);

    public int getIdOrdinal(int ordinal);

    public String getValue(int ordinal);

    public boolean isValueEqual(int ordinal, String testValue);

    public int getValueOrdinal(int ordinal);

    public EntityTypeAPI getTypeAPI();

}