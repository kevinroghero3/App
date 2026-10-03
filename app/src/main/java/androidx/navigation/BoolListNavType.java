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
public final class BoolListNavType extends CollectionNavType<List<? extends Boolean>> {
    public BoolListNavType() {
        super(true);
    }

    @Override // androidx.navigation.CollectionNavType
    public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends Boolean> list) {
        return serializeAsValues2((List<Boolean>) list);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "List<Boolean>";
    }

    @Override // androidx.navigation.NavType
    public List<Boolean> parseValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return CollectionsKt__CollectionsJVMKt.listOf(NavType.BoolType.parseValue(value));
    }

    @Override // androidx.navigation.NavType
    public List<Boolean> parseValue(@NotNull String value, @Nullable List<Boolean> list) {
        List<Boolean> listPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (list == null || (listPlus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) parseValue(value))) == null) ? parseValue(value) : listPlus;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(@Nullable List<Boolean> list, @Nullable List<Boolean> list2) {
        return ArraysKt__ArraysKt.contentDeepEquals(list != null ? (Boolean[]) list.toArray(new Boolean[0]) : null, list2 != null ? (Boolean[]) list2.toArray(new Boolean[0]) : null);
    }

    /* JADX INFO: renamed from: serializeAsValues, reason: avoid collision after fix types in other method */
    public List<String> serializeAsValues2(@Nullable List<Boolean> list) {
        if (list != null) {
            List<Boolean> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(String.valueOf(((Boolean) it2.next()).booleanValue()));
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // androidx.navigation.CollectionNavType
    public List<? extends Boolean> emptyCollection() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // androidx.navigation.NavType
    public void put(@NotNull Bundle bundle, @NotNull String key, @Nullable List<Boolean> list) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4111constructorimpl = SavedStateWriter.m4111constructorimpl(bundle);
        if (list != null) {
            SavedStateWriter.m4118putBooleanArrayimpl(bundleM4111constructorimpl, key, CollectionsKt___CollectionsKt.toBooleanArray(list));
        } else {
            SavedStateWriter.m4134putNullimpl(bundleM4111constructorimpl, key);
        }
    }

    @Override // androidx.navigation.NavType
    public List<Boolean> get(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4025constructorimpl = SavedStateReader.m4025constructorimpl(bundle);
        if (!SavedStateReader.m4026containsimpl(bundleM4025constructorimpl, key) || SavedStateReader.m4104isNullimpl(bundleM4025constructorimpl, key)) {
            return null;
        }
        return ArraysKt___ArraysKt.toList(SavedStateReader.m4035getBooleanArrayimpl(bundleM4025constructorimpl, key));
    }
}
