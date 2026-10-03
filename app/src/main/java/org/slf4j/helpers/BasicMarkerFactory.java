package org.slf4j.helpers;

import android.os.Process;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public class BasicMarkerFactory implements IMarkerFactory {
    public static int onRemoveQueueItem;
    public static int onRewind;
    private final ConcurrentMap<String, Marker> markerMap = new ConcurrentHashMap();

    @Override // org.slf4j.IMarkerFactory
    public Marker getMarker(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Marker name cannot be null");
        }
        Marker marker = this.markerMap.get(str);
        if (marker != null) {
            return marker;
        }
        BasicMarker basicMarker = new BasicMarker(str);
        Marker markerPutIfAbsent = this.markerMap.putIfAbsent(str, basicMarker);
        return markerPutIfAbsent != null ? markerPutIfAbsent : basicMarker;
    }

    @Override // org.slf4j.IMarkerFactory
    public boolean exists(String str) {
        if (str == null) {
            return false;
        }
        return this.markerMap.containsKey(str);
    }

    @Override // org.slf4j.IMarkerFactory
    public boolean detachMarker(String str) {
        return (str == null || this.markerMap.remove(str) == null) ? false : true;
    }

    @Override // org.slf4j.IMarkerFactory
    public Marker getDetachedMarker(String str) {
        return new BasicMarker(str);
    }

    public static int MediaBrowserCompatMediaBrowserImplBaseMediaServiceConnection1() {
        int i = onRewind;
        int i2 = i % 7655223;
        onRewind = i + 1;
        if (i2 != 0) {
            return onRemoveQueueItem;
        }
        int iMyPid = Process.myPid();
        onRemoveQueueItem = iMyPid;
        return iMyPid;
    }
}
