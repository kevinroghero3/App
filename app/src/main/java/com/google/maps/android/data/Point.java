package com.google.maps.android.data;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: loaded from: classes5.dex */
public class Point implements Geometry {
    private static final String GEOMETRY_TYPE = "Point";
    private final LatLng mCoordinates;

    public Point(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        this.mCoordinates = latLng;
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    @Override // com.google.maps.android.data.Geometry
    public LatLng getGeometryObject() {
        return this.mCoordinates;
    }

    public String toString() {
        return GEOMETRY_TYPE + "{\n coordinates=" + this.mCoordinates + "\n}\n";
    }
}
