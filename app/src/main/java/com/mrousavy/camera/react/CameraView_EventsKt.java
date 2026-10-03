package com.mrousavy.camera.react;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CodeScannerFrame;
import com.mrousavy.camera.core.UnknownCameraError;
import com.mrousavy.camera.core.types.CodeType;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.ShutterType;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraView_EventsKt {
    public static final void invokeOnInitialized(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnInitialized()");
        sendEvent(cameraView, new CameraInitializedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnStarted(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnStarted()");
        sendEvent(cameraView, new CameraStartedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnStopped(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnStopped()");
        sendEvent(cameraView, new CameraStoppedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnPreviewStarted(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnPreviewStarted()");
        sendEvent(cameraView, new CameraPreviewStartedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnPreviewStopped(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnPreviewStopped()");
        sendEvent(cameraView, new CameraPreviewStoppedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnShutter(@NotNull CameraView cameraView, @NotNull ShutterType type) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Log.i("CameraView", "invokeOnShutter(" + type + ")");
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", type.getUnionValue());
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap);
        sendEvent(cameraView, new CameraShutterEvent(surfaceId, id, writableMapCreateMap));
    }

    public static final void invokeOnOutputOrientationChanged(@NotNull CameraView cameraView, @NotNull Orientation outputOrientation) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        Log.i("CameraView", "invokeOnOutputOrientationChanged(" + outputOrientation + ")");
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("outputOrientation", outputOrientation.getUnionValue());
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap);
        sendEvent(cameraView, new CameraOutputOrientationChangedEvent(surfaceId, id, writableMapCreateMap));
    }

    public static final void invokeOnPreviewOrientationChanged(@NotNull CameraView cameraView, @NotNull Orientation previewOrientation) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(previewOrientation, "previewOrientation");
        Log.i("CameraView", "invokeOnPreviewOrientationChanged(" + previewOrientation + ")");
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("previewOrientation", previewOrientation.getUnionValue());
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap);
        sendEvent(cameraView, new CameraPreviewOrientationChangedEvent(surfaceId, id, writableMapCreateMap));
    }

    public static final void invokeOnError(@NotNull CameraView cameraView, @NotNull Throwable error) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(error, "error");
        SentryLogcatAdapter.e("CameraView", "invokeOnError(...):");
        error.printStackTrace();
        CameraError unknownCameraError = error instanceof CameraError ? (CameraError) error : new UnknownCameraError(error);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(ResponseTypeValues.CODE, unknownCameraError.getCode());
        writableMapCreateMap.putString("message", unknownCameraError.getMessage());
        Throwable cause = unknownCameraError.getCause();
        if (cause != null) {
            writableMapCreateMap.putMap("cause", errorToMap(cause));
        }
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap);
        sendEvent(cameraView, new CameraErrorEvent(surfaceId, id, writableMapCreateMap));
    }

    public static final void invokeOnViewReady(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        sendEvent(cameraView, new CameraViewReadyEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnAverageFpsChanged(@NotNull CameraView cameraView, double d) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnAverageFpsChanged(" + d + ")");
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("averageFps", d);
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap);
        sendEvent(cameraView, new AverageFpsChangedEvent(surfaceId, id, writableMapCreateMap));
    }

    public static final void invokeOnCodeScanned(@NotNull CameraView cameraView, @NotNull List<? extends Barcode> barcodes, @NotNull CodeScannerFrame scannerFrame) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(barcodes, "barcodes");
        Intrinsics.checkNotNullParameter(scannerFrame, "scannerFrame");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (Barcode barcode : barcodes) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("type", CodeType.Companion.fromBarcodeType(barcode.getFormat()).getUnionValue());
            writableMapCreateMap.putString("value", barcode.getRawValue());
            Rect boundingBox = barcode.getBoundingBox();
            if (boundingBox != null) {
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                writableMapCreateMap2.putInt("x", boundingBox.left);
                writableMapCreateMap2.putInt("y", boundingBox.top);
                writableMapCreateMap2.putInt("width", boundingBox.right - boundingBox.left);
                writableMapCreateMap2.putInt("height", boundingBox.bottom - boundingBox.top);
                writableMapCreateMap.putMap(TypedValues.AttributesType.S_FRAME, writableMapCreateMap2);
            }
            Point[] cornerPoints = barcode.getCornerPoints();
            if (cornerPoints != null) {
                WritableArray writableArrayCreateArray2 = Arguments.createArray();
                for (Point point : cornerPoints) {
                    WritableMap writableMapCreateMap3 = Arguments.createMap();
                    writableMapCreateMap3.putInt("x", point.x);
                    writableMapCreateMap3.putInt("y", point.y);
                    writableArrayCreateArray2.pushMap(writableMapCreateMap3);
                }
                writableMapCreateMap.putArray("corners", writableArrayCreateArray2);
            }
            writableArrayCreateArray.pushMap(writableMapCreateMap);
        }
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        writableMapCreateMap4.putArray("codes", writableArrayCreateArray);
        WritableMap writableMapCreateMap5 = Arguments.createMap();
        writableMapCreateMap5.putInt("width", scannerFrame.getWidth());
        writableMapCreateMap5.putInt("height", scannerFrame.getHeight());
        writableMapCreateMap4.putMap(TypedValues.AttributesType.S_FRAME, writableMapCreateMap5);
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap4);
        sendEvent(cameraView, new CameraCodeScannedEvent(surfaceId, id, writableMapCreateMap4));
    }

    private static final void sendEvent(CameraView cameraView, Event<?> event) {
        Context context = cameraView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, cameraView.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(event);
        }
    }

    private static final WritableMap errorToMap(Throwable th) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("message", th.getMessage());
        writableMapCreateMap.putString("stacktrace", ExceptionsKt__ExceptionsKt.stackTraceToString(th));
        Throwable cause = th.getCause();
        if (cause != null) {
            writableMapCreateMap.putMap("cause", errorToMap(cause));
        }
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }
}
