package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelInfo;

/* JADX INFO: loaded from: classes5.dex */
public interface ModelInfoRetrieverInterop {
    ModelInfo retrieveRemoteModelInfo(@NonNull RemoteModel remoteModel) throws MlKitException;
}
