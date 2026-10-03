package com.salesforce.marketingcloud.push;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class l extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull Throwable cause) {
        super(f.a.UNKNOWN_ERROR, "Unknown error occurred: " + cause.getMessage());
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
