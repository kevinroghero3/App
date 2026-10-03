package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
final class zzbo implements RemoteCall, zzcs {
    final /* synthetic */ zzbp zza;
    private final zzbn zzb;
    private ListenerHolder zzc;
    private boolean zzd = true;

    zzbo(zzbp zzbpVar, ListenerHolder listenerHolder, zzbn zzbnVar) {
        this.zza = zzbpVar;
        this.zzc = listenerHolder;
        this.zzb = zzbnVar;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey;
        boolean z;
        zzda zzdaVar = (zzda) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        synchronized (this) {
            listenerKey = this.zzc.getListenerKey();
            z = this.zzd;
            this.zzc.clear();
        }
        if (listenerKey == null) {
            taskCompletionSource.setResult(Boolean.FALSE);
        } else {
            this.zzb.zza(zzdaVar, listenerKey, z, taskCompletionSource);
        }
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final ListenerHolder zza() {
        ListenerHolder listenerHolder;
        synchronized (this) {
            listenerHolder = this.zzc;
        }
        return listenerHolder;
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final void zzb() {
        ListenerHolder.ListenerKey<?> listenerKey;
        synchronized (this) {
            this.zzd = false;
            listenerKey = this.zzc.getListenerKey();
        }
        if (listenerKey != null) {
            this.zza.doUnregisterEventListener(listenerKey, 2441);
        }
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final void zzc(ListenerHolder listenerHolder) {
        synchronized (this) {
            ListenerHolder listenerHolder2 = this.zzc;
            if (listenerHolder2 != listenerHolder) {
                listenerHolder2.clear();
                this.zzc = listenerHolder;
            }
        }
    }
}
