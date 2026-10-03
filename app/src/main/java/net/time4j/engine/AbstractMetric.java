package net.time4j.engine;

import androidx.compose.animation.core.AnimationKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.time4j.base.MathUtils;
import net.time4j.engine.AbstractDuration;
import net.time4j.engine.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMetric<U extends ChronoUnit, P extends AbstractDuration<U>> implements TimeMetric<U, P>, Comparator<U> {
    private static final double LENGTH_OF_FORTNIGHT = 1209600.0d;
    private static final int MIO = 1000000;
    private final boolean normalizing;
    private final List<U> sortedUnits;

    protected abstract P createEmptyTimeSpan();

    protected abstract P createTimeSpan(List<TimeSpan.Item<U>> list, boolean z);

    protected TimeSpan.Item<U> resolve(TimeSpan.Item<U> item) {
        return item;
    }

    public AbstractMetric(boolean z, U... uArr) {
        this(Arrays.asList(uArr), z);
    }

    public AbstractMetric(boolean z, Collection<? extends U> collection) {
        this(new ArrayList(collection), z);
    }

    private AbstractMetric(List<U> list, boolean z) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Missing units.");
        }
        Collections.sort(list, this);
        int size = list.size();
        int i = 0;
        while (i < size) {
            U u = list.get(i);
            i++;
            for (int i2 = i; i2 < size; i2++) {
                if (u.equals(list.get(i2))) {
                    throw new IllegalArgumentException("Duplicate unit: " + u);
                }
            }
        }
        this.sortedUnits = Collections.unmodifiableList(list);
        this.normalizing = z;
    }

    @Override // java.util.Comparator
    public int compare(U u, U u2) {
        return Double.compare(u2.getLength(), u.getLength());
    }

    @Override // net.time4j.engine.TimeMetric
    public <T extends TimePoint<? super U, T>> P between(T t, T t2) {
        return (P) between(t, t2, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends TimePoint<? super U, T>> P between(T t, T t2, int i) {
        TimePoint timePoint;
        boolean z;
        TimePoint timePoint2 = t2;
        if (timePoint2.equals(t)) {
            return (P) createEmptyTimeSpan();
        }
        int i2 = 0;
        if (t.compareTo(t2) > 0) {
            timePoint = t;
            z = true;
        } else {
            timePoint = timePoint2;
            z = false;
            timePoint2 = t;
        }
        ArrayList arrayList = new ArrayList(10);
        TimeAxis<? super U, T> chronology = t.getChronology();
        int size = this.sortedUnits.size();
        while (i2 < size) {
            U u = this.sortedUnits.get(i2);
            if (getLength(chronology, u) >= 1.0d || i2 >= size - 1) {
                int i3 = i2 + 1;
                long factor = 1;
                while (i3 < size) {
                    U u2 = this.sortedUnits.get(i3);
                    factor *= getFactor(chronology, (ChronoUnit) u, u2);
                    if (factor >= AnimationKt.MillisToNanos || !chronology.isConvertible(u, u2)) {
                        break;
                    }
                    i3++;
                    u = (Object) u2;
                }
                i2 = i3 - 1;
                long jUntil = timePoint2.until(timePoint, u);
                long j = 0;
                if (jUntil < 0) {
                    throw new IllegalStateException("Implementation error: Cannot compute timespan due to illegal negative timespan amounts.");
                }
                while (true) {
                    if (jUntil > j) {
                        TimePoint timePointPlus = timePoint2.plus(jUntil, u);
                        if (i2 > i || i2 == size - 1 || timePointPlus.minus(jUntil, u).equals(timePoint2)) {
                            arrayList.add(resolve(TimeSpan.Item.of(jUntil, u)));
                            timePoint2 = timePointPlus;
                        } else {
                            jUntil--;
                            j = 0;
                        }
                    }
                }
            }
            i2++;
        }
        if (this.normalizing) {
            normalize(chronology, this.sortedUnits, arrayList);
        }
        return (P) createTimeSpan(arrayList, z);
    }

    @Override // net.time4j.engine.TimeMetric
    public TimeMetric<U, P> reversible() {
        return new ReversalMetric();
    }

    private <T extends TimePoint<? super U, T>> void normalize(TimeAxis<? super U, T> timeAxis, List<U> list, List<TimeSpan.Item<U>> list2) {
        TimeSpan.Item item;
        Comparator<? super Object> comparatorUnitComparator = timeAxis.unitComparator();
        for (int size = list.size() - 1; size >= 0; size--) {
            if (size > 0) {
                U u = list.get(size);
                U u2 = list.get(size - 1);
                long factor = getFactor(timeAxis, u2, u);
                if (factor < AnimationKt.MillisToNanos && timeAxis.isConvertible(u2, u) && (item = getItem(list2, u)) != null) {
                    long amount = item.getAmount();
                    long j = amount / factor;
                    if (j > 0) {
                        long j2 = amount % factor;
                        if (j2 == 0) {
                            removeItem(list2, u);
                        } else {
                            putItem(list2, comparatorUnitComparator, j2, u);
                        }
                        TimeSpan.Item item2 = getItem(list2, u2);
                        if (item2 == null) {
                            putItem(list2, comparatorUnitComparator, j, u2);
                        } else {
                            putItem(list2, comparatorUnitComparator, MathUtils.safeAdd(item2.getAmount(), j), u2);
                        }
                    }
                }
            }
        }
    }

    private static <U> TimeSpan.Item<U> getItem(List<TimeSpan.Item<U>> list, U u) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TimeSpan.Item<U> item = list.get(i);
            if (item.getUnit().equals(u)) {
                return item;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <U> void putItem(List<TimeSpan.Item<U>> list, Comparator<? super U> comparator, long j, U u) {
        TimeSpan.Item<U> itemOf = TimeSpan.Item.of(j, u);
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            U unit = list.get(i2).getUnit();
            if (unit.equals(u)) {
                list.set(i2, itemOf);
                return;
            }
            if (i == i2 && comparator.compare(unit, u) < 0) {
                i++;
            }
        }
        list.add(i, itemOf);
    }

    private static <U> void removeItem(List<TimeSpan.Item<U>> list, U u) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getUnit().equals(u)) {
                list.remove(i);
                return;
            }
        }
    }

    private <T extends TimePoint<? super U, T>> long getFactor(TimeAxis<? super U, T> timeAxis, U u, U u2) {
        return Math.round(getLength(timeAxis, u) / getLength(timeAxis, u2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T extends TimePoint<? super U, T>> double getLength(TimeAxis<? super U, T> timeAxis, U u) {
        return timeAxis.getLength(u);
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class ReversalMetric<U extends ChronoUnit, P extends AbstractDuration<U>> implements TimeMetric<U, P> {
        private final AbstractMetric<U, P> delegate;
        private final int monthIndex;

        @Override // net.time4j.engine.TimeMetric
        public TimeMetric<U, P> reversible() {
            return this;
        }

        private ReversalMetric(AbstractMetric<U, P> abstractMetric) {
            this.delegate = abstractMetric;
            int size = ((AbstractMetric) abstractMetric).sortedUnits.size() - 1;
            while (size >= 0) {
                if (Double.compare(((ChronoUnit) ((AbstractMetric) this.delegate).sortedUnits.get(size)).getLength(), AbstractMetric.LENGTH_OF_FORTNIGHT) > 0) {
                    this.monthIndex = size;
                }
                size--;
            }
            size = -1;
            this.monthIndex = size;
        }

        @Override // net.time4j.engine.TimeMetric
        public <T extends TimePoint<? super U, T>> P between(T t, T t2) {
            return (P) this.delegate.between(t, t2, this.monthIndex);
        }
    }
}
