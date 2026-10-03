package androidx.camera.core.impl;

import android.os.Build;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeviceProperties {
    public abstract String manufacturer();

    public abstract String model();

    public abstract int sdkVersion();

    public static DeviceProperties create() {
        return create(Build.MANUFACTURER, Build.MODEL, Build.VERSION.SDK_INT);
    }

    public static DeviceProperties create(@NonNull String str, @NonNull String str2, int i) {
        return new AutoValue_DeviceProperties(str, str2, i);
    }
}
