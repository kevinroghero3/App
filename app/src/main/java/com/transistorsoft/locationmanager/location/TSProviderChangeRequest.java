package com.transistorsoft.locationmanager.location;

import android.content.Context;
import com.transistorsoft.locationmanager.adapter.TSConfig;

/* JADX INFO: loaded from: classes.dex */
public class TSProviderChangeRequest extends SingleLocationRequest {

    public static class Builder extends SingleLocationRequest.Builder<Builder> {
        public Builder(Context context) {
            super(context);
            this.h = 3;
            TSConfig tSConfig = TSConfig.getInstance(context.getApplicationContext());
            this.c = tSConfig.getEnabled().booleanValue() && tSConfig.isLocationTrackingMode() && !tSConfig.getDisableProviderChangeRecord();
        }

        @Override // com.transistorsoft.locationmanager.location.SingleLocationRequest.Builder
        public TSProviderChangeRequest build() {
            return new TSProviderChangeRequest(this);
        }
    }

    TSProviderChangeRequest(Builder builder) {
        super(builder);
    }
}
