package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: loaded from: classes4.dex */
final class zzas implements zzcs {
    private ListenerHolder zza;

    zzas(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final ListenerHolder zza() {
        ListenerHolder listenerHolder;
        synchronized (this) {
            listenerHolder = this.zza;
        }
        return listenerHolder;
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.location.zzcs
    public final void zzc(ListenerHolder listenerHolder) {
        synchronized (this) {
            ListenerHolder listenerHolder2 = this.zza;
            if (listenerHolder2 != listenerHolder) {
                listenerHolder2.clear();
                this.zza = listenerHolder;
            }
        }
    }
}
