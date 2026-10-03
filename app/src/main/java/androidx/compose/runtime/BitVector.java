package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BitVector {
    public static final int $stable = 8;
    private long first;
    private long[] others;
    private long second;

    public final int getSize() {
        long[] jArr = this.others;
        if (jArr != null) {
            return (jArr.length + 2) * 64;
        }
        return 128;
    }

    public final boolean get(int i) {
        int i2;
        if (i < 0 || i >= getSize()) {
            throw new IllegalStateException(("Index " + i + " out of bound").toString());
        }
        if (i < 64) {
            return ((1 << i) & this.first) != 0;
        }
        if (i < 128) {
            return ((1 << (i - 64)) & this.second) != 0;
        }
        long[] jArr = this.others;
        return (jArr == null || (i2 = (i / 64) + (-2)) >= jArr.length || ((1 << (i % 64)) & jArr[i2]) == 0) ? false : true;
    }

    public final void set(int i, boolean z) {
        if (i < 64) {
            long j = 1 << i;
            this.first = z ? this.first | j : this.first & (~j);
            return;
        }
        if (i < 128) {
            long j2 = 1 << (i - 64);
            this.second = z ? this.second | j2 : this.second & (~j2);
            return;
        }
        int i2 = i / 64;
        int i3 = i2 - 2;
        long j3 = 1 << (i % 64);
        long[] jArrCopyOf = this.others;
        if (jArrCopyOf == null) {
            jArrCopyOf = new long[i2 - 1];
            this.others = jArrCopyOf;
        }
        if (i3 >= jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2 - 1);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(this, newSize)");
            this.others = jArrCopyOf;
        }
        long j4 = jArrCopyOf[i3];
        jArrCopyOf[i3] = z ? j3 | j4 : (~j3) & j4;
    }

    public final int nextSet(int i) {
        int size = getSize();
        while (i < size) {
            if (get(i)) {
                return i;
            }
            i++;
        }
        return Integer.MAX_VALUE;
    }

    public final int nextClear(int i) {
        int size = getSize();
        while (i < size) {
            if (!get(i)) {
                return i;
            }
            i++;
        }
        return Integer.MAX_VALUE;
    }

    public final void setRange(int i, int i2) {
        while (i < i2) {
            set(i, true);
            i++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BitVector [");
        int size = getSize();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            if (get(i)) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(i);
                z = false;
            }
        }
        sb.append(']');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
