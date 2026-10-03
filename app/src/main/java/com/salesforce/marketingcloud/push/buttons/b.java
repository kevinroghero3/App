package com.salesforce.marketingcloud.push.buttons;

import com.salesforce.marketingcloud.internal.o;
import com.salesforce.marketingcloud.push.data.Style;
import com.salesforce.marketingcloud.push.e;
import com.salesforce.marketingcloud.push.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final List<a.c> a(@NotNull JSONArray jSONArray) throws JSONException, e {
        com.salesforce.marketingcloud.push.data.c cVarA;
        Style.b bVarA;
        ArrayList arrayList;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        IntRange intRangeUntil = RangesKt___RangesKt.until(0, jSONArray.length());
        ArrayList<JSONObject> arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it2 = intRangeUntil.iterator();
        while (it2.hasNext()) {
            int iNextInt = ((IntIterator) it2).nextInt();
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                jSONObject2 = jSONArray.getJSONObject(iNextInt);
                if (jSONObject2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                jSONObject2 = (JSONObject) Integer.valueOf(jSONArray.getInt(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jSONObject2 = (JSONObject) Double.valueOf(jSONArray.getDouble(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jSONObject2 = (JSONObject) Long.valueOf(jSONArray.getLong(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jSONObject2 = (JSONObject) Boolean.valueOf(jSONArray.getBoolean(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object string = jSONArray.getString(iNextInt);
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject2 = (JSONObject) string;
            } else {
                Object obj = jSONArray.get(iNextInt);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject2 = (JSONObject) obj;
            }
            arrayList2.add(jSONObject2);
        }
        ArrayList arrayList3 = new ArrayList();
        for (JSONObject jSONObject3 : arrayList2) {
            String strOptString = jSONObject3.optString("id");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            String strB = o.b(strOptString);
            if (strB == null) {
                throw new e("id");
            }
            String strOptString2 = jSONObject3.optString(g.s);
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            String strB2 = o.b(strOptString2);
            JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject(g.f81n);
            if (jSONObjectOptJSONObject != null) {
                Intrinsics.checkNotNull(jSONObjectOptJSONObject);
                cVarA = com.salesforce.marketingcloud.push.data.c.e.a(jSONObjectOptJSONObject);
            } else {
                cVarA = null;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject(g.k);
            if (jSONObjectOptJSONObject2 != null) {
                Intrinsics.checkNotNull(jSONObjectOptJSONObject2);
                bVarA = Style.a.a(jSONObjectOptJSONObject2);
            } else {
                bVarA = null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray(g.l);
            if (jSONArrayOptJSONArray != null) {
                IntRange intRangeUntil2 = RangesKt___RangesKt.until(0, jSONArrayOptJSONArray.length());
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil2, 10));
                Iterator<Integer> it3 = intRangeUntil2.iterator();
                while (it3.hasNext()) {
                    int iNextInt2 = ((IntIterator) it3).nextInt();
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JSONObject.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                        jSONObject = jSONArrayOptJSONArray.getJSONObject(iNextInt2);
                        if (jSONObject == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        jSONObject = (JSONObject) Integer.valueOf(jSONArrayOptJSONArray.getInt(iNextInt2));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jSONObject = (JSONObject) Double.valueOf(jSONArrayOptJSONArray.getDouble(iNextInt2));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jSONObject = (JSONObject) Long.valueOf(jSONArrayOptJSONArray.getLong(iNextInt2));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jSONObject = (JSONObject) Boolean.valueOf(jSONArrayOptJSONArray.getBoolean(iNextInt2));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object string2 = jSONArrayOptJSONArray.getString(iNextInt2);
                        if (string2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        jSONObject = (JSONObject) string2;
                    } else {
                        Object obj2 = jSONArrayOptJSONArray.get(iNextInt2);
                        if (obj2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        jSONObject = (JSONObject) obj2;
                    }
                    arrayList4.add(jSONObject);
                }
                ArrayList arrayList5 = new ArrayList();
                Iterator it4 = arrayList4.iterator();
                while (it4.hasNext()) {
                    com.salesforce.marketingcloud.push.data.a aVarA = com.salesforce.marketingcloud.push.data.a.c.a((JSONObject) it4.next());
                    if (aVarA != null) {
                        arrayList5.add(aVarA);
                    }
                }
                arrayList = arrayList5;
            } else {
                arrayList = null;
            }
            arrayList3.add(new a.c(strB, cVarA, strB2, bVarA, arrayList));
        }
        return arrayList3;
    }
}
