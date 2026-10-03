package com.google.maps.android.data;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.Observable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Style extends Observable {
    private static final String LOG_TAG = "Style";
    public MarkerOptions mMarkerOptions = new MarkerOptions();
    public PolygonOptions mPolygonOptions;
    public PolylineOptions mPolylineOptions;

    public Style() {
        PolylineOptions polylineOptions = new PolylineOptions();
        this.mPolylineOptions = polylineOptions;
        polylineOptions.clickable(true);
        PolygonOptions polygonOptions = new PolygonOptions();
        this.mPolygonOptions = polygonOptions;
        polygonOptions.clickable(true);
    }

    public float getRotation() {
        return this.mMarkerOptions.getRotation();
    }

    public void setMarkerRotation(float f) {
        this.mMarkerOptions.rotation(f);
    }

    public void setMarkerHotSpot(float f, float f2, String str, String str2) {
        if (!str.equals("fraction")) {
            SentryLogcatAdapter.w(LOG_TAG, "Hotspot xUnits other than \"fraction\" are not supported.");
            f = 0.5f;
        }
        if (!str2.equals("fraction")) {
            SentryLogcatAdapter.w(LOG_TAG, "Hotspot yUnits other than \"fraction\" are not supported.");
            f2 = 1.0f;
        }
        this.mMarkerOptions.anchor(f, f2);
    }

    public void setLineStringWidth(float f) {
        this.mPolylineOptions.width(f);
    }

    public void setPolygonStrokeWidth(float f) {
        this.mPolygonOptions.strokeWidth(f);
    }

    public void setPolygonFillColor(int i) {
        this.mPolygonOptions.fillColor(i);
    }
}
