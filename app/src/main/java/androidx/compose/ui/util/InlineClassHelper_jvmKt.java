package androidx.compose.ui.util;

/* JADX INFO: loaded from: classes4.dex */
public final class InlineClassHelper_jvmKt {
    public static final float floatFromBits(int i) {
        return Float.intBitsToFloat(i);
    }

    public static final double doubleFromBits(long j) {
        return Double.longBitsToDouble(j);
    }

    public static final int fastRoundToInt(float f) {
        return Math.round(f);
    }

    public static final int fastRoundToInt(double d) {
        return (int) Math.round(d);
    }
}
