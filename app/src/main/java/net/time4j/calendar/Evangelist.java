package net.time4j.calendar;

import java.util.Locale;
import net.time4j.format.CalendarText;

/* JADX INFO: loaded from: classes6.dex */
public enum Evangelist {
    MATTHEW,
    MARK,
    LUKE,
    JOHN;

    public String getDisplayName(Locale locale) {
        return CalendarText.getInstance("generic", locale).getTextForms("EV", Evangelist.class, new String[0]).print(this);
    }
}
