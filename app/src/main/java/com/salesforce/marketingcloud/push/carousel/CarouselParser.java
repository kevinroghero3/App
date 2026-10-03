package com.salesforce.marketingcloud.push.carousel;

import com.salesforce.marketingcloud.push.data.Style;
import com.salesforce.marketingcloud.push.data.Template;
import com.salesforce.marketingcloud.push.e;
import com.salesforce.marketingcloud.push.g;
import com.salesforce.marketingcloud.push.j;
import com.salesforce.marketingcloud.push.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class CarouselParser implements j<a> {
    @Override // com.salesforce.marketingcloud.push.j
    public String hydrate(@NotNull Template obj) throws JSONException, m {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (!(obj instanceof a)) {
            throw new m("Carousel is not a CarouselFullTemplate");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(g.g, obj.f().getValue());
        Style styleA = obj.a();
        if (styleA != null) {
            jSONObject.put(g.k, Style.a.a(styleA));
        }
        List<a.C0095a> listL = ((a) obj).l();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listL, 10));
        Iterator<T> it2 = listL.iterator();
        while (it2.hasNext()) {
            arrayList.add(((a.C0095a) it2.next()).s());
        }
        jSONObject.put(g.h, new JSONArray((Collection) arrayList));
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.salesforce.marketingcloud.push.j
    public a parse(@NotNull String obj) throws JSONException, e, m {
        Style.b bVarA;
        Intrinsics.checkNotNullParameter(obj, "obj");
        JSONObject jSONObject = new JSONObject(obj);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(g.h);
        if (jSONArrayOptJSONArray == null) {
            throw new e(g.h);
        }
        List<a.C0095a> listA = c.a(jSONArrayOptJSONArray);
        if (listA.isEmpty()) {
            throw new m("Carousel is empty");
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(g.k);
        if (jSONObjectOptJSONObject != null) {
            Intrinsics.checkNotNull(jSONObjectOptJSONObject);
            bVarA = Style.a.a(jSONObjectOptJSONObject);
        } else {
            bVarA = null;
        }
        return new a(listA, 0, bVarA, 2, null);
    }
}
