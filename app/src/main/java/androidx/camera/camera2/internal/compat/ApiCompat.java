package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ApiCompat {
    private ApiCompat() {
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void close(@NonNull CameraDevice cameraDevice) {
            cameraDevice.close();
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void onSurfacePrepared(@NonNull CameraCaptureSession.StateCallback stateCallback, @NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
            stateCallback.onSurfacePrepared(cameraCaptureSession, surface);
        }
    }

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void onCaptureBufferLost(@NonNull CameraCaptureSession.CaptureCallback captureCallback, @NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j) {
            captureCallback.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static void onCaptureQueueEmpty(@NonNull CameraCaptureSession.StateCallback stateCallback, @NonNull CameraCaptureSession cameraCaptureSession) {
            stateCallback.onCaptureQueueEmpty(cameraCaptureSession);
        }

        public static <T> OutputConfiguration newOutputConfiguration(@NonNull Size size, @NonNull Class<T> cls) {
            return ApiCompat$Api26Impl$$ExternalSyntheticApiModelOutline1.m(size, cls);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void onCameraAccessPrioritiesChanged(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
            availabilityCallback.onCameraAccessPrioritiesChanged();
        }
    }
}
