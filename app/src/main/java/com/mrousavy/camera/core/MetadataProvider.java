package com.mrousavy.camera.core;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.transistorsoft.rnbackgroundgeolocation.RNBackgroundGeolocationModule;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataProvider implements LocationListener {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MetadataProvider";
    private static final float UPDATE_DISTANCE_M = 5.0f;
    private static final long UPDATE_INTERVAL_MS = 5000;
    private final Context context;
    private Location location;
    private final LocationManager locationManager;

    public MetadataProvider(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        this.locationManager = (LocationManager) systemService;
    }

    public final Context getContext() {
        return this.context;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean getHasLocationPermission() {
        return ContextCompat.checkSelfPermission(this.context, RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION) == 0 || ContextCompat.checkSelfPermission(this.context, RNBackgroundGeolocationModule.ACCESS_COARSE_LOCATION) == 0;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final void enableLocationUpdates(boolean z) throws LocationPermissionError {
        if (!z) {
            Log.i(TAG, "Stopping location updates...");
            this.locationManager.removeUpdates(this);
        } else {
            if (getHasLocationPermission()) {
                Log.i(TAG, "Start updating location...");
                this.locationManager.requestLocationUpdates("gps", 5000L, 5.0f, this);
                Location lastKnownLocation = this.locationManager.getLastKnownLocation("gps");
                this.location = lastKnownLocation;
                if (lastKnownLocation == null) {
                    this.locationManager.requestSingleUpdate("gps", this, (Looper) null);
                    return;
                }
                return;
            }
            throw new LocationPermissionError();
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        Log.i(TAG, "Location updated: " + location.getLatitude() + ", " + location.getLongitude());
        this.location = location;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(@NotNull String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Log.i(TAG, "Location Provider " + provider + " has been disabled.");
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(@NotNull String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Log.i(TAG, "Location Provider " + provider + " has been enabled.");
    }

    @Override // android.location.LocationListener
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "", imports = {""}))
    public void onStatusChanged(@Nullable String str, int i, @Nullable Bundle bundle) {
        Log.i(TAG, "Location Provider " + str + " status changed: " + i);
    }
}
