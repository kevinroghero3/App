package androidx.camera.core;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraProvider {
    List<CameraInfo> getAvailableCameraInfos();

    List<List<CameraInfo>> getAvailableConcurrentCameraInfos();

    boolean hasCamera(@NotNull CameraSelector cameraSelector) throws CameraInfoUnavailableException;

    boolean isConcurrentCameraModeOn();

    default CameraInfo getCameraInfo(@NotNull CameraSelector cameraSelector) {
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        throw new UnsupportedOperationException("The camera provider is not implemented properly.");
    }
}
