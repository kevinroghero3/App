package com.google.maps.android.data.kml;

import com.google.maps.android.data.Geometry;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class KmlMultiTrack extends KmlMultiGeometry {
    public KmlMultiTrack(ArrayList<KmlTrack> arrayList) {
        super(createGeometries(arrayList));
    }

    private static ArrayList<Geometry> createGeometries(ArrayList<KmlTrack> arrayList) {
        ArrayList<Geometry> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            throw new IllegalArgumentException("Tracks cannot be null");
        }
        Iterator<KmlTrack> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next());
        }
        return arrayList2;
    }
}
