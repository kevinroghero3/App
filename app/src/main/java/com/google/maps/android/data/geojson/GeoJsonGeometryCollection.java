package com.google.maps.android.data.geojson;

import android.os.SystemClock;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class GeoJsonGeometryCollection extends MultiGeometry {
    public static int MediaBrowserCompatMediaBrowserImplBase4;
    public static int MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection;

    public GeoJsonGeometryCollection(List<Geometry> list) {
        super(list);
        setGeometryType("GeometryCollection");
    }

    public String getType() {
        return getGeometryType();
    }

    public List<Geometry> getGeometries() {
        return getGeometryObject();
    }

    public static int INotificationSideChannelDefault() {
        int i = MediaBrowserCompatMediaBrowserImplBase4;
        int i2 = i % 5251899;
        MediaBrowserCompatMediaBrowserImplBase4 = i + 1;
        if (i2 != 0) {
            return MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection;
        }
        int iUptimeMillis = (int) SystemClock.uptimeMillis();
        MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection = iUptimeMillis;
        return iUptimeMillis;
    }
}
