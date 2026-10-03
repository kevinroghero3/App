package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class AddToCartEvent extends CartEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddToCartEvent(@NotNull LineItem lineItem) {
        super("Add To Cart", CollectionsKt__CollectionsJVMKt.listOf(lineItem), null);
        Intrinsics.checkNotNullParameter(lineItem, "lineItem");
    }
}
