package androidx.camera.lifecycle;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface LifecycleCameraProvider extends CameraProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmStatic
    static Object createInstance(@NotNull Context context, @Nullable CameraXConfig cameraXConfig, @NotNull Continuation<? super LifecycleCameraProvider> continuation) {
        return Companion.createInstance(context, cameraXConfig, continuation);
    }

    @JvmStatic
    static Object createInstance(@NotNull Context context, @NotNull Continuation<? super LifecycleCameraProvider> continuation) {
        return Companion.createInstance(context, continuation);
    }

    @JvmStatic
    static ListenableFuture<LifecycleCameraProvider> createInstanceAsync(@NotNull Context context) {
        return Companion.createInstanceAsync(context);
    }

    @JvmStatic
    static ListenableFuture<LifecycleCameraProvider> createInstanceAsync(@NotNull Context context, @Nullable CameraXConfig cameraXConfig) {
        return Companion.createInstanceAsync(context, cameraXConfig);
    }

    Camera bindToLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull CameraSelector cameraSelector, @NotNull UseCaseGroup useCaseGroup);

    Camera bindToLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull CameraSelector cameraSelector, @NotNull UseCase... useCaseArr);

    ConcurrentCamera bindToLifecycle(@NotNull List<ConcurrentCamera.SingleCameraConfig> list);

    boolean isBound(@NotNull UseCase useCase);

    void unbind(@NotNull UseCase... useCaseArr);

    void unbindAll();

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @JvmStatic
        public final Object createInstance(@NotNull Context context, @NotNull Continuation<? super LifecycleCameraProvider> continuation) {
            return createInstance$default(this, context, null, continuation, 2, null);
        }

        @JvmStatic
        public final ListenableFuture<LifecycleCameraProvider> createInstanceAsync(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return createInstanceAsync$default(this, context, null, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ Object createInstance$default(Companion companion, Context context, CameraXConfig cameraXConfig, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                cameraXConfig = null;
            }
            return companion.createInstance(context, cameraXConfig, continuation);
        }

        @JvmStatic
        public final Object createInstance(@NotNull Context context, @Nullable CameraXConfig cameraXConfig, @NotNull Continuation<? super LifecycleCameraProvider> continuation) {
            return ListenableFutureKt.await(createInstanceAsync(context, cameraXConfig), continuation);
        }

        public static /* synthetic */ ListenableFuture createInstanceAsync$default(Companion companion, Context context, CameraXConfig cameraXConfig, int i, Object obj) {
            if ((i & 2) != 0) {
                cameraXConfig = null;
            }
            return companion.createInstanceAsync(context, cameraXConfig);
        }

        @JvmStatic
        public final ListenableFuture<LifecycleCameraProvider> createInstanceAsync(@NotNull Context context, @Nullable CameraXConfig cameraXConfig) {
            Intrinsics.checkNotNullParameter(context, "context");
            Preconditions.checkNotNull(context);
            final LifecycleCameraProviderImpl lifecycleCameraProviderImpl = new LifecycleCameraProviderImpl();
            ListenableFuture<Void> listenableFutureInitAsync$camera_lifecycle_release = lifecycleCameraProviderImpl.initAsync$camera_lifecycle_release(context, cameraXConfig);
            final Function1<Void, LifecycleCameraProvider> function1 = new Function1<Void, LifecycleCameraProvider>() { // from class: androidx.camera.lifecycle.LifecycleCameraProvider$Companion$createInstanceAsync$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final LifecycleCameraProvider invoke(Void r1) {
                    return lifecycleCameraProviderImpl;
                }
            };
            ListenableFuture<LifecycleCameraProvider> listenableFutureTransform = Futures.transform(listenableFutureInitAsync$camera_lifecycle_release, new Function() { // from class: androidx.camera.lifecycle.LifecycleCameraProvider$Companion$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return LifecycleCameraProvider.Companion.createInstanceAsync$lambda$0(function1, obj);
                }
            }, CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(listenableFutureTransform, "lifecycleCameraProvider …tExecutor()\n            )");
            return listenableFutureTransform;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LifecycleCameraProvider createInstanceAsync$lambda$0(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (LifecycleCameraProvider) tmp0.invoke(obj);
        }
    }
}
