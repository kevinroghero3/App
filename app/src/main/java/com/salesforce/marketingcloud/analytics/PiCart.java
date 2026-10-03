package com.salesforce.marketingcloud.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class PiCart implements Parcelable {
    public final List<PiCartItem> cartItems;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<PiCart> CREATOR = new b();

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCart(cartItems)", imports = {}))
        @JvmStatic
        public final PiCart a(@NotNull List<PiCartItem> cartItems) {
            Intrinsics.checkNotNullParameter(cartItems, "cartItems");
            return new PiCart(cartItems);
        }

        private a() {
        }
    }

    public static final class b implements Parcelable.Creator<PiCart> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PiCart createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(PiCartItem.CREATOR.createFromParcel(parcel));
            }
            return new PiCart(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PiCart[] newArray(int i) {
            return new PiCart[i];
        }
    }

    static final class c extends Lambda implements Function0<String> {
        public static final c b = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to convert List<PiCartItem> into JSONArray for PiCart payload.";
        }
    }

    public PiCart(@NotNull List<PiCartItem> cartItems) {
        Intrinsics.checkNotNullParameter(cartItems, "cartItems");
        this.cartItems = cartItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PiCart copy$default(PiCart piCart, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = piCart.cartItems;
        }
        return piCart.copy(list);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCart(cartItems)", imports = {}))
    @JvmStatic
    public static final PiCart create(@NotNull List<PiCartItem> list) {
        return Companion.a(list);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cartItems", imports = {}))
    public final List<PiCartItem> cartItems() {
        return this.cartItems;
    }

    public final List<PiCartItem> component1() {
        return this.cartItems;
    }

    public final PiCart copy(@NotNull List<PiCartItem> cartItems) {
        Intrinsics.checkNotNullParameter(cartItems, "cartItems");
        return new PiCart(cartItems);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PiCart) && Intrinsics.areEqual(this.cartItems, ((PiCart) obj).cartItems);
    }

    public int hashCode() {
        return this.cartItems.hashCode();
    }

    public final JSONArray toJson$sdk_release() {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<T> it2 = this.cartItems.iterator();
            while (it2.hasNext()) {
                jSONArray.put(((PiCartItem) it2.next()).toJson$sdk_release());
            }
        } catch (JSONException e) {
            com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
            String TAG = AnalyticsManager.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            gVar.b(TAG, e, c.b);
        }
        return jSONArray;
    }

    public String toString() {
        return "PiCart(cartItems=" + this.cartItems + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        List<PiCartItem> list = this.cartItems;
        out.writeInt(list.size());
        Iterator<PiCartItem> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i);
        }
    }
}
