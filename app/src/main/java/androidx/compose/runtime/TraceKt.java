package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class TraceKt {
    public static final <T> T trace(@NotNull String str, @NotNull Function0<? extends T> function0) {
        Object objBeginSection = Trace.INSTANCE.beginSection(str);
        try {
            T tInvoke = function0.invoke();
            InlineMarker.finallyStart(1);
            return tInvoke;
        } finally {
            InlineMarker.finallyStart(1);
            Trace.INSTANCE.endSection(objBeginSection);
            InlineMarker.finallyEnd(1);
        }
    }
}
