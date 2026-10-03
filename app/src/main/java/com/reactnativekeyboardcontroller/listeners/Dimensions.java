package com.reactnativekeyboardcontroller.listeners;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Dimensions {
    private final double height;
    private final double width;

    public static /* synthetic */ Dimensions copy$default(Dimensions dimensions, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = dimensions.width;
        }
        if ((i & 2) != 0) {
            d2 = dimensions.height;
        }
        return dimensions.copy(d, d2);
    }

    public final double component1() {
        return this.width;
    }

    public final double component2() {
        return this.height;
    }

    public final Dimensions copy(double d, double d2) {
        return new Dimensions(d, d2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dimensions)) {
            return false;
        }
        Dimensions dimensions = (Dimensions) obj;
        return Double.compare(this.width, dimensions.width) == 0 && Double.compare(this.height, dimensions.height) == 0;
    }

    public int hashCode() {
        return (Double.hashCode(this.width) * 31) + Double.hashCode(this.height);
    }

    public String toString() {
        return "Dimensions(width=" + this.width + ", height=" + this.height + ")";
    }

    public Dimensions(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public final double getWidth() {
        return this.width;
    }

    public final double getHeight() {
        return this.height;
    }
}
