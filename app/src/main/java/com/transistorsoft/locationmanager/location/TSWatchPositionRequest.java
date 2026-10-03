package com.transistorsoft.locationmanager.location;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.intentfilter.androidpermissions.PermissionManager;
import com.intentfilter.androidpermissions.models.DeniedPermissions;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.service.LocationRequestService;
import com.transistorsoft.locationmanager.settings.Settings;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class TSWatchPositionRequest extends SingleLocationRequest {
    private long u;
    private PendingIntent v;
    private final AtomicBoolean w;

    public static class Builder extends SingleLocationRequest.Builder<Builder> {
        private long i;

        public Builder(Context context) {
            super(context);
            this.h = 5;
            this.i = 1000L;
            this.e = TSConfig.getInstance(context).getDesiredAccuracy().intValue();
        }

        public Builder setInterval(Long l) {
            this.i = l.longValue();
            return this;
        }

        @Override // com.transistorsoft.locationmanager.location.SingleLocationRequest.Builder
        public TSWatchPositionRequest build() {
            return new TSWatchPositionRequest(this);
        }
    }

    class a implements PermissionManager.PermissionRequestListener {
        a() {
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            TSWatchPositionRequest.this.onError(1);
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            TSLocationManager tSLocationManager = TSLocationManager.getInstance(TSWatchPositionRequest.this.b);
            if (tSLocationManager == null) {
                TSWatchPositionRequest.this.onError(-1);
            } else if (tSLocationManager.isLocationServicesEnabled().booleanValue()) {
                TSWatchPositionRequest.this.startUpdatingLocation();
            } else {
                TSWatchPositionRequest.this.onError(1);
            }
        }
    }

    TSWatchPositionRequest(Builder builder) {
        super(builder);
        this.w = new AtomicBoolean(false);
        this.f = TSConfig.getInstance(this.b).translateDesiredAccuracy(Integer.valueOf(builder.e)).intValue();
        this.u = builder.i;
    }

    @Override // com.transistorsoft.locationmanager.location.SingleLocationRequest
    void g() {
        LocationAuthorization.withPermission(this.b, new a());
    }

    public long getInterval() {
        return this.u;
    }

    void h() {
        synchronized (this.w) {
            this.w.set(false);
        }
        LocationServices.getFusedLocationProviderClient(this.b).removeLocationUpdates(SingleLocationRequest.getPendingIntent(this.b, this.a, getId()));
        LocationRequestService.stopService(this.b);
    }

    @Override // com.transistorsoft.locationmanager.location.SingleLocationRequest
    public void onError(int i) {
        TSLocationCallback tSLocationCallback = this.h;
        if (tSLocationCallback != null) {
            tSLocationCallback.onError(Integer.valueOf(i));
        }
    }

    @Override // com.transistorsoft.locationmanager.location.SingleLocationRequest
    public void onSuccess(TSLocation tSLocation) {
        TSLocationCallback tSLocationCallback = this.h;
        if (tSLocationCallback != null) {
            tSLocationCallback.onLocation(tSLocation);
        }
    }

    @Override // com.transistorsoft.locationmanager.location.SingleLocationRequest
    public void startUpdatingLocation() {
        TSConfig tSConfig = TSConfig.getInstance(this.b);
        if (Settings.isValid(this.b)) {
            synchronized (this.w) {
                if (this.w.get()) {
                    h();
                }
                this.w.set(true);
            }
            LocationRequest locationRequestCreate = LocationRequest.create();
            locationRequestCreate.setPriority(tSConfig.getDesiredAccuracy().intValue());
            locationRequestCreate.setInterval(this.u);
            locationRequestCreate.setFastestInterval(this.u);
            locationRequestCreate.setSmallestDisplacement(0.0f);
            locationRequestCreate.setMaxWaitTime(0L);
            try {
                LocationServices.getFusedLocationProviderClient(this.b).requestLocationUpdates(locationRequestCreate, SingleLocationRequest.getPendingIntent(this.b, this.a, getId()));
            } catch (SecurityException e) {
                TSLog.logger.error(TSLog.error("SecurityException while attempting to watchPosition: " + e.getMessage()), (Throwable) e);
            }
        }
    }
}
