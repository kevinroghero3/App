package net.time4j.calendar.hindu;

import androidx.core.text.util.LocalePreferences;
import java.io.Serializable;
import java.util.Locale;
import net.time4j.calendar.IndianMonth;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.ChronoCondition;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextWidth;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class HinduMonth extends HinduPrimitive implements Comparable<HinduMonth>, ChronoCondition<HinduCalendar>, Serializable {
    public static final AttributeKey<Boolean> RASI_NAMES = Attributes.createKey("RASI_NAMES", Boolean.class);
    private final boolean leap;
    private final IndianMonth value;

    private HinduMonth(IndianMonth indianMonth, boolean z) {
        if (indianMonth == null) {
            throw new NullPointerException("Missing Indian month.");
        }
        this.value = indianMonth;
        this.leap = z;
    }

    public static HinduMonth of(IndianMonth indianMonth) {
        return new HinduMonth(indianMonth, false);
    }

    public static HinduMonth ofLunisolar(int i) {
        return new HinduMonth(IndianMonth.valueOf(i), false);
    }

    public static HinduMonth ofSolar(int i) {
        return new HinduMonth(IndianMonth.valueOf(i != 12 ? 1 + i : 1), false);
    }

    public IndianMonth getValue() {
        return this.value;
    }

    public int getRasi() {
        IndianMonth indianMonth = this.value;
        if (indianMonth == IndianMonth.CHAITRA) {
            return 12;
        }
        return indianMonth.getValue() - 1;
    }

    public String getRasi(Locale locale) {
        String strPrint = CalendarText.getInstance("hindu", locale).getTextForms("R", IndianMonth.class, new String[0]).print(IndianMonth.valueOf(getRasi()));
        if (!this.leap) {
            return strPrint;
        }
        return getAdhika(locale) + strPrint;
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE, OutputContext.FORMAT);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth, OutputContext outputContext) {
        String strPrint = CalendarText.getInstance(LocalePreferences.CalendarType.INDIAN, locale).getStdMonths(textWidth, outputContext).print(this.value);
        if (!this.leap) {
            return strPrint;
        }
        return getAdhika(locale) + strPrint;
    }

    @Override // net.time4j.calendar.hindu.HinduPrimitive
    public boolean isLeap() {
        return this.leap;
    }

    public HinduMonth withLeap() {
        return this.leap ? this : new HinduMonth(this.value, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HinduMonth)) {
            return false;
        }
        HinduMonth hinduMonth = (HinduMonth) obj;
        return this.value == hinduMonth.value && this.leap == hinduMonth.leap;
    }

    public int hashCode() {
        return this.value.hashCode() + (this.leap ? 12 : 0);
    }

    public String toString() {
        String string = this.value.toString();
        if (!this.leap) {
            return string;
        }
        return "*" + string;
    }

    @Override // java.lang.Comparable
    public int compareTo(HinduMonth hinduMonth) {
        int iCompareTo = this.value.compareTo(hinduMonth.value);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (this.leap) {
            return hinduMonth.leap ? 0 : -1;
        }
        return hinduMonth.leap ? 1 : 0;
    }

    @Override // net.time4j.engine.ChronoCondition
    public boolean test(HinduCalendar hinduCalendar) {
        return equals(hinduCalendar.getMonth());
    }

    private static String getAdhika(Locale locale) {
        return CalendarText.getInstance("hindu", locale).getTextForms().get("adhika") + StringUtils.SPACE;
    }
}
