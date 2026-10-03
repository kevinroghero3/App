package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
abstract class zznf extends zznc {
    private boolean zza;

    zznf(zzng zzngVar) {
        super(zzngVar);
        this.zzf.zzu();
    }

    protected abstract boolean zzc();

    protected final void zzak() {
        if (!zzam()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzc();
        this.zzf.zzt();
        this.zza = true;
    }

    final boolean zzam() {
        return this.zza;
    }
}
