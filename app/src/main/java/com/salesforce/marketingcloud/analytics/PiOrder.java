package com.salesforce.marketingcloud.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class PiOrder implements Parcelable {
    public final PiCart cart;
    public final double discount;
    public final String orderNumber;
    public final double shipping;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<PiOrder> CREATOR = new b();

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiOrder(cart, orderNumber, shipping, discount)", imports = {}))
        @JvmStatic
        public final PiOrder a(@NotNull PiCart cart, @NotNull String orderNumber, double d, double d2) {
            Intrinsics.checkNotNullParameter(cart, "cart");
            Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
            return new PiOrder(cart, orderNumber, d, d2);
        }

        private a() {
        }
    }

    public static final class b implements Parcelable.Creator<PiOrder> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PiOrder createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PiOrder(PiCart.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readDouble(), parcel.readDouble());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PiOrder[] newArray(int i) {
            return new PiOrder[i];
        }
    }

    public PiOrder(@NotNull PiCart cart, @NotNull String orderNumber, double d, double d2) {
        Intrinsics.checkNotNullParameter(cart, "cart");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        this.cart = cart;
        this.orderNumber = orderNumber;
        this.shipping = d;
        this.discount = d2;
    }

    public static /* synthetic */ PiOrder copy$default(PiOrder piOrder, PiCart piCart, String str, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            piCart = piOrder.cart;
        }
        if ((i & 2) != 0) {
            str = piOrder.orderNumber;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            d = piOrder.shipping;
        }
        double d3 = d;
        if ((i & 8) != 0) {
            d2 = piOrder.discount;
        }
        return piOrder.copy(piCart, str2, d3, d2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiOrder(cart, orderNumber, shipping, discount)", imports = {}))
    @JvmStatic
    public static final PiOrder create(@NotNull PiCart piCart, @NotNull String str, double d, double d2) {
        return Companion.a(piCart, str, d, d2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cart", imports = {}))
    public final PiCart cart() {
        return this.cart;
    }

    public final PiCart component1() {
        return this.cart;
    }

    public final String component2() {
        return this.orderNumber;
    }

    public final double component3() {
        return this.shipping;
    }

    public final double component4() {
        return this.discount;
    }

    public final PiOrder copy(@NotNull PiCart cart, @NotNull String orderNumber, double d, double d2) {
        Intrinsics.checkNotNullParameter(cart, "cart");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        return new PiOrder(cart, orderNumber, d, d2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.DISCOUNT, imports = {}))
    public final double discount() {
        return this.discount;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PiOrder)) {
            return false;
        }
        PiOrder piOrder = (PiOrder) obj;
        return Intrinsics.areEqual(this.cart, piOrder.cart) && Intrinsics.areEqual(this.orderNumber, piOrder.orderNumber) && Double.compare(this.shipping, piOrder.shipping) == 0 && Double.compare(this.discount, piOrder.discount) == 0;
    }

    public int hashCode() {
        return (((((this.cart.hashCode() * 31) + this.orderNumber.hashCode()) * 31) + Double.hashCode(this.shipping)) * 31) + Double.hashCode(this.discount);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "orderNumber", imports = {}))
    public final String orderNumber() {
        return this.orderNumber;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.SHIPPING, imports = {}))
    public final double shipping() {
        return this.shipping;
    }

    public final JSONObject toJson$sdk_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cart", this.cart.toJson$sdk_release());
        jSONObject.put("order_number", this.orderNumber);
        jSONObject.put(FirebaseAnalytics.Param.SHIPPING, this.shipping);
        jSONObject.put(FirebaseAnalytics.Param.DISCOUNT, this.discount);
        return jSONObject;
    }

    public String toString() {
        return "PiOrder(cart=" + this.cart + ", orderNumber=" + this.orderNumber + ", shipping=" + this.shipping + ", discount=" + this.discount + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.cart.writeToParcel(out, i);
        out.writeString(this.orderNumber);
        out.writeDouble(this.shipping);
        out.writeDouble(this.discount);
    }
}
