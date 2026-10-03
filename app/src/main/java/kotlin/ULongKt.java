package kotlin;

/* JADX INFO: loaded from: classes6.dex */
public final class ULongKt {
    private static final long toULong(byte b) {
        return ULong.m5646constructorimpl(b);
    }

    private static final long toULong(short s) {
        return ULong.m5646constructorimpl(s);
    }

    private static final long toULong(int i) {
        return ULong.m5646constructorimpl(i);
    }

    private static final long toULong(long j) {
        return ULong.m5646constructorimpl(j);
    }

    private static final long toULong(float f) {
        return UnsignedKt.doubleToULong(f);
    }

    private static final long toULong(double d) {
        return UnsignedKt.doubleToULong(d);
    }
}
