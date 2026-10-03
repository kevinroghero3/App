package com.facebook.fresco.vito.options;

import androidx.annotation.ColorInt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class BorderOptions {
    public static final Companion Companion = new Companion(null);
    public final int color;
    public final float padding;
    public final boolean scaleDownInsideBorders;
    public final float width;

    public static /* synthetic */ BorderOptions copy$default(BorderOptions borderOptions, int i, float f, float f2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = borderOptions.color;
        }
        if ((i2 & 2) != 0) {
            f = borderOptions.width;
        }
        if ((i2 & 4) != 0) {
            f2 = borderOptions.padding;
        }
        if ((i2 & 8) != 0) {
            z = borderOptions.scaleDownInsideBorders;
        }
        return borderOptions.copy(i, f, f2, z);
    }

    @JvmStatic
    public static final BorderOptions create(@ColorInt int i, float f) {
        return Companion.create(i, f);
    }

    @JvmStatic
    public static final BorderOptions create(@ColorInt int i, float f, float f2) {
        return Companion.create(i, f, f2);
    }

    @JvmStatic
    public static final BorderOptions create(@ColorInt int i, float f, float f2, boolean z) {
        return Companion.create(i, f, f2, z);
    }

    public final int component1() {
        return this.color;
    }

    public final float component2() {
        return this.width;
    }

    public final float component3() {
        return this.padding;
    }

    public final boolean component4() {
        return this.scaleDownInsideBorders;
    }

    public final BorderOptions copy(@ColorInt int i, float f, float f2, boolean z) {
        return new BorderOptions(i, f, f2, z);
    }

    public String toString() {
        return "BorderOptions(color=" + this.color + ", width=" + this.width + ", padding=" + this.padding + ", scaleDownInsideBorders=" + this.scaleDownInsideBorders + ")";
    }

    public BorderOptions(@ColorInt int i, float f, float f2, boolean z) {
        this.color = i;
        this.width = f;
        this.padding = f2;
        this.scaleDownInsideBorders = z;
    }

    public /* synthetic */ BorderOptions(int i, float f, float f2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, (i2 & 4) != 0 ? 0.0f : f2, (i2 & 8) != 0 ? false : z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(BorderOptions.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.fresco.vito.options.BorderOptions");
        BorderOptions borderOptions = (BorderOptions) obj;
        return this.color == borderOptions.color && this.width == borderOptions.width && this.padding == borderOptions.padding && this.scaleDownInsideBorders == borderOptions.scaleDownInsideBorders;
    }

    public int hashCode() {
        int i = this.color;
        return (((((i * 31) + Float.hashCode(this.width)) * 31) + Float.hashCode(this.padding)) * 31) + Boolean.hashCode(this.scaleDownInsideBorders);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final BorderOptions create(@ColorInt int i, float f) {
            return create$default(this, i, f, 0.0f, false, 12, null);
        }

        @JvmStatic
        public final BorderOptions create(@ColorInt int i, float f, float f2) {
            return create$default(this, i, f, f2, false, 8, null);
        }

        private Companion() {
        }

        public static /* synthetic */ BorderOptions create$default(Companion companion, int i, float f, float f2, boolean z, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                f2 = 0.0f;
            }
            if ((i2 & 8) != 0) {
                z = false;
            }
            return companion.create(i, f, f2, z);
        }

        @JvmStatic
        public final BorderOptions create(@ColorInt int i, float f, float f2, boolean z) {
            return new BorderOptions(i, f, f2, z);
        }
    }
}
