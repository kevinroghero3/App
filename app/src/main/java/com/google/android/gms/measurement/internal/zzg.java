package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
abstract class zzg extends zzd {
    private boolean zza;

    zzg(zzho zzhoVar) {
        super(zzhoVar);
        this.zzu.zzaa();
    }

    protected void zzx() {
    }

    protected abstract boolean zzz();

    protected final void zzu() {
        if (!zzy()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzz()) {
            return;
        }
        this.zzu.zzz();
        this.zza = true;
    }

    public final void zzw() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzx();
        this.zzu.zzz();
        this.zza = true;
    }

    final boolean zzy() {
        return this.zza;
    }
}
