package com.transistorsoft.locationmanager.workers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.adapter.callback.TSSyncCallback;
import com.transistorsoft.locationmanager.data.LocationModel;
import com.transistorsoft.locationmanager.data.sqlite.GeofenceDAO;
import com.transistorsoft.locationmanager.data.sqlite.SQLiteLocationDAO;
import com.transistorsoft.locationmanager.event.GeofenceEvent;
import com.transistorsoft.locationmanager.event.PersistEvent;
import com.transistorsoft.locationmanager.geofence.TSGeofence;
import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.logger.TSMediaPlayer;
import com.transistorsoft.locationmanager.plugin.TSPlugin;
import com.transistorsoft.locationmanager.service.ActivityRecognitionService;
import com.transistorsoft.locationmanager.util.BackgroundTaskManager;
import io.sentry.protocol.Device;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes6.dex */
public class GeofenceWorker {
    public static String ACTION = "GeofenceWorker";
    private final Context a;
    private final int b;

    class a implements TSSyncCallback {
        a() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSSyncCallback
        public void onFailure(String str) {
            GeofenceWorker.this.a(1000L);
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSSyncCallback
        public void onSuccess(List<LocationModel> list) {
            GeofenceWorker.this.a(1000L);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TSLog.logger.debug(GeofenceWorker.ACTION + ": stop");
            BackgroundTaskManager.getInstance().stopBackgroundTask(GeofenceWorker.this.a, GeofenceWorker.this.b);
        }
    }

    public GeofenceWorker(Context context, GeofencingEvent geofencingEvent, int i) {
        this.b = i;
        this.a = context;
        a(geofencingEvent);
    }

    private void a(GeofencingEvent geofencingEvent) {
        String str;
        String str2;
        int geofenceTransition = geofencingEvent.getGeofenceTransition();
        if (geofenceTransition == 1) {
            str2 = "tslocationmanager_beep_trip_up_dry";
            str = "ENTER";
        } else if (geofenceTransition == 2) {
            str2 = "tslocationmanager_beep_trip_dry";
            str = "EXIT";
        } else if (geofenceTransition != 4) {
            str = "UNKNOWN";
            str2 = "";
        } else {
            str2 = "tslocationmanager_beep_trip_up_echo";
            str = "DWELL";
        }
        TSMediaPlayer.getInstance().debug(this.a, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(TSLog.header("Geofencing Event: " + str));
        Iterator<Geofence> it2 = geofencingEvent.getTriggeringGeofences().iterator();
        while (it2.hasNext()) {
            sb.append(TSLog.boxRow(it2.next().getRequestId()));
        }
        sb.append(TSLog.BOX_BOTTOM);
        TSLog.logger.info(sb.toString());
        Location triggeringLocation = geofencingEvent.getTriggeringLocation();
        a(triggeringLocation);
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        GeofenceDAO geofenceDAO = GeofenceDAO.getInstance(this.a);
        TSLocationManager tSLocationManager = TSLocationManager.getInstance(this.a);
        Bundle extras = triggeringLocation.getExtras();
        extras.putBoolean("isMoving", tSConfig.getIsMoving().booleanValue());
        extras.putFloat(TSLocation.LOCATION_OPTIONS_ODOMETER, tSConfig.getOdometer().floatValue());
        EventBus.getDefault().post(new TSLocation(this.a, triggeringLocation, ActivityRecognitionService.getMostProbableActivity(), tSLocationManager.getCurrentLocationProvider()));
        for (Geofence geofence : geofencingEvent.getTriggeringGeofences()) {
            if (tSConfig.getMaxRecordsToPersist().intValue() != 0) {
                TSGeofence tSGeofenceFind = geofenceDAO.find(geofence.getRequestId());
                if (tSGeofenceFind == null) {
                    TSLog.logger.error("Failed to find geofence record in database: " + geofence.getRequestId());
                } else {
                    GeofenceEvent geofenceEvent = new GeofenceEvent(geofenceTransition, tSGeofenceFind, new TSLocation(this.a, triggeringLocation, ActivityRecognitionService.getMostProbableActivity()));
                    a(geofenceEvent.getLocation());
                    EventBus.getDefault().post(geofenceEvent);
                }
            }
        }
    }

    private void a(TSLocation tSLocation) {
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        if (!tSConfig.shouldPersist(tSLocation)) {
            a(1000L);
            return;
        }
        if (EventBus.getDefault().hasSubscriberForEvent(PersistEvent.class)) {
            if (TSPlugin.getInstance().canUsePersistEvent(this.a)) {
                EventBus.getDefault().post(new PersistEvent(this.a, tSLocation, tSConfig.getParams()));
            } else {
                TSLog.logger.warn(TSLog.warn("Failed to persist location"));
            }
            a(1000L);
            return;
        }
        if (tSConfig.getMaxDaysToPersist().intValue() != 0 && tSConfig.getPersist().booleanValue()) {
            if (SQLiteLocationDAO.getInstance(this.a).persist(tSLocation)) {
                if (TSConfig.getInstance(this.a).getAutoSync().booleanValue()) {
                    BackgroundGeolocation.getInstance(this.a).sync(new a());
                    return;
                }
                return;
            } else {
                TSLog.logger.error(TSLog.error("INSERT FAILURE" + tSLocation));
                a(1000L);
                return;
            }
        }
        a(1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        new Handler(Looper.getMainLooper()).postDelayed(new b(), j);
    }

    private void a(Location location) {
        Bundle extras = location.getExtras();
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putString("action", BackgroundGeolocation.ACTION_ON_GEOFENCE);
        extras.putFloat(TSLocation.LOCATION_OPTIONS_ODOMETER, tSConfig.getOdometer().floatValue());
        Intent intentRegisterReceiver = this.a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            extras.putFloat(Device.JsonKeys.BATTERY_LEVEL, intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1));
            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
            extras.putBoolean("is_charging", intExtra == 2 || intExtra == 5);
        }
        location.setExtras(extras);
    }
}
