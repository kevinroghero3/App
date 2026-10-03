package com.salesforce.marketingcloud.proximity;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.messages.Region;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();
    private final String b;
    private final String c;
    private final int d;
    private final int e;

    public static final class a implements Parcelable.Creator<c> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new c(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c[] newArray(int i) {
            return new c[i];
        }
    }

    public c(@NotNull String id, @NotNull String guid, int i, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(guid, "guid");
        this.b = id;
        this.c = guid;
        this.d = i;
        this.e = i2;
    }

    public final c a(@NotNull String id, @NotNull String guid, int i, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(guid, "guid");
        return new c(id, guid, i, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c) && this.d == cVar.d && this.e == cVar.e;
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        return (((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
    }

    public final String j() {
        return this.c;
    }

    public final int k() {
        return this.d;
    }

    public final int l() {
        return this.e;
    }

    public final String m() {
        return this.c;
    }

    public final String n() {
        return this.b;
    }

    public final int o() {
        return this.d;
    }

    public final int p() {
        return this.e;
    }

    public String toString() {
        return "BeaconRegion(id=" + this.b + ", guid=" + this.c + ", major=" + this.d + ", minor=" + this.e + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.b);
        out.writeString(this.c);
        out.writeInt(this.d);
        out.writeInt(this.e);
    }

    public static /* synthetic */ c a(c cVar, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cVar.b;
        }
        if ((i3 & 2) != 0) {
            str2 = cVar.c;
        }
        if ((i3 & 4) != 0) {
            i = cVar.d;
        }
        if ((i3 & 8) != 0) {
            i2 = cVar.e;
        }
        return cVar.a(str, str2, i, i2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(@NotNull Region region) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(region, "region");
        String str = region.id;
        String str2 = region.proximityUuid;
        if (str2 != null) {
            this(str, str2, region.major, region.minor);
            return;
        }
        throw new IllegalArgumentException("Not a beacon region");
    }
}
