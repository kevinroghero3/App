package com.salesforce.marketingcloud.notifications;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.internal.o;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.push.data.RichFeatures;
import com.salesforce.marketingcloud.storage.db.i;
import io.sentry.protocol.Geo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationMessage implements Parcelable {
    public static final String NOTIF_KEY_ALERT = "alert";
    public static final String NOTIF_KEY_MESSAGE_DATE_UTC = "messageDateUtc";
    public static final String NOTIF_KEY_SOUND = "sound";
    public static final String NOTIF_KEY_SUB_TITLE = "subtitle";
    public static final String NOTIF_KEY_TIMESTAMP = "timestamp";
    public static final String NOTIF_KEY_TITLE = "title";
    public final String alert;
    public final String custom;
    public final Map<String, String> customKeys;
    public final String id;
    public final String mediaAltText;
    public final String mediaUrl;
    private int notificationId;
    public final Map<String, String> payload;
    private final String propertyBag;
    public final Region region;
    public final String requestId;
    public final RichFeatures richFeatures;
    public final Sound sound;
    public final String soundName;
    public final String subtitle;
    public final String title;
    public final Trigger trigger;
    public final Type type;
    public final String url;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<NotificationMessage> CREATOR = new b();
    public static final String NOTIF_KEY_ID = "_m";
    public static final String NOTIF_KEY_SID = "_sid";
    public static final String NOTIF_KEY_MESSAGE_TYPE = "_mt";
    public static final String NOTIF_KEY_MESSAGE_HASH = "_h";
    public static final String NOTIF_KEY_REQUEST_ID = "_r";
    public static final String NOTIF_KEY_PB_ID = "_pb";
    public static final String NOTIF_KEY_MEDIA_URL = "_mediaUrl";
    public static final String NOTIF_KEY_MEDIA_ALT = "_mediaAlt";
    public static final String NOTIF_KEY_CLOUD_PAGE_URL = "_x";
    public static final String NOTIF_KEY_OPEN_DIRECT_URL = "_od";
    public static final String NOTIF_KEY_CONTENT_TYPE = "_ct";
    public static final String NOTIF_KEY_INBOX_SUB_TITLE = "inboxSubtitle";
    public static final String NOTIF_KEY_INBOX_MESSAGE = "inboxMessage";
    public static final String NOTIF_KEY_RICH_FEATURES = "_rf";
    public static final String NOTIF_KEY_END_DATE = "_endDt";
    private static final String[] KNOWN_KEYS = {NOTIF_KEY_ID, NOTIF_KEY_SID, "timestamp", NOTIF_KEY_MESSAGE_TYPE, NOTIF_KEY_MESSAGE_HASH, NOTIF_KEY_REQUEST_ID, NOTIF_KEY_PB_ID, "title", "subtitle", "alert", "sound", NOTIF_KEY_MEDIA_URL, NOTIF_KEY_MEDIA_ALT, NOTIF_KEY_CLOUD_PAGE_URL, NOTIF_KEY_OPEN_DIRECT_URL, NOTIF_KEY_CONTENT_TYPE, NOTIF_KEY_INBOX_SUB_TITLE, NOTIF_KEY_INBOX_MESSAGE, NOTIF_KEY_RICH_FEATURES, NOTIF_KEY_END_DATE, "messageDateUtc"};

    public enum Sound {
        CUSTOM,
        DEFAULT,
        NONE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Sound> getEntries() {
            return $ENTRIES;
        }
    }

    public enum Trigger {
        PUSH,
        GEOFENCE,
        BEACON,
        DOWNLOAD;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Trigger> getEntries() {
            return $ENTRIES;
        }
    }

    public enum Type {
        OPEN_DIRECT,
        CLOUD_PAGE,
        OTHER;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String[] a() {
            return NotificationMessage.KNOWN_KEYS;
        }

        private a() {
        }

        public final NotificationMessage a(@NotNull Map<String, String> data) {
            Pair pair;
            HashMap map;
            Iterator<Map.Entry<String, String>> it2;
            String str;
            RichFeatures richFeatures;
            Intrinsics.checkNotNullParameter(data, "data");
            RichFeatures richFeatures2 = null;
            if (data.containsKey(NotificationMessage.NOTIF_KEY_CLOUD_PAGE_URL)) {
                pair = TuplesKt.to(Type.CLOUD_PAGE, data.get(NotificationMessage.NOTIF_KEY_CLOUD_PAGE_URL));
            } else {
                pair = data.containsKey(NotificationMessage.NOTIF_KEY_OPEN_DIRECT_URL) ? TuplesKt.to(Type.OPEN_DIRECT, data.get(NotificationMessage.NOTIF_KEY_OPEN_DIRECT_URL)) : TuplesKt.to(Type.OTHER, null);
            }
            Type type = (Type) pair.component1();
            String str2 = (String) pair.component2();
            Pair<Sound, String> pairA = a(data.get("sound"));
            Sound soundComponent1 = pairA.component1();
            String strComponent2 = pairA.component2();
            String str3 = data.get(NotificationMessage.NOTIF_KEY_ID);
            if (str3 == null) {
                throw new IllegalStateException("message id missing");
            }
            String str4 = str3;
            String str5 = data.get(NotificationMessage.NOTIF_KEY_REQUEST_ID);
            String str6 = data.get("title");
            String str7 = data.get("subtitle");
            String str8 = data.get("alert");
            if (str8 == null) {
                throw new IllegalStateException("alert missing");
            }
            String str9 = str8;
            String str10 = data.get(NotificationMessage.NOTIF_KEY_MEDIA_URL);
            String str11 = data.get(NotificationMessage.NOTIF_KEY_MEDIA_ALT);
            HashMap map2 = new HashMap(data);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<String, String>> it3 = data.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry<String, String> next = it3.next();
                String key = next.getKey();
                if (ArraysKt___ArraysKt.contains(NotificationMessage.Companion.a(), key)) {
                    it2 = it3;
                    map = map2;
                    str = str2;
                    richFeatures = null;
                    if (StringsKt__StringsJVMKt.startsWith$default(key, ".google", false, 2, null)) {
                    }
                    richFeatures2 = richFeatures;
                    it3 = it2;
                    map2 = map;
                    str2 = str;
                } else {
                    map = map2;
                    it2 = it3;
                    str = str2;
                    richFeatures = null;
                }
                linkedHashMap.put(next.getKey(), next.getValue());
                richFeatures2 = richFeatures;
                it3 = it2;
                map2 = map;
                str2 = str;
            }
            HashMap map3 = map2;
            String str12 = str2;
            RichFeatures richFeatures3 = richFeatures2;
            Trigger trigger = Trigger.PUSH;
            String str13 = data.get(NotificationMessage.NOTIF_KEY_PB_ID);
            String str14 = data.get(NotificationMessage.NOTIF_KEY_RICH_FEATURES);
            return new NotificationMessage(str4, str5, null, str9, soundComponent1, strComponent2, str6, str7, type, trigger, str12, str10, str11, linkedHashMap, null, map3, str14 != null ? RichFeatures.Companion.a(str14) : richFeatures3, str13, 0, 278532, null);
        }

        public final NotificationMessage a(@NotNull Message message, @NotNull Region region) {
            Pair pair;
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(region, "region");
            String str = message.url;
            if (str != null) {
                pair = TuplesKt.to(Type.CLOUD_PAGE, str);
            } else {
                String str2 = message.openDirect;
                pair = str2 != null ? TuplesKt.to(Type.OPEN_DIRECT, str2) : TuplesKt.to(Type.OTHER, null);
            }
            Type type = (Type) pair.component1();
            String str3 = (String) pair.component2();
            Pair<Sound, String> pairA = a(message.sound);
            Sound soundComponent1 = pairA.component1();
            String strComponent2 = pairA.component2();
            Trigger trigger = message.messageType == 5 ? Trigger.BEACON : Trigger.GEOFENCE;
            String str4 = message.id;
            String str5 = message.title;
            String str6 = message.alert;
            Map map = message.customKeys != null ? new HashMap(message.customKeys) : MapsKt__MapsKt.emptyMap();
            String str7 = message.custom;
            Message.Media media = message.media;
            return new NotificationMessage(str4, null, region, str6, soundComponent1, strComponent2, str5, null, type, trigger, str3, media != null ? media.url : null, media != null ? media.altText : null, map, str7, null, null, null, 0, 491650, null);
        }

        public final NotificationMessage a(@NotNull JSONObject json) {
            Map<String, String> mapEmptyMap;
            String strOptString;
            String strOptString2;
            Intrinsics.checkNotNullParameter(json, "json");
            String strOptString3 = json.optString("sound");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            String strB = o.b(strOptString3);
            if (strB == null) {
                strB = "";
            }
            Pair<Sound, String> pairA = a(strB);
            Sound soundComponent1 = pairA.component1();
            String strComponent2 = pairA.component2();
            String strOptString4 = json.optString("id");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            String strB2 = o.b(strOptString4);
            if (strB2 != null) {
                String strOptString5 = json.optString("requestId");
                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                String strB3 = o.b(strOptString5);
                String strOptString6 = json.optString("alert");
                Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                String strB4 = o.b(strOptString6);
                if (strB4 != null) {
                    String strOptString7 = json.optString("title");
                    Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                    String strB5 = o.b(strOptString7);
                    String strOptString8 = json.optString("subtitle");
                    Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                    String strB6 = o.b(strOptString8);
                    Type type = Type.OTHER;
                    Trigger trigger = Trigger.DOWNLOAD;
                    String strOptString9 = json.optString("url");
                    Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                    String strB7 = o.b(strOptString9);
                    JSONObject jSONObjectOptJSONObject = json.optJSONObject("media");
                    String strB8 = (jSONObjectOptJSONObject == null || (strOptString2 = jSONObjectOptJSONObject.optString(com.salesforce.marketingcloud.messages.inbox.b.k)) == null) ? null : o.b(strOptString2);
                    JSONObject jSONObjectOptJSONObject2 = json.optJSONObject("media");
                    String strB9 = (jSONObjectOptJSONObject2 == null || (strOptString = jSONObjectOptJSONObject2.optString(com.salesforce.marketingcloud.messages.inbox.b.l)) == null) ? null : o.b(strOptString);
                    JSONArray jSONArrayOptJSONArray = json.optJSONArray("keys");
                    if (jSONArrayOptJSONArray == null || (mapEmptyMap = o.b(jSONArrayOptJSONArray)) == null) {
                        mapEmptyMap = MapsKt__MapsKt.emptyMap();
                    }
                    Map<String, String> map = mapEmptyMap;
                    String strOptString10 = json.optString("custom");
                    Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
                    String strB10 = o.b(strOptString10);
                    String strOptString11 = json.optString(com.salesforce.marketingcloud.messages.inbox.b.m);
                    Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
                    String strB11 = o.b(strOptString11);
                    return new NotificationMessage(strB2, strB3, null, strB4, soundComponent1, strComponent2, strB5, strB6, type, trigger, strB7, strB8, strB9, map, strB10, null, strB11 != null ? RichFeatures.Companion.a(strB11) : null, null, 0, 425988, null);
                }
                throw new IllegalArgumentException("alert is required and cannot be null or empty");
            }
            throw new IllegalArgumentException("id is required and cannot be null or empty");
        }

        public final Pair<Sound, String> a(@Nullable String str) {
            if (str == null || StringsKt__StringsJVMKt.equals(str, "none", true)) {
                return TuplesKt.to(Sound.NONE, null);
            }
            return StringsKt__StringsJVMKt.equals(str, "default", true) ? TuplesKt.to(Sound.DEFAULT, null) : TuplesKt.to(Sound.CUSTOM, str);
        }
    }

    public static final class b implements Parcelable.Creator<NotificationMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final NotificationMessage createFromParcel(@NotNull Parcel parcel) {
            String str;
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Region regionCreateFromParcel = parcel.readInt() == 0 ? null : Region.CREATOR.createFromParcel(parcel);
            String string3 = parcel.readString();
            Sound soundValueOf = Sound.valueOf(parcel.readString());
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            Type typeValueOf = Type.valueOf(parcel.readString());
            Trigger triggerValueOf = Trigger.valueOf(parcel.readString());
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            int i = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(i);
            int i2 = 0;
            while (i2 != i) {
                linkedHashMap2.put(parcel.readString(), parcel.readString());
                i2++;
                i = i;
                string8 = string8;
            }
            String str2 = string8;
            String string10 = parcel.readString();
            if (parcel.readInt() == 0) {
                str = string10;
                linkedHashMap = null;
            } else {
                int i3 = parcel.readInt();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(i3);
                int i4 = 0;
                while (i4 != i3) {
                    linkedHashMap3.put(parcel.readString(), parcel.readString());
                    i4++;
                    i3 = i3;
                    string10 = string10;
                }
                str = string10;
                linkedHashMap = linkedHashMap3;
            }
            return new NotificationMessage(string, string2, regionCreateFromParcel, string3, soundValueOf, string4, string5, string6, typeValueOf, triggerValueOf, string7, str2, string9, linkedHashMap2, str, linkedHashMap, parcel.readInt() == 0 ? null : RichFeatures.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final NotificationMessage[] newArray(int i) {
            return new NotificationMessage[i];
        }
    }

    public NotificationMessage(@NotNull String id, @Nullable String str, @Nullable Region region, @NotNull String alert, @NotNull Sound sound, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Type type, @NotNull Trigger trigger, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NotNull Map<String, String> customKeys, @Nullable String str8, @Nullable Map<String, String> map, @Nullable RichFeatures richFeatures, @Nullable String str9, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(alert, "alert");
        Intrinsics.checkNotNullParameter(sound, "sound");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(customKeys, "customKeys");
        this.id = id;
        this.requestId = str;
        this.region = region;
        this.alert = alert;
        this.sound = sound;
        this.soundName = str2;
        this.title = str3;
        this.subtitle = str4;
        this.type = type;
        this.trigger = trigger;
        this.url = str5;
        this.mediaUrl = str6;
        this.mediaAltText = str7;
        this.customKeys = customKeys;
        this.custom = str8;
        this.payload = map;
        this.richFeatures = richFeatures;
        this.propertyBag = str9;
        this.notificationId = i;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "alert", imports = {}))
    public final String alert() {
        return this.alert;
    }

    public final String component1() {
        return this.id;
    }

    public final Trigger component10() {
        return this.trigger;
    }

    public final String component11() {
        return this.url;
    }

    public final String component12() {
        return this.mediaUrl;
    }

    public final String component13() {
        return this.mediaAltText;
    }

    public final Map<String, String> component14() {
        return this.customKeys;
    }

    public final String component15() {
        return this.custom;
    }

    public final Map<String, String> component16() {
        return this.payload;
    }

    public final RichFeatures component17() {
        return this.richFeatures;
    }

    public final String component18$sdk_release() {
        return this.propertyBag;
    }

    public final int component19$sdk_release() {
        return this.notificationId;
    }

    public final String component2() {
        return this.requestId;
    }

    public final Region component3() {
        return this.region;
    }

    public final String component4() {
        return this.alert;
    }

    public final Sound component5() {
        return this.sound;
    }

    public final String component6() {
        return this.soundName;
    }

    public final String component7() {
        return this.title;
    }

    public final String component8() {
        return this.subtitle;
    }

    public final Type component9() {
        return this.type;
    }

    public final NotificationMessage copy(@NotNull String id, @Nullable String str, @Nullable Region region, @NotNull String alert, @NotNull Sound sound, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Type type, @NotNull Trigger trigger, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NotNull Map<String, String> customKeys, @Nullable String str8, @Nullable Map<String, String> map, @Nullable RichFeatures richFeatures, @Nullable String str9, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(alert, "alert");
        Intrinsics.checkNotNullParameter(sound, "sound");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(customKeys, "customKeys");
        return new NotificationMessage(id, str, region, alert, sound, str2, str3, str4, type, trigger, str5, str6, str7, customKeys, str8, map, richFeatures, str9, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "custom", imports = {}))
    public final String custom() {
        return this.custom;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "customKeys", imports = {}))
    public final Map<String, String> customKeys() {
        return this.customKeys;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationMessage)) {
            return false;
        }
        NotificationMessage notificationMessage = (NotificationMessage) obj;
        return Intrinsics.areEqual(this.id, notificationMessage.id) && Intrinsics.areEqual(this.requestId, notificationMessage.requestId) && Intrinsics.areEqual(this.region, notificationMessage.region) && Intrinsics.areEqual(this.alert, notificationMessage.alert) && this.sound == notificationMessage.sound && Intrinsics.areEqual(this.soundName, notificationMessage.soundName) && Intrinsics.areEqual(this.title, notificationMessage.title) && Intrinsics.areEqual(this.subtitle, notificationMessage.subtitle) && this.type == notificationMessage.type && this.trigger == notificationMessage.trigger && Intrinsics.areEqual(this.url, notificationMessage.url) && Intrinsics.areEqual(this.mediaUrl, notificationMessage.mediaUrl) && Intrinsics.areEqual(this.mediaAltText, notificationMessage.mediaAltText) && Intrinsics.areEqual(this.customKeys, notificationMessage.customKeys) && Intrinsics.areEqual(this.custom, notificationMessage.custom) && Intrinsics.areEqual(this.payload, notificationMessage.payload) && Intrinsics.areEqual(this.richFeatures, notificationMessage.richFeatures) && Intrinsics.areEqual(this.propertyBag, notificationMessage.propertyBag) && this.notificationId == notificationMessage.notificationId;
    }

    public final int getNotificationId$sdk_release() {
        return this.notificationId;
    }

    public final String getPropertyBag$sdk_release() {
        return this.propertyBag;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode();
        String str = this.requestId;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        Region region = this.region;
        int iHashCode3 = region == null ? 0 : region.hashCode();
        int iHashCode4 = this.alert.hashCode();
        int iHashCode5 = this.sound.hashCode();
        String str2 = this.soundName;
        int iHashCode6 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.title;
        int iHashCode7 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.subtitle;
        int iHashCode8 = str4 == null ? 0 : str4.hashCode();
        int iHashCode9 = this.type.hashCode();
        int iHashCode10 = this.trigger.hashCode();
        String str5 = this.url;
        int iHashCode11 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.mediaUrl;
        int iHashCode12 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.mediaAltText;
        int iHashCode13 = str7 == null ? 0 : str7.hashCode();
        int iHashCode14 = this.customKeys.hashCode();
        String str8 = this.custom;
        int iHashCode15 = str8 == null ? 0 : str8.hashCode();
        Map<String, String> map = this.payload;
        int iHashCode16 = map == null ? 0 : map.hashCode();
        RichFeatures richFeatures = this.richFeatures;
        int iHashCode17 = richFeatures == null ? 0 : richFeatures.hashCode();
        String str9 = this.propertyBag;
        return (((((((((((((((((((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode11) * 31) + iHashCode12) * 31) + iHashCode13) * 31) + iHashCode14) * 31) + iHashCode15) * 31) + iHashCode16) * 31) + iHashCode17) * 31) + (str9 == null ? 0 : str9.hashCode())) * 31) + Integer.hashCode(this.notificationId);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "id", imports = {}))
    public final String id() {
        return this.id;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mediaAltText", imports = {}))
    public final String mediaAltText() {
        return this.mediaAltText;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = i.a.e, imports = {}))
    public final String mediaUrl() {
        return this.mediaUrl;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "to be removed")
    public final int notificationId() {
        return this.notificationId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "payload", imports = {}))
    public final Map<String, String> payload() {
        return this.payload;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "to be removed")
    public final String propertyBag() {
        return this.propertyBag;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = Geo.JsonKeys.REGION, imports = {}))
    public final Region region() {
        return this.region;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "requestId", imports = {}))
    public final String requestId() {
        return this.requestId;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = com.salesforce.marketingcloud.messages.inbox.b.m, imports = {}))
    public final RichFeatures richFeatures() {
        return this.richFeatures;
    }

    public final void setNotificationId$sdk_release(int i) {
        this.notificationId = i;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sound", imports = {}))
    public final Sound sound() {
        return this.sound;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "soundName", imports = {}))
    public final String soundName() {
        return this.soundName;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "subtitle", imports = {}))
    public final String subtitle() {
        return this.subtitle;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "title", imports = {}))
    public final String title() {
        return this.title;
    }

    public final JSONObject toJson$sdk_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        String str = this.requestId;
        if (str != null) {
            jSONObject.put("requestId", str);
        }
        jSONObject.put("alert", this.alert);
        jSONObject.put("sound", this.sound.name());
        String str2 = this.soundName;
        if (str2 != null) {
            jSONObject.put("sound", str2);
        }
        String str3 = this.title;
        if (str3 != null) {
            jSONObject.put("title", str3);
        }
        String str4 = this.subtitle;
        if (str4 != null) {
            jSONObject.put("subtitle", str4);
        }
        jSONObject.put("type", this.type.name());
        jSONObject.put(com.salesforce.marketingcloud.messages.inbox.b.f71n, this.trigger.name());
        String str5 = this.url;
        if (str5 != null) {
            jSONObject.put("url", str5);
        }
        String str6 = this.mediaUrl;
        if (str6 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.salesforce.marketingcloud.messages.inbox.b.k, str6);
            String str7 = this.mediaAltText;
            if (str7 != null) {
                jSONObject2.put(com.salesforce.marketingcloud.messages.inbox.b.l, str7);
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put("media", jSONObject2);
        }
        if (!this.customKeys.isEmpty()) {
            jSONObject.put("keys", new JSONObject(this.customKeys));
        }
        String str8 = this.custom;
        if (str8 != null) {
            jSONObject.put("custom", str8);
        }
        RichFeatures richFeatures = this.richFeatures;
        if (richFeatures != null) {
            jSONObject.put(com.salesforce.marketingcloud.messages.inbox.b.m, richFeatures);
        }
        return jSONObject;
    }

    public String toString() {
        return "NotificationMessage(id=" + this.id + ", requestId=" + this.requestId + ", region=" + this.region + ", alert=" + this.alert + ", sound=" + this.sound + ", soundName=" + this.soundName + ", title=" + this.title + ", subtitle=" + this.subtitle + ", type=" + this.type + ", trigger=" + this.trigger + ", url=" + this.url + ", mediaUrl=" + this.mediaUrl + ", mediaAltText=" + this.mediaAltText + ", customKeys=" + this.customKeys + ", custom=" + this.custom + ", payload=" + this.payload + ", richFeatures=" + this.richFeatures + ", propertyBag=" + this.propertyBag + ", notificationId=" + this.notificationId + ")";
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = com.salesforce.marketingcloud.messages.inbox.b.f71n, imports = {}))
    public final Trigger trigger() {
        return this.trigger;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    public final Type type() {
        return this.type;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    public final String url() {
        return this.url;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.id);
        out.writeString(this.requestId);
        Region region = this.region;
        if (region == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            region.writeToParcel(out, i);
        }
        out.writeString(this.alert);
        out.writeString(this.sound.name());
        out.writeString(this.soundName);
        out.writeString(this.title);
        out.writeString(this.subtitle);
        out.writeString(this.type.name());
        out.writeString(this.trigger.name());
        out.writeString(this.url);
        out.writeString(this.mediaUrl);
        out.writeString(this.mediaAltText);
        Map<String, String> map = this.customKeys;
        out.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeString(entry.getValue());
        }
        out.writeString(this.custom);
        Map<String, String> map2 = this.payload;
        if (map2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(map2.size());
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                out.writeString(entry2.getKey());
                out.writeString(entry2.getValue());
            }
        }
        RichFeatures richFeatures = this.richFeatures;
        if (richFeatures == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            richFeatures.writeToParcel(out, i);
        }
        out.writeString(this.propertyBag);
        out.writeInt(this.notificationId);
    }

    public /* synthetic */ NotificationMessage(String str, String str2, Region region, String str3, Sound sound, String str4, String str5, String str6, Type type, Trigger trigger, String str7, String str8, String str9, Map map, String str10, Map map2, RichFeatures richFeatures, String str11, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : region, str3, sound, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6, type, trigger, (i2 & 1024) != 0 ? null : str7, (i2 & 2048) != 0 ? null : str8, (i2 & 4096) != 0 ? null : str9, (i2 & 8192) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i2 & 16384) != 0 ? null : str10, (32768 & i2) != 0 ? null : map2, (65536 & i2) != 0 ? null : richFeatures, (131072 & i2) != 0 ? null : str11, (i2 & 262144) != 0 ? -1 : i);
    }
}
