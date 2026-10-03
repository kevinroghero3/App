package com.google.firebase.messaging;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.AppEventsConstants;
import io.sentry.android.core.SentryLogcatAdapter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationParams {
    private static final int COLOR_TRANSPARENT_IN_HEX = -16777216;
    private static final int EMPTY_JSON_ARRAY_LENGTH = 1;
    private static final String TAG = "NotificationParams";
    private static final int VISIBILITY_MAX = 1;
    private static final int VISIBILITY_MIN = -1;
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final Bundle data;

    private void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    public NotificationParams(@NonNull Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("data");
        }
        this.data = new Bundle(bundle);
    }

    Integer getNotificationCount() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.NOTIFICATION_COUNT);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= 0) {
            return integer;
        }
        SentryLogcatAdapter.w(Constants.TAG, "notificationCount is invalid: " + integer + ". Skipping setting notificationCount.");
        return null;
    }

    Integer getNotificationPriority() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.NOTIFICATION_PRIORITY);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= -2 && integer.intValue() <= 2) {
            return integer;
        }
        SentryLogcatAdapter.w(Constants.TAG, "notificationPriority is invalid " + integer + ". Skipping setting notificationPriority.");
        return null;
    }

    Integer getVisibility() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.VISIBILITY);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= -1 && integer.intValue() <= 1) {
            return integer;
        }
        SentryLogcatAdapter.w(TAG, "visibility is invalid: " + integer + ". Skipping setting visibility.");
        return null;
    }

    public String getString(String str) {
        return this.data.getString(normalizePrefix(str));
    }

    private String normalizePrefix(String str) {
        if (!this.data.containsKey(str) && str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX)) {
            String strKeyWithOldPrefix = keyWithOldPrefix(str);
            if (this.data.containsKey(strKeyWithOldPrefix)) {
                return strKeyWithOldPrefix;
            }
        }
        return str;
    }

    public boolean getBoolean(String str) {
        String string = getString(str);
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(string) || Boolean.parseBoolean(string);
    }

    public Integer getInteger(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(string));
        } catch (NumberFormatException unused) {
            SentryLogcatAdapter.w(TAG, "Couldn't parse value of " + userFriendlyKey(str) + "(" + string + ") into an int");
            return null;
        }
    }

    public Long getLong(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(string));
        } catch (NumberFormatException unused) {
            SentryLogcatAdapter.w(TAG, "Couldn't parse value of " + userFriendlyKey(str) + "(" + string + ") into a long");
            return null;
        }
    }

    public String getLocalizationResourceForKey(String str) {
        return getString(str + Constants.MessageNotificationKeys.TEXT_RESOURCE_SUFFIX);
    }

    public Object[] getLocalizationArgsForKey(String str) {
        JSONArray jSONArray = getJSONArray(str + Constants.MessageNotificationKeys.TEXT_ARGS_SUFFIX);
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    public JSONArray getJSONArray(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            SentryLogcatAdapter.w(TAG, "Malformed JSON for key " + userFriendlyKey(str) + ": " + string + ", falling back to default");
            return null;
        }
    }

    private static String userFriendlyKey(String str) {
        return str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) ? str.substring(6) : str;
    }

    public Uri getLink() {
        String string = getString(Constants.MessageNotificationKeys.LINK_ANDROID);
        if (TextUtils.isEmpty(string)) {
            string = getString(Constants.MessageNotificationKeys.LINK);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Uri.parse(string);
    }

    public String getSoundResourceName() {
        String string = getString(Constants.MessageNotificationKeys.SOUND_2);
        return TextUtils.isEmpty(string) ? getString(Constants.MessageNotificationKeys.SOUND) : string;
    }

    public long[] getVibrateTimings() {
        JSONArray jSONArray = getJSONArray(Constants.MessageNotificationKeys.VIBRATE_TIMINGS);
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = jSONArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = jSONArray.optLong(i);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            SentryLogcatAdapter.w(TAG, "User defined vibrateTimings is invalid: " + jSONArray + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    int[] getLightSettings() {
        JSONArray jSONArray = getJSONArray(Constants.MessageNotificationKeys.LIGHT_SETTINGS);
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArray.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            iArr[0] = getLightColor(jSONArray.optString(0));
            iArr[1] = jSONArray.optInt(1);
            iArr[2] = jSONArray.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e) {
            SentryLogcatAdapter.w(TAG, "LightSettings is invalid: " + jSONArray + ". " + e.getMessage() + ". Skipping setting LightSettings");
            return null;
        } catch (JSONException unused) {
            SentryLogcatAdapter.w(TAG, "LightSettings is invalid: " + jSONArray + ". Skipping setting LightSettings");
            return null;
        }
    }

    public Bundle paramsWithReservedKeysRemoved() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (isReservedKey(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle paramsForAnalyticsIntent() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (!isAnalyticsKey(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public String getLocalizedString(Resources resources, String str, String str2) {
        int i = 2 % 2;
        int i2 = artificialFrame + 63;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        Object obj = null;
        if (i2 % 2 != 0) {
            TextUtils.isEmpty(getLocalizationResourceForKey(str2));
            obj.hashCode();
            throw null;
        }
        String localizationResourceForKey = getLocalizationResourceForKey(str2);
        if (!(!TextUtils.isEmpty(localizationResourceForKey))) {
            int i3 = artificialFrame + 115;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
            if (i3 % 2 == 0) {
                return null;
            }
            obj.hashCode();
            throw null;
        }
        int identifier = resources.getIdentifier(localizationResourceForKey, TypedValues.Custom.S_STRING, str);
        if (identifier == 0) {
            SentryLogcatAdapter.w(TAG, userFriendlyKey(str2 + Constants.MessageNotificationKeys.TEXT_RESOURCE_SUFFIX) + " resource not found: " + str2 + " Default value will be used.");
            int i4 = artificialFrame + 5;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
            return null;
        }
        Object[] localizationArgsForKey = getLocalizationArgsForKey(str2);
        if (localizationArgsForKey == null) {
            String string = resources.getString(identifier);
            if (!string.startsWith(".,.%")) {
                return string;
            }
            Object[] objArr = new Object[1];
            a(string.substring(4), objArr);
            return ((String) objArr[0]).intern();
        }
        try {
            Configuration configuration = resources.getConfiguration();
            Locale locale = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
            String string2 = resources.getString(identifier);
            if (string2.startsWith(".,.%")) {
                int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
                artificialFrame = i6 % 128;
                int i7 = i6 % 2;
                Object[] objArr2 = new Object[1];
                a(string2.substring(4), objArr2);
                string2 = ((String) objArr2[0]).intern();
            }
            return String.format(locale, string2, localizationArgsForKey);
        } catch (MissingFormatArgumentException e) {
            SentryLogcatAdapter.w(TAG, "Missing format argument for " + userFriendlyKey(str2) + ": " + Arrays.toString(localizationArgsForKey) + " Default value will be used.", e);
            return null;
        }
    }

    public String getPossiblyLocalizedString(Resources resources, String str, String str2) {
        String string = getString(str2);
        return !TextUtils.isEmpty(string) ? string : getLocalizedString(resources, str, str2);
    }

    public boolean hasImage() {
        return !TextUtils.isEmpty(getString(Constants.MessageNotificationKeys.IMAGE_URL));
    }

    public String getNotificationChannelId() {
        return getString(Constants.MessageNotificationKeys.CHANNEL);
    }

    private static boolean isAnalyticsKey(String str) {
        return str.startsWith(Constants.AnalyticsKeys.PREFIX) || str.equals("from");
    }

    private static boolean isReservedKey(String str) {
        return str.startsWith(Constants.MessagePayloadKeys.RESERVED_CLIENT_LIB_PREFIX) || str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) || str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD);
    }

    private static int getLightColor(String str) {
        int color = Color.parseColor(str);
        if (color != -16777216) {
            return color;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    public boolean isNotification() {
        return getBoolean(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION);
    }

    public static boolean isNotification(Bundle bundle) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)) || AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString(keyWithOldPrefix(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)));
    }

    private static String keyWithOldPrefix(String str) {
        return !str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) ? str : str.replace(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX, Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD);
    }
}
