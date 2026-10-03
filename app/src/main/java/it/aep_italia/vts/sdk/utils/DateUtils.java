package it.aep_italia.vts.sdk.utils;

import it.aep_italia.vts.sdk.core.VtsLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class DateUtils {
    private static final Pattern a = Pattern.compile("^(N{1,4}-NN?-NN?TNN?:NN?:NN?)(\\.N{1,3})?([-+]NN?(:NN?)?)?$".replaceAll("N", "[0-9]"));
    private static final SimpleDateFormat b;
    private static final SimpleDateFormat c;
    private static final SimpleDateFormat d;
    private static final SimpleDateFormat e;
    private static final SimpleDateFormat f;
    private static final SimpleDateFormat g;
    private static final SimpleDateFormat h;
    private static final SimpleDateFormat i;
    private static final SimpleDateFormat j;
    private static final SimpleDateFormat k;

    static {
        Locale locale = Locale.ITALY;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", locale);
        b = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", locale);
        c = simpleDateFormat2;
        d = new SimpleDateFormat("dd MMMM yyyy, HH:mm", locale);
        e = new SimpleDateFormat("dd/MM/yyyy, HH:mm", locale);
        f = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss", locale);
        g = new SimpleDateFormat("dd MMMM yyyy", locale);
        h = new SimpleDateFormat("dd/MM/yyyy", locale);
        i = new SimpleDateFormat("yyyy-MM-dd", locale);
        j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        k = new SimpleDateFormat("HH:mm", locale);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
    }

    public static Date fromDateString(String str) throws IllegalArgumentException {
        if (str == null) {
            return null;
        }
        try {
            return h.parse(str.trim());
        } catch (ParseException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Date fromISO8601(String str) {
        if (str == null) {
            return null;
        }
        String strReplaceFirst = str.replaceFirst("\\.([0-9]{3,3})[0-9]+", ".$1").replaceFirst("Z$", "+00:00");
        Matcher matcher = a.matcher(strReplaceFirst);
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            if (matcher.group(2) == null) {
                strReplaceFirst = strGroup + ".000";
            } else {
                strReplaceFirst = strGroup + matcher.group(2);
            }
            if (matcher.group(3) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(matcher.group(3));
                sb.append(matcher.group(4) == null ? ":00" : "");
                strReplaceFirst = strReplaceFirst + sb.toString().replaceAll(":", "");
            }
        }
        try {
            return matcher.group(3) != null ? c.parse(strReplaceFirst) : b.parse(strReplaceFirst);
        } catch (Exception unused) {
            VtsLog.w("Could not decode ISO-8601 date from string '%s'.", str);
            return null;
        }
    }

    public static Date fromServerDateString(String str) throws IllegalArgumentException {
        if (str == null) {
            return null;
        }
        try {
            return i.parse(str.trim());
        } catch (ParseException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Date fromServerDateTimeString(String str) throws IllegalArgumentException {
        if (str == null) {
            return null;
        }
        try {
            return j.parse(str.trim());
        } catch (ParseException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static long getLastLocalMidnight() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static String toDateString(Date date) {
        if (date == null) {
            return null;
        }
        return h.format(date);
    }

    public static String toHuman(Date date) {
        if (date == null) {
            return null;
        }
        return d.format(date);
    }

    public static String toHumanDate(Date date) {
        if (date == null) {
            return null;
        }
        return g.format(date);
    }

    public static String toHumanShort(Date date) {
        if (date == null) {
            return null;
        }
        return e.format(date);
    }

    public static String toHumanShortDate(Date date) {
        if (date == null) {
            return null;
        }
        return h.format(date);
    }

    public static String toHumanShortWithSeconds(Date date) {
        if (date == null) {
            return null;
        }
        return f.format(date);
    }

    public static String toISO8601(Date date) {
        if (date == null) {
            return null;
        }
        return c.format(date).replaceFirst("([-+]\\d\\d)(\\d\\d)$", "$1:$2");
    }

    public static String toServerDateString(Date date) {
        if (date == null) {
            return null;
        }
        return i.format(date);
    }

    public static String toTimeShort(Date date) {
        if (date == null) {
            return null;
        }
        return k.format(date);
    }
}
