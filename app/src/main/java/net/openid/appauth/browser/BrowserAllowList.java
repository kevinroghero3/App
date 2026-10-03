package net.openid.appauth.browser;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class BrowserAllowList implements BrowserMatcher {
    private List<BrowserMatcher> mBrowserMatchers;

    public BrowserAllowList(BrowserMatcher... browserMatcherArr) {
        this.mBrowserMatchers = Arrays.asList(browserMatcherArr);
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
