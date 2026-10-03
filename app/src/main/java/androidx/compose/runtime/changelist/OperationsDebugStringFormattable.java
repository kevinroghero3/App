package androidx.compose.runtime.changelist;

import com.transistorsoft.locationmanager.logger.TSLog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class OperationsDebugStringFormattable {
    public static final int $stable = 0;

    public abstract String toDebugString(@NotNull String str);

    public static /* synthetic */ String toDebugString$default(OperationsDebugStringFormattable operationsDebugStringFormattable, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toDebugString");
        }
        if ((i & 1) != 0) {
            str = TSLog.TAB;
        }
        return operationsDebugStringFormattable.toDebugString(str);
    }
}
