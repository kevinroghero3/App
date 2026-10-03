package com.salesforce.marketingcloud.sfmcsdk.components.events;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class OrderEvent extends EngagementEvent {
    public static final Companion Companion = new Companion(null);
    private final Order order;

    public /* synthetic */ OrderEvent(String str, Order order, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, order);
    }

    @JvmStatic
    public static final CancelOrderEvent cancel(@NotNull Order order) {
        return Companion.cancel(order);
    }

    @JvmStatic
    public static final DeliverOrderEvent deliver(@NotNull Order order) {
        return Companion.deliver(order);
    }

    @JvmStatic
    public static final ExchangeOrderEvent exchange(@NotNull Order order) {
        return Companion.exchange(order);
    }

    @JvmStatic
    public static final PreorderEvent preorder(@NotNull Order order) {
        return Companion.preorder(order);
    }

    @JvmStatic
    public static final PurchaseOrderEvent purchase(@NotNull Order order) {
        return Companion.purchase(order);
    }

    @JvmStatic
    public static final ReturnOrderEvent returnOrder(@NotNull Order order) {
        return Companion.returnOrder(order);
    }

    @JvmStatic
    public static final ShipOrderEvent ship(@NotNull Order order) {
        return Companion.ship(order);
    }

    public final Order getOrder() {
        return this.order;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PurchaseOrderEvent purchase(@NotNull Order order) {
            Intrinsics.checkNotNullParameter(order, "order");
            try {
                return new PurchaseOrderEvent(order);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final PreorderEvent preorder(@NotNull Order order) {
            Intrinsics.checkNotNullParameter(order, "order");
            try {
                return new PreorderEvent(order);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final CancelOrderEvent cancel(@NotNull Order order) {
            Intrinsics.checkNotNullParameter(order, "order");
            try {
                return new CancelOrderEvent(order);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final ShipOrderEvent ship(@NotNull Order order) {
            Intrinsics.checkNotNullParameter(order, "order");
            try {
                return new ShipOrderEvent(order);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final DeliverOrderEvent deliver(@NotNull Order order) {
            Intrinsics.checkNotNullParameter(order, "order");
            try {
                return new DeliverOrderEvent(order);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final ReturnOrderEvent returnOrder(@NotNull Order order) {
            Intrinsics.checkNotNullParameter(order, "order");
            try {
                return new ReturnOrderEvent(order);
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final ExchangeOrderEvent exchange(@NotNull Order order) {
            Intrinsics.checkNotNullParameter(order, "order");
            try {
                return new ExchangeOrderEvent(order);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private OrderEvent(String str, Order order) {
        super(str, null);
        this.order = order;
    }
}
