package com.facebook.react.uimanager.style;

import com.facebook.react.uimanager.PixelUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class CornerRadii {
    private final float horizontal;
    private final float vertical;

    /* JADX WARN: Illegal instructions before constructor call */
    public CornerRadii() {
        float f = 0.0f;
        this(f, f, 3, null);
    }

    public static /* synthetic */ CornerRadii copy$default(CornerRadii cornerRadii, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = cornerRadii.horizontal;
        }
        if ((i & 2) != 0) {
            f2 = cornerRadii.vertical;
        }
        return cornerRadii.copy(f, f2);
    }

    public final float component1() {
        return this.horizontal;
    }

    public final float component2() {
        return this.vertical;
    }

    public final CornerRadii copy(float f, float f2) {
        return new CornerRadii(f, f2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CornerRadii)) {
            return false;
        }
        CornerRadii cornerRadii = (CornerRadii) obj;
        return Float.compare(this.horizontal, cornerRadii.horizontal) == 0 && Float.compare(this.vertical, cornerRadii.vertical) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.horizontal) * 31) + Float.hashCode(this.vertical);
    }

    public String toString() {
        return "CornerRadii(horizontal=" + this.horizontal + ", vertical=" + this.vertical + ")";
    }

    public CornerRadii(float f, float f2) {
        this.horizontal = f;
        this.vertical = f2;
    }

    public /* synthetic */ CornerRadii(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2);
    }

    public final float getHorizontal() {
        return this.horizontal;
    }

    public final float getVertical() {
        return this.vertical;
    }

    public final CornerRadii toPixelFromDIP() {
        return new CornerRadii(PixelUtil.toPixelFromDIP(this.horizontal), PixelUtil.toPixelFromDIP(this.vertical));
    }
}
