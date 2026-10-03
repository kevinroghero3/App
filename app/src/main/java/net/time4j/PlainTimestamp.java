package net.time4j;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.base.GregorianDate;
import net.time4j.base.MathUtils;
import net.time4j.base.TimeSource;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BridgeChronology;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.Chronology;
import net.time4j.engine.Converter;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FlagElement;
import net.time4j.engine.Normalizer;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.Temporal;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimeMetric;
import net.time4j.engine.TimePoint;
import net.time4j.engine.TimeSpan;
import net.time4j.engine.UnitRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayMode;
import net.time4j.format.Leniency;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.format.TemporalFormatter;
import net.time4j.scale.TimeScale;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.TransitionStrategy;
import net.time4j.tz.ZonalOffset;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes3.dex */
@CalendarType(CalendarText.ISO_CALENDAR_TYPE)
public final class PlainTimestamp extends TimePoint<IsoUnit, PlainTimestamp> implements GregorianDate, WallTime, Temporal<PlainTimestamp>, Normalizer<IsoUnit>, LocalizedPatternSupport {
    private static final Map<Object, ChronoElement<?>> CHILDREN;
    private static final TimeAxis<IsoUnit, PlainTimestamp> ENGINE;
    private static final PlainTimestamp MAX;
    private static final PlainTimestamp MIN;
    private static final int MRD = 1000000000;
    private static final TimeMetric<IsoUnit, Duration<IsoUnit>> STD_METRIC;
    private static final long serialVersionUID = 7458380065762437714L;
    private final transient PlainDate date;
    private final transient PlainTime time;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public PlainTimestamp getContext() {
        return this;
    }

    static {
        PlainTimestamp plainTimestamp = new PlainTimestamp(PlainDate.MIN, PlainTime.MIN);
        MIN = plainTimestamp;
        PlainDate plainDate = PlainDate.MAX;
        ChronoElement<PlainTime> chronoElement = PlainTime.WALL_TIME;
        PlainTimestamp plainTimestamp2 = new PlainTimestamp(plainDate, chronoElement.getDefaultMaximum());
        MAX = plainTimestamp2;
        HashMap map = new HashMap();
        ChronoElement<PlainDate> chronoElement2 = PlainDate.CALENDAR_DATE;
        map.put(chronoElement2, chronoElement);
        AdjustableElement<Integer, PlainDate> adjustableElement = PlainDate.YEAR;
        ProportionalElement<Integer, PlainDate> proportionalElement = PlainDate.MONTH_AS_NUMBER;
        map.put(adjustableElement, proportionalElement);
        AdjustableElement<Integer, PlainDate> adjustableElement2 = PlainDate.YEAR_OF_WEEKDATE;
        map.put(adjustableElement2, Weekmodel.ISO.weekOfYear());
        NavigableElement<Quarter> navigableElement = PlainDate.QUARTER_OF_YEAR;
        ProportionalElement<Integer, PlainDate> proportionalElement2 = PlainDate.DAY_OF_QUARTER;
        map.put(navigableElement, proportionalElement2);
        NavigableElement<Month> navigableElement2 = PlainDate.MONTH_OF_YEAR;
        ProportionalElement<Integer, PlainDate> proportionalElement3 = PlainDate.DAY_OF_MONTH;
        map.put(navigableElement2, proportionalElement3);
        map.put(proportionalElement, proportionalElement3);
        map.put(proportionalElement3, chronoElement);
        NavigableElement<Weekday> navigableElement3 = PlainDate.DAY_OF_WEEK;
        map.put(navigableElement3, chronoElement);
        ProportionalElement<Integer, PlainDate> proportionalElement4 = PlainDate.DAY_OF_YEAR;
        map.put(proportionalElement4, chronoElement);
        map.put(proportionalElement2, chronoElement);
        OrdinalWeekdayElement ordinalWeekdayElement = PlainDate.WEEKDAY_IN_MONTH;
        map.put(ordinalWeekdayElement, chronoElement);
        ZonalElement<Meridiem> zonalElement = PlainTime.AM_PM_OF_DAY;
        ProportionalElement<Integer, PlainTime> proportionalElement5 = PlainTime.DIGITAL_HOUR_OF_AMPM;
        map.put(zonalElement, proportionalElement5);
        AdjustableElement<Integer, PlainTime> adjustableElement3 = PlainTime.CLOCK_HOUR_OF_AMPM;
        ProportionalElement<Integer, PlainTime> proportionalElement6 = PlainTime.MINUTE_OF_HOUR;
        map.put(adjustableElement3, proportionalElement6);
        AdjustableElement<Integer, PlainTime> adjustableElement4 = PlainTime.CLOCK_HOUR_OF_DAY;
        map.put(adjustableElement4, proportionalElement6);
        map.put(proportionalElement5, proportionalElement6);
        ProportionalElement<Integer, PlainTime> proportionalElement7 = PlainTime.DIGITAL_HOUR_OF_DAY;
        map.put(proportionalElement7, proportionalElement6);
        ProportionalElement<Integer, PlainTime> proportionalElement8 = PlainTime.HOUR_FROM_0_TO_24;
        map.put(proportionalElement8, proportionalElement6);
        ProportionalElement<Integer, PlainTime> proportionalElement9 = PlainTime.SECOND_OF_MINUTE;
        map.put(proportionalElement6, proportionalElement9);
        ProportionalElement<Integer, PlainTime> proportionalElement10 = PlainTime.MINUTE_OF_DAY;
        map.put(proportionalElement10, proportionalElement9);
        ProportionalElement<Integer, PlainTime> proportionalElement11 = PlainTime.NANO_OF_SECOND;
        map.put(proportionalElement9, proportionalElement11);
        ProportionalElement<Integer, PlainTime> proportionalElement12 = PlainTime.SECOND_OF_DAY;
        map.put(proportionalElement12, proportionalElement11);
        CHILDREN = Collections.unmodifiableMap(map);
        TimeAxis.Builder up = TimeAxis.Builder.setUp(IsoUnit.class, PlainTimestamp.class, new Merger(null), plainTimestamp, plainTimestamp2);
        FieldRule fieldRuleOf = FieldRule.of(chronoElement2);
        CalendarUnit calendarUnit = CalendarUnit.DAYS;
        TimeAxis.Builder builderAppendElement = up.appendElement(chronoElement2, fieldRuleOf, calendarUnit);
        FieldRule fieldRuleOf2 = FieldRule.of(adjustableElement);
        CalendarUnit calendarUnit2 = CalendarUnit.YEARS;
        TimeAxis.Builder builderAppendElement2 = builderAppendElement.appendElement(adjustableElement, fieldRuleOf2, calendarUnit2).appendElement(adjustableElement2, FieldRule.of(adjustableElement2), Weekcycle.YEARS).appendElement(navigableElement, FieldRule.of(navigableElement), CalendarUnit.QUARTERS);
        FieldRule fieldRuleOf3 = FieldRule.of(navigableElement2);
        CalendarUnit calendarUnit3 = CalendarUnit.MONTHS;
        TimeAxis.Builder builderAppendElement3 = builderAppendElement2.appendElement(navigableElement2, fieldRuleOf3, calendarUnit3).appendElement(proportionalElement, FieldRule.of(proportionalElement), calendarUnit3).appendElement(proportionalElement3, FieldRule.of(proportionalElement3), calendarUnit).appendElement(navigableElement3, FieldRule.of(navigableElement3), calendarUnit).appendElement(proportionalElement4, FieldRule.of(proportionalElement4), calendarUnit).appendElement(proportionalElement2, FieldRule.of(proportionalElement2), calendarUnit).appendElement(ordinalWeekdayElement, FieldRule.of(ordinalWeekdayElement), CalendarUnit.WEEKS).appendElement((ChronoElement) chronoElement, (ElementRule) FieldRule.of(chronoElement)).appendElement((ChronoElement) zonalElement, (ElementRule) FieldRule.of(zonalElement));
        FieldRule fieldRuleOf4 = FieldRule.of(adjustableElement3);
        ClockUnit clockUnit = ClockUnit.HOURS;
        TimeAxis.Builder builderAppendElement4 = builderAppendElement3.appendElement(adjustableElement3, fieldRuleOf4, clockUnit).appendElement(adjustableElement4, FieldRule.of(adjustableElement4), clockUnit).appendElement(proportionalElement5, FieldRule.of(proportionalElement5), clockUnit).appendElement(proportionalElement7, FieldRule.of(proportionalElement7), clockUnit).appendElement(proportionalElement8, FieldRule.of(proportionalElement8), clockUnit);
        FieldRule fieldRuleOf5 = FieldRule.of(proportionalElement6);
        ClockUnit clockUnit2 = ClockUnit.MINUTES;
        TimeAxis.Builder builderAppendElement5 = builderAppendElement4.appendElement(proportionalElement6, fieldRuleOf5, clockUnit2).appendElement(proportionalElement10, FieldRule.of(proportionalElement10), clockUnit2);
        FieldRule fieldRuleOf6 = FieldRule.of(proportionalElement9);
        ClockUnit clockUnit3 = ClockUnit.SECONDS;
        TimeAxis.Builder builderAppendElement6 = builderAppendElement5.appendElement(proportionalElement9, fieldRuleOf6, clockUnit3).appendElement(proportionalElement12, FieldRule.of(proportionalElement12), clockUnit3);
        ProportionalElement<Integer, PlainTime> proportionalElement13 = PlainTime.MILLI_OF_SECOND;
        FieldRule fieldRuleOf7 = FieldRule.of(proportionalElement13);
        ClockUnit clockUnit4 = ClockUnit.MILLIS;
        TimeAxis.Builder builderAppendElement7 = builderAppendElement6.appendElement(proportionalElement13, fieldRuleOf7, clockUnit4);
        ProportionalElement<Integer, PlainTime> proportionalElement14 = PlainTime.MICRO_OF_SECOND;
        FieldRule fieldRuleOf8 = FieldRule.of(proportionalElement14);
        ClockUnit clockUnit5 = ClockUnit.MICROS;
        TimeAxis.Builder builderAppendElement8 = builderAppendElement7.appendElement(proportionalElement14, fieldRuleOf8, clockUnit5);
        FieldRule fieldRuleOf9 = FieldRule.of(proportionalElement11);
        ClockUnit clockUnit6 = ClockUnit.NANOS;
        TimeAxis.Builder builderAppendElement9 = builderAppendElement8.appendElement(proportionalElement11, fieldRuleOf9, clockUnit6);
        ProportionalElement<Integer, PlainTime> proportionalElement15 = PlainTime.MILLI_OF_DAY;
        TimeAxis.Builder builderAppendElement10 = builderAppendElement9.appendElement(proportionalElement15, FieldRule.of(proportionalElement15), clockUnit4);
        ProportionalElement<Long, PlainTime> proportionalElement16 = PlainTime.MICRO_OF_DAY;
        TimeAxis.Builder builderAppendElement11 = builderAppendElement10.appendElement(proportionalElement16, FieldRule.of(proportionalElement16), clockUnit5);
        ProportionalElement<Long, PlainTime> proportionalElement17 = PlainTime.NANO_OF_DAY;
        TimeAxis.Builder builderAppendElement12 = builderAppendElement11.appendElement(proportionalElement17, FieldRule.of(proportionalElement17), clockUnit6);
        ZonalElement<BigDecimal> zonalElement2 = PlainTime.DECIMAL_HOUR;
        TimeAxis.Builder builderAppendElement13 = builderAppendElement12.appendElement((ChronoElement) zonalElement2, (ElementRule) new DecimalRule(zonalElement2));
        ZonalElement<BigDecimal> zonalElement3 = PlainTime.DECIMAL_MINUTE;
        TimeAxis.Builder builderAppendElement14 = builderAppendElement13.appendElement((ChronoElement) zonalElement3, (ElementRule) new DecimalRule(zonalElement3));
        ZonalElement<BigDecimal> zonalElement4 = PlainTime.DECIMAL_SECOND;
        TimeAxis.Builder builderAppendElement15 = builderAppendElement14.appendElement((ChronoElement) zonalElement4, (ElementRule) new DecimalRule(zonalElement4));
        ChronoElement<ClockUnit> chronoElement3 = PlainTime.PRECISION;
        TimeAxis.Builder builderAppendElement16 = builderAppendElement15.appendElement((ChronoElement) chronoElement3, (ElementRule) FieldRule.of(chronoElement3));
        registerCalendarUnits(builderAppendElement16);
        registerClockUnits(builderAppendElement16);
        registerExtensions(builderAppendElement16);
        ENGINE = builderAppendElement16.build();
        STD_METRIC = Duration.in(calendarUnit2, calendarUnit3, calendarUnit, clockUnit, clockUnit2, clockUnit3, clockUnit6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PlainTimestamp(PlainDate plainDate, PlainTime plainTime) {
        if (plainTime.getHour() == 24) {
            this.date = (PlainDate) plainDate.plus(1L, CalendarUnit.DAYS);
            this.time = PlainTime.MIN;
        } else {
            if (plainDate == null) {
                throw new NullPointerException("Missing date.");
            }
            this.date = plainDate;
            this.time = plainTime;
        }
    }

    public static PlainTimestamp of(PlainDate plainDate, PlainTime plainTime) {
        return new PlainTimestamp(plainDate, plainTime);
    }

    public static PlainTimestamp of(int i, int i2, int i3, int i4, int i5) {
        return of(i, i2, i3, i4, i5, 0);
    }

    public static PlainTimestamp of(int i, int i2, int i3, int i4, int i5, int i6) {
        return of(PlainDate.of(i, i2, i3), PlainTime.of(i4, i5, i6));
    }

    public static PlainTimestamp nowInSystemTime() {
        return ZonalClock.ofSystem().now();
    }

    public PlainDate getCalendarDate() {
        return this.date;
    }

    public PlainTime getWallTime() {
        return this.time;
    }

    @Override // net.time4j.base.GregorianDate
    public int getYear() {
        return this.date.getYear();
    }

    @Override // net.time4j.base.GregorianDate
    public int getMonth() {
        return this.date.getMonth();
    }

    @Override // net.time4j.base.GregorianDate
    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    @Override // net.time4j.base.WallTime
    public int getHour() {
        return this.time.getHour();
    }

    @Override // net.time4j.base.WallTime
    public int getMinute() {
        return this.time.getMinute();
    }

    @Override // net.time4j.base.WallTime
    public int getSecond() {
        return this.time.getSecond();
    }

    @Override // net.time4j.base.WallTime
    public int getNanosecond() {
        return this.time.getNanosecond();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlainTimestamp with(ElementOperator<?> elementOperator) {
        return (PlainTimestamp) with(elementOperator.onTimestamp());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlainTimestamp with(PlainDate plainDate) {
        return (PlainTimestamp) with(PlainDate.CALENDAR_DATE, plainDate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlainTimestamp with(PlainTime plainTime) {
        return (PlainTimestamp) with(PlainTime.WALL_TIME, plainTime);
    }

    @Override // net.time4j.engine.Temporal
    public boolean isBefore(PlainTimestamp plainTimestamp) {
        return compareTo(plainTimestamp) < 0;
    }

    @Override // net.time4j.engine.Temporal
    public boolean isAfter(PlainTimestamp plainTimestamp) {
        return compareTo(plainTimestamp) > 0;
    }

    @Override // net.time4j.engine.Temporal
    public boolean isSimultaneous(PlainTimestamp plainTimestamp) {
        return compareTo(plainTimestamp) == 0;
    }

    @Override // net.time4j.engine.TimePoint
    public int compareTo(PlainTimestamp plainTimestamp) {
        if (this.date.isAfter((CalendarDate) plainTimestamp.date)) {
            return 1;
        }
        if (this.date.isBefore((CalendarDate) plainTimestamp.date)) {
            return -1;
        }
        return this.time.compareTo(plainTimestamp.time);
    }

    @Override // net.time4j.engine.TimePoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlainTimestamp)) {
            return false;
        }
        PlainTimestamp plainTimestamp = (PlainTimestamp) obj;
        return this.date.equals(plainTimestamp.date) && this.time.equals(plainTimestamp.time);
    }

    @Override // net.time4j.engine.TimePoint
    public int hashCode() {
        return (this.date.hashCode() * 13) + (this.time.hashCode() * 37);
    }

    @Override // net.time4j.engine.TimePoint
    public String toString() {
        return this.date.toString() + this.time.toString();
    }

    public PlainDate toDate() {
        return this.date;
    }

    public PlainTime toTime() {
        return this.time;
    }

    public String print(TemporalFormatter<PlainTimestamp> temporalFormatter) {
        return temporalFormatter.print(this);
    }

    public static PlainTimestamp parse(String str, TemporalFormatter<PlainTimestamp> temporalFormatter) {
        try {
            return temporalFormatter.parse(str);
        } catch (ParseException e) {
            throw new ChronoException(e.getMessage(), e);
        }
    }

    public static TimeAxis<IsoUnit, PlainTimestamp> axis() {
        return ENGINE;
    }

    public static <S> Chronology<S> axis(Converter<S, PlainTimestamp> converter) {
        return new BridgeChronology(converter, ENGINE);
    }

    public Moment atUTC() {
        return at(ZonalOffset.UTC);
    }

    public Moment at(ZonalOffset zonalOffset) {
        long jSafeMultiply = MathUtils.safeMultiply(this.date.getDaysSinceUTC() + 730, 86400L);
        long hour = this.time.getHour() * DateTimeConstants.SECONDS_PER_HOUR;
        long minute = this.time.getMinute() * 60;
        long second = this.time.getSecond();
        int nanosecond = this.time.getNanosecond();
        long integralAmount = (((jSafeMultiply + hour) + minute) + second) - ((long) zonalOffset.getIntegralAmount());
        int fractionalAmount = nanosecond - zonalOffset.getFractionalAmount();
        if (fractionalAmount < 0) {
            fractionalAmount += 1000000000;
            integralAmount--;
        } else if (fractionalAmount >= 1000000000) {
            fractionalAmount -= 1000000000;
            integralAmount++;
        }
        return Moment.of(integralAmount, fractionalAmount, TimeScale.POSIX);
    }

    public Moment inStdTimezone() {
        return in(Timezone.ofSystem());
    }

    public Moment inTimezone(TZID tzid) {
        return in(Timezone.of(tzid));
    }

    public Moment in(Timezone timezone) {
        if (timezone.isFixed()) {
            return at(timezone.getOffset(this.date, this.time));
        }
        TransitionStrategy strategy = timezone.getStrategy();
        long jResolve = strategy.resolve(this.date, this.time, timezone);
        Moment momentOf = Moment.of(jResolve, this.time.getNanosecond(), TimeScale.POSIX);
        if (strategy == Timezone.STRICT_MODE) {
            Moment.checkNegativeLS(jResolve, this);
        }
        return momentOf;
    }

    public ZonalDateTime inLocalView() {
        return inZonalView(Timezone.ofSystem());
    }

    public ZonalDateTime inZonalView(Timezone timezone) {
        return ZonalDateTime.of(in(timezone), timezone);
    }

    public boolean isValid(TZID tzid) {
        if (tzid == null) {
            return false;
        }
        return !Timezone.of(tzid).isInvalid(this.date, this.time);
    }

    @Override // net.time4j.engine.Normalizer
    /* JADX INFO: renamed from: normalize */
    public TimeSpan<IsoUnit> normalize2(TimeSpan<? extends IsoUnit> timeSpan) {
        return (Duration) until(plus(timeSpan), (TimeMetric) STD_METRIC);
    }

    @Override // net.time4j.engine.TimePoint, net.time4j.engine.ChronoEntity
    public TimeAxis<IsoUnit, PlainTimestamp> getChronology() {
        return ENGINE;
    }

    static PlainTimestamp from(UnixTime unixTime, ZonalOffset zonalOffset) {
        long posixTime = unixTime.getPosixTime() + ((long) zonalOffset.getIntegralAmount());
        int nanosecond = unixTime.getNanosecond() + zonalOffset.getFractionalAmount();
        if (nanosecond < 0) {
            nanosecond += 1000000000;
            posixTime--;
        } else if (nanosecond >= 1000000000) {
            nanosecond -= 1000000000;
            posixTime++;
        }
        PlainDate plainDateOf = PlainDate.of(MathUtils.floorDivide(posixTime, DateTimeConstants.SECONDS_PER_DAY), EpochDays.UNIX);
        int iFloorModulo = MathUtils.floorModulo(posixTime, DateTimeConstants.SECONDS_PER_DAY);
        int i = iFloorModulo / 60;
        return of(plainDateOf, PlainTime.of(i / 60, i % 60, iFloorModulo % 60, nanosecond));
    }

    private static void registerCalendarUnits(TimeAxis.Builder<IsoUnit, PlainTimestamp> builder) {
        Set<? extends IsoUnit> setRange = EnumSet.range(CalendarUnit.MILLENNIA, CalendarUnit.MONTHS);
        Set<? extends IsoUnit> setRange2 = EnumSet.range(CalendarUnit.WEEKS, CalendarUnit.DAYS);
        for (CalendarUnit calendarUnit : CalendarUnit.values()) {
            builder.appendUnit(calendarUnit, new CompositeUnitRule(calendarUnit), calendarUnit.getLength(), calendarUnit.compareTo(CalendarUnit.WEEKS) < 0 ? setRange : setRange2);
        }
    }

    private static void registerClockUnits(TimeAxis.Builder<IsoUnit, PlainTimestamp> builder) {
        for (ClockUnit clockUnit : ClockUnit.values()) {
            builder.appendUnit(clockUnit, new CompositeUnitRule(clockUnit), clockUnit.getLength(), EnumSet.allOf(ClockUnit.class));
        }
    }

    private static void registerExtensions(TimeAxis.Builder<IsoUnit, PlainTimestamp> builder) {
        Iterator<ChronoExtension> it2 = PlainDate.axis().getExtensions().iterator();
        while (it2.hasNext()) {
            builder.appendExtension(it2.next());
        }
        Iterator<ChronoExtension> it3 = PlainTime.axis().getExtensions().iterator();
        while (it3.hasNext()) {
            builder.appendExtension(it3.next());
        }
    }

    private Object writeReplace() {
        return new SPX(this, 8);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    static class Merger implements ChronoMerger<PlainTimestamp> {
        @Override // net.time4j.engine.ChronoMerger
        public ChronoDisplay preformat(PlainTimestamp plainTimestamp, AttributeQuery attributeQuery) {
            return plainTimestamp;
        }

        @Override // net.time4j.engine.ChronoMerger
        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        /* synthetic */ Merger(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ PlainTimestamp createFrom(TimeSource timeSource, AttributeQuery attributeQuery) {
            return createFrom2((TimeSource<?>) timeSource, attributeQuery);
        }

        @Override // net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ PlainTimestamp createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            return createFrom2((ChronoEntity<?>) chronoEntity, attributeQuery, z, z2);
        }

        @Override // net.time4j.engine.ChronoMerger
        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            DisplayMode displayModeOfStyle = DisplayMode.ofStyle(displayStyle.getStyleValue());
            return CalendarText.patternForTimestamp(displayModeOfStyle, displayModeOfStyle, locale);
        }

        @Override // net.time4j.engine.ChronoMerger
        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        @Override // net.time4j.engine.ChronoMerger
        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear();
        }

        @Override // net.time4j.engine.ChronoMerger
        /* JADX INFO: renamed from: createFrom, reason: avoid collision after fix types in other method */
        public PlainTimestamp createFrom2(TimeSource<?> timeSource, AttributeQuery attributeQuery) {
            Timezone timezoneOfSystem;
            AttributeKey<TZID> attributeKey = Attributes.TIMEZONE_ID;
            if (attributeQuery.contains(attributeKey)) {
                timezoneOfSystem = Timezone.of((TZID) attributeQuery.get(attributeKey));
            } else {
                if (!((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isLax()) {
                    return null;
                }
                timezoneOfSystem = Timezone.ofSystem();
            }
            UnixTime unixTimeCurrentTime = timeSource.currentTime();
            return PlainTimestamp.from(unixTimeCurrentTime, timezoneOfSystem.getOffset(unixTimeCurrentTime));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.engine.ChronoMerger
        /* JADX INFO: renamed from: createFrom, reason: avoid collision after fix types in other method */
        public PlainTimestamp createFrom2(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            PlainDate plainDate;
            PlainTime plainTime;
            TZID tzid;
            if (chronoEntity instanceof UnixTime) {
                AttributeKey<TZID> attributeKey = Attributes.TIMEZONE_ID;
                if (attributeQuery.contains(attributeKey)) {
                    tzid = (TZID) attributeQuery.get(attributeKey);
                } else if (z) {
                    tzid = ZonalOffset.UTC;
                } else {
                    throw new IllegalArgumentException("Missing timezone attribute for type conversion.");
                }
                return Moment.from((UnixTime) UnixTime.class.cast(chronoEntity)).toZonalTimestamp(tzid);
            }
            boolean z3 = z2 && chronoEntity.getInt(PlainTime.SECOND_OF_MINUTE) == 60;
            if (z3) {
                chronoEntity.with((ChronoElement<Integer>) PlainTime.SECOND_OF_MINUTE, 59);
            }
            ChronoElement<?> chronoElement = PlainDate.CALENDAR_DATE;
            if (chronoEntity.contains(chronoElement)) {
                plainDate = (PlainDate) chronoEntity.get(chronoElement);
            } else {
                plainDate = (PlainDate) PlainDate.axis().createFrom(chronoEntity, attributeQuery, z, false);
            }
            if (plainDate == null) {
                return null;
            }
            ChronoElement<?> chronoElement2 = PlainTime.WALL_TIME;
            if (chronoEntity.contains(chronoElement2)) {
                plainTime = (PlainTime) chronoEntity.get(chronoElement2);
            } else {
                plainTime = (PlainTime) PlainTime.axis().createFrom(chronoEntity, attributeQuery, z, false);
                if (plainTime == null && z) {
                    plainTime = PlainTime.MIN;
                }
            }
            if (plainTime == null) {
                return null;
            }
            ChronoElement<?> chronoElement3 = LongElement.DAY_OVERFLOW;
            if (chronoEntity.contains(chronoElement3)) {
                plainDate = (PlainDate) plainDate.plus(((Long) chronoEntity.get(chronoElement3)).longValue(), CalendarUnit.DAYS);
            }
            if (z3) {
                FlagElement flagElement = FlagElement.LEAP_SECOND;
                Boolean bool = Boolean.TRUE;
                if (chronoEntity.isValid(flagElement, bool)) {
                    chronoEntity.with(flagElement, bool);
                }
            }
            return PlainTimestamp.of(plainDate, plainTime);
        }
    }

    static class FieldRule<V> implements ElementRule<PlainTimestamp, V> {
        private final ChronoElement<V> element;

        /* synthetic */ FieldRule(ChronoElement chronoElement, AnonymousClass1 anonymousClass1) {
            this(chronoElement);
        }

        private FieldRule(ChronoElement<V> chronoElement) {
            this.element = chronoElement;
        }

        static <V> FieldRule<V> of(ChronoElement<V> chronoElement) {
            return new FieldRule<>(chronoElement);
        }

        @Override // net.time4j.engine.ElementRule
        public V getValue(PlainTimestamp plainTimestamp) {
            if (this.element.isDateElement()) {
                return (V) plainTimestamp.date.get(this.element);
            }
            if (this.element.isTimeElement()) {
                return (V) plainTimestamp.time.get(this.element);
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        @Override // net.time4j.engine.ElementRule
        public V getMinimum(PlainTimestamp plainTimestamp) {
            if (this.element.isDateElement()) {
                return (V) plainTimestamp.date.getMinimum(this.element);
            }
            if (this.element.isTimeElement()) {
                return this.element.getDefaultMinimum();
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        @Override // net.time4j.engine.ElementRule
        public V getMaximum(PlainTimestamp plainTimestamp) {
            if (this.element.isDateElement()) {
                return (V) plainTimestamp.date.getMaximum(this.element);
            }
            if (this.element.isTimeElement()) {
                return this.element.getDefaultMaximum();
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: merged with bridge method [inline-methods] */
        public boolean isValid2(PlainTimestamp plainTimestamp, V v) {
            if (v == null) {
                return false;
            }
            if (this.element.isDateElement()) {
                return plainTimestamp.date.isValid(this.element, v);
            }
            if (this.element.isTimeElement()) {
                if (Number.class.isAssignableFrom(this.element.getType())) {
                    long number = toNumber(this.element.getDefaultMinimum());
                    long number2 = toNumber(this.element.getDefaultMaximum());
                    long number3 = toNumber(v);
                    return number <= number3 && number2 >= number3;
                }
                if (this.element.equals(PlainTime.WALL_TIME) && PlainTime.MAX.equals(v)) {
                    return false;
                }
                return plainTimestamp.time.isValid(this.element, v);
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: merged with bridge method [inline-methods] */
        public PlainTimestamp withValue2(PlainTimestamp plainTimestamp, V v, boolean z) {
            if (v == null) {
                throw new IllegalArgumentException("Missing element value.");
            }
            if (v.equals(getValue(plainTimestamp))) {
                return plainTimestamp;
            }
            if (z) {
                return plainTimestamp.plus(MathUtils.safeSubtract(toNumber(v), toNumber(getValue(plainTimestamp))), (IsoUnit) PlainTimestamp.ENGINE.getBaseUnit(this.element));
            }
            if (this.element.isDateElement()) {
                return PlainTimestamp.of((PlainDate) plainTimestamp.date.with(this.element, v), plainTimestamp.time);
            }
            if (this.element.isTimeElement()) {
                if (Number.class.isAssignableFrom(this.element.getType())) {
                    long number = toNumber(this.element.getDefaultMinimum());
                    long number2 = toNumber(this.element.getDefaultMaximum());
                    long number3 = toNumber(v);
                    if (number > number3 || number2 < number3) {
                        throw new IllegalArgumentException("Out of range: " + v);
                    }
                } else if (this.element.equals(PlainTime.WALL_TIME) && v.equals(PlainTime.MAX)) {
                    throw new IllegalArgumentException("Out of range: " + v);
                }
                return PlainTimestamp.of(plainTimestamp.date, (PlainTime) plainTimestamp.time.with(this.element, v));
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(PlainTimestamp plainTimestamp) {
            return (ChronoElement) PlainTimestamp.CHILDREN.get(this.element);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(PlainTimestamp plainTimestamp) {
            return (ChronoElement) PlainTimestamp.CHILDREN.get(this.element);
        }

        private long toNumber(V v) {
            return ((Number) Number.class.cast(v)).longValue();
        }
    }

    static class DecimalRule extends FieldRule<BigDecimal> {
        DecimalRule(ChronoElement<BigDecimal> chronoElement) {
            super(chronoElement, null);
        }

        @Override // net.time4j.PlainTimestamp.FieldRule
        public boolean isValid2(PlainTimestamp plainTimestamp, BigDecimal bigDecimal) {
            if (bigDecimal == null) {
                return false;
            }
            return ((BigDecimal) ((FieldRule) this).element.getDefaultMinimum()).compareTo(bigDecimal) <= 0 && bigDecimal.compareTo((BigDecimal) ((FieldRule) this).element.getDefaultMaximum()) <= 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.PlainTimestamp.FieldRule
        public PlainTimestamp withValue2(PlainTimestamp plainTimestamp, BigDecimal bigDecimal, boolean z) {
            if (isValid(plainTimestamp, bigDecimal)) {
                return PlainTimestamp.of(plainTimestamp.date, (PlainTime) plainTimestamp.time.with((ChronoElement<BigDecimal>) ((FieldRule) this).element, bigDecimal));
            }
            throw new IllegalArgumentException("Out of range: " + bigDecimal);
        }
    }

    static class CompositeUnitRule implements UnitRule<PlainTimestamp> {
        private final CalendarUnit calendarUnit;
        private final ClockUnit clockUnit;

        CompositeUnitRule(CalendarUnit calendarUnit) {
            this.calendarUnit = calendarUnit;
            this.clockUnit = null;
        }

        CompositeUnitRule(ClockUnit clockUnit) {
            this.calendarUnit = null;
            this.clockUnit = clockUnit;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.engine.UnitRule
        public PlainTimestamp addTo(PlainTimestamp plainTimestamp, long j) {
            PlainDate plainDate;
            PlainTime plainTime;
            if (this.calendarUnit != null) {
                plainDate = (PlainDate) plainTimestamp.date.plus(j, this.calendarUnit);
                plainTime = plainTimestamp.time;
            } else {
                DayCycles dayCyclesRoll = plainTimestamp.time.roll(j, this.clockUnit);
                PlainDate plainDate2 = (PlainDate) plainTimestamp.date.plus(dayCyclesRoll.getDayOverflow(), CalendarUnit.DAYS);
                PlainTime wallTime = dayCyclesRoll.getWallTime();
                plainDate = plainDate2;
                plainTime = wallTime;
            }
            return PlainTimestamp.of(plainDate, plainTime);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.engine.UnitRule
        public long between(PlainTimestamp plainTimestamp, PlainTimestamp plainTimestamp2) {
            long jSafeAdd;
            CalendarUnit calendarUnit = this.calendarUnit;
            if (calendarUnit != null) {
                long jBetween = calendarUnit.between(plainTimestamp.date, plainTimestamp2.date);
                if (jBetween == 0) {
                    return jBetween;
                }
                if (this.calendarUnit != CalendarUnit.DAYS && ((PlainDate) plainTimestamp.date.plus(jBetween, this.calendarUnit)).compareByTime(plainTimestamp2.date) != 0) {
                    return jBetween;
                }
                PlainTime plainTime = plainTimestamp.time;
                PlainTime plainTime2 = plainTimestamp2.time;
                if (jBetween <= 0 || !plainTime.isAfter(plainTime2)) {
                    return (jBetween >= 0 || !plainTime.isBefore(plainTime2)) ? jBetween : jBetween + 1;
                }
                return jBetween - 1;
            }
            if (!plainTimestamp.date.isAfter((CalendarDate) plainTimestamp2.date)) {
                long jUntil = plainTimestamp.date.until(plainTimestamp2.date, CalendarUnit.DAYS);
                if (jUntil == 0) {
                    return this.clockUnit.between(plainTimestamp.time, plainTimestamp2.time);
                }
                if (this.clockUnit.compareTo(ClockUnit.SECONDS) <= 0) {
                    long jSafeMultiply = MathUtils.safeMultiply(jUntil, 86400L);
                    PlainTime plainTime3 = plainTimestamp2.time;
                    ProportionalElement<Integer, PlainTime> proportionalElement = PlainTime.SECOND_OF_DAY;
                    long jSafeAdd2 = MathUtils.safeAdd(jSafeMultiply, MathUtils.safeSubtract(((Integer) plainTime3.get(proportionalElement)).longValue(), ((Integer) plainTimestamp.time.get(proportionalElement)).longValue()));
                    if (plainTimestamp.time.getNanosecond() > plainTimestamp2.time.getNanosecond()) {
                        jSafeAdd2--;
                    }
                    jSafeAdd = jSafeAdd2;
                } else {
                    long jSafeMultiply2 = MathUtils.safeMultiply(jUntil, 86400000000000L);
                    PlainTime plainTime4 = plainTimestamp2.time;
                    ProportionalElement<Long, PlainTime> proportionalElement2 = PlainTime.NANO_OF_DAY;
                    jSafeAdd = MathUtils.safeAdd(jSafeMultiply2, MathUtils.safeSubtract(((Long) plainTime4.get(proportionalElement2)).longValue(), ((Long) plainTimestamp.time.get(proportionalElement2)).longValue()));
                }
                switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[this.clockUnit.ordinal()]) {
                    case 1:
                        return jSafeAdd / 3600;
                    case 2:
                        return jSafeAdd / 60;
                    case 3:
                    case 6:
                        return jSafeAdd;
                    case 4:
                        return jSafeAdd / AnimationKt.MillisToNanos;
                    case 5:
                        return jSafeAdd / 1000;
                    default:
                        throw new UnsupportedOperationException(this.clockUnit.name());
                }
            }
            return -between(plainTimestamp2, plainTimestamp);
        }
    }

    /* JADX INFO: renamed from: net.time4j.PlainTimestamp$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
        }
    }
}
