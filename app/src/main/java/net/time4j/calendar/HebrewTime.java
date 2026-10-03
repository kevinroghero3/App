package net.time4j.calendar;

import androidx.core.text.util.LocalePreferences;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumSet;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import net.time4j.CalendarUnit;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.PlainTimestamp;
import net.time4j.SystemClock;
import net.time4j.base.MathUtils;
import net.time4j.base.TimeSource;
import net.time4j.calendar.astro.SolarTime;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.Temporal;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimePoint;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarType;
import net.time4j.format.Leniency;
import net.time4j.scale.UniversalTime;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

/* JADX INFO: loaded from: classes6.dex */
@CalendarType(LocalePreferences.CalendarType.HEBREW)
public final class HebrewTime extends TimePoint<Unit, HebrewTime> implements Temporal<HebrewTime> {
    public static final ChronoElement<ClockCycle> CLOCK_CYCLE;

    @FormattableElement(format = "h")
    public static final StdCalendarElement<Integer, HebrewTime> CLOCK_HOUR;

    @FormattableElement(format = "H")
    public static final StdCalendarElement<Integer, HebrewTime> DIGITAL_HOUR;
    private static final TimeAxis<Unit, HebrewTime> ENGINE;
    private static final int HOUR12_INDEX = 0;
    private static final int HOUR23_INDEX = 1;
    private static final HebrewTime MAX;
    private static final HebrewTime MIN;
    private static final int PARTS_IN_HOUR = 1080;
    private static final int PART_INDEX = 2;

    @FormattableElement(dynamic = true, format = "P")
    public static final StdCalendarElement<Integer, HebrewTime> PART_OF_HOUR;
    private static final long serialVersionUID = -6206874394178665128L;
    private final transient int hour23;
    private final transient int part;

    public enum ClockCycle {
        NIGHT,
        DAY
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public HebrewTime getContext() {
        return this;
    }

    static {
        boolean z = false;
        StdEnumDateElement stdEnumDateElement = new StdEnumDateElement("CLOCK_CYCLE", HebrewTime.class, ClockCycle.class, (char) 0);
        CLOCK_CYCLE = stdEnumDateElement;
        Unit unit = Unit.HOURS;
        boolean z2 = true;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("CLOCK_HOUR", HebrewTime.class, 1, 12, 'h', new UnitOperator(unit, z2), new UnitOperator(unit, z));
        CLOCK_HOUR = stdIntegerDateElement;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DIGITAL_HOUR", HebrewTime.class, 0, 23, 'H', new UnitOperator(unit, z2), new UnitOperator(unit, z));
        DIGITAL_HOUR = stdIntegerDateElement2;
        Unit unit2 = Unit.HALAKIM;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("PART_OF_HOUR", HebrewTime.class, 0, 1079, 'P', new UnitOperator(unit2, z2), new UnitOperator(unit2, z));
        PART_OF_HOUR = stdIntegerDateElement3;
        HebrewTime hebrewTime = new HebrewTime(0, 0);
        MIN = hebrewTime;
        HebrewTime hebrewTime2 = new HebrewTime(23, 1079);
        MAX = hebrewTime2;
        TimeAxis.Builder builderAppendElement = TimeAxis.Builder.setUp(Unit.class, HebrewTime.class, new Merger(), hebrewTime, hebrewTime2).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) new CycleRule()).appendElement(stdIntegerDateElement, new IntegerElementRule(0), unit).appendElement(stdIntegerDateElement2, new IntegerElementRule(1), unit).appendElement(stdIntegerDateElement3, new IntegerElementRule(2), unit2);
        registerUnits(builderAppendElement);
        ENGINE = builderAppendElement.build();
    }

    private HebrewTime(ClockCycle clockCycle, int i, int i2) {
        if (i < 1 || i > 12) {
            throw new IllegalArgumentException("CLOCK_HOUR out of range: " + i);
        }
        if (i2 < 0 || i2 >= PARTS_IN_HOUR) {
            throw new IllegalArgumentException("PART_OF_HOUR out of range: " + i2);
        }
        i = i == 12 ? 0 : i;
        this.hour23 = clockCycle.equals(ClockCycle.NIGHT) ? i : i + 12;
        this.part = i2;
    }

    private HebrewTime(int i, int i2) {
        this.hour23 = i;
        this.part = i2;
    }

    public static HebrewTime ofDigital(int i, int i2) {
        if (i < 0 || i > 23) {
            throw new IllegalArgumentException("DIGITAL_HOUR out of range: " + i);
        }
        if (i2 < 0 || i2 >= PARTS_IN_HOUR) {
            throw new IllegalArgumentException("PART_OF_HOUR out of range: " + i2);
        }
        return new HebrewTime(i, i2);
    }

    public static HebrewTime ofNight(int i, int i2) {
        return new HebrewTime(ClockCycle.NIGHT, i, i2);
    }

    public static HebrewTime ofDay(int i, int i2) {
        return new HebrewTime(ClockCycle.DAY, i, i2);
    }

    public static HebrewTime now(SolarTime solarTime) {
        return at(solarTime).apply(SystemClock.currentMoment());
    }

    public static HebrewTime nowInSystemTime() {
        return (HebrewTime) SystemClock.inLocalView().now(axis());
    }

    public static ChronoFunction<Moment, HebrewTime> at(final SolarTime solarTime) {
        return new ChronoFunction<Moment, HebrewTime>() { // from class: net.time4j.calendar.HebrewTime.1
            /* JADX WARN: Code duplicated, block: B:17:0x0092  */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // net.time4j.engine.ChronoFunction
            public HebrewTime apply(Moment moment) {
                Moment moment2;
                ClockCycle clockCycle;
                PlainTimestamp zonalTimestamp = moment.toZonalTimestamp(ZonalOffset.atLongitude(new BigDecimal(solarTime.getLongitude())));
                Moment moment3 = (Moment) zonalTimestamp.toDate().get(solarTime.sunset());
                if (moment3 != null) {
                    if (moment.isBefore((UniversalTime) moment3)) {
                        moment2 = (Moment) zonalTimestamp.toDate().get(solarTime.sunrise());
                        if (moment2 == null) {
                            clockCycle = null;
                            moment3 = null;
                            moment2 = null;
                        } else if (moment.isBefore((UniversalTime) moment2)) {
                            moment3 = (Moment) ((PlainDate) zonalTimestamp.toDate().minus(1L, CalendarUnit.DAYS)).get(solarTime.sunset());
                            if (moment3 != null) {
                                clockCycle = ClockCycle.NIGHT;
                            } else {
                                clockCycle = null;
                                moment3 = null;
                                moment2 = null;
                            }
                        } else {
                            clockCycle = ClockCycle.DAY;
                            moment2 = moment3;
                            moment3 = moment2;
                        }
                    } else {
                        Moment moment4 = (Moment) ((PlainDate) zonalTimestamp.toDate().plus(1L, CalendarUnit.DAYS)).get(solarTime.sunrise());
                        if (moment4 != null) {
                            moment2 = moment4;
                            clockCycle = ClockCycle.NIGHT;
                        } else {
                            clockCycle = null;
                            moment3 = null;
                            moment2 = null;
                        }
                    }
                    if (clockCycle != null && moment3 != null && moment2 != null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        long jUntil = moment3.until(moment2, timeUnit);
                        long nanosecond = moment2.getNanosecond();
                        double dUntil = ((((moment3.until(moment, timeUnit) * 1000000000) + ((long) moment.getNanosecond())) - ((long) moment3.getNanosecond())) * 12960.0d) / (((jUntil * 1000000000) + nanosecond) - moment3.getNanosecond());
                        int iFloor = (int) Math.floor(dUntil / 1080.0d);
                        int iFloor2 = (int) Math.floor(dUntil - ((double) (iFloor * HebrewTime.PARTS_IN_HOUR)));
                        if (iFloor == 0) {
                            iFloor = 12;
                        }
                        return new HebrewTime(clockCycle, iFloor, iFloor2);
                    }
                }
                return null;
            }
        };
    }

    public static ChronoFunction<Moment, HebrewTime> at(final TZID tzid) {
        return new ChronoFunction<Moment, HebrewTime>() { // from class: net.time4j.calendar.HebrewTime.2
            @Override // net.time4j.engine.ChronoFunction
            public HebrewTime apply(Moment moment) {
                PlainTime wallTime = moment.toZonalTimestamp(tzid).getWallTime();
                return new HebrewTime((wallTime.getHour() + 6) % 24, ((BigDecimal) wallTime.get(PlainTime.DECIMAL_HOUR)).subtract(new BigDecimal(wallTime.getHour())).multiply(new BigDecimal(HebrewTime.PARTS_IN_HOUR)).intValue());
            }
        };
    }

    public boolean isNight() {
        return this.hour23 < 12;
    }

    public boolean isDay() {
        return this.hour23 >= 12;
    }

    public int getClockHour() {
        int i = this.hour23;
        if (isDay()) {
            i -= 12;
        }
        if (i == 0) {
            return 12;
        }
        return i;
    }

    public int getDigitalHour() {
        return this.hour23;
    }

    public int getPart() {
        return this.part;
    }

    @Override // net.time4j.engine.Temporal
    public boolean isAfter(HebrewTime hebrewTime) {
        return getTimeOfDay() > hebrewTime.getTimeOfDay();
    }

    @Override // net.time4j.engine.Temporal
    public boolean isBefore(HebrewTime hebrewTime) {
        return getTimeOfDay() < hebrewTime.getTimeOfDay();
    }

    @Override // net.time4j.engine.Temporal
    public boolean isSimultaneous(HebrewTime hebrewTime) {
        return getTimeOfDay() == hebrewTime.getTimeOfDay();
    }

    @Override // net.time4j.engine.TimePoint
    public int compareTo(HebrewTime hebrewTime) {
        return getTimeOfDay() - hebrewTime.getTimeOfDay();
    }

    @Override // net.time4j.engine.TimePoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HebrewTime) && getTimeOfDay() == ((HebrewTime) obj).getTimeOfDay();
    }

    @Override // net.time4j.engine.TimePoint
    public int hashCode() {
        return getTimeOfDay();
    }

    @Override // net.time4j.engine.TimePoint
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hour23);
        sb.append('H');
        sb.append(this.part);
        sb.append('P');
        return sb.toString();
    }

    public Moment on(HebrewCalendar hebrewCalendar, SolarTime solarTime) {
        Moment momentApply;
        HebrewTime hebrewTime;
        Moment momentApply2;
        PlainDate plainDate = (PlainDate) hebrewCalendar.transform(PlainDate.class);
        if (isNight()) {
            momentApply2 = solarTime.sunset().apply(plainDate.minus(CalendarDays.ONE));
            momentApply = solarTime.sunrise().apply(plainDate);
            hebrewTime = this;
        } else {
            HebrewTime hebrewTimeMinus = minus(12L, Unit.HOURS);
            Moment momentApply3 = solarTime.sunrise().apply(plainDate);
            momentApply = solarTime.sunset().apply(plainDate);
            hebrewTime = hebrewTimeMinus;
            momentApply2 = momentApply3;
        }
        if (momentApply2 == null || momentApply == null) {
            return null;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        int iUntil = (int) momentApply2.until(momentApply, timeUnit);
        if (momentApply2.getNanosecond() > momentApply.getNanosecond()) {
            iUntil--;
        }
        return momentApply2.plus((long) Math.floor(((double) (hebrewTime.getTimeOfDay() * iUntil)) / 12960.0d), timeUnit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Moment on(HebrewCalendar hebrewCalendar, Timezone timezone) {
        return hebrewCalendar.at((PlainTime) PlainTime.of(18).with(PlainTime.DECIMAL_HOUR, new BigDecimal(this.part).setScale(15, RoundingMode.UNNECESSARY).divide(new BigDecimal(PARTS_IN_HOUR), RoundingMode.FLOOR).add(new BigDecimal((this.hour23 + 18) % 24)))).in(timezone, StartOfDay.EVENING);
    }

    public static TimeAxis<Unit, HebrewTime> axis() {
        return ENGINE;
    }

    @Override // net.time4j.engine.TimePoint, net.time4j.engine.ChronoEntity
    public TimeAxis<Unit, HebrewTime> getChronology() {
        return ENGINE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTimeOfDay() {
        return this.part + (this.hour23 * PARTS_IN_HOUR);
    }

    private static void registerUnits(TimeAxis.Builder<Unit, HebrewTime> builder) {
        EnumSet enumSetAllOf = EnumSet.allOf(Unit.class);
        for (Unit unit : Unit.values()) {
            builder.appendUnit(unit, new ClockUnitRule(unit), unit.getLength(), enumSetAllOf);
        }
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        HOURS(3600.0d),
        HALAKIM(3.3333333333333335d);

        private final transient double length;

        @Override // net.time4j.engine.ChronoUnit
        public boolean isCalendrical() {
            return false;
        }

        Unit(double d) {
            this.length = d;
        }

        @Override // net.time4j.engine.ChronoUnit
        public double getLength() {
            return this.length;
        }

        public int between(HebrewTime hebrewTime, HebrewTime hebrewTime2) {
            return (int) hebrewTime.until(hebrewTime2, this);
        }
    }

    static class ClockUnitRule implements UnitRule<HebrewTime> {
        private final Unit unit;

        private ClockUnitRule(Unit unit) {
            this.unit = unit;
        }

        @Override // net.time4j.engine.UnitRule
        public HebrewTime addTo(HebrewTime hebrewTime, long j) {
            int iFloorModulo;
            int iFloorModulo2;
            if (j == 0) {
                return hebrewTime;
            }
            int i = AnonymousClass3.$SwitchMap$net$time4j$calendar$HebrewTime$Unit[this.unit.ordinal()];
            if (i == 1) {
                int iFloorModulo3 = MathUtils.floorModulo(MathUtils.safeAdd(hebrewTime.hour23, j), 24);
                iFloorModulo = hebrewTime.part;
                iFloorModulo2 = iFloorModulo3;
            } else if (i == 2) {
                long jSafeAdd = MathUtils.safeAdd(hebrewTime.part, j);
                iFloorModulo = MathUtils.floorModulo(jSafeAdd, HebrewTime.PARTS_IN_HOUR);
                iFloorModulo2 = MathUtils.floorModulo(MathUtils.safeAdd(hebrewTime.hour23, MathUtils.floorDivide(jSafeAdd, HebrewTime.PARTS_IN_HOUR)), 24);
            } else {
                throw new UnsupportedOperationException(this.unit.name());
            }
            return new HebrewTime(iFloorModulo2, iFloorModulo);
        }

        @Override // net.time4j.engine.UnitRule
        public long between(HebrewTime hebrewTime, HebrewTime hebrewTime2) {
            long timeOfDay = hebrewTime2.getTimeOfDay() - hebrewTime.getTimeOfDay();
            int i = AnonymousClass3.$SwitchMap$net$time4j$calendar$HebrewTime$Unit[this.unit.ordinal()];
            if (i == 1) {
                return timeOfDay / 1080;
            }
            if (i == 2) {
                return timeOfDay;
            }
            throw new UnsupportedOperationException(this.unit.name());
        }
    }

    /* JADX INFO: renamed from: net.time4j.calendar.HebrewTime$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$HebrewTime$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$net$time4j$calendar$HebrewTime$Unit = iArr;
            try {
                iArr[Unit.HOURS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$calendar$HebrewTime$Unit[Unit.HALAKIM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static class UnitOperator implements ChronoOperator<HebrewTime> {
        private final boolean decrementing;
        private final Unit unit;

        private UnitOperator(Unit unit, boolean z) {
            this.unit = unit;
            this.decrementing = z;
        }

        @Override // net.time4j.engine.ChronoOperator
        public HebrewTime apply(HebrewTime hebrewTime) {
            return hebrewTime.plus(this.decrementing ? -1L : 1L, this.unit);
        }
    }

    static class CycleRule implements ElementRule<HebrewTime, ClockCycle> {
        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(HebrewTime hebrewTime, ClockCycle clockCycle) {
            return clockCycle != null;
        }

        private CycleRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public ClockCycle getValue(HebrewTime hebrewTime) {
            return hebrewTime.hour23 < 12 ? ClockCycle.NIGHT : ClockCycle.DAY;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public HebrewTime withValue2(HebrewTime hebrewTime, ClockCycle clockCycle, boolean z) {
            if (clockCycle == null) {
                throw new IllegalArgumentException("Missing Hebrew cycle.");
            }
            return new HebrewTime(clockCycle, hebrewTime.getClockHour(), hebrewTime.getPart());
        }

        @Override // net.time4j.engine.ElementRule
        public ClockCycle getMinimum(HebrewTime hebrewTime) {
            return ClockCycle.NIGHT;
        }

        @Override // net.time4j.engine.ElementRule
        public ClockCycle getMaximum(HebrewTime hebrewTime) {
            return ClockCycle.DAY;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(HebrewTime hebrewTime) {
            return HebrewTime.CLOCK_HOUR;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(HebrewTime hebrewTime) {
            return HebrewTime.CLOCK_HOUR;
        }
    }

    static class IntegerElementRule implements ElementRule<HebrewTime, Integer> {
        private final int index;

        IntegerElementRule(int i) {
            this.index = i;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(HebrewTime hebrewTime) {
            int i = this.index;
            if (i == 0) {
                return Integer.valueOf(hebrewTime.getClockHour());
            }
            if (i == 1) {
                return Integer.valueOf(hebrewTime.hour23);
            }
            if (i == 2) {
                return Integer.valueOf(hebrewTime.part);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(HebrewTime hebrewTime) {
            int i = this.index;
            if (i == 0) {
                return 1;
            }
            if (i == 1 || i == 2) {
                return 0;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(HebrewTime hebrewTime) {
            int i = this.index;
            if (i == 0) {
                return 12;
            }
            if (i == 1) {
                return 23;
            }
            if (i == 2) {
                return 1079;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(HebrewTime hebrewTime, Integer num) {
            return num != null && getMinimum(hebrewTime).compareTo(num) <= 0 && getMaximum(hebrewTime).compareTo(num) >= 0;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public HebrewTime withValue2(HebrewTime hebrewTime, Integer num, boolean z) {
            if (num == null) {
                throw new IllegalArgumentException("Missing element value.");
            }
            int iIntValue = num.intValue();
            int i = this.index;
            if (i == 0) {
                if (z) {
                    return hebrewTime.plus(MathUtils.safeSubtract(iIntValue, hebrewTime.getClockHour()), Unit.HOURS);
                }
                return hebrewTime.isDay() ? HebrewTime.ofDay(iIntValue, hebrewTime.part) : HebrewTime.ofNight(iIntValue, hebrewTime.part);
            }
            if (i == 1) {
                return z ? hebrewTime.plus(MathUtils.safeSubtract(iIntValue, hebrewTime.hour23), Unit.HOURS) : HebrewTime.ofDigital(iIntValue, hebrewTime.part);
            }
            if (i == 2) {
                return z ? hebrewTime.plus(MathUtils.safeSubtract(iIntValue, hebrewTime.part), Unit.HALAKIM) : HebrewTime.ofDigital(hebrewTime.hour23, iIntValue);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(HebrewTime hebrewTime) {
            int i = this.index;
            if (i == 0 || i == 1) {
                return HebrewTime.PART_OF_HOUR;
            }
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(HebrewTime hebrewTime) {
            return getChildAtFloor(hebrewTime);
        }
    }

    static class Merger implements ChronoMerger<HebrewTime> {
        @Override // net.time4j.engine.ChronoMerger
        public int getDefaultPivotYear() {
            return 100;
        }

        @Override // net.time4j.engine.ChronoMerger
        public ChronoDisplay preformat(HebrewTime hebrewTime, AttributeQuery attributeQuery) {
            return hebrewTime;
        }

        @Override // net.time4j.engine.ChronoMerger
        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        @Override // net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ HebrewTime createFrom(TimeSource timeSource, AttributeQuery attributeQuery) {
            return createFrom2((TimeSource<?>) timeSource, attributeQuery);
        }

        @Override // net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ HebrewTime createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            return createFrom2((ChronoEntity<?>) chronoEntity, attributeQuery, z, z2);
        }

        @Override // net.time4j.engine.ChronoMerger
        /* JADX INFO: renamed from: createFrom, reason: avoid collision after fix types in other method */
        public HebrewTime createFrom2(TimeSource<?> timeSource, AttributeQuery attributeQuery) {
            TZID id;
            AttributeKey<TZID> attributeKey = Attributes.TIMEZONE_ID;
            if (attributeQuery.contains(attributeKey)) {
                id = (TZID) attributeQuery.get(attributeKey);
            } else {
                if (!((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isLax()) {
                    return null;
                }
                id = Timezone.ofSystem().getID();
            }
            return HebrewTime.at(id).apply(Moment.from(timeSource.currentTime()));
        }

        @Override // net.time4j.engine.ChronoMerger
        /* JADX INFO: renamed from: createFrom, reason: avoid collision after fix types in other method */
        public HebrewTime createFrom2(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            int i;
            StdCalendarElement<Integer, HebrewTime> stdCalendarElement = HebrewTime.PART_OF_HOUR;
            if (chronoEntity.contains(stdCalendarElement)) {
                i = chronoEntity.getInt(stdCalendarElement);
                if (i < 0 || i >= HebrewTime.PARTS_IN_HOUR) {
                    chronoEntity.with(ValidationElement.ERROR_MESSAGE, "PART_OF_HOUR out of range: " + i);
                    return null;
                }
            } else {
                i = 0;
            }
            ChronoElement<?> chronoElement = HebrewTime.CLOCK_CYCLE;
            if (chronoEntity.contains(chronoElement)) {
                StdCalendarElement<Integer, HebrewTime> stdCalendarElement2 = HebrewTime.CLOCK_HOUR;
                if (chronoEntity.contains(stdCalendarElement2)) {
                    ClockCycle clockCycle = (ClockCycle) chronoEntity.get(chronoElement);
                    int i2 = chronoEntity.getInt(stdCalendarElement2);
                    if (i2 < 1 || i2 > 12) {
                        chronoEntity.with(ValidationElement.ERROR_MESSAGE, "CLOCK_HOUR out of range: " + i2);
                        return null;
                    }
                    return new HebrewTime(clockCycle, i2, i);
                }
            }
            StdCalendarElement<Integer, HebrewTime> stdCalendarElement3 = HebrewTime.DIGITAL_HOUR;
            if (chronoEntity.contains(stdCalendarElement3)) {
                int i3 = chronoEntity.getInt(stdCalendarElement3);
                if (i3 < 0 || i3 > 23) {
                    chronoEntity.with(ValidationElement.ERROR_MESSAGE, "DIGITAL_HOUR out of range: " + i3);
                    return null;
                }
                return new HebrewTime(i3, i);
            }
            chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Missing cycle or hour of cycle.");
            return null;
        }

        @Override // net.time4j.engine.ChronoMerger
        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            throw new UnsupportedOperationException("Localized format patterns are not available.");
        }

        @Override // net.time4j.engine.ChronoMerger
        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.EVENING;
        }
    }

    static class SPX implements Externalizable {
        private static final int HEBREW_TIME = 13;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj) {
            this.obj = obj;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(13);
            writeHebrewTime(objectOutput);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 13) {
                this.obj = readHebrewTime(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeHebrewTime(ObjectOutput objectOutput) throws IOException {
            HebrewTime hebrewTime = (HebrewTime) this.obj;
            objectOutput.writeByte(hebrewTime.getDigitalHour());
            objectOutput.writeShort(hebrewTime.getPart());
        }

        private HebrewTime readHebrewTime(ObjectInput objectInput) throws IOException {
            return HebrewTime.ofDigital(objectInput.readByte(), objectInput.readShort());
        }
    }
}
