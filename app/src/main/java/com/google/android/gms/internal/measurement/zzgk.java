package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes4.dex */
final class zzgk extends ContentObserver {
    private final /* synthetic */ zzgi zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgk(zzgi zzgiVar, Handler handler) {
        super(null);
        this.zza = zzgiVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zza.set(true);
    }
}
