package com.salesforce.marketingcloud.util;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static Boolean a;
    private static Boolean b;

    private b() {
    }

    public static boolean a() {
        if (b == null) {
            try {
                Class.forName("org.altbeacon.beacon.BeaconManager");
                b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                b = Boolean.FALSE;
            }
        }
        return b.booleanValue();
    }

    public static boolean b() {
        if (a == null) {
            try {
                Class.forName("com.google.android.gms.location.LocationServices");
                a = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                a = Boolean.FALSE;
            }
        }
        return a.booleanValue();
    }
}
