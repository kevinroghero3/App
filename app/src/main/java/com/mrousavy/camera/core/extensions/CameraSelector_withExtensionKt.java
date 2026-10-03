package com.mrousavy.camera.core.extensions;

import android.content.Context;
import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;
import com.facebook.share.internal.ShareConstants;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraSelector_withExtensionKt {
    private static final String TAG = "CameraSelector";

    /* JADX INFO: renamed from: com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt$withExtension$1, reason: invalid class name */
    @DebugMetadata(c = "com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt", f = "CameraSelector+withExtension.kt", i = {0, 0, 0, 0}, l = {22}, m = "withExtension", n = {"$this$withExtension", "extensionDebugName", "needsImageAnalysis", ShareConstants.MEDIA_EXTENSION}, s = {"L$0", "L$1", "Z$0", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSelector_withExtensionKt.withExtension(null, null, null, false, 0, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object withExtension(@NotNull CameraSelector cameraSelector, @NotNull Context context, @NotNull ProcessCameraProvider processCameraProvider, boolean z, int i, @NotNull String str, @NotNull Continuation<? super CameraSelector> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objAwait);
            Log.i(TAG, str + " is enabled, looking up vendor " + str + " extension...");
            Executor mainExecutor = ContextCompat.getMainExecutor(context);
            Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
            ListenableFuture<ExtensionsManager> instanceAsync = ExtensionsManager.getInstanceAsync(context, processCameraProvider);
            Intrinsics.checkNotNullExpressionValue(instanceAsync, "getInstanceAsync(...)");
            anonymousClass1.L$0 = cameraSelector;
            anonymousClass1.L$1 = str;
            anonymousClass1.Z$0 = z;
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            objAwait = ListenableFuture_awaitKt.await(instanceAsync, mainExecutor, anonymousClass1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = anonymousClass1.I$0;
            z = anonymousClass1.Z$0;
            str = (String) anonymousClass1.L$1;
            cameraSelector = (CameraSelector) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAwait);
        }
        ExtensionsManager extensionsManager = (ExtensionsManager) objAwait;
        if (!extensionsManager.isExtensionAvailable(cameraSelector, i)) {
            return cameraSelector;
        }
        if (z && !extensionsManager.isImageAnalysisSupported(cameraSelector, i)) {
            Log.i(TAG, "Device supports a " + str + " vendor extension, but we cannot use it since we need ImageAnalysis and this extension does not work with ImageAnalysis use-cases.");
            return cameraSelector;
        }
        Log.i(TAG, "Device supports a " + str + " vendor extension! Enabling...");
        CameraSelector extensionEnabledCameraSelector = extensionsManager.getExtensionEnabledCameraSelector(cameraSelector, i);
        Intrinsics.checkNotNullExpressionValue(extensionEnabledCameraSelector, "getExtensionEnabledCameraSelector(...)");
        return extensionEnabledCameraSelector;
    }
}
