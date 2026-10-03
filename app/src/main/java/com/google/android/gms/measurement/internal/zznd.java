package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zznd extends zzav {
    private final /* synthetic */ zzna zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zznd(zzna zznaVar, zziq zziqVar) {
        super(zziqVar);
        this.zza = zznaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() {
        this.zza.zzu();
        this.zza.zzj().zzp().zza("Starting upload from DelayedRunnable");
        this.zza.zzf.zzw();
    }
}
