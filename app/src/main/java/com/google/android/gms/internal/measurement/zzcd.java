package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
final class zzcd extends zzcj {
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final zzcc zze;
    private final zzce zzf;
    private final zzcl zzg;

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode();
        int i = this.zzc ? 1231 : 1237;
        int i2 = this.zzd ? 1231 : 1237;
        zzcc zzccVar = this.zze;
        int iHashCode2 = zzccVar == null ? 0 : zzccVar.hashCode();
        zzce zzceVar = this.zzf;
        return ((((((((((iHashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ iHashCode2) * 1000003) ^ (zzceVar != null ? zzceVar.hashCode() : 0)) * 1000003) ^ this.zzg.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzcj
    public final zzcc zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzcj
    public final zzce zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzcj
    public final zzcl zzc() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzcj
    public final String zzd() {
        return this.zzb;
    }

    public final String toString() {
        return "FileComplianceOptions{fileOwner=" + this.zzb + ", hasDifferentDmaOwner=" + this.zzc + ", skipChecks=" + this.zzd + ", dataForwardingNotAllowedResolver=" + String.valueOf(this.zze) + ", multipleProductIdGroupsResolver=" + String.valueOf(this.zzf) + ", filePurpose=" + String.valueOf(this.zzg) + "}";
    }

    private zzcd(String str, boolean z, boolean z2, zzcc zzccVar, zzce zzceVar, zzcl zzclVar) {
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = null;
        this.zzf = null;
        this.zzg = zzclVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcj)) {
            return false;
        }
        zzcj zzcjVar = (zzcj) obj;
        if (!this.zzb.equals(zzcjVar.zzd()) || this.zzc != zzcjVar.zze() || this.zzd != zzcjVar.zzf()) {
            return false;
        }
        zzcc zzccVar = this.zze;
        if (zzccVar == null) {
            if (zzcjVar.zza() != null) {
                return false;
            }
        } else if (!zzccVar.equals(zzcjVar.zza())) {
            return false;
        }
        zzce zzceVar = this.zzf;
        if (zzceVar == null) {
            if (zzcjVar.zzb() != null) {
                return false;
            }
        } else if (!zzceVar.equals(zzcjVar.zzb())) {
            return false;
        }
        return this.zzg.equals(zzcjVar.zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzcj
    public final boolean zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzcj
    public final boolean zzf() {
        return this.zzd;
    }
}
