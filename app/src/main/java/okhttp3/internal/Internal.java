package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class Internal {
    public static final Cookie parseCookie(long j, @NotNull HttpUrl url, @NotNull String setCookie) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j, url, setCookie);
    }

    public static final String cookieToString(@NotNull Cookie cookie, boolean z) {
        Intrinsics.checkParameterIsNotNull(cookie, "cookie");
        return cookie.toString$okhttp(z);
    }

    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder builder, @NotNull String line) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        Intrinsics.checkParameterIsNotNull(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(value, "value");
        return builder.addLenient$okhttp(name, value);
    }

    public static final Response cacheGet(@NotNull Cache cache, @NotNull Request request) {
        Intrinsics.checkParameterIsNotNull(cache, "cache");
        Intrinsics.checkParameterIsNotNull(request, "request");
        return cache.get$okhttp(request);
    }

    public static final void applyConnectionSpec(@NotNull ConnectionSpec connectionSpec, @NotNull SSLSocket sslSocket, boolean z) throws CloneNotSupportedException {
        Intrinsics.checkParameterIsNotNull(connectionSpec, "connectionSpec");
        Intrinsics.checkParameterIsNotNull(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z);
    }
}
