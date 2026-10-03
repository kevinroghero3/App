package kotlin.ranges;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
final class OpenEndDoubleRange implements OpenEndRange<Double> {
    private final double _endExclusive;
    private final double _start;

    private final boolean lessThanOrEquals(double d, double d2) {
        return d <= d2;
    }

    public OpenEndDoubleRange(double d, double d2) {
        this._start = d;
        this._endExclusive = d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).doubleValue());
    }

    @Override // kotlin.ranges.OpenEndRange
    public Double getStart() {
        return Double.valueOf(this._start);
    }

    @Override // kotlin.ranges.OpenEndRange
    public Double getEndExclusive() {
        return Double.valueOf(this._endExclusive);
    }

    public boolean contains(double d) {
        return d >= this._start && d < this._endExclusive;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return this._start >= this._endExclusive;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof OpenEndDoubleRange) {
            if (!isEmpty() || !((OpenEndDoubleRange) obj).isEmpty()) {
                OpenEndDoubleRange openEndDoubleRange = (OpenEndDoubleRange) obj;
                if (this._start != openEndDoubleRange._start || this._endExclusive != openEndDoubleRange._endExclusive) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.hashCode(this._start) * 31) + Double.hashCode(this._endExclusive);
    }

    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }
}
