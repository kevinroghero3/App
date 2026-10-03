package androidx.navigation;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class NavGraphKt__NavGraphKt {
    public static final NavDestination get(@NotNull NavGraph navGraph, @NotNull String route) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        NavDestination navDestinationFindNode = navGraph.findNode(route);
        if (navDestinationFindNode != null) {
            return navDestinationFindNode;
        }
        throw new IllegalArgumentException("No destination for " + route + " was found in " + navGraph);
    }

    public static final <T> NavDestination get(@NotNull NavGraph navGraph, @NotNull T route) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        NavDestination navDestinationFindNode = navGraph.findNode(route);
        if (navDestinationFindNode != null) {
            return navDestinationFindNode;
        }
        throw new IllegalArgumentException("No destination for " + route + " was found in " + navGraph);
    }

    public static final boolean contains(@NotNull NavGraph navGraph, @NotNull String route) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        return navGraph.findNode(route) != null;
    }

    public static final <T> boolean contains(@NotNull NavGraph navGraph, @NotNull T route) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        return navGraph.findNode(route) != null;
    }

    public static final void plusAssign(@NotNull NavGraph navGraph, @NotNull NavDestination node) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        navGraph.addDestination(node);
    }

    public static final void plusAssign(@NotNull NavGraph navGraph, @NotNull NavGraph other) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        navGraph.addAll(other);
    }

    public static final void minusAssign(@NotNull NavGraph navGraph, @NotNull NavDestination node) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        navGraph.remove(node);
    }

    public static final /* synthetic */ <T> NavDestination get(NavGraph navGraph, KClass<T> route) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        NavDestination navDestinationFindNode = navGraph.findNode(Reflection.getOrCreateKotlinClass(Object.class));
        if (navDestinationFindNode != null) {
            return navDestinationFindNode;
        }
        throw new IllegalArgumentException("No destination for " + route + " was found in " + navGraph);
    }

    public static final /* synthetic */ <T> boolean contains(NavGraph navGraph, KClass<T> route) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return navGraph.findNode(Reflection.getOrCreateKotlinClass(Object.class)) != null;
    }
}
