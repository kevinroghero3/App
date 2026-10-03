package com.salesforce.marketingcloud.sfmcsdk.components.events;

import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class LineItem {
    private Map<String, ? extends Object> attributes;
    private final String catalogObjectId;
    private final String catalogObjectType;
    private String currency;
    private Double price;
    private final int quantity;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LineItem(@NotNull String catalogObjectType, @NotNull String catalogObjectId, int i) {
        this(catalogObjectType, catalogObjectId, i, null, null, null, 56, null);
        Intrinsics.checkNotNullParameter(catalogObjectType, "catalogObjectType");
        Intrinsics.checkNotNullParameter(catalogObjectId, "catalogObjectId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LineItem(@NotNull String catalogObjectType, @NotNull String catalogObjectId, int i, @Nullable Double d) {
        this(catalogObjectType, catalogObjectId, i, d, null, null, 48, null);
        Intrinsics.checkNotNullParameter(catalogObjectType, "catalogObjectType");
        Intrinsics.checkNotNullParameter(catalogObjectId, "catalogObjectId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LineItem(@NotNull String catalogObjectType, @NotNull String catalogObjectId, int i, @Nullable Double d, @Nullable String str) {
        this(catalogObjectType, catalogObjectId, i, d, str, null, 32, null);
        Intrinsics.checkNotNullParameter(catalogObjectType, "catalogObjectType");
        Intrinsics.checkNotNullParameter(catalogObjectId, "catalogObjectId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LineItem copy$default(LineItem lineItem, String str, String str2, int i, Double d, String str3, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = lineItem.catalogObjectType;
        }
        if ((i2 & 2) != 0) {
            str2 = lineItem.catalogObjectId;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            i = lineItem.quantity;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            d = lineItem.price;
        }
        Double d2 = d;
        if ((i2 & 16) != 0) {
            str3 = lineItem.currency;
        }
        String str5 = str3;
        if ((i2 & 32) != 0) {
            map = lineItem.attributes;
        }
        return lineItem.copy(str, str4, i3, d2, str5, map);
    }

    public final String component1() {
        return this.catalogObjectType;
    }

    public final String component2() {
        return this.catalogObjectId;
    }

    public final int component3() {
        return this.quantity;
    }

    public final Double component4() {
        return this.price;
    }

    public final String component5() {
        return this.currency;
    }

    public final Map<String, Object> component6() {
        return this.attributes;
    }

    public final LineItem copy(@NotNull String catalogObjectType, @NotNull String catalogObjectId, int i, @Nullable Double d, @Nullable String str, @NotNull Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(catalogObjectType, "catalogObjectType");
        Intrinsics.checkNotNullParameter(catalogObjectId, "catalogObjectId");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new LineItem(catalogObjectType, catalogObjectId, i, d, str, attributes);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineItem)) {
            return false;
        }
        LineItem lineItem = (LineItem) obj;
        return Intrinsics.areEqual(this.catalogObjectType, lineItem.catalogObjectType) && Intrinsics.areEqual(this.catalogObjectId, lineItem.catalogObjectId) && this.quantity == lineItem.quantity && Intrinsics.areEqual((Object) this.price, (Object) lineItem.price) && Intrinsics.areEqual(this.currency, lineItem.currency) && Intrinsics.areEqual(this.attributes, lineItem.attributes);
    }

    public int hashCode() {
        int iHashCode = this.catalogObjectType.hashCode();
        int iHashCode2 = this.catalogObjectId.hashCode();
        int iHashCode3 = Integer.hashCode(this.quantity);
        Double d = this.price;
        int iHashCode4 = d == null ? 0 : d.hashCode();
        String str = this.currency;
        return (((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.attributes.hashCode();
    }

    public String toString() {
        return "LineItem(catalogObjectType=" + this.catalogObjectType + ", catalogObjectId=" + this.catalogObjectId + ", quantity=" + this.quantity + ", price=" + this.price + ", currency=" + this.currency + ", attributes=" + this.attributes + ")";
    }

    public LineItem(@NotNull String catalogObjectType, @NotNull String catalogObjectId, int i, @Nullable Double d, @Nullable String str, @NotNull Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(catalogObjectType, "catalogObjectType");
        Intrinsics.checkNotNullParameter(catalogObjectId, "catalogObjectId");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.catalogObjectType = catalogObjectType;
        this.catalogObjectId = catalogObjectId;
        this.quantity = i;
        this.price = d;
        this.currency = str;
        this.attributes = attributes;
    }

    public final String getCatalogObjectType() {
        return this.catalogObjectType;
    }

    public final String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final void setPrice(@Nullable Double d) {
        this.price = d;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(@Nullable String str) {
        this.currency = str;
    }

    public /* synthetic */ LineItem(String str, String str2, int i, Double d, String str3, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i2 & 8) != 0 ? null : d, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }

    public final Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public final void setAttributes(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.attributes = map;
    }
}
