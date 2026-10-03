package androidx.navigation.serialization;

import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.core.CoreConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class RouteBuilder<T> {
    private final String path;
    private String pathArgs;
    private String queryArgs;
    private final KSerializer<T> serializer;

    enum ParamType {
        PATH,
        QUERY;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ParamType> getEntries() {
            return $ENTRIES;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ParamType.values().length];
            try {
                iArr[ParamType.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ParamType.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RouteBuilder(@NotNull KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.pathArgs = "";
        this.queryArgs = "";
        this.serializer = serializer;
        this.path = serializer.getDescriptor().getSerialName();
    }

    public RouteBuilder(@NotNull String path, @NotNull KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.pathArgs = "";
        this.queryArgs = "";
        this.serializer = serializer;
        this.path = path;
    }

    public final String build() {
        return this.path + this.pathArgs + this.queryArgs;
    }

    private final void addPath(String str) {
        this.pathArgs += '/' + str;
    }

    private final void addQuery(String str, String str2) {
        this.queryArgs += (this.queryArgs.length() == 0 ? CallerData.NA : "&") + str + '=' + str2;
    }

    public final void appendPattern(int i, @NotNull String name, @NotNull NavType<Object> type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        int i2 = WhenMappings.$EnumSwitchMapping$0[computeParamType(i, type).ordinal()];
        if (i2 == 1) {
            addPath(CoreConstants.CURLY_LEFT + name + CoreConstants.CURLY_RIGHT);
            return;
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        addQuery(name, CoreConstants.CURLY_LEFT + name + CoreConstants.CURLY_RIGHT);
    }

    public final void appendArg(int i, @NotNull String name, @NotNull NavType<Object> type, @NotNull List<String> value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        int i2 = WhenMappings.$EnumSwitchMapping$0[computeParamType(i, type).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Iterator<T> it2 = value.iterator();
            while (it2.hasNext()) {
                addQuery(name, (String) it2.next());
            }
            return;
        }
        if (value.size() != 1) {
            throw new IllegalArgumentException(("Expected one value for argument " + name + ", found " + value.size() + "values instead.").toString());
        }
        addPath((String) CollectionsKt___CollectionsKt.first((List) value));
    }

    private final ParamType computeParamType(int i, NavType<Object> navType) {
        if ((navType instanceof CollectionNavType) || this.serializer.getDescriptor().isElementOptional(i)) {
            return ParamType.QUERY;
        }
        return ParamType.PATH;
    }
}
