package androidx.camera.core.imagecapture;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraCapturePipeline {
    ListenableFuture<Void> invokePostCapture();

    ListenableFuture<Void> invokePreCapture();
}
