package com.transistorsoft.locationmanager.location;

import android.content.Context;
import android.location.Location;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes.dex */
public class TSCurrentPositionRequest extends SingleLocationRequest {
    private final Long u;

    public static class Builder extends SingleLocationRequest.Builder<Builder> {
        private long i;

        public Builder(Context context) {
            super(context);
            this.h = 2;
            this.i = 0L;
        }

        public Builder setMaximumAge(Long l) {
            this.i = l.longValue();
            return this;
        }

        @Override // com.transistorsoft.locationmanager.location.SingleLocationRequest.Builder
        public TSCurrentPositionRequest build() {
            return new TSCurrentPositionRequest(this);
        }
    }

    protected TSCurrentPositionRequest(Builder builder) {
        super(builder);
        this.u = Long.valueOf(builder.i);
    }

    @Override // com.transistorsoft.locationmanager.location.SingleLocationRequest
    void a(Location location) {
        int i = this.d.get();
        super.a(location);
        if (this.u.longValue() > 0) {
            if (TSLocationManager.locationAge(location) <= this.u.longValue() && location.getAccuracy() <= this.f) {
                finish();
                location.getExtras().remove(NotificationCompat.CATEGORY_EVENT);
            } else {
                if (i == 1) {
                    i = 2;
                }
                this.d.set(i);
            }
        }
    }

    public long getMaximumAge() {
        return this.u.longValue();
    }
}
