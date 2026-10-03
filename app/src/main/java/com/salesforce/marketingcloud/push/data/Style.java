package com.salesforce.marketingcloud.push.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import androidx.core.view.GravityCompat;
import androidx.exifinterface.media.ExifInterface;
import com.salesforce.marketingcloud.internal.o;
import com.salesforce.marketingcloud.push.g;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface Style extends Parcelable {
    public static final a a = a.a;

    public enum Alignment {
        B,
        C,
        E;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        public static final a Companion = new a(null);

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Alignment a(@Nullable String str) {
                String upperCase;
                if (str != null) {
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    upperCase = str.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                } else {
                    upperCase = null;
                }
                if (upperCase == null) {
                    return null;
                }
                int iHashCode = upperCase.hashCode();
                if (iHashCode == 66) {
                    if (upperCase.equals("B")) {
                        return Alignment.B;
                    }
                    return null;
                }
                if (iHashCode == 67) {
                    if (upperCase.equals("C")) {
                        return Alignment.C;
                    }
                    return null;
                }
                if (iHashCode == 69 && upperCase.equals(ExifInterface.LONGITUDE_EAST)) {
                    return Alignment.E;
                }
                return null;
            }

            private a() {
            }
        }

        public final /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[Alignment.values().length];
                try {
                    iArr[Alignment.B.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Alignment.C.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Alignment.E.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        public static EnumEntries<Alignment> getEntries() {
            return $ENTRIES;
        }

        public final int toGravity() {
            int i = b.a[ordinal()];
            if (i == 1) {
                return GravityCompat.START;
            }
            if (i == 2) {
                return 17;
            }
            if (i == 3) {
                return GravityCompat.END;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public enum FontStyle {
        R,
        B,
        I;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        public static final a Companion = new a(null);

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final FontStyle a(@Nullable String str) {
                String upperCase;
                if (str != null) {
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    upperCase = str.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                } else {
                    upperCase = null;
                }
                if (upperCase == null) {
                    return null;
                }
                int iHashCode = upperCase.hashCode();
                if (iHashCode == 66) {
                    if (upperCase.equals("B")) {
                        return FontStyle.B;
                    }
                    return null;
                }
                if (iHashCode == 73) {
                    if (upperCase.equals("I")) {
                        return FontStyle.I;
                    }
                    return null;
                }
                if (iHashCode == 82 && upperCase.equals("R")) {
                    return FontStyle.R;
                }
                return null;
            }

            private a() {
            }
        }

        public static EnumEntries<FontStyle> getEntries() {
            return $ENTRIES;
        }
    }

    public enum Size {
        S,
        M,
        L;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        public static final a Companion = new a(null);

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Size a(@NotNull String size) {
                Intrinsics.checkNotNullParameter(size, "size");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String upperCase = size.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                int iHashCode = upperCase.hashCode();
                if (iHashCode != 76) {
                    if (iHashCode != 77) {
                        if (iHashCode == 83 && upperCase.equals(ExifInterface.LATITUDE_SOUTH)) {
                            return Size.S;
                        }
                    } else if (upperCase.equals("M")) {
                        return Size.M;
                    }
                } else if (upperCase.equals("L")) {
                    return Size.L;
                }
                return null;
            }

            private a() {
            }
        }

        public final /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[Size.values().length];
                try {
                    iArr[Size.S.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Size.M.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Size.L.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        public static EnumEntries<Size> getEntries() {
            return $ENTRIES;
        }

        public final float toSP() {
            int i = b.a[ordinal()];
            if (i == 1) {
                return 10.0f;
            }
            if (i == 2) {
                return 12.0f;
            }
            if (i == 3) {
                return 14.0f;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b implements Style {
        public static final Parcelable.Creator<b> CREATOR = new a();
        private final String b;
        private final String c;
        private final Size d;
        private final Alignment e;
        private final FontStyle f;
        private Spanned g;

        public static final class a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new b(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Size.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Alignment.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : FontStyle.valueOf(parcel.readString()), null, 32, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b[] newArray(int i) {
                return new b[i];
            }
        }

        public b() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ void p() {
        }

        public final b a(@Nullable String str, @Nullable String str2, @Nullable Size size, @Nullable Alignment alignment, @Nullable FontStyle fontStyle, @Nullable Spanned spanned) {
            return new b(str, str2, size, alignment, fontStyle, spanned);
        }

        @Override // com.salesforce.marketingcloud.push.data.Style
        public FontStyle b() {
            return this.f;
        }

        @Override // com.salesforce.marketingcloud.push.data.Style
        public Size c() {
            return this.d;
        }

        @Override // com.salesforce.marketingcloud.push.data.Style
        public Alignment e() {
            return this.e;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c) && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && Intrinsics.areEqual(this.g, bVar.g);
        }

        @Override // com.salesforce.marketingcloud.push.data.Style
        public String g() {
            return this.b;
        }

        public final String h() {
            return this.b;
        }

        public int hashCode() {
            String str = this.b;
            int iHashCode = str == null ? 0 : str.hashCode();
            String str2 = this.c;
            int iHashCode2 = str2 == null ? 0 : str2.hashCode();
            Size size = this.d;
            int iHashCode3 = size == null ? 0 : size.hashCode();
            Alignment alignment = this.e;
            int iHashCode4 = alignment == null ? 0 : alignment.hashCode();
            FontStyle fontStyle = this.f;
            int iHashCode5 = fontStyle == null ? 0 : fontStyle.hashCode();
            Spanned spanned = this.g;
            return (((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + (spanned != null ? spanned.hashCode() : 0);
        }

        @Override // com.salesforce.marketingcloud.push.data.Style
        public String i() {
            return this.c;
        }

        public final String j() {
            return this.c;
        }

        public final Size k() {
            return this.d;
        }

        public final Alignment l() {
            return this.e;
        }

        public final FontStyle m() {
            return this.f;
        }

        public final Spanned n() {
            return this.g;
        }

        public final Spanned o() {
            return this.g;
        }

        public String toString() {
            return "StyleImpl(fontColor=" + this.b + ", backgroundColor=" + this.c + ", fontSize=" + this.d + ", alignment=" + this.e + ", fontStyle=" + this.f + ", span=" + ((Object) this.g) + ")";
        }

        @Override // com.salesforce.marketingcloud.push.data.Style, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.b);
            out.writeString(this.c);
            Size size = this.d;
            if (size == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                out.writeString(size.name());
            }
            Alignment alignment = this.e;
            if (alignment == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                out.writeString(alignment.name());
            }
            FontStyle fontStyle = this.f;
            if (fontStyle == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                out.writeString(fontStyle.name());
            }
        }

        public b(@Nullable String str, @Nullable String str2, @Nullable Size size, @Nullable Alignment alignment, @Nullable FontStyle fontStyle, @Nullable Spanned spanned) {
            this.b = str;
            this.c = str2;
            this.d = size;
            this.e = alignment;
            this.f = fontStyle;
            this.g = spanned;
        }

        public static /* synthetic */ b a(b bVar, String str, String str2, Size size, Alignment alignment, FontStyle fontStyle, Spanned spanned, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bVar.b;
            }
            if ((i & 2) != 0) {
                str2 = bVar.c;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                size = bVar.d;
            }
            Size size2 = size;
            if ((i & 8) != 0) {
                alignment = bVar.e;
            }
            Alignment alignment2 = alignment;
            if ((i & 16) != 0) {
                fontStyle = bVar.f;
            }
            FontStyle fontStyle2 = fontStyle;
            if ((i & 32) != 0) {
                spanned = bVar.g;
            }
            return bVar.a(str, str3, size2, alignment2, fontStyle2, spanned);
        }

        public final void a(@Nullable Spanned spanned) {
            this.g = spanned;
        }

        public /* synthetic */ b(String str, String str2, Size size, Alignment alignment, FontStyle fontStyle, Spanned spanned, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : size, (i & 8) != 0 ? null : alignment, (i & 16) != 0 ? null : fontStyle, (i & 32) != 0 ? null : spanned);
        }
    }

    FontStyle b();

    Size c();

    @Override // android.os.Parcelable
    default int describeContents() {
        return 0;
    }

    Alignment e();

    String g();

    String i();

    @Override // android.os.Parcelable
    default void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(g());
        parcel.writeString(i());
        Size sizeC = c();
        parcel.writeString(sizeC != null ? sizeC.name() : null);
        Alignment alignmentE = e();
        parcel.writeString(alignmentE != null ? alignmentE.name() : null);
        FontStyle fontStyleB = b();
        parcel.writeString(fontStyleB != null ? fontStyleB.name() : null);
    }

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final b a(@NotNull JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            String strOptString = json.optString(g.w);
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            String strB = o.b(strOptString);
            if (strB != null && !StringsKt__StringsJVMKt.startsWith$default(strB, "#", false, 2, null)) {
                strB = "#" + strB;
            }
            String str = strB;
            String strOptString2 = json.optString(g.v);
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            String strB2 = o.b(strOptString2);
            if (strB2 != null && !StringsKt__StringsJVMKt.startsWith$default(strB2, "#", false, 2, null)) {
                strB2 = "#" + strB2;
            }
            String str2 = strB2;
            String strOptString3 = json.optString(g.t);
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            String strB3 = o.b(strOptString3);
            Size sizeA = strB3 != null ? Size.Companion.a(strB3) : null;
            String strOptString4 = json.optString(g.x);
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            String strB4 = o.b(strOptString4);
            Alignment alignmentA = strB4 != null ? Alignment.Companion.a(strB4) : null;
            String strOptString5 = json.optString(g.u);
            Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
            String strB5 = o.b(strOptString5);
            return new b(str, str2, sizeA, alignmentA, strB5 != null ? FontStyle.Companion.a(strB5) : null, null);
        }

        public final JSONObject a(@NotNull Style style) throws JSONException {
            Intrinsics.checkNotNullParameter(style, "style");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(g.w, style.g());
            jSONObject.put(g.v, style.i());
            Size sizeC = style.c();
            jSONObject.put(g.t, sizeC != null ? sizeC.name() : null);
            Alignment alignmentE = style.e();
            jSONObject.put(g.x, alignmentE != null ? alignmentE.name() : null);
            FontStyle fontStyleB = style.b();
            jSONObject.put(g.u, fontStyleB != null ? fontStyleB.name() : null);
            return jSONObject;
        }
    }
}
