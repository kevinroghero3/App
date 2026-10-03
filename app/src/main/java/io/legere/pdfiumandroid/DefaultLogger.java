package io.legere.pdfiumandroid;

import android.util.Log;
import io.sentry.android.core.SentryLogcatAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultLogger implements LoggerInterface {
    @Override // io.legere.pdfiumandroid.LoggerInterface
    public void d(@NotNull String tag, @Nullable String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (str != null) {
            Log.d(tag, str);
        }
    }

    @Override // io.legere.pdfiumandroid.LoggerInterface
    public void e(@NotNull String tag, @Nullable Throwable th, @Nullable String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SentryLogcatAdapter.e(tag, str, th);
    }
}
