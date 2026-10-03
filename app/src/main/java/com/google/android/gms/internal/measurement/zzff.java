package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes4.dex */
final class zzff extends zzds.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzds.zzc zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzff(zzds.zzc zzcVar, Activity activity) {
        super(zzds.this);
        this.zzc = activity;
        this.zzd = zzcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(zzds.this.zzj)).onActivityDestroyed(ObjectWrapper.wrap(this.zzc), this.zzb);
    }
}
