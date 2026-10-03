package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public interface RemoteModelManagerInterface<RemoteT extends RemoteModel> {
    Task<Void> deleteDownloadedModel(@NonNull RemoteT remotet);

    Task<Void> download(@NonNull RemoteT remotet, @NonNull DownloadConditions downloadConditions);

    Task<Set<RemoteT>> getDownloadedModels();

    Task<Boolean> isModelDownloaded(@NonNull RemoteT remotet);
}
