package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public final void failed(@NotNull Route failedRoute) {
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(failedRoute, "failedRoute");
            this.failedRoutes.add(failedRoute);
        }
    }

    public final void connected(@NotNull Route route) {
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(route, "route");
            this.failedRoutes.remove(route);
        }
    }

    public final boolean shouldPostpone(@NotNull Route route) {
        boolean zContains;
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(route, "route");
            zContains = this.failedRoutes.contains(route);
        }
        return zContains;
    }
}
