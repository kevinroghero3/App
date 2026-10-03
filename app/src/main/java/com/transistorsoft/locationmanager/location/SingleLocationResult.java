package com.transistorsoft.locationmanager.location;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
public class SingleLocationResult {
    private final int a;
    private final Location b;

    public SingleLocationResult(int i, Location location) {
        this.a = i;
        this.b = location;
    }

    int a() {
        return this.a;
    }

    public Location getLocation() {
        return this.b;
    }
}
