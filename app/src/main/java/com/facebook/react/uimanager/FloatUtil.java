package com.facebook.react.uimanager;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class FloatUtil {
    private static final float EPSILON = 1.0E-5f;
    public static final FloatUtil INSTANCE = new FloatUtil();

    private FloatUtil() {
    }

    @JvmStatic
    public static final boolean floatsEqual(float f, float f2) {
        return Float.isNaN(f) || Float.isNaN(f2) ? Float.isNaN(f) && Float.isNaN(f2) : Math.abs(f2 - f) < EPSILON;
    }

    @JvmStatic
    public static final boolean floatsEqual(@Nullable Float f, @Nullable Float f2) {
        if (f == null) {
            return f2 == null;
        }
        if (f2 == null) {
            return false;
        }
        return floatsEqual(f.floatValue(), f2.floatValue());
    }
}
