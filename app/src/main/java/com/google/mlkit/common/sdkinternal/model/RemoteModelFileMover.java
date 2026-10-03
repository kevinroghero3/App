package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.mlkit.common.MlKitException;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public interface RemoteModelFileMover {
    File getModelFileDestination() throws MlKitException;

    File moveAllFilesFromPrivateTempToPrivateDestination(@NonNull File file) throws MlKitException;
}
