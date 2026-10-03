package io.sentry.android.replay;

import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class WindowsKt {
    public static final Window getPhoneWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        WindowSpy windowSpy = WindowSpy.INSTANCE;
        View rootView = view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return windowSpy.pullWindow(rootView);
    }
}
