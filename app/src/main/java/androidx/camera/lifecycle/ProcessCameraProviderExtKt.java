package androidx.camera.lifecycle;

import android.content.Context;
import androidx.concurrent.futures.ListenableFutureKt;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ProcessCameraProviderExtKt {
    public static final Object awaitInstance(@NotNull ProcessCameraProvider.Companion companion, @NotNull Context context, @NotNull Continuation<? super ProcessCameraProvider> continuation) {
        return ListenableFutureKt.await(companion.getInstance(context), continuation);
    }
}
