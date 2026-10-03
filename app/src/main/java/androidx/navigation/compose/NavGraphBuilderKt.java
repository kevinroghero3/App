package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class NavGraphBuilderKt {
    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        composable(navGraphBuilder, str, list, list2, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of composable builder that supports AnimatedContent")
    public static final /* synthetic */ void composable(NavGraphBuilder navGraphBuilder, String str, List list, List list2, final Function3 function3) {
        ComposeNavigator.Destination destination = new ComposeNavigator.Destination((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), (Function4<? super AnimatedContentScope, NavBackStackEntry, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambdaInstance(-1516831465, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavGraphBuilderKt.composable.1
            @Override // kotlin.jvm.functions.Function4
            public /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedContentScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1516831465, i, -1, "androidx.navigation.compose.composable.<anonymous> (NavGraphBuilder.kt:55)");
                }
                function3.invoke(navBackStackEntry, composer, Integer.valueOf((i >> 3) & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        destination.setRoute(str);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            NamedNavArgument namedNavArgument = (NamedNavArgument) it2.next();
            destination.addArgument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            destination.addDeepLink((NavDeepLink) it3.next());
        }
        navGraphBuilder.addDestination(destination);
    }

    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function4 function5, int i, Object obj) {
        List listEmptyList = (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        List listEmptyList2 = (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2;
        Function1 function6 = (i & 8) != 0 ? null : function1;
        Function1 function7 = (i & 16) != 0 ? null : function2;
        composable(navGraphBuilder, str, listEmptyList, listEmptyList2, function6, function7, (i & 32) != 0 ? function6 : function3, (i & 64) != 0 ? function7 : function4, function5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of composable builder that supports sizeTransform")
    public static final /* synthetic */ void composable(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function4 function5) {
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), str, function5);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            NamedNavArgument namedNavArgument = (NamedNavArgument) it2.next();
            composeNavigatorDestinationBuilder.argument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            composeNavigatorDestinationBuilder.deepLink((NavDeepLink) it3.next());
        }
        composeNavigatorDestinationBuilder.setEnterTransition(function1);
        composeNavigatorDestinationBuilder.setExitTransition(function2);
        composeNavigatorDestinationBuilder.setPopEnterTransition(function3);
        composeNavigatorDestinationBuilder.setPopExitTransition(function4);
        navGraphBuilder.destination(composeNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function4 function6, int i, Object obj) {
        List listEmptyList = (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        List listEmptyList2 = (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2;
        Function1 function7 = (i & 8) != 0 ? null : function1;
        Function1 function8 = (i & 16) != 0 ? null : function2;
        composable(navGraphBuilder, str, (List<NamedNavArgument>) listEmptyList, (List<NavDeepLink>) listEmptyList2, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function7, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function8, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) ((i & 32) != 0 ? function7 : function3), (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) ((i & 64) != 0 ? function8 : function4), (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) ((i & 128) != 0 ? null : function5), (Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit>) function6);
    }

    public static final void composable(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull List<NamedNavArgument> list, @NotNull List<NavDeepLink> list2, @Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, @Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function2, @Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function3, @Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function4, @Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function5, @NotNull Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function6) {
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), str, function6);
        for (NamedNavArgument namedNavArgument : list) {
            composeNavigatorDestinationBuilder.argument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            composeNavigatorDestinationBuilder.deepLink((NavDeepLink) it2.next());
        }
        composeNavigatorDestinationBuilder.setEnterTransition(function1);
        composeNavigatorDestinationBuilder.setExitTransition(function2);
        composeNavigatorDestinationBuilder.setPopEnterTransition(function3);
        composeNavigatorDestinationBuilder.setPopExitTransition(function4);
        composeNavigatorDestinationBuilder.setSizeTransform(function5);
        navGraphBuilder.destination(composeNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, Map map, List list, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function4 function6, int i, Object obj) {
        Map mapEmptyMap = (i & 1) != 0 ? MapsKt__MapsKt.emptyMap() : map;
        List listEmptyList = (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        Function1 function7 = (i & 4) != 0 ? null : function1;
        Function1 function8 = (i & 8) != 0 ? null : function2;
        Function1 function9 = (i & 16) != 0 ? function7 : function3;
        Function1 function10 = (i & 32) != 0 ? function8 : function4;
        Function1 function11 = (i & 64) != 0 ? null : function5;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(Object.class), (Map<KType, NavType<?>>) mapEmptyMap, (List<NavDeepLink>) listEmptyList, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function7, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function8, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function9, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function10, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function11, (Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit>) function6);
    }

    public static final /* synthetic */ <T> void composable(NavGraphBuilder navGraphBuilder, Map<KType, NavType<?>> map, List<NavDeepLink> list, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function2, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function3, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function4, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function5, Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function6) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(Object.class), map, list, function1, function2, function3, function4, function5, function6);
    }

    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, KClass kClass, Map map, List list, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function4 function6, int i, Object obj) {
        Map mapEmptyMap = (i & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map;
        List listEmptyList = (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        Function1 function7 = (i & 8) != 0 ? null : function1;
        Function1 function8 = (i & 16) != 0 ? null : function2;
        composable(navGraphBuilder, kClass, (Map<KType, NavType<?>>) mapEmptyMap, (List<NavDeepLink>) listEmptyList, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function7, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function8, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) ((i & 32) != 0 ? function7 : function3), (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) ((i & 64) != 0 ? function8 : function4), (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) ((i & 128) != 0 ? null : function5), (Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit>) function6);
    }

    public static final <T> void composable(@NotNull NavGraphBuilder navGraphBuilder, @NotNull KClass<T> kClass, @NotNull Map<KType, NavType<?>> map, @NotNull List<NavDeepLink> list, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function2, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function3, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function4, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function5, @NotNull Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function6) {
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), kClass, map, function6);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            composeNavigatorDestinationBuilder.deepLink((NavDeepLink) it2.next());
        }
        composeNavigatorDestinationBuilder.setEnterTransition(function1);
        composeNavigatorDestinationBuilder.setExitTransition(function2);
        composeNavigatorDestinationBuilder.setPopEnterTransition(function3);
        composeNavigatorDestinationBuilder.setPopExitTransition(function4);
        composeNavigatorDestinationBuilder.setSizeTransform(function5);
        navGraphBuilder.destination(composeNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, String str, String str2, List list, List list2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        navigation(navGraphBuilder, str, str2, (List<NamedNavArgument>) list3, (List<NavDeepLink>) list2, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) null, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) null, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) null, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) null, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) null, (Function1<? super NavGraphBuilder, Unit>) function1);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, String str, String str2, List list, List list2, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, int i, Object obj) {
        List listEmptyList = (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        List listEmptyList2 = (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2;
        Function1 function6 = (i & 16) != 0 ? null : function1;
        Function1 function7 = (i & 32) != 0 ? null : function2;
        navigation(navGraphBuilder, str, str2, (List<NamedNavArgument>) listEmptyList, (List<NavDeepLink>) listEmptyList2, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function6, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function7, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) ((i & 64) != 0 ? function6 : function3), (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) ((i & 128) != 0 ? function7 : function4), (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) null, (Function1<? super NavGraphBuilder, Unit>) function5);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, String str, String str2, List list, List list2, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, int i, Object obj) {
        List listEmptyList = (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        List listEmptyList2 = (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2;
        Function1 function7 = (i & 16) != 0 ? null : function1;
        Function1 function8 = (i & 32) != 0 ? null : function2;
        navigation(navGraphBuilder, str, str2, (List<NamedNavArgument>) listEmptyList, (List<NavDeepLink>) listEmptyList2, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function7, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function8, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) ((i & 64) != 0 ? function7 : function3), (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) ((i & 128) != 0 ? function8 : function4), (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) ((i & 256) != 0 ? null : function5), (Function1<? super NavGraphBuilder, Unit>) function6);
    }

    public static final void navigation(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull String str2, @NotNull List<NamedNavArgument> list, @NotNull List<NavDeepLink> list2, @Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, @Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function2, @Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function3, @Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function4, @Nullable Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function5, @NotNull Function1<? super NavGraphBuilder, Unit> function6) {
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), str, str2);
        function6.invoke(navGraphBuilder2);
        NavGraph navGraphBuild = navGraphBuilder2.build();
        for (NamedNavArgument namedNavArgument : list) {
            navGraphBuild.addArgument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            navGraphBuild.addDeepLink((NavDeepLink) it2.next());
        }
        if (navGraphBuild instanceof ComposeNavGraphNavigator.ComposeNavGraph) {
            ComposeNavGraphNavigator.ComposeNavGraph composeNavGraph = (ComposeNavGraphNavigator.ComposeNavGraph) navGraphBuild;
            composeNavGraph.setEnterTransition$navigation_compose_release(function1);
            composeNavGraph.setExitTransition$navigation_compose_release(function2);
            composeNavGraph.setPopEnterTransition$navigation_compose_release(function3);
            composeNavGraph.setPopExitTransition$navigation_compose_release(function4);
            composeNavGraph.setSizeTransform$navigation_compose_release(function5);
        }
        navGraphBuilder.addDestination(navGraphBuild);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, KClass kClass, Map map, List list, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, int i, Object obj) {
        Map mapEmptyMap = (i & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map;
        List listEmptyList = (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        Function1 function7 = (i & 8) != 0 ? null : function1;
        Function1 function8 = (i & 16) != 0 ? null : function2;
        Function1 function9 = (i & 32) != 0 ? function7 : function3;
        Function1 function10 = (i & 64) != 0 ? function8 : function4;
        Function1 function11 = (i & 128) != 0 ? null : function5;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        navigation(navGraphBuilder, (KClass<?>) kClass, Reflection.getOrCreateKotlinClass(Object.class), (Map<KType, NavType<?>>) mapEmptyMap, (List<NavDeepLink>) listEmptyList, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function7, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function8, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function9, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function10, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function11, (Function1<? super NavGraphBuilder, Unit>) function6);
    }

    public static final /* synthetic */ <T> void navigation(NavGraphBuilder navGraphBuilder, KClass<?> kClass, Map<KType, NavType<?>> map, List<NavDeepLink> list, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function2, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function3, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function4, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function5, Function1<? super NavGraphBuilder, Unit> function6) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        navigation(navGraphBuilder, kClass, Reflection.getOrCreateKotlinClass(Object.class), map, list, function1, function2, function3, function4, function5, function6);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, KClass kClass, KClass kClass2, Map map, List list, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, int i, Object obj) {
        Map mapEmptyMap = (i & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map;
        List listEmptyList = (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        Function1 function7 = (i & 16) != 0 ? null : function1;
        Function1 function8 = (i & 32) != 0 ? null : function2;
        navigation(navGraphBuilder, (KClass<?>) kClass, kClass2, (Map<KType, NavType<?>>) mapEmptyMap, (List<NavDeepLink>) listEmptyList, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function7, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function8, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) ((i & 64) != 0 ? function7 : function3), (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) ((i & 128) != 0 ? function8 : function4), (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) ((i & 256) != 0 ? null : function5), (Function1<? super NavGraphBuilder, Unit>) function6);
    }

    public static final <T> void navigation(@NotNull NavGraphBuilder navGraphBuilder, @NotNull KClass<?> kClass, @NotNull KClass<T> kClass2, @NotNull Map<KType, NavType<?>> map, @NotNull List<NavDeepLink> list, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function2, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function3, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function4, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function5, @NotNull Function1<? super NavGraphBuilder, Unit> function6) {
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), kClass, (KClass<?>) kClass2, map);
        function6.invoke(navGraphBuilder2);
        NavGraph navGraphBuild = navGraphBuilder2.build();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            navGraphBuild.addDeepLink((NavDeepLink) it2.next());
        }
        if (navGraphBuild instanceof ComposeNavGraphNavigator.ComposeNavGraph) {
            ComposeNavGraphNavigator.ComposeNavGraph composeNavGraph = (ComposeNavGraphNavigator.ComposeNavGraph) navGraphBuild;
            composeNavGraph.setEnterTransition$navigation_compose_release(function1);
            composeNavGraph.setExitTransition$navigation_compose_release(function2);
            composeNavGraph.setPopEnterTransition$navigation_compose_release(function3);
            composeNavGraph.setPopExitTransition$navigation_compose_release(function4);
            composeNavGraph.setSizeTransform$navigation_compose_release(function5);
        }
        navGraphBuilder.addDestination(navGraphBuild);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, Object obj, Map map, List list, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, int i, Object obj2) {
        Map mapEmptyMap = (i & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map;
        List listEmptyList = (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        Function1 function7 = (i & 8) != 0 ? null : function1;
        Function1 function8 = (i & 16) != 0 ? null : function2;
        Function1 function9 = (i & 32) != 0 ? function7 : function3;
        Function1 function10 = (i & 64) != 0 ? function8 : function4;
        Function1 function11 = (i & 128) != 0 ? null : function5;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        navigation(navGraphBuilder, obj, Reflection.getOrCreateKotlinClass(Object.class), (Map<KType, NavType<?>>) mapEmptyMap, (List<NavDeepLink>) listEmptyList, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function7, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function8, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function9, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function10, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function11, (Function1<? super NavGraphBuilder, Unit>) function6);
    }

    public static final /* synthetic */ <T> void navigation(NavGraphBuilder navGraphBuilder, Object obj, Map<KType, NavType<?>> map, List<NavDeepLink> list, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function2, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function3, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function4, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function5, Function1<? super NavGraphBuilder, Unit> function6) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        navigation(navGraphBuilder, obj, Reflection.getOrCreateKotlinClass(Object.class), map, list, function1, function2, function3, function4, function5, function6);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, Object obj, KClass kClass, Map map, List list, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, int i, Object obj2) {
        Map mapEmptyMap = (i & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map;
        List listEmptyList = (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        Function1 function7 = (i & 16) != 0 ? null : function1;
        Function1 function8 = (i & 32) != 0 ? null : function2;
        navigation(navGraphBuilder, obj, kClass, (Map<KType, NavType<?>>) mapEmptyMap, (List<NavDeepLink>) listEmptyList, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function7, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function8, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) ((i & 64) != 0 ? function7 : function3), (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) ((i & 128) != 0 ? function8 : function4), (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) ((i & 256) != 0 ? null : function5), (Function1<? super NavGraphBuilder, Unit>) function6);
    }

    public static final <T> void navigation(@NotNull NavGraphBuilder navGraphBuilder, @NotNull Object obj, @NotNull KClass<T> kClass, @NotNull Map<KType, NavType<?>> map, @NotNull List<NavDeepLink> list, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function2, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function3, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function4, @Nullable Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function5, @NotNull Function1<? super NavGraphBuilder, Unit> function6) {
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), obj, (KClass<?>) kClass, map);
        function6.invoke(navGraphBuilder2);
        NavGraph navGraphBuild = navGraphBuilder2.build();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            navGraphBuild.addDeepLink((NavDeepLink) it2.next());
        }
        if (navGraphBuild instanceof ComposeNavGraphNavigator.ComposeNavGraph) {
            ComposeNavGraphNavigator.ComposeNavGraph composeNavGraph = (ComposeNavGraphNavigator.ComposeNavGraph) navGraphBuild;
            composeNavGraph.setEnterTransition$navigation_compose_release(function1);
            composeNavGraph.setExitTransition$navigation_compose_release(function2);
            composeNavGraph.setPopEnterTransition$navigation_compose_release(function3);
            composeNavGraph.setPopExitTransition$navigation_compose_release(function4);
            composeNavGraph.setSizeTransform$navigation_compose_release(function5);
        }
        navGraphBuilder.addDestination(navGraphBuild);
    }

    public static final void dialog(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull List<NamedNavArgument> list, @NotNull List<NavDeepLink> list2, @NotNull DialogProperties dialogProperties, @NotNull Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function3) {
        DialogNavigatorDestinationBuilder dialogNavigatorDestinationBuilder = new DialogNavigatorDestinationBuilder((DialogNavigator) navGraphBuilder.getProvider().getNavigator(DialogNavigator.class), str, dialogProperties, function3);
        for (NamedNavArgument namedNavArgument : list) {
            dialogNavigatorDestinationBuilder.argument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            dialogNavigatorDestinationBuilder.deepLink((NavDeepLink) it2.next());
        }
        navGraphBuilder.destination(dialogNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void dialog$default(NavGraphBuilder navGraphBuilder, Map map, List list, DialogProperties dialogProperties, Function3 function3, int i, Object obj) {
        Map mapEmptyMap = (i & 1) != 0 ? MapsKt__MapsKt.emptyMap() : map;
        List listEmptyList = (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        DialogProperties dialogProperties2 = (i & 4) != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : dialogProperties;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        dialog(navGraphBuilder, Reflection.getOrCreateKotlinClass(Object.class), (Map<KType, NavType<?>>) mapEmptyMap, (List<NavDeepLink>) listEmptyList, dialogProperties2, (Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit>) function3);
    }

    public static final /* synthetic */ <T> void dialog(NavGraphBuilder navGraphBuilder, Map<KType, NavType<?>> map, List<NavDeepLink> list, DialogProperties dialogProperties, Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        dialog(navGraphBuilder, Reflection.getOrCreateKotlinClass(Object.class), map, list, dialogProperties, function3);
    }

    public static final <T> void dialog(@NotNull NavGraphBuilder navGraphBuilder, @NotNull KClass<T> kClass, @NotNull Map<KType, NavType<?>> map, @NotNull List<NavDeepLink> list, @NotNull DialogProperties dialogProperties, @NotNull Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function3) {
        DialogNavigatorDestinationBuilder dialogNavigatorDestinationBuilder = new DialogNavigatorDestinationBuilder((DialogNavigator) navGraphBuilder.getProvider().getNavigator(DialogNavigator.class), kClass, map, dialogProperties, function3);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            dialogNavigatorDestinationBuilder.deepLink((NavDeepLink) it2.next());
        }
        navGraphBuilder.destination(dialogNavigatorDestinationBuilder);
    }
}
