package com.mrousavy.camera.core.extensions;

import android.location.Location;
import android.media.MediaActionSound;
import android.util.Log;
import androidx.camera.core.ImageCapture;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.MetadataProvider;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ImageCapture_takePictureKt {
    private static final Object takePicture$$forInline(ImageCapture imageCapture, File file, boolean z, boolean z2, MetadataProvider metadataProvider, CameraSession.Callback callback, Executor executor, Continuation<? super PhotoFileInfo> continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        MediaActionSound mediaActionSound = z2 ? new MediaActionSound() : null;
        if (mediaActionSound != null) {
            mediaActionSound.load(0);
            Unit unit = Unit.INSTANCE;
        }
        ImageCapture.OutputFileOptions.Builder builder = new ImageCapture.OutputFileOptions.Builder(file);
        ImageCapture.Metadata metadata = new ImageCapture.Metadata();
        Location location = metadataProvider.getLocation();
        if (location != null) {
            Log.i("ImageCapture", "Setting Photo Location to " + location.getLatitude() + ", " + location.getLongitude() + "...");
            metadata.setLocation(metadataProvider.getLocation());
            Unit unit2 = Unit.INSTANCE;
        }
        metadata.setReversedHorizontal(z);
        builder.setMetadata(metadata);
        Unit unit3 = Unit.INSTANCE;
        ImageCapture.OutputFileOptions outputFileOptionsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(outputFileOptionsBuild, "build(...)");
        imageCapture.lambda$takePicture$2(outputFileOptionsBuild, executor, new ImageCapture_takePictureKt$takePicture$2$1(z2, mediaActionSound, callback, cancellableContinuationImpl, file, outputFileOptionsBuild));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final Object takePicture(@NotNull ImageCapture imageCapture, @NotNull File file, boolean z, boolean z2, @NotNull MetadataProvider metadataProvider, @NotNull CameraSession.Callback callback, @NotNull Executor executor, @NotNull Continuation<? super PhotoFileInfo> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        MediaActionSound mediaActionSound = z2 ? new MediaActionSound() : null;
        if (mediaActionSound != null) {
            mediaActionSound.load(0);
        }
        ImageCapture.OutputFileOptions.Builder builder = new ImageCapture.OutputFileOptions.Builder(file);
        ImageCapture.Metadata metadata = new ImageCapture.Metadata();
        Location location = metadataProvider.getLocation();
        if (location != null) {
            Log.i("ImageCapture", "Setting Photo Location to " + location.getLatitude() + ", " + location.getLongitude() + "...");
            metadata.setLocation(metadataProvider.getLocation());
        }
        metadata.setReversedHorizontal(z);
        builder.setMetadata(metadata);
        ImageCapture.OutputFileOptions outputFileOptionsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(outputFileOptionsBuild, "build(...)");
        imageCapture.lambda$takePicture$2(outputFileOptionsBuild, executor, new ImageCapture_takePictureKt$takePicture$2$1(z2, mediaActionSound, callback, cancellableContinuationImpl, file, outputFileOptionsBuild));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
