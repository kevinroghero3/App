package com.transistorsoft.locationmanager.location;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
public class WatchPositionResult {
    private final Location a;
    private final int b;

    public WatchPositionResult(int i, Location location) {
        this.b = i;
        this.a = location;
    }

    public Location getLocation() {
        return this.a;
    }

    public int getRequestId() {
        return this.b;
    }
}
