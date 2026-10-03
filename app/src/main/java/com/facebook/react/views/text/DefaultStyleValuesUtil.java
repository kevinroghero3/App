package com.facebook.react.views.text;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultStyleValuesUtil {
    public static final DefaultStyleValuesUtil INSTANCE = new DefaultStyleValuesUtil();

    private DefaultStyleValuesUtil() {
    }

    @JvmStatic
    public static final ColorStateList getDefaultTextColorHint(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getDefaultTextAttribute(context, R.attr.textColorHint);
    }

    @JvmStatic
    public static final ColorStateList getDefaultTextColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getDefaultTextAttribute(context, R.attr.textColor);
    }

    @JvmStatic
    public static final int getDefaultTextColorHighlight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList defaultTextAttribute = INSTANCE.getDefaultTextAttribute(context, R.attr.textColorHighlight);
        if (defaultTextAttribute != null) {
            return defaultTextAttribute.getDefaultColor();
        }
        return 0;
    }

    private final ColorStateList getDefaultTextAttribute(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        return typedArrayObtainStyledAttributes.getColorStateList(0);
    }
}
