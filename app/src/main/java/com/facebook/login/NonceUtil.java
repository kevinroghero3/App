package com.facebook.login;

import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class NonceUtil {
    public static final NonceUtil INSTANCE = new NonceUtil();

    private NonceUtil() {
    }

    @JvmStatic
    public static final boolean isValidNonce(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return !(StringsKt__StringsKt.indexOf$default((CharSequence) str, ' ', 0, false, 6, (Object) null) >= 0);
    }
}
