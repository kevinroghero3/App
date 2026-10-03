package com.mrousavy.camera.core;

import android.util.Log;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.MeteringPoint;
import com.google.common.util.concurrent.ListenableFuture;
import com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CameraSession_FocusKt {

    /* JADX INFO: renamed from: com.mrousavy.camera.core.CameraSession_FocusKt$focus$1, reason: invalid class name */
    @DebugMetadata(c = "com.mrousavy.camera.core.CameraSession_FocusKt", f = "CameraSession+Focus.kt", i = {}, l = {22}, m = "focus", n = {}, s = {})
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
            return CameraSession_FocusKt.focus(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object focus(@NotNull CameraSession cameraSession, @NotNull MeteringPoint meteringPoint, @NotNull Continuation<? super Unit> continuation) throws Throwable {
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
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAwait);
                Camera camera$react_native_vision_camera_release = cameraSession.getCamera$react_native_vision_camera_release();
                if (camera$react_native_vision_camera_release == null) {
                    throw new CameraNotReadyError();
                }
                FocusMeteringAction focusMeteringActionBuild = new FocusMeteringAction.Builder(meteringPoint).build();
                Intrinsics.checkNotNullExpressionValue(focusMeteringActionBuild, "build(...)");
                if (!camera$react_native_vision_camera_release.getCameraInfo().isFocusMeteringSupported(focusMeteringActionBuild)) {
                    throw new FocusNotSupportedError();
                }
                List<MeteringPoint> meteringPointsAf = focusMeteringActionBuild.getMeteringPointsAf();
                Intrinsics.checkNotNullExpressionValue(meteringPointsAf, "getMeteringPointsAf(...)");
                Log.i(CameraSession.TAG, "Focusing to " + CollectionsKt___CollectionsKt.joinToString$default(meteringPointsAf, null, null, null, 0, null, new Function1() { // from class: com.mrousavy.camera.core.CameraSession_FocusKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CameraSession_FocusKt.focus$lambda$0((MeteringPoint) obj);
                    }
                }, 31, null) + "...");
                ListenableFuture<FocusMeteringResult> listenableFutureStartFocusAndMetering = camera$react_native_vision_camera_release.getCameraControl().startFocusAndMetering(focusMeteringActionBuild);
                Intrinsics.checkNotNullExpressionValue(listenableFutureStartFocusAndMetering, "startFocusAndMetering(...)");
                ExecutorService cameraExecutor = CameraQueues.Companion.getCameraExecutor();
                anonymousClass1.label = 1;
                objAwait = ListenableFuture_awaitKt.await(listenableFutureStartFocusAndMetering, cameraExecutor, anonymousClass1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objAwait);
            }
            if (((FocusMeteringResult) objAwait).isFocusSuccessful()) {
                Log.i(CameraSession.TAG, "Focused successfully!");
            } else {
                Log.i(CameraSession.TAG, "Focus failed.");
            }
            return Unit.INSTANCE;
        } catch (CameraControl.OperationCanceledException unused) {
            throw new FocusCanceledError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence focus$lambda$0(MeteringPoint meteringPoint) {
        return "(" + meteringPoint.getX() + ", " + meteringPoint.getY() + ")";
    }
}
