package com.swmansion.rnscreens.utils;

/* JADX INFO: loaded from: classes.dex */
public final class EdgeToEdgePackageDetector {
    private static final boolean ENABLED;
    public static final EdgeToEdgePackageDetector INSTANCE = new EdgeToEdgePackageDetector();

    private EdgeToEdgePackageDetector() {
    }

    public final boolean getENABLED() {
        return ENABLED;
    }

    static {
        boolean z;
        try {
            Class.forName("com.zoontek.rnedgetoedge.EdgeToEdgePackage");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        ENABLED = z;
    }
}
