package androidx.navigation;

import androidx.annotation.IdRes;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class NavGraphBuilderKt {
    @Deprecated(message = "Use routes to build your NavGraph instead", replaceWith = @ReplaceWith(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final NavGraph navigation(@NotNull NavigatorProvider navigatorProvider, @IdRes int i, @IdRes int i2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavGraphBuilderKt__NavGraphBuilder_androidKt.navigation(navigatorProvider, i, i2, function1);
    }

    public static final NavGraph navigation(@NotNull NavigatorProvider navigatorProvider, @NotNull Object obj, @Nullable KClass<?> kClass, @NotNull Map<KType, NavType<?>> map, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavGraphBuilderKt__NavGraphBuilderKt.navigation(navigatorProvider, obj, kClass, map, function1);
    }

    public static final NavGraph navigation(@NotNull NavigatorProvider navigatorProvider, @NotNull String str, @Nullable String str2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavGraphBuilderKt__NavGraphBuilderKt.navigation(navigatorProvider, str, str2, function1);
    }

    public static final NavGraph navigation(@NotNull NavigatorProvider navigatorProvider, @NotNull KClass<?> kClass, @Nullable KClass<?> kClass2, @NotNull Map<KType, NavType<?>> map, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavGraphBuilderKt__NavGraphBuilderKt.navigation(navigatorProvider, kClass, kClass2, map, function1);
    }

    @Deprecated(message = "Use routes to build your nested NavGraph instead", replaceWith = @ReplaceWith(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final void navigation(@NotNull NavGraphBuilder navGraphBuilder, @IdRes int i, @IdRes int i2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        NavGraphBuilderKt__NavGraphBuilder_androidKt.navigation(navGraphBuilder, i, i2, function1);
    }

    public static final void navigation(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull String str2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        NavGraphBuilderKt__NavGraphBuilderKt.navigation(navGraphBuilder, str, str2, function1);
    }

    public static final <T> void navigation(@NotNull NavGraphBuilder navGraphBuilder, @NotNull KClass<T> kClass, @NotNull Object obj, @NotNull Map<KType, NavType<?>> map, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        NavGraphBuilderKt__NavGraphBuilderKt.navigation(navGraphBuilder, kClass, obj, map, function1);
    }

    public static final <T> void navigation(@NotNull NavGraphBuilder navGraphBuilder, @NotNull KClass<T> kClass, @NotNull KClass<?> kClass2, @NotNull Map<KType, NavType<?>> map, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        NavGraphBuilderKt__NavGraphBuilderKt.navigation(navGraphBuilder, (KClass) kClass, kClass2, map, function1);
    }
}
