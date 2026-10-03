package androidx.lifecycle.viewmodel.internal;

import kotlin.NotImplementedError;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class CloseableCoroutineScopeKt {
    public static final String VIEW_MODEL_SCOPE_KEY = "androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY";

    public static final CloseableCoroutineScope createViewModelScope() {
        CoroutineContext immediate;
        try {
            immediate = Dispatchers.getMain().getImmediate();
        } catch (IllegalStateException unused) {
            immediate = EmptyCoroutineContext.INSTANCE;
        } catch (NotImplementedError unused2) {
            immediate = EmptyCoroutineContext.INSTANCE;
        }
        return new CloseableCoroutineScope(immediate.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    public static final CloseableCoroutineScope asCloseable(@NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        return new CloseableCoroutineScope(coroutineScope);
    }
}
