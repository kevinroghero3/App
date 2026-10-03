package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.collection.ScatterMapKt;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int CHROMA_NEUTRAL = 6;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;
    private static final int TONE_SURFACE_CONTAINER_DARK = 12;
    private static final int TONE_SURFACE_CONTAINER_HIGH_DARK = 17;
    private static final int TONE_SURFACE_CONTAINER_HIGH_LIGHT = 92;
    private static final int TONE_SURFACE_CONTAINER_LIGHT = 94;

    private MaterialColors() {
    }

    public static int getColor(@NonNull View view, @AttrRes int i) {
        return resolveColor(view.getContext(), MaterialAttributes.resolveTypedValueOrThrow(view, i));
    }

    public static int getColor(Context context, @AttrRes int i, String str) {
        return resolveColor(context, MaterialAttributes.resolveTypedValueOrThrow(context, i, str));
    }

    public static int getColor(@NonNull View view, @AttrRes int i, @ColorInt int i2) {
        return getColor(view.getContext(), i, i2);
    }

    public static int getColor(@NonNull Context context, @AttrRes int i, @ColorInt int i2) {
        Integer colorOrNull = getColorOrNull(context, i);
        return colorOrNull != null ? colorOrNull.intValue() : i2;
    }

    public static Integer getColorOrNull(@NonNull Context context, @AttrRes int i) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i);
        if (typedValueResolve != null) {
            return Integer.valueOf(resolveColor(context, typedValueResolve));
        }
        return null;
    }

    public static ColorStateList getColorStateList(@NonNull Context context, @AttrRes int i, @NonNull ColorStateList colorStateList) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i);
        ColorStateList colorStateListResolveColorStateList = typedValueResolve != null ? resolveColorStateList(context, typedValueResolve) : null;
        return colorStateListResolveColorStateList == null ? colorStateList : colorStateListResolveColorStateList;
    }

    public static ColorStateList getColorStateListOrNull(@NonNull Context context, @AttrRes int i) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i);
        if (typedValueResolve == null) {
            return null;
        }
        int i2 = typedValueResolve.resourceId;
        if (i2 != 0) {
            return ContextCompat.getColorStateList(context, i2);
        }
        int i3 = typedValueResolve.data;
        if (i3 != 0) {
            return ColorStateList.valueOf(i3);
        }
        return null;
    }

    private static int resolveColor(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i = typedValue.resourceId;
        if (i != 0) {
            return ContextCompat.getColor(context, i);
        }
        return typedValue.data;
    }

    private static ColorStateList resolveColorStateList(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i = typedValue.resourceId;
        if (i != 0) {
            return ContextCompat.getColorStateList(context, i);
        }
        return ColorStateList.valueOf(typedValue.data);
    }

    public static int layer(@NonNull View view, @AttrRes int i, @AttrRes int i2) {
        return layer(view, i, i2, 1.0f);
    }

    public static int layer(@NonNull View view, @AttrRes int i, @AttrRes int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return layer(getColor(view, i), getColor(view, i2), f);
    }

    public static int layer(@ColorInt int i, @ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return layer(i, ColorUtils.setAlphaComponent(i2, Math.round(Color.alpha(i2) * f)));
    }

    public static int layer(@ColorInt int i, @ColorInt int i2) {
        return ColorUtils.compositeColors(i2, i);
    }

    public static int compositeARGBWithAlpha(@ColorInt int i, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i2) {
        return ColorUtils.setAlphaComponent(i, (Color.alpha(i) * i2) / 255);
    }

    public static boolean isColorLight(@ColorInt int i) {
        return i != 0 && ColorUtils.calculateLuminance(i) > 0.5d;
    }

    public static int harmonizeWithPrimary(@NonNull Context context, @ColorInt int i) {
        return harmonize(i, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static int harmonize(@ColorInt int i, @ColorInt int i2) {
        return Blend.harmonize(i, i2);
    }

    public static ColorRoles getColorRoles(@NonNull Context context, @ColorInt int i) {
        return getColorRoles(i, isLightTheme(context));
    }

    public static ColorRoles getColorRoles(@ColorInt int i, boolean z) {
        if (z) {
            return new ColorRoles(getColorRole(i, 40), getColorRole(i, 100), getColorRole(i, 90), getColorRole(i, 10));
        }
        return new ColorRoles(getColorRole(i, 80), getColorRole(i, 20), getColorRole(i, 30), getColorRole(i, 90));
    }

    public static int getSurfaceContainerFromSeed(@NonNull Context context, @ColorInt int i) {
        return getColorRole(i, isLightTheme(context) ? TONE_SURFACE_CONTAINER_LIGHT : 12, 6);
    }

    public static int getSurfaceContainerHighFromSeed(@NonNull Context context, @ColorInt int i) {
        return getColorRole(i, isLightTheme(context) ? TONE_SURFACE_CONTAINER_HIGH_LIGHT : 17, 6);
    }

    static boolean isLightTheme(@NonNull Context context) {
        return MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true);
    }

    private static int getColorRole(@ColorInt int i, @IntRange(from = 0, to = 100) int i2) {
        Hct hctFromInt = Hct.fromInt(i);
        hctFromInt.setTone(i2);
        return hctFromInt.toInt();
    }

    private static int getColorRole(@ColorInt int i, @IntRange(from = 0, to = 100) int i2, int i3) {
        Hct hctFromInt = Hct.fromInt(getColorRole(i, i2));
        hctFromInt.setChroma(i3);
        return hctFromInt.toInt();
    }
}
