package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface RemoteModelLoaderHelper {
    MappedByteBuffer loadModelAtPath(@NonNull String str) throws MlKitException;
}
