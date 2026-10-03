package com.google.android.odml.image;

/* JADX INFO: loaded from: classes5.dex */
final class zzc extends ImageProperties {
    private final int zza;
    private final int zzb;

    /* synthetic */ zzc(int i, int i2, zza zzaVar) {
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageProperties)) {
            return false;
        }
        ImageProperties imageProperties = (ImageProperties) obj;
        return this.zza == imageProperties.getImageFormat() && this.zzb == imageProperties.getStorageType();
    }

    @Override // com.google.android.odml.image.ImageProperties
    public final int getImageFormat() {
        return this.zza;
    }

    @Override // com.google.android.odml.image.ImageProperties
    public final int getStorageType() {
        return this.zzb;
    }

    public final int hashCode() {
        return ((this.zza ^ 1000003) * 1000003) ^ this.zzb;
    }

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        StringBuilder sb = new StringBuilder(65);
        sb.append("ImageProperties{imageFormat=");
        sb.append(i);
        sb.append(", storageType=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
