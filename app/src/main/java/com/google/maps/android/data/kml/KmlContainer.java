package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.GroundOverlay;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class KmlContainer {
    private String mContainerId;
    private final ArrayList<KmlContainer> mContainers;
    private final HashMap<KmlGroundOverlay, GroundOverlay> mGroundOverlays;
    private final HashMap<KmlPlacemark, Object> mPlacemarks;
    private final HashMap<String, String> mProperties;
    private final HashMap<String, String> mStyleMap;
    private HashMap<String, KmlStyle> mStyles;

    KmlContainer(HashMap<String, String> map, HashMap<String, KmlStyle> map2, HashMap<KmlPlacemark, Object> map3, HashMap<String, String> map4, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> map5, String str) {
        this.mProperties = map;
        this.mPlacemarks = map3;
        this.mStyles = map2;
        this.mStyleMap = map4;
        this.mContainers = arrayList;
        this.mGroundOverlays = map5;
        this.mContainerId = str;
    }

    HashMap<String, KmlStyle> getStyles() {
        return this.mStyles;
    }

    void setPlacemark(KmlPlacemark kmlPlacemark, Object obj) {
        this.mPlacemarks.put(kmlPlacemark, obj);
    }

    HashMap<String, String> getStyleMap() {
        return this.mStyleMap;
    }

    HashMap<KmlGroundOverlay, GroundOverlay> getGroundOverlayHashMap() {
        return this.mGroundOverlays;
    }

    public String getContainerId() {
        return this.mContainerId;
    }

    public KmlStyle getStyle(String str) {
        return this.mStyles.get(str);
    }

    public String getStyleIdFromMap(String str) {
        return this.mStyleMap.get(str);
    }

    HashMap<KmlPlacemark, Object> getPlacemarksHashMap() {
        return this.mPlacemarks;
    }

    public String getProperty(String str) {
        return this.mProperties.get(str);
    }

    public boolean hasProperties() {
        return this.mProperties.size() > 0;
    }

    public boolean hasProperty(String str) {
        return this.mProperties.containsKey(str);
    }

    public boolean hasContainers() {
        return this.mContainers.size() > 0;
    }

    public Iterable<KmlContainer> getContainers() {
        return this.mContainers;
    }

    public Iterable<String> getProperties() {
        return this.mProperties.keySet();
    }

    public Iterable<KmlPlacemark> getPlacemarks() {
        return this.mPlacemarks.keySet();
    }

    public boolean hasPlacemarks() {
        return this.mPlacemarks.size() > 0;
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return this.mGroundOverlays.keySet();
    }

    public String toString() {
        return "Container{\n properties=" + this.mProperties + ",\n placemarks=" + this.mPlacemarks + ",\n containers=" + this.mContainers + ",\n ground overlays=" + this.mGroundOverlays + ",\n style maps=" + this.mStyleMap + ",\n styles=" + this.mStyles + "\n}\n";
    }
}
