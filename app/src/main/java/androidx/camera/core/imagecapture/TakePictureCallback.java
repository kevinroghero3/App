package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

/* JADX INFO: loaded from: classes2.dex */
interface TakePictureCallback {
    boolean isAborted();

    void onCaptureFailure(@NonNull ImageCaptureException imageCaptureException);

    void onCaptureProcessProgressed(int i);

    void onCaptureStarted();

    void onFinalResult(@NonNull ImageCapture.OutputFileResults outputFileResults);

    void onFinalResult(@NonNull ImageProxy imageProxy);

    void onImageCaptured();

    void onPostviewBitmapAvailable(@NonNull Bitmap bitmap);

    void onProcessFailure(@NonNull ImageCaptureException imageCaptureException);
}
