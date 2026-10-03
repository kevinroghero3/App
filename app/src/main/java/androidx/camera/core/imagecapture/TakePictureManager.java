package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface TakePictureManager {

    public interface Provider {
        TakePictureManager newInstance(@NonNull ImageCaptureControl imageCaptureControl);
    }

    void abortRequests();

    RequestWithCallback getCapturingRequest();

    ImagePipeline getImagePipeline();

    List<RequestWithCallback> getIncompleteRequests();

    boolean hasCapturingRequest();

    void offerRequest(@NonNull TakePictureRequest takePictureRequest);

    void pause();

    void resume();

    void setImagePipeline(@NonNull ImagePipeline imagePipeline);

    public static abstract class CaptureError {
        abstract ImageCaptureException getImageCaptureException();

        abstract int getRequestId();

        static CaptureError of(int i, @NonNull ImageCaptureException imageCaptureException) {
            return new AutoValue_TakePictureManager_CaptureError(i, imageCaptureException);
        }
    }
}
