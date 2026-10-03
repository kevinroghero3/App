package com.transistorsoft.locationmanager.event;

import android.content.Context;
import android.os.Build;
import com.transistorsoft.locationmanager.service.AbstractService;

/* JADX INFO: loaded from: classes3.dex */
public class LaunchForegroundServiceEvent {
    public static final String ACTION = "LAUNCH_FOREGROUND_SERVICE";

    public LaunchForegroundServiceEvent(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            AbstractService.launchQueuedServices(context);
        }
    }
}
