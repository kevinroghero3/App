package com.mrousavy.camera.react;

import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.util.Log;
import androidx.camera.core.CameraInfo;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.common.util.concurrent.ListenableFuture;
import com.mrousavy.camera.core.CameraDeviceDetails;
import com.mrousavy.camera.core.CameraQueues;
import com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt;
import com.yalantis.ucrop.UCrop;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraDevicesManager extends ReactContextBaseJavaModule {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CameraDevices";
    private final CameraDevicesManager$callback$1 callback;
    private final CameraManager cameraManager;
    private ProcessCameraProvider cameraProvider;
    private final CoroutineScope coroutineScope;
    private final ExecutorService executor;
    private ExtensionsManager extensionsManager;
    private final ReactApplicationContext reactContext;

    @ReactMethod
    public final void addListener(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @ReactMethod
    public final void removeListeners(int i) {
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.mrousavy.camera.react.CameraDevicesManager$callback$1] */
    public CameraDevicesManager(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        ExecutorService cameraExecutor = CameraQueues.Companion.getCameraExecutor();
        this.executor = cameraExecutor;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(cameraExecutor));
        this.coroutineScope = CoroutineScope;
        Object systemService = reactContext.getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        this.cameraManager = (CameraManager) systemService;
        this.callback = new CameraManager.AvailabilityCallback() { // from class: com.mrousavy.camera.react.CameraDevicesManager$callback$1
            private List<String> deviceIds;

            {
                String[] cameraIdList = this.this$0.cameraManager.getCameraIdList();
                Intrinsics.checkNotNullExpressionValue(cameraIdList, "getCameraIdList(...)");
                this.deviceIds = ArraysKt___ArraysKt.toMutableList(cameraIdList);
            }

            private final boolean isDeviceConnected(String str) {
                try {
                    this.this$0.cameraManager.getCameraCharacteristics(str);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraAvailable(String cameraId) {
                Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                Log.i("CameraDevices", "Camera #" + cameraId + " is now available.");
                if (this.deviceIds.contains(cameraId)) {
                    return;
                }
                this.deviceIds.add(cameraId);
                this.this$0.sendAvailableDevicesChangedEvent();
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraUnavailable(String cameraId) {
                Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                Log.i("CameraDevices", "Camera #" + cameraId + " is now unavailable.");
                if (!this.deviceIds.contains(cameraId) || isDeviceConnected(cameraId)) {
                    return;
                }
                this.deviceIds.remove(cameraId);
                this.this$0.sendAvailableDevicesChangedEvent();
            }
        };
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraDevicesManager$1, reason: invalid class name */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraDevicesManager$1", f = "CameraDevicesManager.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL, UCrop.REQUEST_CROP}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraDevicesManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CameraDevicesManager cameraDevicesManager;
            CameraDevicesManager cameraDevicesManager2;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        cameraDevicesManager = (CameraDevicesManager) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        cameraDevicesManager2 = (CameraDevicesManager) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    cameraDevicesManager2.extensionsManager = (ExtensionsManager) obj;
                    Log.i(CameraDevicesManager.TAG, "Successfully initialized!");
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                Log.i(CameraDevicesManager.TAG, "Initializing ProcessCameraProvider...");
                cameraDevicesManager = CameraDevicesManager.this;
                ListenableFuture<ProcessCameraProvider> companion = ProcessCameraProvider.Companion.getInstance(cameraDevicesManager.reactContext);
                ExecutorService executorService = CameraDevicesManager.this.executor;
                this.L$0 = cameraDevicesManager;
                this.label = 1;
                obj = ListenableFuture_awaitKt.await(companion, executorService, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cameraDevicesManager.cameraProvider = (ProcessCameraProvider) obj;
                Log.i(CameraDevicesManager.TAG, "Initializing ExtensionsManager...");
                CameraDevicesManager cameraDevicesManager3 = CameraDevicesManager.this;
                ReactApplicationContext reactApplicationContext = cameraDevicesManager3.reactContext;
                ProcessCameraProvider processCameraProvider = CameraDevicesManager.this.cameraProvider;
                Intrinsics.checkNotNull(processCameraProvider);
                ListenableFuture<ExtensionsManager> instanceAsync = ExtensionsManager.getInstanceAsync(reactApplicationContext, processCameraProvider);
                Intrinsics.checkNotNullExpressionValue(instanceAsync, "getInstanceAsync(...)");
                ExecutorService executorService2 = CameraDevicesManager.this.executor;
                this.L$0 = cameraDevicesManager3;
                this.label = 2;
                Object objAwait = ListenableFuture_awaitKt.await(instanceAsync, executorService2, this);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cameraDevicesManager2 = cameraDevicesManager3;
                obj = objAwait;
                cameraDevicesManager2.extensionsManager = (ExtensionsManager) obj;
                Log.i(CameraDevicesManager.TAG, "Successfully initialized!");
                return Unit.INSTANCE;
            } catch (Throwable th) {
                SentryLogcatAdapter.e(CameraDevicesManager.TAG, "Failed to initialize ProcessCameraProvider/ExtensionsManager! Error: " + th.getMessage(), th);
            }
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        this.cameraManager.registerAvailabilityCallback(this.callback, (Handler) null);
        sendAvailableDevicesChangedEvent();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        this.cameraManager.unregisterAvailabilityCallback(this.callback);
        super.invalidate();
    }

    private final ReadableArray getDevicesJson() {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider == null) {
            Intrinsics.checkNotNull(writableArrayCreateArray);
            return writableArrayCreateArray;
        }
        ExtensionsManager extensionsManager = this.extensionsManager;
        if (extensionsManager == null) {
            Intrinsics.checkNotNull(writableArrayCreateArray);
            return writableArrayCreateArray;
        }
        Iterator<T> it2 = processCameraProvider.getAvailableCameraInfos().iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushMap(new CameraDeviceDetails((CameraInfo) it2.next(), extensionsManager).toMap());
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    public final void sendAvailableDevicesChangedEvent() {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("CameraDevicesChanged", getDevicesJson());
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        ReadableArray devicesJson = getDevicesJson();
        ReadableMap map = devicesJson.size() > 0 ? devicesJson.getMap(0) : null;
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("availableCameraDevices", devicesJson), TuplesKt.to("userPreferredCameraDevice", map != null ? map.toHashMap() : null));
    }
}
