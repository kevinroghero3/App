package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityNavigatorDestinationBuilderKt {
    @Deprecated(message = "Use routes to build your ActivityDestination instead", replaceWith = @ReplaceWith(expression = "activity(route = id.toString()) { builder.invoke() }", imports = {}))
    public static final void activity(@NotNull NavGraphBuilder navGraphBuilder, @IdRes int i, @NotNull Function1<? super ActivityNavigatorDestinationBuilder, Unit> function1) {
        ActivityNavigatorDestinationBuilderKt__ActivityNavigatorDestinationBuilder_androidKt.activity(navGraphBuilder, i, function1);
    }

    public static final void activity(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull Function1<? super ActivityNavigatorDestinationBuilder, Unit> function1) {
        ActivityNavigatorDestinationBuilderKt__ActivityNavigatorDestinationBuilder_androidKt.activity(navGraphBuilder, str, function1);
    }
}
