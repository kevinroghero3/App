package com.facebook.react.views.view;

import android.view.View;
import com.facebook.yoga.YogaMeasureMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class MeasureUtil {
    public static final MeasureUtil INSTANCE = new MeasureUtil();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[YogaMeasureMode.values().length];
            try {
                iArr[YogaMeasureMode.EXACTLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[YogaMeasureMode.AT_MOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MeasureUtil() {
    }

    @JvmStatic
    public static final int getMeasureSpec(float f, @NotNull YogaMeasureMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            return View.MeasureSpec.makeMeasureSpec((int) f, 1073741824);
        }
        if (i == 2) {
            return View.MeasureSpec.makeMeasureSpec((int) f, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }
}
