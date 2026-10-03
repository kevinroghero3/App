package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ViewCatalogDetailEvent extends CatalogEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewCatalogDetailEvent(@NotNull CatalogObject catalogObject) {
        super("View Catalog Object Detail", catalogObject, null);
        Intrinsics.checkNotNullParameter(catalogObject, "catalogObject");
    }
}
