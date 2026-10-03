package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ExchangeOrderEvent extends OrderEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExchangeOrderEvent(@NotNull Order order) {
        super("Exchange", order, null);
        Intrinsics.checkNotNullParameter(order, "order");
    }
}
