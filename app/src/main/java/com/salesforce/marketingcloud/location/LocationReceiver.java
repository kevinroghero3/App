package com.salesforce.marketingcloud.location;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.LocationResult;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.util.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class LocationReceiver extends BroadcastReceiver {
    private static final String a = "com.salesforce.marketingcloud.LOCATION_UPDATE";
    private static final String b = "com.salesforce.marketingcloud.GEOFENCE_TRIGGERED";
    private static final String c = com.salesforce.marketingcloud.g.a("LocationReceiver");

    static boolean a(Context context) {
        return com.salesforce.marketingcloud.util.f.a(context.getPackageManager(), new Intent(context, (Class<?>) LocationReceiver.class));
    }

    static PendingIntent b(Context context) {
        return PendingIntent.getBroadcast(context, 1, new Intent(context, (Class<?>) LocationReceiver.class).setAction(b), j.b(134217728));
    }

    static PendingIntent c(Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) LocationReceiver.class).setAction(a), j.b(134217728));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String str = c;
        com.salesforce.marketingcloud.g.d(str, "onReceive - %s", intent.getAction());
        if (!j.a(500L, 50L) || MarketingCloudSdk.getInstance() == null) {
            com.salesforce.marketingcloud.g.e(str, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
            return;
        }
        String action = intent.getAction();
        action.hashCode();
        if (action.equals(b)) {
            a(context, GeofencingEvent.fromIntent(intent));
        } else if (action.equals(a)) {
            a(context, LocationResult.extractResult(intent));
        }
    }

    private static void a(Context context, LocationResult locationResult) {
        if (locationResult == null) {
            com.salesforce.marketingcloud.g.d(c, "LocationResult was null.", new Object[0]);
            return;
        }
        Location lastLocation = locationResult.getLastLocation();
        if (lastLocation == null) {
            com.salesforce.marketingcloud.g.d(c, "LastLocation was null.", new Object[0]);
        } else {
            context.sendBroadcast(f.a(lastLocation).setPackage(context.getPackageName()));
        }
    }

    private static void a(Context context, GeofencingEvent geofencingEvent) {
        if (geofencingEvent == null) {
            com.salesforce.marketingcloud.g.d(c, "Geofencing event was null.", new Object[0]);
            return;
        }
        if (geofencingEvent.hasError()) {
            String statusCodeString = GeofenceStatusCodes.getStatusCodeString(geofencingEvent.getErrorCode());
            com.salesforce.marketingcloud.g.a(c, "Geofencing event contained error: %s", statusCodeString);
            context.sendBroadcast(f.a(geofencingEvent.getErrorCode(), statusCodeString).setPackage(context.getPackageName()));
        } else {
            if (geofencingEvent.getTriggeringGeofences() != null && !geofencingEvent.getTriggeringGeofences().isEmpty()) {
                int geofenceTransition = geofencingEvent.getGeofenceTransition();
                com.salesforce.marketingcloud.g.d(c, "Geofencing event transition: %d", Integer.valueOf(geofenceTransition));
                ArrayList arrayList = new ArrayList();
                for (Geofence geofence : geofencingEvent.getTriggeringGeofences()) {
                    com.salesforce.marketingcloud.g.d(c, "Triggered fence id: %s", geofence.getRequestId());
                    arrayList.add(geofence.getRequestId());
                }
                context.sendBroadcast(f.a(a(geofenceTransition), arrayList, geofencingEvent.getTriggeringLocation()).setPackage(context.getPackageName()));
                return;
            }
            com.salesforce.marketingcloud.g.a(c, "GeofencingEvent without triggering geofences.", new Object[0]);
        }
    }

    private static int a(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 4;
                if (i != 4) {
                    com.salesforce.marketingcloud.g.d(c, "Unknown geofence transition %d", Integer.valueOf(i));
                    return -1;
                }
            }
        }
        return i2;
    }
}
