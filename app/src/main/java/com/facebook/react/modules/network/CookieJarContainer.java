package com.facebook.react.modules.network;

import okhttp3.CookieJar;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface CookieJarContainer extends CookieJar {
    void removeCookieJar();

    void setCookieJar(@NotNull CookieJar cookieJar);
}
