package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class QuickViewCatalogEvent extends CatalogEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickViewCatalogEvent(@NotNull CatalogObject catalogObject) {
        super("Quick View Catalog Object", catalogObject, null);
        Intrinsics.checkNotNullParameter(catalogObject, "catalogObject");
    }
}
