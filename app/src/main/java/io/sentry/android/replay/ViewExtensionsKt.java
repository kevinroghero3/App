package io.sentry.android.replay;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ViewExtensionsKt {
    public static final void sentryReplayMask(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.sentry_privacy, "mask");
    }

    public static final void sentryReplayUnmask(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.sentry_privacy, "unmask");
    }
}
