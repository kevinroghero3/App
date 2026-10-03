package com.zoontek.rnlocalize;

import android.app.Activity;
import android.content.Intent;
import android.icu.number.NumberFormatter;
import android.icu.util.MeasureUnit;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import androidx.core.os.LocaleListCompat;
import androidx.core.text.util.LocalePreferences;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.sentry.protocol.SentryStackFrame;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class RNLocalizeModuleImpl {
    private static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";
    public static final String NAME = "RNLocalize";
    public static final RNLocalizeModuleImpl INSTANCE = new RNLocalizeModuleImpl();
    private static final List<String> USES_FAHRENHEIT = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"BS", "BZ", "KY", "PR", "PW", "US"});
    private static final List<String> USES_IMPERIAL = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"LR", "MM", "US"});

    private RNLocalizeModuleImpl() {
    }

    private final String createLanguageTag(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2.length() > 0) {
            sb.append("-" + str2);
        }
        sb.append("-" + str3);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String getCountryCodeForLocale(Locale locale) {
        try {
            String country = locale.getCountry();
            if (Intrinsics.areEqual(country, "419")) {
                return "UN";
            }
            Intrinsics.checkNotNull(country);
            if (country.length() > 0) {
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                String upperCase = country.toUpperCase(locale2);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                return upperCase;
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private final String getCurrencyCodeForLocale(Locale locale) {
        String currencyCode;
        try {
            Currency currency = Currency.getInstance(locale);
            return (currency == null || (currencyCode = currency.getCurrencyCode()) == null) ? "" : currencyCode;
        } catch (Exception unused) {
        }
    }

    private final String getLanguageCodeForLocale(Locale locale) {
        String language = locale.getLanguage();
        if (language == null) {
            return language;
        }
        int iHashCode = language.hashCode();
        if (iHashCode == 3365) {
            return !language.equals("in") ? language : "id";
        }
        if (iHashCode != 3374) {
            return (iHashCode == 3391 && language.equals("ji")) ? "yi" : language;
        }
        return !language.equals("iw") ? language : "he";
    }

    private final String getScriptCodeForLocale(Locale locale) {
        String script = locale.getScript();
        return script.length() == 0 ? "" : script;
    }

    private final Locale getSystemLocale(ReactApplicationContext reactApplicationContext) {
        Locale locale = reactApplicationContext.getResources().getConfiguration().getLocales().get(0);
        Intrinsics.checkNotNullExpressionValue(locale, "get(...)");
        return locale;
    }

    private final List<Locale> getSystemLocales(ReactApplicationContext reactApplicationContext) {
        reactApplicationContext.getResources().getConfiguration();
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
        int size = localeListCompat.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Locale locale = localeListCompat.get(i);
            Intrinsics.checkNotNull(locale);
            arrayList.add(locale);
        }
        return arrayList;
    }

    private final String getMiuiRegionCode() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class).invoke(cls, "ro.miui.region");
            Objects.requireNonNull(objInvoke);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            return (String) objInvoke;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String getCalendar() {
        return LocalePreferences.CalendarType.GREGORIAN;
    }

    public final String getCountry(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        String miuiRegionCode = getMiuiRegionCode();
        String countryCodeForLocale = getCountryCodeForLocale(getSystemLocale(reactContext));
        if (miuiRegionCode.length() > 0) {
            return miuiRegionCode;
        }
        return countryCodeForLocale.length() == 0 ? "US" : countryCodeForLocale;
    }

    public final WritableArray getCurrencies(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List<Locale> systemLocales = getSystemLocales(reactContext);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<T> it2 = systemLocales.iterator();
        while (it2.hasNext()) {
            String currencyCodeForLocale = INSTANCE.getCurrencyCodeForLocale((Locale) it2.next());
            if (currencyCodeForLocale.length() > 0 && linkedHashSet.add(currencyCodeForLocale)) {
                writableArrayCreateArray.pushString(currencyCodeForLocale);
            }
        }
        if (writableArrayCreateArray.size() == 0) {
            writableArrayCreateArray.pushString("USD");
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    public final WritableArray getLocales(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List<Locale> systemLocales = getSystemLocales(reactContext);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        String country = getCountry(reactContext);
        for (Locale locale : systemLocales) {
            String languageCodeForLocale = getLanguageCodeForLocale(locale);
            String scriptCodeForLocale = getScriptCodeForLocale(locale);
            String countryCodeForLocale = getCountryCodeForLocale(locale);
            if (countryCodeForLocale.length() == 0) {
                countryCodeForLocale = country;
            }
            Intrinsics.checkNotNull(languageCodeForLocale);
            Intrinsics.checkNotNull(scriptCodeForLocale);
            String strCreateLanguageTag = createLanguageTag(languageCodeForLocale, scriptCodeForLocale, countryCodeForLocale);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, languageCodeForLocale);
            writableMapCreateMap.putString(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, countryCodeForLocale);
            writableMapCreateMap.putString("languageTag", strCreateLanguageTag);
            writableMapCreateMap.putBoolean("isRTL", TextUtils.getLayoutDirectionFromLocale(locale) == 1);
            if (scriptCodeForLocale.length() > 0) {
                writableMapCreateMap.putString("scriptCode", scriptCodeForLocale);
            }
            if (linkedHashSet.add(strCreateLanguageTag)) {
                writableArrayCreateArray.pushMap(writableMapCreateMap);
            }
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    public final WritableMap getNumberFormatSettings(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(getSystemLocale(reactContext));
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("decimalSeparator", String.valueOf(decimalFormatSymbols.getDecimalSeparator()));
        writableMapCreateMap.putString("groupingSeparator", String.valueOf(decimalFormatSymbols.getGroupingSeparator()));
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
        return writableMapCreateMap;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0057 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:9:0x0054 A[RETURN, SYNTHETIC] */
    public final String getTemperatureUnit(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (Build.VERSION.SDK_INT >= 33) {
            String identifier = RNLocalizeModuleImpl$$ExternalSyntheticApiModelOutline2.m(RNLocalizeModuleImpl$$ExternalSyntheticApiModelOutline2.m(NumberFormatter.with().usage("weather")).unit(MeasureUnit.CELSIUS)).locale(getSystemLocale(reactContext)).format(1L).getOutputUnit().getIdentifier();
            Intrinsics.checkNotNull(identifier);
            if (StringsKt__StringsJVMKt.startsWith$default(identifier, LocalePreferences.TemperatureUnit.FAHRENHEIT, false, 2, null)) {
                return "fahrenheit";
            }
            return LocalePreferences.TemperatureUnit.CELSIUS;
        }
        if (USES_FAHRENHEIT.contains(getCountry(reactContext))) {
            return "fahrenheit";
        }
        return LocalePreferences.TemperatureUnit.CELSIUS;
    }

    public final String getTimeZone() {
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
        return id;
    }

    public final boolean uses24HourClock(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return DateFormat.is24HourFormat(reactContext);
    }

    public final boolean usesMetricSystem(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return !USES_IMPERIAL.contains(getCountry(reactContext));
    }

    public final boolean usesAutoDateAndTime(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return Settings.Global.getInt(reactContext.getContentResolver(), "auto_time", 0) != 0;
    }

    public final boolean usesAutoTimeZone(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return Settings.Global.getInt(reactContext.getContentResolver(), "auto_time_zone", 0) != 0;
    }

    public final void openAppLanguageSettings(@NotNull ReactApplicationContext reactContext, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (Build.VERSION.SDK_INT < 33) {
            promise.reject("unsupported", "openAppLanguageSettings is supported only on Android 13+");
            return;
        }
        try {
            String packageName = reactContext.getPackageName();
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_LOCALE_SETTINGS");
            intent.setData(Uri.fromParts(SentryStackFrame.JsonKeys.PACKAGE, packageName, null));
            Activity currentActivity = reactContext.getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.startActivity(intent);
            }
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject(ERROR_INVALID_ACTIVITY, e);
        }
    }
}
