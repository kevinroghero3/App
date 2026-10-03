package io.sentry.android.core;

import android.os.Handler;
import android.os.Looper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
final class MainLooperHandler {
    private final Handler handler;

    MainLooperHandler() {
        this(Looper.getMainLooper());
    }

    MainLooperHandler(@NotNull Looper looper) {
        this.handler = new Handler(looper);
    }

    public void post(@NotNull Runnable runnable) {
        this.handler.post(runnable);
    }

    public Thread getThread() {
        return this.handler.getLooper().getThread();
    }
}
