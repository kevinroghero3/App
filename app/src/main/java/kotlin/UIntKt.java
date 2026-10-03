package kotlin;

/* JADX INFO: loaded from: classes6.dex */
public final class UIntKt {
    private static final int toUInt(byte b) {
        return UInt.m5567constructorimpl(b);
    }

    private static final int toUInt(short s) {
        return UInt.m5567constructorimpl(s);
    }

    private static final int toUInt(int i) {
        return UInt.m5567constructorimpl(i);
    }

    private static final int toUInt(long j) {
        return UInt.m5567constructorimpl((int) j);
    }

    private static final int toUInt(float f) {
        return UnsignedKt.doubleToUInt(f);
    }

    private static final int toUInt(double d) {
        return UnsignedKt.doubleToUInt(d);
    }
}
