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
public final class PiCartItem implements Parcelable {
    public final String item;
    public final double price;
    public final int quantity;
    public final String uniqueId;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<PiCartItem> CREATOR = new b();

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCartItem(item, quantity, price)", imports = {}))
        @JvmStatic
        public final PiCartItem a(@NotNull String item, int i, double d) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new PiCartItem(item, i, d);
        }

        private a() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCartItem(item, quantity, price, uniqueId)", imports = {}))
        @JvmStatic
        public final PiCartItem a(@NotNull String item, int i, double d, @Nullable String str) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new PiCartItem(item, i, d, str);
        }
    }

    public static final class b implements Parcelable.Creator<PiCartItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PiCartItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PiCartItem(parcel.readString(), parcel.readInt(), parcel.readDouble(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PiCartItem[] newArray(int i) {
            return new PiCartItem[i];
        }
    }

    public PiCartItem(@NotNull String item, int i, double d, @Nullable String str) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.quantity = i;
        this.price = d;
        this.uniqueId = str;
    }

    public static /* synthetic */ PiCartItem copy$default(PiCartItem piCartItem, String str, int i, double d, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = piCartItem.item;
        }
        if ((i2 & 2) != 0) {
            i = piCartItem.quantity;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            d = piCartItem.price;
        }
        double d2 = d;
        if ((i2 & 8) != 0) {
            str2 = piCartItem.uniqueId;
        }
        return piCartItem.copy(str, i3, d2, str2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCartItem(item, quantity, price)", imports = {}))
    @JvmStatic
    public static final PiCartItem create(@NotNull String str, int i, double d) {
        return Companion.a(str, i, d);
    }

    public final String component1() {
        return this.item;
    }

    public final int component2() {
        return this.quantity;
    }

    public final double component3() {
        return this.price;
    }

    public final String component4() {
        return this.uniqueId;
    }

    public final PiCartItem copy(@NotNull String item, int i, double d, @Nullable String str) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new PiCartItem(item, i, d, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PiCartItem)) {
            return false;
        }
        PiCartItem piCartItem = (PiCartItem) obj;
        return Intrinsics.areEqual(this.item, piCartItem.item) && this.quantity == piCartItem.quantity && Double.compare(this.price, piCartItem.price) == 0 && Intrinsics.areEqual(this.uniqueId, piCartItem.uniqueId);
    }

    public int hashCode() {
        int iHashCode = this.item.hashCode();
        int iHashCode2 = Integer.hashCode(this.quantity);
        int iHashCode3 = Double.hashCode(this.price);
        String str = this.uniqueId;
        return (((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (str == null ? 0 : str.hashCode());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "item", imports = {}))
    public final String item() {
        return this.item;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.PRICE, imports = {}))
    public final double price() {
        return this.price;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "quantity", imports = {}))
    public final int quantity() {
        return this.quantity;
    }

    public final JSONObject toJson$sdk_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item", this.item);
        jSONObject.put("quantity", this.quantity);
        jSONObject.put(FirebaseAnalytics.Param.PRICE, this.price);
        String str = this.uniqueId;
        if (str != null) {
            jSONObject.put("unique_id", str);
        }
        return jSONObject;
    }

    public String toString() {
        return "PiCartItem(item=" + this.item + ", quantity=" + this.quantity + ", price=" + this.price + ", uniqueId=" + this.uniqueId + ")";
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "uniqueId", imports = {}))
    public final String uniqueId() {
        return this.uniqueId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.item);
        out.writeInt(this.quantity);
        out.writeDouble(this.price);
        out.writeString(this.uniqueId);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCartItem(item, quantity, price, uniqueId)", imports = {}))
    @JvmStatic
    public static final PiCartItem create(@NotNull String str, int i, double d, @Nullable String str2) {
        return Companion.a(str, i, d, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PiCartItem(@NotNull String item, int i, double d) {
        this(item, i, d, null);
        Intrinsics.checkNotNullParameter(item, "item");
    }
}
