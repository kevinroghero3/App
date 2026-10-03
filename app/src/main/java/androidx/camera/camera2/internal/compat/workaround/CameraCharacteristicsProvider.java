package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraCharacteristicsProvider {
    <T> T get(@NonNull CameraCharacteristics.Key<T> key);
}
