package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface zzfq extends IInterface {
    zzal zza(zzn zznVar) throws RemoteException;

    List<zzmy> zza(zzn zznVar, Bundle bundle) throws RemoteException;

    List<zznv> zza(zzn zznVar, boolean z) throws RemoteException;

    List<zzac> zza(@Nullable String str, @Nullable String str2, zzn zznVar) throws RemoteException;

    List<zzac> zza(String str, @Nullable String str2, @Nullable String str3) throws RemoteException;

    List<zznv> zza(String str, @Nullable String str2, @Nullable String str3, boolean z) throws RemoteException;

    List<zznv> zza(@Nullable String str, @Nullable String str2, boolean z, zzn zznVar) throws RemoteException;

    void zza(long j, @Nullable String str, @Nullable String str2, String str3) throws RemoteException;

    void zza(Bundle bundle, zzn zznVar) throws RemoteException;

    void zza(zzac zzacVar) throws RemoteException;

    void zza(zzac zzacVar, zzn zznVar) throws RemoteException;

    void zza(zzbf zzbfVar, zzn zznVar) throws RemoteException;

    void zza(zzbf zzbfVar, String str, @Nullable String str2) throws RemoteException;

    void zza(zznv zznvVar, zzn zznVar) throws RemoteException;

    byte[] zza(zzbf zzbfVar, String str) throws RemoteException;

    String zzb(zzn zznVar) throws RemoteException;

    void zzc(zzn zznVar) throws RemoteException;

    void zzd(zzn zznVar) throws RemoteException;

    void zze(zzn zznVar) throws RemoteException;

    void zzf(zzn zznVar) throws RemoteException;

    void zzg(zzn zznVar) throws RemoteException;

    void zzh(zzn zznVar) throws RemoteException;
}
