package com.henninghall.date_picker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class LocaleUtils {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

    public static String getDay(String str) {
        return getFormat(str, Formats.Format.MMMEd);
    }

    public static String getYear(String str) {
        return getFormat(str, Formats.Format.y);
    }

    public static String getDate(String str) {
        return getFormat(str, Formats.Format.d);
    }

    private static String getFormat(String str, Formats.Format format) {
        try {
            try {
                return Formats.get(str, format);
            } catch (Formats.FormatNotFoundException unused) {
                return Formats.get(str.substring(0, str.indexOf("_")), format);
            }
        } catch (Formats.FormatNotFoundException | IndexOutOfBoundsException unused2) {
            return Formats.defaultFormat.get(format);
        }
    }

    private static void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    public static String getDatePattern(Locale locale) {
        return ((SimpleDateFormat) DateFormat.getDateInstance(0, locale)).toLocalizedPattern().replaceAll(",", "").replaceAll("([a-zA-Z]+)", " $1").trim();
    }

    static String getDateTimePattern(Locale locale) {
        return ((SimpleDateFormat) DateFormat.getDateTimeInstance(0, 0, locale)).toLocalizedPattern().replace(",", "");
    }

    public static Locale getLocale(String str) {
        try {
            return org.apache.commons.lang3.LocaleUtils.toLocale(str);
        } catch (Exception unused) {
            return org.apache.commons.lang3.LocaleUtils.toLocale(str.substring(0, str.indexOf("_")));
        }
    }

    public static boolean localeUsesAmPm(Locale locale) {
        DateFormat timeInstance = DateFormat.getTimeInstance(0, locale);
        return (timeInstance instanceof SimpleDateFormat) && ((SimpleDateFormat) timeInstance).toPattern().contains("a");
    }

    public static String getLocaleStringResource(Locale locale, int i, Context context) {
        int i2 = 2 % 2;
        try {
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            configuration.setLocale(locale);
            Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
            String string = contextCreateConfigurationContext.getString(i);
            boolean zStartsWith = string.startsWith(".,.%");
            CharSequence charSequence = string;
            if (zStartsWith) {
                int i3 = artificialFrame + 9;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                int i4 = i3 % 2;
                Object[] objArr = new Object[1];
                a(string.substring(4), objArr);
                String strIntern = ((String) objArr[0]).intern();
                CharSequence text = contextCreateConfigurationContext.getText(i);
                if (text instanceof Spanned) {
                    SpannableString spannableString = new SpannableString(strIntern);
                    TextUtils.copySpansFrom((SpannedString) text, 0, strIntern.length(), Object.class, spannableString, 0);
                    charSequence = spannableString;
                } else {
                    int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
                    artificialFrame = i5 % 128;
                    int i6 = i5 % 2;
                    charSequence = strIntern;
                }
            }
            return charSequence.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
