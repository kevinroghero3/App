package com.facebook.fresco.ui.common;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class DimensionsInfo {
    private final int decodedImageHeight;
    private final int decodedImageWidth;
    private final int encodedImageHeight;
    private final int encodedImageWidth;
    private final String scaleType;
    private final int viewportHeight;
    private final int viewportWidth;

    public static /* synthetic */ DimensionsInfo copy$default(DimensionsInfo dimensionsInfo, int i, int i2, int i3, int i4, int i5, int i6, String str, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = dimensionsInfo.viewportWidth;
        }
        if ((i7 & 2) != 0) {
            i2 = dimensionsInfo.viewportHeight;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = dimensionsInfo.encodedImageWidth;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = dimensionsInfo.encodedImageHeight;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = dimensionsInfo.decodedImageWidth;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = dimensionsInfo.decodedImageHeight;
        }
        int i12 = i6;
        if ((i7 & 64) != 0) {
            str = dimensionsInfo.scaleType;
        }
        return dimensionsInfo.copy(i, i8, i9, i10, i11, i12, str);
    }

    public final int component1() {
        return this.viewportWidth;
    }

    public final int component2() {
        return this.viewportHeight;
    }

    public final int component3() {
        return this.encodedImageWidth;
    }

    public final int component4() {
        return this.encodedImageHeight;
    }

    public final int component5() {
        return this.decodedImageWidth;
    }

    public final int component6() {
        return this.decodedImageHeight;
    }

    public final String component7() {
        return this.scaleType;
    }

    public final DimensionsInfo copy(int i, int i2, int i3, int i4, int i5, int i6, @NotNull String scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        return new DimensionsInfo(i, i2, i3, i4, i5, i6, scaleType);
    }

    public String toString() {
        return "DimensionsInfo(viewportWidth=" + this.viewportWidth + ", viewportHeight=" + this.viewportHeight + ", encodedImageWidth=" + this.encodedImageWidth + ", encodedImageHeight=" + this.encodedImageHeight + ", decodedImageWidth=" + this.decodedImageWidth + ", decodedImageHeight=" + this.decodedImageHeight + ", scaleType=" + this.scaleType + ")";
    }

    public DimensionsInfo(int i, int i2, int i3, int i4, int i5, int i6, @NotNull String scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.viewportWidth = i;
        this.viewportHeight = i2;
        this.encodedImageWidth = i3;
        this.encodedImageHeight = i4;
        this.decodedImageWidth = i5;
        this.decodedImageHeight = i6;
        this.scaleType = scaleType;
    }

    public final int getViewportWidth() {
        return this.viewportWidth;
    }

    public final int getViewportHeight() {
        return this.viewportHeight;
    }

    public final int getEncodedImageWidth() {
        return this.encodedImageWidth;
    }

    public final int getEncodedImageHeight() {
        return this.encodedImageHeight;
    }

    public final int getDecodedImageWidth() {
        return this.decodedImageWidth;
    }

    public final int getDecodedImageHeight() {
        return this.decodedImageHeight;
    }

    public final String getScaleType() {
        return this.scaleType;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(DimensionsInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.fresco.ui.common.DimensionsInfo");
        DimensionsInfo dimensionsInfo = (DimensionsInfo) obj;
        return this.viewportWidth == dimensionsInfo.viewportWidth && this.viewportHeight == dimensionsInfo.viewportHeight && this.encodedImageWidth == dimensionsInfo.encodedImageWidth && this.encodedImageHeight == dimensionsInfo.encodedImageHeight && this.decodedImageWidth == dimensionsInfo.decodedImageWidth && this.decodedImageHeight == dimensionsInfo.decodedImageHeight && Intrinsics.areEqual(this.scaleType, dimensionsInfo.scaleType);
    }

    public int hashCode() {
        int i = this.viewportWidth;
        int i2 = this.viewportHeight;
        int i3 = this.encodedImageWidth;
        int i4 = this.encodedImageHeight;
        return (((((((((((i * 31) + i2) * 31) + i3) * 31) + i4) * 31) + this.decodedImageWidth) * 31) + this.decodedImageHeight) * 31) + this.scaleType.hashCode();
    }
}
