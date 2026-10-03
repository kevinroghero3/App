package com.salesforce.marketingcloud.push.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.o;
import com.salesforce.marketingcloud.push.j;
import com.salesforce.marketingcloud.push.m;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class RichFeatures implements Parcelable {
    private final com.salesforce.marketingcloud.push.buttons.a buttons;
    private final String largeIcon;
    private final String smallIcon;
    private final Template viewTemplate;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<RichFeatures> CREATOR = new b();
    private static final String TAG = g.a("RichFeatures");

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0046  */
        @JvmStatic
        public final RichFeatures a(@NotNull String json) throws com.salesforce.marketingcloud.push.d {
            Template template;
            j<?> jVarA;
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONObject jSONObject = new JSONObject(json);
                String strOptString = jSONObject.optString(com.salesforce.marketingcloud.push.g.b);
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String strB = o.b(strOptString);
                String strOptString2 = jSONObject.optString(com.salesforce.marketingcloud.push.g.c);
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                String strB2 = o.b(strOptString2);
                Object objOpt = jSONObject.opt(com.salesforce.marketingcloud.push.g.d);
                Template template2 = null;
                if (objOpt != null) {
                    j<?> jVarA2 = j.a.a.a(RichFeatures.Companion.a(objOpt));
                    if (jVarA2 != null) {
                        template = jVarA2.parse(objOpt.toString());
                    } else {
                        template = null;
                    }
                } else {
                    template = null;
                }
                Object objOpt2 = jSONObject.opt(com.salesforce.marketingcloud.push.g.f);
                if (objOpt2 != null && (jVarA = j.a.a.a(Template.Type.RichButtons)) != null) {
                    template2 = jVarA.parse(objOpt2.toString());
                }
                return new RichFeatures(strB, strB2, template, (com.salesforce.marketingcloud.push.buttons.a) template2);
            } catch (JSONException e) {
                throw new com.salesforce.marketingcloud.push.d(e.toString());
            }
        }

        private a() {
        }

        public final Template.Type a(@Nullable Object obj) throws m {
            if (obj instanceof JSONObject) {
                String strOptString = ((JSONObject) obj).optString(com.salesforce.marketingcloud.push.g.g);
                Template.Type type = Template.Type.CarouselFull;
                if (Intrinsics.areEqual(strOptString, type.getValue())) {
                    return type;
                }
                throw new m(strOptString);
            }
            throw new m(String.valueOf(obj));
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class b implements Parcelable.Creator<RichFeatures> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RichFeatures createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RichFeatures(parcel.readString(), parcel.readString(), (Template) parcel.readParcelable(RichFeatures.class.getClassLoader()), parcel.readInt() == 0 ? null : com.salesforce.marketingcloud.push.buttons.a.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RichFeatures[] newArray(int i) {
            return new RichFeatures[i];
        }
    }

    static final class c extends Lambda implements Function0<String> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to serialize " + RichFeatures.this;
        }
    }

    public RichFeatures() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RichFeatures copy$default(RichFeatures richFeatures, String str, String str2, Template template, com.salesforce.marketingcloud.push.buttons.a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = richFeatures.largeIcon;
        }
        if ((i & 2) != 0) {
            str2 = richFeatures.smallIcon;
        }
        if ((i & 4) != 0) {
            template = richFeatures.viewTemplate;
        }
        if ((i & 8) != 0) {
            aVar = richFeatures.buttons;
        }
        return richFeatures.copy(str, str2, template, aVar);
    }

    @JvmStatic
    public static final RichFeatures fromJson(@NotNull String str) {
        return Companion.a(str);
    }

    public final String component1() {
        return this.largeIcon;
    }

    public final String component2() {
        return this.smallIcon;
    }

    public final Template component3() {
        return this.viewTemplate;
    }

    public final com.salesforce.marketingcloud.push.buttons.a component4() {
        return this.buttons;
    }

    public final RichFeatures copy(@Nullable String str, @Nullable String str2, @Nullable Template template, @Nullable com.salesforce.marketingcloud.push.buttons.a aVar) {
        return new RichFeatures(str, str2, template, aVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RichFeatures)) {
            return false;
        }
        RichFeatures richFeatures = (RichFeatures) obj;
        return Intrinsics.areEqual(this.largeIcon, richFeatures.largeIcon) && Intrinsics.areEqual(this.smallIcon, richFeatures.smallIcon) && Intrinsics.areEqual(this.viewTemplate, richFeatures.viewTemplate) && Intrinsics.areEqual(this.buttons, richFeatures.buttons);
    }

    public final com.salesforce.marketingcloud.push.buttons.a getButtons() {
        return this.buttons;
    }

    public final String getLargeIcon() {
        return this.largeIcon;
    }

    public final String getSmallIcon() {
        return this.smallIcon;
    }

    public final Template getViewTemplate() {
        return this.viewTemplate;
    }

    public int hashCode() {
        String str = this.largeIcon;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.smallIcon;
        int iHashCode2 = str2 == null ? 0 : str2.hashCode();
        Template template = this.viewTemplate;
        int iHashCode3 = template == null ? 0 : template.hashCode();
        com.salesforce.marketingcloud.push.buttons.a aVar = this.buttons;
        return (((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (aVar != null ? aVar.hashCode() : 0);
    }

    public final String toJson() {
        Template.Type typeF;
        j<?> jVarA;
        String strHydrate;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.salesforce.marketingcloud.push.g.b, this.largeIcon);
            jSONObject.put(com.salesforce.marketingcloud.push.g.c, this.smallIcon);
            Template template = this.viewTemplate;
            if (template != null && (typeF = template.f()) != null && (jVarA = j.a.a.a(typeF)) != null && (strHydrate = jVarA.hydrate(this.viewTemplate)) != null) {
                jSONObject.put(com.salesforce.marketingcloud.push.g.d, new JSONObject(strHydrate));
            }
            com.salesforce.marketingcloud.push.buttons.a aVar = this.buttons;
            if (aVar != null) {
                j<?> jVarA2 = j.a.a.a(Template.Type.RichButtons);
                jSONObject.put(com.salesforce.marketingcloud.push.g.f, new JSONArray(jVarA2 != null ? jVarA2.hydrate(aVar) : null));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            g.a.b(TAG, e, new c());
            return null;
        }
    }

    public String toString() {
        return "RichFeatures(largeIcon=" + this.largeIcon + ", smallIcon=" + this.smallIcon + ", viewTemplate=" + this.viewTemplate + ", buttons=" + this.buttons + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.largeIcon);
        out.writeString(this.smallIcon);
        out.writeParcelable(this.viewTemplate, i);
        com.salesforce.marketingcloud.push.buttons.a aVar = this.buttons;
        if (aVar == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            aVar.writeToParcel(out, i);
        }
    }

    public RichFeatures(@Nullable String str, @Nullable String str2, @Nullable Template template, @Nullable com.salesforce.marketingcloud.push.buttons.a aVar) {
        this.largeIcon = str;
        this.smallIcon = str2;
        this.viewTemplate = template;
        this.buttons = aVar;
    }

    public /* synthetic */ RichFeatures(String str, String str2, Template template, com.salesforce.marketingcloud.push.buttons.a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : template, (i & 8) != 0 ? null : aVar);
    }
}
