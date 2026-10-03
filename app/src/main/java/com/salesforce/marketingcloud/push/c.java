package com.salesforce.marketingcloud.push;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class c extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String message) {
        super(f.a.INVALID_COMPRESSION, "Invalid compression: " + message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
