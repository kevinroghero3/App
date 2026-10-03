package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    private final int zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;
    private final int zze;
    private final String zzf;
    private final zzd zzg;
    private final List zzh;

    static {
        Process.myUid();
        Process.myPid();
    }

    zzd(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str, @Nullable @SafeParcelable.Param(id = 4) String str2, @Nullable @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 8) List list, @Nullable @SafeParcelable.Param(id = 7) zzd zzdVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = str3;
        this.zze = i3;
        this.zzh = zzds.zzj(list);
        this.zzg = zzdVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzd)) {
            return false;
        }
        zzd zzdVar = (zzd) obj;
        return this.zza == zzdVar.zza && this.zzb == zzdVar.zzb && this.zze == zzdVar.zze && this.zzc.equals(zzdVar.zzc) && zzdl.zza(this.zzd, zzdVar.zzd) && zzdl.zza(this.zzf, zzdVar.zzf) && zzdl.zza(this.zzg, zzdVar.zzg) && this.zzh.equals(zzdVar.zzh);
    }

    public final int hashCode() {
        int i = this.zza;
        return Arrays.hashCode(new Object[]{Integer.valueOf(i), this.zzc, this.zzd, this.zzf});
    }

    public final String toString() {
        int length = this.zzc.length() + 18;
        String str = this.zzd;
        if (str != null) {
            length += str.length();
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append(this.zza);
        sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb.append(this.zzc);
        if (this.zzd != null) {
            sb.append("[");
            if (this.zzd.startsWith(this.zzc)) {
                sb.append((CharSequence) this.zzd, this.zzc.length(), this.zzd.length());
            } else {
                sb.append(this.zzd);
            }
            sb.append("]");
        }
        if (this.zzf != null) {
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(Integer.toHexString(this.zzf.hashCode()));
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeTypedList(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
