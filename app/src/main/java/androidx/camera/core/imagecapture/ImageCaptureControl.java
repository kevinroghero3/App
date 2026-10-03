package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageCaptureControl {
    void lockFlashMode();

    ListenableFuture<Void> submitStillCaptureRequests(@NonNull List<CaptureConfig> list);

    void unlockFlashMode();
}
