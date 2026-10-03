package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt__ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class StringArrayNavType extends CollectionNavType<String[]> {
    @Override // androidx.navigation.CollectionNavType
    public String[] emptyCollection() {
        return new String[0];
    }

    public StringArrayNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "string[]";
    }

    @Override // androidx.navigation.NavType
    public String[] parseValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new String[]{value};
    }

    @Override // androidx.navigation.NavType
    public String[] parseValue(@NotNull String value, @Nullable String[] strArr) {
        String[] strArr2;
        Intrinsics.checkNotNullParameter(value, "value");
        return (strArr == null || (strArr2 = (String[]) ArraysKt___ArraysJvmKt.plus((Object[]) strArr, (Object[]) parseValue(value))) == null) ? parseValue(value) : strArr2;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(@Nullable String[] strArr, @Nullable String[] strArr2) {
        return ArraysKt__ArraysKt.contentDeepEquals(strArr, strArr2);
    }

    @Override // androidx.navigation.NavType
    public void put(@NotNull Bundle bundle, @NotNull String key, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4111constructorimpl = SavedStateWriter.m4111constructorimpl(bundle);
        if (strArr != null) {
            SavedStateWriter.m4145putStringArrayimpl(bundleM4111constructorimpl, key, strArr);
        } else {
            SavedStateWriter.m4134putNullimpl(bundleM4111constructorimpl, key);
        }
    }

    @Override // androidx.navigation.NavType
    public String[] get(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleM4025constructorimpl = SavedStateReader.m4025constructorimpl(bundle);
        if (!SavedStateReader.m4026containsimpl(bundleM4025constructorimpl, key) || SavedStateReader.m4104isNullimpl(bundleM4025constructorimpl, key)) {
            return null;
        }
        return SavedStateReader.m4097getStringArrayimpl(bundleM4025constructorimpl, key);
    }

    @Override // androidx.navigation.CollectionNavType
    public List<String> serializeAsValues(@Nullable String[] strArr) {
        if (strArr == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(NavUriUtils.encode$default(NavUriUtils.INSTANCE, str, null, 2, null));
        }
        return arrayList;
    }
}
