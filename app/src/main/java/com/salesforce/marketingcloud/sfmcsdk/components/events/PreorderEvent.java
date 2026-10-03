package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class PreorderEvent extends OrderEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreorderEvent(@NotNull Order order) {
        super("Preorder", order, null);
        Intrinsics.checkNotNullParameter(order, "order");
    }
}
