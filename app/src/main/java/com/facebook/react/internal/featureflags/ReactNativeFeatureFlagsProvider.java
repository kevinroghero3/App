package com.facebook.react.internal.featureflags;

/* JADX INFO: loaded from: classes2.dex */
public interface ReactNativeFeatureFlagsProvider {
    boolean commonTestFlag();

    boolean completeReactInstanceCreationOnBgThreadOnAndroid();

    boolean disableEventLoopOnBridgeless();

    boolean disableMountItemReorderingAndroid();

    boolean enableAccumulatedUpdatesInRawPropsAndroid();

    boolean enableBridgelessArchitecture();

    boolean enableCppPropsIteratorSetter();

    boolean enableDeletionOfUnmountedViews();

    boolean enableEagerRootViewAttachment();

    boolean enableEventEmitterRetentionDuringGesturesOnAndroid();

    boolean enableFabricLogs();

    boolean enableFabricRenderer();

    boolean enableFixForViewCommandRace();

    boolean enableGranularShadowTreeStateReconciliation();

    boolean enableIOSViewClipToPaddingBox();

    boolean enableImagePrefetchingAndroid();

    boolean enableLayoutAnimationsOnAndroid();

    boolean enableLayoutAnimationsOnIOS();

    boolean enableLongTaskAPI();

    boolean enableNewBackgroundAndBorderDrawables();

    boolean enablePreciseSchedulingForPremountItemsOnAndroid();

    boolean enablePropsUpdateReconciliationAndroid();

    boolean enableReportEventPaintTime();

    boolean enableSynchronousStateUpdates();

    boolean enableUIConsistency();

    boolean enableViewRecycling();

    boolean excludeYogaFromRawProps();

    boolean fixDifferentiatorEmittingUpdatesWithWrongParentTag();

    boolean fixMappingOfEventPrioritiesBetweenFabricAndReact();

    boolean fixMountingCoordinatorReportedPendingTransactionsOnAndroid();

    boolean fuseboxEnabledRelease();

    boolean initEagerTurboModulesOnNativeModulesQueueAndroid();

    boolean lazyAnimationCallbacks();

    boolean loadVectorDrawablesOnImages();

    boolean traceTurboModulePromiseRejectionsOnAndroid();

    boolean useAlwaysAvailableJSErrorHandling();

    boolean useFabricInterop();

    boolean useImmediateExecutorInAndroidBridgeless();

    boolean useNativeViewConfigsInBridgelessMode();

    boolean useOptimisedViewPreallocationOnAndroid();

    boolean useOptimizedEventBatchingOnAndroid();

    boolean useRawPropsJsiValue();

    boolean useRuntimeShadowNodeReferenceUpdate();

    boolean useTurboModuleInterop();

    boolean useTurboModules();
}
