package com.google.mlkit.common.internal.model;

/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_ModelUtils_AutoMLManifest extends ModelUtils.AutoMLManifest {
    private final String zza;
    private final String zzb;
    private final String zzc;

    AutoValue_ModelUtils_AutoMLManifest(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null modelType");
        }
        this.zza = str;
        if (str2 == null) {
            throw new NullPointerException("Null modelFile");
        }
        this.zzb = str2;
        if (str3 == null) {
            throw new NullPointerException("Null labelsFile");
        }
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelUtils.AutoMLManifest)) {
            return false;
        }
        ModelUtils.AutoMLManifest autoMLManifest = (ModelUtils.AutoMLManifest) obj;
        return this.zza.equals(autoMLManifest.getModelType()) && this.zzb.equals(autoMLManifest.getModelFile()) && this.zzc.equals(autoMLManifest.getLabelsFile());
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    public String getLabelsFile() {
        return this.zzc;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    public String getModelFile() {
        return this.zzb;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    public String getModelType() {
        return this.zza;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode();
        return ((((iHashCode ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode();
    }

    public final String toString() {
        return "AutoMLManifest{modelType=" + this.zza + ", modelFile=" + this.zzb + ", labelsFile=" + this.zzc + "}";
    }
}
