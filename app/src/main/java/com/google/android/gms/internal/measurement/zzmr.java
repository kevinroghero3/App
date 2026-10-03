package com.google.android.gms.internal.measurement;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzmr implements zzlf {
    public static int getNotifyChildrenChangedOptions;
    public static int getRoot;

    @Override // com.google.android.gms.internal.measurement.zzlf
    public final zzlh zza() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzlf
    public final zzls zzb() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzlf
    public final boolean zzc() {
        throw new NoSuchMethodError();
    }

    public static int requestPostMessageChannel() {
        int i = getNotifyChildrenChangedOptions;
        int i2 = i % 8983302;
        getNotifyChildrenChangedOptions = i + 1;
        if (i2 != 0) {
            return getRoot;
        }
        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
        getRoot = iElapsedRealtime;
        return iElapsedRealtime;
    }
}
