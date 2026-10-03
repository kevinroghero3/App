package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class MovableContent<P> {
    public static final int $stable = 0;
    private final Function3<P, Composer, Integer, Unit> content;

    /* JADX WARN: Multi-variable type inference failed */
    public MovableContent(@NotNull Function3<? super P, ? super Composer, ? super Integer, Unit> function3) {
        this.content = function3;
    }

    public final Function3<P, Composer, Integer, Unit> getContent() {
        return this.content;
    }
}
