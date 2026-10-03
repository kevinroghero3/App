package com.mrousavy.camera.core;

import android.location.Location;
import android.util.Log;
import android.util.Size;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.core.util.Consumer;
import com.mrousavy.camera.core.extensions.VideoRecordEvent_toCameraErrorKt;
import com.mrousavy.camera.core.types.RecordVideoOptions;
import com.mrousavy.camera.core.types.Video;
import io.sentry.android.core.SentryLogcatAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CameraSession_VideoKt {
    public static final void startRecording(@NotNull final CameraSession cameraSession, boolean z, @NotNull final RecordVideoOptions options, @NotNull final Function1<? super Video, Unit> callback, @NotNull final Function1<? super CameraError, Unit> onError) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (cameraSession.getCamera$react_native_vision_camera_release() == null) {
            throw new CameraNotReadyError();
        }
        if (cameraSession.getRecording$react_native_vision_camera_release() != null) {
            throw new RecordingInProgressError();
        }
        final VideoCapture<Recorder> videoOutput$react_native_vision_camera_release = cameraSession.getVideoOutput$react_native_vision_camera_release();
        if (videoOutput$react_native_vision_camera_release == null) {
            throw new VideoNotEnabledError();
        }
        FileOutputOptions.Builder builder = new FileOutputOptions.Builder(options.getFile().getFile());
        Location location = cameraSession.getMetadataProvider$react_native_vision_camera_release().getLocation();
        if (location != null) {
            Log.i(CameraSession.TAG, "Setting Video Location to " + location.getLatitude() + ", " + location.getLongitude() + "...");
            builder.setLocation(location);
        }
        FileOutputOptions fileOutputOptionsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(fileOutputOptionsBuild, "build(...)");
        PendingRecording pendingRecordingPrepareRecording = ((Recorder) videoOutput$react_native_vision_camera_release.getOutput()).prepareRecording(cameraSession.getContext$react_native_vision_camera_release(), fileOutputOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(pendingRecordingPrepareRecording, "prepareRecording(...)");
        if (z) {
            cameraSession.checkMicrophonePermission$react_native_vision_camera_release();
            pendingRecordingPrepareRecording = PendingRecording.withAudioEnabled$default(pendingRecordingPrepareRecording, false, 1, null);
        }
        PendingRecording pendingRecordingAsPersistentRecording = pendingRecordingPrepareRecording.asPersistentRecording();
        cameraSession.setRecordingCanceled$react_native_vision_camera_release(false);
        cameraSession.setRecording$react_native_vision_camera_release(pendingRecordingAsPersistentRecording.start(CameraQueues.Companion.getCameraExecutor(), new Consumer() { // from class: com.mrousavy.camera.core.CameraSession_VideoKt$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) throws UnknownRecorderError {
                CameraSession_VideoKt.startRecording$lambda$2(cameraSession, onError, options, videoOutput$react_native_vision_camera_release, callback, (VideoRecordEvent) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startRecording$lambda$2(CameraSession cameraSession, Function1 function1, RecordVideoOptions recordVideoOptions, VideoCapture videoCapture, Function1 function2, VideoRecordEvent event) throws UnknownRecorderError {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof VideoRecordEvent.Start) {
            Log.i(CameraSession.TAG, "Recording started!");
            return;
        }
        if (event instanceof VideoRecordEvent.Resume) {
            Log.i(CameraSession.TAG, "Recording resumed!");
            return;
        }
        if (event instanceof VideoRecordEvent.Pause) {
            Log.i(CameraSession.TAG, "Recording paused!");
            return;
        }
        if (event instanceof VideoRecordEvent.Status) {
            Log.i(CameraSession.TAG, "Status update! Recorded " + ((VideoRecordEvent.Status) event).getRecordingStats().getNumBytesRecorded() + " bytes.");
            return;
        }
        if (event instanceof VideoRecordEvent.Finalize) {
            if (cameraSession.isRecordingCanceled$react_native_vision_camera_release()) {
                Log.i(CameraSession.TAG, "Recording was canceled, deleting file..");
                function1.invoke(new RecordingCanceledError());
                try {
                    recordVideoOptions.getFile().getFile().delete();
                    return;
                } catch (Throwable th) {
                    cameraSession.getCallback$react_native_vision_camera_release().onError(new FileIOError(th));
                    return;
                }
            }
            Log.i(CameraSession.TAG, "Recording stopped!");
            VideoRecordEvent.Finalize finalize = (VideoRecordEvent.Finalize) event;
            RecorderError cameraError = VideoRecordEvent_toCameraErrorKt.getCameraError(finalize);
            if (cameraError != null) {
                if (cameraError.getWasVideoRecorded()) {
                    SentryLogcatAdapter.e(CameraSession.TAG, "Video Recorder encountered an error, but the video was recorded anyways.", cameraError);
                } else {
                    SentryLogcatAdapter.e(CameraSession.TAG, "Video Recorder encountered a fatal error!", cameraError);
                    function1.invoke(cameraError);
                    return;
                }
            }
            long recordedDurationNanos = finalize.getRecordingStats().getRecordedDurationNanos() / ((long) DurationKt.NANOS_IN_MILLIS);
            Log.i(CameraSession.TAG, "Successfully completed video recording! Captured " + (recordedDurationNanos / 1000.0d) + " seconds.");
            String path = finalize.getOutputResults().getOutputUri().getPath();
            if (path == null) {
                throw new UnknownRecorderError(false, null);
            }
            Size attachedSurfaceResolution = videoCapture.getAttachedSurfaceResolution();
            if (attachedSurfaceResolution == null) {
                attachedSurfaceResolution = new Size(0, 0);
            }
            function2.invoke(new Video(path, recordedDurationNanos, attachedSurfaceResolution));
        }
    }

    public static final void stopRecording(@NotNull CameraSession cameraSession) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Recording recording$react_native_vision_camera_release = cameraSession.getRecording$react_native_vision_camera_release();
        if (recording$react_native_vision_camera_release == null) {
            throw new NoRecordingInProgressError();
        }
        recording$react_native_vision_camera_release.stop();
        cameraSession.setRecording$react_native_vision_camera_release(null);
    }

    public static final void cancelRecording(@NotNull CameraSession cameraSession) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        cameraSession.setRecordingCanceled$react_native_vision_camera_release(true);
        stopRecording(cameraSession);
    }

    public static final void pauseRecording(@NotNull CameraSession cameraSession) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Recording recording$react_native_vision_camera_release = cameraSession.getRecording$react_native_vision_camera_release();
        if (recording$react_native_vision_camera_release == null) {
            throw new NoRecordingInProgressError();
        }
        recording$react_native_vision_camera_release.pause();
    }

    public static final void resumeRecording(@NotNull CameraSession cameraSession) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Recording recording$react_native_vision_camera_release = cameraSession.getRecording$react_native_vision_camera_release();
        if (recording$react_native_vision_camera_release == null) {
            throw new NoRecordingInProgressError();
        }
        recording$react_native_vision_camera_release.resume();
    }
}
