package kotlinx.coroutines.internal;

import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class Symbol {
    public final String symbol;

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T unbox(@Nullable Object obj) {
        if (obj == this) {
            return null;
        }
        return obj;
    }

    public Symbol(@NotNull String str) {
        this.symbol = str;
    }

    public String toString() {
        return Typography.less + this.symbol + Typography.greater;
    }
}
