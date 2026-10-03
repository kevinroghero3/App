package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoOutput {

    public enum SourceState {
        ACTIVE_STREAMING,
        ACTIVE_NON_STREAMING,
        INACTIVE
    }

    default void onSourceStateChanged(@NonNull SourceState sourceState) {
    }

    void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest);

    default void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        onSurfaceRequested(surfaceRequest);
    }

    default Observable<StreamInfo> getStreamInfo() {
        return StreamInfo.ALWAYS_ACTIVE_OBSERVABLE;
    }

    default Observable<MediaSpec> getMediaSpec() {
        return ConstantObservable.withValue(null);
    }

    default Observable<Boolean> isSourceStreamRequired() {
        return ConstantObservable.withValue(Boolean.FALSE);
    }

    default VideoCapabilities getMediaCapabilities(@NonNull CameraInfo cameraInfo) {
        return VideoCapabilities.EMPTY;
    }
}
