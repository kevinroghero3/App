package com.salesforce.marketingcloud.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class CompressionUtility {
    public static final CompressionUtility INSTANCE = new CompressionUtility();
    private static final a compressionStrategy = a.C0078a.a;

    private CompressionUtility() {
    }

    public final Map<String, String> decompress(@NotNull Map<String, String> input) throws com.salesforce.marketingcloud.push.c {
        String strSubstring;
        Intrinsics.checkNotNullParameter(input, "input");
        Set<Map.Entry<String, String>> setEntrySet = input.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it2 = setEntrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            String str = (String) entry.getKey();
            String strA = (String) entry.getValue();
            if (StringsKt__StringsJVMKt.startsWith(str, "$", true)) {
                strSubstring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            } else {
                strSubstring = str;
            }
            if (StringsKt__StringsJVMKt.startsWith(str, "$", true)) {
                strA = compressionStrategy.a(strA);
            }
            Pair pair = TuplesKt.to(strSubstring, strA);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
