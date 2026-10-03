package net.time4j.calendar;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.time4j.GeneralTimestamp;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.MathUtils;
import net.time4j.base.TimeSource;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarType;
import net.time4j.format.Leniency;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.history.ChronoHistory;
import net.time4j.history.HistoricDate;
import net.time4j.history.HistoricEra;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;

/* JADX INFO: loaded from: classes6.dex */
@CalendarType("coptic")
public final class CopticCalendar extends Calendrical<Unit, CopticCalendar> implements LocalizedPatternSupport {
    private static final EraYearMonthDaySystem<CopticCalendar> CALSYS;

    @FormattableElement(format = DateTokenConverter.CONVERTER_KEY)
    public static final StdCalendarElement<Integer, CopticCalendar> DAY_OF_MONTH;
    private static final int DAY_OF_MONTH_INDEX = 2;

    @FormattableElement(format = ExifInterface.LONGITUDE_EAST)
    public static final StdCalendarElement<Weekday, CopticCalendar> DAY_OF_WEEK;

    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, CopticCalendar> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 3;
    private static final long DIOCLETIAN = ((Long) ChronoHistory.PROLEPTIC_JULIAN.convert(HistoricDate.of(HistoricEra.AD, 284, 8, 29)).get(EpochDays.UTC)).longValue();
    private static final TimeAxis<Unit, CopticCalendar> ENGINE;

    @FormattableElement(format = "G")
    public static final ChronoElement<CopticEra> ERA;

    @FormattableElement(alt = "L", format = "M")
    public static final StdCalendarElement<CopticMonth, CopticCalendar> MONTH_OF_YEAR;

    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<CopticCalendar> WEEKDAY_IN_MONTH;
    private static final WeekdayInMonthElement<CopticCalendar> WIM_ELEMENT;
    private static final int YEAR_INDEX = 0;

    @FormattableElement(format = "y")
    public static final StdCalendarElement<Integer, CopticCalendar> YEAR_OF_ERA;
    private static final long serialVersionUID = -8248846000788617742L;
    private final transient int cdom;
    private final transient int cmonth;
    private final transient int cyear;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public CopticCalendar getContext() {
        return this;
    }

    static {
        StdEnumDateElement stdEnumDateElement = new StdEnumDateElement("ERA", CopticCalendar.class, CopticEra.class, 'G');
        ERA = stdEnumDateElement;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("YEAR_OF_ERA", CopticCalendar.class, 1, 9999, 'y', null, null);
        YEAR_OF_ERA = stdIntegerDateElement;
        StdEnumDateElement stdEnumDateElement2 = new StdEnumDateElement("MONTH_OF_YEAR", CopticCalendar.class, CopticMonth.class, 'M');
        MONTH_OF_YEAR = stdEnumDateElement2;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DAY_OF_MONTH", CopticCalendar.class, 1, 30, 'd');
        DAY_OF_MONTH = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_YEAR", CopticCalendar.class, 1, 365, 'D');
        DAY_OF_YEAR = stdIntegerDateElement3;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(CopticCalendar.class, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<CopticCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(CopticCalendar.class, stdIntegerDateElement2, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        TimeAxis.Builder builderAppendElement = TimeAxis.Builder.setUp(Unit.class, CopticCalendar.class, new Merger(), transformer).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) new EraRule());
        IntegerRule integerRule = new IntegerRule(0);
        Unit unit = Unit.YEARS;
        TimeAxis.Builder builderAppendElement2 = builderAppendElement.appendElement(stdIntegerDateElement, integerRule, unit);
        MonthRule monthRule = new MonthRule();
        Unit unit2 = Unit.MONTHS;
        TimeAxis.Builder builderAppendElement3 = builderAppendElement2.appendElement(stdEnumDateElement2, monthRule, unit2);
        IntegerRule integerRule2 = new IntegerRule(2);
        Unit unit3 = Unit.DAYS;
        TimeAxis.Builder builderAppendUnit = builderAppendElement3.appendElement(stdIntegerDateElement2, integerRule2, unit3).appendElement(stdIntegerDateElement3, new IntegerRule(3), unit3).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<CopticCalendar, CalendarSystem<CopticCalendar>>() { // from class: net.time4j.calendar.CopticCalendar.1
            @Override // net.time4j.engine.ChronoFunction
            public CalendarSystem<CopticCalendar> apply(CopticCalendar copticCalendar) {
                return CopticCalendar.CALSYS;
            }
        }), unit3).appendElement((ChronoElement) weekdayInMonthElement, WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new RelatedGregorianYearRule(transformer, stdIntegerDateElement3)).appendUnit(unit, new CopticUnitRule(unit), unit.getLength(), Collections.singleton(unit2)).appendUnit(unit2, new CopticUnitRule(unit2), unit2.getLength(), Collections.singleton(unit));
        Unit unit4 = Unit.WEEKS;
        ENGINE = builderAppendUnit.appendUnit(unit4, new CopticUnitRule(unit4), unit4.getLength(), Collections.singleton(unit3)).appendUnit(unit3, new CopticUnitRule(unit3), unit3.getLength(), Collections.singleton(unit4)).appendExtension((ChronoExtension) new CommonElements.Weekengine(CopticCalendar.class, stdIntegerDateElement2, stdIntegerDateElement3, getDefaultWeekmodel())).build();
    }

    private CopticCalendar(int i, int i2, int i3) {
        this.cyear = i;
        this.cmonth = i2;
        this.cdom = i3;
    }

    public static CopticCalendar of(int i, CopticMonth copticMonth, int i2) {
        return of(i, copticMonth.getValue(), i2);
    }

    public static CopticCalendar of(int i, int i2, int i3) {
        if (!CALSYS.isValid(CopticEra.ANNO_MARTYRUM, i, i2, i3)) {
            throw new IllegalArgumentException("Invalid Coptic date: year=" + i + ", month=" + i2 + ", day=" + i3);
        }
        return new CopticCalendar(i, i2, i3);
    }

    public static CopticCalendar nowInSystemTime() {
        return (CopticCalendar) SystemClock.inLocalView().now(axis());
    }

    public CopticEra getEra() {
        return CopticEra.ANNO_MARTYRUM;
    }

    public int getYear() {
        return this.cyear;
    }

    public CopticMonth getMonth() {
        return CopticMonth.valueOf(this.cmonth);
    }

    public int getDayOfMonth() {
        return this.cdom;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(CALSYS.transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return ((Integer) get(DAY_OF_YEAR)).intValue();
    }

    public int lengthOfMonth() {
        return CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, this.cyear, this.cmonth);
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public boolean isLeapYear() {
        return this.cyear % 4 == 3;
    }

    public static boolean isValid(int i, int i2, int i3) {
        return CALSYS.isValid(CopticEra.ANNO_MARTYRUM, i, i2, i3);
    }

    public GeneralTimestamp<CopticCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<CopticCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    @Override // net.time4j.engine.Calendrical, net.time4j.engine.TimePoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CopticCalendar)) {
            return false;
        }
        CopticCalendar copticCalendar = (CopticCalendar) obj;
        return this.cdom == copticCalendar.cdom && this.cmonth == copticCalendar.cmonth && this.cyear == copticCalendar.cyear;
    }

    @Override // net.time4j.engine.Calendrical, net.time4j.engine.TimePoint
    public int hashCode() {
        return (this.cdom * 17) + (this.cmonth * 31) + (this.cyear * 37);
    }

    @Override // net.time4j.engine.TimePoint
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("A.M.-");
        String strValueOf = String.valueOf(this.cyear);
        for (int length = strValueOf.length(); length < 4; length++) {
            sb.append('0');
        }
        sb.append(strValueOf);
        sb.append(CoreConstants.DASH_CHAR);
        if (this.cmonth < 10) {
            sb.append('0');
        }
        sb.append(this.cmonth);
        sb.append(CoreConstants.DASH_CHAR);
        if (this.cdom < 10) {
            sb.append('0');
        }
        sb.append(this.cdom);
        return sb.toString();
    }

    public static Weekmodel getDefaultWeekmodel() {
        Weekday weekday = Weekday.SATURDAY;
        return Weekmodel.of(weekday, 1, Weekday.FRIDAY, weekday);
    }

    public static TimeAxis<Unit, CopticCalendar> axis() {
        return ENGINE;
    }

    @Override // net.time4j.engine.TimePoint, net.time4j.engine.ChronoEntity
    public TimeAxis<Unit, CopticCalendar> getChronology() {
        return ENGINE;
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        YEARS(3.15576E7d),
        MONTHS(2592000.0d),
        WEEKS(604800.0d),
        DAYS(86400.0d);

        private final transient double length;

        @Override // net.time4j.engine.ChronoUnit
        public boolean isCalendrical() {
            return true;
        }

        Unit(double d) {
            this.length = d;
        }

        @Override // net.time4j.engine.ChronoUnit
        public double getLength() {
            return this.length;
        }

        public int between(CopticCalendar copticCalendar, CopticCalendar copticCalendar2) {
            return (int) copticCalendar.until(copticCalendar2, this);
        }
    }

    static class Transformer implements EraYearMonthDaySystem<CopticCalendar> {
        private Transformer() {
        }

        @Override // net.time4j.calendar.EraYearMonthDaySystem
        public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
            return calendarEra == CopticEra.ANNO_MARTYRUM && i >= 1 && i <= 9999 && i2 >= 1 && i2 <= 13 && i3 >= 1 && i3 <= getLengthOfMonth(calendarEra, i, i2);
        }

        @Override // net.time4j.calendar.EraYearMonthDaySystem
        public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
            if (calendarEra != CopticEra.ANNO_MARTYRUM) {
                throw new IllegalArgumentException("Invalid era: " + calendarEra);
            }
            if (i >= 1 && i <= 9999 && i2 >= 1 && i2 <= 13) {
                if (i2 <= 12) {
                    return 30;
                }
                return i % 4 == 3 ? 6 : 5;
            }
            throw new IllegalArgumentException("Out of bounds: year=" + i + ", month=" + i2);
        }

        @Override // net.time4j.calendar.EraYearMonthDaySystem
        public int getLengthOfYear(CalendarEra calendarEra, int i) {
            if (calendarEra != CopticEra.ANNO_MARTYRUM) {
                throw new IllegalArgumentException("Invalid era: " + calendarEra);
            }
            if (i >= 1 && i <= 9999) {
                return i % 4 == 3 ? 366 : 365;
            }
            throw new IllegalArgumentException("Out of bounds: year=" + i);
        }

        @Override // net.time4j.engine.CalendarSystem
        public CopticCalendar transform(long j) {
            try {
                int iSafeCast = MathUtils.safeCast(MathUtils.floorDivide(MathUtils.safeAdd(MathUtils.safeMultiply(4L, MathUtils.safeSubtract(j, CopticCalendar.DIOCLETIAN)), 1463L), 1461));
                int i = 1;
                int iSafeCast2 = MathUtils.safeCast(MathUtils.floorDivide(j - ((long) MathUtils.safeCast(transform(new CopticCalendar(iSafeCast, i, i)))), 30)) + 1;
                return CopticCalendar.of(iSafeCast, iSafeCast2, MathUtils.safeCast(MathUtils.safeSubtract(j, MathUtils.safeCast(transform(new CopticCalendar(iSafeCast, iSafeCast2, i))))) + 1);
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override // net.time4j.engine.CalendarSystem
        public long transform(CopticCalendar copticCalendar) {
            return (CopticCalendar.DIOCLETIAN - 1) + ((long) ((copticCalendar.cyear - 1) * 365)) + ((long) MathUtils.floorDivide(copticCalendar.cyear, 4)) + ((long) ((copticCalendar.cmonth - 1) * 30)) + ((long) copticCalendar.cdom);
        }

        @Override // net.time4j.engine.CalendarSystem
        public long getMinimumSinceUTC() {
            int i = 1;
            return transform(new CopticCalendar(i, i, i));
        }

        @Override // net.time4j.engine.CalendarSystem
        public long getMaximumSinceUTC() {
            return transform(new CopticCalendar(9999, 13, 6));
        }

        @Override // net.time4j.engine.CalendarSystem
        public List<CalendarEra> getEras() {
            return Collections.singletonList(CopticEra.ANNO_MARTYRUM);
        }
    }

    static class IntegerRule implements ElementRule<CopticCalendar, Integer> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(CopticCalendar copticCalendar) {
            int i = this.index;
            if (i == 0) {
                return Integer.valueOf(copticCalendar.cyear);
            }
            if (i == 2) {
                return Integer.valueOf(copticCalendar.cdom);
            }
            if (i == 3) {
                int lengthOfMonth = 0;
                for (int i2 = 1; i2 < copticCalendar.cmonth; i2++) {
                    lengthOfMonth += CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, copticCalendar.cyear, i2);
                }
                return Integer.valueOf(lengthOfMonth + copticCalendar.cdom);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(CopticCalendar copticCalendar) {
            int i = this.index;
            if (i == 0 || i == 2 || i == 3) {
                return 1;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(CopticCalendar copticCalendar) {
            int i = this.index;
            if (i == 0) {
                return 9999;
            }
            if (i == 2) {
                return Integer.valueOf(CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, copticCalendar.cyear, copticCalendar.cmonth));
            }
            if (i == 3) {
                return Integer.valueOf(CopticCalendar.CALSYS.getLengthOfYear(CopticEra.ANNO_MARTYRUM, copticCalendar.cyear));
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(CopticCalendar copticCalendar, Integer num) {
            if (num == null) {
                return false;
            }
            return getMinimum(copticCalendar).compareTo(num) <= 0 && getMaximum(copticCalendar).compareTo(num) >= 0;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public CopticCalendar withValue2(CopticCalendar copticCalendar, Integer num, boolean z) {
            if (!isValid2(copticCalendar, num)) {
                throw new IllegalArgumentException("Out of range: " + num);
            }
            int i = this.index;
            if (i == 0) {
                int iIntValue = num.intValue();
                return CopticCalendar.of(iIntValue, copticCalendar.cmonth, Math.min(copticCalendar.cdom, CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, iIntValue, copticCalendar.cmonth)));
            }
            if (i == 2) {
                return new CopticCalendar(copticCalendar.cyear, copticCalendar.cmonth, num.intValue());
            }
            if (i == 3) {
                return copticCalendar.plus(CalendarDays.of(num.intValue() - getValue(copticCalendar).intValue()));
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(CopticCalendar copticCalendar) {
            if (this.index == 0) {
                return CopticCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(CopticCalendar copticCalendar) {
            if (this.index == 0) {
                return CopticCalendar.MONTH_OF_YEAR;
            }
            return null;
        }
    }

    static class MonthRule implements ElementRule<CopticCalendar, CopticMonth> {
        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(CopticCalendar copticCalendar, CopticMonth copticMonth) {
            return copticMonth != null;
        }

        private MonthRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public CopticMonth getValue(CopticCalendar copticCalendar) {
            return copticCalendar.getMonth();
        }

        @Override // net.time4j.engine.ElementRule
        public CopticMonth getMinimum(CopticCalendar copticCalendar) {
            return CopticMonth.TOUT;
        }

        @Override // net.time4j.engine.ElementRule
        public CopticMonth getMaximum(CopticCalendar copticCalendar) {
            return CopticMonth.NASIE;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public CopticCalendar withValue2(CopticCalendar copticCalendar, CopticMonth copticMonth, boolean z) {
            if (copticMonth == null) {
                throw new IllegalArgumentException("Missing month.");
            }
            int value = copticMonth.getValue();
            return new CopticCalendar(copticCalendar.cyear, value, Math.min(copticCalendar.cdom, CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, copticCalendar.cyear, value)));
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(CopticCalendar copticCalendar) {
            return CopticCalendar.DAY_OF_MONTH;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(CopticCalendar copticCalendar) {
            return CopticCalendar.DAY_OF_MONTH;
        }
    }

    static class EraRule implements ElementRule<CopticCalendar, CopticEra> {
        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(CopticCalendar copticCalendar, CopticEra copticEra) {
            return copticEra != null;
        }

        private EraRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public CopticEra getValue(CopticCalendar copticCalendar) {
            return CopticEra.ANNO_MARTYRUM;
        }

        @Override // net.time4j.engine.ElementRule
        public CopticEra getMinimum(CopticCalendar copticCalendar) {
            return CopticEra.ANNO_MARTYRUM;
        }

        @Override // net.time4j.engine.ElementRule
        public CopticEra getMaximum(CopticCalendar copticCalendar) {
            return CopticEra.ANNO_MARTYRUM;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public CopticCalendar withValue2(CopticCalendar copticCalendar, CopticEra copticEra, boolean z) {
            if (copticEra != null) {
                return copticCalendar;
            }
            throw new IllegalArgumentException("Missing era value.");
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(CopticCalendar copticCalendar) {
            return CopticCalendar.YEAR_OF_ERA;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(CopticCalendar copticCalendar) {
            return CopticCalendar.YEAR_OF_ERA;
        }
    }

    static class Merger implements ChronoMerger<CopticCalendar> {
        @Override // net.time4j.engine.ChronoMerger
        public ChronoDisplay preformat(CopticCalendar copticCalendar, AttributeQuery attributeQuery) {
            return copticCalendar;
        }

        @Override // net.time4j.engine.ChronoMerger
        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        @Override // net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ CopticCalendar createFrom(TimeSource timeSource, AttributeQuery attributeQuery) {
            return createFrom2((TimeSource<?>) timeSource, attributeQuery);
        }

        @Override // net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ CopticCalendar createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            return createFrom2((ChronoEntity<?>) chronoEntity, attributeQuery, z, z2);
        }

        @Override // net.time4j.engine.ChronoMerger
        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("coptic", displayStyle, locale);
        }

        @Override // net.time4j.engine.ChronoMerger
        /* JADX INFO: renamed from: createFrom, reason: avoid collision after fix types in other method */
        public CopticCalendar createFrom2(TimeSource<?> timeSource, AttributeQuery attributeQuery) {
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
            return (CopticCalendar) Moment.from(timeSource.currentTime()).toGeneralTimestamp(CopticCalendar.ENGINE, id, (StartOfDay) attributeQuery.get(Attributes.START_OF_DAY, getDefaultStartOfDay())).toDate();
        }

        @Override // net.time4j.engine.ChronoMerger
        /* JADX INFO: renamed from: createFrom, reason: avoid collision after fix types in other method */
        public CopticCalendar createFrom2(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            int i = chronoEntity.getInt(CopticCalendar.YEAR_OF_ERA);
            if (i == Integer.MIN_VALUE) {
                chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Missing Coptic year.");
                return null;
            }
            StdCalendarElement<CopticMonth, CopticCalendar> stdCalendarElement = CopticCalendar.MONTH_OF_YEAR;
            if (chronoEntity.contains(stdCalendarElement)) {
                int value = ((CopticMonth) chronoEntity.get(stdCalendarElement)).getValue();
                int i2 = chronoEntity.getInt(CopticCalendar.DAY_OF_MONTH);
                if (i2 != Integer.MIN_VALUE) {
                    if (CopticCalendar.CALSYS.isValid(CopticEra.ANNO_MARTYRUM, i, value, i2)) {
                        return CopticCalendar.of(i, value, i2);
                    }
                    chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Invalid Coptic date.");
                }
            } else {
                int i3 = chronoEntity.getInt(CopticCalendar.DAY_OF_YEAR);
                if (i3 != Integer.MIN_VALUE) {
                    if (i3 > 0) {
                        int i4 = 1;
                        int i5 = 0;
                        while (i4 <= 13) {
                            int lengthOfMonth = CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, i, i4) + i5;
                            if (i3 <= lengthOfMonth) {
                                return CopticCalendar.of(i, i4, i3 - i5);
                            }
                            i4++;
                            i5 = lengthOfMonth;
                        }
                    }
                    chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Invalid Coptic date.");
                }
            }
            return null;
        }

        @Override // net.time4j.engine.ChronoMerger
        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.EVENING;
        }

        @Override // net.time4j.engine.ChronoMerger
        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear() - 284;
        }
    }

    static class CopticUnitRule implements UnitRule<CopticCalendar> {
        private final Unit unit;

        CopticUnitRule(Unit unit) {
            this.unit = unit;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.engine.UnitRule
        public CopticCalendar addTo(CopticCalendar copticCalendar, long j) {
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$CopticCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                j = MathUtils.safeMultiply(j, 13L);
            } else if (i != 2) {
                if (i == 3) {
                    j = MathUtils.safeMultiply(j, 7L);
                } else if (i != 4) {
                    throw new UnsupportedOperationException(this.unit.name());
                }
                return (CopticCalendar) CopticCalendar.CALSYS.transform(MathUtils.safeAdd(CopticCalendar.CALSYS.transform(copticCalendar), j));
            }
            long jSafeAdd = MathUtils.safeAdd(ymValue(copticCalendar), j);
            int iSafeCast = MathUtils.safeCast(MathUtils.floorDivide(jSafeAdd, 13));
            int iFloorModulo = MathUtils.floorModulo(jSafeAdd, 13) + 1;
            return CopticCalendar.of(iSafeCast, iFloorModulo, Math.min(copticCalendar.cdom, CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, iSafeCast, iFloorModulo)));
        }

        @Override // net.time4j.engine.UnitRule
        public long between(CopticCalendar copticCalendar, CopticCalendar copticCalendar2) {
            int iBetween;
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$CopticCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                iBetween = Unit.MONTHS.between(copticCalendar, copticCalendar2) / 13;
            } else {
                if (i == 2) {
                    long jYmValue = ymValue(copticCalendar2) - ymValue(copticCalendar);
                    if (jYmValue <= 0 || copticCalendar2.cdom >= copticCalendar.cdom) {
                        return (jYmValue >= 0 || copticCalendar2.cdom <= copticCalendar.cdom) ? jYmValue : jYmValue + 1;
                    }
                    return jYmValue - 1;
                }
                if (i != 3) {
                    if (i == 4) {
                        return CopticCalendar.CALSYS.transform(copticCalendar2) - CopticCalendar.CALSYS.transform(copticCalendar);
                    }
                    throw new UnsupportedOperationException(this.unit.name());
                }
                iBetween = Unit.DAYS.between(copticCalendar, copticCalendar2) / 7;
            }
            return iBetween;
        }

        private static int ymValue(CopticCalendar copticCalendar) {
            return ((copticCalendar.cyear * 13) + copticCalendar.cmonth) - 1;
        }
    }

    /* JADX INFO: renamed from: net.time4j.calendar.CopticCalendar$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$CopticCalendar$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$net$time4j$calendar$CopticCalendar$Unit = iArr;
            try {
                iArr[Unit.YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$calendar$CopticCalendar$Unit[Unit.MONTHS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$calendar$CopticCalendar$Unit[Unit.WEEKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$time4j$calendar$CopticCalendar$Unit[Unit.DAYS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static class SPX implements Externalizable {
        private static final int COPTIC = 3;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj) {
            this.obj = obj;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(3);
            writeCoptic(objectOutput);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 3) {
                this.obj = readCoptic(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeCoptic(ObjectOutput objectOutput) throws IOException {
            CopticCalendar copticCalendar = (CopticCalendar) this.obj;
            objectOutput.writeInt(copticCalendar.getYear());
            objectOutput.writeByte(copticCalendar.getMonth().getValue());
            objectOutput.writeByte(copticCalendar.getDayOfMonth());
        }

        private CopticCalendar readCoptic(ObjectInput objectInput) throws IOException {
            return CopticCalendar.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
        }
    }
}
