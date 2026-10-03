package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
class PreconditionsKt__PreconditionsKt extends PreconditionsKt__AssertionsJVMKt {
    private static final void require(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    private static final void require(boolean z, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (!z) {
            throw new IllegalArgumentException(lazyMessage.invoke().toString());
        }
    }

    private static final <T> T requireNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    private static final <T> T requireNotNull(T t, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(lazyMessage.invoke().toString());
    }

    private static final void check(boolean z) {
        if (!z) {
            throw new IllegalStateException("Check failed.");
        }
    }

    private static final void check(boolean z, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (!z) {
            throw new IllegalStateException(lazyMessage.invoke().toString());
        }
    }

    private static final <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.");
    }

    private static final <T> T checkNotNull(T t, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(lazyMessage.invoke().toString());
    }

    private static final Void error(Object message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new IllegalStateException(message.toString());
    }
}
