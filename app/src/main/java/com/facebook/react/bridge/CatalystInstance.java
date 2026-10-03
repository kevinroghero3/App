package com.facebook.react.bridge;

import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.NativeMethodCallInvokerHolder;
import java.util.Collection;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "This class is deprecated, please to migrate to new architecture using [com.facebook.react.defaults.DefaultReactHost] instead.")
public interface CatalystInstance extends MemoryPressureListener, JSInstance, JSBundleLoaderDelegate {
    static /* synthetic */ void getJSCallInvokerHolder$annotations() {
    }

    void addBridgeIdleDebugListener(@NotNull NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener);

    void callFunction(@NotNull String str, @NotNull String str2, @Nullable NativeArray nativeArray);

    void destroy();

    void extendNativeModules(@NotNull NativeModuleRegistry nativeModuleRegistry);

    @Deprecated(message = "This method is deprecated, please to migrate to new architecture using [com.facebook.react.defaults.DefaultReactHost] instead.")
    UIManager getFabricUIManager();

    @Deprecated(message = "Use ReactContext.getJSCallInvokerHolder instead")
    CallInvokerHolder getJSCallInvokerHolder();

    <T extends JavaScriptModule> T getJSModule(@NotNull Class<T> cls);

    @Deprecated(message = "Use getRuntimeExecutor() instead.")
    JavaScriptContextHolder getJavaScriptContextHolder();

    NativeMethodCallInvokerHolder getNativeMethodCallInvokerHolder();

    <T extends NativeModule> T getNativeModule(@NotNull Class<T> cls);

    NativeModule getNativeModule(@NotNull String str);

    Collection<NativeModule> getNativeModules();

    ReactQueueConfiguration getReactQueueConfiguration();

    RuntimeExecutor getRuntimeExecutor();

    RuntimeScheduler getRuntimeScheduler();

    String getSourceURL();

    <T extends NativeModule> boolean hasNativeModule(@NotNull Class<T> cls);

    boolean hasRunJSBundle();

    @VisibleForTesting
    void initialize();

    @Override // com.facebook.react.bridge.JSInstance
    void invokeCallback(int i, @NotNull NativeArrayInterface nativeArrayInterface);

    boolean isDestroyed();

    void registerSegment(int i, @NotNull String str);

    void removeBridgeIdleDebugListener(@NotNull NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener);

    void runJSBundle();

    @Deprecated(message = "This method is deprecated, please to migrate to new architecture using [com.facebook.react.defaults.DefaultReactHost] instead.")
    void setFabricUIManager(@NotNull UIManager uIManager);

    @VisibleForTesting
    void setGlobalVariable(@NotNull String str, @NotNull String str2);

    @Deprecated(message = "This method is deprecated, please to migrate to new architecture using [com.facebook.react.defaults.DefaultReactHost] instead.")
    void setTurboModuleRegistry(@NotNull TurboModuleRegistry turboModuleRegistry);
}
