package androidx.navigation;

import androidx.annotation.IdRes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class NavGraphKt {
    public static final boolean contains(@NotNull NavGraph navGraph, @IdRes int i) {
        return NavGraphKt__NavGraph_androidKt.contains(navGraph, i);
    }

    public static final <T> boolean contains(@NotNull NavGraph navGraph, @NotNull T t) {
        return NavGraphKt__NavGraphKt.contains(navGraph, t);
    }

    public static final boolean contains(@NotNull NavGraph navGraph, @NotNull String str) {
        return NavGraphKt__NavGraphKt.contains(navGraph, str);
    }

    public static final NavDestination get(@NotNull NavGraph navGraph, @IdRes int i) {
        return NavGraphKt__NavGraph_androidKt.get(navGraph, i);
    }

    public static final <T> NavDestination get(@NotNull NavGraph navGraph, @NotNull T t) {
        return NavGraphKt__NavGraphKt.get(navGraph, t);
    }

    public static final NavDestination get(@NotNull NavGraph navGraph, @NotNull String str) {
        return NavGraphKt__NavGraphKt.get(navGraph, str);
    }

    public static final void minusAssign(@NotNull NavGraph navGraph, @NotNull NavDestination navDestination) {
        NavGraphKt__NavGraphKt.minusAssign(navGraph, navDestination);
    }

    public static final void plusAssign(@NotNull NavGraph navGraph, @NotNull NavDestination navDestination) {
        NavGraphKt__NavGraphKt.plusAssign(navGraph, navDestination);
    }

    public static final void plusAssign(@NotNull NavGraph navGraph, @NotNull NavGraph navGraph2) {
        NavGraphKt__NavGraphKt.plusAssign(navGraph, navGraph2);
    }
}
