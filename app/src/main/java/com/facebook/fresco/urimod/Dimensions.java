package com.facebook.fresco.urimod;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class Dimensions {
    private final int h;
    private final int w;

    public static /* synthetic */ Dimensions copy$default(Dimensions dimensions, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dimensions.w;
        }
        if ((i3 & 2) != 0) {
            i2 = dimensions.h;
        }
        return dimensions.copy(i, i2);
    }

    public final int component1() {
        return this.w;
    }

    public final int component2() {
        return this.h;
    }

    public final Dimensions copy(int i, int i2) {
        return new Dimensions(i, i2);
    }

    public Dimensions(int i, int i2) {
        this.w = i;
        this.h = i2;
    }

    public final int getH() {
        return this.h;
    }

    public final int getW() {
        return this.w;
    }

    public String toString() {
        return this.w + "x" + this.h;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(Dimensions.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.fresco.urimod.Dimensions");
        Dimensions dimensions = (Dimensions) obj;
        return this.w == dimensions.w && this.h == dimensions.h;
    }

    public int hashCode() {
        return (this.w * 31) + this.h;
    }
}
