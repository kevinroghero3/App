package kotlin.jvm.functions;

import kotlin.Function;
import kotlin.jvm.internal.FunctionBase;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface FunctionN<R> extends Function<R>, FunctionBase<R> {
    int getArity();

    R invoke(@NotNull Object... objArr);
}
