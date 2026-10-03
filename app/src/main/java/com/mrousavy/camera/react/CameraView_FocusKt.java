package com.mrousavy.camera.react;

import android.content.res.Resources;
import androidx.camera.core.MeteringPoint;
import androidx.camera.view.PreviewView;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.CameraSession_FocusKt;
import com.mrousavy.camera.core.FocusRequiresPreviewError;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CameraView_FocusKt {

    /* JADX INFO: renamed from: com.mrousavy.camera.react.CameraView_FocusKt$focus$1, reason: invalid class name */
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraView_FocusKt", f = "CameraView+Focus.kt", i = {0, 0, 0, 0}, l = {27, 18}, m = "focus", n = {"$this$focus", "previewView", "x", "y"}, s = {"L$0", "L$1", "D$0", "D$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        double D$0;
        double D$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraView_FocusKt.focus(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object focus(@NotNull CameraView cameraView, @NotNull ReadableMap readableMap, @NotNull Continuation<? super Unit> continuation) throws FocusRequiresPreviewError {
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
        Object result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(result);
            final double d = readableMap.getDouble("x");
            final double d2 = readableMap.getDouble("y");
            final PreviewView previewView$react_native_vision_camera_release = cameraView.getPreviewView$react_native_vision_camera_release();
            if (previewView$react_native_vision_camera_release == null) {
                throw new FocusRequiresPreviewError();
            }
            if (UiThreadUtil.isOnUiThread()) {
                float f = Resources.getSystem().getDisplayMetrics().density;
                result = previewView$react_native_vision_camera_release.getMeteringPointFactory().createPoint(((float) d) * f, ((float) d2) * f);
            } else {
                anonymousClass1.L$0 = cameraView;
                anonymousClass1.L$1 = previewView$react_native_vision_camera_release;
                anonymousClass1.D$0 = d;
                anonymousClass1.D$1 = d2;
                anonymousClass1.label = 1;
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(anonymousClass1), 1);
                cancellableContinuationImpl.initCancellability();
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.react.CameraView_FocusKt$focus$$inlined$runOnUiThreadAndWait$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (cancellableContinuationImpl.isCancelled()) {
                            throw new CancellationException();
                        }
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        MeteringPoint meteringPointCreatePoint = previewView$react_native_vision_camera_release.getMeteringPointFactory().createPoint(((float) d) * f2, ((float) d2) * f2);
                        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.Companion;
                        cancellableContinuation.resumeWith(Result.m5472constructorimpl(meteringPointCreatePoint));
                    }
                });
                result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(anonymousClass1);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i2 == 1) {
                cameraView = (CameraView) anonymousClass1.L$0;
                ResultKt.throwOnFailure(result);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(result);
            }
            return Unit.INSTANCE;
        }
        Intrinsics.checkNotNullExpressionValue(result, "runOnUiThreadAndWait(...)");
        CameraSession cameraSession$react_native_vision_camera_release = cameraView.getCameraSession$react_native_vision_camera_release();
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 2;
        if (CameraSession_FocusKt.focus(cameraSession$react_native_vision_camera_release, (MeteringPoint) result, anonymousClass1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
