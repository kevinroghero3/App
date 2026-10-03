package androidx.camera.core;

import android.graphics.Bitmap;
import androidx.camera.core.imagecapture.RequestWithCallback;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageCaptureExtKt {
    public static /* synthetic */ Object takePicture$default(ImageCapture imageCapture, Function0 function0, Function1 function1, Function1 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        return takePicture(imageCapture, function0, function1, function2, continuation);
    }

    public static final TakePictureRequest getTakePictureRequest(@NotNull ImageCapture imageCapture) {
        Intrinsics.checkNotNullParameter(imageCapture, "<this>");
        RequestWithCallback capturingRequest = imageCapture.getTakePictureManager().getCapturingRequest();
        if (capturingRequest != null) {
            return capturingRequest.getTakePictureRequest();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, androidx.camera.core.DelegatingImageCapturedCallback] */
    public static final Object takePicture(@NotNull ImageCapture imageCapture, @Nullable final Function0<Unit> function0, @Nullable final Function1<? super Integer, Unit> function1, @Nullable final Function1<? super Bitmap, Unit> function2, @NotNull Continuation<? super ImageProxy> continuation) {
        Executor executorDirectExecutor;
        CoroutineContext.Element element = continuation.getContext().get(ContinuationInterceptor.Key);
        DelegatingImageCapturedCallback delegatingImageCapturedCallback = null;
        CoroutineDispatcher coroutineDispatcher = element instanceof CoroutineDispatcher ? (CoroutineDispatcher) element : null;
        if (coroutineDispatcher == null || (executorDirectExecutor = ExecutorsKt.asExecutor(coroutineDispatcher)) == null) {
            executorDirectExecutor = CameraXExecutors.directExecutor();
            Intrinsics.checkNotNullExpressionValue(executorDirectExecutor, "directExecutor()");
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new DelegatingImageCapturedCallback(new ImageCapture.OnImageCapturedCallback() { // from class: androidx.camera.core.ImageCaptureExtKt$takePicture$2$1
            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onCaptureStarted() {
                Function0<Unit> function3 = function0;
                if (function3 != null) {
                    function3.invoke();
                }
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onCaptureProcessProgressed(int i) {
                Function1<Integer, Unit> function3 = function1;
                if (function3 != null) {
                    function3.invoke(Integer.valueOf(i));
                }
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onPostviewBitmapAvailable(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                Function1<Bitmap, Unit> function3 = function2;
                if (function3 != null) {
                    function3.invoke(bitmap);
                }
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onCaptureSuccess(ImageProxy imageProxy) {
                DelegatingImageCapturedCallback delegatingImageCapturedCallback2;
                Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
                DelegatingImageCapturedCallback delegatingImageCapturedCallback3 = objectRef.element;
                if (delegatingImageCapturedCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("delegatingCallback");
                    delegatingImageCapturedCallback2 = null;
                } else {
                    delegatingImageCapturedCallback2 = delegatingImageCapturedCallback3;
                }
                delegatingImageCapturedCallback2.dispose();
                CancellableContinuation<ImageProxy> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m5472constructorimpl(imageProxy));
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onError(ImageCaptureException exception) {
                DelegatingImageCapturedCallback delegatingImageCapturedCallback2;
                Intrinsics.checkNotNullParameter(exception, "exception");
                DelegatingImageCapturedCallback delegatingImageCapturedCallback3 = objectRef.element;
                if (delegatingImageCapturedCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("delegatingCallback");
                    delegatingImageCapturedCallback2 = null;
                } else {
                    delegatingImageCapturedCallback2 = delegatingImageCapturedCallback3;
                }
                delegatingImageCapturedCallback2.dispose();
                CancellableContinuation<ImageProxy> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m5472constructorimpl(ResultKt.createFailure(exception)));
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.camera.core.ImageCaptureExtKt$takePicture$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                DelegatingImageCapturedCallback delegatingImageCapturedCallback2;
                DelegatingImageCapturedCallback delegatingImageCapturedCallback3 = objectRef.element;
                if (delegatingImageCapturedCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("delegatingCallback");
                    delegatingImageCapturedCallback2 = null;
                } else {
                    delegatingImageCapturedCallback2 = delegatingImageCapturedCallback3;
                }
                delegatingImageCapturedCallback2.dispose();
            }
        });
        T t = objectRef.element;
        if (t == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("delegatingCallback");
        } else {
            delegatingImageCapturedCallback = (DelegatingImageCapturedCallback) t;
        }
        imageCapture.lambda$takePicture$1(executorDirectExecutor, delegatingImageCapturedCallback);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, androidx.camera.core.DelegatingImageSavedCallback] */
    public static final Object takePicture(@NotNull ImageCapture imageCapture, @NotNull ImageCapture.OutputFileOptions outputFileOptions, @Nullable final Function0<Unit> function0, @Nullable final Function1<? super Integer, Unit> function1, @Nullable final Function1<? super Bitmap, Unit> function2, @NotNull Continuation<? super ImageCapture.OutputFileResults> continuation) {
        Executor executorDirectExecutor;
        CoroutineContext.Element element = continuation.getContext().get(ContinuationInterceptor.Key);
        DelegatingImageSavedCallback delegatingImageSavedCallback = null;
        CoroutineDispatcher coroutineDispatcher = element instanceof CoroutineDispatcher ? (CoroutineDispatcher) element : null;
        if (coroutineDispatcher == null || (executorDirectExecutor = ExecutorsKt.asExecutor(coroutineDispatcher)) == null) {
            executorDirectExecutor = CameraXExecutors.directExecutor();
            Intrinsics.checkNotNullExpressionValue(executorDirectExecutor, "directExecutor()");
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new DelegatingImageSavedCallback(new ImageCapture.OnImageSavedCallback() { // from class: androidx.camera.core.ImageCaptureExtKt$takePicture$4$1
            @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
            public void onCaptureStarted() {
                Function0<Unit> function3 = function0;
                if (function3 != null) {
                    function3.invoke();
                }
            }

            @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
            public void onCaptureProcessProgressed(int i) {
                Function1<Integer, Unit> function3 = function1;
                if (function3 != null) {
                    function3.invoke(Integer.valueOf(i));
                }
            }

            @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
            public void onPostviewBitmapAvailable(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                Function1<Bitmap, Unit> function3 = function2;
                if (function3 != null) {
                    function3.invoke(bitmap);
                }
            }

            @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
            public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
                DelegatingImageSavedCallback delegatingImageSavedCallback2;
                Intrinsics.checkNotNullParameter(outputFileResults, "outputFileResults");
                DelegatingImageSavedCallback delegatingImageSavedCallback3 = objectRef.element;
                if (delegatingImageSavedCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("delegatingCallback");
                    delegatingImageSavedCallback2 = null;
                } else {
                    delegatingImageSavedCallback2 = delegatingImageSavedCallback3;
                }
                delegatingImageSavedCallback2.dispose();
                CancellableContinuation<ImageCapture.OutputFileResults> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m5472constructorimpl(outputFileResults));
            }

            @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
            public void onError(ImageCaptureException exception) {
                DelegatingImageSavedCallback delegatingImageSavedCallback2;
                Intrinsics.checkNotNullParameter(exception, "exception");
                DelegatingImageSavedCallback delegatingImageSavedCallback3 = objectRef.element;
                if (delegatingImageSavedCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("delegatingCallback");
                    delegatingImageSavedCallback2 = null;
                } else {
                    delegatingImageSavedCallback2 = delegatingImageSavedCallback3;
                }
                delegatingImageSavedCallback2.dispose();
                CancellableContinuation<ImageCapture.OutputFileResults> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m5472constructorimpl(ResultKt.createFailure(exception)));
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.camera.core.ImageCaptureExtKt$takePicture$4$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                DelegatingImageSavedCallback delegatingImageSavedCallback2;
                DelegatingImageSavedCallback delegatingImageSavedCallback3 = objectRef.element;
                if (delegatingImageSavedCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("delegatingCallback");
                    delegatingImageSavedCallback2 = null;
                } else {
                    delegatingImageSavedCallback2 = delegatingImageSavedCallback3;
                }
                delegatingImageSavedCallback2.dispose();
            }
        });
        T t = objectRef.element;
        if (t == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("delegatingCallback");
        } else {
            delegatingImageSavedCallback = (DelegatingImageSavedCallback) t;
        }
        imageCapture.lambda$takePicture$2(outputFileOptions, executorDirectExecutor, delegatingImageSavedCallback);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
