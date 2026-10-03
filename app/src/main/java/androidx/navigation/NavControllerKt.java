package androidx.navigation;

import android.content.Intent;
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
public final class NavControllerKt {
    public static final NavDeepLinkRequest NavDeepLinkRequest(@NotNull Intent intent) {
        return NavControllerKt__NavController_androidKt.NavDeepLinkRequest(intent);
    }

    @Deprecated(message = "Use routes to create your NavGraph instead", replaceWith = @ReplaceWith(expression = "createGraph(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final NavGraph createGraph(@NotNull NavController navController, @IdRes int i, @IdRes int i2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavControllerKt__NavController_androidKt.createGraph(navController, i, i2, function1);
    }

    public static final NavGraph createGraph(@NotNull NavController navController, @NotNull Object obj, @Nullable KClass<?> kClass, @NotNull Map<KType, NavType<?>> map, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavControllerKt__NavControllerKt.createGraph(navController, obj, kClass, map, function1);
    }

    public static final NavGraph createGraph(@NotNull NavController navController, @NotNull String str, @Nullable String str2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavControllerKt__NavControllerKt.createGraph(navController, str, str2, function1);
    }

    public static final NavGraph createGraph(@NotNull NavController navController, @NotNull KClass<?> kClass, @Nullable KClass<?> kClass2, @NotNull Map<KType, NavType<?>> map, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        return NavControllerKt__NavControllerKt.createGraph(navController, kClass, kClass2, map, function1);
    }
}
