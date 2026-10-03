package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class LongNavType extends NavType<Long> {
    public LongNavType() {
        super(false);
    }

    @Override // androidx.navigation.NavType
    public /* synthetic */ void put(Bundle bundle, String str, Long l) {
        put(bundle, str, l.longValue());
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "long";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.NavType
    public Long parseValue(@NotNull String value) {
        String strSubstring;
        long j;
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt__StringsJVMKt.endsWith$default(value, "L", false, 2, null)) {
            strSubstring = value.substring(0, value.length() - 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        } else {
            strSubstring = value;
        }
        if (StringsKt__StringsJVMKt.startsWith$default(value, "0x", false, 2, null)) {
            String strSubstring2 = strSubstring.substring(2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            j = Long.parseLong(strSubstring2, CharsKt__CharJVMKt.checkRadix(16));
        } else {
            j = Long.parseLong(strSubstring);
        }
        return Long.valueOf(j);
    }

    public void put(@NotNull Bundle bundle, @NotNull String key, long j) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        SavedStateWriter.m4132putLongimpl(SavedStateWriter.m4111constructorimpl(bundle), key, j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.NavType
    public Long get(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return Long.valueOf(SavedStateReader.m4066getLongimpl(SavedStateReader.m4025constructorimpl(bundle), key));
    }
}
