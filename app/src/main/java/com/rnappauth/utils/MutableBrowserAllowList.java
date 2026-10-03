package com.rnappauth.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.openid.appauth.browser.BrowserDescriptor;
import net.openid.appauth.browser.BrowserMatcher;

/* JADX INFO: loaded from: classes3.dex */
public class MutableBrowserAllowList implements BrowserMatcher {
    private final List<BrowserMatcher> mBrowserMatchers = new ArrayList();

    public void add(BrowserMatcher browserMatcher) {
        this.mBrowserMatchers.add(browserMatcher);
    }

    public void remove(BrowserMatcher browserMatcher) {
        this.mBrowserMatchers.remove(browserMatcher);
    }

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(@NonNull BrowserDescriptor browserDescriptor) {
        Iterator<BrowserMatcher> it2 = this.mBrowserMatchers.iterator();
        while (it2.hasNext()) {
            if (it2.next().matches(browserDescriptor)) {
                return true;
            }
        }
        return false;
    }
}
