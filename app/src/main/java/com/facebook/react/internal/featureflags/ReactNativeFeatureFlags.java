package com.facebook.react.internal.featureflags;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ReactNativeFeatureFlags {
    public static final ReactNativeFeatureFlags INSTANCE = new ReactNativeFeatureFlags();
    private static ReactNativeFeatureFlagsAccessor accessor;
    private static Function0<? extends ReactNativeFeatureFlagsAccessor> accessorProvider;

    private ReactNativeFeatureFlags() {
    }

    static {
        Function0<? extends ReactNativeFeatureFlagsAccessor> function0 = new Function0() { // from class: com.facebook.react.internal.featureflags.ReactNativeFeatureFlags$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReactNativeFeatureFlags.accessorProvider$lambda$0();
            }
        };
        accessorProvider = function0;
        accessor = function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReactNativeFeatureFlagsCxxAccessor accessorProvider$lambda$0() {
        return new ReactNativeFeatureFlagsCxxAccessor();
    }

    @JvmStatic
    public static final boolean commonTestFlag() {
        return accessor.commonTestFlag();
    }

    @JvmStatic
    public static final boolean completeReactInstanceCreationOnBgThreadOnAndroid() {
        return accessor.completeReactInstanceCreationOnBgThreadOnAndroid();
    }

    @JvmStatic
    public static final boolean disableEventLoopOnBridgeless() {
        return accessor.disableEventLoopOnBridgeless();
    }

    @JvmStatic
    public static final boolean disableMountItemReorderingAndroid() {
        return accessor.disableMountItemReorderingAndroid();
    }

    @JvmStatic
    public static final boolean enableAccumulatedUpdatesInRawPropsAndroid() {
        return accessor.enableAccumulatedUpdatesInRawPropsAndroid();
    }

    @JvmStatic
    public static final boolean enableBridgelessArchitecture() {
        return accessor.enableBridgelessArchitecture();
    }

    @JvmStatic
    public static final boolean enableCppPropsIteratorSetter() {
        return accessor.enableCppPropsIteratorSetter();
    }

    @JvmStatic
    public static final boolean enableDeletionOfUnmountedViews() {
        return accessor.enableDeletionOfUnmountedViews();
    }

    @JvmStatic
    public static final boolean enableEagerRootViewAttachment() {
        return accessor.enableEagerRootViewAttachment();
    }

    @JvmStatic
    public static final boolean enableEventEmitterRetentionDuringGesturesOnAndroid() {
        return accessor.enableEventEmitterRetentionDuringGesturesOnAndroid();
    }

    @JvmStatic
    public static final boolean enableFabricLogs() {
        return accessor.enableFabricLogs();
    }

    @JvmStatic
    public static final boolean enableFabricRenderer() {
        return accessor.enableFabricRenderer();
    }

    @JvmStatic
    public static final boolean enableFixForViewCommandRace() {
        return accessor.enableFixForViewCommandRace();
    }

    @JvmStatic
    public static final boolean enableGranularShadowTreeStateReconciliation() {
        return accessor.enableGranularShadowTreeStateReconciliation();
    }

    @JvmStatic
    public static final boolean enableIOSViewClipToPaddingBox() {
        return accessor.enableIOSViewClipToPaddingBox();
    }

    @JvmStatic
    public static final boolean enableImagePrefetchingAndroid() {
        return accessor.enableImagePrefetchingAndroid();
    }

    @JvmStatic
    public static final boolean enableLayoutAnimationsOnAndroid() {
        return accessor.enableLayoutAnimationsOnAndroid();
    }

    @JvmStatic
    public static final boolean enableLayoutAnimationsOnIOS() {
        return accessor.enableLayoutAnimationsOnIOS();
    }

    @JvmStatic
    public static final boolean enableLongTaskAPI() {
        return accessor.enableLongTaskAPI();
    }

    @JvmStatic
    public static final boolean enableNewBackgroundAndBorderDrawables() {
        return accessor.enableNewBackgroundAndBorderDrawables();
    }

    @JvmStatic
    public static final boolean enablePreciseSchedulingForPremountItemsOnAndroid() {
        return accessor.enablePreciseSchedulingForPremountItemsOnAndroid();
    }

    @JvmStatic
    public static final boolean enablePropsUpdateReconciliationAndroid() {
        return accessor.enablePropsUpdateReconciliationAndroid();
    }

    @JvmStatic
    public static final boolean enableReportEventPaintTime() {
        return accessor.enableReportEventPaintTime();
    }

    @JvmStatic
    public static final boolean enableSynchronousStateUpdates() {
        return accessor.enableSynchronousStateUpdates();
    }

    @JvmStatic
    public static final boolean enableUIConsistency() {
        return accessor.enableUIConsistency();
    }

    @JvmStatic
    public static final boolean enableViewRecycling() {
        return accessor.enableViewRecycling();
    }

    @JvmStatic
    public static final boolean excludeYogaFromRawProps() {
        return accessor.excludeYogaFromRawProps();
    }

    @JvmStatic
    public static final boolean fixDifferentiatorEmittingUpdatesWithWrongParentTag() {
        return accessor.fixDifferentiatorEmittingUpdatesWithWrongParentTag();
    }

    @JvmStatic
    public static final boolean fixMappingOfEventPrioritiesBetweenFabricAndReact() {
        return accessor.fixMappingOfEventPrioritiesBetweenFabricAndReact();
    }

    @JvmStatic
    public static final boolean fixMountingCoordinatorReportedPendingTransactionsOnAndroid() {
        return accessor.fixMountingCoordinatorReportedPendingTransactionsOnAndroid();
    }

    @JvmStatic
    public static final boolean fuseboxEnabledRelease() {
        return accessor.fuseboxEnabledRelease();
    }

    @JvmStatic
    public static final boolean initEagerTurboModulesOnNativeModulesQueueAndroid() {
        return accessor.initEagerTurboModulesOnNativeModulesQueueAndroid();
    }

    @JvmStatic
    public static final boolean lazyAnimationCallbacks() {
        return accessor.lazyAnimationCallbacks();
    }

    @JvmStatic
    public static final boolean loadVectorDrawablesOnImages() {
        return accessor.loadVectorDrawablesOnImages();
    }

    @JvmStatic
    public static final boolean traceTurboModulePromiseRejectionsOnAndroid() {
        return accessor.traceTurboModulePromiseRejectionsOnAndroid();
    }

    @JvmStatic
    public static final boolean useAlwaysAvailableJSErrorHandling() {
        return accessor.useAlwaysAvailableJSErrorHandling();
    }

    @JvmStatic
    public static final boolean useFabricInterop() {
        return accessor.useFabricInterop();
    }

    @JvmStatic
    public static final boolean useImmediateExecutorInAndroidBridgeless() {
        return accessor.useImmediateExecutorInAndroidBridgeless();
    }

    @JvmStatic
    public static final boolean useNativeViewConfigsInBridgelessMode() {
        return accessor.useNativeViewConfigsInBridgelessMode();
    }

    @JvmStatic
    public static final boolean useOptimisedViewPreallocationOnAndroid() {
        return accessor.useOptimisedViewPreallocationOnAndroid();
    }

    @JvmStatic
    public static final boolean useOptimizedEventBatchingOnAndroid() {
        return accessor.useOptimizedEventBatchingOnAndroid();
    }

    @JvmStatic
    public static final boolean useRawPropsJsiValue() {
        return accessor.useRawPropsJsiValue();
    }

    @JvmStatic
    public static final boolean useRuntimeShadowNodeReferenceUpdate() {
        return accessor.useRuntimeShadowNodeReferenceUpdate();
    }

    @JvmStatic
    public static final boolean useTurboModuleInterop() {
        return accessor.useTurboModuleInterop();
    }

    @JvmStatic
    public static final boolean useTurboModules() {
        return accessor.useTurboModules();
    }

    @JvmStatic
    public static final void override(@NotNull ReactNativeFeatureFlagsProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        accessor.override(provider);
    }

    @JvmStatic
    public static final void dangerouslyReset() {
        accessor.dangerouslyReset();
        accessor = accessorProvider.invoke();
    }

    @JvmStatic
    public static final String dangerouslyForceOverride(@NotNull ReactNativeFeatureFlagsProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        ReactNativeFeatureFlagsAccessor reactNativeFeatureFlagsAccessorInvoke = accessorProvider.invoke();
        String strDangerouslyForceOverride = reactNativeFeatureFlagsAccessorInvoke.dangerouslyForceOverride(provider);
        accessor = reactNativeFeatureFlagsAccessorInvoke;
        return strDangerouslyForceOverride;
    }

    public final void setAccessorProvider$ReactAndroid_release(@NotNull Function0<? extends ReactNativeFeatureFlagsAccessor> newAccessorProvider) {
        Intrinsics.checkNotNullParameter(newAccessorProvider, "newAccessorProvider");
        accessorProvider = newAccessorProvider;
        accessor = newAccessorProvider.invoke();
    }
}
