package com.salesforce.marketingcloud.sfmcsdk.components.http;

import kotlin.Pair;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Authenticator {
    public abstract void deleteCachedToken();

    public abstract Pair<String, String> getCachedTokenHeader();

    public abstract Pair<String, String> refreshAuthTokenHeader();

    public static /* synthetic */ Pair getAuthTokenHeader$sfmcsdk_release$default(Authenticator authenticator, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAuthTokenHeader");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return authenticator.getAuthTokenHeader$sfmcsdk_release(z);
    }

    public final Pair<String, String> getAuthTokenHeader$sfmcsdk_release(boolean z) {
        Pair<String, String> cachedTokenHeader;
        synchronized (this) {
            try {
                if (z || (cachedTokenHeader = getCachedTokenHeader()) == null) {
                    cachedTokenHeader = refreshAuthTokenHeader();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cachedTokenHeader;
    }
}
