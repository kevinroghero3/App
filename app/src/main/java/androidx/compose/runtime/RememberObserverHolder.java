package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class RememberObserverHolder {
    public static final int $stable = 8;
    private Anchor after;
    private RememberObserver wrapped;

    public RememberObserverHolder(@NotNull RememberObserver rememberObserver, @Nullable Anchor anchor) {
        this.wrapped = rememberObserver;
        this.after = anchor;
    }

    public final RememberObserver getWrapped() {
        return this.wrapped;
    }

    public final void setWrapped(@NotNull RememberObserver rememberObserver) {
        this.wrapped = rememberObserver;
    }

    public final Anchor getAfter() {
        return this.after;
    }

    public final void setAfter(@Nullable Anchor anchor) {
        this.after = anchor;
    }
}
