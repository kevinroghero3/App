package com.google.firebase.components;

import android.os.Process;
import com.google.firebase.inject.Provider;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ComponentRuntime$$ExternalSyntheticLambda1 implements Provider {
    public static int MediaBrowserCompatMediaBrowserImplApi215;
    public static int MediaBrowserCompatMediaBrowserImplApi26;

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return Collections.emptySet();
    }

    public static int ITrustedWebActivityServiceStub() {
        int i = MediaBrowserCompatMediaBrowserImplApi26;
        int i2 = i % 5678682;
        MediaBrowserCompatMediaBrowserImplApi26 = i + 1;
        if (i2 != 0) {
            return MediaBrowserCompatMediaBrowserImplApi215;
        }
        int startUptimeMillis = (int) Process.getStartUptimeMillis();
        MediaBrowserCompatMediaBrowserImplApi215 = startUptimeMillis;
        return startUptimeMillis;
    }
}
