package com.facebook.react.modules.network;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ForwardingCookieHandler extends CookieHandler {
    private static final String COOKIE_HEADER = "Cookie";
    private static final Companion Companion = new Companion(null);
    private static final String VERSION_ONE_HEADER = "Set-cookie2";
    private static final String VERSION_ZERO_HEADER = "Set-cookie";
    private CookieManager cookieManager;

    public final void destroy() {
    }

    public ForwardingCookieHandler() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use the default constructor", replaceWith = @ReplaceWith(expression = "ForwardingCookieHandler()", imports = {}))
    public ForwardingCookieHandler(@NotNull ReactContext reactContext) {
        this();
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // java.net.CookieHandler
    public Map<String, List<String>> get(@NotNull URI uri, @NotNull Map<String, ? extends List<String>> headers) throws IOException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(headers, "headers");
        CookieManager cookieManager = getCookieManager();
        String cookie = cookieManager != null ? cookieManager.getCookie(uri.toString()) : null;
        if (cookie == null || cookie.length() == 0) {
            return MapsKt__MapsKt.emptyMap();
        }
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to("Cookie", CollectionsKt__CollectionsJVMKt.listOf(cookie)));
    }

    @Override // java.net.CookieHandler
    public void put(@NotNull URI uri, @NotNull Map<String, ? extends List<String>> headers) throws IOException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(headers, "headers");
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        for (Map.Entry<String, ? extends List<String>> entry : headers.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (Companion.isCookieHeader(key)) {
                addCookies(string, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearCookies$lambda$0(Callback callback, Boolean bool) {
        callback.invoke(bool);
    }

    public final void clearCookies(@NotNull final Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.removeAllCookies(new ValueCallback() { // from class: com.facebook.react.modules.network.ForwardingCookieHandler$$ExternalSyntheticLambda0
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    ForwardingCookieHandler.clearCookies$lambda$0(callback, (Boolean) obj);
                }
            });
        }
    }

    public final void addCookies(@NotNull String url, @NotNull List<String> cookies) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Iterator<String> it2 = cookies.iterator();
        while (it2.hasNext()) {
            addCookieAsync(url, it2.next());
        }
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.flush();
        }
    }

    private final void addCookieAsync(String str, String str2) {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.setCookie(str, str2, null);
        }
    }

    private final CookieManager getCookieManager() {
        if (this.cookieManager == null) {
            try {
                this.cookieManager = CookieManager.getInstance();
            } catch (IllegalArgumentException | Exception unused) {
                return null;
            }
        }
        return this.cookieManager;
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isCookieHeader(String str) {
            return StringsKt__StringsJVMKt.equals(str, ForwardingCookieHandler.VERSION_ZERO_HEADER, true) || StringsKt__StringsJVMKt.equals(str, ForwardingCookieHandler.VERSION_ONE_HEADER, true);
        }
    }
}
