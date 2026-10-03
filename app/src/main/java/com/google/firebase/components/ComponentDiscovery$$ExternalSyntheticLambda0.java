package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ComponentDiscovery$$ExternalSyntheticLambda0 implements Provider {
    public static int MediaBrowserCompatMediaBrowserImplApi216;
    public static int MediaBrowserCompatMediaBrowserImplApi23;
    public final /* synthetic */ String f$0;

    public /* synthetic */ ComponentDiscovery$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return ComponentDiscovery.instantiate(this.f$0);
    }

    public static int ITrustedWebActivityServiceDefault() {
        int i = MediaBrowserCompatMediaBrowserImplApi216;
        int i2 = i % 9193043;
        MediaBrowserCompatMediaBrowserImplApi216 = i + 1;
        if (i2 != 0) {
            return MediaBrowserCompatMediaBrowserImplApi23;
        }
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        MediaBrowserCompatMediaBrowserImplApi23 = iMaxMemory;
        return iMaxMemory;
    }
}
