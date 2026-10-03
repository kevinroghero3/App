package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
abstract class CameraDeviceId {
    public abstract String getBrand();

    public abstract String getCameraId();

    public abstract String getDevice();

    public abstract String getModel();

    CameraDeviceId() {
    }

    public static CameraDeviceId create(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        return new AutoValue_CameraDeviceId(str.toLowerCase(), str2.toLowerCase(), str3.toLowerCase(), str4.toLowerCase());
    }
}
