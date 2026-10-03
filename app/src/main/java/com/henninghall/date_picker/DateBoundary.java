package com.henninghall.date_picker;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public class DateBoundary {
    private Calendar date;

    DateBoundary(TimeZone timeZone, String str) {
        if (str == null) {
            return;
        }
        this.date = Utils.getTruncatedCalendarOrNull(Utils.isoToCalendar(str, timeZone));
    }

    protected Calendar get() {
        return this.date;
    }
}
