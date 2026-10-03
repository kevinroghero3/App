package com.mrousavy.camera.react;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.CodeScannerOptions;
import com.mrousavy.camera.core.types.OutputOrientation;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.PreviewViewType;
import com.mrousavy.camera.core.types.QualityBalance;
import com.mrousavy.camera.core.types.ResizeMode;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.swmansion.rnscreens.Screen;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraViewManager extends ViewGroupManager<CameraView> {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "CameraView";

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public CameraView createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CameraView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull CameraView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.update();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(CameraViewReadyEvent.EVENT_NAME, MapBuilder.of("registrationName", "onViewReady")).put(CameraInitializedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onInitialized")).put(CameraStartedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onStarted")).put(CameraStoppedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onStopped")).put(CameraShutterEvent.EVENT_NAME, MapBuilder.of("registrationName", "onShutter")).put(CameraErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", "onError")).put(CameraCodeScannedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onCodeScanned")).put(CameraPreviewStartedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPreviewStarted")).put(CameraPreviewStoppedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPreviewStopped")).put(CameraOutputOrientationChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onOutputOrientationChanged")).put(CameraPreviewOrientationChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPreviewOrientationChanged")).put(AverageFpsChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onAverageFpsChanged")).build();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "CameraView";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NotNull CameraView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.destroy();
        super.onDropViewInstance(view);
    }

    @ReactProp(name = "cameraId")
    public final void setCameraId(@NotNull CameraView view, @NotNull String cameraId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        view.setCameraId(cameraId);
    }

    @ReactProp(name = "isMirrored")
    public final void setIsMirrored(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMirrored(z);
    }

    @ReactProp(defaultBoolean = true, name = "preview")
    public final void setPreview(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPreview(z);
    }

    @ReactProp(name = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO)
    public final void setPhoto(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPhoto(z);
    }

    @ReactProp(name = "video")
    public final void setVideo(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVideo(z);
    }

    @ReactProp(name = "audio")
    public final void setAudio(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAudio(z);
    }

    @ReactProp(name = "enableLocation")
    public final void setEnableLocation(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableLocation(z);
    }

    @ReactProp(name = "enableFrameProcessor")
    public final void setEnableFrameProcessor(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableFrameProcessor(z);
    }

    @ReactProp(name = "pixelFormat")
    public final void setPixelFormat(@NotNull CameraView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            view.setPixelFormat(PixelFormat.Companion.fromUnionValue(str));
        } else {
            view.setPixelFormat(PixelFormat.YUV);
        }
    }

    @ReactProp(name = "enableDepthData")
    public final void setEnableDepthData(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableDepthData(z);
    }

    @ReactProp(name = "enableZoomGesture")
    public final void setEnableZoomGesture(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableZoomGesture(z);
    }

    @ReactProp(name = "videoStabilizationMode")
    public final void setVideoStabilizationMode(@NotNull CameraView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            view.setVideoStabilizationMode(VideoStabilizationMode.Companion.fromUnionValue(str));
        } else {
            view.setVideoStabilizationMode(null);
        }
    }

    @ReactProp(name = "enablePortraitEffectsMatteDelivery")
    public final void setEnablePortraitEffectsMatteDelivery(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnablePortraitEffectsMatteDelivery(z);
    }

    @ReactProp(name = "format")
    public final void setFormat(@NotNull CameraView view, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableMap != null) {
            view.setFormat(CameraDeviceFormat.Companion.fromJSValue(readableMap));
        } else {
            view.setFormat(null);
        }
    }

    @ReactProp(name = ViewProps.RESIZE_MODE)
    public final void setResizeMode(@NotNull CameraView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            view.setResizeMode(ResizeMode.Companion.fromUnionValue(str));
        } else {
            view.setResizeMode(ResizeMode.COVER);
        }
    }

    @ReactProp(name = "androidPreviewViewType")
    public final void setAndroidPreviewViewType(@NotNull CameraView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            view.setAndroidPreviewViewType(PreviewViewType.Companion.fromUnionValue(str));
        } else {
            view.setAndroidPreviewViewType(PreviewViewType.SURFACE_VIEW);
        }
    }

    @ReactProp(defaultInt = -1, name = "minFps")
    public final void setMinFps(@NotNull CameraView view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMinFps(i > 0 ? Integer.valueOf(i) : null);
    }

    @ReactProp(defaultInt = -1, name = "maxFps")
    public final void setMaxFps(@NotNull CameraView view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMaxFps(i > 0 ? Integer.valueOf(i) : null);
    }

    @ReactProp(name = "photoHdr")
    public final void setPhotoHdr(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPhotoHdr(z);
    }

    @ReactProp(name = "photoQualityBalance")
    public final void setPhotoQualityBalance(@NotNull CameraView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            view.setPhotoQualityBalance(QualityBalance.Companion.fromUnionValue(str));
        } else {
            view.setPhotoQualityBalance(QualityBalance.BALANCED);
        }
    }

    @ReactProp(name = "videoHdr")
    public final void setVideoHdr(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVideoHdr(z);
    }

    @ReactProp(defaultDouble = Screen.SHEET_FIT_TO_CONTENTS, name = "videoBitRateOverride")
    public final void setVideoBitRateOverride(@NotNull CameraView view, double d) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (d != -1.0d) {
            view.setVideoBitRateOverride(Double.valueOf(d));
        } else {
            view.setVideoBitRateOverride(null);
        }
    }

    @ReactProp(defaultDouble = Screen.SHEET_FIT_TO_CONTENTS, name = "videoBitRateMultiplier")
    public final void setVideoBitRateMultiplier(@NotNull CameraView view, double d) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (d != -1.0d) {
            view.setVideoBitRateMultiplier(Double.valueOf(d));
        } else {
            view.setVideoBitRateMultiplier(null);
        }
    }

    @ReactProp(name = "lowLightBoost")
    public final void setLowLightBoost(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLowLightBoost(z);
    }

    @ReactProp(name = "isActive")
    public final void setIsActive(@NotNull CameraView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setActive(z);
    }

    @ReactProp(name = "torch")
    public final void setTorch(@NotNull CameraView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            view.setTorch(Torch.Companion.fromUnionValue(str));
        } else {
            view.setTorch(Torch.OFF);
        }
    }

    @ReactProp(name = "zoom")
    public final void setZoom(@NotNull CameraView view, double d) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setZoom((float) d);
    }

    @ReactProp(name = "exposure")
    public final void setExposure(@NotNull CameraView view, double d) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setExposure(d);
    }

    @ReactProp(name = "outputOrientation")
    public final void setOrientation(@NotNull CameraView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            view.setOutputOrientation(OutputOrientation.Companion.fromUnionValue(str));
        } else {
            view.setOutputOrientation(OutputOrientation.DEVICE);
        }
    }

    @ReactProp(name = "codeScannerOptions")
    public final void setCodeScanner(@NotNull CameraView view, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableMap != null) {
            view.setCodeScannerOptions(CodeScannerOptions.Companion.fromJSValue(readableMap));
        } else {
            view.setCodeScannerOptions(null);
        }
    }
}
