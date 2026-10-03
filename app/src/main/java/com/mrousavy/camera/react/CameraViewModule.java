package com.mrousavy.camera.react;

import android.content.ComponentCallbacks2;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.uimanager.UIManagerHelper;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CameraQueues;
import com.mrousavy.camera.core.UnknownCameraError;
import com.mrousavy.camera.core.ViewNotFoundError;
import com.mrousavy.camera.core.types.PermissionStatus;
import com.mrousavy.camera.core.types.RecordVideoOptions;
import com.mrousavy.camera.core.types.TakeSnapshotOptions;
import com.mrousavy.camera.frameprocessors.VisionCameraInstaller;
import com.mrousavy.camera.frameprocessors.VisionCameraProxy;
import com.mrousavy.camera.react.utils.CallbackPromiseKt;
import com.transistorsoft.rnbackgroundgeolocation.RNBackgroundGeolocationModule;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = "CameraView")
public final class CameraViewModule extends ReactContextBaseJavaModule {
    public static final String TAG = "CameraView";
    private final CoroutineScope backgroundCoroutineScope;
    public static final Companion Companion = new Companion(null);
    private static int sharedRequestCode = 10;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getSharedRequestCode() {
            return CameraViewModule.sharedRequestCode;
        }

        public final void setSharedRequestCode(int i) {
            CameraViewModule.sharedRequestCode = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.backgroundCoroutineScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(CameraQueues.Companion.getCameraExecutor()));
    }

    static {
        try {
            System.loadLibrary("VisionCamera");
        } catch (UnsatisfiedLinkError e) {
            SentryLogcatAdapter.e(VisionCameraProxy.TAG, "Failed to load VisionCamera C++ library!", e);
            throw e;
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        if (CoroutineScopeKt.isActive(this.backgroundCoroutineScope)) {
            CoroutineScopeKt.cancel$default(this.backgroundCoroutineScope, "CameraViewModule has been destroyed.", null, 2, null);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "CameraView";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean installFrameProcessorBindings() {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            VisionCameraInstaller.install(new VisionCameraProxy(reactApplicationContext));
            return true;
        } catch (Error e) {
            SentryLogcatAdapter.e("CameraView", "Failed to install Frame Processor JSI Bindings!", e);
            return false;
        }
    }

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraViewModule$takePhoto$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$takePhoto$1", f = "CameraViewModule.kt", i = {1}, l = {94, 96}, m = "invokeSuspend", n = {"promise$iv"}, s = {"L$0"})
    static final class C03421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadableMap $options;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03421(int i, Promise promise, ReadableMap readableMap, Continuation<? super C03421> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
            this.$options = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C03421(this.$viewTag, this.$promise, this.$options, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0054  */
        /* JADX WARN: Code duplicated, block: B:29:0x0057  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            CameraView cameraView;
            Promise promise;
            ReadableMap readableMap;
            Promise promise2;
            CameraError unknownCameraError;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CameraViewModule cameraViewModule = CameraViewModule.this;
                    int i2 = this.$viewTag;
                    this.label = 1;
                    obj = cameraViewModule.findCameraView(i2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        promise2 = (Promise) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            promise2.resolve(obj);
                        } catch (Throwable th) {
                            th = th;
                            promise = promise2;
                            th.printStackTrace();
                            if (th instanceof CameraError) {
                                unknownCameraError = th;
                            } else {
                                unknownCameraError = new UnknownCameraError(th);
                            }
                            promise.reject(unknownCameraError.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.L$0 = promise;
                this.label = 2;
                obj = CameraView_TakePhotoKt.takePhoto(cameraView, readableMap, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                promise2 = promise;
                promise2.resolve(obj);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                if (th instanceof CameraError) {
                    unknownCameraError = th;
                } else {
                    unknownCameraError = new UnknownCameraError(th);
                }
                promise.reject(unknownCameraError.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            cameraView = (CameraView) obj;
            promise = this.$promise;
            readableMap = this.$options;
        }
    }

    @ReactMethod
    public final void takePhoto(int i, @NotNull ReadableMap options, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C03421(i, promise, options, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraViewModule$takeSnapshot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes6.dex */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$takeSnapshot$1", f = "CameraViewModule.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    static final class C03431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadableMap $jsOptions;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03431(int i, ReadableMap readableMap, Promise promise, Continuation<? super C03431> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$jsOptions = readableMap;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C03431(this.$viewTag, this.$jsOptions, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraViewModule cameraViewModule = CameraViewModule.this;
                int i2 = this.$viewTag;
                this.label = 1;
                obj = cameraViewModule.findCameraView(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            final CameraView cameraView = (CameraView) obj;
            final CameraViewModule cameraViewModule2 = CameraViewModule.this;
            final ReadableMap readableMap = this.$jsOptions;
            final Promise promise = this.$promise;
            if (UiThreadUtil.isOnUiThread()) {
                try {
                    TakeSnapshotOptions.Companion companion = TakeSnapshotOptions.Companion;
                    ReactApplicationContext reactApplicationContext = cameraViewModule2.getReactApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                    promise.resolve(CameraView_TakeSnapshotKt.takeSnapshot(cameraView, companion.fromJSValue(reactApplicationContext, readableMap)));
                } catch (Throwable th) {
                    promise.reject(th);
                }
            } else {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.react.CameraViewModule$takeSnapshot$1$invokeSuspend$$inlined$runOnUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            TakeSnapshotOptions.Companion companion2 = TakeSnapshotOptions.Companion;
                            ReactApplicationContext reactApplicationContext2 = cameraViewModule2.getReactApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "access$getReactApplicationContext(...)");
                            promise.resolve(CameraView_TakeSnapshotKt.takeSnapshot(cameraView, companion2.fromJSValue(reactApplicationContext2, readableMap)));
                        } catch (Throwable th2) {
                            promise.reject(th2);
                        }
                    }
                });
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void takeSnapshot(int i, @NotNull ReadableMap jsOptions, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(jsOptions, "jsOptions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C03431(i, jsOptions, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraViewModule$startRecording$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$startRecording$1", f = "CameraViewModule.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    static final class C03401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadableMap $jsOptions;
        final /* synthetic */ Callback $onRecordCallback;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03401(int i, ReadableMap readableMap, Callback callback, Continuation<? super C03401> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$jsOptions = readableMap;
            this.$onRecordCallback = callback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C03401(this.$viewTag, this.$jsOptions, this.$onRecordCallback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraViewModule cameraViewModule = CameraViewModule.this;
                int i2 = this.$viewTag;
                this.label = 1;
                obj = cameraViewModule.findCameraView(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            try {
                RecordVideoOptions.Companion companion = RecordVideoOptions.Companion;
                ReactApplicationContext reactApplicationContext = CameraViewModule.this.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                CameraView_RecordVideoKt.startRecording(cameraView, companion.fromJSValue(reactApplicationContext, this.$jsOptions), this.$onRecordCallback);
            } catch (CameraError e) {
                this.$onRecordCallback.invoke(null, CallbackPromiseKt.makeErrorMap$default(e.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + e.getId(), e.getMessage(), e, null, 8, null));
            } catch (Throwable th) {
                this.$onRecordCallback.invoke(null, CallbackPromiseKt.makeErrorMap$default("capture/unknown", "An unknown error occurred while trying to start a video recording! " + th.getMessage(), th, null, 8, null));
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void startRecording(int i, @NotNull ReadableMap jsOptions, @NotNull Callback onRecordCallback) {
        Intrinsics.checkNotNullParameter(jsOptions, "jsOptions");
        Intrinsics.checkNotNullParameter(onRecordCallback, "onRecordCallback");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C03401(i, jsOptions, onRecordCallback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraViewModule$pauseRecording$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$pauseRecording$1", f = "CameraViewModule.kt", i = {0}, l = {140}, m = "invokeSuspend", n = {"promise$iv"}, s = {"L$0"})
    static final class C03381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        Object L$0;
        int label;
        final /* synthetic */ CameraViewModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03381(Promise promise, CameraViewModule cameraViewModule, int i, Continuation<? super C03381> continuation) {
            super(2, continuation);
            this.$promise = promise;
            this.this$0 = cameraViewModule;
            this.$viewTag = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03381(this.$promise, this.this$0, this.$viewTag, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0048  */
        /* JADX WARN: Code duplicated, block: B:24:0x004b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Promise promise;
            CameraError th;
            CameraError unknownCameraError;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Promise promise2 = this.$promise;
                CameraViewModule cameraViewModule = this.this$0;
                int i2 = this.$viewTag;
                try {
                    this.L$0 = promise2;
                    this.label = 1;
                    Object objFindCameraView = cameraViewModule.findCameraView(i2, this);
                    if (objFindCameraView == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    promise = promise2;
                    obj = objFindCameraView;
                } catch (Throwable th2) {
                    promise = promise2;
                    th = th2;
                    th.printStackTrace();
                    if (th instanceof CameraError) {
                        unknownCameraError = th;
                    } else {
                        unknownCameraError = new UnknownCameraError(th);
                    }
                    promise.reject(unknownCameraError.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                promise = (Promise) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                    if (th instanceof CameraError) {
                        unknownCameraError = th;
                    } else {
                        unknownCameraError = new UnknownCameraError(th);
                    }
                    promise.reject(unknownCameraError.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
                }
            }
            CameraView_RecordVideoKt.pauseRecording((CameraView) obj);
            promise.resolve(null);
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void pauseRecording(int i, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C03381(promise, this, i, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraViewModule$resumeRecording$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$resumeRecording$1", f = "CameraViewModule.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    static final class C03391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03391(int i, Promise promise, Continuation<? super C03391> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C03391(this.$viewTag, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraViewModule cameraViewModule = CameraViewModule.this;
                int i2 = this.$viewTag;
                this.label = 1;
                obj = cameraViewModule.findCameraView(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            Promise promise = this.$promise;
            try {
                CameraView_RecordVideoKt.resumeRecording(cameraView);
                promise.resolve(null);
            } catch (Throwable th) {
                th.printStackTrace();
                CameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
                promise.reject(unknownCameraError.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void resumeRecording(int i, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C03391(i, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraViewModule$stopRecording$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$stopRecording$1", f = "CameraViewModule.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    static final class C03411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03411(int i, Promise promise, Continuation<? super C03411> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C03411(this.$viewTag, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraViewModule cameraViewModule = CameraViewModule.this;
                int i2 = this.$viewTag;
                this.label = 1;
                obj = cameraViewModule.findCameraView(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            Promise promise = this.$promise;
            try {
                CameraView_RecordVideoKt.stopRecording(cameraView);
                promise.resolve(null);
            } catch (Throwable th) {
                th.printStackTrace();
                CameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
                promise.reject(unknownCameraError.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void stopRecording(int i, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C03411(i, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraViewModule$cancelRecording$1, reason: invalid class name */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$cancelRecording$1", f = "CameraViewModule.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, Promise promise, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new AnonymousClass1(this.$viewTag, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraViewModule cameraViewModule = CameraViewModule.this;
                int i2 = this.$viewTag;
                this.label = 1;
                obj = cameraViewModule.findCameraView(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            Promise promise = this.$promise;
            try {
                CameraView_RecordVideoKt.cancelRecording(cameraView);
                promise.resolve(null);
            } catch (Throwable th) {
                th.printStackTrace();
                CameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
                promise.reject(unknownCameraError.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void cancelRecording(int i, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new AnonymousClass1(i, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraViewModule$focus$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$focus$1", f = "CameraViewModule.kt", i = {1}, l = {183, 185}, m = "invokeSuspend", n = {"promise$iv"}, s = {"L$0"})
    static final class C03371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadableMap $point;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03371(int i, Promise promise, ReadableMap readableMap, Continuation<? super C03371> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
            this.$point = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C03371(this.$viewTag, this.$promise, this.$point, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0055  */
        /* JADX WARN: Code duplicated, block: B:30:0x0058  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            CameraView cameraView;
            Promise promise;
            ReadableMap readableMap;
            Promise promise2;
            CameraError unknownCameraError;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CameraViewModule cameraViewModule = CameraViewModule.this;
                    int i2 = this.$viewTag;
                    this.label = 1;
                    obj = cameraViewModule.findCameraView(i2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        promise2 = (Promise) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            promise2.resolve(null);
                        } catch (Throwable th) {
                            th = th;
                            promise = promise2;
                            th.printStackTrace();
                            if (th instanceof CameraError) {
                                unknownCameraError = th;
                            } else {
                                unknownCameraError = new UnknownCameraError(th);
                            }
                            promise.reject(unknownCameraError.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.L$0 = promise;
                this.label = 2;
                if (CameraView_FocusKt.focus(cameraView, readableMap, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                promise2 = promise;
                promise2.resolve(null);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                if (th instanceof CameraError) {
                    unknownCameraError = th;
                } else {
                    unknownCameraError = new UnknownCameraError(th);
                }
                promise.reject(unknownCameraError.getDomain() + RemoteSettings.FORWARD_SLASH_STRING + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            cameraView = (CameraView) obj;
            promise = this.$promise;
            readableMap = this.$point;
        }
    }

    @ReactMethod
    public final void focus(int i, @NotNull ReadableMap point, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C03371(i, promise, point, null), 3, null);
    }

    private final boolean canRequestPermission(String str) {
        ComponentCallbacks2 currentActivity = getReactApplicationContext().getCurrentActivity();
        PermissionAwareActivity permissionAwareActivity = currentActivity instanceof PermissionAwareActivity ? (PermissionAwareActivity) currentActivity : null;
        if (permissionAwareActivity != null) {
            return permissionAwareActivity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    private final PermissionStatus getPermission(String str) {
        PermissionStatus permissionStatusFromPermissionStatus = PermissionStatus.Companion.fromPermissionStatus(ContextCompat.checkSelfPermission(getReactApplicationContext(), str));
        return (permissionStatusFromPermissionStatus == PermissionStatus.DENIED && canRequestPermission(str)) ? PermissionStatus.NOT_DETERMINED : permissionStatusFromPermissionStatus;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getCameraPermissionStatus() {
        return getPermission("android.permission.CAMERA").getUnionValue();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getMicrophonePermissionStatus() {
        return getPermission("android.permission.RECORD_AUDIO").getUnionValue();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getLocationPermissionStatus() {
        PermissionStatus permission = getPermission(RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION);
        if (permission == PermissionStatus.GRANTED) {
            return permission.getUnionValue();
        }
        return getPermission(RNBackgroundGeolocationModule.ACCESS_COARSE_LOCATION).getUnionValue();
    }

    private final void requestPermission(String str, final Promise promise) {
        ComponentCallbacks2 currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity instanceof PermissionAwareActivity) {
            final int i = sharedRequestCode;
            sharedRequestCode = i + 1;
            ((PermissionAwareActivity) currentActivity).requestPermissions(new String[]{str}, i, new PermissionListener() { // from class: com.mrousavy.camera.react.CameraViewModule$$ExternalSyntheticLambda0
                @Override // com.facebook.react.modules.core.PermissionListener
                public final boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    return CameraViewModule.requestPermission$lambda$1(i, promise, i2, strArr, iArr);
                }
            });
            return;
        }
        promise.reject("NO_ACTIVITY", "No PermissionAwareActivity was found! Make sure the app has launched before calling this function.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean requestPermission$lambda$1(int i, Promise promise, int i2, String[] strArr, int[] grantResults) {
        Intrinsics.checkNotNullParameter(strArr, "<unused var>");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i2 != i) {
            return false;
        }
        promise.resolve(PermissionStatus.Companion.fromPermissionStatus(grantResults.length == 0 ? -1 : grantResults[0]).getUnionValue());
        return true;
    }

    @ReactMethod
    public final void requestCameraPermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        requestPermission("android.permission.CAMERA", promise);
    }

    @ReactMethod
    public final void requestMicrophonePermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        requestPermission("android.permission.RECORD_AUDIO", promise);
    }

    @ReactMethod
    public final void requestLocationPermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        requestPermission(RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object findCameraView(final int i, Continuation<? super CameraView> continuation) throws ViewNotFoundError {
        if (UiThreadUtil.isOnUiThread()) {
            Log.d("CameraView", "Finding view " + i + "...");
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            if (reactApplicationContext == null) {
                throw new Error("React Context was null!");
            }
            UIManager uIManager = UIManagerHelper.getUIManager(reactApplicationContext, 1);
            if (uIManager == null) {
                throw new Error("UIManager not found!");
            }
            View viewResolveView = uIManager.resolveView(i);
            CameraView cameraView = viewResolveView instanceof CameraView ? (CameraView) viewResolveView : null;
            if (cameraView == null) {
                throw new ViewNotFoundError(i);
            }
            Log.d("CameraView", "Found view " + i + "!");
            return cameraView;
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.react.CameraViewModule$findCameraView$$inlined$runOnUiThreadAndWait$1
            @Override // java.lang.Runnable
            public final void run() throws ViewNotFoundError {
                if (cancellableContinuationImpl.isCancelled()) {
                    throw new CancellationException();
                }
                Log.d("CameraView", "Finding view " + i + "...");
                ReactApplicationContext reactApplicationContext2 = this.getReactApplicationContext();
                if (reactApplicationContext2 == null) {
                    throw new Error("React Context was null!");
                }
                UIManager uIManager2 = UIManagerHelper.getUIManager(reactApplicationContext2, 1);
                if (uIManager2 == null) {
                    throw new Error("UIManager not found!");
                }
                View viewResolveView2 = uIManager2.resolveView(i);
                CameraView cameraView2 = viewResolveView2 instanceof CameraView ? (CameraView) viewResolveView2 : null;
                if (cameraView2 == null) {
                    throw new ViewNotFoundError(i);
                }
                Log.d("CameraView", "Found view " + i + "!");
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m5472constructorimpl(cameraView2));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
