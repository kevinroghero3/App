package com.facebook.react.bridge.interop;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class InteropModuleRegistry {
    private final Map<Class<?>, Object> supportedModules = new LinkedHashMap();

    public final <T extends JavaScriptModule> boolean shouldReturnInteropModule(@NotNull Class<T> requestedModule) {
        Intrinsics.checkNotNullParameter(requestedModule, "requestedModule");
        return checkReactFeatureFlagsConditions() && this.supportedModules.containsKey(requestedModule);
    }

    public final <T extends JavaScriptModule> T getInteropModule(@NotNull Class<T> requestedModule) {
        Intrinsics.checkNotNullParameter(requestedModule, "requestedModule");
        if (checkReactFeatureFlagsConditions()) {
            Object obj = this.supportedModules.get(requestedModule);
            if (obj instanceof JavaScriptModule) {
                return (T) obj;
            }
        }
        return null;
    }

    public final <T extends JavaScriptModule> void registerInteropModule(@NotNull Class<T> interopModuleInterface, @NotNull Object interopModule) {
        Intrinsics.checkNotNullParameter(interopModuleInterface, "interopModuleInterface");
        Intrinsics.checkNotNullParameter(interopModule, "interopModule");
        if (checkReactFeatureFlagsConditions()) {
            this.supportedModules.put(interopModuleInterface, interopModule);
        }
    }

    private final boolean checkReactFeatureFlagsConditions() {
        return ReactNativeFeatureFlags.enableFabricRenderer() && ReactNativeFeatureFlags.useFabricInterop();
    }
}
