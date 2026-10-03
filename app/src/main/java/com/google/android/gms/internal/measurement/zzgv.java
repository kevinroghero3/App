package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes4.dex */
final class zzgv extends ContentObserver {
    private final /* synthetic */ zzgt zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgv(zzgt zzgtVar, Handler handler) {
        super(null);
        this.zza = zzgtVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzd();
    }
}
