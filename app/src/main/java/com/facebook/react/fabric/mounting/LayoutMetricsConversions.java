package com.facebook.react.fabric.mounting;

import android.view.View;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.yoga.YogaMeasureMode;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public interface LayoutMetricsConversions {
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmStatic
    static float getMaxSize(int i) {
        return Companion.getMaxSize(i);
    }

    @JvmStatic
    static float getMinSize(int i) {
        return Companion.getMinSize(i);
    }

    @JvmStatic
    static YogaMeasureMode getYogaMeasureMode(float f, float f2) {
        return Companion.getYogaMeasureMode(f, f2);
    }

    @JvmStatic
    static float getYogaSize(float f, float f2) {
        return Companion.getYogaSize(f, f2);
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final float getMinSize(int i) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == 1073741824) {
                return size;
            }
            return 0.0f;
        }

        @JvmStatic
        public final float getMaxSize(int i) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == 0) {
                return Float.POSITIVE_INFINITY;
            }
            return size;
        }

        @JvmStatic
        public final float getYogaSize(float f, float f2) {
            if (f == f2) {
                return PixelUtil.INSTANCE.dpToPx(f2);
            }
            if (Float.isInfinite(f2)) {
                return Float.POSITIVE_INFINITY;
            }
            return PixelUtil.INSTANCE.dpToPx(f2);
        }

        @JvmStatic
        public final YogaMeasureMode getYogaMeasureMode(float f, float f2) {
            if (f == f2) {
                return YogaMeasureMode.EXACTLY;
            }
            if (Float.isInfinite(f2)) {
                return YogaMeasureMode.UNDEFINED;
            }
            return YogaMeasureMode.AT_MOST;
        }
    }
}
