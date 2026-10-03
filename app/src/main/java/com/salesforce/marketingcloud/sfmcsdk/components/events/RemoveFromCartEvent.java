package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class RemoveFromCartEvent extends CartEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoveFromCartEvent(@NotNull LineItem lineItem) {
        super("Remove From Cart", CollectionsKt__CollectionsJVMKt.listOf(lineItem), null);
        Intrinsics.checkNotNullParameter(lineItem, "lineItem");
    }
}
