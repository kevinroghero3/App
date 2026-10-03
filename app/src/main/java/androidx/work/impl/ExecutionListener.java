package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.work.impl.model.WorkGenerationalId;

/* JADX INFO: loaded from: classes2.dex */
public interface ExecutionListener {
    void onExecuted(@NonNull WorkGenerationalId workGenerationalId, boolean z);
}
