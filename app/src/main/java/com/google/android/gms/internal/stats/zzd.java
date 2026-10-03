package com.google.android.gms.internal.stats;

import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class zzd extends zza {
    public static int search;
    public static int subscribe;

    @Override // com.google.android.gms.internal.stats.zza, java.io.Closeable, java.lang.AutoCloseable
    public final /* bridge */ /* synthetic */ void close() {
        throw null;
    }

    @Override // com.google.android.gms.internal.stats.zza
    public final /* bridge */ /* synthetic */ void finalize() {
    }

    public static int requestPostMessageChannelWithExtras() {
        int i = subscribe;
        int i2 = i % 6355964;
        subscribe = i + 1;
        if (i2 != 0) {
            return search;
        }
        int iNextInt = new Random().nextInt();
        search = iNextInt;
        return iNextInt;
    }
}
