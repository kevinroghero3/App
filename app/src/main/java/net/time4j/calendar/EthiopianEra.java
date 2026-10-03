package net.time4j.calendar;

import java.util.Locale;
import net.time4j.engine.CalendarEra;
import net.time4j.format.CalendarText;
import net.time4j.format.TextWidth;

/* JADX INFO: loaded from: classes6.dex */
public enum EthiopianEra implements CalendarEra {
    AMETE_ALEM,
    AMETE_MIHRET;

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getInstance("ethiopic", locale).getEras(textWidth).print(this);
    }
}
