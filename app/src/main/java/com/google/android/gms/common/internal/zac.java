package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.ConfigurationCompat;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.android.core.SentryLogcatAdapter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class zac {
    private static int artificialFrame = 1;
    private static byte extraCallback;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final SimpleArrayMap zaa;
    private static Locale zab;

    static {
        accessartificialFrame();
        zaa = new SimpleArrayMap();
    }

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String zab(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_button);
        }
        if (i != 2) {
            return i != 3 ? resources.getString(android.R.string.ok) : resources.getString(R.string.common_google_play_services_enable_button);
        }
        return resources.getString(R.string.common_google_play_services_update_button);
    }

    public static String zaf(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                SentryLogcatAdapter.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zah(context, "common_google_play_services_invalid_account_title");
            case 7:
                SentryLogcatAdapter.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zah(context, "common_google_play_services_network_error_title");
            case 8:
                SentryLogcatAdapter.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                SentryLogcatAdapter.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                SentryLogcatAdapter.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                SentryLogcatAdapter.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                SentryLogcatAdapter.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
            case 16:
                SentryLogcatAdapter.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                SentryLogcatAdapter.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zah(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                SentryLogcatAdapter.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zah(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String zah(Context context, String str) {
        SimpleArrayMap simpleArrayMap = zaa;
        synchronized (simpleArrayMap) {
            Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
            if (!locale.equals(zab)) {
                simpleArrayMap.clear();
                zab = locale;
            }
            String str2 = (String) simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, TypedValues.Custom.S_STRING, "com.google.android.gms");
            if (identifier == 0) {
                SentryLogcatAdapter.w("GoogleApiAvailability", "Missing resource: " + str);
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (string.startsWith(".,.%")) {
                Object[] objArr = new Object[1];
                a(string.substring(4), objArr);
                string = ((String) objArr[0]).intern();
            }
            if (!TextUtils.isEmpty(string)) {
                simpleArrayMap.put(str, string);
                return string;
            }
            SentryLogcatAdapter.w("GoogleApiAvailability", "Got empty resource: " + str);
            return null;
        }
    }

    public static String zad(Context context, int i) {
        return (i == 6 || i == 19) ? zag(context, "common_google_play_services_resolution_required_text", zaa(context)) : zac(context, i);
    }

    public static String zae(Context context, int i) {
        int i2 = 2 % 2;
        String strZah = i == 6 ? zah(context, "common_google_play_services_resolution_required_title") : zaf(context, i);
        if (strZah != null) {
            int i3 = artificialFrame + 23;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 99 / 0;
            }
            return strZah;
        }
        String string = context.getResources().getString(R.string.common_google_play_services_notification_ticker);
        if (!string.startsWith(".,.%")) {
            return string;
        }
        Object[] objArr = new Object[1];
        a(string.substring(4), objArr);
        String strIntern = ((String) objArr[0]).intern();
        int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 125;
        artificialFrame = i5 % 128;
        int i6 = i5 % 2;
        return strIntern;
    }

    private static String zag(Context context, String str, String str2) {
        int i = 2 % 2;
        int i2 = artificialFrame + 53;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Resources resources = context.getResources();
        String strZah = zah(context, str);
        if (strZah == null) {
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
            strZah = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
            if (strZah.startsWith(".,.%")) {
                int i6 = artificialFrame + 3;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i6 % 128;
                if (i6 % 2 != 0) {
                    Object[] objArr = new Object[1];
                    a(strZah.substring(4), objArr);
                    ((String) objArr[0]).intern();
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }
                Object[] objArr2 = new Object[1];
                a(strZah.substring(4), objArr2);
                strZah = ((String) objArr2[0]).intern();
            }
        }
        return String.format(resources.getConfiguration().locale, strZah, str2);
    }

    public static String zac(Context context, int i) {
        Locale locale;
        Locale locale2;
        int i2 = 2 % 2;
        Resources resources = context.getResources();
        String strZaa = zaa(context);
        if (i == 1) {
            int i3 = R.string.common_google_play_services_install_text;
            Object[] objArr = {strZaa};
            Configuration configuration = resources.getConfiguration();
            Locale locale3 = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
            String string = resources.getString(i3);
            if (string.startsWith(".,.%")) {
                Object[] objArr2 = new Object[1];
                a(string.substring(4), objArr2);
                string = ((String) objArr2[0]).intern();
            }
            return String.format(locale3, string, objArr);
        }
        if (i == 2) {
            if (!(!DeviceProperties.isWearableWithoutPlayStore(context))) {
                String string2 = resources.getString(R.string.common_google_play_services_wear_update_text);
                int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
                artificialFrame = i4 % 128;
                int i5 = i4 % 2;
                return string2;
            }
            int i6 = R.string.common_google_play_services_update_text;
            Object[] objArr3 = {strZaa};
            Configuration configuration2 = resources.getConfiguration();
            Locale locale4 = Build.VERSION.SDK_INT >= 24 ? configuration2.getLocales().get(0) : configuration2.locale;
            String string3 = resources.getString(i6);
            if (string3.startsWith(".,.%")) {
                Object[] objArr4 = new Object[1];
                a(string3.substring(4), objArr4);
                string3 = ((String) objArr4[0]).intern();
            }
            return String.format(locale4, string3, objArr3);
        }
        int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i8 = i7 + 25;
        artificialFrame = i8 % 128;
        int i9 = i8 % 2;
        if (i == 3) {
            int i10 = R.string.common_google_play_services_enable_text;
            Object[] objArr5 = {strZaa};
            Configuration configuration3 = resources.getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                int i11 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
                artificialFrame = i11 % 128;
                int i12 = i11 % 2;
                locale = configuration3.getLocales().get(0);
                int i13 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
                int i14 = i13 % 2;
            } else {
                locale = configuration3.locale;
            }
            String string4 = resources.getString(i10);
            if (string4.startsWith(".,.%")) {
                Object[] objArr6 = new Object[1];
                a(string4.substring(4), objArr6);
                string4 = ((String) objArr6[0]).intern();
            }
            return String.format(locale, string4, objArr5);
        }
        if (i == 5) {
            return zag(context, "common_google_play_services_invalid_account_text", strZaa);
        }
        if (i == 7) {
            String strZag = zag(context, "common_google_play_services_network_error_text", strZaa);
            int i15 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
            artificialFrame = i15 % 128;
            int i16 = i15 % 2;
            return strZag;
        }
        int i17 = i7 + b.f40o;
        artificialFrame = i17 % 128;
        int i18 = i17 % 2;
        Object obj = null;
        if (i == 9) {
            int i19 = R.string.common_google_play_services_unsupported_text;
            Object[] objArr7 = {strZaa};
            Configuration configuration4 = resources.getConfiguration();
            Locale locale5 = Build.VERSION.SDK_INT >= 24 ? configuration4.getLocales().get(0) : configuration4.locale;
            String string5 = resources.getString(i19);
            if (string5.startsWith(".,.%")) {
                int i20 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
                artificialFrame = i20 % 128;
                if (i20 % 2 == 0) {
                    Object[] objArr8 = new Object[1];
                    a(string5.substring(4), objArr8);
                    ((String) objArr8[0]).intern();
                    throw null;
                }
                Object[] objArr9 = new Object[1];
                a(string5.substring(4), objArr9);
                string5 = ((String) objArr9[0]).intern();
            }
            return String.format(locale5, string5, objArr7);
        }
        if (i == 20) {
            return zag(context, "common_google_play_services_restricted_profile_text", strZaa);
        }
        switch (i) {
            case 16:
                return zag(context, "common_google_play_services_api_unavailable_text", strZaa);
            case 17:
                return zag(context, "common_google_play_services_sign_in_failed_text", strZaa);
            case 18:
                int i21 = R.string.common_google_play_services_updating_text;
                Object[] objArr10 = {strZaa};
                Configuration configuration5 = resources.getConfiguration();
                Locale locale6 = Build.VERSION.SDK_INT >= 24 ? configuration5.getLocales().get(0) : configuration5.locale;
                String string6 = resources.getString(i21);
                if (string6.startsWith(".,.%")) {
                    int i22 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                    artificialFrame = i22 % 128;
                    int i23 = i22 % 2;
                    Object[] objArr11 = new Object[1];
                    a(string6.substring(4), objArr11);
                    string6 = ((String) objArr11[0]).intern();
                }
                return String.format(locale6, string6, objArr10);
            default:
                int i24 = com.google.android.gms.common.R.string.common_google_play_services_unknown_issue;
                Object[] objArr12 = {strZaa};
                Configuration configuration6 = resources.getConfiguration();
                if (Build.VERSION.SDK_INT >= 24) {
                    int i25 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                    artificialFrame = i25 % 128;
                    int i26 = i25 % 2;
                    locale2 = configuration6.getLocales().get(0);
                } else {
                    locale2 = configuration6.locale;
                }
                String string7 = resources.getString(i24);
                if (string7.startsWith(".,.%")) {
                    int i27 = artificialFrame + 119;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i27 % 128;
                    if (i27 % 2 != 0) {
                        Object[] objArr13 = new Object[1];
                        a(string7.substring(4), objArr13);
                        ((String) objArr13[0]).intern();
                        obj.hashCode();
                        throw null;
                    }
                    Object[] objArr14 = new Object[1];
                    a(string7.substring(4), objArr14);
                    string7 = ((String) objArr14[0]).intern();
                }
                return String.format(locale2, string7, objArr12);
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

    static void accessartificialFrame() {
        extraCallback = (byte) -124;
    }
}
