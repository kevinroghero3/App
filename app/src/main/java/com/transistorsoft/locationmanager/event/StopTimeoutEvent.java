package com.transistorsoft.locationmanager.event;

import android.content.Context;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.service.TrackingService;

/* JADX INFO: loaded from: classes3.dex */
public class StopTimeoutEvent {
    public static final String ACTION = "STOP_TIMEOUT";

    public StopTimeoutEvent(Context context) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (tSConfig.getEnabled().booleanValue() && tSConfig.getIsMoving().booleanValue()) {
            TrackingService.changePace(context, false, null);
        }
    }
}
