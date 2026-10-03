package androidx.compose.ui.text.android;

/* JADX INFO: loaded from: classes4.dex */
public final class InlineClassUtils_androidKt {
    public static final long packInts(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    public static final int unpackInt1(long j) {
        return (int) (j >> 32);
    }

    public static final int unpackInt2(long j) {
        return (int) (j & 4294967295L);
    }
}
