package com.captureprotection;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import com.captureprotection.constants.CaptureEventType;
import com.captureprotection.constants.Constants;
import com.captureprotection.utils.FileUtils;
import com.captureprotection.utils.ModuleThread;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = "CaptureProtection")
public final class CaptureProtectionModule extends CaptureProtectionModuleSpec implements LifecycleEventListener {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "CaptureProtection";
    public static final String SUPPORT_UNDER_TIRAMISU_CAPTURE_CALLBACK = "callbackTiramisu";
    private static ContentObserver contentObserver;
    private static DisplayManager.DisplayListener displayListener;
    private static ReactApplicationContext reactContext;
    private static Method registerScreenCaptureCallback;
    private static Object screenCaptureCallback;
    private static Method unregisterScreenCaptureCallback;
    private final DisplayManager displayManager;
    private Job eventJob;
    private final ReactApplicationContext reactContext$1;
    private final ArrayList<Integer> screens;

    private final boolean checkPermission() {
        return false;
    }

    private final void requestPermission() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.captureprotection.CaptureProtectionModuleSpec
    @ReactMethod
    public void removeListeners(double d) {
    }

    public final boolean requestStoragePermission() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureProtectionModule(@NotNull ReactApplicationContext reactContext2) {
        super(reactContext2);
        Intrinsics.checkNotNullParameter(reactContext2, "reactContext");
        this.reactContext$1 = reactContext2;
        Object systemService = reactContext2.getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        DisplayManager displayManager = (DisplayManager) systemService;
        this.displayManager = displayManager;
        this.screens = new ArrayList<>();
        if (!Intrinsics.areEqual(reactContext, reactContext2)) {
            screenCaptureCallback = null;
        }
        reflectionCallback();
        registerDisplayListener();
        DisplayManager.DisplayListener displayListener2 = displayListener;
        if (displayListener2 != null) {
            try {
                displayManager.unregisterDisplayListener(displayListener2);
            } catch (Exception unused) {
            }
        }
        this.displayManager.registerDisplayListener(displayListener, ModuleThread.Companion.getMainHandler());
        ReactApplicationContext reactApplicationContext = this.reactContext$1;
        reactContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "CaptureProtection";
    }

    public final DisplayManager getDisplayManager() {
        return this.displayManager;
    }

    public final ArrayList<Integer> getScreens() {
        return this.screens;
    }

    public final Activity getReactCurrentActivity() {
        return ActivityUtils.Companion.getReactCurrentActivity(this.reactContext$1);
    }

    public final Job getEventJob() {
        return this.eventJob;
    }

    public final void setEventJob(@Nullable Job job) {
        this.eventJob = job;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object getScreenCaptureCallback() {
            return CaptureProtectionModule.screenCaptureCallback;
        }

        public final void setScreenCaptureCallback(@Nullable Object obj) {
            CaptureProtectionModule.screenCaptureCallback = obj;
        }

        public final Method getRegisterScreenCaptureCallback() {
            return CaptureProtectionModule.registerScreenCaptureCallback;
        }

        public final void setRegisterScreenCaptureCallback(@Nullable Method method) {
            CaptureProtectionModule.registerScreenCaptureCallback = method;
        }

        public final Method getUnregisterScreenCaptureCallback() {
            return CaptureProtectionModule.unregisterScreenCaptureCallback;
        }

        public final void setUnregisterScreenCaptureCallback(@Nullable Method method) {
            CaptureProtectionModule.unregisterScreenCaptureCallback = method;
        }

        public final ContentObserver getContentObserver() {
            return CaptureProtectionModule.contentObserver;
        }

        public final void setContentObserver(@Nullable ContentObserver contentObserver) {
            CaptureProtectionModule.contentObserver = contentObserver;
        }

        public final DisplayManager.DisplayListener getDisplayListener() {
            return CaptureProtectionModule.displayListener;
        }

        public final void setDisplayListener(@Nullable DisplayManager.DisplayListener displayListener) {
            CaptureProtectionModule.displayListener = displayListener;
        }

        public final ReactApplicationContext getReactContext() {
            return CaptureProtectionModule.reactContext;
        }

        public final void setReactContext(@Nullable ReactApplicationContext reactApplicationContext) {
            CaptureProtectionModule.reactContext = reactApplicationContext;
        }
    }

    public final void reflectionCallback() {
        if (Build.VERSION.SDK_INT >= 34 && getReactCurrentActivity() != null) {
            if (registerScreenCaptureCallback == null) {
                Reflection.Companion companion = Reflection.Companion;
                Activity reactCurrentActivity = getReactCurrentActivity();
                Intrinsics.checkNotNull(reactCurrentActivity);
                registerScreenCaptureCallback = companion.getMethod(reactCurrentActivity.getClass(), "registerScreenCaptureCallback");
            }
            if (unregisterScreenCaptureCallback == null) {
                Reflection.Companion companion2 = Reflection.Companion;
                Activity reactCurrentActivity2 = getReactCurrentActivity();
                Intrinsics.checkNotNull(reactCurrentActivity2);
                unregisterScreenCaptureCallback = companion2.getMethod(reactCurrentActivity2.getClass(), "unregisterScreenCaptureCallback");
            }
            if (screenCaptureCallback == null || !Intrinsics.areEqual(reactContext, this.reactContext$1)) {
                screenCaptureCallback = Reflection.Companion.createScreenCaptureCallback(new Function0() { // from class: com.captureprotection.CaptureProtectionModule$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CaptureProtectionModule.reflectionCallback$lambda$0(this.f$0);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reflectionCallback$lambda$0(CaptureProtectionModule captureProtectionModule) {
        captureProtectionModule.triggerCaptureEvent(CaptureEventType.CAPTURED);
        return Unit.INSTANCE;
    }

    public final void triggerCaptureEvent(@NotNull CaptureEventType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Job job = this.eventJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.eventJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C03121(type, null), 3, null);
    }

    /* JADX INFO: renamed from: com.captureprotection.CaptureProtectionModule$triggerCaptureEvent$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.captureprotection.CaptureProtectionModule$triggerCaptureEvent$1", f = "CaptureProtectionModule.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class C03121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CaptureEventType $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03121(CaptureEventType captureEventType, Continuation<? super C03121> continuation) {
            super(2, continuation);
            this.$type = captureEventType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureProtectionModule.this.new C03121(this.$type, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Response.Companion.sendEvent(CaptureProtectionModule.this.reactContext$1, Constants.LISTENER_EVENT_NAME, this.$type.getValue());
                    this.label = 1;
                    if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (!CaptureProtectionModule.this.getScreens().isEmpty()) {
                    Response.Companion.sendEvent(CaptureProtectionModule.this.reactContext$1, Constants.LISTENER_EVENT_NAME, CaptureEventType.RECORDING.getValue());
                } else {
                    Response.Companion.sendEvent(CaptureProtectionModule.this.reactContext$1, Constants.LISTENER_EVENT_NAME, CaptureEventType.NONE.getValue());
                }
            } catch (Exception e) {
                SentryLogcatAdapter.e("CaptureProtection", "Error in triggerCaptureEvent: " + e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    public final void registerDisplayListener() {
        if (displayListener == null || !Intrinsics.areEqual(reactContext, this.reactContext$1)) {
            displayListener = new C03111();
        }
    }

    /* JADX INFO: renamed from: com.captureprotection.CaptureProtectionModule$registerDisplayListener$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03111 implements DisplayManager.DisplayListener {
        C03111() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(final int i) {
            Activity reactCurrentActivity = CaptureProtectionModule.this.getReactCurrentActivity();
            if (reactCurrentActivity != null) {
                final CaptureProtectionModule captureProtectionModule = CaptureProtectionModule.this;
                reactCurrentActivity.runOnUiThread(new Runnable() { // from class: com.captureprotection.CaptureProtectionModule$registerDisplayListener$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CaptureProtectionModule.C03111.onDisplayAdded$lambda$0(captureProtectionModule, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDisplayAdded$lambda$0(CaptureProtectionModule captureProtectionModule, int i) {
            if (captureProtectionModule.getDisplayManager().getDisplay(i) != null) {
                captureProtectionModule.getScreens().add(Integer.valueOf(i));
            }
            try {
                Response.Companion.sendEvent(captureProtectionModule.reactContext$1, Constants.LISTENER_EVENT_NAME, captureProtectionModule.getScreens().isEmpty() ? CaptureEventType.NONE.getValue() : CaptureEventType.RECORDING.getValue());
                Log.d("CaptureProtection", "=> display add event " + i);
            } catch (Exception e) {
                SentryLogcatAdapter.e("CaptureProtection", "display add event Error with displayId: " + i + ", error: " + e.getMessage());
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(final int i) {
            Activity reactCurrentActivity = CaptureProtectionModule.this.getReactCurrentActivity();
            if (reactCurrentActivity != null) {
                final CaptureProtectionModule captureProtectionModule = CaptureProtectionModule.this;
                reactCurrentActivity.runOnUiThread(new Runnable() { // from class: com.captureprotection.CaptureProtectionModule$registerDisplayListener$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        CaptureProtectionModule.C03111.onDisplayRemoved$lambda$1(captureProtectionModule, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDisplayRemoved$lambda$1(CaptureProtectionModule captureProtectionModule, int i) {
            int iIndexOf = captureProtectionModule.getScreens().indexOf(Integer.valueOf(i));
            if (iIndexOf > -1) {
                captureProtectionModule.getScreens().remove(iIndexOf);
            }
            try {
                if (captureProtectionModule.getScreens().isEmpty()) {
                    captureProtectionModule.triggerCaptureEvent(CaptureEventType.END_RECORDING);
                } else {
                    Response.Companion.sendEvent(captureProtectionModule.reactContext$1, Constants.LISTENER_EVENT_NAME, CaptureEventType.RECORDING.getValue());
                }
                Log.d("CaptureProtection", "=> display remove event " + i);
            } catch (Exception e) {
                SentryLogcatAdapter.e("CaptureProtection", "display remove event Error with displayId: " + i + ", error: " + e.getMessage());
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            Log.d("CaptureProtection", "=> display change event " + i);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        try {
            reflectionCallback();
            Method method = registerScreenCaptureCallback;
            if (method != null) {
                method.invoke(getReactCurrentActivity(), ModuleThread.Companion.getMainExecutor(), screenCaptureCallback);
            }
        } catch (Exception e) {
            SentryLogcatAdapter.e("CaptureProtection", "onHostResume has raise Exception: " + e.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004b A[PHI: r2
  0x004b: PHI (r2v6 kotlinx.coroutines.Job) = (r2v3 kotlinx.coroutines.Job), (r2v8 kotlinx.coroutines.Job) binds: [B:20:0x0049, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        Job job;
        try {
            Method method = unregisterScreenCaptureCallback;
            if (method != null) {
                method.invoke(getReactCurrentActivity(), screenCaptureCallback);
            }
            try {
                DisplayManager.DisplayListener displayListener2 = displayListener;
                if (displayListener2 != null) {
                    this.displayManager.unregisterDisplayListener(displayListener2);
                }
            } catch (Exception unused) {
            }
            job = this.eventJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        } catch (Exception e) {
            SentryLogcatAdapter.e("CaptureProtection", "onHostDestroy has raise Exception: " + e.getLocalizedMessage());
            try {
                DisplayManager.DisplayListener displayListener3 = displayListener;
                if (displayListener3 != null) {
                    this.displayManager.unregisterDisplayListener(displayListener3);
                }
            } catch (Exception unused2) {
            }
            job = this.eventJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        } finally {
            try {
                DisplayManager.DisplayListener displayListener4 = displayListener;
                if (displayListener4 != null) {
                    this.displayManager.unregisterDisplayListener(displayListener4);
                }
            } catch (Exception unused3) {
            }
            Job job2 = this.eventJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.screens.clear();
        }
    }

    public final boolean checkStoragePermission() {
        if (registerScreenCaptureCallback != null) {
            return true;
        }
        return checkPermission();
    }

    public final void addScreenCaptureListener() {
        reflectionCallback();
        if (registerScreenCaptureCallback == null && contentObserver == null && checkStoragePermission()) {
            contentObserver = new ContentObserver(ModuleThread.Companion.getMainHandler()) { // from class: com.captureprotection.CaptureProtectionModule.addScreenCaptureListener.1
                @Override // android.database.ContentObserver
                public void onChange(boolean z, Uri uri) {
                    FileUtils.Companion companion = FileUtils.Companion;
                    if (companion.isImageUri(uri)) {
                        ReactApplicationContext reactApplicationContext = CaptureProtectionModule.this.reactContext$1;
                        Intrinsics.checkNotNull(uri);
                        if (companion.isScreenshotFile(reactApplicationContext, uri)) {
                            Log.d("CaptureProtection", "CaptureProtectionModule.contentObserver detect screenshot file");
                            CaptureProtectionModule.this.triggerCaptureEvent(CaptureEventType.CAPTURED);
                        }
                    }
                    super.onChange(z, uri);
                }
            };
            ContentResolver contentResolver = this.reactContext$1.getContentResolver();
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentObserver contentObserver2 = contentObserver;
            Intrinsics.checkNotNull(contentObserver2);
            contentResolver.registerContentObserver(uri, true, contentObserver2);
        }
    }

    public final void removeScreenCaptureListener() {
        ContentObserver contentObserver2 = contentObserver;
        if (contentObserver2 != null) {
            try {
                this.reactContext$1.getContentResolver().unregisterContentObserver(contentObserver2);
            } catch (Exception unused) {
            } finally {
                contentObserver = null;
            }
        }
    }

    public final boolean hasScreenCaptureListener() {
        return (contentObserver == null && registerScreenCaptureCallback == null) ? false : true;
    }

    public final boolean hasScreenRecordListener() {
        return displayListener != null;
    }

    @Override // com.captureprotection.CaptureProtectionModuleSpec
    @ReactMethod
    public void addListener(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        addScreenCaptureListener();
    }

    @Override // com.captureprotection.CaptureProtectionModuleSpec
    @ReactMethod
    public void hasListener(@NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (getReactCurrentActivity() == null) {
            promise.reject("hasListener", new RuntimeException("Activity is null"));
            return;
        }
        Activity reactCurrentActivity = getReactCurrentActivity();
        if (reactCurrentActivity != null) {
            reactCurrentActivity.runOnUiThread(new Runnable() { // from class: com.captureprotection.CaptureProtectionModule$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureProtectionModule.hasListener$lambda$8(this.f$0, promise);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hasListener$lambda$8(CaptureProtectionModule captureProtectionModule, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(captureProtectionModule.hasScreenCaptureListener()));
        } catch (Exception e) {
            promise.reject("hasListener", e);
        }
    }

    @Override // com.captureprotection.CaptureProtectionModuleSpec
    @ReactMethod
    public void isScreenRecording(@NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (getReactCurrentActivity() == null) {
            promise.reject("isScreenRecording", new RuntimeException("Activity is null"));
            return;
        }
        Activity reactCurrentActivity = getReactCurrentActivity();
        if (reactCurrentActivity != null) {
            reactCurrentActivity.runOnUiThread(new Runnable() { // from class: com.captureprotection.CaptureProtectionModule$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureProtectionModule.isScreenRecording$lambda$9(promise, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isScreenRecording$lambda$9(Promise promise, CaptureProtectionModule captureProtectionModule) {
        try {
            boolean z = true;
            if (captureProtectionModule.screens.size() <= 1) {
                z = false;
            }
            promise.resolve(Boolean.valueOf(z));
        } catch (Exception e) {
            promise.reject("isScreenRecording", e);
        }
    }

    @Override // com.captureprotection.CaptureProtectionModuleSpec
    @ReactMethod
    public void prevent(@NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (getReactCurrentActivity() == null) {
            promise.reject("prevent", new RuntimeException("Activity is null"));
            return;
        }
        Activity reactCurrentActivity = getReactCurrentActivity();
        if (reactCurrentActivity != null) {
            reactCurrentActivity.runOnUiThread(new Runnable() { // from class: com.captureprotection.CaptureProtectionModule$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureProtectionModule.prevent$lambda$10(this.f$0, promise);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prevent$lambda$10(CaptureProtectionModule captureProtectionModule, Promise promise) {
        try {
            Activity reactCurrentActivity = ActivityUtils.Companion.getReactCurrentActivity(captureProtectionModule.reactContext$1);
            Intrinsics.checkNotNull(reactCurrentActivity);
            reactCurrentActivity.getWindow().addFlags(8192);
            Response.Companion.sendEvent(captureProtectionModule.reactContext$1, Constants.LISTENER_EVENT_NAME, CaptureEventType.PREVENT_SCREEN_CAPTURE.getValue() + CaptureEventType.PREVENT_SCREEN_RECORDING.getValue() + CaptureEventType.PREVENT_SCREEN_APP_SWITCHING.getValue());
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject("prevent", e);
        }
    }

    @Override // com.captureprotection.CaptureProtectionModuleSpec
    @ReactMethod
    public void allow(@NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (getReactCurrentActivity() == null) {
            promise.reject("allow", new RuntimeException("Activity is null"));
            return;
        }
        Activity reactCurrentActivity = getReactCurrentActivity();
        if (reactCurrentActivity != null) {
            reactCurrentActivity.runOnUiThread(new Runnable() { // from class: com.captureprotection.CaptureProtectionModule$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureProtectionModule.allow$lambda$11(this.f$0, promise);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void allow$lambda$11(CaptureProtectionModule captureProtectionModule, Promise promise) {
        try {
            Activity reactCurrentActivity = ActivityUtils.Companion.getReactCurrentActivity(captureProtectionModule.reactContext$1);
            Intrinsics.checkNotNull(reactCurrentActivity);
            reactCurrentActivity.getWindow().clearFlags(8192);
            Response.Companion.sendEvent(captureProtectionModule.reactContext$1, Constants.LISTENER_EVENT_NAME, CaptureEventType.ALLOW.getValue());
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject("allow", e);
        }
    }

    @Override // com.captureprotection.CaptureProtectionModuleSpec
    @ReactMethod
    public void protectionStatus(@NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (getReactCurrentActivity() == null) {
            promise.reject("protectionStatus", new RuntimeException("Activity is null"));
            return;
        }
        Activity reactCurrentActivity = getReactCurrentActivity();
        if (reactCurrentActivity != null) {
            reactCurrentActivity.runOnUiThread(new Runnable() { // from class: com.captureprotection.CaptureProtectionModule$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureProtectionModule.protectionStatus$lambda$12(this.f$0, promise);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void protectionStatus$lambda$12(CaptureProtectionModule captureProtectionModule, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(ActivityUtils.Companion.isSecureFlag(captureProtectionModule.reactContext$1)));
        } catch (Exception e) {
            promise.reject("protectionStatus", e);
        }
    }

    @Override // com.captureprotection.CaptureProtectionModuleSpec
    @ReactMethod
    public void requestPermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(requestStoragePermission()));
    }

    @Override // com.captureprotection.CaptureProtectionModuleSpec
    @ReactMethod
    public void checkPermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(checkStoragePermission()));
    }
}
