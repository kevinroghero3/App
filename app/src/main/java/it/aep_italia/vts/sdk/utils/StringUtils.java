package it.aep_italia.vts.sdk.utils;

import com.google.maps.android.BuildConfig;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class StringUtils {
    private static String a(Object obj) {
        ArrayList arrayList;
        StringBuilder sb;
        if (obj == null) {
            return BuildConfig.TRAVIS;
        }
        if (obj.getClass().isArray()) {
            if (byte[].class.equals(obj.getClass())) {
                return "(blob)";
            }
            arrayList = new ArrayList();
            for (int i = 0; i < Array.getLength(obj); i++) {
                arrayList.add(a(Array.get(obj, i)));
            }
            sb = new StringBuilder();
        } else {
            if (!(obj instanceof Collection)) {
                return obj.toString();
            }
            arrayList = new ArrayList();
            Iterator it2 = ((Collection) obj).iterator();
            while (it2.hasNext()) {
                arrayList.add(a(it2.next()));
            }
            sb = new StringBuilder();
        }
        sb.append("[");
        sb.append(join(arrayList, ", ", true));
        sb.append("]");
        return sb.toString();
    }

    public static String blankToNull(String str) {
        if (isBlank(str)) {
            return null;
        }
        return str;
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isHexNumber(String str) {
        if (isBlank(str)) {
            return false;
        }
        return str.trim().matches("^[0-9a-fA-F]{1,16}$");
    }

    public static String join(Collection<String> collection, String str, boolean z) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        String strNullToEmpty = nullToEmpty(str);
        StringBuilder sb = new StringBuilder();
        for (String strTrim : collection) {
            if (strTrim != null && z) {
                strTrim = strTrim.trim();
            }
            sb.append(strTrim);
            sb.append(strNullToEmpty);
        }
        sb.setLength(sb.length() - strNullToEmpty.length());
        return sb.toString();
    }

    public static int naturalCompare(String str, String str2) {
        if (isBlank(str)) {
            return 1;
        }
        if (isBlank(str2)) {
            return -1;
        }
        boolean z = false;
        char cCharAt = str.trim().charAt(0);
        char cCharAt2 = str2.trim().charAt(0);
        boolean z2 = cCharAt >= '0' && cCharAt <= '9';
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            z = true;
        }
        if (z2 && !z) {
            return -1;
        }
        if (!z2 && z) {
            return 1;
        }
        if (z2 && z) {
            return Integer.parseInt(str.trim().replaceAll("^([0-9]+)[^0-9].*$", "$1")) - Integer.parseInt(str2.trim().replaceAll("^([0-9]+)[^0-9].*$", "$1"));
        }
        return str.trim().compareToIgnoreCase(str2.trim());
    }

    public static String nullToEmpty(String str) {
        return str == null ? "" : str;
    }

    public static String padLeftToLength(String str, int i, char c) {
        if (str == null) {
            str = "";
        }
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < i) {
            sb.insert(0, c);
        }
        return sb.toString();
    }

    public static String padRightToLength(String str, int i, char c) {
        if (str == null) {
            str = "";
        }
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < i) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String stringifyParams(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i += 2) {
            String strA = a(objArr[i]);
            int i2 = i + 1;
            String strA2 = i2 < objArr.length ? a(objArr[i2]) : "";
            sb.append(strA);
            sb.append("=");
            sb.append(strA2);
            if (i2 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String toFullHexString(Long l) {
        return padLeftToLength(l == null ? "" : Long.toHexString(l.longValue()), 16, '0').toUpperCase(Locale.ITALY);
    }

    public static long unsignedHexStringToSignedLong(String str) {
        if (str == null) {
            return 0L;
        }
        String strTrim = str.trim();
        int length = strTrim.length();
        if (length < 16) {
            return Long.parseLong(strTrim, 16);
        }
        if (length > 16) {
            strTrim = strTrim.substring(length - 16);
        }
        return Long.parseLong(strTrim.substring(8, 16), 16) | (Long.parseLong(strTrim.substring(0, 8), 16) << 32);
    }
}
