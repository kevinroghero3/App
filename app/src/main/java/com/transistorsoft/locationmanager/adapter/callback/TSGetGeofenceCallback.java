package com.transistorsoft.locationmanager.adapter.callback;

import com.transistorsoft.locationmanager.geofence.TSGeofence;

/* JADX INFO: loaded from: classes.dex */
public interface TSGetGeofenceCallback {
    void onFailure(String str);

    void onSuccess(TSGeofence tSGeofence);
}
