package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt__ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LongArrayNavType extends CollectionNavType<long[]> {
    @Override // androidx.navigation.CollectionNavType
    public long[] emptyCollection() {
        return new long[0];
    }

    public LongArrayNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "long[]";
    }

    @Override // androidx.navigation.NavType
    public long[] parseValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new long[]{NavType.LongType.parseValue(value).longValue()};
    }

    @Override // androidx.navigation.NavType
    public long[] parseValue(@NotNull String value, @Nullable long[] jArr) {
        long[] jArrPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (jArr == null || (jArrPlus = ArraysKt___ArraysJvmKt.plus(jArr, parseValue(value))) == null) ? parseValue(value) : jArrPlus;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(@Nullable long[] jArr, @Nullable long[] jArr2) {
        return ArraysKt__ArraysKt.contentDeepEquals(jArr != null ? ArraysKt___ArraysJvmKt.toTypedArray(jArr) : null, jArr2 != null ? ArraysKt___ArraysJvmKt.toTypedArray(jArr2) : null);
    }

    @Override // androidx.navigation.CollectionNavType
    public List<String> serializeAsValues(@Nullable long[] jArr) {
        List list;
        if (jArr == null || (list = ArraysKt___ArraysKt.toList(jArr)) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList.add(String.valueOf(((Number) it2.next()).longValue()));
        }
        return arrayList;
    }

    @Override // androidx.navigation.NavType
    public void put(@NotNull Bundle bundle, @NotNull String key, @Nullable long[] jArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4111constructorimpl = SavedStateWriter.m4111constructorimpl(bundle);
        if (jArr != null) {
            SavedStateWriter.m4133putLongArrayimpl(bundleM4111constructorimpl, key, jArr);
        } else {
            SavedStateWriter.m4134putNullimpl(bundleM4111constructorimpl, key);
        }
    }

    @Override // androidx.navigation.NavType
    public long[] get(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4025constructorimpl = SavedStateReader.m4025constructorimpl(bundle);
        if (!SavedStateReader.m4026containsimpl(bundleM4025constructorimpl, key) || SavedStateReader.m4104isNullimpl(bundleM4025constructorimpl, key)) {
            return null;
        }
        return SavedStateReader.m4067getLongArrayimpl(bundleM4025constructorimpl, key);
    }
}
