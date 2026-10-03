package com.swmansion.rnscreens.utils;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class PaddingBundle {
    private final float height;
    private final float paddingEnd;
    private final float paddingStart;

    public static /* synthetic */ PaddingBundle copy$default(PaddingBundle paddingBundle, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = paddingBundle.height;
        }
        if ((i & 2) != 0) {
            f2 = paddingBundle.paddingStart;
        }
        if ((i & 4) != 0) {
            f3 = paddingBundle.paddingEnd;
        }
        return paddingBundle.copy(f, f2, f3);
    }

    public final float component1() {
        return this.height;
    }

    public final float component2() {
        return this.paddingStart;
    }

    public final float component3() {
        return this.paddingEnd;
    }

    public final PaddingBundle copy(float f, float f2, float f3) {
        return new PaddingBundle(f, f2, f3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaddingBundle)) {
            return false;
        }
        PaddingBundle paddingBundle = (PaddingBundle) obj;
        return Float.compare(this.height, paddingBundle.height) == 0 && Float.compare(this.paddingStart, paddingBundle.paddingStart) == 0 && Float.compare(this.paddingEnd, paddingBundle.paddingEnd) == 0;
    }

    public int hashCode() {
        return (((Float.hashCode(this.height) * 31) + Float.hashCode(this.paddingStart)) * 31) + Float.hashCode(this.paddingEnd);
    }

    public String toString() {
        return "PaddingBundle(height=" + this.height + ", paddingStart=" + this.paddingStart + ", paddingEnd=" + this.paddingEnd + ")";
    }

    public PaddingBundle(float f, float f2, float f3) {
        this.height = f;
        this.paddingStart = f2;
        this.paddingEnd = f3;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getPaddingStart() {
        return this.paddingStart;
    }

    public final float getPaddingEnd() {
        return this.paddingEnd;
    }
}
