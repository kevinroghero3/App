package androidx.camera.extensions.internal.sessionprocessor;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SurfaceOutputConfig implements Camera2OutputConfig {
    abstract Surface getSurface();

    static SurfaceOutputConfig create(int i, int i2, @Nullable String str, @NonNull List<Camera2OutputConfig> list, @NonNull Surface surface) {
        return new AutoValue_SurfaceOutputConfig(i, i2, str, list, surface);
    }

    static SurfaceOutputConfig create(int i, @NonNull Surface surface) {
        return create(i, -1, null, Collections.emptyList(), surface);
    }
}
