package com.facebook.react.internal.featureflags;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ReactNativeFeatureFlagsAccessor extends ReactNativeFeatureFlagsProvider {
    String dangerouslyForceOverride(@NotNull ReactNativeFeatureFlagsProvider reactNativeFeatureFlagsProvider);

    void dangerouslyReset();

    void override(@NotNull ReactNativeFeatureFlagsProvider reactNativeFeatureFlagsProvider);
}
