package net.time4j;

import java.io.ObjectStreamException;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.UnitRule;

/* JADX INFO: loaded from: classes3.dex */
final class YOWElement extends AbstractDateElement<Integer> {
    private static final long serialVersionUID = -6907291758376370420L;
    private final transient ElementOperator<PlainDate> nextAdjuster;
    private final transient ElementOperator<PlainDate> previousAdjuster;
    private static final UnitRule U_RULE = new URule();
    static final YOWElement INSTANCE = new YOWElement("YEAR_OF_WEEKDATE");

    @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
    public char getSymbol() {
        return 'Y';
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.engine.BasicElement
    public boolean isSingleton() {
        return true;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isTimeElement() {
        return false;
    }

    private YOWElement(String str) {
        super(str);
        this.previousAdjuster = new YOWRollingAdjuster(-1L);
        this.nextAdjuster = new YOWRollingAdjuster(1L);
    }

    @Override // net.time4j.engine.ChronoElement
    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override // net.time4j.engine.ChronoElement
    public Integer getDefaultMinimum() {
        return PlainDate.MIN_YEAR;
    }

    @Override // net.time4j.engine.ChronoElement
    public Integer getDefaultMaximum() {
        return PlainDate.MAX_YEAR;
    }

    @Override // net.time4j.AbstractDateElement, net.time4j.AdjustableElement
    public ElementOperator<PlainDate> decremented() {
        return this.previousAdjuster;
    }

    @Override // net.time4j.AbstractDateElement, net.time4j.AdjustableElement
    public ElementOperator<PlainDate> incremented() {
        return this.nextAdjuster;
    }

    static <T extends ChronoEntity<T>> ElementRule<T, Integer> elementRule(Class<T> cls) {
        return new ERule();
    }

    static <T extends ChronoEntity<T>> UnitRule<T> unitRule() {
        return U_RULE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getFirstCalendarWeekAsDayOfYear(PlainDate plainDate, int i) {
        return getFirstCalendarWeekAsDayOfYear(plainDate.getYear() + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getFirstCalendarWeekAsDayOfYear(int i) {
        Weekday weekdayValueOf = Weekday.valueOf(GregorianMath.getDayOfWeek(i, 1, 1));
        Weekmodel weekmodel = Weekmodel.ISO;
        int value = weekdayValueOf.getValue(weekmodel);
        return value <= 8 - weekmodel.getMinimalDaysInFirstWeek() ? 2 - value : 9 - value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLengthOfYear(PlainDate plainDate, int i) {
        return GregorianMath.isLeapYear(plainDate.getYear() + i) ? 366 : 365;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getWeekOfYear(PlainDate plainDate) {
        int dayOfYear = plainDate.getDayOfYear();
        int firstCalendarWeekAsDayOfYear = getFirstCalendarWeekAsDayOfYear(plainDate, 0);
        if (firstCalendarWeekAsDayOfYear <= dayOfYear) {
            int i = ((dayOfYear - firstCalendarWeekAsDayOfYear) / 7) + 1;
            if (i < 53 || getFirstCalendarWeekAsDayOfYear(plainDate, 1) + getLengthOfYear(plainDate, 0) > dayOfYear) {
                return i;
            }
            return 1;
        }
        return (((dayOfYear + getLengthOfYear(plainDate, -1)) - getFirstCalendarWeekAsDayOfYear(plainDate, -1)) / 7) + 1;
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    static class YOWRollingAdjuster extends ElementOperator<PlainDate> {
        private final long amount;
        private final ChronoOperator<PlainTimestamp> yowTS;

        private YOWRollingAdjuster(long j) {
            super(YOWElement.INSTANCE, 8);
            this.amount = j;
            this.yowTS = new ChronoOperator<PlainTimestamp>() { // from class: net.time4j.YOWElement.YOWRollingAdjuster.1
                @Override // net.time4j.engine.ChronoOperator
                public PlainTimestamp apply(PlainTimestamp plainTimestamp) {
                    return (PlainTimestamp) YOWElement.unitRule().addTo(plainTimestamp, YOWRollingAdjuster.this.amount);
                }
            };
        }

        @Override // net.time4j.engine.ChronoOperator
        public PlainDate apply(PlainDate plainDate) {
            return (PlainDate) YOWElement.unitRule().addTo(plainDate, this.amount);
        }

        @Override // net.time4j.ElementOperator
        ChronoOperator<PlainTimestamp> onTimestamp() {
            return this.yowTS;
        }
    }

    static class URule<T extends ChronoEntity<T>> implements UnitRule<T> {
        private URule() {
        }

        @Override // net.time4j.engine.UnitRule
        public T addTo(T t, long j) {
            if (j == 0) {
                return t;
            }
            int iSafeCast = MathUtils.safeCast(MathUtils.safeAdd(((Integer) t.get(YOWElement.INSTANCE)).intValue(), j));
            ChronoElement<PlainDate> chronoElement = PlainDate.CALENDAR_DATE;
            PlainDate plainDate = (PlainDate) t.get(chronoElement);
            int weekOfYear = plainDate.getWeekOfYear();
            Weekday dayOfWeek = plainDate.getDayOfWeek();
            if (weekOfYear == 53) {
                weekOfYear = ((Integer) PlainDate.of(iSafeCast, 26, dayOfWeek).getMaximum(Weekmodel.ISO.weekOfYear())).intValue();
            }
            return (T) t.with(chronoElement, PlainDate.of(iSafeCast, weekOfYear, dayOfWeek));
        }

        @Override // net.time4j.engine.UnitRule
        public long between(T t, T t2) {
            ChronoElement<PlainDate> chronoElement = PlainDate.CALENDAR_DATE;
            PlainDate plainDate = (PlainDate) t.get(chronoElement);
            PlainDate plainDate2 = (PlainDate) t2.get(chronoElement);
            YOWElement yOWElement = YOWElement.INSTANCE;
            long jIntValue = ((Integer) plainDate2.get(yOWElement)).intValue() - ((Integer) plainDate.get(yOWElement)).intValue();
            if (jIntValue == 0) {
                return jIntValue;
            }
            int weekOfYear = YOWElement.getWeekOfYear(plainDate);
            int weekOfYear2 = YOWElement.getWeekOfYear(plainDate2);
            if (jIntValue > 0 && weekOfYear > weekOfYear2) {
                jIntValue--;
            } else if (jIntValue < 0 && weekOfYear < weekOfYear2) {
                jIntValue++;
            }
            if (jIntValue == 0 || weekOfYear != weekOfYear2) {
                return jIntValue;
            }
            int value = plainDate.getDayOfWeek().getValue();
            int value2 = plainDate2.getDayOfWeek().getValue();
            if (jIntValue > 0 && value > value2) {
                jIntValue--;
            } else if (jIntValue < 0 && value < value2) {
                jIntValue++;
            }
            if (jIntValue == 0 || value != value2) {
                return jIntValue;
            }
            ChronoElement<PlainTime> chronoElement2 = PlainTime.WALL_TIME;
            if (!t.contains(chronoElement2) || !t2.contains(chronoElement2)) {
                return jIntValue;
            }
            PlainTime plainTime = (PlainTime) t.get(chronoElement2);
            PlainTime plainTime2 = (PlainTime) t2.get(chronoElement2);
            if (jIntValue <= 0 || !plainTime.isAfter(plainTime2)) {
                return (jIntValue >= 0 || !plainTime.isBefore(plainTime2)) ? jIntValue : jIntValue + 1;
            }
            return jIntValue - 1;
        }
    }

    static class ERule<T extends ChronoEntity<T>> implements ElementRule<T, Integer> {
        private ERule() {
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(T t) {
            PlainDate plainDate = (PlainDate) t.get(PlainDate.CALENDAR_DATE);
            int year = plainDate.getYear();
            int dayOfYear = plainDate.getDayOfYear();
            int firstCalendarWeekAsDayOfYear = YOWElement.getFirstCalendarWeekAsDayOfYear(plainDate, 0);
            if (firstCalendarWeekAsDayOfYear > dayOfYear) {
                year--;
            } else if (((dayOfYear - firstCalendarWeekAsDayOfYear) / 7) + 1 >= 53 && YOWElement.getFirstCalendarWeekAsDayOfYear(plainDate, 1) + YOWElement.getLengthOfYear(plainDate, 0) <= dayOfYear) {
                year++;
            }
            return Integer.valueOf(year);
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(T t) {
            return YOWElement.INSTANCE.getDefaultMinimum();
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(T t) {
            return YOWElement.INSTANCE.getDefaultMaximum();
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: merged with bridge method [inline-methods] */
        public boolean isValid2(T t, Integer num) {
            int iIntValue;
            return num != null && (iIntValue = num.intValue()) >= -999999999 && iIntValue <= 999999999;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: merged with bridge method [inline-methods] */
        public T withValue2(T t, Integer num, boolean z) {
            if (num == null) {
                throw new IllegalArgumentException("Missing element value.");
            }
            ChronoElement<PlainDate> chronoElement = PlainDate.CALENDAR_DATE;
            return (T) t.with(chronoElement, setYearOfWeekdate((PlainDate) t.get(chronoElement), num.intValue()));
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(T t) {
            return getChild();
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(T t) {
            return getChild();
        }

        private ChronoElement<?> getChild() {
            return Weekmodel.ISO.weekOfYear();
        }

        private static PlainDate setYearOfWeekdate(PlainDate plainDate, int i) {
            int firstCalendarWeekAsDayOfYear = YOWElement.getFirstCalendarWeekAsDayOfYear(i);
            int weekOfYear = YOWElement.getWeekOfYear(plainDate);
            long jTransform = EpochDays.UNIX.transform(GregorianMath.toMJD(i, 1, 1), EpochDays.MODIFIED_JULIAN_DATE) + ((long) (firstCalendarWeekAsDayOfYear - 1)) + ((long) ((weekOfYear - 1) * 7)) + ((long) (plainDate.getDayOfWeek().getValue(Weekmodel.ISO) - 1));
            if (weekOfYear == 53) {
                if (((YOWElement.getFirstCalendarWeekAsDayOfYear(i + 1) + (GregorianMath.isLeapYear(i) ? 366 : 365)) - firstCalendarWeekAsDayOfYear) / 7 < 53) {
                    jTransform -= 7;
                }
            }
            return plainDate.withDaysSinceUTC(jTransform - 730);
        }
    }
}
