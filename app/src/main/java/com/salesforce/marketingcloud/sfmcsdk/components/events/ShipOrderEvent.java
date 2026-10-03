package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ShipOrderEvent extends OrderEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShipOrderEvent(@NotNull Order order) {
        super("Ship", order, null);
        Intrinsics.checkNotNullParameter(order, "order");
    }
}
