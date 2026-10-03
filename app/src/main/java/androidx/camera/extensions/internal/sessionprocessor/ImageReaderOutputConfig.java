package androidx.camera.extensions.internal.sessionprocessor;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImageReaderOutputConfig implements Camera2OutputConfig {
    abstract int getImageFormat();

    abstract int getMaxImages();

    abstract Size getSize();

    static ImageReaderOutputConfig create(int i, int i2, @Nullable String str, @NonNull List<Camera2OutputConfig> list, @NonNull Size size, int i3, int i4) {
        return new AutoValue_ImageReaderOutputConfig(i, i2, str, list, size, i3, i4);
    }

    static ImageReaderOutputConfig create(int i, @NonNull Size size, int i2, int i3) {
        return new AutoValue_ImageReaderOutputConfig(i, -1, null, Collections.emptyList(), size, i2, i3);
    }
}
