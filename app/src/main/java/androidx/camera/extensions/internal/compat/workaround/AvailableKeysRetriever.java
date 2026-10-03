package androidx.camera.extensions.internal.compat.workaround;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.extensions.impl.ImageCaptureExtenderImpl;
import androidx.camera.extensions.internal.compat.quirk.DeviceQuirks;
import androidx.camera.extensions.internal.compat.quirk.GetAvailableKeysNeedsOnInit;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AvailableKeysRetriever {
    boolean mShouldInvokeOnInit;

    public AvailableKeysRetriever() {
        this.mShouldInvokeOnInit = DeviceQuirks.get(GetAvailableKeysNeedsOnInit.class) != null;
    }

    public List<CaptureRequest.Key> getAvailableCaptureRequestKeys(@NonNull ImageCaptureExtenderImpl imageCaptureExtenderImpl, @NonNull String str, @NonNull CameraCharacteristics cameraCharacteristics, @NonNull Context context) {
        if (this.mShouldInvokeOnInit) {
            imageCaptureExtenderImpl.onInit(str, cameraCharacteristics, context);
        }
        try {
            return imageCaptureExtenderImpl.getAvailableCaptureRequestKeys();
        } finally {
            if (this.mShouldInvokeOnInit) {
                imageCaptureExtenderImpl.onDeInit();
            }
        }
    }
}
