package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class PurchaseOrderEvent extends OrderEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchaseOrderEvent(@NotNull Order order) {
        super("Purchase", order, null);
        Intrinsics.checkNotNullParameter(order, "order");
    }
}
