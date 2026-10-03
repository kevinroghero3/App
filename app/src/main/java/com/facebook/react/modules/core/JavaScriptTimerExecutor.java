package com.facebook.react.modules.core;

import com.facebook.react.bridge.WritableArray;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaScriptTimerExecutor {
    void callIdleCallbacks(double d);

    void callTimers(@NotNull WritableArray writableArray);

    void emitTimeDriftWarning(@NotNull String str);
}
