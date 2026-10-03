package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageInfo {
    int getRotationDegrees();

    TagBundle getTagBundle();

    long getTimestamp();

    void populateExifData(@NonNull ExifData.Builder builder);

    default Matrix getSensorToBufferTransformMatrix() {
        return new Matrix();
    }
}
