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
public final class IntArrayNavType extends CollectionNavType<int[]> {
    @Override // androidx.navigation.CollectionNavType
    public int[] emptyCollection() {
        return new int[0];
    }

    public IntArrayNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "integer[]";
    }

    @Override // androidx.navigation.NavType
    public int[] parseValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new int[]{NavType.IntType.parseValue(value).intValue()};
    }

    @Override // androidx.navigation.NavType
    public int[] parseValue(@NotNull String value, @Nullable int[] iArr) {
        int[] iArrPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (iArr == null || (iArrPlus = ArraysKt___ArraysJvmKt.plus(iArr, parseValue(value))) == null) ? parseValue(value) : iArrPlus;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(@Nullable int[] iArr, @Nullable int[] iArr2) {
        return ArraysKt__ArraysKt.contentDeepEquals(iArr != null ? ArraysKt___ArraysJvmKt.toTypedArray(iArr) : null, iArr2 != null ? ArraysKt___ArraysJvmKt.toTypedArray(iArr2) : null);
    }

    @Override // androidx.navigation.CollectionNavType
    public List<String> serializeAsValues(@Nullable int[] iArr) {
        List list;
        if (iArr == null || (list = ArraysKt___ArraysKt.toList(iArr)) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList.add(String.valueOf(((Number) it2.next()).intValue()));
        }
        return arrayList;
    }

    @Override // androidx.navigation.NavType
    public void put(@NotNull Bundle bundle, @NotNull String key, @Nullable int[] iArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4111constructorimpl = SavedStateWriter.m4111constructorimpl(bundle);
        if (iArr != null) {
            SavedStateWriter.m4129putIntArrayimpl(bundleM4111constructorimpl, key, iArr);
        } else {
            SavedStateWriter.m4134putNullimpl(bundleM4111constructorimpl, key);
        }
    }

    @Override // androidx.navigation.NavType
    public int[] get(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4025constructorimpl = SavedStateReader.m4025constructorimpl(bundle);
        if (!SavedStateReader.m4026containsimpl(bundleM4025constructorimpl, key) || SavedStateReader.m4104isNullimpl(bundleM4025constructorimpl, key)) {
            return null;
        }
        return SavedStateReader.m4057getIntArrayimpl(bundleM4025constructorimpl, key);
    }
}
