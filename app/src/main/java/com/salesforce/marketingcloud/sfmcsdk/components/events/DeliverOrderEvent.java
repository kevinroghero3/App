package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class DeliverOrderEvent extends OrderEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeliverOrderEvent(@NotNull Order order) {
        super("Deliver", order, null);
        Intrinsics.checkNotNullParameter(order, "order");
    }
}
