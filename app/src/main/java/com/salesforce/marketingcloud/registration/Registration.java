package com.salesforce.marketingcloud.registration;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.salesforce.marketingcloud.internal.o;
import com.salesforce.marketingcloud.storage.db.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Registration {
    public final String appId;
    public final String appVersion;
    public final Map<String, String> attributes;
    public final String contactKey;
    public final String deviceId;
    public final boolean dst;
    public final String hwid;
    private int id;
    public final String locale;
    public final boolean locationEnabled;
    public final String platform;
    public final String platformVersion;
    public final boolean proximityEnabled;
    public final boolean pushEnabled;
    public final String sdkVersion;
    public final String signedString;
    public final String systemToken;
    public final Set<String> tags;
    public final int timeZone;
    private final String uuid;

    public Registration(int i, @NotNull String uuid, @Nullable String str, @NotNull String deviceId, @Nullable String str2, @NotNull String sdkVersion, @NotNull String appVersion, boolean z, boolean z2, boolean z3, @NotNull String platformVersion, boolean z4, int i2, @Nullable String str3, @NotNull String platform, @NotNull String hwid, @NotNull String appId, @NotNull String locale, @NotNull Set<String> tags, @NotNull Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(platformVersion, "platformVersion");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(hwid, "hwid");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.id = i;
        this.uuid = uuid;
        this.signedString = str;
        this.deviceId = deviceId;
        this.systemToken = str2;
        this.sdkVersion = sdkVersion;
        this.appVersion = appVersion;
        this.dst = z;
        this.locationEnabled = z2;
        this.proximityEnabled = z3;
        this.platformVersion = platformVersion;
        this.pushEnabled = z4;
        this.timeZone = i2;
        this.contactKey = str3;
        this.platform = platform;
        this.hwid = hwid;
        this.appId = appId;
        this.locale = locale;
        this.tags = tags;
        this.attributes = attributes;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = RemoteConfigConstants.RequestFieldKey.APP_ID, imports = {}))
    public final String appId() {
        return this.appId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = RemoteConfigConstants.RequestFieldKey.APP_VERSION, imports = {}))
    public final String appVersion() {
        return this.appVersion;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "attributes", imports = {}))
    public final Map<String, String> attributes() {
        return this.attributes;
    }

    public final int component1$sdk_release() {
        return this.id;
    }

    public final boolean component10() {
        return this.proximityEnabled;
    }

    public final String component11() {
        return this.platformVersion;
    }

    public final boolean component12() {
        return this.pushEnabled;
    }

    public final int component13() {
        return this.timeZone;
    }

    public final String component14() {
        return this.contactKey;
    }

    public final String component15() {
        return this.platform;
    }

    public final String component16() {
        return this.hwid;
    }

    public final String component17() {
        return this.appId;
    }

    public final String component18() {
        return this.locale;
    }

    public final Set<String> component19() {
        return this.tags;
    }

    public final String component2$sdk_release() {
        return this.uuid;
    }

    public final Map<String, String> component20() {
        return this.attributes;
    }

    public final String component3() {
        return this.signedString;
    }

    public final String component4() {
        return this.deviceId;
    }

    public final String component5() {
        return this.systemToken;
    }

    public final String component6() {
        return this.sdkVersion;
    }

    public final String component7() {
        return this.appVersion;
    }

    public final boolean component8() {
        return this.dst;
    }

    public final boolean component9() {
        return this.locationEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "contactKey", imports = {}))
    public final String contactKey() {
        return this.contactKey;
    }

    public final Registration copy(int i, @NotNull String uuid, @Nullable String str, @NotNull String deviceId, @Nullable String str2, @NotNull String sdkVersion, @NotNull String appVersion, boolean z, boolean z2, boolean z3, @NotNull String platformVersion, boolean z4, int i2, @Nullable String str3, @NotNull String platform, @NotNull String hwid, @NotNull String appId, @NotNull String locale, @NotNull Set<String> tags, @NotNull Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(platformVersion, "platformVersion");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(hwid, "hwid");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new Registration(i, uuid, str, deviceId, str2, sdkVersion, appVersion, z, z2, z3, platformVersion, z4, i2, str3, platform, hwid, appId, locale, tags, attributes);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "deviceId", imports = {}))
    public final String deviceId() {
        return this.deviceId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = k.a.f, imports = {}))
    public final boolean dst() {
        return this.dst;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Registration)) {
            return false;
        }
        Registration registration = (Registration) obj;
        return this.id == registration.id && Intrinsics.areEqual(this.uuid, registration.uuid) && Intrinsics.areEqual(this.signedString, registration.signedString) && Intrinsics.areEqual(this.deviceId, registration.deviceId) && Intrinsics.areEqual(this.systemToken, registration.systemToken) && Intrinsics.areEqual(this.sdkVersion, registration.sdkVersion) && Intrinsics.areEqual(this.appVersion, registration.appVersion) && this.dst == registration.dst && this.locationEnabled == registration.locationEnabled && this.proximityEnabled == registration.proximityEnabled && Intrinsics.areEqual(this.platformVersion, registration.platformVersion) && this.pushEnabled == registration.pushEnabled && this.timeZone == registration.timeZone && Intrinsics.areEqual(this.contactKey, registration.contactKey) && Intrinsics.areEqual(this.platform, registration.platform) && Intrinsics.areEqual(this.hwid, registration.hwid) && Intrinsics.areEqual(this.appId, registration.appId) && Intrinsics.areEqual(this.locale, registration.locale) && Intrinsics.areEqual(this.tags, registration.tags) && Intrinsics.areEqual(this.attributes, registration.attributes);
    }

    public final int getId$sdk_release() {
        return this.id;
    }

    public final String getUuid$sdk_release() {
        return this.uuid;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id);
        int iHashCode2 = this.uuid.hashCode();
        String str = this.signedString;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        int iHashCode4 = this.deviceId.hashCode();
        String str2 = this.systemToken;
        int iHashCode5 = str2 == null ? 0 : str2.hashCode();
        int iHashCode6 = this.sdkVersion.hashCode();
        int iHashCode7 = this.appVersion.hashCode();
        int iHashCode8 = Boolean.hashCode(this.dst);
        int iHashCode9 = Boolean.hashCode(this.locationEnabled);
        int iHashCode10 = Boolean.hashCode(this.proximityEnabled);
        int iHashCode11 = this.platformVersion.hashCode();
        int iHashCode12 = Boolean.hashCode(this.pushEnabled);
        int iHashCode13 = Integer.hashCode(this.timeZone);
        String str3 = this.contactKey;
        return (((((((((((((((((((((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode11) * 31) + iHashCode12) * 31) + iHashCode13) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + this.platform.hashCode()) * 31) + this.hwid.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.locale.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.attributes.hashCode();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = k.a.m, imports = {}))
    public final String hwid() {
        return this.hwid;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "locale", imports = {}))
    public final String locale() {
        return this.locale;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "locationEnabled", imports = {}))
    public final boolean locationEnabled() {
        return this.locationEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "platform", imports = {}))
    public final String platform() {
        return this.platform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = RemoteConfigConstants.RequestFieldKey.PLATFORM_VERSION, imports = {}))
    public final String platformVersion() {
        return this.platformVersion;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proximityEnabled", imports = {}))
    public final boolean proximityEnabled() {
        return this.proximityEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pushEnabled", imports = {}))
    public final boolean pushEnabled() {
        return this.pushEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = RemoteConfigConstants.RequestFieldKey.SDK_VERSION, imports = {}))
    public final String sdkVersion() {
        return this.sdkVersion;
    }

    public final void setId$sdk_release(int i) {
        this.id = i;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "signedString", imports = {}))
    public final String signedString() {
        return this.signedString;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "systemToken", imports = {}))
    public final String systemToken() {
        return this.systemToken;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "tags", imports = {}))
    public final Set<String> tags() {
        return this.tags;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = RemoteConfigConstants.RequestFieldKey.TIME_ZONE, imports = {}))
    public final int timeZone() {
        return this.timeZone;
    }

    public final JSONObject toJson$sdk_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uuid", this.uuid);
        jSONObject.put("signedString", this.signedString);
        jSONObject.put("deviceID", this.deviceId);
        String str = this.systemToken;
        if (str != null) {
            jSONObject.put("device_Token", str);
        }
        jSONObject.put("sdk_Version", this.sdkVersion);
        jSONObject.put("app_Version", this.appVersion);
        jSONObject.put("dST", this.dst);
        jSONObject.put("location_Enabled", this.locationEnabled);
        jSONObject.put("proximity_Enabled", this.proximityEnabled);
        jSONObject.put("platform_Version", this.platformVersion);
        jSONObject.put("push_Enabled", this.pushEnabled);
        jSONObject.put(RemoteConfigConstants.RequestFieldKey.TIME_ZONE, String.valueOf(this.timeZone));
        String str2 = this.contactKey;
        if (str2 != null) {
            jSONObject.put("subscriberKey", str2);
        }
        jSONObject.put("platform", this.platform);
        jSONObject.put(k.a.m, this.hwid);
        jSONObject.put(com.salesforce.marketingcloud.analytics.b.v, this.appId);
        jSONObject.put("locale", this.locale);
        jSONObject.put("tags", new JSONArray((Collection) new TreeSet(this.tags)));
        jSONObject.put("attributes", o.a(MapsKt__MapsJVMKt.toSortedMap(this.attributes)));
        return jSONObject;
    }

    public String toString() {
        return "Registration(id=" + this.id + ", uuid=" + this.uuid + ", signedString=" + this.signedString + ", deviceId=" + this.deviceId + ", systemToken=" + this.systemToken + ", sdkVersion=" + this.sdkVersion + ", appVersion=" + this.appVersion + ", dst=" + this.dst + ", locationEnabled=" + this.locationEnabled + ", proximityEnabled=" + this.proximityEnabled + ", platformVersion=" + this.platformVersion + ", pushEnabled=" + this.pushEnabled + ", timeZone=" + this.timeZone + ", contactKey=" + this.contactKey + ", platform=" + this.platform + ", hwid=" + this.hwid + ", appId=" + this.appId + ", locale=" + this.locale + ", tags=" + this.tags + ", attributes=" + this.attributes + ")";
    }

    public /* synthetic */ Registration(int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, String str7, boolean z4, int i2, String str8, String str9, String str10, String str11, String str12, Set set, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, str, str2, str3, (i3 & 16) != 0 ? null : str4, str5, str6, z, z2, z3, str7, z4, i2, (i3 & 8192) != 0 ? null : str8, str9, str10, str11, str12, set, map);
    }

    public Registration(@NotNull JSONObject json) throws JSONException {
        String string;
        Intrinsics.checkNotNullParameter(json, "json");
        String string2 = json.getString("uuid");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String strOptString = json.optString("signedString");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strB = o.b(strOptString);
        String string3 = json.getString("deviceID");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String strOptString2 = json.optString("device_Token");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strB2 = o.b(strOptString2);
        String string4 = json.getString("sdk_Version");
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = json.getString("app_Version");
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        boolean z = json.getBoolean("dST");
        boolean z2 = json.getBoolean("location_Enabled");
        boolean z3 = json.getBoolean("proximity_Enabled");
        String string6 = json.getString("platform_Version");
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        boolean z4 = json.getBoolean("push_Enabled");
        String string7 = json.getString(RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        int i = Integer.parseInt(string7);
        String strOptString3 = json.optString("subscriberKey");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strB3 = o.b(strOptString3);
        String string8 = json.getString("platform");
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        String string9 = json.getString(k.a.m);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        String string10 = json.getString(com.salesforce.marketingcloud.analytics.b.v);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        String string11 = json.getString("locale");
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        JSONArray jSONArray = json.getJSONArray("tags");
        Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
        IntRange intRangeUntil = RangesKt___RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it2 = intRangeUntil.iterator();
        while (it2.hasNext()) {
            int iNextInt = ((IntIterator) it2).nextInt();
            Iterator<Integer> it3 = it2;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            String str = string6;
            boolean z5 = z3;
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                Object jSONObject = jSONArray.getJSONObject(iNextInt);
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONObject;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string = (String) Integer.valueOf(jSONArray.getInt(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string = (String) Double.valueOf(jSONArray.getDouble(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string = (String) Long.valueOf(jSONArray.getLong(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                string = (String) Boolean.valueOf(jSONArray.getBoolean(iNextInt));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                string = jSONArray.getString(iNextInt);
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                Object obj = jSONArray.get(iNextInt);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) obj;
            }
            arrayList.add(string);
            it2 = it3;
            string6 = str;
            z3 = z5;
        }
        boolean z6 = z3;
        String str2 = string6;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!TextUtils.isEmpty((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        Set set = CollectionsKt___CollectionsKt.toSet(arrayList2);
        JSONArray jSONArray2 = json.getJSONArray("attributes");
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
        this(0, string2, strB, string3, strB2, string4, string5, z, z2, z6, str2, z4, i, strB3, string8, string9, string10, string11, set, o.b(jSONArray2));
    }
}
