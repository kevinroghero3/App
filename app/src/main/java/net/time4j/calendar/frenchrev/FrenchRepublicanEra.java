package net.time4j.calendar.frenchrev;

import java.util.Locale;
import net.time4j.engine.CalendarEra;
import net.time4j.format.CalendarText;
import net.time4j.format.TextWidth;

/* JADX INFO: loaded from: classes6.dex */
public enum FrenchRepublicanEra implements CalendarEra {
    REPUBLICAN;

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getInstance("frenchrev", locale).getEras(textWidth).print(this);
    }
}
