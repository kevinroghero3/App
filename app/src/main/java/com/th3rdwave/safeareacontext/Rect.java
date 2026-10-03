package com.th3rdwave.safeareacontext;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Rect {
    private final float height;
    private final float width;
    private final float x;
    private final float y;

    public static /* synthetic */ Rect copy$default(Rect rect, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = rect.x;
        }
        if ((i & 2) != 0) {
            f2 = rect.y;
        }
        if ((i & 4) != 0) {
            f3 = rect.width;
        }
        if ((i & 8) != 0) {
            f4 = rect.height;
        }
        return rect.copy(f, f2, f3, f4);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final float component3() {
        return this.width;
    }

    public final float component4() {
        return this.height;
    }

    public final Rect copy(float f, float f2, float f3, float f4) {
        return new Rect(f, f2, f3, f4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        return Float.compare(this.x, rect.x) == 0 && Float.compare(this.y, rect.y) == 0 && Float.compare(this.width, rect.width) == 0 && Float.compare(this.height, rect.height) == 0;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.width)) * 31) + Float.hashCode(this.height);
    }

    public String toString() {
        return "Rect(x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public Rect(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }
}
