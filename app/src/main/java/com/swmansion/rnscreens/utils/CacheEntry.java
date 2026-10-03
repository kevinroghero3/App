package com.swmansion.rnscreens.utils;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
final class CacheEntry {
    public static final Companion Companion = new Companion(null);
    private static final CacheEntry EMPTY = new CacheEntry(new CacheKey(Integer.MIN_VALUE, false), 0.0f);
    private final CacheKey cacheKey;
    private final float headerHeight;

    public CacheEntry(@NotNull CacheKey cacheKey, float f) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.cacheKey = cacheKey;
        this.headerHeight = f;
    }

    public final CacheKey getCacheKey() {
        return this.cacheKey;
    }

    public final float getHeaderHeight() {
        return this.headerHeight;
    }

    public final boolean hasKey(@NotNull CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.cacheKey.getFontSize() != Integer.MIN_VALUE && Intrinsics.areEqual(this.cacheKey, key);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CacheEntry getEMPTY() {
            return CacheEntry.EMPTY;
        }
    }
}
