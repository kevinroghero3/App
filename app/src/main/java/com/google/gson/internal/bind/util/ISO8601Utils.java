package com.google.gson.internal.bind.util;

import ch.qos.logback.core.CoreConstants;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* JADX INFO: loaded from: classes5.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    private ISO8601Utils() {
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder((z ? 4 : 0) + 19 + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        char c = CoreConstants.DASH_CHAR;
        sb.append(CoreConstants.DASH_CHAR);
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append(CoreConstants.DASH_CHAR);
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(CoreConstants.COLON_CHAR);
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(CoreConstants.COLON_CHAR);
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int iAbs = Math.abs(i / 60);
            int iAbs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            padInt(sb, iAbs, 2);
            sb.append(CoreConstants.COLON_CHAR);
            padInt(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00d4 A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0, IndexOutOfBoundsException -> 0x01c2, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:24:0x0077, B:26:0x007d, B:30:0x0087, B:35:0x0097, B:37:0x009f, B:48:0x00ce, B:50:0x00d4, B:52:0x00da, B:76:0x0187, B:56:0x00e4, B:57:0x00ff, B:58:0x0100, B:62:0x011c, B:64:0x0129, B:67:0x0132, B:69:0x0151, B:72:0x0160, B:73:0x0182, B:75:0x0185, B:61:0x010b, B:78:0x01b8, B:79:0x01bf, B:41:0x00b7, B:42:0x00ba), top: B:93:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00da A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0, IndexOutOfBoundsException -> 0x01c2, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:24:0x0077, B:26:0x007d, B:30:0x0087, B:35:0x0097, B:37:0x009f, B:48:0x00ce, B:50:0x00d4, B:52:0x00da, B:76:0x0187, B:56:0x00e4, B:57:0x00ff, B:58:0x0100, B:62:0x011c, B:64:0x0129, B:67:0x0132, B:69:0x0151, B:72:0x0160, B:73:0x0182, B:75:0x0185, B:61:0x010b, B:78:0x01b8, B:79:0x01bf, B:41:0x00b7, B:42:0x00ba), top: B:93:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00df  */
    /* JADX WARN: Code duplicated, block: B:60:0x010a  */
    /* JADX WARN: Code duplicated, block: B:61:0x010b A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0, IndexOutOfBoundsException -> 0x01c2, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:24:0x0077, B:26:0x007d, B:30:0x0087, B:35:0x0097, B:37:0x009f, B:48:0x00ce, B:50:0x00d4, B:52:0x00da, B:76:0x0187, B:56:0x00e4, B:57:0x00ff, B:58:0x0100, B:62:0x011c, B:64:0x0129, B:67:0x0132, B:69:0x0151, B:72:0x0160, B:73:0x0182, B:75:0x0185, B:61:0x010b, B:78:0x01b8, B:79:0x01bf, B:41:0x00b7, B:42:0x00ba), top: B:93:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0185 A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0, IndexOutOfBoundsException -> 0x01c2, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:24:0x0077, B:26:0x007d, B:30:0x0087, B:35:0x0097, B:37:0x009f, B:48:0x00ce, B:50:0x00d4, B:52:0x00da, B:76:0x0187, B:56:0x00e4, B:57:0x00ff, B:58:0x0100, B:62:0x011c, B:64:0x0129, B:67:0x0132, B:69:0x0151, B:72:0x0160, B:73:0x0182, B:75:0x0185, B:61:0x010b, B:78:0x01b8, B:79:0x01bf, B:41:0x00b7, B:42:0x00ba), top: B:93:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01b8 A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0, IndexOutOfBoundsException -> 0x01c2, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:24:0x0077, B:26:0x007d, B:30:0x0087, B:35:0x0097, B:37:0x009f, B:48:0x00ce, B:50:0x00d4, B:52:0x00da, B:76:0x0187, B:56:0x00e4, B:57:0x00ff, B:58:0x0100, B:62:0x011c, B:64:0x0129, B:67:0x0132, B:69:0x0151, B:72:0x0160, B:73:0x0182, B:75:0x0185, B:61:0x010b, B:78:0x01b8, B:79:0x01bf, B:41:0x00b7, B:42:0x00ba), top: B:93:0x0004 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:61:0x010b, please report this as an issue */
    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        char cCharAt;
        String strSubstring;
        int length;
        TimeZone timeZone;
        char cCharAt2;
        try {
            int index = parsePosition.getIndex();
            int i5 = index + 4;
            int i6 = parseInt(str, index, i5);
            if (checkOffset(str, i5, CoreConstants.DASH_CHAR)) {
                i5 = index + 5;
            }
            int i7 = i5 + 2;
            int i8 = parseInt(str, i5, i7);
            if (checkOffset(str, i7, CoreConstants.DASH_CHAR)) {
                i7 = i5 + 3;
            }
            int i9 = i7 + 2;
            int i10 = parseInt(str, i7, i9);
            boolean zCheckOffset = checkOffset(str, i9, 'T');
            if (!zCheckOffset && str.length() <= i9) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i6, i8 - 1, i10);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i9);
                return gregorianCalendar.getTime();
            }
            if (zCheckOffset) {
                int i11 = i7 + 5;
                i2 = parseInt(str, i7 + 3, i11);
                if (checkOffset(str, i11, CoreConstants.COLON_CHAR)) {
                    i11 = i7 + 6;
                }
                int i12 = i11 + 2;
                int i13 = parseInt(str, i11, i12);
                i9 = checkOffset(str, i12, CoreConstants.COLON_CHAR) ? i11 + 3 : i12;
                if (str.length() <= i9 || (cCharAt2 = str.charAt(i9)) == 'Z' || cCharAt2 == '+' || cCharAt2 == '-') {
                    i = i13;
                } else {
                    int i14 = i9 + 2;
                    i4 = parseInt(str, i9, i14);
                    if (i4 > 59 && i4 < 63) {
                        i4 = 59;
                    }
                    if (checkOffset(str, i14, '.')) {
                        int i15 = i9 + 3;
                        int iIndexOfNonDigit = indexOfNonDigit(str, i9 + 4);
                        int iMin = Math.min(iIndexOfNonDigit, i9 + 6);
                        int i16 = parseInt(str, i15, iMin);
                        int i17 = iMin - i15;
                        if (i17 == 1) {
                            i16 *= 100;
                        } else if (i17 == 2) {
                            i16 *= 10;
                        }
                        i9 = iIndexOfNonDigit;
                        i = i13;
                        i3 = i16;
                    } else {
                        i9 = i14;
                        i = i13;
                        i3 = 0;
                    }
                }
                if (str.length() > i9) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                cCharAt = str.charAt(i9);
                if (cCharAt == 'Z') {
                    timeZone = TIMEZONE_UTC;
                    length = i9 + 1;
                } else {
                    if (cCharAt != '+' && cCharAt != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                    }
                    strSubstring = str.substring(i9);
                    if (strSubstring.length() >= 5) {
                        strSubstring = strSubstring + "00";
                    }
                    length = i9 + strSubstring.length();
                    if (!strSubstring.equals("+0000") || strSubstring.equals("+00:00")) {
                        timeZone = TIMEZONE_UTC;
                    } else {
                        String str3 = TimeZones.GMT_ID + strSubstring;
                        TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                        String id = timeZone2.getID();
                        if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                        }
                        timeZone = timeZone2;
                    }
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(1, i6);
                gregorianCalendar2.set(2, i8 - 1);
                gregorianCalendar2.set(5, i10);
                gregorianCalendar2.set(11, i2);
                gregorianCalendar2.set(12, i);
                gregorianCalendar2.set(13, i4);
                gregorianCalendar2.set(14, i3);
                parsePosition.setIndex(length);
                return gregorianCalendar2.getTime();
            }
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            if (str.length() > i9) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            cCharAt = str.charAt(i9);
            if (cCharAt == 'Z') {
                timeZone = TIMEZONE_UTC;
                length = i9 + 1;
            } else {
                if (cCharAt != '+') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                }
                strSubstring = str.substring(i9);
                if (strSubstring.length() >= 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i9 + strSubstring.length();
                if (!strSubstring.equals("+0000")) {
                    timeZone = TIMEZONE_UTC;
                } else {
                    timeZone = TIMEZONE_UTC;
                }
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(timeZone);
            gregorianCalendar3.setLenient(false);
            gregorianCalendar3.set(1, i6);
            gregorianCalendar3.set(2, i8 - 1);
            gregorianCalendar3.set(5, i10);
            gregorianCalendar3.set(11, i2);
            gregorianCalendar3.set(12, i);
            gregorianCalendar3.set(13, i4);
            gregorianCalendar3.set(14, i3);
            parsePosition.setIndex(length);
            return gregorianCalendar3.getTime();
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - iDigit2;
            i4++;
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String string = Integer.toString(i);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
