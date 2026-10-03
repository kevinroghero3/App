package com.th3rdwave.safeareacontext;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class EdgeInsets {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public static /* synthetic */ EdgeInsets copy$default(EdgeInsets edgeInsets, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = edgeInsets.top;
        }
        if ((i & 2) != 0) {
            f2 = edgeInsets.right;
        }
        if ((i & 4) != 0) {
            f3 = edgeInsets.bottom;
        }
        if ((i & 8) != 0) {
            f4 = edgeInsets.left;
        }
        return edgeInsets.copy(f, f2, f3, f4);
    }

    public final float component1() {
        return this.top;
    }

    public final float component2() {
        return this.right;
    }

    public final float component3() {
        return this.bottom;
    }

    public final float component4() {
        return this.left;
    }

    public final EdgeInsets copy(float f, float f2, float f3, float f4) {
        return new EdgeInsets(f, f2, f3, f4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EdgeInsets)) {
            return false;
        }
        EdgeInsets edgeInsets = (EdgeInsets) obj;
        return Float.compare(this.top, edgeInsets.top) == 0 && Float.compare(this.right, edgeInsets.right) == 0 && Float.compare(this.bottom, edgeInsets.bottom) == 0 && Float.compare(this.left, edgeInsets.left) == 0;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.top) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom)) * 31) + Float.hashCode(this.left);
    }

    public String toString() {
        return "EdgeInsets(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ")";
    }

    public EdgeInsets(float f, float f2, float f3, float f4) {
        this.top = f;
        this.right = f2;
        this.bottom = f3;
        this.left = f4;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }
}
