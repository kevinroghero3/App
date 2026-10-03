package com.mrousavy.camera.frameprocessors;

import android.util.Log;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.UIManagerHelper;
import com.mrousavy.camera.core.ViewNotFoundError;
import com.mrousavy.camera.react.CameraView;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class VisionCameraProxy {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "VisionCameraProxy";
    private WeakReference<ReactApplicationContext> mContext;
    private HybridData mHybridData;
    private VisionCameraScheduler mScheduler;
    private final ReactApplicationContext reactContext;

    private final native HybridData initHybrid(long j, CallInvokerHolderImpl callInvokerHolderImpl, VisionCameraScheduler visionCameraScheduler);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public VisionCameraProxy(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        CallInvokerHolder jSCallInvokerHolder = getContext().getCatalystInstance().getJSCallInvokerHolder();
        Intrinsics.checkNotNull(jSCallInvokerHolder, "null cannot be cast to non-null type com.facebook.react.turbomodule.core.CallInvokerHolderImpl");
        CallInvokerHolderImpl callInvokerHolderImpl = (CallInvokerHolderImpl) jSCallInvokerHolder;
        JavaScriptContextHolder javaScriptContextHolder = getContext().getJavaScriptContextHolder();
        if (javaScriptContextHolder == null) {
            throw new Error("JSI Runtime is null! VisionCamera does not yet support bridgeless mode..");
        }
        long j = javaScriptContextHolder.get();
        this.mScheduler = new VisionCameraScheduler();
        this.mContext = new WeakReference<>(getContext());
        this.mHybridData = initHybrid(j, callInvokerHolderImpl, this.mScheduler);
    }

    public final ReactApplicationContext getContext() {
        return this.reactContext;
    }

    private final CameraView findCameraViewById(int i) throws ViewNotFoundError {
        StringBuilder sb;
        String str;
        Log.d(TAG, "Finding view " + i + "...");
        ReactApplicationContext reactApplicationContext = this.mContext.get();
        CameraView cameraView = null;
        if (reactApplicationContext != null) {
            UIManager uIManager = UIManagerHelper.getUIManager(reactApplicationContext, i);
            cameraView = (CameraView) (uIManager != null ? uIManager.resolveView(i) : null);
        }
        if (cameraView != null) {
            sb = new StringBuilder();
            str = "Found view ";
        } else {
            sb = new StringBuilder();
            str = "Couldn't find view ";
        }
        sb.append(str);
        sb.append(i);
        sb.append("!");
        Log.d(TAG, sb.toString());
        if (cameraView != null) {
            return cameraView;
        }
        throw new ViewNotFoundError(i);
    }

    public final void setFrameProcessor(final int i, @NotNull final FrameProcessor frameProcessor) {
        Intrinsics.checkNotNullParameter(frameProcessor, "frameProcessor");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.frameprocessors.VisionCameraProxy$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VisionCameraProxy.setFrameProcessor$lambda$0(this.f$0, i, frameProcessor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFrameProcessor$lambda$0(VisionCameraProxy visionCameraProxy, int i, FrameProcessor frameProcessor) {
        visionCameraProxy.findCameraViewById(i).setFrameProcessor$react_native_vision_camera_release(frameProcessor);
    }

    public final void removeFrameProcessor(final int i) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.frameprocessors.VisionCameraProxy$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VisionCameraProxy.removeFrameProcessor$lambda$1(this.f$0, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeFrameProcessor$lambda$1(VisionCameraProxy visionCameraProxy, int i) {
        visionCameraProxy.findCameraViewById(i).setFrameProcessor$react_native_vision_camera_release(null);
    }

    public final FrameProcessorPlugin initFrameProcessorPlugin(@NotNull String name, @NotNull Map<String, ? extends Object> options) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(options, "options");
        return FrameProcessorPluginRegistry.getPlugin(name, this, options);
    }
}
