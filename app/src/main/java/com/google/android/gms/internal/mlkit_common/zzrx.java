package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: loaded from: classes4.dex */
final class zzrx extends zzsj {
    private final zzmu zza;
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final ModelType zze;
    private final zzna zzf;
    private final int zzg;

    /* synthetic */ zzrx(zzmu zzmuVar, String str, boolean z, boolean z2, ModelType modelType, zzna zznaVar, int i, zzrw zzrwVar) {
        this.zza = zzmuVar;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = modelType;
        this.zzf = zznaVar;
        this.zzg = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsj)) {
            return false;
        }
        zzsj zzsjVar = (zzsj) obj;
        return this.zza.equals(zzsjVar.zzc()) && this.zzb.equals(zzsjVar.zze()) && this.zzc == zzsjVar.zzg() && this.zzd == zzsjVar.zzf() && this.zze.equals(zzsjVar.zzb()) && this.zzf.equals(zzsjVar.zzd()) && this.zzg == zzsjVar.zza();
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode();
        int iHashCode2 = this.zzb.hashCode();
        int i = true != this.zzc ? 1237 : 1231;
        return ((((((((((((iHashCode ^ 1000003) * 1000003) ^ iHashCode2) * 1000003) ^ i) * 1000003) ^ (true == this.zzd ? 1231 : 1237)) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf.hashCode()) * 1000003) ^ this.zzg;
    }

    public final String toString() {
        zzna zznaVar = this.zzf;
        ModelType modelType = this.zze;
        return "RemoteModelLoggingOptions{errorCode=" + this.zza.toString() + ", tfliteSchemaVersion=" + this.zzb + ", shouldLogRoughDownloadTime=" + this.zzc + ", shouldLogExactDownloadTime=" + this.zzd + ", modelType=" + modelType.toString() + ", downloadStatus=" + zznaVar.toString() + ", failureStatusCode=" + this.zzg + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsj
    public final int zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsj
    public final ModelType zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsj
    public final zzmu zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsj
    public final zzna zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsj
    public final String zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsj
    public final boolean zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsj
    public final boolean zzg() {
        return this.zzc;
    }
}
