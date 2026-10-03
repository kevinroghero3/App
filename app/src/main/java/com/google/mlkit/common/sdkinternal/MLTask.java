package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTaskInput;

/* JADX INFO: loaded from: classes.dex */
public abstract class MLTask<T, S extends MLTaskInput> extends ModelResource {
    public MLTask() {
    }

    public abstract T run(@NonNull S s) throws MlKitException;

    protected MLTask(@NonNull TaskQueue taskQueue) {
        super(taskQueue);
    }
}
