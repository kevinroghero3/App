package androidx.navigation;

import androidx.navigation.serialization.RouteSerializerKt;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@NavDeepLinkDsl
public final class NavDeepLinkDslBuilder {
    private String action;
    private final NavDeepLink.Builder builder;
    private String mimeType;
    private KClass<?> route;
    private Map<KType, ? extends NavType<?>> typeMap;
    private String uriPattern;

    public NavDeepLinkDslBuilder() {
        this.builder = new NavDeepLink.Builder();
        this.typeMap = MapsKt__MapsKt.emptyMap();
    }

    public NavDeepLinkDslBuilder(@NotNull String basePath, @NotNull KClass<?> route, @NotNull Map<KType, NavType<?>> typeMap) {
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        this.builder = new NavDeepLink.Builder();
        this.typeMap = MapsKt__MapsKt.emptyMap();
        if (basePath.length() <= 0) {
            throw new IllegalArgumentException("The basePath for NavDeepLink from KClass cannot be empty");
        }
        this.uriPattern = RouteSerializerKt.generateRoutePattern(SerializersKt.serializer(route), typeMap, basePath);
        this.route = route;
        this.typeMap = typeMap;
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final void setUriPattern(@Nullable String str) {
        this.uriPattern = str;
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(@Nullable String str) {
        if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }
        this.action = str;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final void setMimeType(@Nullable String str) {
        this.mimeType = str;
    }

    public final NavDeepLink build$navigation_common_release() {
        NavDeepLink.Builder builder = this.builder;
        String str = this.uriPattern;
        if (str == null && this.action == null && this.mimeType == null) {
            throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.");
        }
        if (str != null) {
            builder.setUriPattern(str);
        }
        String str2 = this.action;
        if (str2 != null) {
            builder.setAction(str2);
        }
        String str3 = this.mimeType;
        if (str3 != null) {
            builder.setMimeType(str3);
        }
        return builder.build();
    }
}
