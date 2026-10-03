package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraConfig;

/* JADX INFO: loaded from: classes.dex */
public interface Camera {
    CameraControl getCameraControl();

    CameraInfo getCameraInfo();

    CameraConfig getExtendedConfig();

    default boolean isUseCasesCombinationSupported(boolean z, @NonNull UseCase... useCaseArr) {
        return true;
    }

    default boolean isUseCasesCombinationSupported(@NonNull UseCase... useCaseArr) {
        return isUseCasesCombinationSupported(true, useCaseArr);
    }

    default boolean isUseCasesCombinationSupportedByFramework(@NonNull UseCase... useCaseArr) {
        return isUseCasesCombinationSupported(false, useCaseArr);
    }
}
