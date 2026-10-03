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
public final class NavHostKt {
    @Deprecated(message = "Use routes to create your NavGraph instead", replaceWith = @ReplaceWith(expression = "createGraph(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final NavGraph createGraph(@NotNull NavHost navHost, @IdRes int i, @IdRes int i2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavHostKt__NavHost_androidKt.createGraph(navHost, i, i2, function1);
    }

    public static final NavGraph createGraph(@NotNull NavHost navHost, @NotNull Object obj, @Nullable KClass<?> kClass, @NotNull Map<KType, NavType<?>> map, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavHostKt__NavHostKt.createGraph(navHost, obj, kClass, map, function1);
    }

    public static final NavGraph createGraph(@NotNull NavHost navHost, @NotNull String str, @Nullable String str2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavHostKt__NavHostKt.createGraph(navHost, str, str2, function1);
    }

    public static final NavGraph createGraph(@NotNull NavHost navHost, @NotNull KClass<?> kClass, @Nullable KClass<?> kClass2, @NotNull Map<KType, NavType<?>> map, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavHostKt__NavHostKt.createGraph(navHost, kClass, kClass2, map, function1);
    }
}
