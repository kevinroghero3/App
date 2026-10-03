package com.transistorsoft.locationmanager.geofence;

import android.os.Process;
import com.google.android.gms.tasks.OnSuccessListener;
import com.transistorsoft.locationmanager.adapter.callback.TSCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TSGeofenceManager$$ExternalSyntheticLambda7 implements OnSuccessListener {
    public static int MediaControllerCompatApi24;
    public static int R;
    public final /* synthetic */ TSGeofenceManager f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ TSCallback f$2;

    public /* synthetic */ TSGeofenceManager$$ExternalSyntheticLambda7(TSGeofenceManager tSGeofenceManager, List list, TSCallback tSCallback) {
        this.f$0 = tSGeofenceManager;
        this.f$1 = list;
        this.f$2 = tSCallback;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.f$0.b(this.f$1, this.f$2, (Void) obj);
    }

    public static int S() {
        int i = MediaControllerCompatApi24;
        int i2 = i % 6495988;
        MediaControllerCompatApi24 = i + 1;
        if (i2 != 0) {
            return R;
        }
        int startUptimeMillis = (int) Process.getStartUptimeMillis();
        R = startUptimeMillis;
        return startUptimeMillis;
    }
}
