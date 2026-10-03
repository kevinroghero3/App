package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt__ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class FloatListNavType extends CollectionNavType<List<? extends Float>> {
    public FloatListNavType() {
        super(true);
    }

    @Override // androidx.navigation.CollectionNavType
    public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends Float> list) {
        return serializeAsValues2((List<Float>) list);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "List<Float>";
    }

    @Override // androidx.navigation.NavType
    public List<Float> parseValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return CollectionsKt__CollectionsJVMKt.listOf(NavType.FloatType.parseValue(value));
    }

    @Override // androidx.navigation.NavType
    public List<Float> parseValue(@NotNull String value, @Nullable List<Float> list) {
        List<Float> listPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (list == null || (listPlus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) parseValue(value))) == null) ? parseValue(value) : listPlus;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(@Nullable List<Float> list, @Nullable List<Float> list2) {
        return ArraysKt__ArraysKt.contentDeepEquals(list != null ? (Float[]) list.toArray(new Float[0]) : null, list2 != null ? (Float[]) list2.toArray(new Float[0]) : null);
    }

    /* JADX INFO: renamed from: serializeAsValues, reason: avoid collision after fix types in other method */
    public List<String> serializeAsValues2(@Nullable List<Float> list) {
        if (list != null) {
            List<Float> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(String.valueOf(((Number) it2.next()).floatValue()));
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // androidx.navigation.CollectionNavType
    public List<? extends Float> emptyCollection() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // androidx.navigation.NavType
    public void put(@NotNull Bundle bundle, @NotNull String key, @Nullable List<Float> list) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4111constructorimpl = SavedStateWriter.m4111constructorimpl(bundle);
        if (list != null) {
            SavedStateWriter.m4127putFloatArrayimpl(bundleM4111constructorimpl, key, CollectionsKt___CollectionsKt.toFloatArray(list));
        } else {
            SavedStateWriter.m4134putNullimpl(bundleM4111constructorimpl, key);
        }
    }

    @Override // androidx.navigation.NavType
    public List<Float> get(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4025constructorimpl = SavedStateReader.m4025constructorimpl(bundle);
        if (!SavedStateReader.m4026containsimpl(bundleM4025constructorimpl, key) || SavedStateReader.m4104isNullimpl(bundleM4025constructorimpl, key)) {
            return null;
        }
        return ArraysKt___ArraysKt.toList(SavedStateReader.m4053getFloatArrayimpl(bundleM4025constructorimpl, key));
    }
}
