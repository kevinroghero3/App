package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public final class zzdl extends zzbu implements zzdj {
    @Override // com.google.android.gms.internal.measurement.zzdj
    public final int zza() throws RemoteException {
        Parcel parcelZza = zza(2, a_());
        int i = parcelZza.readInt();
        parcelZza.recycle();
        return i;
    }

    zzdl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzdj
    public final void zza(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeString(str);
        parcelA_.writeString(str2);
        zzbw.zza(parcelA_, bundle);
        parcelA_.writeLong(j);
        zzb(1, parcelA_);
    }
}
