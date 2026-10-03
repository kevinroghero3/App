package com.transistorsoft.locationmanager.event;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationManagerCompat;
import com.facebook.react.uimanager.ViewProps;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.provider.TSProviderManager;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import com.transistorsoft.rnbackgroundgeolocation.RNBackgroundGeolocationModule;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationProviderChangeEvent {
    private int a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private boolean f;
    private long g;

    public LocationProviderChangeEvent(Context context) {
        init(context);
    }

    public long elapsed() {
        return System.currentTimeMillis() - this.g;
    }

    public boolean equals(LocationProviderChangeEvent locationProviderChangeEvent) {
        return locationProviderChangeEvent.isGPSEnabled() == this.b && locationProviderChangeEvent.isNetworkEnabled() == this.c && locationProviderChangeEvent.isPermissionGranted() == isPermissionGranted() && locationProviderChangeEvent.isEnabled() == isEnabled() && locationProviderChangeEvent.getAccuracyAuthorization() == this.e && locationProviderChangeEvent.isAirplaneMode() == this.f && locationProviderChangeEvent.getStatus() == this.d;
    }

    public int getAccuracyAuthorization() {
        return this.e;
    }

    public int getPermission() {
        return this.a;
    }

    public int getStatus() {
        return this.d;
    }

    public void init(Context context) {
        this.g = System.currentTimeMillis();
        this.e = TSProviderManager.ACCURACY_AUTHORIZATION_FULL;
        this.a = ContextCompat.checkSelfPermission(context, RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION);
        boolean zHasPermission = LocationAuthorization.hasPermission(context);
        int i = Build.VERSION.SDK_INT;
        this.f = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            boolean zIsLocationEnabled = LocationManagerCompat.isLocationEnabled(locationManager);
            this.b = zIsLocationEnabled && locationManager.isProviderEnabled("gps");
            this.c = zIsLocationEnabled && locationManager.isProviderEnabled("network") && wifiManager.isWifiEnabled();
        }
        this.d = 0;
        if (!zHasPermission) {
            this.d = TSProviderManager.PERMISSION_DENIED;
            return;
        }
        if (i < 29) {
            this.d = TSProviderManager.PERMISSION_ALWAYS;
            return;
        }
        this.d = LocationAuthorization.hasBackgroundPermission(context) ? TSProviderManager.PERMISSION_ALWAYS : TSProviderManager.PERMISSION_WHEN_IN_USE;
        if (i >= 31) {
            this.e = ContextCompat.checkSelfPermission(context, RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION) == 0 ? TSProviderManager.ACCURACY_AUTHORIZATION_FULL : TSProviderManager.ACCURACY_AUTHORIZATION_REDUCED;
        }
    }

    public boolean isAirplaneMode() {
        return this.f;
    }

    public boolean isEnabled() {
        return this.b || this.c;
    }

    public boolean isGPSEnabled() {
        return this.b;
    }

    public boolean isNetworkEnabled() {
        return this.c;
    }

    public boolean isPermissionGranted() {
        return this.a == 0;
    }

    public void load(Context context) {
        init(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(TSProviderManager.class.getSimpleName(), 0);
        if (sharedPreferences.contains("networkEnabled")) {
            this.c = sharedPreferences.getBoolean("networkEnabled", this.c);
            this.b = sharedPreferences.getBoolean("gpsEnabled", this.b);
            this.a = sharedPreferences.getInt("permission", this.a);
            this.e = sharedPreferences.getInt("accuracyAuthorization", this.e);
            this.f = sharedPreferences.getBoolean("isAirplaneMode", this.f);
            this.d = sharedPreferences.getInt("status", this.d);
        }
    }

    public void save(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(TSProviderManager.class.getSimpleName(), 0).edit();
        editorEdit.putBoolean("networkEnabled", this.c);
        editorEdit.putBoolean("gpsEnabled", this.b);
        editorEdit.putInt("permission", this.a);
        editorEdit.putInt("accuracyAuthorization", this.e);
        editorEdit.putBoolean("isAirplaneMode", this.f);
        editorEdit.putInt("status", this.d);
        editorEdit.apply();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("network", this.c);
            jSONObject.put("gps", this.b);
            jSONObject.put(ViewProps.ENABLED, isEnabled());
            jSONObject.put("status", this.d);
            jSONObject.put("accuracyAuthorization", this.e);
            jSONObject.put("airplane", this.f);
        } catch (JSONException e) {
            TSLog.logger.error(TSLog.error(e.getMessage()));
            e.printStackTrace();
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("network", Boolean.valueOf(this.c));
        map.put("gps", Boolean.valueOf(this.b));
        map.put(ViewProps.ENABLED, Boolean.valueOf(isEnabled()));
        map.put("status", Integer.valueOf(this.d));
        map.put("accuracyAuthorization", Integer.valueOf(this.e));
        map.put("airplane", Boolean.valueOf(this.f));
        return map;
    }

    public void update(LocationProviderChangeEvent locationProviderChangeEvent) {
        this.g = System.currentTimeMillis();
        this.e = locationProviderChangeEvent.getAccuracyAuthorization();
        this.a = locationProviderChangeEvent.getPermission();
        this.f = locationProviderChangeEvent.isAirplaneMode();
        this.b = locationProviderChangeEvent.isGPSEnabled();
        this.c = locationProviderChangeEvent.isNetworkEnabled();
        this.d = locationProviderChangeEvent.getStatus();
    }
}
