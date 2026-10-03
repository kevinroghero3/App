package com.mrousavy.camera.react;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.camera.view.PreviewView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.mrousavy.camera.core.SnapshotFailedError;
import com.mrousavy.camera.core.SnapshotFailedPreviewNotEnabledError;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.ShutterType;
import com.mrousavy.camera.core.types.TakeSnapshotOptions;
import com.mrousavy.camera.core.utils.FileUtils;
import io.sentry.protocol.Device;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CameraView_TakeSnapshotKt {
    private static final String TAG = "CameraView.takeSnapshot";

    public static final WritableMap takeSnapshot(@NotNull CameraView cameraView, @NotNull TakeSnapshotOptions options) throws SnapshotFailedError, SnapshotFailedPreviewNotEnabledError, FileNotFoundException {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Log.i(TAG, "Capturing snapshot of Camera View...");
        PreviewView previewView$react_native_vision_camera_release = cameraView.getPreviewView$react_native_vision_camera_release();
        if (previewView$react_native_vision_camera_release == null) {
            throw new SnapshotFailedPreviewNotEnabledError();
        }
        Bitmap bitmap = previewView$react_native_vision_camera_release.getBitmap();
        if (bitmap == null) {
            throw new SnapshotFailedError();
        }
        cameraView.onShutter(ShutterType.SNAPSHOT);
        FileUtils.Companion companion = FileUtils.Companion;
        File file = options.getFile().getFile();
        Intrinsics.checkNotNullExpressionValue(file, "<get-file>(...)");
        companion.writeBitmapTofile(bitmap, file, options.getQuality());
        Log.i(TAG, "Successfully saved snapshot to file!");
        Orientation outputOrientation = cameraView.getCameraSession$react_native_vision_camera_release().getOutputOrientation();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("path", options.getFile().getFile().getAbsolutePath());
        writableMapCreateMap.putInt("width", bitmap.getWidth());
        writableMapCreateMap.putInt("height", bitmap.getHeight());
        writableMapCreateMap.putString(Device.JsonKeys.ORIENTATION, outputOrientation.getUnionValue());
        writableMapCreateMap.putBoolean("isMirrored", false);
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }
}
