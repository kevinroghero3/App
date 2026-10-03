package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ResultKt {
    public static final Object createFailure(@NotNull Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return new Result.Failure(exception);
    }

    public static final void throwOnFailure(@NotNull Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    private static final <R> Object runCatching(Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Result.Companion companion = Result.Companion;
            return Result.m5472constructorimpl(block.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m5472constructorimpl(createFailure(th));
        }
    }

    private static final <T, R> Object runCatching(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Result.Companion companion = Result.Companion;
            return Result.m5472constructorimpl(block.invoke(t));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m5472constructorimpl(createFailure(th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> T getOrThrow(Object obj) {
        throwOnFailure(obj);
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrElse(Object obj, Function1<? super Throwable, ? extends R> onFailure) {
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable thM5475exceptionOrNullimpl = Result.m5475exceptionOrNullimpl(obj);
        return thM5475exceptionOrNullimpl == null ? obj : onFailure.invoke(thM5475exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrDefault(Object obj, R r) {
        return Result.m5478isFailureimpl(obj) ? r : obj;
    }

    private static final <R, T> R fold(Object obj, Function1<? super T, ? extends R> onSuccess, Function1<? super Throwable, ? extends R> onFailure) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable thM5475exceptionOrNullimpl = Result.m5475exceptionOrNullimpl(obj);
        if (thM5475exceptionOrNullimpl == null) {
            return onSuccess.invoke(obj);
        }
        return onFailure.invoke(thM5475exceptionOrNullimpl);
    }

    private static final <R, T> Object map(Object obj, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (!Result.m5479isSuccessimpl(obj)) {
            return Result.m5472constructorimpl(obj);
        }
        Result.Companion companion = Result.Companion;
        return Result.m5472constructorimpl(transform.invoke(obj));
    }

    private static final <R, T> Object mapCatching(Object obj, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (!Result.m5479isSuccessimpl(obj)) {
            return Result.m5472constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.Companion;
            return Result.m5472constructorimpl(transform.invoke(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m5472constructorimpl(createFailure(th));
        }
    }

    private static final <R, T extends R> Object recover(Object obj, Function1<? super Throwable, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable thM5475exceptionOrNullimpl = Result.m5475exceptionOrNullimpl(obj);
        if (thM5475exceptionOrNullimpl == null) {
            return obj;
        }
        Result.Companion companion = Result.Companion;
        return Result.m5472constructorimpl(transform.invoke(thM5475exceptionOrNullimpl));
    }

    private static final <R, T extends R> Object recoverCatching(Object obj, Function1<? super Throwable, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable thM5475exceptionOrNullimpl = Result.m5475exceptionOrNullimpl(obj);
        if (thM5475exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            Result.Companion companion = Result.Companion;
            return Result.m5472constructorimpl(transform.invoke(thM5475exceptionOrNullimpl));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m5472constructorimpl(createFailure(th));
        }
    }

    private static final <T> Object onFailure(Object obj, Function1<? super Throwable, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Throwable thM5475exceptionOrNullimpl = Result.m5475exceptionOrNullimpl(obj);
        if (thM5475exceptionOrNullimpl != null) {
            action.invoke(thM5475exceptionOrNullimpl);
        }
        return obj;
    }

    private static final <T> Object onSuccess(Object obj, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Result.m5479isSuccessimpl(obj)) {
            action.invoke(obj);
        }
        return obj;
    }
}
