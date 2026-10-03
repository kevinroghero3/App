package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class StatsUtils {
    public static String getEventKey(@NonNull PowerManager.WakeLock wakeLock, @NonNull String str) {
        long jMyPid = Process.myPid();
        long jIdentityHashCode = System.identityHashCode(wakeLock);
        if (true == TextUtils.isEmpty(str)) {
            str = "";
        }
        return String.valueOf(String.valueOf((jMyPid << 32) | jIdentityHashCode)).concat(String.valueOf(str));
    }
}
