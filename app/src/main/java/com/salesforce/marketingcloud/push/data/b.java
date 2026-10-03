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
public final class b implements d, Parcelable {
    private final String b;
    private final c c;
    private final Style d;
    private final List<com.salesforce.marketingcloud.push.data.a> e;
    public static final a f = new a(null);
    public static final Parcelable.Creator<b> CREATOR = new C0104b();

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(@NotNull JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            String strOptString = json.optString(g.m);
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            String strB = o.b(strOptString);
            if (strB == null) {
                throw new e(g.m);
            }
            JSONObject jSONObjectOptJSONObject = json.optJSONObject(g.p);
            c cVarA = jSONObjectOptJSONObject != null ? c.e.a(jSONObjectOptJSONObject) : null;
            JSONObject jSONObjectOptJSONObject2 = json.optJSONObject(g.k);
            return new b(strB, cVarA, jSONObjectOptJSONObject2 != null ? Style.a.a(jSONObjectOptJSONObject2) : null, null, 8, null);
        }

        private a() {
        }

        public final JSONObject a(@NotNull b media) throws JSONException {
            Intrinsics.checkNotNullParameter(media, "media");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(g.m, media.o());
            c cVarN = media.n();
            if (cVarN != null) {
                jSONObject.put(g.p, c.e.a(cVarN));
            }
            Style styleA = media.a();
            jSONObject.put(g.k, styleA != null ? Style.a.a(styleA) : null);
            return jSONObject;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.data.b$b, reason: collision with other inner class name */
    public static final class C0104b implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            ArrayList arrayList = null;
            c cVarCreateFromParcel = parcel.readInt() == 0 ? null : c.CREATOR.createFromParcel(parcel);
            Style style = (Style) parcel.readParcelable(b.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(parcel.readParcelable(b.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new b(string, cVarCreateFromParcel, style, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b[] newArray(int i) {
            return new b[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull String url, @Nullable c cVar, @Nullable Style style, @Nullable List<? extends com.salesforce.marketingcloud.push.data.a> list) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.b = url;
        this.c = cVar;
        this.d = style;
        this.e = list;
    }

    public final b a(@NotNull String url, @Nullable c cVar, @Nullable Style style, @Nullable List<? extends com.salesforce.marketingcloud.push.data.a> list) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new b(url, cVar, style, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c) && Intrinsics.areEqual(this.d, bVar.d) && Intrinsics.areEqual(this.e, bVar.e);
    }

    @Override // com.salesforce.marketingcloud.push.data.d
    public List<com.salesforce.marketingcloud.push.data.a> h() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = this.b.hashCode();
        c cVar = this.c;
        int iHashCode2 = cVar == null ? 0 : cVar.hashCode();
        Style style = this.d;
        int iHashCode3 = style == null ? 0 : style.hashCode();
        List<com.salesforce.marketingcloud.push.data.a> list = this.e;
        return (((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String j() {
        return this.b;
    }

    public final c k() {
        return this.c;
    }

    public final Style l() {
        return this.d;
    }

    public final List<com.salesforce.marketingcloud.push.data.a> m() {
        return this.e;
    }

    public final c n() {
        return this.c;
    }

    public final String o() {
        return this.b;
    }

    public String toString() {
        return "Media(url=" + this.b + ", altText=" + this.c + ", style=" + a() + ", action=" + h() + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.b);
        c cVar = this.c;
        if (cVar == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            cVar.writeToParcel(out, i);
        }
        out.writeParcelable(this.d, i);
        List<com.salesforce.marketingcloud.push.data.a> list = this.e;
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
    public static /* synthetic */ b a(b bVar, String str, c cVar, Style style, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bVar.b;
        }
        if ((i & 2) != 0) {
            cVar = bVar.c;
        }
        if ((i & 4) != 0) {
            style = bVar.d;
        }
        if ((i & 8) != 0) {
            list = bVar.e;
        }
        return bVar.a(str, cVar, style, list);
    }

    @Override // com.salesforce.marketingcloud.push.data.d
    public Style a() {
        return this.d;
    }

    public /* synthetic */ b(String str, c cVar, Style style, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : cVar, (i & 4) != 0 ? null : style, (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
