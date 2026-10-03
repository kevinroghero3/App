package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
abstract class zzin extends zzio {
    private boolean zza;

    zzin(zzho zzhoVar) {
        super(zzhoVar);
        this.zzu.zzaa();
    }

    protected void zzaa() {
    }

    protected abstract boolean zzo();

    protected final void zzac() {
        if (!zzaf()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzad() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzo()) {
            return;
        }
        this.zzu.zzz();
        this.zza = true;
    }

    public final void zzae() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaa();
        this.zzu.zzz();
        this.zza = true;
    }

    final boolean zzaf() {
        return this.zza;
    }
}
