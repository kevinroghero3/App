package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraRequest {
    private final TakePictureCallback mCallback;
    private final List<CaptureConfig> mCaptureConfigs;

    public CameraRequest(@NonNull List<CaptureConfig> list, @NonNull TakePictureCallback takePictureCallback) {
        this.mCaptureConfigs = list;
        this.mCallback = takePictureCallback;
    }

    List<CaptureConfig> getCaptureConfigs() {
        return this.mCaptureConfigs;
    }

    boolean isAborted() {
        return this.mCallback.isAborted();
    }
}
