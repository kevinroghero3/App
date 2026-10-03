package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzkf {
    public static int getItem;
    public static int getServiceComponent;

    public static int postMessage() {
        int i = getServiceComponent;
        int i2 = i % 6986330;
        getServiceComponent = i + 1;
        if (i2 != 0) {
            return getItem;
        }
        int iUptimeMillis = (int) SystemClock.uptimeMillis();
        getItem = iUptimeMillis;
        return iUptimeMillis;
    }
}
