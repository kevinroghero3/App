package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DataHolderNotifier<L> implements ListenerHolder.Notifier<L> {
    private final DataHolder zaa;

    protected DataHolderNotifier(@NonNull DataHolder dataHolder) {
        this.zaa = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(@NonNull L l) {
        notifyListener(l, this.zaa);
    }

    protected abstract void notifyListener(@NonNull L l, @NonNull DataHolder dataHolder);

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public void onNotifyListenerFailed() {
        DataHolder dataHolder = this.zaa;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
