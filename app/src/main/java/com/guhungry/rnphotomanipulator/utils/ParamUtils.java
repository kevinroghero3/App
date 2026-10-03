package com.guhungry.rnphotomanipulator.utils;

import android.graphics.Color;
import android.graphics.PointF;
import com.facebook.react.bridge.ReadableMap;
import com.guhungry.photomanipulator.model.CGRect;
import com.guhungry.photomanipulator.model.CGSize;
import com.guhungry.photomanipulator.model.FlipMode;
import com.guhungry.photomanipulator.model.RotationMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ParamUtils {
    public static final ParamUtils INSTANCE = new ParamUtils();

    private ParamUtils() {
    }

    @JvmStatic
    public static final PointF toPointF(@Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            return toPointF(Integer.valueOf(readableMap.getInt("x")), Integer.valueOf(readableMap.getInt("y")));
        }
        return null;
    }

    @JvmStatic
    public static final PointF toPointF(@NotNull Number x, @NotNull Number y) {
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        return new PointF(x.floatValue(), y.floatValue());
    }

    @JvmStatic
    public static final Integer toColorInt(@Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            return Integer.valueOf(Color.argb(readableMap.getInt("a"), readableMap.getInt("r"), readableMap.getInt("g"), readableMap.getInt("b")));
        }
        return null;
    }

    @JvmStatic
    public static final CGRect toCGRect(@NotNull ReadableMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new CGRect(map.getInt("x"), map.getInt("y"), map.getInt("width"), map.getInt("height"), null, 16, null);
    }

    @JvmStatic
    public static final CGSize toCGSize(@Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            return new CGSize(readableMap.getInt("width"), readableMap.getInt("height"));
        }
        return null;
    }

    @JvmStatic
    public static final FlipMode toFlipMode(@NotNull String mode) {
        Object objM5472constructorimpl;
        Intrinsics.checkNotNullParameter(mode, "mode");
        try {
            Result.Companion companion = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(FlipMode.valueOf(mode));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
        FlipMode flipMode = FlipMode.None;
        if (Result.m5478isFailureimpl(objM5472constructorimpl)) {
            objM5472constructorimpl = flipMode;
        }
        return (FlipMode) objM5472constructorimpl;
    }

    @JvmStatic
    public static final RotationMode toRotationMode(@NotNull String mode) {
        Object objM5472constructorimpl;
        Intrinsics.checkNotNullParameter(mode, "mode");
        try {
            Result.Companion companion = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(RotationMode.valueOf(mode));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
        RotationMode rotationMode = RotationMode.None;
        if (Result.m5478isFailureimpl(objM5472constructorimpl)) {
            objM5472constructorimpl = rotationMode;
        }
        return (RotationMode) objM5472constructorimpl;
    }
}
