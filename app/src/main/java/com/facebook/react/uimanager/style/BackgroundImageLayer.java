package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Shader;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class BackgroundImageLayer {
    private final Gradient gradient;

    public BackgroundImageLayer(@Nullable ReadableMap readableMap, @NotNull Context context) {
        Gradient gradient;
        Intrinsics.checkNotNullParameter(context, "context");
        if (readableMap != null) {
            try {
                gradient = new Gradient(readableMap, context);
            } catch (IllegalArgumentException unused) {
                gradient = null;
            }
        } else {
            gradient = null;
        }
        this.gradient = gradient;
    }

    public final Shader getShader(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Gradient gradient = this.gradient;
        if (gradient != null) {
            return gradient.getShader(bounds);
        }
        return null;
    }
}
