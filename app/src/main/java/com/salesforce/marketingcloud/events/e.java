package com.salesforce.marketingcloud.events;

import com.salesforce.marketingcloud.internal.o;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private final String a;
    private final String b;
    private final String c;

    public e(@NotNull String id, @Nullable String str, @NotNull String type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = id;
        this.b = str;
        this.c = type;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual(this.a, eVar.a) && Intrinsics.areEqual(this.b, eVar.b) && Intrinsics.areEqual(this.c, eVar.c);
    }

    public final String f() {
        return this.c;
    }

    public final JSONObject g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.a);
        String str = this.b;
        if (str != null) {
            jSONObject.put("activityInstanceId", str);
        }
        jSONObject.put("type", this.c);
        return jSONObject;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode();
        String str = this.b;
        return (((iHashCode * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Outcome(id=" + this.a + ", activityInstanceId=" + this.b + ", type=" + this.c + ")";
    }

    public final e a(@NotNull String id, @Nullable String str, @NotNull String type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new e(id, str, type);
    }

    public static /* synthetic */ e a(e eVar, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eVar.a;
        }
        if ((i & 2) != 0) {
            str2 = eVar.b;
        }
        if ((i & 4) != 0) {
            str3 = eVar.c;
        }
        return eVar.a(str, str2, str3);
    }

    public /* synthetic */ e(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, str3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e(@NotNull JSONObject json) throws JSONException {
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String strOptString = json.optString("activityInstanceId");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strB = o.b(strOptString);
        String string2 = json.getString("type");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this(string, strB, string2);
    }
}
