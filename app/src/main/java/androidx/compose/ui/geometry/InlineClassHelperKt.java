package androidx.compose.ui.geometry;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class InlineClassHelperKt {
    public static final long DualFirstNaN = 9187343246269874177L;
    public static final long DualFloatInfinityBase = 9187343241974906880L;
    public static final long DualFloatSignBit = -9223372034707292160L;
    public static final long DualUnsignedFloatMask = 9223372034707292159L;
    public static final long FloatInfinityBase = 2139095040;
    public static final long Uint64High32 = -9223372034707292160L;
    public static final long Uint64Low32 = 4294967297L;
    public static final long UnspecifiedPackedFloats = 9205357640488583168L;

    public static final void throwIllegalStateException(@NotNull String str) {
        throw new IllegalStateException(str);
    }

    public static final void checkPrecondition(boolean z, @NotNull Function0<String> function0) {
        if (z) {
            return;
        }
        throwIllegalStateException(function0.invoke());
    }
}
