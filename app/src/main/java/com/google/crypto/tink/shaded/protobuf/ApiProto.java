package com.google.crypto.tink.shaded.protobuf;

import android.os.Process;

/* JADX INFO: loaded from: classes5.dex */
public final class ApiProto {
    public static int MediaBrowserCompatMediaBrowserImplApi212;
    public static int MediaBrowserCompatMediaBrowserImplApi214;

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private ApiProto() {
    }

    public static int ITrustedWebActivityCallbackStubProxy() {
        int i = MediaBrowserCompatMediaBrowserImplApi214;
        int i2 = i % 8393714;
        MediaBrowserCompatMediaBrowserImplApi214 = i + 1;
        if (i2 != 0) {
            return MediaBrowserCompatMediaBrowserImplApi212;
        }
        int startUptimeMillis = (int) Process.getStartUptimeMillis();
        MediaBrowserCompatMediaBrowserImplApi212 = startUptimeMillis;
        return startUptimeMillis;
    }
}
