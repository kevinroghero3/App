package net.time4j.calendar;

import androidx.core.text.util.LocalePreferences;
import java.util.Locale;
import net.time4j.engine.CalendarEra;
import net.time4j.format.CalendarText;
import net.time4j.format.TextWidth;

/* JADX INFO: loaded from: classes6.dex */
public enum HebrewEra implements CalendarEra {
    ANNO_MUNDI;

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getInstance(LocalePreferences.CalendarType.HEBREW, locale).getEras(textWidth).print(this);
    }
}
