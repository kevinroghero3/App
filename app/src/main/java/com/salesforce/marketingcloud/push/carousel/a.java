package com.salesforce.marketingcloud.push.carousel;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.push.data.Style;
import com.salesforce.marketingcloud.push.data.Template;
import com.salesforce.marketingcloud.push.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Template {
    public static final int h = 0;
    private final List<C0095a> b;
    private final int c;
    private final Style d;
    private final Template.Type e;
    private final String f;
    public static final b g = new b(null);
    public static final Parcelable.Creator<a> CREATOR = new c();

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.carousel.a$a, reason: collision with other inner class name */
    public static final class C0095a implements Parcelable, com.salesforce.marketingcloud.push.data.d {
        public static final Parcelable.Creator<C0095a> CREATOR = new C0096a();
        private final String b;
        private final com.salesforce.marketingcloud.push.data.b c;
        private final com.salesforce.marketingcloud.push.data.c d;
        private final com.salesforce.marketingcloud.push.data.c e;
        private final Style f;
        private final List<com.salesforce.marketingcloud.push.data.a> g;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.carousel.a$a$a, reason: collision with other inner class name */
        public static final class C0096a implements Parcelable.Creator<C0095a> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C0095a createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String string = parcel.readString();
                com.salesforce.marketingcloud.push.data.b bVarCreateFromParcel = com.salesforce.marketingcloud.push.data.b.CREATOR.createFromParcel(parcel);
                ArrayList arrayList = null;
                com.salesforce.marketingcloud.push.data.c cVarCreateFromParcel = parcel.readInt() == 0 ? null : com.salesforce.marketingcloud.push.data.c.CREATOR.createFromParcel(parcel);
                com.salesforce.marketingcloud.push.data.c cVarCreateFromParcel2 = parcel.readInt() == 0 ? null : com.salesforce.marketingcloud.push.data.c.CREATOR.createFromParcel(parcel);
                Style style = (Style) parcel.readParcelable(C0095a.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    int i = parcel.readInt();
                    arrayList = new ArrayList(i);
                    for (int i2 = 0; i2 != i; i2++) {
                        arrayList.add(parcel.readParcelable(C0095a.class.getClassLoader()));
                    }
                }
                return new C0095a(string, bVarCreateFromParcel, cVarCreateFromParcel, cVarCreateFromParcel2, style, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C0095a[] newArray(int i) {
                return new C0095a[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0095a(@NotNull String identifier, @NotNull com.salesforce.marketingcloud.push.data.b media, @Nullable com.salesforce.marketingcloud.push.data.c cVar, @Nullable com.salesforce.marketingcloud.push.data.c cVar2, @Nullable Style style, @Nullable List<? extends com.salesforce.marketingcloud.push.data.a> list) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(media, "media");
            this.b = identifier;
            this.c = media;
            this.d = cVar;
            this.e = cVar2;
            this.f = style;
            this.g = list;
        }

        public final C0095a a(@NotNull String identifier, @NotNull com.salesforce.marketingcloud.push.data.b media, @Nullable com.salesforce.marketingcloud.push.data.c cVar, @Nullable com.salesforce.marketingcloud.push.data.c cVar2, @Nullable Style style, @Nullable List<? extends com.salesforce.marketingcloud.push.data.a> list) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(media, "media");
            return new C0095a(identifier, media, cVar, cVar2, style, list);
        }

        public final String d() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0095a)) {
                return false;
            }
            C0095a c0095a = (C0095a) obj;
            return Intrinsics.areEqual(this.b, c0095a.b) && Intrinsics.areEqual(this.c, c0095a.c) && Intrinsics.areEqual(this.d, c0095a.d) && Intrinsics.areEqual(this.e, c0095a.e) && Intrinsics.areEqual(this.f, c0095a.f) && Intrinsics.areEqual(this.g, c0095a.g);
        }

        @Override // com.salesforce.marketingcloud.push.data.d
        public List<com.salesforce.marketingcloud.push.data.a> h() {
            return this.g;
        }

        public int hashCode() {
            int iHashCode = this.b.hashCode();
            int iHashCode2 = this.c.hashCode();
            com.salesforce.marketingcloud.push.data.c cVar = this.d;
            int iHashCode3 = cVar == null ? 0 : cVar.hashCode();
            com.salesforce.marketingcloud.push.data.c cVar2 = this.e;
            int iHashCode4 = cVar2 == null ? 0 : cVar2.hashCode();
            Style style = this.f;
            int iHashCode5 = style == null ? 0 : style.hashCode();
            List<com.salesforce.marketingcloud.push.data.a> list = this.g;
            return (((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + (list != null ? list.hashCode() : 0);
        }

        public final String j() {
            return this.b;
        }

        public final com.salesforce.marketingcloud.push.data.b k() {
            return this.c;
        }

        public final com.salesforce.marketingcloud.push.data.c l() {
            return this.d;
        }

        public final com.salesforce.marketingcloud.push.data.c m() {
            return this.e;
        }

        public final Style n() {
            return this.f;
        }

        public final List<com.salesforce.marketingcloud.push.data.a> o() {
            return this.g;
        }

        public final com.salesforce.marketingcloud.push.data.b p() {
            return this.c;
        }

        public final com.salesforce.marketingcloud.push.data.c q() {
            return this.e;
        }

        public final com.salesforce.marketingcloud.push.data.c r() {
            return this.d;
        }

        public final JSONObject s() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.b);
            jSONObject.put(g.j, com.salesforce.marketingcloud.push.data.b.f.a(this.c));
            com.salesforce.marketingcloud.push.data.c cVar = this.d;
            if (cVar != null) {
                jSONObject.put(g.f81n, com.salesforce.marketingcloud.push.data.c.e.a(cVar));
            }
            com.salesforce.marketingcloud.push.data.c cVar2 = this.e;
            if (cVar2 != null) {
                jSONObject.put(g.f82o, com.salesforce.marketingcloud.push.data.c.e.a(cVar2));
            }
            Style styleA = a();
            if (styleA != null) {
                jSONObject.put(g.k, Style.a.a(styleA));
            }
            if (h() != null) {
                List<com.salesforce.marketingcloud.push.data.a> listH = h();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listH, 10));
                Iterator<T> it2 = listH.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((com.salesforce.marketingcloud.push.data.a) it2.next()).j());
                }
                jSONObject.put(g.l, new JSONArray((Collection) arrayList));
            }
            return jSONObject;
        }

        public String toString() {
            return "CarouselItem(identifier=" + this.b + ", title=" + this.d + ", subTitle=" + this.e + ", media=" + this.c + ", style=" + a() + ", action=" + h() + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.b);
            this.c.writeToParcel(out, i);
            com.salesforce.marketingcloud.push.data.c cVar = this.d;
            if (cVar == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                cVar.writeToParcel(out, i);
            }
            com.salesforce.marketingcloud.push.data.c cVar2 = this.e;
            if (cVar2 == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                cVar2.writeToParcel(out, i);
            }
            out.writeParcelable(this.f, i);
            List<com.salesforce.marketingcloud.push.data.a> list = this.g;
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
        public static /* synthetic */ C0095a a(C0095a c0095a, String str, com.salesforce.marketingcloud.push.data.b bVar, com.salesforce.marketingcloud.push.data.c cVar, com.salesforce.marketingcloud.push.data.c cVar2, Style style, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = c0095a.b;
            }
            if ((i & 2) != 0) {
                bVar = c0095a.c;
            }
            com.salesforce.marketingcloud.push.data.b bVar2 = bVar;
            if ((i & 4) != 0) {
                cVar = c0095a.d;
            }
            com.salesforce.marketingcloud.push.data.c cVar3 = cVar;
            if ((i & 8) != 0) {
                cVar2 = c0095a.e;
            }
            com.salesforce.marketingcloud.push.data.c cVar4 = cVar2;
            if ((i & 16) != 0) {
                style = c0095a.f;
            }
            Style style2 = style;
            if ((i & 32) != 0) {
                list = c0095a.g;
            }
            return c0095a.a(str, bVar2, cVar3, cVar4, style2, list);
        }

        @Override // com.salesforce.marketingcloud.push.data.d
        public Style a() {
            return this.f;
        }

        public /* synthetic */ C0095a(String str, com.salesforce.marketingcloud.push.data.b bVar, com.salesforce.marketingcloud.push.data.c cVar, com.salesforce.marketingcloud.push.data.c cVar2, Style style, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, bVar, (i & 4) != 0 ? null : cVar, (i & 8) != 0 ? null : cVar2, (i & 16) != 0 ? null : style, (i & 32) != 0 ? CollectionsKt__CollectionsJVMKt.listOf(com.salesforce.marketingcloud.push.data.a.e.d) : list);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private b() {
        }
    }

    public static final class c implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(C0095a.CREATOR.createFromParcel(parcel));
            }
            return new a(arrayList, parcel.readInt(), (Style) parcel.readParcelable(a.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a[] newArray(int i) {
            return new a[i];
        }
    }

    public a(@NotNull List<C0095a> items, int i, @Nullable Style style) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.b = items;
        this.c = i;
        this.d = style;
        this.e = Template.Type.CarouselFull;
    }

    public final a a(@NotNull List<C0095a> items, int i, @Nullable Style style) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new a(items, i, style);
    }

    @Override // com.salesforce.marketingcloud.push.data.Template
    public String d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.b, aVar.b) && this.c == aVar.c && Intrinsics.areEqual(this.d, aVar.d);
    }

    @Override // com.salesforce.marketingcloud.push.data.Template
    public Template.Type f() {
        return this.e;
    }

    public final List<C0095a> h() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = this.b.hashCode();
        int iHashCode2 = Integer.hashCode(this.c);
        Style style = this.d;
        return (((iHashCode * 31) + iHashCode2) * 31) + (style == null ? 0 : style.hashCode());
    }

    public final int j() {
        return this.c;
    }

    public final Style k() {
        return this.d;
    }

    public final List<C0095a> l() {
        return this.b;
    }

    public final int m() {
        return this.c;
    }

    public String toString() {
        return "CarouselFullTemplate(items=" + this.b + ", selectedIndex=" + this.c + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        List<C0095a> list = this.b;
        out.writeInt(list.size());
        Iterator<C0095a> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i);
        }
        out.writeInt(this.c);
        out.writeParcelable(this.d, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a a(a aVar, List list, int i, Style style, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = aVar.b;
        }
        if ((i2 & 2) != 0) {
            i = aVar.c;
        }
        if ((i2 & 4) != 0) {
            style = aVar.d;
        }
        return aVar.a(list, i, style);
    }

    @Override // com.salesforce.marketingcloud.push.data.Template
    public Style a() {
        return this.d;
    }

    public /* synthetic */ a(List list, int i, Style style, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : style);
    }
}
