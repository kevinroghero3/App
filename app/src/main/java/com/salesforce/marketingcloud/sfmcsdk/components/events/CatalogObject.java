package com.salesforce.marketingcloud.sfmcsdk.components.events;

import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CatalogObject {
    private final Map<String, Object> attributes;
    private final String id;
    private final Map<String, List<String>> relatedCatalogObjects;
    private final String type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CatalogObject(@NotNull String type, @NotNull String id) {
        this(type, id, null, null, 12, null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CatalogObject(@NotNull String type, @NotNull String id, @NotNull Map<String, ? extends Object> attributes) {
        this(type, id, attributes, null, 8, null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CatalogObject(@NotNull String type, @NotNull String id, @NotNull Map<String, ? extends Object> attributes, @NotNull Map<String, ? extends List<String>> relatedCatalogObjects) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(relatedCatalogObjects, "relatedCatalogObjects");
        this.type = type;
        this.id = id;
        this.attributes = attributes;
        this.relatedCatalogObjects = relatedCatalogObjects;
    }

    public final String getType() {
        return this.type;
    }

    public final String getId() {
        return this.id;
    }

    public /* synthetic */ CatalogObject(String str, String str2, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i & 8) != 0 ? MapsKt__MapsKt.emptyMap() : map2);
    }

    public final Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public final Map<String, List<String>> getRelatedCatalogObjects() {
        return this.relatedCatalogObjects;
    }
}
