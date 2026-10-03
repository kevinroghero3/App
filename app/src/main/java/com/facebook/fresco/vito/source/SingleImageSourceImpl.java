package com.facebook.fresco.vito.source;

import android.net.Uri;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleImageSourceImpl implements SingleImageSource {
    private final Map<String, Object> extras;
    private final Uri imageUri;
    private final Uri uri;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SingleImageSourceImpl copy$default(SingleImageSourceImpl singleImageSourceImpl, Uri uri, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = singleImageSourceImpl.uri;
        }
        if ((i & 2) != 0) {
            map = singleImageSourceImpl.extras;
        }
        return singleImageSourceImpl.copy(uri, map);
    }

    public final Uri component1() {
        return this.uri;
    }

    public final Map<String, Object> component2() {
        return this.extras;
    }

    public final SingleImageSourceImpl copy(@NotNull Uri uri, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new SingleImageSourceImpl(uri, map);
    }

    public String toString() {
        return "SingleImageSourceImpl(uri=" + this.uri + ", extras=" + this.extras + ")";
    }

    public SingleImageSourceImpl(@NotNull Uri uri, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.extras = map;
        this.imageUri = getUri();
    }

    public /* synthetic */ SingleImageSourceImpl(Uri uri, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? null : map);
    }

    @Override // com.facebook.fresco.vito.source.SingleImageSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.facebook.fresco.vito.source.UriImageSource
    public Map<String, Object> getExtras() {
        return this.extras;
    }

    public final Object getExtra(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, Object> extras = getExtras();
        if (extras != null) {
            return extras.get(key);
        }
        return null;
    }

    @Override // com.facebook.fresco.vito.source.SingleImageSource
    public String getStringExtra(@NotNull String key) {
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
        if (!Intrinsics.areEqual(SingleImageSourceImpl.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.fresco.vito.source.SingleImageSourceImpl");
        SingleImageSourceImpl singleImageSourceImpl = (SingleImageSourceImpl) obj;
        return Intrinsics.areEqual(getImageUri(), singleImageSourceImpl.getImageUri()) && Intrinsics.areEqual(getExtras(), singleImageSourceImpl.getExtras());
    }

    public int hashCode() {
        int iHashCode = getImageUri().hashCode();
        Map<String, Object> extras = getExtras();
        return (iHashCode * 31) + (extras != null ? extras.hashCode() : 0);
    }

    @Override // com.facebook.fresco.vito.source.UriImageSource
    public Uri getImageUri() {
        return this.imageUri;
    }
}
