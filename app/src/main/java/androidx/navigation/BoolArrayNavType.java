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
public final class BoolArrayNavType extends CollectionNavType<boolean[]> {
    @Override // androidx.navigation.CollectionNavType
    public boolean[] emptyCollection() {
        return new boolean[0];
    }

    public BoolArrayNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "boolean[]";
    }

    @Override // androidx.navigation.NavType
    public boolean[] parseValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new boolean[]{NavType.BoolType.parseValue(value).booleanValue()};
    }

    @Override // androidx.navigation.NavType
    public boolean[] parseValue(@NotNull String value, @Nullable boolean[] zArr) {
        boolean[] zArrPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (zArr == null || (zArrPlus = ArraysKt___ArraysJvmKt.plus(zArr, parseValue(value))) == null) ? parseValue(value) : zArrPlus;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(@Nullable boolean[] zArr, @Nullable boolean[] zArr2) {
        return ArraysKt__ArraysKt.contentDeepEquals(zArr != null ? ArraysKt___ArraysJvmKt.toTypedArray(zArr) : null, zArr2 != null ? ArraysKt___ArraysJvmKt.toTypedArray(zArr2) : null);
    }

    @Override // androidx.navigation.CollectionNavType
    public List<String> serializeAsValues(@Nullable boolean[] zArr) {
        List list;
        if (zArr == null || (list = ArraysKt___ArraysKt.toList(zArr)) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList.add(String.valueOf(((Boolean) it2.next()).booleanValue()));
        }
        return arrayList;
    }

    @Override // androidx.navigation.NavType
    public void put(@NotNull Bundle bundle, @NotNull String key, @Nullable boolean[] zArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4111constructorimpl = SavedStateWriter.m4111constructorimpl(bundle);
        if (zArr != null) {
            SavedStateWriter.m4118putBooleanArrayimpl(bundleM4111constructorimpl, key, zArr);
        } else {
            SavedStateWriter.m4134putNullimpl(bundleM4111constructorimpl, key);
        }
    }

    @Override // androidx.navigation.NavType
    public boolean[] get(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4025constructorimpl = SavedStateReader.m4025constructorimpl(bundle);
        if (!SavedStateReader.m4026containsimpl(bundleM4025constructorimpl, key) || SavedStateReader.m4104isNullimpl(bundleM4025constructorimpl, key)) {
            return null;
        }
        return SavedStateReader.m4035getBooleanArrayimpl(bundleM4025constructorimpl, key);
    }
}
