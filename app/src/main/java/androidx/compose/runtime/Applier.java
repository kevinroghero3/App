package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface Applier<N> {
    void clear();

    void down(N n2);

    N getCurrent();

    void insertBottomUp(int i, N n2);

    void insertTopDown(int i, N n2);

    void move(int i, int i2, int i3);

    default void onBeginChanges() {
    }

    default void onEndChanges() {
    }

    void remove(int i, int i2);

    void up();

    /* JADX INFO: loaded from: classes3.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <N> void onBeginChanges(@NotNull Applier<N> applier) {
            Applier.super.onBeginChanges();
        }

        @Deprecated
        public static <N> void onEndChanges(@NotNull Applier<N> applier) {
            Applier.super.onEndChanges();
        }
    }
}
