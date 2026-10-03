package com.transistorsoft.locationmanager.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.location.LocationResult;
import com.transistorsoft.locationmanager.logger.TSLog;

/* JADX INFO: loaded from: classes6.dex */
public class SingleLocationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == null) {
            TSLog.logger.error(TSLog.error("handleLocationResult with no action"));
            return;
        }
        Bundle extras = intent.getExtras();
        extras.getInt("requestType");
        int i = extras.getInt("requestId");
        LocationResult.extractResult(intent);
        TSLocationManager.getInstance(context).getRequest(i).finish();
    }
}
