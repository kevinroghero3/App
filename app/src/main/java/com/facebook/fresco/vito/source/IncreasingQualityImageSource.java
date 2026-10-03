package com.facebook.fresco.vito.source;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class IncreasingQualityImageSource implements ImageSource {
    private final Map<String, Object> extras;
    private final ImageSource highResSource;
    private final ImageSource lowResSource;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IncreasingQualityImageSource copy$default(IncreasingQualityImageSource increasingQualityImageSource, ImageSource imageSource, ImageSource imageSource2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            imageSource = increasingQualityImageSource.lowResSource;
        }
        if ((i & 2) != 0) {
            imageSource2 = increasingQualityImageSource.highResSource;
        }
        if ((i & 4) != 0) {
            map = increasingQualityImageSource.extras;
        }
        return increasingQualityImageSource.copy(imageSource, imageSource2, map);
    }

    public final ImageSource component1() {
        return this.lowResSource;
    }

    public final ImageSource component2() {
        return this.highResSource;
    }

    public final Map<String, Object> component3() {
        return this.extras;
    }

    public final IncreasingQualityImageSource copy(@NotNull ImageSource lowResSource, @NotNull ImageSource highResSource, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(lowResSource, "lowResSource");
        Intrinsics.checkNotNullParameter(highResSource, "highResSource");
        return new IncreasingQualityImageSource(lowResSource, highResSource, map);
    }

    public String toString() {
        return "IncreasingQualityImageSource(lowResSource=" + this.lowResSource + ", highResSource=" + this.highResSource + ", extras=" + this.extras + ")";
    }

    public IncreasingQualityImageSource(@NotNull ImageSource lowResSource, @NotNull ImageSource highResSource, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(lowResSource, "lowResSource");
        Intrinsics.checkNotNullParameter(highResSource, "highResSource");
        this.lowResSource = lowResSource;
        this.highResSource = highResSource;
        this.extras = map;
    }

    public /* synthetic */ IncreasingQualityImageSource(ImageSource imageSource, ImageSource imageSource2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, imageSource2, (i & 4) != 0 ? null : map);
    }

    public final ImageSource getLowResSource() {
        return this.lowResSource;
    }

    public final ImageSource getHighResSource() {
        return this.highResSource;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    public final Object getExtra(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, Object> map = this.extras;
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    public final String getStringExtra(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object extra = getExtra(key);
        if (extra instanceof String) {
            return (String) extra;
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(IncreasingQualityImageSource.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.fresco.vito.source.IncreasingQualityImageSource");
        IncreasingQualityImageSource increasingQualityImageSource = (IncreasingQualityImageSource) obj;
        return Intrinsics.areEqual(this.lowResSource, increasingQualityImageSource.lowResSource) && Intrinsics.areEqual(this.highResSource, increasingQualityImageSource.highResSource) && Intrinsics.areEqual(this.extras, increasingQualityImageSource.extras);
    }

    public int hashCode() {
        int iHashCode = this.lowResSource.hashCode();
        int iHashCode2 = this.highResSource.hashCode();
        Map<String, Object> map = this.extras;
        return (((iHashCode * 31) + iHashCode2) * 31) + (map != null ? map.hashCode() : 0);
    }
}
