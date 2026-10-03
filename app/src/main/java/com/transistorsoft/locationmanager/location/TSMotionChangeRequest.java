package com.transistorsoft.locationmanager.location;

import android.content.Context;
import android.location.Location;
import com.transistorsoft.locationmanager.adapter.TSConfig;

/* JADX INFO: loaded from: classes3.dex */
public class TSMotionChangeRequest extends SingleLocationRequest {

    /* JADX INFO: loaded from: classes.dex */
    public static class Builder extends SingleLocationRequest.Builder<Builder> {
        public Builder(Context context) {
            super(context);
            boolean z = true;
            this.h = 1;
            TSConfig tSConfig = TSConfig.getInstance(context.getApplicationContext());
            if (tSConfig.getEnabled().booleanValue() && tSConfig.isLocationTrackingMode()) {
                int iIntValue = tSConfig.getPersistMode().intValue();
                if (iIntValue != 2 && iIntValue != 1) {
                    z = false;
                }
                this.c = z;
            } else {
                this.c = false;
            }
            this.b = 30;
            this.d = 3;
            this.e = 50;
        }

        @Override // com.transistorsoft.locationmanager.location.SingleLocationRequest.Builder
        public TSMotionChangeRequest build() {
            return new TSMotionChangeRequest(this);
        }
    }

    @Override // com.transistorsoft.locationmanager.location.SingleLocationRequest
    void a(Location location) {
        super.a(location);
        long jLocationAge = TSLocationManager.locationAge(location);
        if (location.getAccuracy() > this.f || jLocationAge > 30000) {
            return;
        }
        finish();
    }

    private TSMotionChangeRequest(Builder builder) {
        super(builder);
    }
}
