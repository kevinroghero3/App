package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageReaderProxy {

    public interface OnImageAvailableListener {
        void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy);
    }

    ImageProxy acquireLatestImage();

    ImageProxy acquireNextImage();

    void clearOnImageAvailableListener();

    void close();

    int getHeight();

    int getImageFormat();

    int getMaxImages();

    Surface getSurface();

    int getWidth();

    void setOnImageAvailableListener(@NonNull OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor);
}
