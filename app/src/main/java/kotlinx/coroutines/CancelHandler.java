package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface CancelHandler extends NotCompleted {
    void invoke(@Nullable Throwable th);

    /* JADX INFO: loaded from: classes3.dex */
    public static final class UserSupplied implements CancelHandler {
        private final Function1<Throwable, Unit> handler;

        /* JADX WARN: Multi-variable type inference failed */
        public UserSupplied(@NotNull Function1<? super Throwable, Unit> function1) {
            this.handler = function1;
        }

        @Override // kotlinx.coroutines.CancelHandler
        public void invoke(@Nullable Throwable th) {
            this.handler.invoke(th);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + DebugStringsKt.getClassSimpleName(this.handler) + '@' + DebugStringsKt.getHexAddress(this) + ']';
        }
    }
}
