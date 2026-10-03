package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredential> CREATOR = new zzal();
    private final String zza;
    private final String zzb;
    private final byte[] zzc;
    private final AuthenticatorAttestationResponse zzd;
    private final AuthenticatorAssertionResponse zze;
    private final AuthenticatorErrorResponse zzf;
    private final AuthenticationExtensionsClientOutputs zzg;
    private final String zzh;

    public static class Builder {
        private String zza;
        private byte[] zzb;
        private AuthenticatorResponse zzc;
        private AuthenticationExtensionsClientOutputs zzd;
        private String zze;

        public PublicKeyCredential build() {
            AuthenticatorResponse authenticatorResponse = this.zzc;
            return new PublicKeyCredential(this.zza, PublicKeyCredentialType.PUBLIC_KEY.toString(), this.zzb, authenticatorResponse instanceof AuthenticatorAttestationResponse ? (AuthenticatorAttestationResponse) authenticatorResponse : null, authenticatorResponse instanceof AuthenticatorAssertionResponse ? (AuthenticatorAssertionResponse) authenticatorResponse : null, authenticatorResponse instanceof AuthenticatorErrorResponse ? (AuthenticatorErrorResponse) authenticatorResponse : null, this.zzd, this.zze);
        }

        public Builder setAuthenticationExtensionsClientOutputs(@Nullable AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs) {
            this.zzd = authenticationExtensionsClientOutputs;
            return this;
        }

        public Builder setAuthenticatorAttachment(@NonNull String str) {
            this.zze = str;
            return this;
        }

        public Builder setId(@NonNull String str) {
            this.zza = str;
            return this;
        }

        public Builder setRawId(@NonNull byte[] bArr) {
            this.zzb = bArr;
            return this;
        }

        public Builder setResponse(@NonNull AuthenticatorResponse authenticatorResponse) {
            this.zzc = authenticatorResponse;
            return this;
        }
    }

    PublicKeyCredential(@NonNull @SafeParcelable.Param(id = 1) String str, @NonNull @SafeParcelable.Param(id = 2) String str2, @NonNull @SafeParcelable.Param(id = 3) byte[] bArr, @Nullable @SafeParcelable.Param(id = 4) AuthenticatorAttestationResponse authenticatorAttestationResponse, @Nullable @SafeParcelable.Param(id = 5) AuthenticatorAssertionResponse authenticatorAssertionResponse, @Nullable @SafeParcelable.Param(id = 6) AuthenticatorErrorResponse authenticatorErrorResponse, @Nullable @SafeParcelable.Param(id = 7) AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs, @Nullable @SafeParcelable.Param(id = 8) String str3) {
        Preconditions.checkArgument((authenticatorAttestationResponse != null && authenticatorAssertionResponse == null && authenticatorErrorResponse == null) || (authenticatorAttestationResponse == null && authenticatorAssertionResponse != null && authenticatorErrorResponse == null) || (authenticatorAttestationResponse == null && authenticatorAssertionResponse == null && authenticatorErrorResponse != null));
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = authenticatorAttestationResponse;
        this.zze = authenticatorAssertionResponse;
        this.zzf = authenticatorErrorResponse;
        this.zzg = authenticationExtensionsClientOutputs;
        this.zzh = str3;
    }

    public static PublicKeyCredential deserializeFromBytes(@NonNull byte[] bArr) {
        return (PublicKeyCredential) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PublicKeyCredential)) {
            return false;
        }
        PublicKeyCredential publicKeyCredential = (PublicKeyCredential) obj;
        return Objects.equal(this.zza, publicKeyCredential.zza) && Objects.equal(this.zzb, publicKeyCredential.zzb) && Arrays.equals(this.zzc, publicKeyCredential.zzc) && Objects.equal(this.zzd, publicKeyCredential.zzd) && Objects.equal(this.zze, publicKeyCredential.zze) && Objects.equal(this.zzf, publicKeyCredential.zzf) && Objects.equal(this.zzg, publicKeyCredential.zzg) && Objects.equal(this.zzh, publicKeyCredential.zzh);
    }

    public String getAuthenticatorAttachment() {
        return this.zzh;
    }

    public AuthenticationExtensionsClientOutputs getClientExtensionResults() {
        return this.zzg;
    }

    public String getId() {
        return this.zza;
    }

    public byte[] getRawId() {
        return this.zzc;
    }

    public AuthenticatorResponse getResponse() {
        AuthenticatorAttestationResponse authenticatorAttestationResponse = this.zzd;
        if (authenticatorAttestationResponse != null) {
            return authenticatorAttestationResponse;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = this.zze;
        if (authenticatorAssertionResponse != null) {
            return authenticatorAssertionResponse;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = this.zzf;
        if (authenticatorErrorResponse != null) {
            return authenticatorErrorResponse;
        }
        throw new IllegalStateException("No response set.");
    }

    public String getType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zze, this.zzd, this.zzf, this.zzg, this.zzh);
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getRawId(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, getClientExtensionResults(), i, false);
        SafeParcelWriter.writeString(parcel, 8, getAuthenticatorAttachment(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
