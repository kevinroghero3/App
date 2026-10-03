package net.time4j.calendar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.time4j.PlainDate;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.ChronoFunction;

/* JADX INFO: loaded from: classes6.dex */
public enum HebrewAnniversary {
    BIRTHDAY { // from class: net.time4j.calendar.HebrewAnniversary.1
        @Override // net.time4j.calendar.HebrewAnniversary
        public ChronoFunction<CalendarDate, HebrewCalendar> inHebrewYear(final int i) {
            return new ChronoFunction<CalendarDate, HebrewCalendar>() { // from class: net.time4j.calendar.HebrewAnniversary.1.1
                @Override // net.time4j.engine.ChronoFunction
                public HebrewCalendar apply(CalendarDate calendarDate) {
                    HebrewCalendar hebrewCalendarConvert = HebrewAnniversary.convert(calendarDate);
                    int dayOfMonth = hebrewCalendarConvert.getDayOfMonth();
                    HebrewMonth month = hebrewCalendarConvert.getMonth();
                    HebrewMonth hebrewMonth = HebrewMonth.ADAR_II;
                    if (month == hebrewMonth) {
                        int i2 = i;
                        return HebrewCalendar.ofBiblical(i2, HebrewCalendar.isLeapYear(i2) ? 13 : 12, dayOfMonth);
                    }
                    HebrewMonth month2 = hebrewCalendarConvert.getMonth();
                    if (month2 != HebrewMonth.ADAR_I || HebrewCalendar.isLeapYear(i)) {
                        hebrewMonth = month2;
                    }
                    if (dayOfMonth <= 29) {
                        return HebrewCalendar.of(i, hebrewMonth, dayOfMonth);
                    }
                    return HebrewCalendar.of(i, hebrewMonth, 1).plus(CalendarDays.of(dayOfMonth - 1));
                }
            };
        }
    },
    YAHRZEIT { // from class: net.time4j.calendar.HebrewAnniversary.2
        @Override // net.time4j.calendar.HebrewAnniversary
        public ChronoFunction<CalendarDate, HebrewCalendar> inHebrewYear(final int i) {
            return new ChronoFunction<CalendarDate, HebrewCalendar>() { // from class: net.time4j.calendar.HebrewAnniversary.2.1
                @Override // net.time4j.engine.ChronoFunction
                public HebrewCalendar apply(CalendarDate calendarDate) {
                    HebrewCalendar hebrewCalendarConvert = HebrewAnniversary.convert(calendarDate);
                    int year = hebrewCalendarConvert.getYear();
                    HebrewMonth month = hebrewCalendarConvert.getMonth();
                    int dayOfMonth = hebrewCalendarConvert.getDayOfMonth();
                    HebrewMonth hebrewMonth = HebrewMonth.HESHVAN;
                    if (month == hebrewMonth && dayOfMonth == 30 && HebrewCalendar.lengthOfMonth(year + 1, hebrewMonth) == 29) {
                        return HebrewCalendar.of(i, HebrewMonth.KISLEV, 1).minus(CalendarDays.ONE);
                    }
                    HebrewMonth hebrewMonth2 = HebrewMonth.KISLEV;
                    if (month == hebrewMonth2 && dayOfMonth == 30 && HebrewCalendar.lengthOfMonth(year + 1, hebrewMonth2) == 29) {
                        return HebrewCalendar.of(i, HebrewMonth.TEVET, 1).minus(CalendarDays.ONE);
                    }
                    HebrewMonth hebrewMonth3 = HebrewMonth.ADAR_II;
                    if (month == hebrewMonth3 && HebrewCalendar.isLeapYear(year)) {
                        return HebrewCalendar.of(i, hebrewMonth3, dayOfMonth);
                    }
                    if (month.getBiblicalValue(false) == 12 && dayOfMonth == 30 && !HebrewCalendar.isLeapYear(i)) {
                        return HebrewCalendar.of(i, HebrewMonth.SHEVAT, 30);
                    }
                    return HebrewCalendar.ofBiblical(i, month.getBiblicalValue(false), 1).plus(CalendarDays.of(dayOfMonth - 1));
                }
            };
        }
    };

    public ChronoFunction<CalendarDate, HebrewCalendar> inHebrewYear(int i) {
        throw new AbstractMethodError();
    }

    public ChronoFunction<CalendarDate, List<PlainDate>> inGregorianYear(final int i) {
        return new ChronoFunction<CalendarDate, List<PlainDate>>() { // from class: net.time4j.calendar.HebrewAnniversary.3
            @Override // net.time4j.engine.ChronoFunction
            public List<PlainDate> apply(CalendarDate calendarDate) {
                HebrewCalendar hebrewCalendarConvert = HebrewAnniversary.convert(calendarDate);
                int year = ((HebrewCalendar) PlainDate.of(i, 1, 1).transform(HebrewCalendar.class)).getYear();
                PlainDate plainDate = (PlainDate) HebrewAnniversary.this.inHebrewYear(year).apply(hebrewCalendarConvert).transform(PlainDate.class);
                PlainDate plainDate2 = (PlainDate) HebrewAnniversary.this.inHebrewYear(year + 1).apply(hebrewCalendarConvert).transform(PlainDate.class);
                ArrayList arrayList = new ArrayList(2);
                if (plainDate.getYear() == i) {
                    arrayList.add(plainDate);
                }
                if (plainDate2.getYear() == i) {
                    arrayList.add(plainDate2);
                }
                return Collections.unmodifiableList(arrayList);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HebrewCalendar convert(CalendarDate calendarDate) {
        if (calendarDate instanceof HebrewCalendar) {
            return (HebrewCalendar) calendarDate;
        }
        return (HebrewCalendar) HebrewCalendar.axis().getCalendarSystem().transform(calendarDate.getDaysSinceEpochUTC());
    }
}
