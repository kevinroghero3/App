package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class OnTimeoutKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R> void onTimeout(@NotNull SelectBuilder<? super R> selectBuilder, long j, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectBuilder.invoke(new OnTimeout(j).getSelectClause(), (Function1<? super Continuation<? super Object>, ? extends Object>) function1);
    }

    /* JADX INFO: renamed from: onTimeout-8Mi8wO0, reason: not valid java name */
    public static final <R> void m7068onTimeout8Mi8wO0(@NotNull SelectBuilder<? super R> selectBuilder, long j, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        onTimeout(selectBuilder, DelayKt.m6977toDelayMillisLRDsOJo(j), function1);
    }
}
