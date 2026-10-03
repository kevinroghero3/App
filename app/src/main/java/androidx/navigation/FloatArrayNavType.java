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
public final class FloatArrayNavType extends CollectionNavType<float[]> {
    @Override // androidx.navigation.CollectionNavType
    public float[] emptyCollection() {
        return new float[0];
    }

    public FloatArrayNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "float[]";
    }

    @Override // androidx.navigation.NavType
    public float[] parseValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new float[]{NavType.FloatType.parseValue(value).floatValue()};
    }

    @Override // androidx.navigation.NavType
    public float[] parseValue(@NotNull String value, @Nullable float[] fArr) {
        float[] fArrPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (fArr == null || (fArrPlus = ArraysKt___ArraysJvmKt.plus(fArr, parseValue(value))) == null) ? parseValue(value) : fArrPlus;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(@Nullable float[] fArr, @Nullable float[] fArr2) {
        return ArraysKt__ArraysKt.contentDeepEquals(fArr != null ? ArraysKt___ArraysJvmKt.toTypedArray(fArr) : null, fArr2 != null ? ArraysKt___ArraysJvmKt.toTypedArray(fArr2) : null);
    }

    @Override // androidx.navigation.CollectionNavType
    public List<String> serializeAsValues(@Nullable float[] fArr) {
        List list;
        if (fArr == null || (list = ArraysKt___ArraysKt.toList(fArr)) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList.add(String.valueOf(((Number) it2.next()).floatValue()));
        }
        return arrayList;
    }

    @Override // androidx.navigation.NavType
    public void put(@NotNull Bundle bundle, @NotNull String key, @Nullable float[] fArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4111constructorimpl = SavedStateWriter.m4111constructorimpl(bundle);
        if (fArr != null) {
            SavedStateWriter.m4127putFloatArrayimpl(bundleM4111constructorimpl, key, fArr);
        } else {
            SavedStateWriter.m4134putNullimpl(bundleM4111constructorimpl, key);
        }
    }

    @Override // androidx.navigation.NavType
    public float[] get(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4025constructorimpl = SavedStateReader.m4025constructorimpl(bundle);
        if (!SavedStateReader.m4026containsimpl(bundleM4025constructorimpl, key) || SavedStateReader.m4104isNullimpl(bundleM4025constructorimpl, key)) {
            return null;
        }
        return SavedStateReader.m4053getFloatArrayimpl(bundleM4025constructorimpl, key);
    }
}
