package net.time4j.calendar;

import androidx.core.text.util.LocalePreferences;
import java.util.Locale;
import net.time4j.engine.CalendarEra;
import net.time4j.format.CalendarText;
import net.time4j.format.TextWidth;

/* JADX INFO: loaded from: classes6.dex */
public enum HijriEra implements CalendarEra {
    ANNO_HEGIRAE;

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getInstance(LocalePreferences.CalendarType.ISLAMIC, locale).getEras(textWidth).print(this);
    }
}
