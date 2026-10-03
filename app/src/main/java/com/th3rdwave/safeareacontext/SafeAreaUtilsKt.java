package com.th3rdwave.safeareacontext;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SafeAreaUtilsKt {
    public static int MediaControllerCompatApi24TransportControls;
    public static int MediaSessionCompat;

    private static final EdgeInsets getRootWindowInsetsCompatR(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        Insets insets = rootWindowInsets.getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.displayCutout() | WindowInsets.Type.navigationBars() | WindowInsets.Type.captionBar());
        if (insets == null) {
            return null;
        }
        return new EdgeInsets(insets.top, insets.right, insets.bottom, insets.left);
    }

    private static final EdgeInsets getRootWindowInsetsCompatM(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        return new EdgeInsets(rootWindowInsets.getSystemWindowInsetTop(), rootWindowInsets.getSystemWindowInsetRight(), Math.min(rootWindowInsets.getSystemWindowInsetBottom(), rootWindowInsets.getStableInsetBottom()), rootWindowInsets.getSystemWindowInsetLeft());
    }

    private static final EdgeInsets getRootWindowInsetsCompatBase(View view) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return new EdgeInsets(rect.top, view.getWidth() - rect.right, view.getHeight() - rect.bottom, rect.left);
    }

    private static final EdgeInsets getRootWindowInsetsCompat(View view) {
        return Build.VERSION.SDK_INT >= 30 ? getRootWindowInsetsCompatR(view) : getRootWindowInsetsCompatM(view);
    }

    public static final EdgeInsets getSafeAreaInsets(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getHeight() == 0) {
            return null;
        }
        View rootView = view.getRootView();
        Intrinsics.checkNotNull(rootView);
        EdgeInsets rootWindowInsetsCompat = getRootWindowInsetsCompat(rootView);
        if (rootWindowInsetsCompat == null) {
            return null;
        }
        float width = rootView.getWidth();
        float height = rootView.getHeight();
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getGlobalVisibleRect(rect);
        return new EdgeInsets(Math.max(rootWindowInsetsCompat.getTop() - rect.top, 0.0f), Math.max(Math.min((rect.left + view.getWidth()) - width, 0.0f) + rootWindowInsetsCompat.getRight(), 0.0f), Math.max(Math.min((rect.top + view.getHeight()) - height, 0.0f) + rootWindowInsetsCompat.getBottom(), 0.0f), Math.max(rootWindowInsetsCompat.getLeft() - rect.left, 0.0f));
    }

    public static final Rect getFrame(@NotNull ViewGroup rootView, @NotNull View view) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getParent() == null) {
            return null;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getDrawingRect(rect);
        try {
            rootView.offsetDescendantRectToMyCoords(view, rect);
            return new Rect(rect.left, rect.top, view.getWidth(), view.getHeight());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int onServiceConnected() {
        int i = MediaControllerCompatApi24TransportControls;
        int i2 = i % 7074627;
        MediaControllerCompatApi24TransportControls = i + 1;
        if (i2 != 0) {
            return MediaSessionCompat;
        }
        int i3 = (int) Runtime.getRuntime().totalMemory();
        MediaSessionCompat = i3;
        return i3;
    }
}
