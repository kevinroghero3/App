package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzlt extends zzav {
    private final /* synthetic */ zzlf zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzlt(zzlf zzlfVar, zziq zziqVar) {
        super(zziqVar);
        this.zza = zzlfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() {
        this.zza.zzj().zzu().zza("Tasks have been queued for a long time");
    }
}
