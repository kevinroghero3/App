package io.sentry.util;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.StringCharacterIterator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class StringUtils {
    private static final String CORRUPTED_NIL_UUID = "0000-0000";
    public static final String PROPER_NIL_UUID = "00000000-0000-0000-0000-000000000000";
    private static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);
    private static final Pattern PATTERN_WORD_SNAKE_CASE = Pattern.compile("[\\W_]+");

    private StringUtils() {
    }

    public static String getStringAfterDot(@Nullable String str) {
        int i;
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".");
        return (iLastIndexOf < 0 || str.length() <= (i = iLastIndexOf + 1)) ? str : str.substring(i);
    }

    public static String capitalize(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        Locale locale = Locale.ROOT;
        sb.append(strSubstring.toUpperCase(locale));
        sb.append(str.substring(1).toLowerCase(locale));
        return sb.toString();
    }

    public static String camelCase(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] strArrSplit = PATTERN_WORD_SNAKE_CASE.split(str, -1);
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb.append(capitalize(str2));
        }
        return sb.toString();
    }

    public static String removeSurrounding(@Nullable String str, @Nullable String str2) {
        return (str == null || str2 == null || !str.startsWith(str2) || !str.endsWith(str2)) ? str : str.substring(str2.length(), str.length() - str2.length());
    }

    public static String byteCountToString(long j) {
        if (-1000 < j && j < 1000) {
            return j + " B";
        }
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("kMGTPE");
        while (true) {
            if (j <= -999950 || j >= 999950) {
                j /= 1000;
                stringCharacterIterator.next();
            } else {
                return String.format(Locale.ROOT, "%.1f %cB", Double.valueOf(j / 1000.0d), Character.valueOf(stringCharacterIterator.current()));
            }
        }
    }

    public static String calculateStringHash(@Nullable String str, @NotNull ILogger iLogger) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new StringBuilder(new BigInteger(1, MessageDigest.getInstance("SHA-1").digest(str.getBytes(UTF_8))).toString(16)).toString();
        } catch (NoSuchAlgorithmException e) {
            iLogger.log(SentryLevel.INFO, "SHA-1 isn't available to calculate the hash.", e);
            return null;
        } catch (Throwable th) {
            iLogger.log(SentryLevel.INFO, "string: %s could not calculate its hash", th, str);
            return null;
        }
    }

    public static int countOf(@NotNull String str, char c) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }

    public static String normalizeUUID(@NotNull String str) {
        return str.equals(CORRUPTED_NIL_UUID) ? PROPER_NIL_UUID : str;
    }

    public static String join(@NotNull CharSequence charSequence, @NotNull Iterable<? extends CharSequence> iterable) {
        StringBuilder sb = new StringBuilder();
        Iterator<? extends CharSequence> it2 = iterable.iterator();
        if (it2.hasNext()) {
            sb.append(it2.next());
            while (it2.hasNext()) {
                sb.append(charSequence);
                sb.append(it2.next());
            }
        }
        return sb.toString();
    }

    public static String toString(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static String removePrefix(@Nullable String str, @NotNull String str2) {
        if (str == null) {
            return "";
        }
        return str.indexOf(str2) == 0 ? str.substring(str2.length()) : str;
    }

    public static String substringBefore(@Nullable String str, @NotNull String str2) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(str2);
        return iIndexOf >= 0 ? str.substring(0, iIndexOf) : str;
    }
}
