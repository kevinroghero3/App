package com.salesforce.marketingcloud.push.buttons;

import com.salesforce.marketingcloud.push.data.Template;
import com.salesforce.marketingcloud.push.e;
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

/* JADX INFO: loaded from: classes3.dex */
public final class RichButtonsParser implements j<a> {
    @Override // com.salesforce.marketingcloud.push.j
    public String hydrate(@NotNull Template obj) throws m {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (!(obj instanceof a)) {
            throw new m("obj is not a RichButtonTemplate");
        }
        List<a.c> listK = ((a) obj).k();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listK, 10));
        Iterator<T> it2 = listK.iterator();
        while (it2.hasNext()) {
            arrayList.add(((a.c) it2.next()).q());
        }
        String string = new JSONArray((Collection) arrayList).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.salesforce.marketingcloud.push.j
    public a parse(@NotNull String obj) throws JSONException, e, m {
        Intrinsics.checkNotNullParameter(obj, "obj");
        List<a.c> listA = b.a(new JSONArray(obj));
        if (listA.isEmpty()) {
            throw new m("Button is empty");
        }
        return new a(listA, null, 2, 0 == true ? 1 : 0);
    }
}
