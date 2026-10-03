package com.transistorsoft.locationmanager.event;

import android.content.Context;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class MotionActivityCheckEvent {
    public static final String ACTION = "MOTION_ACTIVITY_CHECK";

    public MotionActivityCheckEvent(Context context) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (tSConfig.getEnabled().booleanValue() && tSConfig.getIsMoving().booleanValue()) {
            EventBus.getDefault().post(this);
        }
    }
}
