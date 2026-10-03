package androidx.navigation.internal;

import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class NavGraphImpl {
    private final NavGraph graph;
    private final SparseArrayCompat<NavDestination> nodes;
    private int startDestId;
    private String startDestIdName;
    private String startDestinationRoute;

    public NavGraphImpl(@NotNull NavGraph graph) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        this.graph = graph;
        this.nodes = new SparseArrayCompat<>(0, 1, null);
    }

    public final NavGraph getGraph() {
        return this.graph;
    }

    public final SparseArrayCompat<NavDestination> getNodes$navigation_common_release() {
        return this.nodes;
    }

    public final int getStartDestId$navigation_common_release() {
        return this.startDestId;
    }

    public final void setStartDestId$navigation_common_release(int i) {
        this.startDestId = i;
    }

    public final String getStartDestIdName$navigation_common_release() {
        return this.startDestIdName;
    }

    public final void setStartDestIdName$navigation_common_release(@Nullable String str) {
        this.startDestIdName = str;
    }

    public final NavDestination.DeepLinkMatch matchRouteComprehensive$navigation_common_release(@NotNull String route, boolean z, boolean z2, @NotNull NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        NavDestination.DeepLinkMatch deepLinkMatchMatchRoute;
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch deepLinkMatchMatchRoute2 = this.graph.matchRoute(route);
        NavDestination.DeepLinkMatch deepLinkMatchMatchRouteComprehensive = null;
        if (z) {
            NavGraph navGraph = this.graph;
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : navGraph) {
                if (Intrinsics.areEqual(navDestination, lastVisited)) {
                    deepLinkMatchMatchRoute = null;
                } else if (navDestination instanceof NavGraph) {
                    deepLinkMatchMatchRoute = ((NavGraph) navDestination).matchRouteComprehensive(route, true, false, this.graph);
                } else {
                    deepLinkMatchMatchRoute = navDestination.matchRoute(route);
                }
                if (deepLinkMatchMatchRoute != null) {
                    arrayList.add(deepLinkMatchMatchRoute);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt___CollectionsKt.maxOrNull((Iterable) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = this.graph.getParent();
        if (parent != null && z2 && !Intrinsics.areEqual(parent, lastVisited)) {
            deepLinkMatchMatchRouteComprehensive = parent.matchRouteComprehensive(route, z, true, this.graph);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt___CollectionsKt.maxOrNull((Iterable) CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{deepLinkMatchMatchRoute2, deepLinkMatch, deepLinkMatchMatchRouteComprehensive}));
    }

    public final NavDestination.DeepLinkMatch matchDeepLinkComprehensive$navigation_common_release(@Nullable NavDestination.DeepLinkMatch deepLinkMatch, @NotNull NavDeepLinkRequest navDeepLinkRequest, boolean z, boolean z2, @NotNull NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch2;
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive = null;
        if (z) {
            NavGraph navGraph = this.graph;
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : navGraph) {
                NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = !Intrinsics.areEqual(navDestination, lastVisited) ? navDestination.matchDeepLink(navDeepLinkRequest) : null;
                if (deepLinkMatchMatchDeepLink != null) {
                    arrayList.add(deepLinkMatchMatchDeepLink);
                }
            }
            deepLinkMatch2 = (NavDestination.DeepLinkMatch) CollectionsKt___CollectionsKt.maxOrNull((Iterable) arrayList);
        } else {
            deepLinkMatch2 = null;
        }
        NavGraph parent = this.graph.getParent();
        if (parent != null && z2 && !Intrinsics.areEqual(parent, lastVisited)) {
            deepLinkMatchMatchDeepLinkComprehensive = parent.matchDeepLinkComprehensive(navDeepLinkRequest, z, true, this.graph);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt___CollectionsKt.maxOrNull((Iterable) CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{deepLinkMatch, deepLinkMatch2, deepLinkMatchMatchDeepLinkComprehensive}));
    }

    public final NavDestination.DeepLinkMatch matchDeepLink$navigation_common_release(@Nullable NavDestination.DeepLinkMatch deepLinkMatch, @NotNull NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return matchDeepLinkComprehensive$navigation_common_release(deepLinkMatch, navDeepLinkRequest, true, false, this.graph);
    }

    public final void addDestination$navigation_common_release(@NotNull NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int id = node.getId();
        String route = node.getRoute();
        if (id == 0 && route == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
        }
        if (this.graph.getRoute() != null && Intrinsics.areEqual(route, this.graph.getRoute())) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + this.graph).toString());
        }
        if (id == this.graph.getId()) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + this.graph).toString());
        }
        NavDestination navDestination = this.nodes.get(id);
        if (navDestination == node) {
            return;
        }
        if (node.getParent() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (navDestination != null) {
            navDestination.setParent(null);
        }
        node.setParent(this.graph);
        this.nodes.put(node.getId(), node);
    }

    public final void addDestinations$navigation_common_release(@NotNull Collection<? extends NavDestination> nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            if (navDestination != null) {
                addDestination$navigation_common_release(navDestination);
            }
        }
    }

    public final void addDestinations$navigation_common_release(@NotNull NavDestination... nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            addDestination$navigation_common_release(navDestination);
        }
    }

    public final NavDestination findNode$navigation_common_release(int i) {
        return findNodeComprehensive$navigation_common_release$default(this, i, this.graph, false, null, 8, null);
    }

    public static /* synthetic */ NavDestination findNodeComprehensive$navigation_common_release$default(NavGraphImpl navGraphImpl, int i, NavDestination navDestination, boolean z, NavDestination navDestination2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            navDestination2 = null;
        }
        return navGraphImpl.findNodeComprehensive$navigation_common_release(i, navDestination, z, navDestination2);
    }

    public final NavDestination findNodeComprehensive$navigation_common_release(int i, @Nullable NavDestination navDestination, boolean z, @Nullable NavDestination navDestination2) {
        NavDestination navDestination3 = this.nodes.get(i);
        if (navDestination2 != null) {
            if (Intrinsics.areEqual(navDestination3, navDestination2) && Intrinsics.areEqual(navDestination3.getParent(), navDestination2.getParent())) {
                return navDestination3;
            }
            navDestination3 = null;
        } else if (navDestination3 != null) {
            return navDestination3;
        }
        if (z) {
            Iterator it2 = SequencesKt__SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    navDestination3 = null;
                    break;
                }
                NavDestination navDestination4 = (NavDestination) it2.next();
                NavDestination navDestinationFindNodeComprehensive = (!(navDestination4 instanceof NavGraph) || Intrinsics.areEqual(navDestination4, navDestination)) ? null : ((NavGraph) navDestination4).findNodeComprehensive(i, this.graph, true, navDestination2);
                if (navDestinationFindNodeComprehensive != null) {
                    navDestination3 = navDestinationFindNodeComprehensive;
                    break;
                }
            }
        }
        if (navDestination3 != null) {
            return navDestination3;
        }
        if (this.graph.getParent() == null || Intrinsics.areEqual(this.graph.getParent(), navDestination)) {
            return null;
        }
        NavGraph parent = this.graph.getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNodeComprehensive(i, this.graph, z, navDestination2);
    }

    public final NavDestination findNode$navigation_common_release(@Nullable String str) {
        if (str == null || StringsKt__StringsKt.isBlank(str)) {
            return null;
        }
        return findNode$navigation_common_release(str, true);
    }

    public final NavDestination findNode$navigation_common_release(@NotNull KClass<?> route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return findNode$navigation_common_release(RouteSerializerKt.generateHashCode(SerializersKt.serializer(route)));
    }

    public final <T> NavDestination findNode$navigation_common_release(@Nullable T t) {
        if (t != null) {
            return findNode$navigation_common_release(RouteSerializerKt.generateHashCode(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(t.getClass()))));
        }
        return null;
    }

    public final NavDestination findNode$navigation_common_release(@NotNull String route, boolean z) {
        Object next;
        NavDestination navDestination;
        Intrinsics.checkNotNullParameter(route, "route");
        Iterator it2 = SequencesKt__SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            navDestination = (NavDestination) next;
            if (StringsKt__StringsJVMKt.equals$default(navDestination.getRoute(), route, false, 2, null)) {
                break;
            }
        } while (navDestination.matchRoute(route) == null);
        NavDestination navDestination2 = (NavDestination) next;
        if (navDestination2 != null) {
            return navDestination2;
        }
        if (!z || this.graph.getParent() == null) {
            return null;
        }
        NavGraph parent = this.graph.getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNode(route);
    }

    public final Iterator<NavDestination> iterator$navigation_common_release() {
        return new NavGraphImpl$iterator$1(this);
    }

    public final void addAll$navigation_common_release(@NotNull NavGraph other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<NavDestination> it2 = other.iterator();
        while (it2.hasNext()) {
            NavDestination next = it2.next();
            it2.remove();
            addDestination$navigation_common_release(next);
        }
    }

    public final void remove$navigation_common_release(@NotNull NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int iIndexOfKey = this.nodes.indexOfKey(node.getId());
        if (iIndexOfKey >= 0) {
            this.nodes.valueAt(iIndexOfKey).setParent(null);
            this.nodes.removeAt(iIndexOfKey);
        }
    }

    public final void clear$navigation_common_release() {
        Iterator<NavDestination> itIterator$navigation_common_release = iterator$navigation_common_release();
        while (itIterator$navigation_common_release.hasNext()) {
            itIterator$navigation_common_release.next();
            itIterator$navigation_common_release.remove();
        }
    }

    public final String getDisplayName$navigation_common_release(@NotNull String superName) {
        Intrinsics.checkNotNullParameter(superName, "superName");
        return this.graph.getId() != 0 ? superName : "the root navigation";
    }

    public final int getStartDestinationId$navigation_common_release() {
        return this.startDestId;
    }

    public final void setStartDestinationId$navigation_common_release(int i) {
        if (i == this.graph.getId()) {
            throw new IllegalArgumentException(("Start destination " + i + " cannot use the same id as the graph " + this.graph).toString());
        }
        if (this.startDestinationRoute != null) {
            setStartDestinationRoute$navigation_common_release(null);
        }
        this.startDestId = i;
        this.startDestIdName = null;
    }

    public final void setStartDestination$navigation_common_release(int i) {
        setStartDestinationId$navigation_common_release(i);
    }

    public final void setStartDestination$navigation_common_release(@NotNull String startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestinationRoute$navigation_common_release(startDestRoute);
    }

    public final <T> void setStartDestination$navigation_common_release(@NotNull KClass<T> startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestination$navigation_common_release(SerializersKt.serializer(startDestRoute), new Function1() { // from class: androidx.navigation.internal.NavGraphImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavGraphImpl.setStartDestination$lambda$12((NavDestination) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setStartDestination$lambda$12(NavDestination startDestination) {
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        String route = startDestination.getRoute();
        Intrinsics.checkNotNull(route);
        return route;
    }

    public final <T> void setStartDestination$navigation_common_release(@NotNull final T startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestination$navigation_common_release(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(startDestRoute.getClass())), new Function1() { // from class: androidx.navigation.internal.NavGraphImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavGraphImpl.setStartDestination$lambda$14(startDestRoute, (NavDestination) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setStartDestination$lambda$14(Object obj, NavDestination startDestination) {
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Map<String, NavArgument> arguments = startDestination.getArguments();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(arguments.size()));
        Iterator<T> it2 = arguments.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
        }
        return RouteSerializerKt.generateRouteWithArgs(obj, linkedHashMap);
    }

    public final <T> void setStartDestination$navigation_common_release(@NotNull KSerializer<T> serializer, @NotNull Function1<? super NavDestination, String> parseRoute) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(parseRoute, "parseRoute");
        int iGenerateHashCode = RouteSerializerKt.generateHashCode(serializer);
        NavDestination navDestinationFindNode$navigation_common_release = findNode$navigation_common_release(iGenerateHashCode);
        if (navDestinationFindNode$navigation_common_release == null) {
            throw new IllegalStateException(("Cannot find startDestination " + serializer.getDescriptor().getSerialName() + " from NavGraph. Ensure the starting NavDestination was added with route from KClass.").toString());
        }
        setStartDestinationRoute$navigation_common_release(parseRoute.invoke(navDestinationFindNode$navigation_common_release));
        this.startDestId = iGenerateHashCode;
    }

    public final String getStartDestinationRoute$navigation_common_release() {
        return this.startDestinationRoute;
    }

    public final void setStartDestinationRoute$navigation_common_release(@Nullable String str) {
        int iHashCode;
        if (str == null) {
            iHashCode = 0;
        } else {
            if (Intrinsics.areEqual(str, this.graph.getRoute())) {
                throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this.graph).toString());
            }
            if (StringsKt__StringsKt.isBlank(str)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route");
            }
            iHashCode = NavDestination.Companion.createRoute(str).hashCode();
        }
        this.startDestId = iHashCode;
        this.startDestinationRoute = str;
    }

    public final String getStartDestDisplayName$navigation_common_release() {
        if (this.startDestIdName == null) {
            String strValueOf = this.startDestinationRoute;
            if (strValueOf == null) {
                strValueOf = String.valueOf(this.startDestId);
            }
            this.startDestIdName = strValueOf;
        }
        String str = this.startDestIdName;
        Intrinsics.checkNotNull(str);
        return str;
    }
}
