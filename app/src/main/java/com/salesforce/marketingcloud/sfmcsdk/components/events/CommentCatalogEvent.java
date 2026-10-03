package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CommentCatalogEvent extends CatalogEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentCatalogEvent(@NotNull CatalogObject catalogObject) {
        super("Comment Catalog Object", catalogObject, null);
        Intrinsics.checkNotNullParameter(catalogObject, "catalogObject");
    }
}
