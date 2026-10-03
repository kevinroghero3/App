package com.reactnativecommunity.webview;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface RNCWebViewMessagingModule extends JavaScriptModule {
    void onMessage(@NotNull WritableMap writableMap);

    void onShouldStartLoadWithRequest(@NotNull WritableMap writableMap);
}
