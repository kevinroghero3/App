package com.mrousavy.camera.core.extensions;

import android.media.MediaActionSound;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.types.ShutterType;
import java.io.File;
import java.net.URI;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: loaded from: classes6.dex */
public final class ImageCapture_takePictureKt$takePicture$2$1 implements ImageCapture.OnImageSavedCallback {
    final /* synthetic */ CameraSession.Callback $callback;
    final /* synthetic */ CancellableContinuation<PhotoFileInfo> $continuation;
    final /* synthetic */ boolean $enableShutterSound;
    final /* synthetic */ File $file;
    final /* synthetic */ ImageCapture.OutputFileOptions $outputFileOptions;
    final /* synthetic */ MediaActionSound $shutterSound;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageCapture_takePictureKt$takePicture$2$1(boolean z, MediaActionSound mediaActionSound, CameraSession.Callback callback, CancellableContinuation<? super PhotoFileInfo> cancellableContinuation, File file, ImageCapture.OutputFileOptions outputFileOptions) {
        this.$enableShutterSound = z;
        this.$shutterSound = mediaActionSound;
        this.$callback = callback;
        this.$continuation = cancellableContinuation;
        this.$file = file;
        this.$outputFileOptions = outputFileOptions;
    }

    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
    public void onCaptureStarted() {
        MediaActionSound mediaActionSound;
        super.onCaptureStarted();
        if (this.$enableShutterSound && (mediaActionSound = this.$shutterSound) != null) {
            mediaActionSound.play(0);
        }
        this.$callback.onShutter(ShutterType.PHOTO);
    }

    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
    public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
        Intrinsics.checkNotNullParameter(outputFileResults, "outputFileResults");
        if (this.$continuation.isActive()) {
            URI uri = this.$file.toURI();
            Intrinsics.checkNotNullExpressionValue(uri, "toURI(...)");
            ImageCapture.Metadata metadata = this.$outputFileOptions.getMetadata();
            Intrinsics.checkNotNullExpressionValue(metadata, "getMetadata(...)");
            PhotoFileInfo photoFileInfo = new PhotoFileInfo(uri, metadata);
            CancellableContinuation<PhotoFileInfo> cancellableContinuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m5472constructorimpl(photoFileInfo));
        }
    }

    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
    public void onError(ImageCaptureException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (this.$continuation.isActive()) {
            CancellableContinuation<PhotoFileInfo> cancellableContinuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m5472constructorimpl(ResultKt.createFailure(exception)));
        }
    }
}
