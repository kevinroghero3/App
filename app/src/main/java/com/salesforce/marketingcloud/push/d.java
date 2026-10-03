package com.salesforce.marketingcloud.push;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull String message) {
        super(f.a.INVALID_JSON, "Invalid json: " + message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
