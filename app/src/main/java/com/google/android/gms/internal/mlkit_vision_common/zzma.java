package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: loaded from: classes2.dex */
final class zzma extends zzme {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* synthetic */ zzma(String str, boolean z, int i, zzlz zzlzVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzme)) {
            return false;
        }
        zzme zzmeVar = (zzme) obj;
        return this.zza.equals(zzmeVar.zzb()) && this.zzb == zzmeVar.zzc() && this.zzc == zzmeVar.zza();
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.zza + ", enableFirelog=" + this.zzb + ", firelogEventType=" + this.zzc + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzme
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzme
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzme
    public final boolean zzc() {
        return this.zzb;
    }
}
