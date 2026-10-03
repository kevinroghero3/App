package com.salesforce.marketingcloud.push.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.internal.o;
import com.salesforce.marketingcloud.push.e;
import com.salesforce.marketingcloud.push.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements d, Parcelable {
    private final String b;
    private final Style.b c;
    private final List<com.salesforce.marketingcloud.push.data.a> d;
    public static final a e = new a(null);
    public static final Parcelable.Creator<c> CREATOR = new b();

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a(@NotNull JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            String strOptString = json.optString(g.q);
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            String strB = o.b(strOptString);
            if (strB == null) {
                throw new e(g.q);
            }
            JSONObject jSONObjectOptJSONObject = json.optJSONObject(g.k);
            return new c(strB, jSONObjectOptJSONObject != null ? Style.a.a(jSONObjectOptJSONObject) : null, null, 4, null);
        }

        private a() {
        }

        public final JSONObject a(@NotNull c text) throws JSONException {
            Intrinsics.checkNotNullParameter(text, "text");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(g.q, text.n());
            Style.b bVarA = text.a();
            jSONObject.put(g.k, bVarA != null ? Style.a.a(bVarA) : null);
            return jSONObject;
        }
    }

    public static final class b implements Parcelable.Creator<c> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            ArrayList arrayList = null;
            Style.b bVarCreateFromParcel = parcel.readInt() == 0 ? null : Style.b.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(parcel.readParcelable(c.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new c(string, bVarCreateFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c[] newArray(int i) {
            return new c[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull String text, @Nullable Style.b bVar, @Nullable List<? extends com.salesforce.marketingcloud.push.data.a> list) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.b = text;
        this.c = bVar;
        this.d = list;
    }

    public final c a(@NotNull String text, @Nullable Style.b bVar, @Nullable List<? extends com.salesforce.marketingcloud.push.data.a> list) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new c(text, bVar, list);
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
        return Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c) && Intrinsics.areEqual(this.d, cVar.d);
    }

    @Override // com.salesforce.marketingcloud.push.data.d
    public List<com.salesforce.marketingcloud.push.data.a> h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = this.b.hashCode();
        Style.b bVar = this.c;
        int iHashCode2 = bVar == null ? 0 : bVar.hashCode();
        List<com.salesforce.marketingcloud.push.data.a> list = this.d;
        return (((iHashCode * 31) + iHashCode2) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String j() {
        return this.b;
    }

    public final Style.b k() {
        return this.c;
    }

    public final List<com.salesforce.marketingcloud.push.data.a> l() {
        return this.d;
    }

    @Override // com.salesforce.marketingcloud.push.data.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Style.b a() {
        return this.c;
    }

    public final String n() {
        return this.b;
    }

    public String toString() {
        return "Text(text=" + this.b + ", style=" + a() + ", action=" + h() + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.b);
        Style.b bVar = this.c;
        if (bVar == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            bVar.writeToParcel(out, i);
        }
        List<com.salesforce.marketingcloud.push.data.a> list = this.d;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        Iterator<com.salesforce.marketingcloud.push.data.a> it2 = list.iterator();
        while (it2.hasNext()) {
            out.writeParcelable(it2.next(), i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c a(c cVar, String str, Style.b bVar, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cVar.b;
        }
        if ((i & 2) != 0) {
            bVar = cVar.c;
        }
        if ((i & 4) != 0) {
            list = cVar.d;
        }
        return cVar.a(str, bVar, list);
    }

    public /* synthetic */ c(String str, Style.b bVar, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : bVar, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
