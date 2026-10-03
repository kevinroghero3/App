package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: loaded from: classes4.dex */
final class zzcy implements ListenerHolder.Notifier {
    final /* synthetic */ zzcz zza;

    zzcy(zzcz zzczVar) {
        this.zza = zzczVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        this.zza.zza.zzb();
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
