package com.salesforce.marketingcloud.sfmcsdk.components.events;

import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CartEvent extends EngagementEvent {
    public static final Companion Companion = new Companion(null);
    private final List<LineItem> lineItems;

    public /* synthetic */ CartEvent(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list);
    }

    @JvmStatic
    public static final AddToCartEvent add(@NotNull LineItem lineItem) {
        return Companion.add(lineItem);
    }

    @JvmStatic
    public static final RemoveFromCartEvent remove(@NotNull LineItem lineItem) {
        return Companion.remove(lineItem);
    }

    @JvmStatic
    public static final ReplaceCartEvent replace(@NotNull List<LineItem> list) {
        return Companion.replace(list);
    }

    public final List<LineItem> getLineItems() {
        return this.lineItems;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddToCartEvent add(@NotNull LineItem lineItem) {
            Intrinsics.checkNotNullParameter(lineItem, "lineItem");
            try {
                return new AddToCartEvent(lineItem);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final RemoveFromCartEvent remove(@NotNull LineItem lineItem) {
            Intrinsics.checkNotNullParameter(lineItem, "lineItem");
            try {
                return new RemoveFromCartEvent(lineItem);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final ReplaceCartEvent replace(@NotNull List<LineItem> lineItems) {
            Intrinsics.checkNotNullParameter(lineItems, "lineItems");
            try {
                return new ReplaceCartEvent(lineItems);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private CartEvent(String str, List<LineItem> list) {
        super(str, null);
        this.lineItems = list;
    }
}
