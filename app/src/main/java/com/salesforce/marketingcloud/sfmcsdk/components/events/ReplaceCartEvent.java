package com.salesforce.marketingcloud.sfmcsdk.components.events;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ReplaceCartEvent extends CartEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplaceCartEvent(@NotNull List<LineItem> lineItems) {
        super("Replace Cart", lineItems, null);
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
    }
}
