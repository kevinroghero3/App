package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zzft extends com.google.android.gms.internal.measurement.zzbx implements zzfq {
    public zzft() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzbf zzbfVar = (zzbf) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbf.CREATOR);
                zzn zznVar = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzbfVar, zznVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zznv zznvVar = (zznv) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zznv.CREATOR);
                zzn zznVar2 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zznvVar, zznVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            default:
                return false;
            case 4:
                zzn zznVar3 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzc(zznVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbf zzbfVar2 = (zzbf) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbf.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzbfVar2, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzn zznVar4 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzg(zznVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzn zznVar5 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                boolean zZzc = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zznv> listZza = zza(zznVar5, zZzc);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza);
                return true;
            case 9:
                zzbf zzbfVar3 = (zzbf) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbf.CREATOR);
                String string3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                byte[] bArrZza = zza(zzbfVar3, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrZza);
                return true;
            case 10:
                long j = parcel.readLong();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(j, string4, string5, string6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzn zznVar6 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                String strZzb = zzb(zznVar6);
                parcel2.writeNoException();
                parcel2.writeString(strZzb);
                return true;
            case 12:
                zzac zzacVar = (zzac) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzac.CREATOR);
                zzn zznVar7 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzacVar, zznVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzac zzacVar2 = (zzac) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzac.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzacVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zZzc2 = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                zzn zznVar8 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zznv> listZza2 = zza(string7, string8, zZzc2, zznVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza2);
                return true;
            case 15:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zZzc3 = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zznv> listZza3 = zza(string9, string10, string11, zZzc3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza3);
                return true;
            case 16:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzn zznVar9 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzac> listZza4 = zza(string12, string13, zznVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza4);
                return true;
            case 17:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzac> listZza5 = zza(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza5);
                return true;
            case 18:
                zzn zznVar10 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzd(zznVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                zzn zznVar11 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(bundle, zznVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzn zznVar12 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zze(zznVar12);
                parcel2.writeNoException();
                return true;
            case 21:
                zzn zznVar13 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzal zzalVarZza = zza(zznVar13);
                parcel2.writeNoException();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel2, zzalVarZza);
                return true;
            case 24:
                zzn zznVar14 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzmy> listZza6 = zza(zznVar14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza6);
                return true;
            case 25:
                zzn zznVar15 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzh(zznVar15);
                parcel2.writeNoException();
                return true;
            case 26:
                zzn zznVar16 = (zzn) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzf(zznVar16);
                parcel2.writeNoException();
                return true;
        }
    }
}
