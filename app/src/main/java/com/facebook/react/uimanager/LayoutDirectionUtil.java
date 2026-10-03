package com.facebook.react.uimanager;

import com.facebook.yoga.YogaDirection;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutDirectionUtil {
    public static final LayoutDirectionUtil INSTANCE = new LayoutDirectionUtil();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[YogaDirection.values().length];
            try {
                iArr[YogaDirection.LTR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[YogaDirection.RTL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private LayoutDirectionUtil() {
    }

    @JvmStatic
    public static final int toAndroidFromYoga(@NotNull YogaDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        int i = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
        if (i != 1) {
            return i != 2 ? 2 : 1;
        }
        return 0;
    }

    @JvmStatic
    public static final YogaDirection toYogaFromAndroid(int i) {
        if (i == 0) {
            return YogaDirection.LTR;
        }
        if (i == 1) {
            return YogaDirection.RTL;
        }
        return YogaDirection.INHERIT;
    }
}
