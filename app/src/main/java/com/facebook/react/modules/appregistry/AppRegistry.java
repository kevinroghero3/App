package com.facebook.react.modules.appregistry;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface AppRegistry extends JavaScriptModule {
    void runApplication(@NotNull String str, @NotNull WritableMap writableMap);

    void startHeadlessTask(int i, @NotNull String str, @NotNull WritableMap writableMap);

    void unmountApplicationComponentAtRootTag(int i);
}
