package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzcq {
    private static zzcq zza = new zzcp();

    public static zzcq zza() {
        zzcq zzcqVar;
        synchronized (zzcq.class) {
            zzcqVar = zza;
        }
        return zzcqVar;
    }

    public abstract URLConnection zza(URL url, String str) throws IOException;
}
