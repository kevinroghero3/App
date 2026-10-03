package net.time4j.calendar;

import androidx.core.text.util.LocalePreferences;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.VariantSource;

/* JADX INFO: loaded from: classes6.dex */
public enum HijriAlgorithm implements VariantSource {
    EAST_ISLAMIC_CIVIL("islamic-eastc", new int[]{2, 5, 7, 10, 13, 15, 18, 21, 24, 26, 29}, true),
    EAST_ISLAMIC_ASTRO("islamic-easta", new int[]{2, 5, 7, 10, 13, 15, 18, 21, 24, 26, 29}, false),
    WEST_ISLAMIC_CIVIL(LocalePreferences.CalendarType.ISLAMIC_CIVIL, new int[]{2, 5, 7, 10, 13, 16, 18, 21, 24, 26, 29}, true),
    WEST_ISLAMIC_ASTRO(LocalePreferences.CalendarType.ISLAMIC_TBLA, new int[]{2, 5, 7, 10, 13, 16, 18, 21, 24, 26, 29}, false),
    FATIMID_CIVIL("islamic-fatimidc", new int[]{2, 5, 8, 10, 13, 16, 19, 21, 24, 27, 29}, true),
    FATIMID_ASTRO("islamic-fatimida", new int[]{2, 5, 8, 10, 13, 16, 19, 21, 24, 27, 29}, false),
    HABASH_AL_HASIB_CIVIL("islamic-habashalhasibc", new int[]{2, 5, 8, 11, 13, 16, 19, 21, 24, 27, 30}, true),
    HABASH_AL_HASIB_ASTRO("islamic-habashalhasiba", new int[]{2, 5, 8, 11, 13, 16, 19, 21, 24, 27, 30}, false);

    private final transient Transformer calsys;
    private static final long LENGTH_OF_30_YEAR_CYCLE = 10631;
    private static final long START_622_07_15 = -492879;
    private static final long START_622_07_16 = -492878;
    private static final int MAX_YEAR = 1600;
    private static final long ASTRO_1600_12_29 = 74106;
    private static final long CIVIL_1600_12_29 = 74107;

    HijriAlgorithm(String str, int[] iArr, boolean z) {
        this.calsys = new Transformer(str, iArr, z, 0);
    }

    @Override // net.time4j.engine.VariantSource
    public String getVariant() {
        return this.calsys.variant;
    }

    EraYearMonthDaySystem<HijriCalendar> getCalendarSystem(int i) {
        if (i == 0) {
            return this.calsys;
        }
        return new Transformer(HijriAdjustment.of(getVariant(), i).getVariant(), this.calsys.intercalaries, this.calsys.civil, i);
    }

    static class Transformer implements EraYearMonthDaySystem<HijriCalendar> {
        private final int adjustment;
        private final boolean civil;
        private final int[] intercalaries;
        private final String variant;

        Transformer(String str, int[] iArr, boolean z, int i) {
            this.variant = str;
            this.intercalaries = iArr;
            this.civil = z;
            this.adjustment = i;
        }

        @Override // net.time4j.calendar.EraYearMonthDaySystem
        public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
            return calendarEra == HijriEra.ANNO_HEGIRAE && i >= 1 && i <= HijriAlgorithm.MAX_YEAR && i2 >= 1 && i2 <= 12 && i3 >= 1 && i3 <= getLengthOfMonth(calendarEra, i, i2);
        }

        @Override // net.time4j.calendar.EraYearMonthDaySystem
        public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
            if (calendarEra == HijriEra.ANNO_HEGIRAE) {
                if (i >= 1 && i <= HijriAlgorithm.MAX_YEAR && i2 >= 1 && i2 <= 12) {
                    if (i2 == 12) {
                        return Arrays.binarySearch(this.intercalaries, ((i - 1) % 30) + 1) >= 0 ? 30 : 29;
                    }
                    return i2 % 2 == 1 ? 30 : 29;
                }
                throw new IllegalArgumentException("Out of bounds: " + i + RemoteSettings.FORWARD_SLASH_STRING + i2);
            }
            throw new IllegalArgumentException("Wrong era: " + calendarEra);
        }

        @Override // net.time4j.calendar.EraYearMonthDaySystem
        public int getLengthOfYear(CalendarEra calendarEra, int i) {
            if (calendarEra == HijriEra.ANNO_HEGIRAE) {
                if (i >= 1 && i <= HijriAlgorithm.MAX_YEAR) {
                    return Arrays.binarySearch(this.intercalaries, ((i - 1) % 30) + 1) >= 0 ? 355 : 354;
                }
                throw new IllegalArgumentException("Out of bounds: yearOfEra=" + i);
            }
            throw new IllegalArgumentException("Wrong era: " + calendarEra);
        }

        @Override // net.time4j.engine.CalendarSystem
        public HijriCalendar transform(long j) {
            int i;
            long jSafeAdd = MathUtils.safeAdd(j, this.adjustment);
            long j2 = this.civil ? HijriAlgorithm.START_622_07_16 : HijriAlgorithm.START_622_07_15;
            if (jSafeAdd >= j2) {
                if (jSafeAdd <= (this.civil ? HijriAlgorithm.CIVIL_1600_12_29 : HijriAlgorithm.ASTRO_1600_12_29)) {
                    long jSafeSubtract = MathUtils.safeSubtract(jSafeAdd, j2);
                    int i2 = 1;
                    int iSafeCast = MathUtils.safeCast((jSafeSubtract / HijriAlgorithm.LENGTH_OF_30_YEAR_CYCLE) * 30) + 1;
                    int i3 = (int) (jSafeSubtract % HijriAlgorithm.LENGTH_OF_30_YEAR_CYCLE);
                    int i4 = 1;
                    while (true) {
                        i = 30;
                        if (i4 >= 30) {
                            break;
                        }
                        int i5 = Arrays.binarySearch(this.intercalaries, i4) >= 0 ? 355 : 354;
                        if (i3 <= i5) {
                            break;
                        }
                        i3 -= i5;
                        iSafeCast++;
                        i4++;
                    }
                    int i6 = 1;
                    for (int i7 = 1; i7 < 12; i7++) {
                        int i8 = i7 % 2 == 0 ? 29 : 30;
                        if (i3 <= i8) {
                            break;
                        }
                        i3 -= i8;
                        i6++;
                    }
                    int i9 = i3 + 1;
                    if (i6 != 12 ? i6 % 2 != 1 : Arrays.binarySearch(this.intercalaries, ((iSafeCast - 1) % 30) + 1) < 0) {
                        i = 29;
                    }
                    if (i9 <= i) {
                        i2 = i6;
                    } else {
                        i6++;
                        if (i6 > 12) {
                            iSafeCast++;
                            i9 = 1;
                        } else {
                            i9 = 1;
                            i2 = i6;
                        }
                    }
                    return HijriCalendar.of(this.variant, iSafeCast, i2, i9);
                }
            }
            throw new IllegalArgumentException("Out of supported range: " + j);
        }

        @Override // net.time4j.engine.CalendarSystem
        public long transform(HijriCalendar hijriCalendar) {
            int year = hijriCalendar.getYear();
            int value = hijriCalendar.getMonth().getValue();
            int dayOfMonth = hijriCalendar.getDayOfMonth();
            if (year >= 1 && year <= HijriAlgorithm.MAX_YEAR && value >= 1 && value <= 12 && dayOfMonth >= 1 && dayOfMonth <= 30) {
                int i = year - 1;
                long j = ((long) (i / 30)) * HijriAlgorithm.LENGTH_OF_30_YEAR_CYCLE;
                int i2 = (i % 30) + 1;
                for (int i3 = 1; i3 < i2; i3++) {
                    j += Arrays.binarySearch(this.intercalaries, i3) >= 0 ? 355L : 354L;
                }
                for (int i4 = 1; i4 < value; i4++) {
                    j += i4 % 2 == 0 ? 29L : 30L;
                }
                if (dayOfMonth == 30 && ((value == 12 && Arrays.binarySearch(this.intercalaries, i2) < 0) || (value != 12 && value % 2 == 0))) {
                    throw new IllegalArgumentException("Invalid day-of-month: " + hijriCalendar);
                }
                return MathUtils.safeSubtract(((this.civil ? HijriAlgorithm.START_622_07_16 : HijriAlgorithm.START_622_07_15) + (j + ((long) dayOfMonth))) - 1, this.adjustment);
            }
            throw new IllegalArgumentException("Out of supported range: " + hijriCalendar);
        }

        @Override // net.time4j.engine.CalendarSystem
        public long getMinimumSinceUTC() {
            return MathUtils.safeSubtract(this.civil ? HijriAlgorithm.START_622_07_16 : HijriAlgorithm.START_622_07_15, this.adjustment);
        }

        @Override // net.time4j.engine.CalendarSystem
        public long getMaximumSinceUTC() {
            return MathUtils.safeSubtract(this.civil ? HijriAlgorithm.CIVIL_1600_12_29 : HijriAlgorithm.ASTRO_1600_12_29, this.adjustment);
        }

        @Override // net.time4j.engine.CalendarSystem
        public List<CalendarEra> getEras() {
            return Collections.singletonList(HijriEra.ANNO_HEGIRAE);
        }
    }
}
