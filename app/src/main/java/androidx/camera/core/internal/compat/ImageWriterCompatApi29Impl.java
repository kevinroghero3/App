package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
final class ImageWriterCompatApi29Impl {
    static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i, int i2) {
        return ImageWriter.newInstance(surface, i, i2);
    }

    private ImageWriterCompatApi29Impl() {
    }
}
