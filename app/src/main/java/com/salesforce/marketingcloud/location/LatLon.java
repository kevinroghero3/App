package com.salesforce.marketingcloud.location;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class LatLon implements Parcelable {
    public static final Parcelable.Creator<LatLon> CREATOR = new a();
    public final double latitude;
    public final double longitude;

    public static final class a implements Parcelable.Creator<LatLon> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LatLon createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LatLon(parcel.readDouble(), parcel.readDouble());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LatLon[] newArray(int i) {
            return new LatLon[i];
        }
    }

    public LatLon(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public static /* synthetic */ LatLon copy$default(LatLon latLon, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = latLon.latitude;
        }
        if ((i & 2) != 0) {
            d2 = latLon.longitude;
        }
        return latLon.copy(d, d2);
    }

    public final double component1() {
        return this.latitude;
    }

    public final double component2() {
        return this.longitude;
    }

    public final LatLon copy(double d, double d2) {
        return new LatLon(d, d2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLon)) {
            return false;
        }
        LatLon latLon = (LatLon) obj;
        return Double.compare(this.latitude, latLon.latitude) == 0 && Double.compare(this.longitude, latLon.longitude) == 0;
    }

    public int hashCode() {
        return (Double.hashCode(this.latitude) * 31) + Double.hashCode(this.longitude);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "latitude", imports = {}))
    public final double latitude() {
        return this.latitude;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "longitude", imports = {}))
    public final double longitude() {
        return this.longitude;
    }

    public String toString() {
        return "LatLon(latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeDouble(this.latitude);
        out.writeDouble(this.longitude);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LatLon(@NotNull JSONObject json) throws JSONException {
        this(json.getDouble("latitude"), json.getDouble("longitude"));
        Intrinsics.checkNotNullParameter(json, "json");
    }
}
