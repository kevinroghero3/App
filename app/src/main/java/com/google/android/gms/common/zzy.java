package com.google.android.gms.common;

import android.os.Process;

/* JADX INFO: loaded from: classes4.dex */
public final class zzy {
    public static int MediaBrowserCompat;
    public static int connect;

    static int zza(int i) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i2 = 0; i2 < 6; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                throw null;
            }
            if (i3 - 1 == i) {
                return i3;
            }
        }
        return 1;
    }

    public static int newSessionWithExtras() {
        int i = MediaBrowserCompat;
        int i2 = i % 5160867;
        MediaBrowserCompat = i + 1;
        if (i2 != 0) {
            return connect;
        }
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        connect = elapsedCpuTime;
        return elapsedCpuTime;
    }
}
