package com.facebook.hermes.instrumentation;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface HermesMemoryDumper {
    String getId();

    String getInternalStorage();

    void setMetaData(@NotNull String str);

    boolean shouldSaveSnapshot();
}
