package com.salesforce.marketingcloud.events;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private final int a;
    private final String b;
    private final a c;
    private final b d;
    private final String e;

    public enum a {
        EQ,
        NEQ,
        LT,
        GT,
        LTEQ,
        GTEQ,
        REGEX;

        private static final /* synthetic */ EnumEntries j = EnumEntriesKt.enumEntries(a());

        public static EnumEntries<a> b() {
            return j;
        }
    }

    public enum b {
        INT,
        DOUBLE,
        BOOL,
        STRING;

        private static final /* synthetic */ EnumEntries g = EnumEntriesKt.enumEntries(a());

        public static EnumEntries<b> b() {
            return g;
        }
    }

    public g(int i, @NotNull String key, @NotNull a operator, @NotNull b valueType, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(valueType, "valueType");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = i;
        this.b = key;
        this.c = operator;
        this.d = valueType;
        this.e = value;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final a c() {
        return this.c;
    }

    public final b d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a == gVar.a && Intrinsics.areEqual(this.b, gVar.b) && this.c == gVar.c && this.d == gVar.d && Intrinsics.areEqual(this.e, gVar.e);
    }

    public final int f() {
        return this.a;
    }

    public final String g() {
        return this.b;
    }

    public final a h() {
        return this.c;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String i() {
        return this.e;
    }

    public final b j() {
        return this.d;
    }

    public final JSONObject k() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FirebaseAnalytics.Param.INDEX, this.a);
        jSONObject.put("key", this.b);
        jSONObject.put("operator", this.c.name());
        jSONObject.put("valueType", this.d.name());
        jSONObject.put("value", this.e);
        return jSONObject;
    }

    public String toString() {
        return "Rule(index=" + this.a + ", key=" + this.b + ", operator=" + this.c + ", valueType=" + this.d + ", value=" + this.e + ")";
    }

    public final g a(int i, @NotNull String key, @NotNull a operator, @NotNull b valueType, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(valueType, "valueType");
        Intrinsics.checkNotNullParameter(value, "value");
        return new g(i, key, operator, valueType, value);
    }

    public static /* synthetic */ g a(g gVar, int i, String str, a aVar, b bVar, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gVar.a;
        }
        if ((i2 & 2) != 0) {
            str = gVar.b;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            aVar = gVar.c;
        }
        a aVar2 = aVar;
        if ((i2 & 8) != 0) {
            bVar = gVar.d;
        }
        b bVar2 = bVar;
        if ((i2 & 16) != 0) {
            str2 = gVar.e;
        }
        return gVar.a(i, str3, aVar2, bVar2, str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public g(@NotNull JSONObject json) throws JSONException {
        Intrinsics.checkNotNullParameter(json, "json");
        int iOptInt = json.optInt(FirebaseAnalytics.Param.INDEX, 0);
        String string = json.getString("key");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = json.getString("operator");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        a aVarValueOf = a.valueOf(string2);
        String string3 = json.getString("valueType");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        b bVarValueOf = b.valueOf(string3);
        String string4 = json.getString("value");
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this(iOptInt, string, aVarValueOf, bVarValueOf, string4);
    }
}
