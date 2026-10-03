package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: loaded from: classes2.dex */
final class zzxg extends zzxn {
    private final float zza;
    private final float zzb;
    private final float zzc;
    private final float zzd;

    zzxg(float f, float f2, float f3, float f4, float f5) {
        this.zza = f;
        this.zzb = f2;
        this.zzc = f3;
        this.zzd = f4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzxn)) {
            return false;
        }
        zzxn zzxnVar = (zzxn) obj;
        if (Float.floatToIntBits(this.zza) != Float.floatToIntBits(zzxnVar.zzc()) || Float.floatToIntBits(this.zzb) != Float.floatToIntBits(zzxnVar.zze()) || Float.floatToIntBits(this.zzc) != Float.floatToIntBits(zzxnVar.zzb()) || Float.floatToIntBits(this.zzd) != Float.floatToIntBits(zzxnVar.zzd())) {
            return false;
        }
        int iFloatToIntBits = Float.floatToIntBits(0.0f);
        zzxnVar.zza();
        return iFloatToIntBits == Float.floatToIntBits(0.0f);
    }

    public final int hashCode() {
        int iFloatToIntBits = Float.floatToIntBits(this.zza);
        int iFloatToIntBits2 = Float.floatToIntBits(this.zzb);
        return ((((((((iFloatToIntBits ^ 1000003) * 1000003) ^ iFloatToIntBits2) * 1000003) ^ Float.floatToIntBits(this.zzc)) * 1000003) ^ Float.floatToIntBits(this.zzd)) * 1000003) ^ Float.floatToIntBits(0.0f);
    }

    public final String toString() {
        return "PredictedArea{xMin=" + this.zza + ", yMin=" + this.zzb + ", xMax=" + this.zzc + ", yMax=" + this.zzd + ", confidenceScore=0.0}";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxn
    final float zza() {
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxn
    final float zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxn
    final float zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxn
    final float zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzxn
    final float zze() {
        return this.zzb;
    }
}
