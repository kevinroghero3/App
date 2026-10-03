package com.salesforce.marketingcloud.sfmcsdk.components.utils;

import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SdkExecutorsKt {
    public static final void namedRunnable(@NotNull ExecutorService executorService, @NotNull String name, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(executorService, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        executorService.execute(new NamedRunnable(name, new Object[0]) { // from class: com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutorsKt.namedRunnable.1
            @Override // com.salesforce.marketingcloud.sfmcsdk.components.utils.NamedRunnable
            protected void execute() {
                block.invoke();
            }
        });
    }
}
