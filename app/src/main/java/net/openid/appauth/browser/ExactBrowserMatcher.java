package net.openid.appauth.browser;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public class ExactBrowserMatcher implements BrowserMatcher {
    private BrowserDescriptor mBrowser;

    public ExactBrowserMatcher(BrowserDescriptor browserDescriptor) {
        this.mBrowser = browserDescriptor;
    }

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(@NonNull BrowserDescriptor browserDescriptor) {
        return this.mBrowser.equals(browserDescriptor);
    }
}
