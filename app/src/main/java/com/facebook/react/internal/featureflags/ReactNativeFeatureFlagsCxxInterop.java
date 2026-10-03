package com.facebook.react.internal.featureflags;

import com.facebook.soloader.SoLoader;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactNativeFeatureFlagsCxxInterop {
    public static final ReactNativeFeatureFlagsCxxInterop INSTANCE = new ReactNativeFeatureFlagsCxxInterop();

    @JvmStatic
    public static final native boolean commonTestFlag();

    @JvmStatic
    public static final native boolean completeReactInstanceCreationOnBgThreadOnAndroid();

    @JvmStatic
    public static final native String dangerouslyForceOverride(@NotNull Object obj);

    @JvmStatic
    public static final native void dangerouslyReset();

    @JvmStatic
    public static final native boolean disableEventLoopOnBridgeless();

    @JvmStatic
    public static final native boolean disableMountItemReorderingAndroid();

    @JvmStatic
    public static final native boolean enableAccumulatedUpdatesInRawPropsAndroid();

    @JvmStatic
    public static final native boolean enableBridgelessArchitecture();

    @JvmStatic
    public static final native boolean enableCppPropsIteratorSetter();

    @JvmStatic
    public static final native boolean enableDeletionOfUnmountedViews();

    @JvmStatic
    public static final native boolean enableEagerRootViewAttachment();

    @JvmStatic
    public static final native boolean enableEventEmitterRetentionDuringGesturesOnAndroid();

    @JvmStatic
    public static final native boolean enableFabricLogs();

    @JvmStatic
    public static final native boolean enableFabricRenderer();

    @JvmStatic
    public static final native boolean enableFixForViewCommandRace();

    @JvmStatic
    public static final native boolean enableGranularShadowTreeStateReconciliation();

    @JvmStatic
    public static final native boolean enableIOSViewClipToPaddingBox();

    @JvmStatic
    public static final native boolean enableImagePrefetchingAndroid();

    @JvmStatic
    public static final native boolean enableLayoutAnimationsOnAndroid();

    @JvmStatic
    public static final native boolean enableLayoutAnimationsOnIOS();

    @JvmStatic
    public static final native boolean enableLongTaskAPI();

    @JvmStatic
    public static final native boolean enableNewBackgroundAndBorderDrawables();

    @JvmStatic
    public static final native boolean enablePreciseSchedulingForPremountItemsOnAndroid();

    @JvmStatic
    public static final native boolean enablePropsUpdateReconciliationAndroid();

    @JvmStatic
    public static final native boolean enableReportEventPaintTime();

    @JvmStatic
    public static final native boolean enableSynchronousStateUpdates();

    @JvmStatic
    public static final native boolean enableUIConsistency();

    @JvmStatic
    public static final native boolean enableViewRecycling();

    @JvmStatic
    public static final native boolean excludeYogaFromRawProps();

    @JvmStatic
    public static final native boolean fixDifferentiatorEmittingUpdatesWithWrongParentTag();

    @JvmStatic
    public static final native boolean fixMappingOfEventPrioritiesBetweenFabricAndReact();

    @JvmStatic
    public static final native boolean fixMountingCoordinatorReportedPendingTransactionsOnAndroid();

    @JvmStatic
    public static final native boolean fuseboxEnabledRelease();

    @JvmStatic
    public static final native boolean initEagerTurboModulesOnNativeModulesQueueAndroid();

    @JvmStatic
    public static final native boolean lazyAnimationCallbacks();

    @JvmStatic
    public static final native boolean loadVectorDrawablesOnImages();

    @JvmStatic
    public static final native void override(@NotNull Object obj);

    @JvmStatic
    public static final native boolean traceTurboModulePromiseRejectionsOnAndroid();

    @JvmStatic
    public static final native boolean useAlwaysAvailableJSErrorHandling();

    @JvmStatic
    public static final native boolean useFabricInterop();

    @JvmStatic
    public static final native boolean useImmediateExecutorInAndroidBridgeless();

    @JvmStatic
    public static final native boolean useNativeViewConfigsInBridgelessMode();

    @JvmStatic
    public static final native boolean useOptimisedViewPreallocationOnAndroid();

    @JvmStatic
    public static final native boolean useOptimizedEventBatchingOnAndroid();

    @JvmStatic
    public static final native boolean useRawPropsJsiValue();

    @JvmStatic
    public static final native boolean useRuntimeShadowNodeReferenceUpdate();

    @JvmStatic
    public static final native boolean useTurboModuleInterop();

    @JvmStatic
    public static final native boolean useTurboModules();

    private ReactNativeFeatureFlagsCxxInterop() {
    }

    static {
        SoLoader.loadLibrary("react_featureflagsjni");
    }
}
