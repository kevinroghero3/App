package com.salesforce.marketingcloud.push.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.internal.o;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Parcelable {
    public static final b c = new b(null);
    private final int b;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.data.a$a, reason: collision with other inner class name */
    public static final class C0098a extends a {
        public static final Parcelable.Creator<C0098a> CREATOR = new C0099a();
        private final String d;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.data.a$a$a, reason: collision with other inner class name */
        public static final class C0099a implements Parcelable.Creator<C0098a> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C0098a createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new C0098a(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C0098a[] newArray(int i) {
                return new C0098a[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0098a(@NotNull String url) {
            super(f.CloudPage.ordinal(), null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.d = url;
        }

        public final C0098a a(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new C0098a(url);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0098a) && Intrinsics.areEqual(this.d, ((C0098a) obj).d);
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        public final String k() {
            return this.d;
        }

        public final String l() {
            return this.d;
        }

        public String toString() {
            return "CloudPage(url=" + this.d + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.d);
        }

        public static /* synthetic */ C0098a a(C0098a c0098a, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = c0098a.d;
            }
            return c0098a.a(str);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(@NotNull JSONObject json) {
            a c0098a;
            Intrinsics.checkNotNullParameter(json, "json");
            Integer numValueOf = Integer.valueOf(json.optString(com.salesforce.marketingcloud.push.g.g));
            int iOrdinal = f.OpenApp.ordinal();
            if (numValueOf != null && numValueOf.intValue() == iOrdinal) {
                return e.d;
            }
            int iOrdinal2 = f.Deeplink.ordinal();
            if (numValueOf != null && numValueOf.intValue() == iOrdinal2) {
                String strOptString = json.optString(com.salesforce.marketingcloud.push.g.m);
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String strB = o.b(strOptString);
                if (strB == null) {
                    return e.d;
                }
                c0098a = new c(strB);
            } else {
                int iOrdinal3 = f.Url.ordinal();
                if (numValueOf != null && numValueOf.intValue() == iOrdinal3) {
                    String strOptString2 = json.optString(com.salesforce.marketingcloud.push.g.m);
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    String strB2 = o.b(strOptString2);
                    if (strB2 == null) {
                        return e.d;
                    }
                    c0098a = new g(strB2);
                } else {
                    int iOrdinal4 = f.CloudPage.ordinal();
                    if (numValueOf == null || numValueOf.intValue() != iOrdinal4) {
                        int iOrdinal5 = f.Dismiss.ordinal();
                        if (numValueOf != null && numValueOf.intValue() == iOrdinal5) {
                            return d.d;
                        }
                        return null;
                    }
                    String strOptString3 = json.optString(com.salesforce.marketingcloud.push.g.m);
                    Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                    String strB3 = o.b(strOptString3);
                    if (strB3 == null) {
                        return e.d;
                    }
                    c0098a = new C0098a(strB3);
                }
            }
            return c0098a;
        }

        private b() {
        }
    }

    public static final class c extends a {
        public static final Parcelable.Creator<c> CREATOR = new C0100a();
        private final String d;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.data.a$c$a, reason: collision with other inner class name */
        public static final class C0100a implements Parcelable.Creator<c> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new c(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c[] newArray(int i) {
                return new c[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull String url) {
            super(f.Deeplink.ordinal(), null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.d = url;
        }

        public final c a(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new c(url);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.areEqual(this.d, ((c) obj).d);
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        public final String k() {
            return this.d;
        }

        public final String l() {
            return this.d;
        }

        public String toString() {
            return "Deeplink(url=" + this.d + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.d);
        }

        public static /* synthetic */ c a(c cVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cVar.d;
            }
            return cVar.a(str);
        }
    }

    public static final class d extends a {
        public static final d d = new d();
        public static final Parcelable.Creator<d> CREATOR = new C0101a();

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.data.a$d$a, reason: collision with other inner class name */
        public static final class C0101a implements Parcelable.Creator<d> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final d createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return d.d;
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final d[] newArray(int i) {
                return new d[i];
            }
        }

        private d() {
            super(f.Dismiss.ordinal(), null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(1);
        }
    }

    public static final class e extends a {
        public static final e d = new e();
        public static final Parcelable.Creator<e> CREATOR = new C0102a();

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.data.a$e$a, reason: collision with other inner class name */
        public static final class C0102a implements Parcelable.Creator<e> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final e createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return e.d;
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final e[] newArray(int i) {
                return new e[i];
            }
        }

        private e() {
            super(f.OpenApp.ordinal(), null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(1);
        }
    }

    public enum f {
        OpenApp,
        Deeplink,
        Url,
        CloudPage,
        Dismiss;

        private static final /* synthetic */ EnumEntries h = EnumEntriesKt.enumEntries(a());

        public static EnumEntries<f> b() {
            return h;
        }
    }

    public static final class g extends a {
        public static final Parcelable.Creator<g> CREATOR = new C0103a();
        private final String d;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.data.a$g$a, reason: collision with other inner class name */
        public static final class C0103a implements Parcelable.Creator<g> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new g(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g[] newArray(int i) {
                return new g[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(@NotNull String url) {
            super(f.Url.ordinal(), null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.d = url;
        }

        public final g a(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new g(url);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && Intrinsics.areEqual(this.d, ((g) obj).d);
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        public final String k() {
            return this.d;
        }

        public final String l() {
            return this.d;
        }

        public String toString() {
            return "Url(url=" + this.d + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.d);
        }

        public static /* synthetic */ g a(g gVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gVar.d;
            }
            return gVar.a(str);
        }
    }

    public /* synthetic */ a(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    public final int h() {
        return this.b;
    }

    public final JSONObject j() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(com.salesforce.marketingcloud.push.g.g, this.b);
        if (this instanceof c) {
            jSONObject.put(com.salesforce.marketingcloud.push.g.m, ((c) this).l());
        } else if (this instanceof g) {
            jSONObject.put(com.salesforce.marketingcloud.push.g.m, ((g) this).l());
        } else if (this instanceof C0098a) {
            jSONObject.put(com.salesforce.marketingcloud.push.g.m, ((C0098a) this).l());
        }
        return jSONObject;
    }

    private a(int i) {
        this.b = i;
    }
}
