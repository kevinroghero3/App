package com.facebook.react.defaults;

import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultNewArchitectureEntryPoint {
    public static final DefaultNewArchitectureEntryPoint INSTANCE = new DefaultNewArchitectureEntryPoint();
    private static boolean privateBridgelessEnabled;
    private static boolean privateConcurrentReactEnabled;
    private static boolean privateFabricEnabled;
    private static boolean privateTurboModulesEnabled;

    @JvmStatic
    public static /* synthetic */ void getBridgelessEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getConcurrentReactEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getFabricEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getTurboModulesEnabled$annotations() {
    }

    @JvmStatic
    public static final void load() {
        load$default(false, false, false, 7, null);
    }

    @JvmStatic
    public static final void load(boolean z) {
        load$default(z, false, false, 6, null);
    }

    @JvmStatic
    public static final void load(boolean z, boolean z2) {
        load$default(z, z2, false, 4, null);
    }

    private DefaultNewArchitectureEntryPoint() {
    }

    public static /* synthetic */ void load$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        load(z, z2, z3);
    }

    @JvmStatic
    public static final void load(boolean z, boolean z2, boolean z3) {
        Pair<Boolean, String> pairIsConfigurationValid = INSTANCE.isConfigurationValid(z, z2, z3);
        boolean zBooleanValue = pairIsConfigurationValid.component1().booleanValue();
        String strComponent2 = pairIsConfigurationValid.component2();
        if (!zBooleanValue) {
            throw new IllegalStateException(strComponent2.toString());
        }
        ReactNativeFeatureFlags.override(new ReactNativeNewArchitectureFeatureFlagsDefaults(z3, z2, z) { // from class: com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load.1
            final /* synthetic */ boolean $bridgelessEnabled;
            final /* synthetic */ boolean $fabricEnabled;
            final /* synthetic */ boolean $turboModulesEnabled;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(z3);
                this.$bridgelessEnabled = z3;
                this.$fabricEnabled = z2;
                this.$turboModulesEnabled = z;
            }

            @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
            public boolean useFabricInterop() {
                return this.$bridgelessEnabled || this.$fabricEnabled;
            }

            @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
            public boolean enableFabricRenderer() {
                return this.$bridgelessEnabled || this.$fabricEnabled;
            }

            @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
            public boolean enableEventEmitterRetentionDuringGesturesOnAndroid() {
                return this.$bridgelessEnabled || this.$fabricEnabled;
            }

            @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
            public boolean useTurboModules() {
                return this.$bridgelessEnabled || this.$turboModulesEnabled;
            }
        });
        privateFabricEnabled = z2;
        privateTurboModulesEnabled = z;
        privateConcurrentReactEnabled = z2;
        privateBridgelessEnabled = z3;
        DefaultSoLoader.Companion.maybeLoadSoLibrary();
    }

    public static final boolean getFabricEnabled() {
        return privateFabricEnabled;
    }

    public static final boolean getTurboModulesEnabled() {
        return privateTurboModulesEnabled;
    }

    public static final boolean getConcurrentReactEnabled() {
        return privateConcurrentReactEnabled;
    }

    public static final boolean getBridgelessEnabled() {
        return privateBridgelessEnabled;
    }

    @VisibleForTesting
    public final Pair<Boolean, String> isConfigurationValid(boolean z, boolean z2, boolean z3) {
        if (z2 && !z) {
            return TuplesKt.to(Boolean.FALSE, "fabricEnabled=true requires turboModulesEnabled=true (is now false) - Please update your DefaultNewArchitectureEntryPoint.load() parameters.");
        }
        if (z3 && (!z || !z2)) {
            return TuplesKt.to(Boolean.FALSE, "bridgelessEnabled=true requires (turboModulesEnabled=true AND fabricEnabled=true) - Please update your DefaultNewArchitectureEntryPoint.load() parameters.");
        }
        return TuplesKt.to(Boolean.TRUE, "");
    }
}
