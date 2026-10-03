package com.google.mlkit.common.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzq;
import com.google.android.gms.internal.mlkit_common.zzr;

/* JADX INFO: loaded from: classes5.dex */
public class LocalModel {
    private final String zza;
    private final String zzb;
    private final Uri zzc;
    private final boolean zzd;

    public static class Builder {
        private String zza = null;
        private String zzb = null;
        private Uri zzc = null;
        private boolean zzd = false;

        public LocalModel build() {
            String str = this.zza;
            Preconditions.checkArgument((str != null && this.zzb == null && this.zzc == null) || (str == null && this.zzb != null && this.zzc == null) || (str == null && this.zzb == null && this.zzc != null), "Set one of filePath, assetFilePath and URI.");
            return new LocalModel(this.zza, this.zzb, this.zzc, this.zzd, null);
        }

        public Builder setAbsoluteFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            Preconditions.checkArgument(this.zzb == null && this.zzc == null && !this.zzd, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.zza = str;
            return this;
        }

        public Builder setAbsoluteManifestFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Manifest file path can not be empty");
            Preconditions.checkArgument(this.zzb == null && this.zzc == null && (this.zza == null || this.zzd), "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.zza = str;
            this.zzd = true;
            return this;
        }

        public Builder setAssetFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            Preconditions.checkArgument(this.zza == null && this.zzc == null && !this.zzd, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.zzb = str;
            return this;
        }

        public Builder setAssetManifestFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Manifest file path can not be empty");
            Preconditions.checkArgument(this.zza == null && this.zzc == null && (this.zzb == null || this.zzd), "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.zzb = str;
            this.zzd = true;
            return this;
        }

        public Builder setUri(@NonNull Uri uri) {
            Preconditions.checkArgument(this.zza == null && this.zzb == null, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.zzc = uri;
            return this;
        }
    }

    /* synthetic */ LocalModel(String str, String str2, Uri uri, boolean z, zzc zzcVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = uri;
        this.zzd = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalModel)) {
            return false;
        }
        LocalModel localModel = (LocalModel) obj;
        return Objects.equal(this.zza, localModel.zza) && Objects.equal(this.zzb, localModel.zzb) && Objects.equal(this.zzc, localModel.zzc) && this.zzd == localModel.zzd;
    }

    public String getAbsoluteFilePath() {
        return this.zza;
    }

    public String getAssetFilePath() {
        return this.zzb;
    }

    public Uri getUri() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Boolean.valueOf(this.zzd));
    }

    public boolean isManifestFile() {
        return this.zzd;
    }

    public String toString() {
        zzq zzqVarZza = zzr.zza(this);
        zzqVarZza.zza("absoluteFilePath", this.zza);
        zzqVarZza.zza("assetFilePath", this.zzb);
        zzqVarZza.zza("uri", this.zzc);
        zzqVarZza.zzb("isManifestFile", this.zzd);
        return zzqVarZza.toString();
    }
}
