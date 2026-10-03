package com.transistorsoft.locationmanager.event;

import android.content.Context;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.service.TrackingService;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class StopAfterElapsedMinutesEvent {
    public static final String ACTION = "STOP_AFTER_ELAPSED_MINUTES";

    public StopAfterElapsedMinutesEvent(Context context) {
        if (TSConfig.getInstance(context).getEnabled().booleanValue()) {
            EventBus.getDefault().post(this);
            TrackingService.stop(context);
        }
    }
}
