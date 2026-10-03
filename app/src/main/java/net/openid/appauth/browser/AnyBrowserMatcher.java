package net.openid.appauth.browser;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class AnyBrowserMatcher implements BrowserMatcher {
    public static final AnyBrowserMatcher INSTANCE = new AnyBrowserMatcher();

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(@NonNull BrowserDescriptor browserDescriptor) {
        return true;
    }

    private AnyBrowserMatcher() {
    }
}
