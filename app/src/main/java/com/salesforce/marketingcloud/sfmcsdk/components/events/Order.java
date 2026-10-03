package com.salesforce.marketingcloud.sfmcsdk.components.events;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class Order {
    private final Map<String, Object> attributes;
    private final String currency;
    private final String id;
    private final List<LineItem> lineItems;
    private final Double totalValue;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Order(@NotNull String id) {
        this(id, null, null, null, null, 30, null);
        Intrinsics.checkNotNullParameter(id, "id");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Order(@NotNull String id, @NotNull List<LineItem> lineItems) {
        this(id, lineItems, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Order(@NotNull String id, @NotNull List<LineItem> lineItems, @Nullable Double d) {
        this(id, lineItems, d, null, null, 24, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Order(@NotNull String id, @NotNull List<LineItem> lineItems, @Nullable Double d, @Nullable String str) {
        this(id, lineItems, d, str, null, 16, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Order copy$default(Order order, String str, List list, Double d, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = order.id;
        }
        if ((i & 2) != 0) {
            list = order.lineItems;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            d = order.totalValue;
        }
        Double d2 = d;
        if ((i & 8) != 0) {
            str2 = order.currency;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            map = order.attributes;
        }
        return order.copy(str, list2, d2, str3, map);
    }

    public final String component1() {
        return this.id;
    }

    public final List<LineItem> component2() {
        return this.lineItems;
    }

    public final Double component3() {
        return this.totalValue;
    }

    public final String component4() {
        return this.currency;
    }

    public final Map<String, Object> component5() {
        return this.attributes;
    }

    public final Order copy(@NotNull String id, @NotNull List<LineItem> lineItems, @Nullable Double d, @Nullable String str, @NotNull Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new Order(id, lineItems, d, str, attributes);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Order)) {
            return false;
        }
        Order order = (Order) obj;
        return Intrinsics.areEqual(this.id, order.id) && Intrinsics.areEqual(this.lineItems, order.lineItems) && Intrinsics.areEqual((Object) this.totalValue, (Object) order.totalValue) && Intrinsics.areEqual(this.currency, order.currency) && Intrinsics.areEqual(this.attributes, order.attributes);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode();
        int iHashCode2 = this.lineItems.hashCode();
        Double d = this.totalValue;
        int iHashCode3 = d == null ? 0 : d.hashCode();
        String str = this.currency;
        return (((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.attributes.hashCode();
    }

    public String toString() {
        return "Order(id=" + this.id + ", lineItems=" + this.lineItems + ", totalValue=" + this.totalValue + ", currency=" + this.currency + ", attributes=" + this.attributes + ")";
    }

    public Order(@NotNull String id, @NotNull List<LineItem> lineItems, @Nullable Double d, @Nullable String str, @NotNull Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.id = id;
        this.lineItems = lineItems;
        this.totalValue = d;
        this.currency = str;
        this.attributes = attributes;
    }

    public final String getId() {
        return this.id;
    }

    public /* synthetic */ Order(String str, List list, Double d, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }

    public final List<LineItem> getLineItems() {
        return this.lineItems;
    }

    public final Double getTotalValue() {
        return this.totalValue;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final Map<String, Object> getAttributes() {
        return this.attributes;
    }
}
