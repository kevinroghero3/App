package com.mrousavy.camera.core;

import android.content.Context;
import android.util.Log;
import android.util.Range;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.ZoomState;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.lifecycle.Lifecycle;
import com.mrousavy.camera.core.extensions.CameraInfo_idKt;
import com.mrousavy.camera.core.extensions.CameraSelector_byIdKt;
import com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt;
import com.mrousavy.camera.core.extensions.DynamicRange_isSDRKt;
import com.mrousavy.camera.core.extensions.ImageAnalysis_Builder_setTargetFrameRateKt;
import com.mrousavy.camera.core.extensions.ResolutionSelector_forSizeKt;
import com.mrousavy.camera.core.extensions.StateError_toCameraErrorKt;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.mrousavy.camera.core.utils.CamcorderProfileUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.time.DurationKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraSession_ConfigurationKt {

    /* JADX INFO: renamed from: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureCamera$1, reason: invalid class name */
    @DebugMetadata(c = "com.mrousavy.camera.core.CameraSession_ConfigurationKt", f = "CameraSession+Configuration.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {259, 271}, m = "configureCamera", n = {"$this$configureCamera", "provider", "configuration", "useCases", "isStreamingHDR", "needsImageAnalysis", "enableHdrExtension", "$this$configureCamera", "provider", "configuration", "useCases"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSession_ConfigurationKt.configureCamera(null, null, null, this);
        }
    }

    private static final void assertFormatRequirement(String str, CameraDeviceFormat cameraDeviceFormat, CameraError cameraError, Function1<? super CameraDeviceFormat, Boolean> function1) throws CameraError {
        if (cameraDeviceFormat == null) {
            throw new PropRequiresFormatToBeNonNullError(str);
        }
        if (!function1.invoke(cameraDeviceFormat).booleanValue()) {
            throw cameraError;
        }
    }

    public static final void configureOutputs(@NotNull CameraSession cameraSession, @NotNull final CameraConfiguration configuration) throws CameraError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        String cameraId = configuration.getCameraId();
        Intrinsics.checkNotNull(cameraId);
        Log.i(CameraSession.TAG, "Creating new Outputs for Camera #" + cameraId + "...");
        final Range<Integer> targetFpsRange = configuration.getTargetFpsRange();
        CameraDeviceFormat format = configuration.getFormat();
        Log.i(CameraSession.TAG, "Using FPS Range: " + targetFpsRange);
        CameraConfiguration.Output<CameraConfiguration.Photo> photo = configuration.getPhoto();
        CameraConfiguration.Output.Enabled enabled = photo instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) photo : null;
        CameraConfiguration.Output<CameraConfiguration.Video> video = configuration.getVideo();
        CameraConfiguration.Output.Enabled enabled2 = video instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) video : null;
        CameraConfiguration.Output<CameraConfiguration.Preview> preview = configuration.getPreview();
        CameraConfiguration.Output.Enabled enabled3 = preview instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) preview : null;
        if (enabled3 != null) {
            Log.i(CameraSession.TAG, "Creating Preview output...");
            Preview.Builder builder = new Preview.Builder();
            if (configuration.getVideoStabilizationMode().isAtLeast(VideoStabilizationMode.CINEMATIC)) {
                assertFormatRequirement("videoStabilizationMode", format, new InvalidVideoStabilizationMode(configuration.getVideoStabilizationMode()), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$2$lambda$0(configuration, (CameraDeviceFormat) obj));
                    }
                });
                builder.setPreviewStabilizationEnabled(true);
            }
            if (targetFpsRange != null) {
                Object upper = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(((Number) upper).intValue()), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$2$lambda$1(targetFpsRange, (CameraDeviceFormat) obj));
                    }
                });
                builder.setTargetFrameRate(targetFpsRange);
            }
            if (format != null) {
                ResolutionSelector resolutionSelectorBuild = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), enabled2 != null ? format.getVideoSize() : format.getPhotoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild, "build(...)");
                builder.setResolutionSelector(resolutionSelectorBuild);
            }
            Preview previewBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(previewBuild, "build(...)");
            previewBuild.setSurfaceProvider(((CameraConfiguration.Preview) enabled3.getConfig()).getSurfaceProvider());
            cameraSession.setPreviewOutput$react_native_vision_camera_release(previewBuild);
        } else {
            cameraSession.setPreviewOutput$react_native_vision_camera_release(null);
        }
        if (enabled != null) {
            Log.i(CameraSession.TAG, "Creating Photo output...");
            ImageCapture.Builder builder2 = new ImageCapture.Builder();
            builder2.setCaptureMode(((CameraConfiguration.Photo) enabled.getConfig()).getPhotoQualityBalance().toCaptureMode());
            if (format != null) {
                Log.i(CameraSession.TAG, "Photo size: " + format.getPhotoSize());
                ResolutionSelector resolutionSelectorBuild2 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getPhotoSize()).setAllowedResolutionMode(1).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild2, "build(...)");
                builder2.setResolutionSelector(resolutionSelectorBuild2);
            }
            ImageCapture imageCaptureBuild = builder2.build();
            Intrinsics.checkNotNullExpressionValue(imageCaptureBuild, "build(...)");
            cameraSession.setPhotoOutput$react_native_vision_camera_release(imageCaptureBuild);
        } else {
            cameraSession.setPhotoOutput$react_native_vision_camera_release(null);
        }
        if (enabled2 != null) {
            Log.i(CameraSession.TAG, "Creating Video output...");
            Recorder recorderOutput$react_native_vision_camera_release = cameraSession.getRecorderOutput$react_native_vision_camera_release();
            if (cameraSession.getRecording$react_native_vision_camera_release() != null && recorderOutput$react_native_vision_camera_release != null) {
                Log.i(CameraSession.TAG, "Re-using active Recorder because we are currently recording...");
            } else {
                Log.i(CameraSession.TAG, "Creating new Recorder...");
                Recorder.Builder builder3 = new Recorder.Builder();
                if (format != null) {
                    builder3.setQualitySelector(format.getVideoQualitySelector());
                }
                Double bitRateOverride = ((CameraConfiguration.Video) enabled2.getConfig()).getBitRateOverride();
                if (bitRateOverride != null) {
                    builder3.setTargetVideoEncodingBitRate((int) (bitRateOverride.doubleValue() * ((double) DurationKt.NANOS_IN_MILLIS)));
                }
                Double bitRateMultiplier = ((CameraConfiguration.Video) enabled2.getConfig()).getBitRateMultiplier();
                if (bitRateMultiplier != null) {
                    double dDoubleValue = bitRateMultiplier.doubleValue();
                    if (format == null) {
                        throw new PropRequiresFormatToBeNonNullError("videoBitRate");
                    }
                    Integer recommendedBitRate = CamcorderProfileUtils.Companion.getRecommendedBitRate(cameraId, format.getVideoSize());
                    if (recommendedBitRate != null) {
                        builder3.setTargetVideoEncodingBitRate((int) (((double) recommendedBitRate.intValue()) * dDoubleValue));
                    }
                }
                recorderOutput$react_native_vision_camera_release = builder3.build();
                Intrinsics.checkNotNull(recorderOutput$react_native_vision_camera_release);
            }
            VideoCapture.Builder builder4 = new VideoCapture.Builder(recorderOutput$react_native_vision_camera_release);
            if (((CameraConfiguration.Video) enabled2.getConfig()).isMirrored()) {
                builder4.setMirrorMode(1);
            } else {
                builder4.setMirrorMode(0);
            }
            if (configuration.getVideoStabilizationMode().isAtLeast(VideoStabilizationMode.STANDARD)) {
                assertFormatRequirement("videoStabilizationMode", format, new InvalidVideoStabilizationMode(configuration.getVideoStabilizationMode()), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$11$lambda$8(configuration, (CameraDeviceFormat) obj));
                    }
                });
                builder4.setVideoStabilizationEnabled(true);
            }
            if (targetFpsRange != null) {
                Object upper2 = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper2, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(((Number) upper2).intValue()), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$11$lambda$9(targetFpsRange, (CameraDeviceFormat) obj));
                    }
                });
                builder4.setTargetFrameRate(targetFpsRange);
            }
            if (((CameraConfiguration.Video) enabled2.getConfig()).getEnableHdr()) {
                assertFormatRequirement("videoHdr", format, new InvalidVideoHdrError(), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$11$lambda$10((CameraDeviceFormat) obj));
                    }
                });
                builder4.setDynamicRange(DynamicRange.HDR_UNSPECIFIED_10_BIT);
            }
            if (format != null) {
                Log.i(CameraSession.TAG, "Video size: " + format.getVideoSize());
                ResolutionSelector resolutionSelectorBuild3 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getVideoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild3, "build(...)");
                builder4.setResolutionSelector(resolutionSelectorBuild3);
            }
            VideoCapture<Recorder> videoCaptureBuild = builder4.build();
            Intrinsics.checkNotNullExpressionValue(videoCaptureBuild, "build(...)");
            cameraSession.setVideoOutput$react_native_vision_camera_release(videoCaptureBuild);
            cameraSession.setRecorderOutput$react_native_vision_camera_release(recorderOutput$react_native_vision_camera_release);
        } else {
            cameraSession.setVideoOutput$react_native_vision_camera_release(null);
            cameraSession.setRecorderOutput$react_native_vision_camera_release(null);
        }
        CameraConfiguration.Output<CameraConfiguration.FrameProcessor> frameProcessor = configuration.getFrameProcessor();
        CameraConfiguration.Output.Enabled enabled4 = frameProcessor instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) frameProcessor : null;
        if (enabled4 != null) {
            PixelFormat pixelFormat = ((CameraConfiguration.FrameProcessor) enabled4.getConfig()).getPixelFormat();
            Log.i(CameraSession.TAG, "Creating " + pixelFormat + " Frame Processor output...");
            ImageAnalysis.Builder builder5 = new ImageAnalysis.Builder();
            builder5.setBackpressureStrategy(1);
            builder5.setOutputImageFormat(pixelFormat.toImageAnalysisFormat());
            if (targetFpsRange != null) {
                Object upper3 = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper3, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(((Number) upper3).intValue()), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$13$lambda$12(targetFpsRange, (CameraDeviceFormat) obj));
                    }
                });
                ImageAnalysis_Builder_setTargetFrameRateKt.setTargetFrameRate(builder5, targetFpsRange);
            }
            if (format != null) {
                Log.i(CameraSession.TAG, "Frame Processor size: " + format.getVideoSize());
                ResolutionSelector resolutionSelectorBuild4 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getVideoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild4, "build(...)");
                builder5.setResolutionSelector(resolutionSelectorBuild4);
            }
            ImageAnalysis imageAnalysisBuild = builder5.build();
            Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "build(...)");
            imageAnalysisBuild.setAnalyzer(CameraQueues.Companion.getVideoQueue().getExecutor(), new FrameProcessorPipeline(cameraSession.getCallback$react_native_vision_camera_release()));
            cameraSession.setFrameProcessorOutput$react_native_vision_camera_release(imageAnalysisBuild);
        } else {
            cameraSession.setFrameProcessorOutput$react_native_vision_camera_release(null);
        }
        CameraConfiguration.Output<CameraConfiguration.CodeScanner> codeScanner = configuration.getCodeScanner();
        CameraConfiguration.Output.Enabled enabled5 = codeScanner instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) codeScanner : null;
        if (enabled5 != null) {
            Log.i(CameraSession.TAG, "Creating CodeScanner output...");
            ImageAnalysis imageAnalysisBuild2 = new ImageAnalysis.Builder().build();
            Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild2, "build(...)");
            imageAnalysisBuild2.setAnalyzer(CameraQueues.Companion.getAnalyzerExecutor(), new CodeScannerPipeline((CameraConfiguration.CodeScanner) enabled5.getConfig(), cameraSession.getCallback$react_native_vision_camera_release()));
            cameraSession.setCodeScannerOutput$react_native_vision_camera_release(imageAnalysisBuild2);
        } else {
            cameraSession.setCodeScannerOutput$react_native_vision_camera_release(null);
        }
        Log.i(CameraSession.TAG, "Successfully created new Outputs for Camera #" + configuration.getCameraId() + "!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$2$lambda$0(CameraConfiguration cameraConfiguration, CameraDeviceFormat it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.getVideoStabilizationModes().contains(cameraConfiguration.getVideoStabilizationMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$2$lambda$1(Range range, CameraDeviceFormat it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return ((double) ((Number) range.getLower()).intValue()) >= it2.getMinFps() && ((double) ((Number) range.getUpper()).intValue()) <= it2.getMaxFps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$11$lambda$8(CameraConfiguration cameraConfiguration, CameraDeviceFormat it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.getVideoStabilizationModes().contains(cameraConfiguration.getVideoStabilizationMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$11$lambda$9(Range range, CameraDeviceFormat it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return ((double) ((Number) range.getLower()).intValue()) >= it2.getMinFps() && ((double) ((Number) range.getUpper()).intValue()) <= it2.getMaxFps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$11$lambda$10(CameraDeviceFormat it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.getSupportsVideoHdr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$13$lambda$12(Range range, CameraDeviceFormat it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return ((double) ((Number) range.getLower()).intValue()) >= it2.getMinFps() && ((double) ((Number) range.getUpper()).intValue()) <= it2.getMaxFps();
    }

    /* JADX WARN: Code duplicated, block: B:60:0x019d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x019f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:64:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:68:0x01c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:75:0x01df  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code duplicated, block: B:80:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:83:0x0206  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object configureCamera(@NotNull CameraSession cameraSession, @NotNull ProcessCameraProvider processCameraProvider, @NotNull CameraConfiguration cameraConfiguration, @NotNull Continuation<? super Unit> continuation) throws NoCameraDeviceError, PhotoHdrAndVideoHdrNotSupportedSimultaneously, LowLightBoostNotSupportedWithHdr, NoOutputsError {
        AnonymousClass1 anonymousClass1;
        CameraSelector cameraSelectorBuild;
        int i;
        int i2;
        int i3;
        int i4;
        List<? extends UseCase> list;
        CameraConfiguration cameraConfiguration2;
        final CameraSession cameraSession2;
        ProcessCameraProvider processCameraProvider2;
        CameraSession cameraSession3;
        ProcessCameraProvider processCameraProvider3;
        List<? extends UseCase> list2;
        CameraConfiguration cameraConfiguration3;
        int i5;
        int i6;
        int i7;
        boolean z;
        List<? extends UseCase> list3;
        CameraConfiguration cameraConfiguration4;
        Object objWithExtension;
        ProcessCameraProvider processCameraProvider4;
        CameraConfiguration cameraConfiguration5;
        List<? extends UseCase> list4;
        CameraSession cameraSession4;
        Camera camera$react_native_vision_camera_release;
        String id;
        CameraInfo cameraInfo;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i8 = anonymousClass1.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i8 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = anonymousClass1.label;
        if (i9 != 0) {
            if (i9 == 1) {
                i7 = anonymousClass1.I$2;
                i5 = anonymousClass1.I$1;
                i6 = anonymousClass1.I$0;
                list2 = (List) anonymousClass1.L$3;
                cameraConfiguration3 = (CameraConfiguration) anonymousClass1.L$2;
                processCameraProvider3 = (ProcessCameraProvider) anonymousClass1.L$1;
                cameraSession3 = (CameraSession) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list4 = (List) anonymousClass1.L$3;
                cameraConfiguration5 = (CameraConfiguration) anonymousClass1.L$2;
                processCameraProvider4 = (ProcessCameraProvider) anonymousClass1.L$1;
                cameraSession4 = (CameraSession) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            list = list4;
            cameraConfiguration2 = cameraConfiguration5;
            processCameraProvider2 = processCameraProvider4;
            cameraSelectorBuild = (CameraSelector) obj;
            cameraSession2 = cameraSession4;
            if (!cameraSession2.getCurrentUseCases$react_native_vision_camera_release().isEmpty()) {
                int size = cameraSession2.getCurrentUseCases$react_native_vision_camera_release().size();
                camera$react_native_vision_camera_release = cameraSession2.getCamera$react_native_vision_camera_release();
                if (camera$react_native_vision_camera_release != null || (cameraInfo = camera$react_native_vision_camera_release.getCameraInfo()) == null) {
                    id = null;
                } else {
                    id = CameraInfo_idKt.getId(cameraInfo);
                }
                Log.i(CameraSession.TAG, "Unbinding " + size + " use-cases for Camera #" + id + "...");
                UseCase[] useCaseArr = (UseCase[]) cameraSession2.getCurrentUseCases$react_native_vision_camera_release().toArray(new UseCase[0]);
                processCameraProvider2.unbind((UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length));
            }
            Log.i(CameraSession.TAG, "Binding " + list.size() + " use-cases...");
            UseCase[] useCaseArr2 = (UseCase[]) list.toArray(new UseCase[0]);
            cameraSession2.setCamera$react_native_vision_camera_release(processCameraProvider2.bindToLifecycle(cameraSession2, cameraSelectorBuild, (UseCase[]) Arrays.copyOf(useCaseArr2, useCaseArr2.length)));
            cameraSession2.getCallback$react_native_vision_camera_release().onInitialized();
            cameraSession2.setCurrentUseCases$react_native_vision_camera_release(list);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Camera camera$react_native_vision_camera_release2 = cameraSession2.getCamera$react_native_vision_camera_release();
            Intrinsics.checkNotNull(camera$react_native_vision_camera_release2);
            camera$react_native_vision_camera_release2.getCameraInfo().getCameraState().observe(cameraSession2, new CameraSession_ConfigurationKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return CameraSession_ConfigurationKt.configureCamera$lambda$15(booleanRef, cameraSession2, (CameraState) obj2);
                }
            }));
            Log.i(CameraSession.TAG, "Successfully bound Camera #" + cameraConfiguration2.getCameraId() + "!");
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        Log.i(CameraSession.TAG, "Binding Camera #" + cameraConfiguration.getCameraId() + "...");
        cameraSession.checkCameraPermission$react_native_vision_camera_release();
        List<? extends UseCase> listListOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new UseCase[]{cameraSession.getPreviewOutput$react_native_vision_camera_release(), cameraSession.getPhotoOutput$react_native_vision_camera_release(), cameraSession.getVideoOutput$react_native_vision_camera_release(), cameraSession.getFrameProcessorOutput$react_native_vision_camera_release(), cameraSession.getCodeScannerOutput$react_native_vision_camera_release()});
        if (listListOfNotNull.isEmpty()) {
            throw new NoOutputsError();
        }
        String cameraId = cameraConfiguration.getCameraId();
        if (cameraId == null) {
            throw new NoCameraDeviceError();
        }
        cameraSelectorBuild = CameraSelector_byIdKt.byId(new CameraSelector.Builder(), cameraId).build();
        Intrinsics.checkNotNullExpressionValue(cameraSelectorBuild, "build(...)");
        List<? extends UseCase> list5 = listListOfNotNull;
        if (!(list5 instanceof Collection) || !list5.isEmpty()) {
            Iterator<T> it2 = list5.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i = 0;
                    break;
                }
                DynamicRange dynamicRange = ((UseCase) it2.next()).getCurrentConfig().getDynamicRange();
                Intrinsics.checkNotNullExpressionValue(dynamicRange, "getDynamicRange(...)");
                if (!DynamicRange_isSDRKt.isSDR(dynamicRange)) {
                    i = 1;
                    break;
                }
            }
        } else {
            i = 0;
            break;
        }
        int i10 = (cameraSession.getCodeScannerOutput$react_native_vision_camera_release() == null && cameraSession.getFrameProcessorOutput$react_native_vision_camera_release() == null) ? 0 : 1;
        CameraConfiguration.Output<CameraConfiguration.Photo> photo = cameraConfiguration.getPhoto();
        CameraConfiguration.Output.Enabled enabled = photo instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) photo : null;
        i2 = (enabled == null || !((CameraConfiguration.Photo) enabled.getConfig()).getEnableHdr()) ? 0 : 1;
        if (i2 == 0) {
            i3 = i10;
            i4 = i;
            list = listListOfNotNull;
            cameraConfiguration2 = cameraConfiguration;
            cameraSession2 = cameraSession;
            processCameraProvider2 = processCameraProvider;
        } else {
            if (i != 0) {
                throw new PhotoHdrAndVideoHdrNotSupportedSimultaneously();
            }
            Context context$react_native_vision_camera_release = cameraSession.getContext$react_native_vision_camera_release();
            anonymousClass1.L$0 = cameraSession;
            anonymousClass1.L$1 = processCameraProvider;
            anonymousClass1.L$2 = cameraConfiguration;
            anonymousClass1.L$3 = listListOfNotNull;
            anonymousClass1.I$0 = i;
            anonymousClass1.I$1 = i10;
            anonymousClass1.I$2 = i2;
            anonymousClass1.label = 1;
            int i11 = i2;
            int i12 = i10;
            int i13 = i;
            Object objWithExtension2 = CameraSelector_withExtensionKt.withExtension(cameraSelectorBuild, context$react_native_vision_camera_release, processCameraProvider, i10, 2, "HDR", anonymousClass1);
            if (objWithExtension2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            cameraSession3 = cameraSession;
            processCameraProvider3 = processCameraProvider;
            list2 = listListOfNotNull;
            obj = objWithExtension2;
            cameraConfiguration3 = cameraConfiguration;
            i5 = i12;
            i6 = i13;
            i7 = i11;
        }
        if (!cameraConfiguration2.getEnableLowLightBoost()) {
            if (i4 == 0) {
                throw new LowLightBoostNotSupportedWithHdr();
            }
            if (i2 == 0) {
                throw new LowLightBoostNotSupportedWithHdr();
            }
            Context context$react_native_vision_camera_release2 = cameraSession2.getContext$react_native_vision_camera_release();
            if (i3 != 0) {
                z = true;
            } else {
                z = false;
            }
            anonymousClass1.L$0 = cameraSession2;
            anonymousClass1.L$1 = processCameraProvider2;
            anonymousClass1.L$2 = cameraConfiguration2;
            anonymousClass1.L$3 = list;
            anonymousClass1.label = 2;
            list3 = list;
            cameraConfiguration4 = cameraConfiguration2;
            objWithExtension = CameraSelector_withExtensionKt.withExtension(cameraSelectorBuild, context$react_native_vision_camera_release2, processCameraProvider2, z, 3, "NIGHT", anonymousClass1);
            if (objWithExtension == coroutine_suspended) {
                return coroutine_suspended;
            }
            processCameraProvider4 = processCameraProvider2;
            cameraConfiguration5 = cameraConfiguration4;
            list4 = list3;
            cameraSession4 = cameraSession2;
            obj = objWithExtension;
            list = list4;
            cameraConfiguration2 = cameraConfiguration5;
            processCameraProvider2 = processCameraProvider4;
            cameraSelectorBuild = (CameraSelector) obj;
            cameraSession2 = cameraSession4;
        }
        if (!cameraSession2.getCurrentUseCases$react_native_vision_camera_release().isEmpty()) {
            int size2 = cameraSession2.getCurrentUseCases$react_native_vision_camera_release().size();
            camera$react_native_vision_camera_release = cameraSession2.getCamera$react_native_vision_camera_release();
            if (camera$react_native_vision_camera_release != null) {
                id = null;
            } else {
                id = null;
            }
            Log.i(CameraSession.TAG, "Unbinding " + size2 + " use-cases for Camera #" + id + "...");
            UseCase[] useCaseArr3 = (UseCase[]) cameraSession2.getCurrentUseCases$react_native_vision_camera_release().toArray(new UseCase[0]);
            processCameraProvider2.unbind((UseCase[]) Arrays.copyOf(useCaseArr3, useCaseArr3.length));
        }
        Log.i(CameraSession.TAG, "Binding " + list.size() + " use-cases...");
        UseCase[] useCaseArr4 = (UseCase[]) list.toArray(new UseCase[0]);
        cameraSession2.setCamera$react_native_vision_camera_release(processCameraProvider2.bindToLifecycle(cameraSession2, cameraSelectorBuild, (UseCase[]) Arrays.copyOf(useCaseArr4, useCaseArr4.length)));
        cameraSession2.getCallback$react_native_vision_camera_release().onInitialized();
        cameraSession2.setCurrentUseCases$react_native_vision_camera_release(list);
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        Camera camera$react_native_vision_camera_release3 = cameraSession2.getCamera$react_native_vision_camera_release();
        Intrinsics.checkNotNull(camera$react_native_vision_camera_release3);
        camera$react_native_vision_camera_release3.getCameraInfo().getCameraState().observe(cameraSession2, new CameraSession_ConfigurationKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return CameraSession_ConfigurationKt.configureCamera$lambda$15(booleanRef2, cameraSession2, (CameraState) obj2);
            }
        }));
        Log.i(CameraSession.TAG, "Successfully bound Camera #" + cameraConfiguration2.getCameraId() + "!");
        return Unit.INSTANCE;
        i3 = i5;
        i4 = i6;
        processCameraProvider2 = processCameraProvider3;
        list = list2;
        int i14 = i7;
        cameraSelectorBuild = (CameraSelector) obj;
        cameraSession2 = cameraSession3;
        cameraConfiguration2 = cameraConfiguration3;
        i2 = i14;
        if (!cameraConfiguration2.getEnableLowLightBoost()) {
            if (i4 == 0) {
                throw new LowLightBoostNotSupportedWithHdr();
            }
            if (i2 == 0) {
                throw new LowLightBoostNotSupportedWithHdr();
            }
            Context context$react_native_vision_camera_release3 = cameraSession2.getContext$react_native_vision_camera_release();
            if (i3 != 0) {
                z = true;
            } else {
                z = false;
            }
            anonymousClass1.L$0 = cameraSession2;
            anonymousClass1.L$1 = processCameraProvider2;
            anonymousClass1.L$2 = cameraConfiguration2;
            anonymousClass1.L$3 = list;
            anonymousClass1.label = 2;
            list3 = list;
            cameraConfiguration4 = cameraConfiguration2;
            objWithExtension = CameraSelector_withExtensionKt.withExtension(cameraSelectorBuild, context$react_native_vision_camera_release3, processCameraProvider2, z, 3, "NIGHT", anonymousClass1);
            if (objWithExtension == coroutine_suspended) {
                return coroutine_suspended;
            }
            processCameraProvider4 = processCameraProvider2;
            cameraConfiguration5 = cameraConfiguration4;
            list4 = list3;
            cameraSession4 = cameraSession2;
            obj = objWithExtension;
            list = list4;
            cameraConfiguration2 = cameraConfiguration5;
            processCameraProvider2 = processCameraProvider4;
            cameraSelectorBuild = (CameraSelector) obj;
            cameraSession2 = cameraSession4;
        }
        if (!cameraSession2.getCurrentUseCases$react_native_vision_camera_release().isEmpty()) {
            int size3 = cameraSession2.getCurrentUseCases$react_native_vision_camera_release().size();
            camera$react_native_vision_camera_release = cameraSession2.getCamera$react_native_vision_camera_release();
            if (camera$react_native_vision_camera_release != null) {
                id = null;
            } else {
                id = null;
            }
            Log.i(CameraSession.TAG, "Unbinding " + size3 + " use-cases for Camera #" + id + "...");
            UseCase[] useCaseArr5 = (UseCase[]) cameraSession2.getCurrentUseCases$react_native_vision_camera_release().toArray(new UseCase[0]);
            processCameraProvider2.unbind((UseCase[]) Arrays.copyOf(useCaseArr5, useCaseArr5.length));
        }
        Log.i(CameraSession.TAG, "Binding " + list.size() + " use-cases...");
        UseCase[] useCaseArr6 = (UseCase[]) list.toArray(new UseCase[0]);
        cameraSession2.setCamera$react_native_vision_camera_release(processCameraProvider2.bindToLifecycle(cameraSession2, cameraSelectorBuild, (UseCase[]) Arrays.copyOf(useCaseArr6, useCaseArr6.length)));
        cameraSession2.getCallback$react_native_vision_camera_release().onInitialized();
        cameraSession2.setCurrentUseCases$react_native_vision_camera_release(list);
        final Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        Camera camera$react_native_vision_camera_release4 = cameraSession2.getCamera$react_native_vision_camera_release();
        Intrinsics.checkNotNull(camera$react_native_vision_camera_release4);
        camera$react_native_vision_camera_release4.getCameraInfo().getCameraState().observe(cameraSession2, new CameraSession_ConfigurationKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return CameraSession_ConfigurationKt.configureCamera$lambda$15(booleanRef3, cameraSession2, (CameraState) obj2);
            }
        }));
        Log.i(CameraSession.TAG, "Successfully bound Camera #" + cameraConfiguration2.getCameraId() + "!");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit configureCamera$lambda$15(Ref.BooleanRef booleanRef, CameraSession cameraSession, CameraState cameraState) {
        Log.i(CameraSession.TAG, "Camera State: " + cameraState.getType() + " (has error: " + (cameraState.getError() != null) + ")");
        boolean z = cameraState.getType() == CameraState.Type.OPEN;
        if (z != booleanRef.element) {
            if (z) {
                cameraSession.getCallback$react_native_vision_camera_release().onStarted();
            } else {
                cameraSession.getCallback$react_native_vision_camera_release().onStopped();
            }
            booleanRef.element = z;
        }
        CameraState.StateError error = cameraState.getError();
        if (error != null) {
            cameraSession.getCallback$react_native_vision_camera_release().onError(StateError_toCameraErrorKt.toCameraError(error));
        }
        return Unit.INSTANCE;
    }

    public static final void configureSideProps(@NotNull CameraSession cameraSession, @NotNull CameraConfiguration config) throws CameraNotReadyError, FlashUnavailableError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        Camera camera$react_native_vision_camera_release = cameraSession.getCamera$react_native_vision_camera_release();
        if (camera$react_native_vision_camera_release == null) {
            throw new CameraNotReadyError();
        }
        ZoomState value = camera$react_native_vision_camera_release.getCameraInfo().getZoomState().getValue();
        if (!Intrinsics.areEqual(value != null ? Float.valueOf(value.getZoomRatio()) : null, config.getZoom())) {
            camera$react_native_vision_camera_release.getCameraControl().setZoomRatio(config.getZoom());
        }
        Integer value2 = camera$react_native_vision_camera_release.getCameraInfo().getTorchState().getValue();
        boolean z = value2 != null && value2.intValue() == 1;
        boolean z2 = config.getTorch() == Torch.ON;
        if (z != z2) {
            if (z2 && !camera$react_native_vision_camera_release.getCameraInfo().hasFlashUnit()) {
                throw new FlashUnavailableError();
            }
            camera$react_native_vision_camera_release.getCameraControl().enableTorch(z2);
        }
        int exposureCompensationIndex = camera$react_native_vision_camera_release.getCameraInfo().getExposureState().getExposureCompensationIndex();
        Double exposure = config.getExposure();
        int iRoundToInt = exposure != null ? MathKt__MathJVMKt.roundToInt(exposure.doubleValue()) : 0;
        if (exposureCompensationIndex != iRoundToInt) {
            camera$react_native_vision_camera_release.getCameraControl().setExposureCompensationIndex(iRoundToInt);
        }
    }

    public static final void configureIsActive(@NotNull CameraSession cameraSession, @NotNull CameraConfiguration config) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.isActive()) {
            cameraSession.getLifecycleRegistry$react_native_vision_camera_release().setCurrentState(Lifecycle.State.STARTED);
            cameraSession.getLifecycleRegistry$react_native_vision_camera_release().setCurrentState(Lifecycle.State.RESUMED);
        } else {
            cameraSession.getLifecycleRegistry$react_native_vision_camera_release().setCurrentState(Lifecycle.State.STARTED);
            cameraSession.getLifecycleRegistry$react_native_vision_camera_release().setCurrentState(Lifecycle.State.CREATED);
        }
    }
}
