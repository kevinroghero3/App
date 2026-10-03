package com.mrousavy.camera.core;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.camera.core.Camera;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.facebook.react.bridge.UiThreadUtil;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.ShutterType;
import com.mrousavy.camera.frameprocessors.Frame;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraSession implements Closeable, LifecycleOwner, OrientationManager.Callback {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "CameraSession";
    private final AudioManager audioManager;
    private final Callback callback;
    private Camera camera;
    private final ListenableFuture<ProcessCameraProvider> cameraProvider;
    private ImageAnalysis codeScannerOutput;
    private CameraConfiguration configuration;
    private final Context context;
    private List<? extends UseCase> currentUseCases;
    private ImageAnalysis frameProcessorOutput;
    private boolean isDestroyed;
    private boolean isRecordingCanceled;
    private final LifecycleRegistry lifecycleRegistry;
    private final Executor mainExecutor;
    private final MetadataProvider metadataProvider;
    private final Mutex mutex;
    private final OrientationManager orientationManager;
    private ImageCapture photoOutput;
    private Preview previewOutput;
    private Recorder recorderOutput;
    private Recording recording;
    private VideoCapture<Recorder> videoOutput;

    public interface Callback {
        void onCodeScanned(@NotNull List<? extends Barcode> list, @NotNull CodeScannerFrame codeScannerFrame);

        void onError(@NotNull Throwable th);

        void onFrame(@NotNull Frame frame);

        void onInitialized();

        void onOutputOrientationChanged(@NotNull Orientation orientation);

        void onPreviewOrientationChanged(@NotNull Orientation orientation);

        void onShutter(@NotNull ShutterType shutterType);

        void onStarted();

        void onStopped();
    }

    /* JADX INFO: renamed from: com.mrousavy.camera.core.CameraSession$configure$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.mrousavy.camera.core.CameraSession", f = "CameraSession.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 232, 149}, m = BackgroundFetch.ACTION_CONFIGURE, n = {"this", "lambda", "this", "lambda", "provider", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "config", "diff"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class C03351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C03351(Continuation<? super C03351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSession.this.configure(null, this);
        }
    }

    public CameraSession(@NotNull Context context, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.callback = callback;
        this.cameraProvider = ProcessCameraProvider.Companion.getInstance(context);
        this.currentUseCases = CollectionsKt__CollectionsKt.emptyList();
        this.metadataProvider = new MetadataProvider(context);
        this.orientationManager = new OrientationManager(context, this);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.lifecycleRegistry = lifecycleRegistry;
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        Executor mainExecutor = ContextCompat.getMainExecutor(context);
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
        this.mainExecutor = mainExecutor;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.mrousavy.camera.core.CameraSession.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Log.i(CameraSession.TAG, "Camera Lifecycle changed to " + event.getTargetState() + "!");
            }
        });
    }

    public final Callback getCallback$react_native_vision_camera_release() {
        return this.callback;
    }

    public final Context getContext$react_native_vision_camera_release() {
        return this.context;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final CameraConfiguration getConfiguration$react_native_vision_camera_release() {
        return this.configuration;
    }

    public final void setConfiguration$react_native_vision_camera_release(@Nullable CameraConfiguration cameraConfiguration) {
        this.configuration = cameraConfiguration;
    }

    public final ListenableFuture<ProcessCameraProvider> getCameraProvider$react_native_vision_camera_release() {
        return this.cameraProvider;
    }

    public final Camera getCamera$react_native_vision_camera_release() {
        return this.camera;
    }

    public final void setCamera$react_native_vision_camera_release(@Nullable Camera camera) {
        this.camera = camera;
    }

    public final Preview getPreviewOutput$react_native_vision_camera_release() {
        return this.previewOutput;
    }

    public final void setPreviewOutput$react_native_vision_camera_release(@Nullable Preview preview) {
        this.previewOutput = preview;
    }

    public final ImageCapture getPhotoOutput$react_native_vision_camera_release() {
        return this.photoOutput;
    }

    public final void setPhotoOutput$react_native_vision_camera_release(@Nullable ImageCapture imageCapture) {
        this.photoOutput = imageCapture;
    }

    public final VideoCapture<Recorder> getVideoOutput$react_native_vision_camera_release() {
        return this.videoOutput;
    }

    public final void setVideoOutput$react_native_vision_camera_release(@Nullable VideoCapture<Recorder> videoCapture) {
        this.videoOutput = videoCapture;
    }

    public final ImageAnalysis getFrameProcessorOutput$react_native_vision_camera_release() {
        return this.frameProcessorOutput;
    }

    public final void setFrameProcessorOutput$react_native_vision_camera_release(@Nullable ImageAnalysis imageAnalysis) {
        this.frameProcessorOutput = imageAnalysis;
    }

    public final ImageAnalysis getCodeScannerOutput$react_native_vision_camera_release() {
        return this.codeScannerOutput;
    }

    public final void setCodeScannerOutput$react_native_vision_camera_release(@Nullable ImageAnalysis imageAnalysis) {
        this.codeScannerOutput = imageAnalysis;
    }

    public final List<UseCase> getCurrentUseCases$react_native_vision_camera_release() {
        return this.currentUseCases;
    }

    public final void setCurrentUseCases$react_native_vision_camera_release(@NotNull List<? extends UseCase> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.currentUseCases = list;
    }

    public final MetadataProvider getMetadataProvider$react_native_vision_camera_release() {
        return this.metadataProvider;
    }

    public final OrientationManager getOrientationManager$react_native_vision_camera_release() {
        return this.orientationManager;
    }

    public final Recorder getRecorderOutput$react_native_vision_camera_release() {
        return this.recorderOutput;
    }

    public final void setRecorderOutput$react_native_vision_camera_release(@Nullable Recorder recorder) {
        this.recorderOutput = recorder;
    }

    public final Mutex getMutex$react_native_vision_camera_release() {
        return this.mutex;
    }

    public final boolean isDestroyed$react_native_vision_camera_release() {
        return this.isDestroyed;
    }

    public final void setDestroyed$react_native_vision_camera_release(boolean z) {
        this.isDestroyed = z;
    }

    public final LifecycleRegistry getLifecycleRegistry$react_native_vision_camera_release() {
        return this.lifecycleRegistry;
    }

    public final Recording getRecording$react_native_vision_camera_release() {
        return this.recording;
    }

    public final void setRecording$react_native_vision_camera_release(@Nullable Recording recording) {
        this.recording = recording;
    }

    public final boolean isRecordingCanceled$react_native_vision_camera_release() {
        return this.isRecordingCanceled;
    }

    public final void setRecordingCanceled$react_native_vision_camera_release(boolean z) {
        this.isRecordingCanceled = z;
    }

    public final AudioManager getAudioManager$react_native_vision_camera_release() {
        return this.audioManager;
    }

    public final Executor getMainExecutor$react_native_vision_camera_release() {
        return this.mainExecutor;
    }

    public final Orientation getOutputOrientation() {
        return this.orientationManager.getOutputOrientation();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Log.i(TAG, "Closing CameraSession...");
        this.isDestroyed = true;
        this.orientationManager.stopOrientationUpdates();
        if (UiThreadUtil.isOnUiThread()) {
            getLifecycleRegistry$react_native_vision_camera_release().setCurrentState(Lifecycle.State.DESTROYED);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.core.CameraSession$close$$inlined$runOnUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.getLifecycleRegistry$react_native_vision_camera_release().setCurrentState(Lifecycle.State.DESTROYED);
                }
            });
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00c3 A[Catch: all -> 0x0198, TryCatch #4 {all -> 0x0198, blocks: (B:75:0x0192, B:74:0x016d, B:38:0x00aa, B:39:0x00b2, B:40:0x00b5, B:42:0x00c3, B:43:0x00ca, B:45:0x00ce, B:46:0x00d5, B:80:0x019a), top: B:99:0x00aa, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ca A[Catch: all -> 0x0198, TryCatch #4 {all -> 0x0198, blocks: (B:75:0x0192, B:74:0x016d, B:38:0x00aa, B:39:0x00b2, B:40:0x00b5, B:42:0x00c3, B:43:0x00ca, B:45:0x00ce, B:46:0x00d5, B:80:0x019a), top: B:99:0x00aa, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ce A[Catch: all -> 0x0198, TryCatch #4 {all -> 0x0198, blocks: (B:75:0x0192, B:74:0x016d, B:38:0x00aa, B:39:0x00b2, B:40:0x00b5, B:42:0x00c3, B:43:0x00ca, B:45:0x00ce, B:46:0x00d5, B:80:0x019a), top: B:99:0x00aa, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00d5 A[Catch: all -> 0x0198, TRY_LEAVE, TryCatch #4 {all -> 0x0198, blocks: (B:75:0x0192, B:74:0x016d, B:38:0x00aa, B:39:0x00b2, B:40:0x00b5, B:42:0x00c3, B:43:0x00ca, B:45:0x00ce, B:46:0x00d5, B:80:0x019a), top: B:99:0x00aa, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ef A[Catch: all -> 0x016c, TryCatch #5 {all -> 0x016c, blocks: (B:47:0x00e9, B:49:0x00ef, B:50:0x00f5, B:52:0x00fb), top: B:100:0x00e9 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00fb A[Catch: all -> 0x016c, TRY_LEAVE, TryCatch #5 {all -> 0x016c, blocks: (B:47:0x00e9, B:49:0x00ef, B:50:0x00f5, B:52:0x00fb), top: B:100:0x00e9 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x010b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x010c  */
    /* JADX WARN: Code duplicated, block: B:57:0x0112  */
    /* JADX WARN: Code duplicated, block: B:60:0x011b A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:14:0x003e, B:58:0x0115, B:60:0x011b, B:61:0x011e, B:63:0x0124, B:64:0x0127, B:66:0x012d, B:67:0x0136, B:69:0x013c, B:70:0x0145), top: B:93:0x003e }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0124 A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:14:0x003e, B:58:0x0115, B:60:0x011b, B:61:0x011e, B:63:0x0124, B:64:0x0127, B:66:0x012d, B:67:0x0136, B:69:0x013c, B:70:0x0145), top: B:93:0x003e }] */
    /* JADX WARN: Code duplicated, block: B:66:0x012d A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:14:0x003e, B:58:0x0115, B:60:0x011b, B:61:0x011e, B:63:0x0124, B:64:0x0127, B:66:0x012d, B:67:0x0136, B:69:0x013c, B:70:0x0145), top: B:93:0x003e }] */
    /* JADX WARN: Code duplicated, block: B:69:0x013c A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:14:0x003e, B:58:0x0115, B:60:0x011b, B:61:0x011e, B:63:0x0124, B:64:0x0127, B:66:0x012d, B:67:0x0136, B:69:0x013c, B:70:0x0145), top: B:93:0x003e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x00d5, please report this as an issue */
    public final Object configure(@NotNull Function1<? super CameraConfiguration, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        C03351 c03351;
        CameraSession cameraSession;
        ProcessCameraProvider processCameraProvider;
        Function1<? super CameraConfiguration, Unit> function2;
        Mutex mutex;
        CameraConfiguration cameraConfigurationCopyOf;
        CameraConfiguration.Difference difference;
        CameraSession cameraSession2;
        Mutex mutex2;
        CameraConfiguration.Difference difference2;
        CameraConfiguration cameraConfiguration;
        if (continuation instanceof C03351) {
            c03351 = (C03351) continuation;
            int i = c03351.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03351.label = i - Integer.MIN_VALUE;
            } else {
                c03351 = new C03351(continuation);
            }
        } else {
            c03351 = new C03351(continuation);
        }
        Object objAwait = c03351.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c03351.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            if (!UiThreadUtil.isOnUiThread()) {
                throw new Error("configure { ... } must be called from the Main UI Thread!");
            }
            Log.i(TAG, "configure { ... }: Waiting for lock...");
            try {
                ListenableFuture<ProcessCameraProvider> listenableFuture = this.cameraProvider;
                Executor executor = this.mainExecutor;
                c03351.L$0 = this;
                c03351.L$1 = function1;
                c03351.label = 1;
                objAwait = ListenableFuture_awaitKt.await(listenableFuture, executor, c03351);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cameraSession = this;
            } catch (Throwable th) {
                th = th;
                cameraSession = this;
                SentryLogcatAdapter.e(TAG, "Failed to get CameraProvider! Error: " + th.getMessage(), th);
                cameraSession.callback.onError(th);
                return Unit.INSTANCE;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    difference2 = (CameraConfiguration.Difference) c03351.L$3;
                    cameraConfiguration = (CameraConfiguration) c03351.L$2;
                    mutex2 = (Mutex) c03351.L$1;
                    cameraSession2 = (CameraSession) c03351.L$0;
                    try {
                        ResultKt.throwOnFailure(objAwait);
                        cameraConfigurationCopyOf = cameraConfiguration;
                        if (difference2.getSidePropsChanged()) {
                            CameraSession_ConfigurationKt.configureSideProps(cameraSession2, cameraConfigurationCopyOf);
                        }
                        if (difference2.isActiveChanged()) {
                            CameraSession_ConfigurationKt.configureIsActive(cameraSession2, cameraConfigurationCopyOf);
                        }
                        if (difference2.getOrientationChanged()) {
                            cameraSession2.orientationManager.setTargetOutputOrientation(cameraConfigurationCopyOf.getOutputOrientation());
                        }
                        if (difference2.getLocationChanged()) {
                            cameraSession2.metadataProvider.enableLocationUpdates(cameraConfigurationCopyOf.getEnableLocation());
                        }
                        Log.i(TAG, "configure { ... }: Completed CameraSession Configuration! (State: " + cameraSession2.getLifecycle().getCurrentState() + ")");
                        mutex = mutex2;
                    } catch (Throwable th2) {
                        th = th2;
                        difference = difference2;
                        mutex = mutex2;
                        cameraSession = cameraSession2;
                        SentryLogcatAdapter.e(TAG, "Failed to configure CameraSession! Error: " + th.getMessage() + ", Config-Diff: " + difference, th);
                        cameraSession.callback.onError(th);
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock(null);
                    return unit;
                }
                mutex = (Mutex) c03351.L$3;
                ProcessCameraProvider processCameraProvider2 = (ProcessCameraProvider) c03351.L$2;
                function2 = (Function1) c03351.L$1;
                CameraSession cameraSession3 = (CameraSession) c03351.L$0;
                ResultKt.throwOnFailure(objAwait);
                processCameraProvider = processCameraProvider2;
                cameraSession = cameraSession3;
                try {
                    CameraConfiguration.Companion companion = CameraConfiguration.Companion;
                    cameraConfigurationCopyOf = companion.copyOf(cameraSession.configuration);
                    try {
                        function2.invoke(cameraConfigurationCopyOf);
                        difference = companion.difference(cameraSession.configuration, cameraConfigurationCopyOf);
                        cameraSession.configuration = cameraConfigurationCopyOf;
                        if (!difference.getHasChanges()) {
                            Log.i(TAG, "Nothing changed, aborting configure { ... }");
                        } else if (cameraSession.isDestroyed) {
                            Log.i(TAG, "CameraSession is already destroyed. Skipping configure { ... }");
                        } else {
                            Log.i(TAG, "configure { ... }: Updating CameraSession Configuration... " + difference);
                            try {
                                if (difference.getOutputsChanged()) {
                                    CameraSession_ConfigurationKt.configureOutputs(cameraSession, cameraConfigurationCopyOf);
                                    cameraSession.configureOrientation();
                                }
                                if (difference.getDeviceChanged()) {
                                    c03351.L$0 = cameraSession;
                                    c03351.L$1 = mutex;
                                    c03351.L$2 = cameraConfigurationCopyOf;
                                    c03351.L$3 = difference;
                                    c03351.label = 3;
                                    if (CameraSession_ConfigurationKt.configureCamera(cameraSession, processCameraProvider, cameraConfigurationCopyOf, c03351) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    cameraSession2 = cameraSession;
                                    cameraConfiguration = cameraConfigurationCopyOf;
                                    mutex2 = mutex;
                                    difference2 = difference;
                                    cameraConfigurationCopyOf = cameraConfiguration;
                                } else {
                                    cameraSession2 = cameraSession;
                                    mutex2 = mutex;
                                    difference2 = difference;
                                }
                                if (difference2.getSidePropsChanged()) {
                                    CameraSession_ConfigurationKt.configureSideProps(cameraSession2, cameraConfigurationCopyOf);
                                }
                                if (difference2.isActiveChanged()) {
                                    CameraSession_ConfigurationKt.configureIsActive(cameraSession2, cameraConfigurationCopyOf);
                                }
                                if (difference2.getOrientationChanged()) {
                                    cameraSession2.orientationManager.setTargetOutputOrientation(cameraConfigurationCopyOf.getOutputOrientation());
                                }
                                if (difference2.getLocationChanged()) {
                                    cameraSession2.metadataProvider.enableLocationUpdates(cameraConfigurationCopyOf.getEnableLocation());
                                }
                                Log.i(TAG, "configure { ... }: Completed CameraSession Configuration! (State: " + cameraSession2.getLifecycle().getCurrentState() + ")");
                                mutex = mutex2;
                            } catch (Throwable th3) {
                                th = th3;
                                SentryLogcatAdapter.e(TAG, "Failed to configure CameraSession! Error: " + th.getMessage() + ", Config-Diff: " + difference, th);
                                cameraSession.callback.onError(th);
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                        mutex.unlock(null);
                        return unit2;
                    } catch (CameraConfiguration.AbortThrow unused) {
                        Unit unit3 = Unit.INSTANCE;
                        mutex.unlock(null);
                        return unit3;
                    }
                } catch (Throwable th4) {
                    mutex.unlock(null);
                    throw th4;
                }
            }
            function1 = (Function1) c03351.L$1;
            cameraSession = (CameraSession) c03351.L$0;
            try {
                ResultKt.throwOnFailure(objAwait);
            } catch (Throwable th5) {
                th = th5;
                SentryLogcatAdapter.e(TAG, "Failed to get CameraProvider! Error: " + th.getMessage(), th);
                cameraSession.callback.onError(th);
                return Unit.INSTANCE;
            }
        }
        processCameraProvider = (ProcessCameraProvider) objAwait;
        Mutex mutex3 = cameraSession.mutex;
        c03351.L$0 = cameraSession;
        c03351.L$1 = function1;
        c03351.L$2 = processCameraProvider;
        c03351.L$3 = mutex3;
        c03351.label = 2;
        if (mutex3.lock(null, c03351) == coroutine_suspended) {
            return coroutine_suspended;
        }
        function2 = function1;
        mutex = mutex3;
        CameraConfiguration.Companion companion2 = CameraConfiguration.Companion;
        cameraConfigurationCopyOf = companion2.copyOf(cameraSession.configuration);
        function2.invoke(cameraConfigurationCopyOf);
        difference = companion2.difference(cameraSession.configuration, cameraConfigurationCopyOf);
        cameraSession.configuration = cameraConfigurationCopyOf;
        if (!difference.getHasChanges()) {
            Log.i(TAG, "Nothing changed, aborting configure { ... }");
        } else if (cameraSession.isDestroyed) {
            Log.i(TAG, "CameraSession is already destroyed. Skipping configure { ... }");
        } else {
            Log.i(TAG, "configure { ... }: Updating CameraSession Configuration... " + difference);
            if (difference.getOutputsChanged()) {
                CameraSession_ConfigurationKt.configureOutputs(cameraSession, cameraConfigurationCopyOf);
                cameraSession.configureOrientation();
            }
            if (difference.getDeviceChanged()) {
                c03351.L$0 = cameraSession;
                c03351.L$1 = mutex;
                c03351.L$2 = cameraConfigurationCopyOf;
                c03351.L$3 = difference;
                c03351.label = 3;
                if (CameraSession_ConfigurationKt.configureCamera(cameraSession, processCameraProvider, cameraConfigurationCopyOf, c03351) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cameraSession2 = cameraSession;
                cameraConfiguration = cameraConfigurationCopyOf;
                mutex2 = mutex;
                difference2 = difference;
                cameraConfigurationCopyOf = cameraConfiguration;
            } else {
                cameraSession2 = cameraSession;
                mutex2 = mutex;
                difference2 = difference;
            }
            if (difference2.getSidePropsChanged()) {
                CameraSession_ConfigurationKt.configureSideProps(cameraSession2, cameraConfigurationCopyOf);
            }
            if (difference2.isActiveChanged()) {
                CameraSession_ConfigurationKt.configureIsActive(cameraSession2, cameraConfigurationCopyOf);
            }
            if (difference2.getOrientationChanged()) {
                cameraSession2.orientationManager.setTargetOutputOrientation(cameraConfigurationCopyOf.getOutputOrientation());
            }
            if (difference2.getLocationChanged()) {
                cameraSession2.metadataProvider.enableLocationUpdates(cameraConfigurationCopyOf.getEnableLocation());
            }
            Log.i(TAG, "configure { ... }: Completed CameraSession Configuration! (State: " + cameraSession2.getLifecycle().getCurrentState() + ")");
            mutex = mutex2;
        }
        Unit unit4 = Unit.INSTANCE;
        mutex.unlock(null);
        return unit4;
    }

    public final void checkCameraPermission$react_native_vision_camera_release() {
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            throw new CameraPermissionError();
        }
    }

    public final void checkMicrophonePermission$react_native_vision_camera_release() throws MicrophonePermissionError {
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.RECORD_AUDIO") != 0) {
            throw new MicrophonePermissionError();
        }
    }

    @Override // com.mrousavy.camera.core.OrientationManager.Callback
    public void onOutputOrientationChanged(@NotNull Orientation outputOrientation) {
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        Log.i(TAG, "Output orientation changed! " + outputOrientation);
        configureOrientation();
        this.callback.onOutputOrientationChanged(outputOrientation);
    }

    @Override // com.mrousavy.camera.core.OrientationManager.Callback
    public void onPreviewOrientationChanged(@NotNull Orientation previewOrientation) {
        Intrinsics.checkNotNullParameter(previewOrientation, "previewOrientation");
        Log.i(TAG, "Preview orientation changed! " + previewOrientation);
        configureOrientation();
        this.callback.onPreviewOrientationChanged(previewOrientation);
    }

    private final void configureOrientation() {
        int surfaceRotation = this.orientationManager.getPreviewOrientation().toSurfaceRotation();
        Preview preview = this.previewOutput;
        if (preview != null) {
            preview.setTargetRotation(surfaceRotation);
        }
        ImageAnalysis imageAnalysis = this.codeScannerOutput;
        if (imageAnalysis != null) {
            imageAnalysis.setTargetRotation(surfaceRotation);
        }
        int surfaceRotation2 = this.orientationManager.getOutputOrientation().toSurfaceRotation();
        ImageCapture imageCapture = this.photoOutput;
        if (imageCapture != null) {
            imageCapture.setTargetRotation(surfaceRotation2);
        }
        VideoCapture<Recorder> videoCapture = this.videoOutput;
        if (videoCapture != null) {
            videoCapture.setTargetRotation(surfaceRotation2);
        }
    }
}
