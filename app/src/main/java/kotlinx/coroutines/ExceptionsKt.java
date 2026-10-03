package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ExceptionsKt {
    public static final CancellationException CancellationException(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
