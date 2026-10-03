package com.swmansion.rnscreens.utils;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
final class CacheKey {
    private final int fontSize;
    private final boolean isTitleEmpty;

    public static /* synthetic */ CacheKey copy$default(CacheKey cacheKey, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cacheKey.fontSize;
        }
        if ((i2 & 2) != 0) {
            z = cacheKey.isTitleEmpty;
        }
        return cacheKey.copy(i, z);
    }

    public final int component1() {
        return this.fontSize;
    }

    public final boolean component2() {
        return this.isTitleEmpty;
    }

    public final CacheKey copy(int i, boolean z) {
        return new CacheKey(i, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheKey)) {
            return false;
        }
        CacheKey cacheKey = (CacheKey) obj;
        return this.fontSize == cacheKey.fontSize && this.isTitleEmpty == cacheKey.isTitleEmpty;
    }

    public int hashCode() {
        return (Integer.hashCode(this.fontSize) * 31) + Boolean.hashCode(this.isTitleEmpty);
    }

    public String toString() {
        return "CacheKey(fontSize=" + this.fontSize + ", isTitleEmpty=" + this.isTitleEmpty + ")";
    }

    public CacheKey(int i, boolean z) {
        this.fontSize = i;
        this.isTitleEmpty = z;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final boolean isTitleEmpty() {
        return this.isTitleEmpty;
    }
}
