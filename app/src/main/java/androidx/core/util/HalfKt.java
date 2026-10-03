package androidx.core.util;

import android.util.Half;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class HalfKt {
    public static final Half toHalf(short s) {
        return Half.valueOf(s);
    }

    public static final Half toHalf(float f) {
        return Half.valueOf(f);
    }

    public static final Half toHalf(@NotNull String str) {
        return Half.valueOf(str);
    }

    public static final Half toHalf(double d) {
        return Half.valueOf((float) d);
    }
}
