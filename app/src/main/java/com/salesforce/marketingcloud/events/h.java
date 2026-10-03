package com.salesforce.marketingcloud.events;

import com.salesforce.marketingcloud.extensions.PushExtensionsKt;
import com.salesforce.marketingcloud.internal.o;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private final String a;
    private final String b;
    private final Date c;
    private final List<g> d;
    private final List<e> e;
    private String f;

    public h(@NotNull String id, @NotNull String key, @Nullable Date date, @Nullable List<g> list, @NotNull List<e> outcomes, @Nullable String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(outcomes, "outcomes");
        this.a = id;
        this.b = key;
        this.c = date;
        this.d = list;
        this.e = outcomes;
        this.f = str;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final Date c() {
        return this.c;
    }

    public final List<g> d() {
        return this.d;
    }

    public final List<e> e() {
        return this.e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.a, hVar.a) && Intrinsics.areEqual(this.b, hVar.b) && Intrinsics.areEqual(this.c, hVar.c) && Intrinsics.areEqual(this.d, hVar.d) && Intrinsics.areEqual(this.e, hVar.e) && Intrinsics.areEqual(this.f, hVar.f);
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.f;
    }

    public final String h() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode();
        int iHashCode2 = this.b.hashCode();
        Date date = this.c;
        int iHashCode3 = date == null ? 0 : date.hashCode();
        List<g> list = this.d;
        int iHashCode4 = list == null ? 0 : list.hashCode();
        int iHashCode5 = this.e.hashCode();
        String str = this.f;
        return (((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String i() {
        return this.b;
    }

    public final List<e> j() {
        return this.e;
    }

    public final List<g> k() {
        return this.d;
    }

    public final Date l() {
        return this.c;
    }

    public final JSONObject m() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.a);
        jSONObject.put("key", this.b);
        Date date = this.c;
        if (date != null) {
            jSONObject.put("startDateUtc", o.a(date));
        }
        List<g> list = this.d;
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                jSONArray.put(((g) it2.next()).k());
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put("rules", jSONArray);
        }
        JSONArray jSONArray2 = new JSONArray();
        Iterator<T> it3 = this.e.iterator();
        while (it3.hasNext()) {
            jSONArray2.put(((e) it3.next()).g());
        }
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("outcomes", jSONArray2);
        String str = this.f;
        if (str != null) {
            jSONObject.put("evalLogic", str);
        }
        return jSONObject;
    }

    public String toString() {
        return "Trigger(id=" + this.a + ", key=" + this.b + ", startDateUtc=" + this.c + ", rules=" + this.d + ", outcomes=" + this.e + ", evalLogic=" + this.f + ")";
    }

    public final h a(@NotNull String id, @NotNull String key, @Nullable Date date, @Nullable List<g> list, @NotNull List<e> outcomes, @Nullable String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(outcomes, "outcomes");
        return new h(id, key, date, list, outcomes, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ h a(h hVar, String str, String str2, Date date, List list, List list2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hVar.a;
        }
        if ((i & 2) != 0) {
            str2 = hVar.b;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            date = hVar.c;
        }
        Date date2 = date;
        if ((i & 8) != 0) {
            list = hVar.d;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = hVar.e;
        }
        List list4 = list2;
        if ((i & 32) != 0) {
            str3 = hVar.f;
        }
        return hVar.a(str, str4, date2, list3, list4, str3);
    }

    public final void a(@Nullable String str) {
        this.f = str;
    }

    public /* synthetic */ h(String str, String str2, Date date, List list, List list2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : date, (i & 8) != 0 ? null : list, list2, (i & 32) != 0 ? null : str3);
    }

    public h(@NotNull JSONObject json) throws JSONException {
        ArrayList arrayList;
        String strReplace$default;
        e eVar;
        JSONObject jSONObject;
        g gVar;
        JSONObject jSONObject2;
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = json.getString("key");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String strOptString = json.optString("startDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strB = o.b(strOptString);
        Date dateA = strB != null ? o.a(strB) : null;
        JSONArray jSONArrayOptJSONArray = json.optJSONArray("rules");
        if (jSONArrayOptJSONArray != null) {
            IntRange intRangeUntil = RangesKt___RangesKt.until(0, jSONArrayOptJSONArray.length());
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                int iNextInt = ((IntIterator) it2).nextInt();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    jSONObject2 = jSONArrayOptJSONArray.getJSONObject(iNextInt);
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jSONObject2 = (JSONObject) Integer.valueOf(jSONArrayOptJSONArray.getInt(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jSONObject2 = (JSONObject) Double.valueOf(jSONArrayOptJSONArray.getDouble(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jSONObject2 = (JSONObject) Long.valueOf(jSONArrayOptJSONArray.getLong(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jSONObject2 = (JSONObject) Boolean.valueOf(jSONArrayOptJSONArray.getBoolean(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object string3 = jSONArrayOptJSONArray.getString(iNextInt);
                    if (string3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject2 = (JSONObject) string3;
                } else {
                    Object obj = jSONArrayOptJSONArray.get(iNextInt);
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject2 = (JSONObject) obj;
                }
                arrayList2.add(jSONObject2);
            }
            arrayList = new ArrayList();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                try {
                    gVar = new g((JSONObject) it3.next());
                } catch (Exception unused) {
                    gVar = null;
                }
                if (gVar != null) {
                    arrayList.add(gVar);
                }
            }
        } else {
            arrayList = null;
        }
        JSONArray jSONArray = json.getJSONArray("outcomes");
        Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
        IntRange intRangeUntil2 = RangesKt___RangesKt.until(0, jSONArray.length());
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil2, 10));
        Iterator<Integer> it4 = intRangeUntil2.iterator();
        while (it4.hasNext()) {
            int iNextInt2 = ((IntIterator) it4).nextInt();
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JSONObject.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                jSONObject = jSONArray.getJSONObject(iNextInt2);
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                jSONObject = (JSONObject) Integer.valueOf(jSONArray.getInt(iNextInt2));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jSONObject = (JSONObject) Double.valueOf(jSONArray.getDouble(iNextInt2));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jSONObject = (JSONObject) Long.valueOf(jSONArray.getLong(iNextInt2));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jSONObject = (JSONObject) Boolean.valueOf(jSONArray.getBoolean(iNextInt2));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object string4 = jSONArray.getString(iNextInt2);
                if (string4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) string4;
            } else {
                Object obj2 = jSONArray.get(iNextInt2);
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) obj2;
            }
            arrayList3.add(jSONObject);
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            try {
                eVar = new e((JSONObject) it5.next());
            } catch (Exception unused2) {
                eVar = null;
            }
            if (eVar != null) {
                arrayList4.add(eVar);
            }
        }
        String stringOrNull = PushExtensionsKt.getStringOrNull(json, "evalLogic");
        if (stringOrNull != null) {
            List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) stringOrNull, new String[]{"&&"}, false, 0, 6, (Object) null);
            List listSplit$default2 = StringsKt__StringsKt.split$default((CharSequence) stringOrNull, new String[]{"||"}, false, 0, 6, (Object) null);
            if (!StringsKt__StringsKt.isBlank(stringOrNull)) {
                boolean z = true;
                if (listSplit$default.size() <= 1 || listSplit$default2.size() <= 1) {
                    ArrayList arrayList5 = new ArrayList();
                    if (listSplit$default.size() > 1) {
                        arrayList5.addAll(listSplit$default);
                    } else {
                        arrayList5.addAll(listSplit$default2);
                    }
                    Iterator it6 = arrayList5.iterator();
                    while (it6.hasNext()) {
                        String string5 = StringsKt__StringsKt.trim((CharSequence) it6.next()).toString();
                        if (StringsKt__StringsKt.isBlank(string5) || StringsKt__StringNumberConversionsKt.toLongOrNull(string5) == null || Long.parseLong(string5) < 0) {
                            z = false;
                        }
                    }
                    if (z) {
                        strReplace$default = StringsKt__StringsJVMKt.replace$default(stringOrNull, StringUtils.SPACE, "", false, 4, (Object) null);
                    } else {
                        throw new IllegalArgumentException("evalLogic contained non-numeric indexes.");
                    }
                }
            }
            throw new IllegalArgumentException("evalLogic was blank or contained both && and || operators");
        }
        strReplace$default = null;
        this(string, string2, dateA, arrayList, arrayList4, strReplace$default);
    }
}
