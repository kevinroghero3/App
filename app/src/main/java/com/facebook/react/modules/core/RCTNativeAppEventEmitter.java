package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface RCTNativeAppEventEmitter extends JavaScriptModule {
    void emit(@NotNull String str, @Nullable Object obj);
}
