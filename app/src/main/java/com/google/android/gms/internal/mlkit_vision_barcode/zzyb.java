package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzyb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyb> CREATOR = new zzyc();
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final byte[] zzd;
    private final Point[] zze;
    private final int zzf;
    private final zzxu zzg;
    private final zzxx zzh;
    private final zzxy zzi;
    private final zzya zzj;
    private final zzxz zzk;
    private final zzxv zzl;
    private final zzxr zzm;
    private final zzxs zzn;
    private final zzxt zzo;

    public zzyb(@SafeParcelable.Param(id = 1) int i, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) byte[] bArr, @Nullable @SafeParcelable.Param(id = 5) Point[] pointArr, @SafeParcelable.Param(id = 6) int i2, @Nullable @SafeParcelable.Param(id = 7) zzxu zzxuVar, @Nullable @SafeParcelable.Param(id = 8) zzxx zzxxVar, @Nullable @SafeParcelable.Param(id = 9) zzxy zzxyVar, @Nullable @SafeParcelable.Param(id = 10) zzya zzyaVar, @Nullable @SafeParcelable.Param(id = 11) zzxz zzxzVar, @Nullable @SafeParcelable.Param(id = 12) zzxv zzxvVar, @Nullable @SafeParcelable.Param(id = 13) zzxr zzxrVar, @Nullable @SafeParcelable.Param(id = 14) zzxs zzxsVar, @Nullable @SafeParcelable.Param(id = 15) zzxt zzxtVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzxuVar;
        this.zzh = zzxxVar;
        this.zzi = zzxyVar;
        this.zzj = zzyaVar;
        this.zzk = zzxzVar;
        this.zzl = zzxvVar;
        this.zzm = zzxrVar;
        this.zzn = zzxsVar;
        this.zzo = zzxtVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzo, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzf;
    }

    public final zzxr zzc() {
        return this.zzm;
    }

    public final zzxs zzd() {
        return this.zzn;
    }

    public final zzxt zze() {
        return this.zzo;
    }

    public final zzxu zzf() {
        return this.zzg;
    }

    public final zzxv zzg() {
        return this.zzl;
    }

    public final zzxx zzh() {
        return this.zzh;
    }

    public final zzxy zzi() {
        return this.zzi;
    }

    public final zzxz zzj() {
        return this.zzk;
    }

    public final zzya zzk() {
        return this.zzj;
    }

    public final String zzl() {
        return this.zzb;
    }

    public final String zzm() {
        return this.zzc;
    }

    public final byte[] zzn() {
        return this.zzd;
    }

    public final Point[] zzo() {
        return this.zze;
    }
}
