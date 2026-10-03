package com.mrousavy.camera.react;

import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CameraSession_VideoKt;
import com.mrousavy.camera.core.MicrophonePermissionError;
import com.mrousavy.camera.core.types.RecordVideoOptions;
import com.mrousavy.camera.core.types.Video;
import com.mrousavy.camera.react.utils.CallbackPromiseKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CameraView_RecordVideoKt {
    public static final void startRecording(@NotNull CameraView cameraView, @NotNull RecordVideoOptions options, @NotNull final Callback onRecordCallback) throws MicrophonePermissionError {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onRecordCallback, "onRecordCallback");
        if (cameraView.getAudio() && ContextCompat.checkSelfPermission(cameraView.getContext(), "android.permission.RECORD_AUDIO") != 0) {
            throw new MicrophonePermissionError();
        }
        CameraSession_VideoKt.startRecording(cameraView.getCameraSession$react_native_vision_camera_release(), cameraView.getAudio(), options, new Function1() { // from class: com.mrousavy.camera.react.CameraView_RecordVideoKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CameraView_RecordVideoKt.startRecording$lambda$0(onRecordCallback, (Video) obj);
            }
        }, new Function1() { // from class: com.mrousavy.camera.react.CameraView_RecordVideoKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CameraView_RecordVideoKt.startRecording$lambda$1(onRecordCallback, (CameraError) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startRecording$lambda$0(Callback callback, Video video) {
        Intrinsics.checkNotNullParameter(video, "video");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("path", video.getPath());
        writableMapCreateMap.putDouble("duration", video.getDurationMs() / 1000.0d);
        writableMapCreateMap.putInt("width", video.getSize().getWidth());
        writableMapCreateMap.putInt("height", video.getSize().getHeight());
        callback.invoke(writableMapCreateMap, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startRecording$lambda$1(Callback callback, CameraError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        callback.invoke(null, CallbackPromiseKt.makeErrorMap$default(error.getCode(), error.getMessage(), null, null, 12, null));
        return Unit.INSTANCE;
    }

    public static final void pauseRecording(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.pauseRecording(cameraView.getCameraSession$react_native_vision_camera_release());
    }

    public static final void resumeRecording(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.resumeRecording(cameraView.getCameraSession$react_native_vision_camera_release());
    }

    public static final void stopRecording(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.stopRecording(cameraView.getCameraSession$react_native_vision_camera_release());
    }

    public static final void cancelRecording(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.cancelRecording(cameraView.getCameraSession$react_native_vision_camera_release());
    }
}
