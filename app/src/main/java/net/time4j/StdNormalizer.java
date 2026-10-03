package net.time4j;

import androidx.compose.animation.core.AnimationKt;
import java.util.ArrayList;
import java.util.Comparator;
import net.time4j.IsoUnit;
import net.time4j.base.MathUtils;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Normalizer;
import net.time4j.engine.TimeSpan;

/* JADX INFO: loaded from: classes3.dex */
class StdNormalizer<U extends IsoUnit> implements Normalizer<U>, Comparator<TimeSpan.Item<? extends ChronoUnit>> {
    private static final int MIO = 1000000;
    private static final int MRD = 1000000000;
    private final boolean mixed;

    private StdNormalizer(boolean z) {
        this.mixed = z;
    }

    static StdNormalizer<IsoUnit> ofMixedUnits() {
        return new StdNormalizer<>(true);
    }

    static StdNormalizer<CalendarUnit> ofCalendarUnits() {
        return new StdNormalizer<>(false);
    }

    static StdNormalizer<ClockUnit> ofClockUnits() {
        return new StdNormalizer<>(false);
    }

    static Comparator<TimeSpan.Item<? extends ChronoUnit>> comparator() {
        return new StdNormalizer(false);
    }

    @Override // java.util.Comparator
    public int compare(TimeSpan.Item<? extends ChronoUnit> item, TimeSpan.Item<? extends ChronoUnit> item2) {
        return compare(item.getUnit(), item2.getUnit());
    }

    @Override // net.time4j.engine.Normalizer
    /* JADX INFO: renamed from: normalize */
    public Duration<U> normalize2(TimeSpan<? extends U> timeSpan) {
        long jSafeAdd;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long jSafeAdd2;
        long jSafeAdd3;
        long j7;
        int size = timeSpan.getTotalLength().size();
        ArrayList arrayList = new ArrayList(size);
        int i = 0;
        long jSafeAdd4 = 0;
        long j8 = 0;
        long j9 = 0;
        long amount = 0;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        while (i < size) {
            TimeSpan.Item<? extends U> item = timeSpan.getTotalLength().get(i);
            long j14 = amount;
            amount = item.getAmount();
            U unit = item.getUnit();
            int i2 = size;
            long j15 = j8;
            if (unit instanceof CalendarUnit) {
                switch (AnonymousClass1.$SwitchMap$net$time4j$CalendarUnit[((CalendarUnit) CalendarUnit.class.cast(unit)).ordinal()]) {
                    case 1:
                        jSafeAdd3 = MathUtils.safeAdd(MathUtils.safeMultiply(amount, 1000L), j11);
                        j7 = j12;
                        j12 = j7;
                        amount = j14;
                        j11 = jSafeAdd3;
                        j8 = j15;
                        i++;
                        size = i2;
                        break;
                    case 2:
                        jSafeAdd3 = MathUtils.safeAdd(MathUtils.safeMultiply(amount, 100L), j11);
                        j7 = j12;
                        j12 = j7;
                        amount = j14;
                        j11 = jSafeAdd3;
                        j8 = j15;
                        i++;
                        size = i2;
                        break;
                    case 3:
                        jSafeAdd3 = MathUtils.safeAdd(MathUtils.safeMultiply(amount, 10L), j11);
                        j7 = j12;
                        j12 = j7;
                        amount = j14;
                        j11 = jSafeAdd3;
                        j8 = j15;
                        i++;
                        size = i2;
                        break;
                    case 4:
                        jSafeAdd3 = MathUtils.safeAdd(amount, j11);
                        j7 = j12;
                        j12 = j7;
                        amount = j14;
                        j11 = jSafeAdd3;
                        j8 = j15;
                        i++;
                        size = i2;
                        break;
                    case 5:
                        jSafeAdd4 = MathUtils.safeAdd(MathUtils.safeMultiply(amount, 3L), jSafeAdd4);
                        break;
                    case 6:
                        jSafeAdd4 = MathUtils.safeAdd(amount, jSafeAdd4);
                        break;
                    case 7:
                        j13 = amount;
                        break;
                    case 8:
                        jSafeAdd3 = j11;
                        j7 = amount;
                        j12 = j7;
                        amount = j14;
                        j11 = jSafeAdd3;
                        j8 = j15;
                        i++;
                        size = i2;
                        break;
                    default:
                        throw new UnsupportedOperationException(unit.toString());
                }
            } else if (unit instanceof ClockUnit) {
                switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[((ClockUnit) ClockUnit.class.cast(unit)).ordinal()]) {
                    case 1:
                        j8 = amount;
                        amount = j14;
                        i++;
                        size = i2;
                        break;
                    case 2:
                        j9 = amount;
                        break;
                    case 3:
                        j8 = j15;
                        i++;
                        size = i2;
                        break;
                    case 4:
                        jSafeAdd2 = MathUtils.safeAdd(MathUtils.safeMultiply(amount, AnimationKt.MillisToNanos), j10);
                        j10 = jSafeAdd2;
                        break;
                    case 5:
                        jSafeAdd2 = MathUtils.safeAdd(MathUtils.safeMultiply(amount, 1000L), j10);
                        j10 = jSafeAdd2;
                        break;
                    case 6:
                        jSafeAdd2 = MathUtils.safeAdd(amount, j10);
                        j10 = jSafeAdd2;
                        break;
                    default:
                        throw new UnsupportedOperationException(unit.toString());
                }
            } else {
                arrayList.add(TimeSpan.Item.of(amount, unit));
            }
            jSafeAdd3 = j11;
            j7 = j12;
            j12 = j7;
            amount = j14;
            j11 = jSafeAdd3;
            j8 = j15;
            i++;
            size = i2;
        }
        long j16 = j8;
        long j17 = amount;
        if ((j16 | j9 | j17 | j10) != 0) {
            j4 = j10 % 1000000000;
            long jSafeAdd5 = MathUtils.safeAdd(j17, j10 / 1000000000);
            long j18 = jSafeAdd5 % 60;
            long jSafeAdd6 = MathUtils.safeAdd(j9, jSafeAdd5 / 60);
            long j19 = jSafeAdd6 % 60;
            long jSafeAdd7 = MathUtils.safeAdd(j16, jSafeAdd6 / 60);
            if (this.mixed) {
                jSafeAdd = MathUtils.safeAdd(j12, jSafeAdd7 / 24);
                j3 = j19;
                j2 = jSafeAdd7 % 24;
            } else {
                jSafeAdd = j12;
                j2 = jSafeAdd7;
                j3 = j19;
            }
            j = j18;
        } else {
            jSafeAdd = j12;
            j = 0;
            j2 = 0;
            j3 = 0;
            j4 = 0;
        }
        if ((j11 | jSafeAdd4 | jSafeAdd) != 0) {
            j5 = j;
            long jSafeAdd8 = MathUtils.safeAdd(j11, jSafeAdd4 / 12);
            long j20 = jSafeAdd4 % 12;
            j6 = j3;
            long jSafeAdd9 = MathUtils.safeAdd(MathUtils.safeMultiply(j13, 7L), jSafeAdd);
            if (jSafeAdd8 != 0) {
                arrayList.add(TimeSpan.Item.of(jSafeAdd8, CalendarUnit.YEARS));
            }
            if (j20 != 0) {
                arrayList.add(TimeSpan.Item.of(j20, CalendarUnit.MONTHS));
            }
            if (jSafeAdd9 != 0) {
                arrayList.add(TimeSpan.Item.of(jSafeAdd9, CalendarUnit.DAYS));
            }
        } else {
            j5 = j;
            j6 = j3;
            long j21 = j13;
            if (j21 != 0) {
                arrayList.add(TimeSpan.Item.of(j21, CalendarUnit.WEEKS));
            }
        }
        if (j2 != 0) {
            arrayList.add(TimeSpan.Item.of(j2, ClockUnit.HOURS));
        }
        if (j6 != 0) {
            arrayList.add(TimeSpan.Item.of(j6, ClockUnit.MINUTES));
        }
        if (j5 != 0) {
            arrayList.add(TimeSpan.Item.of(j5, ClockUnit.SECONDS));
        }
        long j22 = j4;
        if (j22 != 0) {
            arrayList.add(TimeSpan.Item.of(j22, ClockUnit.NANOS));
        }
        return new Duration<>(arrayList, timeSpan.isNegative());
    }

    /* JADX INFO: renamed from: net.time4j.StdNormalizer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$CalendarUnit;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$ClockUnit;

        static {
            int[] iArr = new int[ClockUnit.values().length];
            $SwitchMap$net$time4j$ClockUnit = iArr;
            try {
                iArr[ClockUnit.HOURS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$ClockUnit[ClockUnit.MINUTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$ClockUnit[ClockUnit.SECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$time4j$ClockUnit[ClockUnit.MILLIS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$time4j$ClockUnit[ClockUnit.MICROS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$time4j$ClockUnit[ClockUnit.NANOS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[CalendarUnit.values().length];
            $SwitchMap$net$time4j$CalendarUnit = iArr2;
            try {
                iArr2[CalendarUnit.MILLENNIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.CENTURIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.DECADES.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.QUARTERS.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.MONTHS.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.WEEKS.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.DAYS.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    static int compare(ChronoUnit chronoUnit, ChronoUnit chronoUnit2) {
        int iCompare = Double.compare(chronoUnit2.getLength(), chronoUnit.getLength());
        if (iCompare != 0 || chronoUnit.equals(chronoUnit2)) {
            return iCompare;
        }
        throw new IllegalArgumentException("Mixing different units of same length not allowed.");
    }
}
