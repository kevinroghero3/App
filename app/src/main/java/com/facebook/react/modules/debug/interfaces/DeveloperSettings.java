package com.facebook.react.modules.debug.interfaces;

import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface DeveloperSettings {
    @Deprecated(message = "Legacy sampling profiler is no longer supported - This field will be removed in React Native 0.77")
    static /* synthetic */ void isStartSamplingProfilerOnInit$annotations() {
    }

    void addMenuItem(@NotNull String str);

    PackagerConnectionSettings getPackagerConnectionSettings();

    boolean isAnimationFpsDebugEnabled();

    boolean isDeviceDebugEnabled();

    boolean isElementInspectorEnabled();

    boolean isFpsDebugEnabled();

    boolean isHotModuleReplacementEnabled();

    boolean isJSDevModeEnabled();

    boolean isJSMinifyEnabled();

    boolean isRemoteJSDebugEnabled();

    boolean isStartSamplingProfilerOnInit();

    void setAnimationFpsDebugEnabled(boolean z);

    void setDeviceDebugEnabled(boolean z);

    void setElementInspectorEnabled(boolean z);

    void setFpsDebugEnabled(boolean z);

    void setHotModuleReplacementEnabled(boolean z);

    void setJSDevModeEnabled(boolean z);

    void setJSMinifyEnabled(boolean z);

    void setRemoteJSDebugEnabled(boolean z);

    void setStartSamplingProfilerOnInit(boolean z);
}
