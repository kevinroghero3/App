package com.salesforce.marketingcloud.sfmcsdk.util;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ApplicationUtilsKt {
    public static final <R> R orElse(@Nullable R r, @NotNull Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return r == null ? block.invoke() : r;
    }
}
