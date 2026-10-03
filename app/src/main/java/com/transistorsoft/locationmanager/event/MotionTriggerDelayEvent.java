package com.transistorsoft.locationmanager.event;

import android.content.Context;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.service.ActivityRecognitionService;
import com.transistorsoft.locationmanager.service.TrackingService;

/* JADX INFO: loaded from: classes3.dex */
public class MotionTriggerDelayEvent {
    public static final String ACTION = "MOTION_TRIGGER_DELAY";

    public MotionTriggerDelayEvent(Context context) {
        if (TSConfig.getInstance(context).getEnabled().booleanValue()) {
            ActivityRecognitionService.disableMotionTriggerDelay(context.getApplicationContext());
            TrackingService.changePace(context.getApplicationContext(), true, null);
        }
    }
}
