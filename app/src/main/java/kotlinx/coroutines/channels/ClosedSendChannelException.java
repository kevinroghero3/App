package kotlinx.coroutines.channels;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ClosedSendChannelException extends IllegalStateException {
    public ClosedSendChannelException(@Nullable String str) {
        super(str);
    }
}
