package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.CompositionSettings;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import androidx.tracing.Trace;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class LifecycleCameraProviderImpl implements LifecycleCameraProvider {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "LifecycleCameraProvider";
    private final Map<CameraUseCaseAdapter.CameraId, RestrictedCameraInfo> cameraInfoMap;
    private CameraX cameraX;
    private CameraXConfig.Provider cameraXConfigProvider;
    private ListenableFuture<Void> cameraXInitializeFuture;
    private ListenableFuture<Void> cameraXShutdownFuture;
    private Context context;
    private final LifecycleCameraRepository lifecycleCameraRepository;
    private final Object lock = new Object();

    public LifecycleCameraProviderImpl() {
        ListenableFuture<Void> listenableFutureImmediateFuture = Futures.immediateFuture(null);
        Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFuture, "immediateFuture<Void>(null)");
        this.cameraXShutdownFuture = listenableFutureImmediateFuture;
        LifecycleCameraRepository lifecycleCameraRepository = LifecycleCameraRepository.getInstance();
        Intrinsics.checkNotNullExpressionValue(lifecycleCameraRepository, "getInstance()");
        this.lifecycleCameraRepository = lifecycleCameraRepository;
        this.cameraInfoMap = new HashMap();
    }

    public static /* synthetic */ ListenableFuture initAsync$camera_lifecycle_release$default(LifecycleCameraProviderImpl lifecycleCameraProviderImpl, Context context, CameraXConfig cameraXConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            cameraXConfig = null;
        }
        return lifecycleCameraProviderImpl.initAsync$camera_lifecycle_release(context, cameraXConfig);
    }

    public final ListenableFuture<Void> initAsync$camera_lifecycle_release(@NotNull final Context context, @Nullable CameraXConfig cameraXConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (this.lock) {
            ListenableFuture<Void> listenableFuture = this.cameraXInitializeFuture;
            if (listenableFuture != null) {
                Intrinsics.checkNotNull(listenableFuture, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<java.lang.Void>");
                return listenableFuture;
            }
            if (cameraXConfig != null) {
                configure$camera_lifecycle_release(cameraXConfig);
            }
            final CameraX cameraX = new CameraX(context, this.cameraXConfigProvider);
            FutureChain futureChainFrom = FutureChain.from(this.cameraXShutdownFuture);
            final Function1<Void, ListenableFuture<Void>> function1 = new Function1<Void, ListenableFuture<Void>>() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$initAsync$1$initFuture$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ListenableFuture<Void> invoke(Void r1) {
                    return cameraX.getInitializeFuture();
                }
            };
            FutureChain futureChainTransformAsync = futureChainFrom.transformAsync(new AsyncFunction() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$$ExternalSyntheticLambda1
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return LifecycleCameraProviderImpl.initAsync$lambda$2$lambda$1(function1, obj);
                }
            }, CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(futureChainTransformAsync, "cameraX = CameraX(contex…ecutors.directExecutor())");
            this.cameraXInitializeFuture = futureChainTransformAsync;
            Futures.addCallback(futureChainTransformAsync, new FutureCallback<Void>() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$initAsync$1$2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Void r2) {
                    this.this$0.cameraX = cameraX;
                    this.this$0.context = ContextUtil.getApplicationContext(context);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable t) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    this.this$0.shutdownAsync$camera_lifecycle_release();
                }
            }, CameraXExecutors.directExecutor());
            ListenableFuture<Void> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(futureChainTransformAsync);
            Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(initFuture)");
            return listenableFutureNonCancellationPropagating;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ListenableFuture initAsync$lambda$2$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (ListenableFuture) tmp0.invoke(obj);
    }

    public final ListenableFuture<Void> shutdownAsync$camera_lifecycle_release() {
        ListenableFuture<Void> listenableFutureImmediateFuture;
        Threads.runOnMainSync(new Runnable() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LifecycleCameraProviderImpl.shutdownAsync$lambda$5(this.f$0);
            }
        });
        CameraX cameraX = this.cameraX;
        if (cameraX != null) {
            Intrinsics.checkNotNull(cameraX);
            cameraX.getCameraFactory().getCameraCoordinator().shutdown();
        }
        CameraX cameraX2 = this.cameraX;
        if (cameraX2 != null) {
            Intrinsics.checkNotNull(cameraX2);
            listenableFutureImmediateFuture = cameraX2.shutdown();
        } else {
            listenableFutureImmediateFuture = Futures.immediateFuture(null);
        }
        Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFuture, "if (cameraX != null) cam…mediateFuture<Void>(null)");
        synchronized (this.lock) {
            this.cameraXConfigProvider = null;
            this.cameraXInitializeFuture = null;
            this.cameraXShutdownFuture = listenableFutureImmediateFuture;
            this.cameraInfoMap.clear();
            Unit unit = Unit.INSTANCE;
        }
        this.cameraX = null;
        this.context = null;
        return listenableFutureImmediateFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shutdownAsync$lambda$5(LifecycleCameraProviderImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.unbindAll();
        this$0.lifecycleCameraRepository.clear();
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(@NotNull UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        for (LifecycleCamera lifecycleCamera : this.lifecycleCameraRepository.getLifecycleCameras()) {
            Intrinsics.checkNotNullExpressionValue(lifecycleCamera, "lifecycleCameraRepository.lifecycleCameras");
            if (lifecycleCamera.isBound(useCase)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean isConcurrentCameraModeOn() {
        return getCameraOperatingMode() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, CameraSelector cameraSelector2, CompositionSettings compositionSettings, CompositionSettings compositionSettings2, ViewPort viewPort, List<? extends CameraEffect> list, UseCase... useCaseArr) {
        CameraInternal cameraInternal;
        RestrictedCameraInfo restrictedCameraInfo;
        Trace.beginSection("CX:bindToLifecycle-internal");
        try {
            Threads.checkMainThread();
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            CameraInternal cameraInternalSelect = cameraSelector.select(cameraX.getCameraRepository().getCameras());
            Intrinsics.checkNotNullExpressionValue(cameraInternalSelect, "primaryCameraSelector.se…cameraRepository.cameras)");
            cameraInternalSelect.setPrimary(true);
            CameraInfo cameraInfo = getCameraInfo(cameraSelector);
            Intrinsics.checkNotNull(cameraInfo, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");
            RestrictedCameraInfo restrictedCameraInfo2 = (RestrictedCameraInfo) cameraInfo;
            if (cameraSelector2 != null) {
                CameraX cameraX2 = this.cameraX;
                Intrinsics.checkNotNull(cameraX2);
                CameraInternal cameraInternalSelect2 = cameraSelector2.select(cameraX2.getCameraRepository().getCameras());
                cameraInternalSelect2.setPrimary(false);
                CameraInfo cameraInfo2 = getCameraInfo(cameraSelector2);
                Intrinsics.checkNotNull(cameraInfo2, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");
                cameraInternal = cameraInternalSelect2;
                restrictedCameraInfo = (RestrictedCameraInfo) cameraInfo2;
            } else {
                cameraInternal = null;
                restrictedCameraInfo = null;
            }
            LifecycleCamera lifecycleCamera = this.lifecycleCameraRepository.getLifecycleCamera(lifecycleOwner, CameraUseCaseAdapter.generateCameraId(restrictedCameraInfo2, restrictedCameraInfo));
            Collection<LifecycleCamera> lifecycleCameras = this.lifecycleCameraRepository.getLifecycleCameras();
            for (UseCase useCase : ArraysKt___ArraysKt.filterNotNull(useCaseArr)) {
                for (LifecycleCamera lifecycleCameras2 : lifecycleCameras) {
                    Intrinsics.checkNotNullExpressionValue(lifecycleCameras2, "lifecycleCameras");
                    LifecycleCamera lifecycleCamera2 = lifecycleCameras2;
                    if (lifecycleCamera2.isBound(useCase) && !Intrinsics.areEqual(lifecycleCamera2, lifecycleCamera)) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str = String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{useCase}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        throw new IllegalStateException(str);
                    }
                }
            }
            if (lifecycleCamera == null) {
                LifecycleCameraRepository lifecycleCameraRepository = this.lifecycleCameraRepository;
                CameraX cameraX3 = this.cameraX;
                Intrinsics.checkNotNull(cameraX3);
                CameraCoordinator cameraCoordinator = cameraX3.getCameraFactory().getCameraCoordinator();
                CameraX cameraX4 = this.cameraX;
                Intrinsics.checkNotNull(cameraX4);
                CameraDeviceSurfaceManager cameraDeviceSurfaceManager = cameraX4.getCameraDeviceSurfaceManager();
                CameraX cameraX5 = this.cameraX;
                Intrinsics.checkNotNull(cameraX5);
                lifecycleCamera = lifecycleCameraRepository.createLifecycleCamera(lifecycleOwner, new CameraUseCaseAdapter(cameraInternalSelect, cameraInternal, restrictedCameraInfo2, restrictedCameraInfo, compositionSettings, compositionSettings2, cameraCoordinator, cameraDeviceSurfaceManager, cameraX5.getDefaultConfigFactory()));
            }
            if (useCaseArr.length != 0) {
                LifecycleCameraRepository lifecycleCameraRepository2 = this.lifecycleCameraRepository;
                Intrinsics.checkNotNull(lifecycleCamera);
                List listListOf = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(useCaseArr, useCaseArr.length));
                CameraX cameraX6 = this.cameraX;
                Intrinsics.checkNotNull(cameraX6);
                lifecycleCameraRepository2.bindToLifecycleCamera(lifecycleCamera, viewPort, list, listListOf, cameraX6.getCameraFactory().getCameraCoordinator());
            } else {
                Intrinsics.checkNotNull(lifecycleCamera);
            }
            Trace.endSection();
            return lifecycleCamera;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVideoCapture(UseCase useCase) {
        return useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE) && useCase.getCurrentConfig().getCaptureType() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPreview(UseCase useCase) {
        return useCase instanceof Preview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraConfig getCameraConfig(CameraSelector cameraSelector, CameraInfo cameraInfo) {
        CameraConfig cameraConfig = null;
        for (CameraFilter cameraFilter : cameraSelector.getCameraFilterSet()) {
            Intrinsics.checkNotNullExpressionValue(cameraFilter, "cameraSelector.cameraFilterSet");
            CameraFilter cameraFilter2 = cameraFilter;
            if (!Intrinsics.areEqual(cameraFilter2.getIdentifier(), CameraFilter.DEFAULT_ID)) {
                CameraConfigProvider configProvider = ExtendedCameraConfigProviderStore.getConfigProvider(cameraFilter2.getIdentifier());
                Context context = this.context;
                Intrinsics.checkNotNull(context);
                CameraConfig config = configProvider.getConfig(cameraInfo, context);
                if (config == null) {
                    continue;
                } else {
                    if (cameraConfig != null) {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                    cameraConfig = config;
                }
            }
        }
        return cameraConfig == null ? CameraConfigs.defaultConfig() : cameraConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCameraOperatingMode() {
        CameraX cameraX = this.cameraX;
        if (cameraX == null) {
            return 0;
        }
        Intrinsics.checkNotNull(cameraX);
        return cameraX.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCameraOperatingMode(int i) {
        CameraX cameraX = this.cameraX;
        if (cameraX == null) {
            return;
        }
        Intrinsics.checkNotNull(cameraX);
        cameraX.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<CameraInfo> getActiveConcurrentCameraInfos() {
        CameraX cameraX = this.cameraX;
        if (cameraX == null) {
            return new ArrayList();
        }
        Intrinsics.checkNotNull(cameraX);
        List<CameraInfo> activeConcurrentCameraInfos = cameraX.getCameraFactory().getCameraCoordinator().getActiveConcurrentCameraInfos();
        Intrinsics.checkNotNullExpressionValue(activeConcurrentCameraInfos, "cameraX!!.cameraFactory.…tiveConcurrentCameraInfos");
        return activeConcurrentCameraInfos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setActiveConcurrentCameraInfos(List<? extends CameraInfo> list) {
        CameraX cameraX = this.cameraX;
        if (cameraX == null) {
            return;
        }
        Intrinsics.checkNotNull(cameraX);
        cameraX.getCameraFactory().getCameraCoordinator().setActiveConcurrentCameraInfos(list);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void configure$camera_lifecycle_release(@NotNull final CameraXConfig cameraXConfig) {
        Intrinsics.checkNotNullParameter(cameraXConfig, "cameraXConfig");
        Trace.beginSection("CX:configureInstanceInternal");
        try {
            synchronized (this.lock) {
                Preconditions.checkNotNull(cameraXConfig);
                Preconditions.checkState(this.cameraXConfigProvider == null, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
                this.cameraXConfigProvider = new CameraXConfig.Provider() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$configure$1$1$1
                    @Override // androidx.camera.core.CameraXConfig.Provider
                    public final CameraXConfig getCameraXConfig() {
                        return cameraXConfig;
                    }
                };
                Unit unit = Unit.INSTANCE;
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbind(@NotNull UseCase... useCases) {
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        Trace.beginSection("CX:unbind");
        try {
            Threads.checkMainThread();
            if (getCameraOperatingMode() != 2) {
                this.lifecycleCameraRepository.unbind(CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(useCases, useCases.length)));
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return;
            }
            throw new UnsupportedOperationException("Unbind usecase is not supported in concurrent camera mode, call unbindAll() first.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbindAll() {
        Trace.beginSection("CX:unbindAll");
        try {
            Threads.checkMainThread();
            setCameraOperatingMode(0);
            this.lifecycleCameraRepository.unbindAll();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean hasCamera(@NotNull CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        boolean z;
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Trace.beginSection("CX:hasCamera");
        try {
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            cameraSelector.select(cameraX.getCameraRepository().getCameras());
            z = true;
        } catch (IllegalArgumentException unused) {
            z = false;
        } finally {
            Trace.endSection();
        }
        return z;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public Camera bindToLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull CameraSelector cameraSelector, @NotNull UseCase... useCases) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        Trace.beginSection("CX:bindToLifecycle");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                CompositionSettings DEFAULT = CompositionSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                Camera cameraBindToLifecycle = bindToLifecycle(lifecycleOwner, cameraSelector, null, DEFAULT, DEFAULT, null, CollectionsKt__CollectionsKt.emptyList(), (UseCase[]) Arrays.copyOf(useCases, useCases.length));
                Trace.endSection();
                return cameraBindToLifecycle;
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public Camera bindToLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull CameraSelector cameraSelector, @NotNull UseCaseGroup useCaseGroup) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCaseGroup, "useCaseGroup");
        Trace.beginSection("CX:bindToLifecycle-UseCaseGroup");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                CompositionSettings DEFAULT = CompositionSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                ViewPort viewPort = useCaseGroup.getViewPort();
                List<CameraEffect> effects = useCaseGroup.getEffects();
                Intrinsics.checkNotNullExpressionValue(effects, "useCaseGroup.effects");
                List<UseCase> useCases = useCaseGroup.getUseCases();
                Intrinsics.checkNotNullExpressionValue(useCases, "useCaseGroup.useCases");
                UseCase[] useCaseArr = (UseCase[]) useCases.toArray(new UseCase[0]);
                Camera cameraBindToLifecycle = bindToLifecycle(lifecycleOwner, cameraSelector, null, DEFAULT, DEFAULT, viewPort, effects, (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length));
                Trace.endSection();
                return cameraBindToLifecycle;
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x01fb A[Catch: all -> 0x030c, TryCatch #1 {all -> 0x030c, blocks: (B:3:0x000f, B:5:0x0016, B:7:0x001c, B:10:0x0057, B:12:0x005d, B:14:0x006b, B:16:0x0081, B:18:0x0097, B:19:0x00c1, B:21:0x00c7, B:22:0x00dc, B:24:0x00e2, B:26:0x00f7, B:27:0x00fb, B:28:0x010c, B:65:0x02dd, B:29:0x0136, B:30:0x013d, B:31:0x013e, B:32:0x0143, B:33:0x0144, B:35:0x0157, B:37:0x015d, B:38:0x0162, B:39:0x017a, B:41:0x018c, B:44:0x0197, B:45:0x019e, B:46:0x019f, B:48:0x01b8, B:50:0x01c6, B:53:0x01f2, B:59:0x020a, B:64:0x02da, B:55:0x01fb, B:57:0x0201, B:60:0x026f, B:61:0x0273, B:63:0x0279, B:68:0x02e6, B:69:0x02ed, B:70:0x02ee, B:71:0x02f3, B:72:0x02f4, B:73:0x02fb, B:74:0x02fc, B:75:0x0303, B:76:0x0304, B:77:0x030b), top: B:83:0x000f, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0201 A[Catch: all -> 0x030c, TryCatch #1 {all -> 0x030c, blocks: (B:3:0x000f, B:5:0x0016, B:7:0x001c, B:10:0x0057, B:12:0x005d, B:14:0x006b, B:16:0x0081, B:18:0x0097, B:19:0x00c1, B:21:0x00c7, B:22:0x00dc, B:24:0x00e2, B:26:0x00f7, B:27:0x00fb, B:28:0x010c, B:65:0x02dd, B:29:0x0136, B:30:0x013d, B:31:0x013e, B:32:0x0143, B:33:0x0144, B:35:0x0157, B:37:0x015d, B:38:0x0162, B:39:0x017a, B:41:0x018c, B:44:0x0197, B:45:0x019e, B:46:0x019f, B:48:0x01b8, B:50:0x01c6, B:53:0x01f2, B:59:0x020a, B:64:0x02da, B:55:0x01fb, B:57:0x0201, B:60:0x026f, B:61:0x0273, B:63:0x0279, B:68:0x02e6, B:69:0x02ed, B:70:0x02ee, B:71:0x02f3, B:72:0x02f4, B:73:0x02fb, B:74:0x02fc, B:75:0x0303, B:76:0x0304, B:77:0x030b), top: B:83:0x000f, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0279 A[Catch: all -> 0x030c, LOOP:2: B:61:0x0273->B:63:0x0279, LOOP_END, TryCatch #1 {all -> 0x030c, blocks: (B:3:0x000f, B:5:0x0016, B:7:0x001c, B:10:0x0057, B:12:0x005d, B:14:0x006b, B:16:0x0081, B:18:0x0097, B:19:0x00c1, B:21:0x00c7, B:22:0x00dc, B:24:0x00e2, B:26:0x00f7, B:27:0x00fb, B:28:0x010c, B:65:0x02dd, B:29:0x0136, B:30:0x013d, B:31:0x013e, B:32:0x0143, B:33:0x0144, B:35:0x0157, B:37:0x015d, B:38:0x0162, B:39:0x017a, B:41:0x018c, B:44:0x0197, B:45:0x019e, B:46:0x019f, B:48:0x01b8, B:50:0x01c6, B:53:0x01f2, B:59:0x020a, B:64:0x02da, B:55:0x01fb, B:57:0x0201, B:60:0x026f, B:61:0x0273, B:63:0x0279, B:68:0x02e6, B:69:0x02ed, B:70:0x02ee, B:71:0x02f3, B:72:0x02f4, B:73:0x02fb, B:74:0x02fc, B:75:0x0303, B:76:0x0304, B:77:0x030b), top: B:83:0x000f, inners: #0 }] */
    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public ConcurrentCamera bindToLifecycle(@NotNull List<ConcurrentCamera.SingleCameraConfig> singleCameraConfigs) {
        Intrinsics.checkNotNullParameter(singleCameraConfigs, "singleCameraConfigs");
        Trace.beginSection("CX:bindToLifecycle-Concurrent");
        try {
            if (singleCameraConfigs.size() < 2) {
                throw new IllegalArgumentException("Concurrent camera needs two camera configs.");
            }
            if (singleCameraConfigs.size() > 2) {
                throw new IllegalArgumentException("Concurrent camera is only supporting two cameras at maximum.");
            }
            ConcurrentCamera.SingleCameraConfig singleCameraConfig = singleCameraConfigs.get(0);
            Intrinsics.checkNotNull(singleCameraConfig);
            ConcurrentCamera.SingleCameraConfig singleCameraConfig2 = singleCameraConfig;
            ConcurrentCamera.SingleCameraConfig singleCameraConfig3 = singleCameraConfigs.get(1);
            Intrinsics.checkNotNull(singleCameraConfig3);
            ConcurrentCamera.SingleCameraConfig singleCameraConfig4 = singleCameraConfig3;
            ArrayList arrayList = new ArrayList();
            if (Intrinsics.areEqual(singleCameraConfig2.getCameraSelector().getLensFacing(), singleCameraConfig4.getCameraSelector().getLensFacing())) {
                if (getCameraOperatingMode() == 2) {
                    throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");
                }
                if (!Intrinsics.areEqual(singleCameraConfig2.getLifecycleOwner(), singleCameraConfig4.getLifecycleOwner()) || !Intrinsics.areEqual(singleCameraConfig2.getUseCaseGroup().getViewPort(), singleCameraConfig4.getUseCaseGroup().getViewPort()) || !Intrinsics.areEqual(singleCameraConfig2.getUseCaseGroup().getEffects(), singleCameraConfig4.getUseCaseGroup().getEffects())) {
                    throw new IllegalArgumentException("Two camera configs need to have the same lifecycle owner, view port and effects.");
                }
                LifecycleOwner lifecycleOwner = singleCameraConfig2.getLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "firstCameraConfig.lifecycleOwner");
                CameraSelector cameraSelector = singleCameraConfig2.getCameraSelector();
                Intrinsics.checkNotNullExpressionValue(cameraSelector, "firstCameraConfig.cameraSelector");
                ViewPort viewPort = singleCameraConfig2.getUseCaseGroup().getViewPort();
                List<CameraEffect> effects = singleCameraConfig2.getUseCaseGroup().getEffects();
                Intrinsics.checkNotNullExpressionValue(effects, "firstCameraConfig.useCaseGroup.effects");
                ArrayList arrayList2 = new ArrayList();
                for (ConcurrentCamera.SingleCameraConfig singleCameraConfig5 : singleCameraConfigs) {
                    Intrinsics.checkNotNull(singleCameraConfig5);
                    for (UseCase useCase : singleCameraConfig5.getUseCaseGroup().getUseCases()) {
                        Intrinsics.checkNotNullExpressionValue(useCase, "config!!.useCaseGroup.useCases");
                        UseCase useCase2 = useCase;
                        String physicalCameraId = singleCameraConfig5.getCameraSelector().getPhysicalCameraId();
                        if (physicalCameraId != null) {
                            useCase2.setPhysicalCameraId(physicalCameraId);
                        }
                    }
                    List<UseCase> useCases = singleCameraConfig5.getUseCaseGroup().getUseCases();
                    Intrinsics.checkNotNullExpressionValue(useCases, "config.useCaseGroup.useCases");
                    arrayList2.addAll(useCases);
                }
                setCameraOperatingMode(1);
                CompositionSettings DEFAULT = CompositionSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                UseCase[] useCaseArr = (UseCase[]) arrayList2.toArray(new UseCase[0]);
                arrayList.add(bindToLifecycle(lifecycleOwner, cameraSelector, null, DEFAULT, DEFAULT, viewPort, effects, (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length)));
            } else {
                Context context = this.context;
                Intrinsics.checkNotNull(context);
                if (context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent")) {
                    if (getCameraOperatingMode() == 1) {
                        throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");
                    }
                    ArrayList arrayList3 = new ArrayList();
                    try {
                        CameraSelector cameraSelector2 = singleCameraConfig2.getCameraSelector();
                        Intrinsics.checkNotNullExpressionValue(cameraSelector2, "firstCameraConfig.cameraSelector");
                        CameraInfo cameraInfo = getCameraInfo(cameraSelector2);
                        CameraSelector cameraSelector3 = singleCameraConfig4.getCameraSelector();
                        Intrinsics.checkNotNullExpressionValue(cameraSelector3, "secondCameraConfig.cameraSelector");
                        CameraInfo cameraInfo2 = getCameraInfo(cameraSelector3);
                        arrayList3.add(cameraInfo);
                        arrayList3.add(cameraInfo2);
                        if (!getActiveConcurrentCameraInfos().isEmpty() && !Intrinsics.areEqual(arrayList3, getActiveConcurrentCameraInfos())) {
                            throw new UnsupportedOperationException("Cameras are already running, call unbindAll() before binding more cameras.");
                        }
                        setCameraOperatingMode(2);
                        if (Objects.equals(singleCameraConfig2.getUseCaseGroup().getUseCases(), singleCameraConfig4.getUseCaseGroup().getUseCases()) && singleCameraConfig2.getUseCaseGroup().getUseCases().size() == 2) {
                            UseCase useCase0 = singleCameraConfig2.getUseCaseGroup().getUseCases().get(0);
                            UseCase useCase1 = singleCameraConfig2.getUseCaseGroup().getUseCases().get(1);
                            Intrinsics.checkNotNullExpressionValue(useCase0, "useCase0");
                            if (isVideoCapture(useCase0)) {
                                Intrinsics.checkNotNullExpressionValue(useCase1, "useCase1");
                                if (!isPreview(useCase1)) {
                                    if (isPreview(useCase0)) {
                                        Intrinsics.checkNotNullExpressionValue(useCase1, "useCase1");
                                        if (isVideoCapture(useCase1)) {
                                        }
                                    }
                                    for (ConcurrentCamera.SingleCameraConfig singleCameraConfig6 : singleCameraConfigs) {
                                        Intrinsics.checkNotNull(singleCameraConfig6);
                                        LifecycleOwner lifecycleOwner2 = singleCameraConfig6.getLifecycleOwner();
                                        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "config!!.lifecycleOwner");
                                        CameraSelector cameraSelector4 = singleCameraConfig6.getCameraSelector();
                                        Intrinsics.checkNotNullExpressionValue(cameraSelector4, "config.cameraSelector");
                                        CompositionSettings DEFAULT2 = CompositionSettings.DEFAULT;
                                        Intrinsics.checkNotNullExpressionValue(DEFAULT2, "DEFAULT");
                                        Intrinsics.checkNotNullExpressionValue(DEFAULT2, "DEFAULT");
                                        ViewPort viewPort2 = singleCameraConfig6.getUseCaseGroup().getViewPort();
                                        List<CameraEffect> effects2 = singleCameraConfig6.getUseCaseGroup().getEffects();
                                        Intrinsics.checkNotNullExpressionValue(effects2, "config.useCaseGroup.effects");
                                        List<UseCase> useCases2 = singleCameraConfig6.getUseCaseGroup().getUseCases();
                                        Intrinsics.checkNotNullExpressionValue(useCases2, "config.useCaseGroup.useCases");
                                        UseCase[] useCaseArr2 = (UseCase[]) useCases2.toArray(new UseCase[0]);
                                        arrayList.add(bindToLifecycle(lifecycleOwner2, cameraSelector4, null, DEFAULT2, DEFAULT2, viewPort2, effects2, (UseCase[]) Arrays.copyOf(useCaseArr2, useCaseArr2.length)));
                                    }
                                }
                                LifecycleOwner lifecycleOwner3 = singleCameraConfig2.getLifecycleOwner();
                                Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "firstCameraConfig.lifecycleOwner");
                                CameraSelector cameraSelector5 = singleCameraConfig2.getCameraSelector();
                                Intrinsics.checkNotNullExpressionValue(cameraSelector5, "firstCameraConfig.cameraSelector");
                                CameraSelector cameraSelector6 = singleCameraConfig4.getCameraSelector();
                                CompositionSettings compositionSettings = singleCameraConfig2.getCompositionSettings();
                                Intrinsics.checkNotNullExpressionValue(compositionSettings, "firstCameraConfig.compositionSettings");
                                CompositionSettings compositionSettings2 = singleCameraConfig4.getCompositionSettings();
                                Intrinsics.checkNotNullExpressionValue(compositionSettings2, "secondCameraConfig.compositionSettings");
                                ViewPort viewPort3 = singleCameraConfig2.getUseCaseGroup().getViewPort();
                                List<CameraEffect> effects3 = singleCameraConfig2.getUseCaseGroup().getEffects();
                                Intrinsics.checkNotNullExpressionValue(effects3, "firstCameraConfig.useCaseGroup.effects");
                                List<UseCase> useCases3 = singleCameraConfig2.getUseCaseGroup().getUseCases();
                                Intrinsics.checkNotNullExpressionValue(useCases3, "firstCameraConfig.useCaseGroup.useCases");
                                UseCase[] useCaseArr3 = (UseCase[]) useCases3.toArray(new UseCase[0]);
                                arrayList.add(bindToLifecycle(lifecycleOwner3, cameraSelector5, cameraSelector6, compositionSettings, compositionSettings2, viewPort3, effects3, (UseCase[]) Arrays.copyOf(useCaseArr3, useCaseArr3.length)));
                            } else {
                                if (isPreview(useCase0)) {
                                    Intrinsics.checkNotNullExpressionValue(useCase1, "useCase1");
                                    if (isVideoCapture(useCase1)) {
                                        LifecycleOwner lifecycleOwner4 = singleCameraConfig2.getLifecycleOwner();
                                        Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "firstCameraConfig.lifecycleOwner");
                                        CameraSelector cameraSelector7 = singleCameraConfig2.getCameraSelector();
                                        Intrinsics.checkNotNullExpressionValue(cameraSelector7, "firstCameraConfig.cameraSelector");
                                        CameraSelector cameraSelector8 = singleCameraConfig4.getCameraSelector();
                                        CompositionSettings compositionSettings3 = singleCameraConfig2.getCompositionSettings();
                                        Intrinsics.checkNotNullExpressionValue(compositionSettings3, "firstCameraConfig.compositionSettings");
                                        CompositionSettings compositionSettings4 = singleCameraConfig4.getCompositionSettings();
                                        Intrinsics.checkNotNullExpressionValue(compositionSettings4, "secondCameraConfig.compositionSettings");
                                        ViewPort viewPort4 = singleCameraConfig2.getUseCaseGroup().getViewPort();
                                        List<CameraEffect> effects4 = singleCameraConfig2.getUseCaseGroup().getEffects();
                                        Intrinsics.checkNotNullExpressionValue(effects4, "firstCameraConfig.useCaseGroup.effects");
                                        List<UseCase> useCases4 = singleCameraConfig2.getUseCaseGroup().getUseCases();
                                        Intrinsics.checkNotNullExpressionValue(useCases4, "firstCameraConfig.useCaseGroup.useCases");
                                        UseCase[] useCaseArr4 = (UseCase[]) useCases4.toArray(new UseCase[0]);
                                        arrayList.add(bindToLifecycle(lifecycleOwner4, cameraSelector7, cameraSelector8, compositionSettings3, compositionSettings4, viewPort4, effects4, (UseCase[]) Arrays.copyOf(useCaseArr4, useCaseArr4.length)));
                                    }
                                }
                                while (r0.hasNext()) {
                                    Intrinsics.checkNotNull(singleCameraConfig6);
                                    LifecycleOwner lifecycleOwner5 = singleCameraConfig6.getLifecycleOwner();
                                    Intrinsics.checkNotNullExpressionValue(lifecycleOwner5, "config!!.lifecycleOwner");
                                    CameraSelector cameraSelector9 = singleCameraConfig6.getCameraSelector();
                                    Intrinsics.checkNotNullExpressionValue(cameraSelector9, "config.cameraSelector");
                                    CompositionSettings DEFAULT3 = CompositionSettings.DEFAULT;
                                    Intrinsics.checkNotNullExpressionValue(DEFAULT3, "DEFAULT");
                                    Intrinsics.checkNotNullExpressionValue(DEFAULT3, "DEFAULT");
                                    ViewPort viewPort5 = singleCameraConfig6.getUseCaseGroup().getViewPort();
                                    List<CameraEffect> effects5 = singleCameraConfig6.getUseCaseGroup().getEffects();
                                    Intrinsics.checkNotNullExpressionValue(effects5, "config.useCaseGroup.effects");
                                    List<UseCase> useCases5 = singleCameraConfig6.getUseCaseGroup().getUseCases();
                                    Intrinsics.checkNotNullExpressionValue(useCases5, "config.useCaseGroup.useCases");
                                    UseCase[] useCaseArr5 = (UseCase[]) useCases5.toArray(new UseCase[0]);
                                    arrayList.add(bindToLifecycle(lifecycleOwner5, cameraSelector9, null, DEFAULT3, DEFAULT3, viewPort5, effects5, (UseCase[]) Arrays.copyOf(useCaseArr5, useCaseArr5.length)));
                                }
                            }
                        } else {
                            while (r0.hasNext()) {
                                Intrinsics.checkNotNull(singleCameraConfig6);
                                LifecycleOwner lifecycleOwner6 = singleCameraConfig6.getLifecycleOwner();
                                Intrinsics.checkNotNullExpressionValue(lifecycleOwner6, "config!!.lifecycleOwner");
                                CameraSelector cameraSelector10 = singleCameraConfig6.getCameraSelector();
                                Intrinsics.checkNotNullExpressionValue(cameraSelector10, "config.cameraSelector");
                                CompositionSettings DEFAULT4 = CompositionSettings.DEFAULT;
                                Intrinsics.checkNotNullExpressionValue(DEFAULT4, "DEFAULT");
                                Intrinsics.checkNotNullExpressionValue(DEFAULT4, "DEFAULT");
                                ViewPort viewPort6 = singleCameraConfig6.getUseCaseGroup().getViewPort();
                                List<CameraEffect> effects6 = singleCameraConfig6.getUseCaseGroup().getEffects();
                                Intrinsics.checkNotNullExpressionValue(effects6, "config.useCaseGroup.effects");
                                List<UseCase> useCases6 = singleCameraConfig6.getUseCaseGroup().getUseCases();
                                Intrinsics.checkNotNullExpressionValue(useCases6, "config.useCaseGroup.useCases");
                                UseCase[] useCaseArr6 = (UseCase[]) useCases6.toArray(new UseCase[0]);
                                arrayList.add(bindToLifecycle(lifecycleOwner6, cameraSelector10, null, DEFAULT4, DEFAULT4, viewPort6, effects6, (UseCase[]) Arrays.copyOf(useCaseArr6, useCaseArr6.length)));
                            }
                        }
                        setActiveConcurrentCameraInfos(arrayList3);
                    } catch (IllegalArgumentException unused) {
                        throw new IllegalArgumentException("Invalid camera selectors in camera configs.");
                    }
                } else {
                    throw new UnsupportedOperationException("Concurrent camera is not supported on the device.");
                }
            }
            ConcurrentCamera concurrentCamera = new ConcurrentCamera(arrayList);
            Trace.endSection();
            return concurrentCamera;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public List<CameraInfo> getAvailableCameraInfos() {
        Trace.beginSection("CX:getAvailableCameraInfos");
        try {
            ArrayList arrayList = new ArrayList();
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            LinkedHashSet<CameraInternal> cameras = cameraX.getCameraRepository().getCameras();
            Intrinsics.checkNotNullExpressionValue(cameras, "cameraX!!.cameraRepository.cameras");
            Iterator<CameraInternal> it2 = cameras.iterator();
            while (it2.hasNext()) {
                CameraInfo cameraInfo = it2.next().getCameraInfo();
                Intrinsics.checkNotNullExpressionValue(cameraInfo, "camera.cameraInfo");
                arrayList.add(cameraInfo);
            }
            Trace.endSection();
            return arrayList;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        Trace.beginSection("CX:getAvailableConcurrentCameraInfos");
        try {
            Objects.requireNonNull(this.cameraX);
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            Objects.requireNonNull(cameraX.getCameraFactory().getCameraCoordinator());
            CameraX cameraX2 = this.cameraX;
            Intrinsics.checkNotNull(cameraX2);
            List<List<CameraSelector>> concurrentCameraSelectors = cameraX2.getCameraFactory().getCameraCoordinator().getConcurrentCameraSelectors();
            Intrinsics.checkNotNullExpressionValue(concurrentCameraSelectors, "cameraX!!.cameraFactory.…concurrentCameraSelectors");
            ArrayList arrayList = new ArrayList();
            for (List<CameraSelector> list : concurrentCameraSelectors) {
                ArrayList arrayList2 = new ArrayList();
                for (CameraSelector cameraSelector : list) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(cameraSelector, "cameraSelector");
                        arrayList2.add(getCameraInfo(cameraSelector));
                    } catch (IllegalArgumentException unused) {
                    }
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public CameraInfo getCameraInfo(@NotNull CameraSelector cameraSelector) {
        Object restrictedCameraInfo;
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Trace.beginSection("CX:getCameraInfo");
        try {
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            CameraInfoInternal cameraInfoInternal = cameraSelector.select(cameraX.getCameraRepository().getCameras()).getCameraInfoInternal();
            Intrinsics.checkNotNullExpressionValue(cameraInfoInternal, "cameraSelector.select(ca…meras).cameraInfoInternal");
            CameraConfig cameraConfig = getCameraConfig(cameraSelector, cameraInfoInternal);
            CameraUseCaseAdapter.CameraId cameraIdCreate = CameraUseCaseAdapter.CameraId.create(cameraInfoInternal.getCameraId(), cameraConfig.getCompatibilityId());
            Intrinsics.checkNotNullExpressionValue(cameraIdCreate, "create(\n                …ilityId\n                )");
            synchronized (this.lock) {
                restrictedCameraInfo = this.cameraInfoMap.get(cameraIdCreate);
                if (restrictedCameraInfo == null) {
                    restrictedCameraInfo = new RestrictedCameraInfo(cameraInfoInternal, cameraConfig);
                    this.cameraInfoMap.put(cameraIdCreate, restrictedCameraInfo);
                }
                Unit unit = Unit.INSTANCE;
            }
            RestrictedCameraInfo restrictedCameraInfo2 = (RestrictedCameraInfo) restrictedCameraInfo;
            Trace.endSection();
            return restrictedCameraInfo2;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
