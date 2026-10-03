package com.facebook.appevents.integrity;

import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.soloader.Elf64;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MACARuleMatchingManager {
    private static JSONArray MACARules;
    private static boolean enabled;
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    private static String[] keys = {NotificationCompat.CATEGORY_EVENT, "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private MACARuleMatchingManager() {
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            INSTANCE.loadMACARules();
            if (MACARules != null) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    private final void loadMACARules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            MACARules = fetchedAppSettingsQueryAppSettings.getMACARuleMatchingSetting();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final String getKey(@NotNull JSONObject logic) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(logic, "logic");
            Iterator<String> itKeys = logic.keys();
            if (itKeys.hasNext()) {
                return itKeys.next();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:107:0x01db  */
    /* JADX WARN: Code duplicated, block: B:117:0x020b  */
    /* JADX WARN: Code duplicated, block: B:122:0x0219 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:123:0x021a A[Catch: all -> 0x034d, TryCatch #0 {all -> 0x034d, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0093, B:34:0x009d, B:37:0x00a9, B:123:0x021a, B:126:0x0222, B:127:0x0226, B:129:0x022c, B:40:0x00b3, B:43:0x00bd, B:44:0x00d7, B:137:0x025b, B:140:0x0263, B:141:0x0267, B:143:0x026d, B:47:0x00e1, B:50:0x00eb, B:51:0x0105, B:99:0x01b5, B:54:0x010f, B:93:0x0199, B:57:0x0119, B:84:0x0173, B:60:0x0123, B:63:0x012d, B:115:0x01fb, B:66:0x0137, B:69:0x0141, B:178:0x031f, B:72:0x014b, B:105:0x01cb, B:75:0x0155, B:78:0x015f, B:111:0x01e7, B:81:0x0169, B:87:0x0185, B:90:0x018f, B:96:0x01ab, B:102:0x01c1, B:108:0x01dd, B:112:0x01f1, B:118:0x020d, B:132:0x024e, B:146:0x028f, B:149:0x0299, B:152:0x02b5, B:155:0x02bf, B:156:0x02c9, B:172:0x030a, B:159:0x02d3, B:162:0x02dd, B:163:0x02eb, B:166:0x02f5, B:167:0x02fe, B:173:0x0313, B:179:0x0328, B:182:0x0331, B:20:0x005b), top: B:189:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0220  */
    /* JADX WARN: Code duplicated, block: B:126:0x0222 A[Catch: all -> 0x034d, TryCatch #0 {all -> 0x034d, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0093, B:34:0x009d, B:37:0x00a9, B:123:0x021a, B:126:0x0222, B:127:0x0226, B:129:0x022c, B:40:0x00b3, B:43:0x00bd, B:44:0x00d7, B:137:0x025b, B:140:0x0263, B:141:0x0267, B:143:0x026d, B:47:0x00e1, B:50:0x00eb, B:51:0x0105, B:99:0x01b5, B:54:0x010f, B:93:0x0199, B:57:0x0119, B:84:0x0173, B:60:0x0123, B:63:0x012d, B:115:0x01fb, B:66:0x0137, B:69:0x0141, B:178:0x031f, B:72:0x014b, B:105:0x01cb, B:75:0x0155, B:78:0x015f, B:111:0x01e7, B:81:0x0169, B:87:0x0185, B:90:0x018f, B:96:0x01ab, B:102:0x01c1, B:108:0x01dd, B:112:0x01f1, B:118:0x020d, B:132:0x024e, B:146:0x028f, B:149:0x0299, B:152:0x02b5, B:155:0x02bf, B:156:0x02c9, B:172:0x030a, B:159:0x02d3, B:162:0x02dd, B:163:0x02eb, B:166:0x02f5, B:167:0x02fe, B:173:0x0313, B:179:0x0328, B:182:0x0331, B:20:0x005b), top: B:189:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:129:0x022c A[Catch: all -> 0x034d, TryCatch #0 {all -> 0x034d, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0093, B:34:0x009d, B:37:0x00a9, B:123:0x021a, B:126:0x0222, B:127:0x0226, B:129:0x022c, B:40:0x00b3, B:43:0x00bd, B:44:0x00d7, B:137:0x025b, B:140:0x0263, B:141:0x0267, B:143:0x026d, B:47:0x00e1, B:50:0x00eb, B:51:0x0105, B:99:0x01b5, B:54:0x010f, B:93:0x0199, B:57:0x0119, B:84:0x0173, B:60:0x0123, B:63:0x012d, B:115:0x01fb, B:66:0x0137, B:69:0x0141, B:178:0x031f, B:72:0x014b, B:105:0x01cb, B:75:0x0155, B:78:0x015f, B:111:0x01e7, B:81:0x0169, B:87:0x0185, B:90:0x018f, B:96:0x01ab, B:102:0x01c1, B:108:0x01dd, B:112:0x01f1, B:118:0x020d, B:132:0x024e, B:146:0x028f, B:149:0x0299, B:152:0x02b5, B:155:0x02bf, B:156:0x02c9, B:172:0x030a, B:159:0x02d3, B:162:0x02dd, B:163:0x02eb, B:166:0x02f5, B:167:0x02fe, B:173:0x0313, B:179:0x0328, B:182:0x0331, B:20:0x005b), top: B:189:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:143:0x026d A[Catch: all -> 0x034d, TryCatch #0 {all -> 0x034d, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0093, B:34:0x009d, B:37:0x00a9, B:123:0x021a, B:126:0x0222, B:127:0x0226, B:129:0x022c, B:40:0x00b3, B:43:0x00bd, B:44:0x00d7, B:137:0x025b, B:140:0x0263, B:141:0x0267, B:143:0x026d, B:47:0x00e1, B:50:0x00eb, B:51:0x0105, B:99:0x01b5, B:54:0x010f, B:93:0x0199, B:57:0x0119, B:84:0x0173, B:60:0x0123, B:63:0x012d, B:115:0x01fb, B:66:0x0137, B:69:0x0141, B:178:0x031f, B:72:0x014b, B:105:0x01cb, B:75:0x0155, B:78:0x015f, B:111:0x01e7, B:81:0x0169, B:87:0x0185, B:90:0x018f, B:96:0x01ab, B:102:0x01c1, B:108:0x01dd, B:112:0x01f1, B:118:0x020d, B:132:0x024e, B:146:0x028f, B:149:0x0299, B:152:0x02b5, B:155:0x02bf, B:156:0x02c9, B:172:0x030a, B:159:0x02d3, B:162:0x02dd, B:163:0x02eb, B:166:0x02f5, B:167:0x02fe, B:173:0x0313, B:179:0x0328, B:182:0x0331, B:20:0x005b), top: B:189:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:171:0x0309 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:172:0x030a A[Catch: all -> 0x034d, TryCatch #0 {all -> 0x034d, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0093, B:34:0x009d, B:37:0x00a9, B:123:0x021a, B:126:0x0222, B:127:0x0226, B:129:0x022c, B:40:0x00b3, B:43:0x00bd, B:44:0x00d7, B:137:0x025b, B:140:0x0263, B:141:0x0267, B:143:0x026d, B:47:0x00e1, B:50:0x00eb, B:51:0x0105, B:99:0x01b5, B:54:0x010f, B:93:0x0199, B:57:0x0119, B:84:0x0173, B:60:0x0123, B:63:0x012d, B:115:0x01fb, B:66:0x0137, B:69:0x0141, B:178:0x031f, B:72:0x014b, B:105:0x01cb, B:75:0x0155, B:78:0x015f, B:111:0x01e7, B:81:0x0169, B:87:0x0185, B:90:0x018f, B:96:0x01ab, B:102:0x01c1, B:108:0x01dd, B:112:0x01f1, B:118:0x020d, B:132:0x024e, B:146:0x028f, B:149:0x0299, B:152:0x02b5, B:155:0x02bf, B:156:0x02c9, B:172:0x030a, B:159:0x02d3, B:162:0x02dd, B:163:0x02eb, B:166:0x02f5, B:167:0x02fe, B:173:0x0313, B:179:0x0328, B:182:0x0331, B:20:0x005b), top: B:189:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:177:0x031e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:178:0x031f A[Catch: all -> 0x034d, TryCatch #0 {all -> 0x034d, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0093, B:34:0x009d, B:37:0x00a9, B:123:0x021a, B:126:0x0222, B:127:0x0226, B:129:0x022c, B:40:0x00b3, B:43:0x00bd, B:44:0x00d7, B:137:0x025b, B:140:0x0263, B:141:0x0267, B:143:0x026d, B:47:0x00e1, B:50:0x00eb, B:51:0x0105, B:99:0x01b5, B:54:0x010f, B:93:0x0199, B:57:0x0119, B:84:0x0173, B:60:0x0123, B:63:0x012d, B:115:0x01fb, B:66:0x0137, B:69:0x0141, B:178:0x031f, B:72:0x014b, B:105:0x01cb, B:75:0x0155, B:78:0x015f, B:111:0x01e7, B:81:0x0169, B:87:0x0185, B:90:0x018f, B:96:0x01ab, B:102:0x01c1, B:108:0x01dd, B:112:0x01f1, B:118:0x020d, B:132:0x024e, B:146:0x028f, B:149:0x0299, B:152:0x02b5, B:155:0x02bf, B:156:0x02c9, B:172:0x030a, B:159:0x02d3, B:162:0x02dd, B:163:0x02eb, B:166:0x02f5, B:167:0x02fe, B:173:0x0313, B:179:0x0328, B:182:0x0331, B:20:0x005b), top: B:189:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:191:0x024c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:? A[LOOP:0: B:127:0x0226->B:192:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x028d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:? A[LOOP:1: B:141:0x0267->B:195:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x005b A[Catch: all -> 0x034d, TryCatch #0 {all -> 0x034d, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0093, B:34:0x009d, B:37:0x00a9, B:123:0x021a, B:126:0x0222, B:127:0x0226, B:129:0x022c, B:40:0x00b3, B:43:0x00bd, B:44:0x00d7, B:137:0x025b, B:140:0x0263, B:141:0x0267, B:143:0x026d, B:47:0x00e1, B:50:0x00eb, B:51:0x0105, B:99:0x01b5, B:54:0x010f, B:93:0x0199, B:57:0x0119, B:84:0x0173, B:60:0x0123, B:63:0x012d, B:115:0x01fb, B:66:0x0137, B:69:0x0141, B:178:0x031f, B:72:0x014b, B:105:0x01cb, B:75:0x0155, B:78:0x015f, B:111:0x01e7, B:81:0x0169, B:87:0x0185, B:90:0x018f, B:96:0x01ab, B:102:0x01c1, B:108:0x01dd, B:112:0x01f1, B:118:0x020d, B:132:0x024e, B:146:0x028f, B:149:0x0299, B:152:0x02b5, B:155:0x02bf, B:156:0x02c9, B:172:0x030a, B:159:0x02d3, B:162:0x02dd, B:163:0x02eb, B:166:0x02f5, B:167:0x02fe, B:173:0x0313, B:179:0x0328, B:182:0x0331, B:20:0x005b), top: B:189:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0061  */
    /* JADX WARN: Code duplicated, block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0064 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x0183  */
    /* JADX WARN: Code duplicated, block: B:95:0x01a9  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final boolean stringComparison(@NotNull String variable, @NotNull JSONObject values, @Nullable Bundle bundle) {
        Object obj;
        String lowerCase;
        String lowerCase2;
        String lowerCase3;
        String lowerCase4;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(variable, "variable");
            Intrinsics.checkNotNullParameter(values, "values");
            String key = getKey(values);
            if (key == null) {
                return false;
            }
            String string = values.get(key).toString();
            ArrayList<String> stringArrayList = getStringArrayList(values.optJSONArray(key));
            if (Intrinsics.areEqual(key, "exists")) {
                return bundle != null && bundle.containsKey(variable) == Boolean.parseBoolean(string);
            }
            if (bundle != null) {
                String lowerCase5 = variable.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase5, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                obj = bundle.get(lowerCase5);
                if (obj == null) {
                    if (bundle != null) {
                        obj = bundle.get(variable);
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        return false;
                    }
                }
            } else {
                if (bundle != null) {
                    obj = bundle.get(variable);
                } else {
                    obj = null;
                }
                if (obj == null) {
                    return false;
                }
            }
            switch (key.hashCode()) {
                case -1729128927:
                    if (!key.equals("i_not_contains")) {
                        return false;
                    }
                    String string2 = obj.toString();
                    Locale locale = Locale.ROOT;
                    String lowerCase6 = string2.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase6, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String lowerCase7 = string.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase7, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase6, (CharSequence) lowerCase7, false, 2, (Object) null)) {
                        return false;
                    }
                case -1179774633:
                    if (!key.equals("is_any")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    return stringArrayList.contains(obj.toString());
                case -1039699439:
                    if (!key.equals("not_in")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    return stringArrayList.contains(obj.toString());
                case -969266188:
                    if (key.equals("starts_with")) {
                        return StringsKt__StringsJVMKt.startsWith$default(obj.toString(), string, false, 2, null);
                    }
                    return false;
                case -966353971:
                    if (key.equals("regex_match")) {
                        return new Regex(string).matches(obj.toString());
                    }
                    return false;
                case -665609109:
                    if (!key.equals("is_not_any")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    return stringArrayList.contains(obj.toString());
                case -567445985:
                    if (key.equals("contains")) {
                        return StringsKt__StringsKt.contains$default((CharSequence) obj.toString(), (CharSequence) string, false, 2, (Object) null);
                    }
                    return false;
                case -327990090:
                    if (!key.equals("i_str_neq")) {
                        return false;
                    }
                    String string3 = obj.toString();
                    Locale locale2 = Locale.ROOT;
                    String lowerCase8 = string3.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase8, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String lowerCase9 = string.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase9, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    return !Intrinsics.areEqual(lowerCase8, lowerCase9);
                case -159812115:
                    if (!key.equals("i_is_any")) {
                        return false;
                    }
                    if (stringArrayList == null && !stringArrayList.isEmpty()) {
                        for (String str : stringArrayList) {
                            Locale locale3 = Locale.ROOT;
                            lowerCase = str.toLowerCase(locale3);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                            lowerCase2 = obj.toString().toLowerCase(locale3);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                            if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                            }
                        }
                        return false;
                    }
                    return false;
                case -92753547:
                    if (!key.equals("i_str_not_in")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    if (stringArrayList.isEmpty()) {
                        for (String str2 : stringArrayList) {
                            Locale locale4 = Locale.ROOT;
                            lowerCase3 = str2.toLowerCase(locale4);
                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                            lowerCase4 = obj.toString().toLowerCase(locale4);
                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                            if (Intrinsics.areEqual(lowerCase3, lowerCase4)) {
                                return false;
                            }
                        }
                    }
                case 60:
                    if (!key.equals("<")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(string)) {
                        return false;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (!key.equals("=")) {
                        return false;
                    }
                    return Intrinsics.areEqual(obj.toString(), string);
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (!key.equals(">")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(string)) {
                        return false;
                    }
                case 1084:
                    if (!key.equals("!=")) {
                        return false;
                    }
                    if (Intrinsics.areEqual(obj.toString(), string)) {
                        return false;
                    }
                case 1921:
                    if (!key.equals("<=")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(string)) {
                        return false;
                    }
                case 1952:
                    if (!key.equals("==")) {
                        return false;
                    }
                    return Intrinsics.areEqual(obj.toString(), string);
                case 1983:
                    if (!key.equals(">=")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(string)) {
                        return false;
                    }
                case 3244:
                    if (!key.equals("eq")) {
                        return false;
                    }
                    return Intrinsics.areEqual(obj.toString(), string);
                case 3294:
                    if (!key.equals(UserDataStore.GENDER)) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(string)) {
                        return false;
                    }
                case 3309:
                    if (!key.equals("gt")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(string)) {
                        return false;
                    }
                case 3365:
                    if (!key.equals("in")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    return stringArrayList.contains(obj.toString());
                case 3449:
                    if (!key.equals("le")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(string)) {
                        return false;
                    }
                case 3464:
                    if (!key.equals("lt")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(string)) {
                        return false;
                    }
                case 3511:
                    if (!key.equals("ne")) {
                        return false;
                    }
                    if (Intrinsics.areEqual(obj.toString(), string)) {
                        return false;
                    }
                case 102680:
                    if (!key.equals("gte")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(string)) {
                        return false;
                    }
                case 107485:
                    if (!key.equals("lte")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(string)) {
                        return false;
                    }
                case 108954:
                    if (!key.equals("neq")) {
                        return false;
                    }
                    if (Intrinsics.areEqual(obj.toString(), string)) {
                        return false;
                    }
                case 127966736:
                    if (!key.equals("i_str_eq")) {
                        return false;
                    }
                    String string4 = obj.toString();
                    Locale locale5 = Locale.ROOT;
                    String lowerCase10 = string4.toLowerCase(locale5);
                    Intrinsics.checkNotNullExpressionValue(lowerCase10, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String lowerCase11 = string.toLowerCase(locale5);
                    Intrinsics.checkNotNullExpressionValue(lowerCase11, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    return Intrinsics.areEqual(lowerCase10, lowerCase11);
                case 127966857:
                    if (!key.equals("i_str_in")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    while (r8.hasNext()) {
                        Locale locale6 = Locale.ROOT;
                        lowerCase = str.toLowerCase(locale6);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        lowerCase2 = obj.toString().toLowerCase(locale6);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        }
                    }
                    return false;
                case 363990325:
                    if (!key.equals("i_contains")) {
                        return false;
                    }
                    String string5 = obj.toString();
                    Locale locale7 = Locale.ROOT;
                    String lowerCase12 = string5.toLowerCase(locale7);
                    Intrinsics.checkNotNullExpressionValue(lowerCase12, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String lowerCase13 = string.toLowerCase(locale7);
                    Intrinsics.checkNotNullExpressionValue(lowerCase13, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    return StringsKt__StringsKt.contains$default((CharSequence) lowerCase12, (CharSequence) lowerCase13, false, 2, (Object) null);
                case 1091487233:
                    if (!key.equals("i_is_not_any")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    if (stringArrayList.isEmpty()) {
                        while (r8.hasNext()) {
                            Locale locale8 = Locale.ROOT;
                            lowerCase3 = str2.toLowerCase(locale8);
                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                            lowerCase4 = obj.toString().toLowerCase(locale8);
                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                            if (Intrinsics.areEqual(lowerCase3, lowerCase4)) {
                                return false;
                            }
                        }
                    }
                case 1918401035:
                    if (!key.equals("not_contains") || StringsKt__StringsKt.contains$default((CharSequence) obj.toString(), (CharSequence) string, false, 2, (Object) null)) {
                        return false;
                    }
                case 1961112862:
                    if (!key.equals("i_starts_with")) {
                        return false;
                    }
                    String string6 = obj.toString();
                    Locale locale9 = Locale.ROOT;
                    String lowerCase14 = string6.toLowerCase(locale9);
                    Intrinsics.checkNotNullExpressionValue(lowerCase14, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String lowerCase15 = string.toLowerCase(locale9);
                    Intrinsics.checkNotNullExpressionValue(lowerCase15, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    return StringsKt__StringsJVMKt.startsWith$default(lowerCase14, lowerCase15, false, 2, null);
                default:
                    return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return false;
        }
    }

    @JvmStatic
    public static final ArrayList<String> getStringArrayList(@Nullable JSONArray jSONArray) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) || jSONArray == null) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.get(i).toString());
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isMatchCCRule(@Nullable String str, @Nullable Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) && str != null && bundle != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String key = getKey(jSONObject);
                if (key == null) {
                    return false;
                }
                Object obj = jSONObject.get(key);
                int iHashCode = key.hashCode();
                if (iHashCode != 3555) {
                    if (iHashCode != 96727) {
                        if (iHashCode == 109267 && key.equals("not")) {
                            return !isMatchCCRule(obj.toString(), bundle);
                        }
                    } else if (key.equals("and")) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray == null) {
                            return false;
                        }
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            if (!isMatchCCRule(jSONArray.get(i).toString(), bundle)) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if (key.equals("or")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2 == null) {
                        return false;
                    }
                    int length2 = jSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        if (isMatchCCRule(jSONArray2.get(i2).toString(), bundle)) {
                            return true;
                        }
                    }
                    return false;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    return false;
                }
                return stringComparison(key, jSONObject2, bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            }
        }
        return false;
    }

    @JvmStatic
    public static final String getMatchPropertyIDs(@Nullable Bundle bundle) {
        String strOptString;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = MACARules;
            if (jSONArray == null) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            if (jSONArray != null && jSONArray.length() == 0) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            JSONArray jSONArray2 = MACARules;
            Intrinsics.checkNotNull(jSONArray2, "null cannot be cast to non-null type org.json.JSONArray");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                String strOptString2 = jSONArray2.optString(i);
                if (strOptString2 != null) {
                    JSONObject jSONObject = new JSONObject(strOptString2);
                    long jOptLong = jSONObject.optLong("id");
                    if (jOptLong != 0 && (strOptString = jSONObject.optString("rule")) != null && isMatchCCRule(strOptString, bundle)) {
                        arrayList.add(Long.valueOf(jOptLong));
                    }
                }
            }
            String string = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONArray(res).toString()");
            return string;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final void processParameters(@Nullable Bundle bundle, @NotNull String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!enabled || bundle == null) {
                return;
            }
            try {
                generateInfo(bundle, event);
                bundle.putString("_audiencePropertyIds", getMatchPropertyIDs(bundle));
                bundle.putString("cs_maca", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                removeGeneratedInfo(bundle);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void generateInfo(@NotNull Bundle params, @NotNull String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(event, "event");
            params.putString(NotificationCompat.CATEGORY_EVENT, event);
            StringBuilder sb = new StringBuilder();
            Utility utility = Utility.INSTANCE;
            Locale locale = utility.getLocale();
            String language = locale != null ? locale.getLanguage() : null;
            String str = "";
            if (language == null) {
                language = "";
            }
            sb.append(language);
            sb.append('_');
            Locale locale2 = utility.getLocale();
            String country = locale2 != null ? locale2.getCountry() : null;
            if (country == null) {
                country = "";
            }
            sb.append(country);
            params.putString("_locale", sb.toString());
            String versionName = utility.getVersionName();
            if (versionName == null) {
                versionName = "";
            }
            params.putString("_appVersion", versionName);
            params.putString("_deviceOS", "ANDROID");
            params.putString("_platform", "mobile");
            String str2 = Build.MODEL;
            if (str2 == null) {
                str2 = "";
            }
            params.putString("_deviceModel", str2);
            params.putString("_nativeAppID", FacebookSdk.getApplicationId());
            String versionName2 = utility.getVersionName();
            if (versionName2 != null) {
                str = versionName2;
            }
            params.putString("_nativeAppShortVersion", str);
            params.putString("_timezone", utility.getDeviceTimeZoneName());
            params.putString("_carrier", utility.getCarrierName());
            params.putString("_deviceOSTypeName", "ANDROID");
            params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
            params.putLong("_remainingDiskGB", utility.getAvailableExternalStorageGB());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void removeGeneratedInfo(@NotNull Bundle params) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            for (String str : keys) {
                params.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }
}
