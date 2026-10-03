package com.facebook.imagepipeline.common;

import com.facebook.common.util.HashCodeUtil;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ResizeOptions {
    public static final Companion Companion = new Companion(null);
    public static final float DEFAULT_ROUNDUP_FRACTION = 0.6666667f;
    public final int height;
    public final float maxBitmapDimension;
    public final float roundUpFraction;
    public final int width;

    public ResizeOptions(int i, int i2) {
        this(i, i2, 0.0f, 0.0f, 12, null);
    }

    public ResizeOptions(int i, int i2, float f) {
        this(i, i2, f, 0.0f, 8, null);
    }

    @JvmStatic
    public static final ResizeOptions forDimensions(int i, int i2) {
        return Companion.forDimensions(i, i2);
    }

    @JvmStatic
    public static final ResizeOptions forSquareSize(int i) {
        return Companion.forSquareSize(i);
    }

    public ResizeOptions(int i, int i2, float f, float f2) {
        this.width = i;
        this.height = i2;
        this.maxBitmapDimension = f;
        this.roundUpFraction = f2;
        if (i <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (i2 <= 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public /* synthetic */ ResizeOptions(int i, int i2, float f, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? 2048.0f : f, (i3 & 8) != 0 ? 0.6666667f : f2);
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(this.width, this.height);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ResizeOptions) {
            ResizeOptions resizeOptions = (ResizeOptions) obj;
            if (this.width == resizeOptions.width && this.height == resizeOptions.height) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(null, "%dx%d", Arrays.copyOf(new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ResizeOptions forDimensions(int i, int i2) {
            if (i <= 0 || i2 <= 0) {
                return null;
            }
            return new ResizeOptions(i, i2, 0.0f, 0.0f, 12, null);
        }

        @JvmStatic
        public final ResizeOptions forSquareSize(int i) {
            if (i <= 0) {
                return null;
            }
            return new ResizeOptions(i, i, 0.0f, 0.0f, 12, null);
        }
    }
}
