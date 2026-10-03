package com.facebook.fresco.animation.bitmap.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimationFrameCacheKey implements CacheKey {
    public static final Companion Companion = new Companion(null);
    private static final String URI_PREFIX = "anim://";
    private final String animationUriString;
    private final boolean deepEquals;

    public AnimationFrameCacheKey(int i) {
        this(i, false, 2, null);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }

    public AnimationFrameCacheKey(int i, boolean z) {
        this.deepEquals = z;
        this.animationUriString = URI_PREFIX + i;
    }

    public /* synthetic */ AnimationFrameCacheKey(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt__StringsJVMKt.startsWith$default(string, this.animationUriString, false, 2, null);
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.animationUriString;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(@Nullable Object obj) {
        if (!this.deepEquals) {
            return super.equals(obj);
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(AnimationFrameCacheKey.class, obj.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this.animationUriString, ((AnimationFrameCacheKey) obj).animationUriString);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        if (!this.deepEquals) {
            return super.hashCode();
        }
        return this.animationUriString.hashCode();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
