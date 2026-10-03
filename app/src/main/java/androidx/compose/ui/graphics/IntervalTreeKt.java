package androidx.compose.ui.graphics;

/* JADX INFO: loaded from: classes4.dex */
public final class IntervalTreeKt {
    private static final Interval<Object> EmptyInterval = new Interval<>(Float.MAX_VALUE, Float.MIN_VALUE, null);

    public static final Interval<Object> getEmptyInterval() {
        return EmptyInterval;
    }
}
