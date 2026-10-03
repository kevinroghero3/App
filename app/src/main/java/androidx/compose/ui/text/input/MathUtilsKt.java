package androidx.compose.ui.text.input;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class MathUtilsKt {
    public static final int addExactOrElse(int i, int i2, @NotNull Function0<Integer> function0) {
        int i3 = i + i2;
        return ((i ^ i3) & (i2 ^ i3)) < 0 ? function0.invoke().intValue() : i3;
    }

    public static final int subtractExactOrElse(int i, int i2, @NotNull Function0<Integer> function0) {
        int i3 = i - i2;
        return ((i ^ i2) & (i ^ i3)) < 0 ? function0.invoke().intValue() : i3;
    }
}
