package com.google.crypto.tink;

import android.os.Process;
import com.google.crypto.tink.internal.PrimitiveWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ConfigurationV0$1$$ExternalSyntheticLambda9 implements PrimitiveWrapper.PrimitiveFactory {
    public static int onItemLoaded;
    public static int onReceiveResult;

    @Override // com.google.crypto.tink.internal.PrimitiveWrapper.PrimitiveFactory
    public final Object create(KeysetHandleInterface.Entry entry) {
        return ConfigurationV0.access$000(entry);
    }

    public static int IPostMessageServiceStubProxy() {
        int i = onItemLoaded;
        int i2 = i % 5085378;
        onItemLoaded = i + 1;
        if (i2 != 0) {
            return onReceiveResult;
        }
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        onReceiveResult = elapsedCpuTime;
        return elapsedCpuTime;
    }
}
