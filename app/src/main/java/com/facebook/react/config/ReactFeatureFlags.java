package com.facebook.react.config;

import kotlin.Deprecated;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Use com.facebook.react.internal.featureflags.ReactNativeFeatureFlags instead.")
public final class ReactFeatureFlags {
    public static final ReactFeatureFlags INSTANCE = new ReactFeatureFlags();
    public static boolean dispatchPointerEvents;

    private ReactFeatureFlags() {
    }
}
