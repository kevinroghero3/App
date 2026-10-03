package com.facebook.react.views.image;

import android.graphics.Shader;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.react.common.ReactConstants;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ImageResizeMode {
    public static final ImageResizeMode INSTANCE = new ImageResizeMode();
    private static final String RESIZE_MODE_CENTER = "center";
    private static final String RESIZE_MODE_CONTAIN = "contain";
    private static final String RESIZE_MODE_COVER = "cover";
    private static final String RESIZE_MODE_NONE = "none";
    private static final String RESIZE_MODE_REPEAT = "repeat";
    private static final String RESIZE_MODE_STRETCH = "stretch";

    private ImageResizeMode() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final ScalingUtils.ScaleType toScaleType(@Nullable String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals(RESIZE_MODE_STRETCH)) {
                        ScalingUtils.ScaleType FIT_XY = ScalingUtils.ScaleType.FIT_XY;
                        Intrinsics.checkNotNullExpressionValue(FIT_XY, "FIT_XY");
                        return FIT_XY;
                    }
                    break;
                case -1364013995:
                    if (str.equals(RESIZE_MODE_CENTER)) {
                        ScalingUtils.ScaleType CENTER_INSIDE = ScalingUtils.ScaleType.CENTER_INSIDE;
                        Intrinsics.checkNotNullExpressionValue(CENTER_INSIDE, "CENTER_INSIDE");
                        return CENTER_INSIDE;
                    }
                    break;
                case -934531685:
                    if (str.equals(RESIZE_MODE_REPEAT)) {
                        return ScaleTypeStartInside.Companion.getINSTANCE();
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        return ScaleTypeStartInside.Companion.getINSTANCE();
                    }
                    break;
                case 94852023:
                    if (str.equals(RESIZE_MODE_COVER)) {
                        ScalingUtils.ScaleType CENTER_CROP = ScalingUtils.ScaleType.CENTER_CROP;
                        Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
                        return CENTER_CROP;
                    }
                    break;
                case 951526612:
                    if (str.equals(RESIZE_MODE_CONTAIN)) {
                        ScalingUtils.ScaleType FIT_CENTER = ScalingUtils.ScaleType.FIT_CENTER;
                        Intrinsics.checkNotNullExpressionValue(FIT_CENTER, "FIT_CENTER");
                        return FIT_CENTER;
                    }
                    break;
            }
        }
        if (str != null) {
            FLog.w(ReactConstants.TAG, "Invalid resize mode: '" + str + "'");
        }
        return defaultValue();
    }

    @JvmStatic
    public static final Shader.TileMode toTileMode(@Nullable String str) {
        if (Intrinsics.areEqual(RESIZE_MODE_CONTAIN, str) || Intrinsics.areEqual(RESIZE_MODE_COVER, str) || Intrinsics.areEqual(RESIZE_MODE_STRETCH, str) || Intrinsics.areEqual(RESIZE_MODE_CENTER, str) || Intrinsics.areEqual("none", str)) {
            return Shader.TileMode.CLAMP;
        }
        if (Intrinsics.areEqual(RESIZE_MODE_REPEAT, str)) {
            return Shader.TileMode.REPEAT;
        }
        if (str != null) {
            FLog.w(ReactConstants.TAG, "Invalid resize mode: '" + str + "'");
        }
        return defaultTileMode();
    }

    @JvmStatic
    public static final ScalingUtils.ScaleType defaultValue() {
        ScalingUtils.ScaleType CENTER_CROP = ScalingUtils.ScaleType.CENTER_CROP;
        Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
        return CENTER_CROP;
    }

    @JvmStatic
    public static final Shader.TileMode defaultTileMode() {
        return Shader.TileMode.CLAMP;
    }
}
