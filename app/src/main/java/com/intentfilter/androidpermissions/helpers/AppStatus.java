package com.intentfilter.androidpermissions.helpers;

import android.app.ActivityManager;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class AppStatus {
    private final Context context;

    public AppStatus(Context context) {
        this.context = context;
    }

    public boolean isInForeground() {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) this.context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equals(this.context.getApplicationInfo().processName)) {
                if (runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
        }
        return false;
    }
}
