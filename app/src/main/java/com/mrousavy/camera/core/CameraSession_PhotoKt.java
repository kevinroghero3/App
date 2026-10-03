package com.mrousavy.camera.core;

import android.location.Location;
import android.media.AudioManager;
import android.media.MediaActionSound;
import android.util.Log;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.ImageCapture;
import com.mrousavy.camera.core.extensions.ImageCapture_takePictureKt$takePicture$2$1;
import com.mrousavy.camera.core.extensions.PhotoFileInfo;
import com.mrousavy.camera.core.types.Flash;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.TakePhotoOptions;
import com.mrousavy.camera.core.utils.FileUtils;
import java.io.File;
import java.util.concurrent.ExecutorService;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CameraSession_PhotoKt {

    /* JADX INFO: renamed from: com.mrousavy.camera.core.CameraSession_PhotoKt$takePhoto$1, reason: invalid class name */
    @DebugMetadata(c = "com.mrousavy.camera.core.CameraSession_PhotoKt", f = "CameraSession+Photo.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {48}, m = "takePhoto", n = {"photoOutput", "$this$takePicture$iv", "file$iv", "metadataProvider$iv", "callback$iv", "executor$iv", "enableShutterSound", "isMirrored"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSession_PhotoKt.takePhoto(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public static final Object takePhoto(@NotNull CameraSession cameraSession, @NotNull TakePhotoOptions takePhotoOptions, @NotNull Continuation<? super Photo> continuation) {
        AnonymousClass1 anonymousClass1;
        boolean z;
        ImageCapture imageCapture;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Camera camera$react_native_vision_camera_release = cameraSession.getCamera$react_native_vision_camera_release();
            if (camera$react_native_vision_camera_release == null) {
                throw new CameraNotReadyError();
            }
            CameraConfiguration configuration$react_native_vision_camera_release = cameraSession.getConfiguration$react_native_vision_camera_release();
            if (configuration$react_native_vision_camera_release == null) {
                throw new CameraNotReadyError();
            }
            CameraConfiguration.Output<CameraConfiguration.Photo> photo = configuration$react_native_vision_camera_release.getPhoto();
            CameraConfiguration.Output.Enabled enabled = photo instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) photo : null;
            if (enabled == null) {
                throw new PhotoNotEnabledError();
            }
            ImageCapture photoOutput$react_native_vision_camera_release = cameraSession.getPhotoOutput$react_native_vision_camera_release();
            if (photoOutput$react_native_vision_camera_release == null) {
                throw new PhotoNotEnabledError();
            }
            if (takePhotoOptions.getFlash() != Flash.OFF && !camera$react_native_vision_camera_release.getCameraInfo().hasFlashUnit()) {
                throw new FlashUnavailableError();
            }
            photoOutput$react_native_vision_camera_release.setFlashMode(takePhotoOptions.getFlash().toFlashMode());
            ?? r9 = (!takePhotoOptions.getEnableShutterSound() || isSilent(cameraSession.getAudioManager$react_native_vision_camera_release())) ? 0 : 1;
            boolean zIsMirrored = ((CameraConfiguration.Photo) enabled.getConfig()).isMirrored();
            File file = takePhotoOptions.getFile().getFile();
            Intrinsics.checkNotNullExpressionValue(file, "<get-file>(...)");
            MetadataProvider metadataProvider$react_native_vision_camera_release = cameraSession.getMetadataProvider$react_native_vision_camera_release();
            CameraSession.Callback callback$react_native_vision_camera_release = cameraSession.getCallback$react_native_vision_camera_release();
            ExecutorService cameraExecutor = CameraQueues.Companion.getCameraExecutor();
            anonymousClass1.L$0 = photoOutput$react_native_vision_camera_release;
            anonymousClass1.L$1 = photoOutput$react_native_vision_camera_release;
            anonymousClass1.L$2 = file;
            anonymousClass1.L$3 = metadataProvider$react_native_vision_camera_release;
            anonymousClass1.L$4 = callback$react_native_vision_camera_release;
            anonymousClass1.L$5 = cameraExecutor;
            anonymousClass1.I$0 = r9;
            anonymousClass1.Z$0 = zIsMirrored;
            anonymousClass1.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(anonymousClass1), 1);
            cancellableContinuationImpl.initCancellability();
            MediaActionSound mediaActionSound = r9 != 0 ? new MediaActionSound() : null;
            if (mediaActionSound != null) {
                mediaActionSound.load(0);
            }
            ImageCapture.OutputFileOptions.Builder builder = new ImageCapture.OutputFileOptions.Builder(file);
            ImageCapture.Metadata metadata = new ImageCapture.Metadata();
            Location location = metadataProvider$react_native_vision_camera_release.getLocation();
            AnonymousClass1 anonymousClass2 = anonymousClass1;
            if (location != null) {
                Log.i("ImageCapture", "Setting Photo Location to " + location.getLatitude() + ", " + location.getLongitude() + "...");
                metadata.setLocation(metadataProvider$react_native_vision_camera_release.getLocation());
            }
            metadata.setReversedHorizontal(zIsMirrored);
            builder.setMetadata(metadata);
            ImageCapture.OutputFileOptions outputFileOptionsBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(outputFileOptionsBuild, "build(...)");
            photoOutput$react_native_vision_camera_release.lambda$takePicture$2(outputFileOptionsBuild, cameraExecutor, new ImageCapture_takePictureKt$takePicture$2$1(r9, mediaActionSound, callback$react_native_vision_camera_release, cancellableContinuationImpl, file, outputFileOptionsBuild));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(anonymousClass2);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
            z = zIsMirrored;
            obj = result;
            imageCapture = photoOutput$react_native_vision_camera_release;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = anonymousClass1.Z$0;
            imageCapture = (ImageCapture) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            z = z2;
        }
        PhotoFileInfo photoFileInfo = (PhotoFileInfo) obj;
        FileUtils.Companion companion = FileUtils.Companion;
        String path = photoFileInfo.getUri().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        Size imageSize = companion.getImageSize(path);
        Orientation orientationFromSurfaceRotation = Orientation.Companion.fromSurfaceRotation(imageCapture.getTargetRotation());
        String path2 = photoFileInfo.getUri().getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        return new Photo(path2, imageSize.getWidth(), imageSize.getHeight(), orientationFromSurfaceRotation, z);
    }

    private static final boolean isSilent(AudioManager audioManager) {
        return audioManager.getRingerMode() != 2;
    }
}
