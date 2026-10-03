package org.joda.time.chrono;

import org.joda.time.Chronology;

/* JADX INFO: loaded from: classes3.dex */
abstract class BasicGJChronology extends BasicChronology {
    private static final long FEB_29 = 5097600000L;
    private static final long serialVersionUID = 538276888268L;
    private static final int[] MIN_DAYS_PER_MONTH_ARRAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] MAX_DAYS_PER_MONTH_ARRAY = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final long[] MIN_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
    private static final long[] MAX_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];

    static {
        long j = 0;
        int i = 0;
        long j2 = 0;
        while (i < 11) {
            j += ((long) MIN_DAYS_PER_MONTH_ARRAY[i]) * 86400000;
            int i2 = i + 1;
            MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[i2] = j;
            j2 += ((long) MAX_DAYS_PER_MONTH_ARRAY[i]) * 86400000;
            MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[i2] = j2;
            i = i2;
        }
    }

    BasicGJChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    @Override // org.joda.time.chrono.BasicChronology
    boolean isLeapDay(long j) {
        return dayOfMonth().get(j) == 29 && monthOfYear().isLeap(j);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0061 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0063 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0071 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0073 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0086 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0089 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0097 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x009a A[ORIG_RETURN, RETURN] */
    @Override // org.joda.time.chrono.BasicChronology
    int getMonthOfYear(long j, int i) {
        int yearMillis = (int) ((j - getYearMillis(i)) >> 10);
        if (isLeapYear(i)) {
            if (yearMillis < 15356250) {
                if (yearMillis < 7678125) {
                    if (yearMillis >= 2615625) {
                        if (yearMillis < 5062500) {
                            return 2;
                        }
                        return 3;
                    }
                    return 1;
                }
                if (yearMillis >= 10209375) {
                    if (yearMillis < 12825000) {
                        return 5;
                    }
                    return 6;
                }
                return 4;
            }
            if (yearMillis < 23118750) {
                if (yearMillis >= 17971875) {
                    if (yearMillis < 20587500) {
                        return 8;
                    }
                    return 9;
                }
                return 7;
            }
            if (yearMillis < 25734375) {
                return 10;
            }
            if (yearMillis < 28265625) {
                return 11;
            }
            return 12;
        }
        if (yearMillis < 15271875) {
            if (yearMillis < 7593750) {
                if (yearMillis >= 2615625) {
                    if (yearMillis < 4978125) {
                        return 2;
                    }
                    return 3;
                }
                return 1;
            }
            if (yearMillis >= 10125000) {
                if (yearMillis < 12740625) {
                    return 5;
                }
                return 6;
            }
            return 4;
        }
        if (yearMillis < 23034375) {
            if (yearMillis >= 17887500) {
                if (yearMillis < 20503125) {
                    return 8;
                }
                return 9;
            }
            return 7;
        }
        if (yearMillis < 25650000) {
            return 10;
        }
        if (yearMillis < 28181250) {
            return 11;
        }
        return 12;
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getDaysInYearMonth(int i, int i2) {
        if (isLeapYear(i)) {
            return MAX_DAYS_PER_MONTH_ARRAY[i2 - 1];
        }
        return MIN_DAYS_PER_MONTH_ARRAY[i2 - 1];
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getDaysInMonthMax(int i) {
        return MAX_DAYS_PER_MONTH_ARRAY[i - 1];
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getDaysInMonthMaxForSet(long j, int i) {
        if (i > 28 || i < 1) {
            return getDaysInMonthMax(j);
        }
        return 28;
    }

    @Override // org.joda.time.chrono.BasicChronology
    long getTotalMillisByYearMonth(int i, int i2) {
        if (isLeapYear(i)) {
            return MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[i2 - 1];
        }
        return MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[i2 - 1];
    }

    @Override // org.joda.time.chrono.BasicChronology
    long getYearDifference(long j, long j2) {
        int year = getYear(j);
        int year2 = getYear(j2);
        long yearMillis = j - getYearMillis(year);
        long yearMillis2 = j2 - getYearMillis(year2);
        if (yearMillis2 >= FEB_29) {
            if (isLeapYear(year2)) {
                if (!isLeapYear(year)) {
                    yearMillis2 -= 86400000;
                }
            } else if (yearMillis >= FEB_29 && isLeapYear(year)) {
                yearMillis -= 86400000;
            }
        }
        int i = year - year2;
        if (yearMillis < yearMillis2) {
            i--;
        }
        return i;
    }

    @Override // org.joda.time.chrono.BasicChronology
    long setYear(long j, int i) {
        int year = getYear(j);
        int dayOfYear = getDayOfYear(j, year);
        int millisOfDay = getMillisOfDay(j);
        if (dayOfYear > 59) {
            if (isLeapYear(year)) {
                if (!isLeapYear(i)) {
                    dayOfYear--;
                }
            } else if (isLeapYear(i)) {
                dayOfYear++;
            }
        }
        return getYearMonthDayMillis(i, 1, dayOfYear) + ((long) millisOfDay);
    }
}
