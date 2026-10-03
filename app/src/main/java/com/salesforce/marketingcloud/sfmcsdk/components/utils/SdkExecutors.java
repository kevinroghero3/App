package com.salesforce.marketingcloud.sfmcsdk.components.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SdkExecutors {
    private final ExecutorService diskIO;
    private final ExecutorService networkIO;

    public SdkExecutors() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public SdkExecutors(@NotNull ExecutorService diskIO, @NotNull ExecutorService networkIO) {
        Intrinsics.checkNotNullParameter(diskIO, "diskIO");
        Intrinsics.checkNotNullParameter(networkIO, "networkIO");
        this.diskIO = diskIO;
        this.networkIO = networkIO;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SdkExecutors(ExecutorService executorService, ExecutorService executorService2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            executorService = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executorService, "newSingleThreadExecutor(...)");
        }
        if ((i & 2) != 0) {
            executorService2 = Executors.newFixedThreadPool(2);
            Intrinsics.checkNotNullExpressionValue(executorService2, "newFixedThreadPool(...)");
        }
        this(executorService, executorService2);
    }

    public final ExecutorService getDiskIO() {
        return this.diskIO;
    }

    public final ExecutorService getNetworkIO() {
        return this.networkIO;
    }
}
