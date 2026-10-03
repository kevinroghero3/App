package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@NavDestinationDsl
public final class ComposeNavigatorDestinationBuilder extends NavDestinationBuilder<ComposeNavigator.Destination> {
    public static final int $stable = 8;
    private final ComposeNavigator composeNavigator;
    private final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> content;
    private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition;
    private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition;
    private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition;
    private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition;
    private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform;

    public final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> getEnterTransition() {
        return this.enterTransition;
    }

    public final void setEnterTransition(@Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1) {
        this.enterTransition = function1;
    }

    public final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> getExitTransition() {
        return this.exitTransition;
    }

    public final void setExitTransition(@Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1) {
        this.exitTransition = function1;
    }

    public final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> getPopEnterTransition() {
        return this.popEnterTransition;
    }

    public final void setPopEnterTransition(@Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1) {
        this.popEnterTransition = function1;
    }

    public final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> getPopExitTransition() {
        return this.popExitTransition;
    }

    public final void setPopExitTransition(@Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1) {
        this.popExitTransition = function1;
    }

    public final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> getSizeTransform() {
        return this.sizeTransform;
    }

    public final void setSizeTransform(@Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1) {
        this.sizeTransform = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComposeNavigatorDestinationBuilder(@NotNull ComposeNavigator composeNavigator, @NotNull String str, @NotNull Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function4) {
        super(composeNavigator, str);
        this.composeNavigator = composeNavigator;
        this.content = function4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComposeNavigatorDestinationBuilder(@NotNull ComposeNavigator composeNavigator, @NotNull KClass<?> kClass, @NotNull Map<KType, NavType<?>> map, @NotNull Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function4) {
        super(composeNavigator, kClass, map);
        this.composeNavigator = composeNavigator;
        this.content = function4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.navigation.NavDestinationBuilder
    public ComposeNavigator.Destination instantiateDestination() {
        return new ComposeNavigator.Destination(this.composeNavigator, this.content);
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public ComposeNavigator.Destination build() {
        ComposeNavigator.Destination destination = (ComposeNavigator.Destination) super.build();
        destination.setEnterTransition$navigation_compose_release(this.enterTransition);
        destination.setExitTransition$navigation_compose_release(this.exitTransition);
        destination.setPopEnterTransition$navigation_compose_release(this.popEnterTransition);
        destination.setPopExitTransition$navigation_compose_release(this.popExitTransition);
        destination.setSizeTransform$navigation_compose_release(this.sizeTransform);
        return destination;
    }
}
