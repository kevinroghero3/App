package com.salesforce.marketingcloud.push;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull String fieldName) {
        super(f.a.MISSING_FIELD, "Missing required field: " + fieldName);
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }
}
