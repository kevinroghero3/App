package com.facebook.react.views.view;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class WindowUtilKt {
    public static final void setStatusBarTranslucency(@NotNull Window window, boolean z) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        if (z) {
            window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.facebook.react.views.view.WindowUtilKt$$ExternalSyntheticLambda1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return WindowUtilKt.setStatusBarTranslucency$lambda$0(view, windowInsets);
                }
            });
        } else {
            window.getDecorView().setOnApplyWindowInsetsListener(null);
        }
        ViewCompat.requestApplyInsets(window.getDecorView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets setStatusBarTranslucency$lambda$0(View v, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsets windowInsetsOnApplyWindowInsets = v.onApplyWindowInsets(insets);
        return windowInsetsOnApplyWindowInsets.replaceSystemWindowInsets(windowInsetsOnApplyWindowInsets.getSystemWindowInsetLeft(), 0, windowInsetsOnApplyWindowInsets.getSystemWindowInsetRight(), windowInsetsOnApplyWindowInsets.getSystemWindowInsetBottom());
    }

    public static final void setStatusBarVisibility(@NotNull Window window, boolean z) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        if (z) {
            statusBarHide(window);
        } else {
            statusBarShow(window);
        }
    }

    private static final void statusBarHide(Window window) {
        if (Build.VERSION.SDK_INT >= 30) {
            window.getAttributes().layoutInDisplayCutoutMode = 1;
            window.setDecorFitsSystemWindows(false);
        }
        window.addFlags(1024);
        window.clearFlags(2048);
    }

    private static final void statusBarShow(Window window) {
        if (Build.VERSION.SDK_INT >= 30) {
            window.getAttributes().layoutInDisplayCutoutMode = 0;
            window.setDecorFitsSystemWindows(true);
        }
        window.addFlags(2048);
        window.clearFlags(1024);
    }

    public static final void setSystemBarsTranslucency(@NotNull Window window, boolean z) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        WindowCompat.setDecorFitsSystemWindows(window, !z);
        if (z) {
            int iArgb = 0;
            boolean z2 = (window.getContext().getResources().getConfiguration().uiMode & 48) == 32;
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                window.setStatusBarContrastEnforced(false);
                window.setNavigationBarContrastEnforced(true);
            }
            window.setStatusBarColor(0);
            if (i < 29) {
                if (i >= 27 && !z2) {
                    iArgb = Color.argb(230, 255, 255, 255);
                } else {
                    iArgb = Color.argb(128, 27, 27, 27);
                }
            }
            window.setNavigationBarColor(iArgb);
            new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightNavigationBars(!z2);
            if (i >= 28) {
                window.getAttributes().layoutInDisplayCutoutMode = i >= 30 ? 3 : 1;
            }
        }
    }
}
