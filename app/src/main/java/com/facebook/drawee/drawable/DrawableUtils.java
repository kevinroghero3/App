package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class DrawableUtils {
    public static final DrawableUtils INSTANCE = new DrawableUtils();

    @JvmStatic
    public static final int getOpacityFromColor(int i) {
        int i2 = i >>> 24;
        if (i2 != 0) {
            return i2 != 255 ? -3 : -1;
        }
        return -2;
    }

    @JvmStatic
    public static final int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & ViewCompat.MEASURED_SIZE_MASK;
        }
        return ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24) | (16777215 & i);
    }

    private DrawableUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final Drawable cloneDrawable(@Nullable Drawable drawable) {
        Drawable drawableCloneDrawable;
        if (drawable == 0) {
            return null;
        }
        CloneableDrawable cloneableDrawable = drawable instanceof CloneableDrawable ? (CloneableDrawable) drawable : null;
        if (cloneableDrawable != null && (drawableCloneDrawable = cloneableDrawable.cloneDrawable()) != null) {
            return drawableCloneDrawable;
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            return constantState.newDrawable();
        }
        return null;
    }

    @JvmStatic
    public static final void copyProperties(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        if (drawable2 == null || drawable == null || drawable == drawable2) {
            return;
        }
        drawable.setBounds(drawable2.getBounds());
        drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
        drawable.setLevel(drawable2.getLevel());
        drawable.setVisible(drawable2.isVisible(), false);
        drawable.setState(drawable2.getState());
    }

    @JvmStatic
    public static final void setDrawableProperties(@Nullable Drawable drawable, @Nullable DrawableProperties drawableProperties) {
        if (drawable == null || drawableProperties == null) {
            return;
        }
        drawableProperties.applyTo(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void setCallbacks(@Nullable Drawable drawable, @Nullable Drawable.Callback callback, @Nullable TransformCallback transformCallback) {
        if (drawable == 0) {
            return;
        }
        drawable.setCallback(callback);
        TransformAwareDrawable transformAwareDrawable = drawable instanceof TransformAwareDrawable ? (TransformAwareDrawable) drawable : null;
        if (transformAwareDrawable != null) {
            transformAwareDrawable.setTransformCallback(transformCallback);
        }
    }
}
