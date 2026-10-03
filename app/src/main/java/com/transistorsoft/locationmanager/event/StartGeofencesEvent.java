package com.transistorsoft.locationmanager.event;

import android.content.Context;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;

/* JADX INFO: loaded from: classes3.dex */
public class StartGeofencesEvent {
    public static final String ACTION = "START_GEOFENCES";

    public StartGeofencesEvent(Context context) {
        BackgroundGeolocation.getInstance(context).startGeofences();
    }
}
