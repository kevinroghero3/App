package com.facebook.hermes.intl;

import android.icu.text.NumberingSystem;
import android.icu.util.Calendar;
import android.icu.util.ULocale;
import androidx.core.text.util.LocalePreferences;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import io.sentry.SentryBaseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.time4j.format.CalendarText;

/* JADX INFO: loaded from: classes4.dex */
public class UnicodeExtensionKeys {
    public static String CALENDAR = "calendar";
    public static String CALENDAR_CANON = "ca";
    public static String COLLATION = "collation";
    public static String COLLATION_CANON = "co";
    public static String COLLATION_CASEFIRST = "colcasefirst";
    public static String COLLATION_CASEFIRST_CANON = "kf";
    public static String COLLATION_NUMERIC = "colnumeric";
    public static String COLLATION_NUMERIC_CANON = "kn";
    public static String HOURCYCLE = "hours";
    public static String HOURCYCLE_CANON = "hc";
    public static String NUMERINGSYSTEM = "numbers";
    public static String NUMERINGSYSTEM_CANON = "nu";
    private static HashMap<String, String> s_canonicalkey_icukey_map = new HashMap<String, String>() { // from class: com.facebook.hermes.intl.UnicodeExtensionKeys.1
        {
            put(UnicodeExtensionKeys.CALENDAR_CANON, UnicodeExtensionKeys.CALENDAR);
            put(UnicodeExtensionKeys.NUMERINGSYSTEM_CANON, UnicodeExtensionKeys.NUMERINGSYSTEM);
            put(UnicodeExtensionKeys.HOURCYCLE_CANON, UnicodeExtensionKeys.HOURCYCLE);
            put(UnicodeExtensionKeys.COLLATION_CANON, UnicodeExtensionKeys.COLLATION);
            put(UnicodeExtensionKeys.COLLATION_NUMERIC_CANON, UnicodeExtensionKeys.COLLATION_NUMERIC);
            put(UnicodeExtensionKeys.COLLATION_CASEFIRST_CANON, UnicodeExtensionKeys.COLLATION_CASEFIRST);
        }
    };
    private static HashMap<String, String> s_icukey_canonicalkey_map = new AnonymousClass2();
    private static final Map<String, String> s_collationAliasMappings = new HashMap<String, String>() { // from class: com.facebook.hermes.intl.UnicodeExtensionKeys.3
        {
            put("dictionary", "dict");
            put("phonebook", "phonebk");
            put("traditional", "trad");
            put("gb2312han", "gb2312");
        }
    };
    private static Map<String, String> s_calendarAliasMappings = new HashMap<String, String>() { // from class: com.facebook.hermes.intl.UnicodeExtensionKeys.4
        {
            put(LocalePreferences.CalendarType.GREGORIAN, "gregory");
        }
    };
    private static Map<String, String> s_numberSystemAliasMappings = new HashMap<String, String>() { // from class: com.facebook.hermes.intl.UnicodeExtensionKeys.5
        {
            put("traditional", "traditio");
        }
    };
    private static Map<String, String[]> s_validKeywords = new HashMap<String, String[]>() { // from class: com.facebook.hermes.intl.UnicodeExtensionKeys.6
        {
            put("nu", new String[]{"adlm", "ahom", "arab", "arabext", "bali", "beng", "bhks", "brah", "cakm", "cham", "deva", "diak", "fullwide", "gong", "gonm", "gujr", "guru", "hanidec", "hmng", "hmnp", SentryBaseEvent.DEFAULT_PLATFORM, "kali", "khmr", "knda", "lana", "lanatham", "laoo", "latn", "lepc", "limb", "mathbold", "mathdbl", "mathmono", "mathsanb", "mathsans", "mlym", "modi", "mong", "mroo", "mtei", "mymr", "mymrshan", "mymrtlng", "newa", "nkoo", "olck", "orya", "osma", "rohg", "saur", "segment", "shrd", "sind", "sinh", "sora", "sund", "takr", "talu", "tamldec", "telu", "thai", "tibt", "tirh", "vaii", "wara", "wcho"});
            put(Constants.COLLATION_EXTENSION_KEY_SHORT, new String[]{"big5han", "compat", "dict", DevicePublicKeyStringDef.DIRECT, "ducet", "emoji", "eor", "gb2312", "phonebk", "phonetic", "pinyin", "reformed", "searchjl", "stroke", "trad", "unihan", "zhuyin"});
            put("ca", new String[]{"buddhist", LocalePreferences.CalendarType.CHINESE, "coptic", LocalePreferences.CalendarType.DANGI, "ethioaa", "ethiopic", "gregory", LocalePreferences.CalendarType.HEBREW, LocalePreferences.CalendarType.INDIAN, LocalePreferences.CalendarType.ISLAMIC, "islamic-umalqura", LocalePreferences.CalendarType.ISLAMIC_TBLA, LocalePreferences.CalendarType.ISLAMIC_CIVIL, LocalePreferences.CalendarType.ISLAMIC_RGSA, CalendarText.ISO_CALENDAR_TYPE, "japanese", LocalePreferences.CalendarType.PERSIAN, "roc"});
        }
    };

    /* JADX INFO: renamed from: com.facebook.hermes.intl.UnicodeExtensionKeys$2, reason: invalid class name */
    public class AnonymousClass2 extends HashMap<String, String> {
        public static int ITrustedWebActivityCallbackDefault;
        public static int onExtraCallback;

        AnonymousClass2() {
            put(UnicodeExtensionKeys.CALENDAR, UnicodeExtensionKeys.CALENDAR_CANON);
            put(UnicodeExtensionKeys.NUMERINGSYSTEM, UnicodeExtensionKeys.NUMERINGSYSTEM_CANON);
            put(UnicodeExtensionKeys.HOURCYCLE, UnicodeExtensionKeys.HOURCYCLE_CANON);
            put(UnicodeExtensionKeys.COLLATION, UnicodeExtensionKeys.COLLATION_CANON);
            put(UnicodeExtensionKeys.COLLATION_NUMERIC, UnicodeExtensionKeys.COLLATION_NUMERIC_CANON);
            put(UnicodeExtensionKeys.COLLATION_CASEFIRST, UnicodeExtensionKeys.COLLATION_CASEFIRST_CANON);
        }

        public static int extraCallbackWithResult() {
            int i = ITrustedWebActivityCallbackDefault;
            int i2 = i % 6301674;
            ITrustedWebActivityCallbackDefault = i + 1;
            if (i2 != 0) {
                return onExtraCallback;
            }
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            onExtraCallback = iFreeMemory;
            return iFreeMemory;
        }
    }

    public static String CanonicalKeyToICUKey(String str) {
        return s_canonicalkey_icukey_map.containsKey(str) ? s_canonicalkey_icukey_map.get(str) : str;
    }

    public static String ICUKeyToCanonicalKey(String str) {
        return s_icukey_canonicalkey_map.containsKey(str) ? s_icukey_canonicalkey_map.get(str) : str;
    }

    public static String resolveCollationAlias(String str) {
        Map<String, String> map = s_collationAliasMappings;
        return !map.containsKey(str) ? str : map.get(str);
    }

    public static String resolveCalendarAlias(String str) {
        return !s_calendarAliasMappings.containsKey(str) ? str : s_calendarAliasMappings.get(str);
    }

    public static String resolveNumberSystemAlias(String str) {
        return !s_numberSystemAliasMappings.containsKey(str) ? str : s_numberSystemAliasMappings.get(str);
    }

    public static boolean isValidKeyword(String str, String str2, ILocaleObject iLocaleObject) throws JSRangeErrorException {
        ULocale uLocale = (ULocale) iLocaleObject.getLocale();
        String[] availableNames = new String[0];
        if (str.equals(Constants.COLLATION_EXTENSION_KEY_SHORT)) {
            if (str2.equals(Constants.COLLATION_STANDARD) || str2.equals("search")) {
                return false;
            }
            availableNames = android.icu.text.Collator.getKeywordValuesForLocale(Constants.COLLATION_EXTENSION_KEY_SHORT, uLocale, false);
        } else if (str.equals("ca")) {
            availableNames = Calendar.getKeywordValuesForLocale("ca", uLocale, false);
        } else if (str.equals("nu")) {
            availableNames = NumberingSystem.getAvailableNames();
        }
        if (availableNames.length == 0) {
            return true;
        }
        return Arrays.asList(availableNames).contains(str2);
    }

    public static Object resolveKnownAliases(String str, Object obj) {
        if (str.equals("ca") && JSObjects.isString(obj)) {
            return resolveCalendarAlias((String) obj);
        }
        if (str.equals("nu") && JSObjects.isString(obj)) {
            return resolveNumberSystemAlias((String) obj);
        }
        if (str.equals(Constants.COLLATION_EXTENSION_KEY_SHORT) && JSObjects.isString(obj)) {
            return resolveCollationAlias((String) obj);
        }
        if (str.equals(Constants.COLLATION_EXTENSION_PARAM_NUMERIC_SHORT) && JSObjects.isString(obj) && obj.equals("yes")) {
            return JSObjects.newString("true");
        }
        return ((str.equals(Constants.COLLATION_EXTENSION_PARAM_NUMERIC_SHORT) || str.equals(Constants.COLLATION_EXTENSION_PARAM_CASEFIRST_SHORT)) && JSObjects.isString(obj) && obj.equals("no")) ? JSObjects.newString(Constants.CASEFIRST_FALSE) : obj;
    }
}
