package com.facebook.react.internal.featureflags;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public final class ReactNativeFeatureFlagsForTests {
    public static final ReactNativeFeatureFlagsForTests INSTANCE = new ReactNativeFeatureFlagsForTests();

    private ReactNativeFeatureFlagsForTests() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReactNativeFeatureFlagsAccessor setUp$lambda$0() {
        return new ReactNativeFeatureFlagsLocalAccessor();
    }

    public final void setUp() {
        ReactNativeFeatureFlags.INSTANCE.setAccessorProvider$ReactAndroid_release(new Function0() { // from class: com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsForTests$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReactNativeFeatureFlagsForTests.setUp$lambda$0();
            }
        });
    }
}
