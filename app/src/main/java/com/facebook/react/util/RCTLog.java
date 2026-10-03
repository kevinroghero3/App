package com.facebook.react.util;

import com.facebook.react.bridge.JavaScriptModule;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface RCTLog extends JavaScriptModule {
    void logIfNoNativeHook(@Nullable String str, @Nullable String str2);
}
