package com.facebook.react.fabric.interop;

import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Use UIManagerListener or View Commands instead of addUIBlock and prependUIBlock.")
@UnstableReactNativeAPI
public interface UIBlock {
    void execute(@NotNull UIBlockViewResolver uIBlockViewResolver);
}
