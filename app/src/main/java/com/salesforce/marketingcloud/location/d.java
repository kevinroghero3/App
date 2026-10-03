package com.salesforce.marketingcloud.location;

import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class d implements OnFailureListener {
    static final String e = com.salesforce.marketingcloud.g.a("GmsLocationProvider");
    private final Context a;
    volatile boolean b;
    int c;
    String d;

    class a implements OnCompleteListener<Void> {
        a() {
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<Void> task) {
            com.salesforce.marketingcloud.g.d(d.e, "Location request completed.", new Object[0]);
            d.this.b = false;
        }
    }

    class b implements OnCompleteListener<Void> {
        b() {
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<Void> task) {
            com.salesforce.marketingcloud.g.d(d.e, "Add Geofences request completed.", new Object[0]);
        }
    }

    d(Context context) throws IllegalStateException {
        this.a = context;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
        this.c = iIsGooglePlayServicesAvailable;
        this.d = googleApiAvailability.getErrorString(iIsGooglePlayServicesAvailable);
        int i = this.c;
        if (i == 0 || googleApiAvailability.isUserResolvableError(i)) {
            return;
        }
        int i2 = this.c;
        throw new g(i2, googleApiAvailability.getErrorString(i2));
    }

    private static Geofence a(@NonNull com.salesforce.marketingcloud.location.b bVar) {
        int i = (bVar.j() & 1) != 1 ? 0 : 1;
        if ((bVar.j() & 2) == 2) {
            i |= 2;
        }
        if ((bVar.j() & 4) == 4) {
            i |= 4;
        }
        return new Geofence.Builder().setRequestId(bVar.f()).setCircularRegion(bVar.g(), bVar.h(), bVar.i()).setTransitionTypes(i).setExpirationDuration(-1L).build();
    }

    String b() {
        return this.d;
    }

    int c() {
        return this.c;
    }

    boolean d() {
        return this.c == 0;
    }

    void e() throws SecurityException {
        synchronized (this) {
            if (this.b) {
                com.salesforce.marketingcloud.g.d(e, "Location request already being made.", new Object[0]);
                return;
            }
            this.b = true;
            try {
                LocationServices.getFusedLocationProviderClient(this.a).requestLocationUpdates(LocationRequest.create().setNumUpdates(1).setPriority(100), LocationReceiver.c(this.a)).addOnFailureListener(this).addOnCompleteListener(new a());
            } catch (SecurityException e2) {
                com.salesforce.marketingcloud.g.b(e, e2, "ACCESS_FINE_LOCATION needed to request location.", new Object[0]);
                this.b = false;
                throw e2;
            }
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(@NonNull Exception exc) {
        com.salesforce.marketingcloud.g.b(e, exc, "LocationServices failure", new Object[0]);
    }

    void a(com.salesforce.marketingcloud.location.b... bVarArr) throws SecurityException {
        if (bVarArr != null && bVarArr.length != 0) {
            PendingIntent pendingIntentB = LocationReceiver.b(this.a);
            GeofencingRequest.Builder initialTrigger = new GeofencingRequest.Builder().setInitialTrigger(1);
            for (com.salesforce.marketingcloud.location.b bVar : bVarArr) {
                com.salesforce.marketingcloud.g.d(e, "Adding %s to geofence request", bVar.f());
                initialTrigger.addGeofence(a(bVar));
            }
            try {
                LocationServices.getGeofencingClient(this.a).addGeofences(initialTrigger.build(), pendingIntentB).addOnFailureListener(this).addOnCompleteListener(new b());
                return;
            } catch (SecurityException e2) {
                com.salesforce.marketingcloud.g.b(e, e2, "ACCESS_FINE_LOCATION needed to request location.", new Object[0]);
                throw e2;
            }
        }
        com.salesforce.marketingcloud.g.d(e, "No GeofenceRegions provided", new Object[0]);
    }

    void a(List<String> list) {
        if (list != null && list.size() != 0) {
            LocationServices.getGeofencingClient(this.a).removeGeofences(list).addOnFailureListener(this);
        } else {
            com.salesforce.marketingcloud.g.d(e, "No GeofenceRegions provided", new Object[0]);
        }
    }

    void a() {
        LocationServices.getGeofencingClient(this.a).removeGeofences(LocationReceiver.b(this.a)).addOnFailureListener(this);
    }
}
