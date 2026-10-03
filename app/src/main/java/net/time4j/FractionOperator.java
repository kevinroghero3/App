package net.time4j;

import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;

/* JADX INFO: loaded from: classes3.dex */
final class FractionOperator<T extends ChronoEntity<T>> implements ChronoOperator<T> {
    private static final int KILO = 1000;
    private static final int MIO = 1000000;
    private final char fraction;
    private final boolean up;

    FractionOperator(char c, boolean z) {
        this.fraction = c;
        this.up = z;
    }

    @Override // net.time4j.engine.ChronoOperator
    public T apply(T t) {
        if (this.fraction == '9') {
            return t;
        }
        ProportionalElement<Integer, PlainTime> proportionalElement = PlainTime.NANO_OF_SECOND;
        int iIntValue = ((Integer) t.get(proportionalElement)).intValue();
        int iIntValue2 = ((Integer) t.getMaximum(proportionalElement)).intValue();
        char c = this.fraction;
        if (c == '3') {
            return (T) t.with(proportionalElement, Math.min(iIntValue2, ((iIntValue / 1000000) * 1000000) + (this.up ? 999999 : 0)));
        }
        if (c == '6') {
            return (T) t.with(proportionalElement, Math.min(iIntValue2, ((iIntValue / 1000) * 1000) + (this.up ? 999 : 0)));
        }
        throw new UnsupportedOperationException("Unknown: " + this.fraction);
    }
}
