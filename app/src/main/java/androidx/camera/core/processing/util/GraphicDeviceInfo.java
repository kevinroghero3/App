package androidx.camera.core.processing.util;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GraphicDeviceInfo {

    public static abstract class Builder {
        public abstract GraphicDeviceInfo build();

        public abstract Builder setEglExtensions(@NonNull String str);

        public abstract Builder setEglVersion(@NonNull String str);

        public abstract Builder setGlExtensions(@NonNull String str);

        public abstract Builder setGlVersion(@NonNull String str);
    }

    public abstract String getEglExtensions();

    public abstract String getEglVersion();

    public abstract String getGlExtensions();

    public abstract String getGlVersion();

    public static Builder builder() {
        return new AutoValue_GraphicDeviceInfo.Builder().setGlVersion(GLUtils.VERSION_UNKNOWN).setEglVersion(GLUtils.VERSION_UNKNOWN).setGlExtensions("").setEglExtensions("");
    }

    GraphicDeviceInfo() {
    }
}
