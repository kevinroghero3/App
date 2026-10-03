package com.facebook.react.modules.network;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactCookieJarContainer implements CookieJarContainer {
    private CookieJar cookieJar;

    @Override // com.facebook.react.modules.network.CookieJarContainer
    public void setCookieJar(@NotNull CookieJar cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    @Override // com.facebook.react.modules.network.CookieJarContainer
    public void removeCookieJar() {
        this.cookieJar = null;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(@NotNull HttpUrl url, @NotNull List<Cookie> cookies) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        CookieJar cookieJar = this.cookieJar;
        if (cookieJar != null) {
            cookieJar.saveFromResponse(url, cookies);
        }
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(@NotNull HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        CookieJar cookieJar = this.cookieJar;
        if (cookieJar == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Cookie> listLoadForRequest = cookieJar.loadForRequest(url);
        ArrayList arrayList = new ArrayList();
        for (Cookie cookie : listLoadForRequest) {
            try {
                new Headers.Builder().add(cookie.m7151deprecated_name(), cookie.m7155deprecated_value());
                arrayList.add(cookie);
            } catch (IllegalArgumentException unused) {
            }
        }
        return arrayList;
    }
}
