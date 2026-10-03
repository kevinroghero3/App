package com.google.maps.android.geometry;

import ch.qos.logback.core.CoreConstants;

/* JADX INFO: loaded from: classes3.dex */
public class Point {
    public final double x;
    public final double y;

    public Point(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public String toString() {
        return "Point{x=" + this.x + ", y=" + this.y + CoreConstants.CURLY_RIGHT;
    }
}
