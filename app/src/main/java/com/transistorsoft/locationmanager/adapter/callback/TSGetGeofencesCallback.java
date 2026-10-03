package com.transistorsoft.locationmanager.adapter.callback;

import com.transistorsoft.locationmanager.geofence.TSGeofence;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface TSGetGeofencesCallback {
    void onFailure(String str);

    void onSuccess(List<TSGeofence> list);
}
