package com.google.firebase.perf.v1;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes3.dex */
public interface AndroidMemoryReadingOrBuilder extends MessageLiteOrBuilder {
    long getClientTimeUs();

    int getUsedAppJavaHeapMemoryKb();

    boolean hasClientTimeUs();

    boolean hasUsedAppJavaHeapMemoryKb();
}
