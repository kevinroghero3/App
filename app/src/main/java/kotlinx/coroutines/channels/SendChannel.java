package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface SendChannel<E> {
    boolean close(@Nullable Throwable th);

    SelectClause2<E, SendChannel<E>> getOnSend();

    void invokeOnClose(@NotNull Function1<? super Throwable, Unit> function1);

    boolean isClosedForSend();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    boolean offer(E e);

    Object send(E e, @NotNull Continuation<? super Unit> continuation);

    /* JADX INFO: renamed from: trySend-JP2dKIU */
    Object mo6988trySendJP2dKIU(E e);

    public static final class DefaultImpls {
        public static /* synthetic */ void isClosedForSend$annotations() {
        }

        public static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return sendChannel.close(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean offer(@NotNull SendChannel<? super E> sendChannel, E e) throws Throwable {
            Object objMo6988trySendJP2dKIU = sendChannel.mo6988trySendJP2dKIU(e);
            if (ChannelResult.m7013isSuccessimpl(objMo6988trySendJP2dKIU)) {
                return true;
            }
            Throwable thM7007exceptionOrNullimpl = ChannelResult.m7007exceptionOrNullimpl(objMo6988trySendJP2dKIU);
            if (thM7007exceptionOrNullimpl == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(thM7007exceptionOrNullimpl);
        }
    }
}
