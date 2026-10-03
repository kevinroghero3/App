package com.mrousavy.camera.react;

import android.content.Context;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.CameraSession_PhotoKt;
import com.mrousavy.camera.core.Photo;
import com.mrousavy.camera.core.types.TakePhotoOptions;
import io.sentry.protocol.Device;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CameraView_TakePhotoKt {
    private static final String TAG = "CameraView.takePhoto";

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraView_TakePhotoKt$takePhoto$1, reason: invalid class name */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraView_TakePhotoKt", f = "CameraView+TakePhoto.kt", i = {}, l = {19}, m = "takePhoto", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraView_TakePhotoKt.takePhoto(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object takePhoto(@NotNull CameraView cameraView, @NotNull ReadableMap readableMap, @NotNull Continuation<? super WritableMap> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objTakePhoto = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objTakePhoto);
            Log.i(TAG, "Taking photo... Options: " + readableMap.toHashMap());
            TakePhotoOptions.Companion companion = TakePhotoOptions.Companion;
            Context context = cameraView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            TakePhotoOptions takePhotoOptionsFromJS = companion.fromJS(context, readableMap);
            CameraSession cameraSession$react_native_vision_camera_release = cameraView.getCameraSession$react_native_vision_camera_release();
            anonymousClass1.label = 1;
            objTakePhoto = CameraSession_PhotoKt.takePhoto(cameraSession$react_native_vision_camera_release, takePhotoOptionsFromJS, anonymousClass1);
            if (objTakePhoto == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objTakePhoto);
        }
        Photo photo = (Photo) objTakePhoto;
        Log.i(TAG, "Successfully captured " + photo.getWidth() + " x " + photo.getHeight() + " photo!");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("path", photo.getPath());
        writableMapCreateMap.putInt("width", photo.getWidth());
        writableMapCreateMap.putInt("height", photo.getHeight());
        writableMapCreateMap.putString(Device.JsonKeys.ORIENTATION, photo.getOrientation().getUnionValue());
        writableMapCreateMap.putBoolean("isRawPhoto", false);
        writableMapCreateMap.putBoolean("isMirrored", photo.isMirrored());
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }
}
