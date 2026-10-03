package com.salesforce.marketingcloud.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.extensions.PushExtensionsKt;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.o;
import com.salesforce.marketingcloud.storage.db.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Message implements Parcelable {
    public static final int CONTENT_TYPE_ALERT = 1;
    public static final int MESSAGE_TYPE_FENCE_ENTRY = 3;
    public static final int MESSAGE_TYPE_FENCE_EXIT = 4;
    public static final int MESSAGE_TYPE_NONE = 0;
    public static final int MESSAGE_TYPE_PROXIMITY = 5;
    public static final int PERIOD_TYPE_UNIT_DAY = 4;
    public static final int PERIOD_TYPE_UNIT_HOUR = 5;
    public static final int PERIOD_TYPE_UNIT_MONTH = 2;
    public static final int PERIOD_TYPE_UNIT_NONE = 0;
    public static final int PERIOD_TYPE_UNIT_WEEK = 3;
    public static final int PERIOD_TYPE_UNIT_YEAR = 1;
    public static final int PROXIMITY_UNKNOWN = 0;
    public final String alert;
    public final int contentType;
    public final String custom;
    public final Map<String, String> customKeys;
    public final Date endDateUtc;
    public final String id;
    public final boolean isRollingPeriod;
    private Date lastShownDate;
    public final Media media;
    public final int messageLimit;
    public final int messageType;
    public final int messagesPerPeriod;
    private Date nextAllowedShow;
    private int notificationId;
    public final int numberOfPeriods;
    public final String openDirect;
    private int periodShowCount;
    public final int periodType;
    public final int proximity;
    private int showCount;
    public final String sound;
    public final Date startDateUtc;
    public final String title;
    public final String url;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Message> CREATOR = new a();
    private static final String TAG = g.a("Message");

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG$sdk_release() {
            return Message.TAG;
        }

        private Companion() {
        }
    }

    public static final class Media implements Parcelable {
        public final String altText;
        public final String url;
        public static final a Companion = new a(null);
        public static final Parcelable.Creator<Media> CREATOR = new b();

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Media a(@Nullable JSONObject jSONObject) {
                String stringOrNull = jSONObject != null ? PushExtensionsKt.getStringOrNull(jSONObject, com.salesforce.marketingcloud.messages.inbox.b.k) : null;
                String stringOrNull2 = jSONObject != null ? PushExtensionsKt.getStringOrNull(jSONObject, com.salesforce.marketingcloud.messages.inbox.b.l) : null;
                if (stringOrNull == null && stringOrNull2 == null) {
                    return null;
                }
                if (stringOrNull == null) {
                    stringOrNull = "";
                }
                return new Media(stringOrNull, stringOrNull2);
            }

            private a() {
            }
        }

        public static final class b implements Parcelable.Creator<Media> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Media createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Media(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Media[] newArray(int i) {
                return new Media[i];
            }
        }

        public Media(@Nullable String str, @Nullable String str2) {
            this.url = str;
            this.altText = str2;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "altText", imports = {}))
        public final String altText() {
            return this.altText;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Media(url=" + this.url + ", altText=" + this.altText + ")";
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
        public final String url() {
            return this.url;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.url);
            out.writeString(this.altText);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface MessageType {
    }

    public static final class a implements Parcelable.Creator<Message> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Message createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            Media mediaCreateFromParcel = parcel.readInt() == 0 ? null : Media.CREATOR.createFromParcel(parcel);
            Date date = (Date) parcel.readSerializable();
            Date date2 = (Date) parcel.readSerializable();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            String string5 = parcel.readString();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            int i5 = parcel.readInt();
            boolean z = parcel.readInt() != 0;
            int i6 = parcel.readInt();
            int i7 = parcel.readInt();
            String string6 = parcel.readString();
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i8 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(i8);
                int i9 = 0;
                while (i9 != i8) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                    i9++;
                    i8 = i8;
                    i5 = i5;
                }
            }
            return new Message(string, string2, string3, string4, mediaCreateFromParcel, date, date2, i, i2, string5, i3, i4, i5, z, i6, i7, string6, linkedHashMap, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Message[] newArray(int i) {
            return new Message[i];
        }
    }

    public Message(@NotNull String id, @Nullable String str, @NotNull String alert, @Nullable String str2, @Nullable Media media, @Nullable Date date, @Nullable Date date2, int i, int i2, @Nullable String str3, int i3, int i4, int i5, boolean z, int i6, int i7, @Nullable String str4, @Nullable Map<String, String> map, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(alert, "alert");
        this.id = id;
        this.title = str;
        this.alert = alert;
        this.sound = str2;
        this.media = media;
        this.startDateUtc = date;
        this.endDateUtc = date2;
        this.messageType = i;
        this.contentType = i2;
        this.url = str3;
        this.messagesPerPeriod = i3;
        this.numberOfPeriods = i4;
        this.periodType = i5;
        this.isRollingPeriod = z;
        this.messageLimit = i6;
        this.proximity = i7;
        this.openDirect = str4;
        this.customKeys = map;
        this.custom = str5;
        this.notificationId = -1;
    }

    public static /* synthetic */ void getLastShownDate$sdk_release$annotations() {
    }

    public static /* synthetic */ void getNextAllowedShow$sdk_release$annotations() {
    }

    public static /* synthetic */ void getNotificationId$sdk_release$annotations() {
    }

    public static /* synthetic */ void getPeriodShowCount$sdk_release$annotations() {
    }

    public static /* synthetic */ void getShowCount$sdk_release$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "alert", imports = {}))
    public final String alert() {
        return this.alert;
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.url;
    }

    public final int component11() {
        return this.messagesPerPeriod;
    }

    public final int component12() {
        return this.numberOfPeriods;
    }

    public final int component13() {
        return this.periodType;
    }

    public final boolean component14() {
        return this.isRollingPeriod;
    }

    public final int component15() {
        return this.messageLimit;
    }

    public final int component16() {
        return this.proximity;
    }

    public final String component17() {
        return this.openDirect;
    }

    public final Map<String, String> component18() {
        return this.customKeys;
    }

    public final String component19() {
        return this.custom;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.alert;
    }

    public final String component4() {
        return this.sound;
    }

    public final Media component5() {
        return this.media;
    }

    public final Date component6() {
        return this.startDateUtc;
    }

    public final Date component7() {
        return this.endDateUtc;
    }

    public final int component8() {
        return this.messageType;
    }

    public final int component9() {
        return this.contentType;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "contentType", imports = {}))
    public final int contentType() {
        return this.contentType;
    }

    public final Message copy(@NotNull String id, @Nullable String str, @NotNull String alert, @Nullable String str2, @Nullable Media media, @Nullable Date date, @Nullable Date date2, int i, int i2, @Nullable String str3, int i3, int i4, int i5, boolean z, int i6, int i7, @Nullable String str4, @Nullable Map<String, String> map, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(alert, "alert");
        return new Message(id, str, alert, str2, media, date, date2, i, i2, str3, i3, i4, i5, z, i6, i7, str4, map, str5);
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

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "endDateUtc", imports = {}))
    public final Date endDateUtc() {
        return this.endDateUtc;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return Intrinsics.areEqual(this.id, message.id) && Intrinsics.areEqual(this.title, message.title) && Intrinsics.areEqual(this.alert, message.alert) && Intrinsics.areEqual(this.sound, message.sound) && Intrinsics.areEqual(this.media, message.media) && Intrinsics.areEqual(this.startDateUtc, message.startDateUtc) && Intrinsics.areEqual(this.endDateUtc, message.endDateUtc) && this.messageType == message.messageType && this.contentType == message.contentType && Intrinsics.areEqual(this.url, message.url) && this.messagesPerPeriod == message.messagesPerPeriod && this.numberOfPeriods == message.numberOfPeriods && this.periodType == message.periodType && this.isRollingPeriod == message.isRollingPeriod && this.messageLimit == message.messageLimit && this.proximity == message.proximity && Intrinsics.areEqual(this.openDirect, message.openDirect) && Intrinsics.areEqual(this.customKeys, message.customKeys) && Intrinsics.areEqual(this.custom, message.custom);
    }

    public final Date getLastShownDate$sdk_release() {
        return this.lastShownDate;
    }

    public final Date getNextAllowedShow$sdk_release() {
        return this.nextAllowedShow;
    }

    public final int getNotificationId$sdk_release() {
        return this.notificationId;
    }

    public final int getPeriodShowCount$sdk_release() {
        return this.periodShowCount;
    }

    public final int getShowCount$sdk_release() {
        return this.showCount;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode();
        String str = this.title;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        int iHashCode3 = this.alert.hashCode();
        String str2 = this.sound;
        int iHashCode4 = str2 == null ? 0 : str2.hashCode();
        Media media = this.media;
        int iHashCode5 = media == null ? 0 : media.hashCode();
        Date date = this.startDateUtc;
        int iHashCode6 = date == null ? 0 : date.hashCode();
        Date date2 = this.endDateUtc;
        int iHashCode7 = date2 == null ? 0 : date2.hashCode();
        int iHashCode8 = Integer.hashCode(this.messageType);
        int iHashCode9 = Integer.hashCode(this.contentType);
        String str3 = this.url;
        int iHashCode10 = str3 == null ? 0 : str3.hashCode();
        int iHashCode11 = Integer.hashCode(this.messagesPerPeriod);
        int iHashCode12 = Integer.hashCode(this.numberOfPeriods);
        int iHashCode13 = Integer.hashCode(this.periodType);
        int iHashCode14 = Boolean.hashCode(this.isRollingPeriod);
        int iHashCode15 = Integer.hashCode(this.messageLimit);
        int iHashCode16 = Integer.hashCode(this.proximity);
        String str4 = this.openDirect;
        int iHashCode17 = str4 == null ? 0 : str4.hashCode();
        Map<String, String> map = this.customKeys;
        int iHashCode18 = map == null ? 0 : map.hashCode();
        String str5 = this.custom;
        return (((((((((((((((((((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode11) * 31) + iHashCode12) * 31) + iHashCode13) * 31) + iHashCode14) * 31) + iHashCode15) * 31) + iHashCode16) * 31) + iHashCode17) * 31) + iHashCode18) * 31) + (str5 == null ? 0 : str5.hashCode());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "id", imports = {}))
    public final String id() {
        return this.id;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "isRollingPeriod", imports = {}))
    public final boolean isRollingPeriod() {
        return this.isRollingPeriod;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "media", imports = {}))
    public final Media media() {
        return this.media;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "messageLimit", imports = {}))
    public final int messageLimit() {
        return this.messageLimit;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "messageType", imports = {}))
    public final int messageType() {
        return this.messageType;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "messagesPerPeriod", imports = {}))
    public final int messagesPerPeriod() {
        return this.messagesPerPeriod;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "numberOfPeriods", imports = {}))
    public final int numberOfPeriods() {
        return this.numberOfPeriods;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "openDirect", imports = {}))
    public final String openDirect() {
        return this.openDirect;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "periodType", imports = {}))
    public final int periodType() {
        return this.periodType;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = i.a.x, imports = {}))
    public final int proximity() {
        return this.proximity;
    }

    public final void setLastShownDate$sdk_release(@Nullable Date date) {
        this.lastShownDate = date;
    }

    public final void setNextAllowedShow$sdk_release(@Nullable Date date) {
        this.nextAllowedShow = date;
    }

    public final void setNotificationId$sdk_release(int i) {
        this.notificationId = i;
    }

    public final void setPeriodShowCount$sdk_release(int i) {
        this.periodShowCount = i;
    }

    public final void setShowCount$sdk_release(int i) {
        this.showCount = i;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sound", imports = {}))
    public final String sound() {
        return this.sound;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "startDateUtc", imports = {}))
    public final Date startDateUtc() {
        return this.startDateUtc;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "title", imports = {}))
    public final String title() {
        return this.title;
    }

    public String toString() {
        return "Message(id=" + this.id + ", title=" + this.title + ", alert=" + this.alert + ", sound=" + this.sound + ", media=" + this.media + ", startDateUtc=" + this.startDateUtc + ", endDateUtc=" + this.endDateUtc + ", messageType=" + this.messageType + ", contentType=" + this.contentType + ", url=" + this.url + ", messagesPerPeriod=" + this.messagesPerPeriod + ", numberOfPeriods=" + this.numberOfPeriods + ", periodType=" + this.periodType + ", isRollingPeriod=" + this.isRollingPeriod + ", messageLimit=" + this.messageLimit + ", proximity=" + this.proximity + ", openDirect=" + this.openDirect + ", customKeys=" + this.customKeys + ", custom=" + this.custom + ")";
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    public final String url() {
        return this.url;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.id);
        out.writeString(this.title);
        out.writeString(this.alert);
        out.writeString(this.sound);
        Media media = this.media;
        if (media == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            media.writeToParcel(out, i);
        }
        out.writeSerializable(this.startDateUtc);
        out.writeSerializable(this.endDateUtc);
        out.writeInt(this.messageType);
        out.writeInt(this.contentType);
        out.writeString(this.url);
        out.writeInt(this.messagesPerPeriod);
        out.writeInt(this.numberOfPeriods);
        out.writeInt(this.periodType);
        out.writeInt(this.isRollingPeriod ? 1 : 0);
        out.writeInt(this.messageLimit);
        out.writeInt(this.proximity);
        out.writeString(this.openDirect);
        Map<String, String> map = this.customKeys;
        if (map == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                out.writeString(entry.getKey());
                out.writeString(entry.getValue());
            }
        }
        out.writeString(this.custom);
    }

    public /* synthetic */ Message(String str, String str2, String str3, String str4, Media media, Date date, Date date2, int i, int i2, String str5, int i3, int i4, int i5, boolean z, int i6, int i7, String str6, Map map, String str7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? null : str2, str3, (i8 & 8) != 0 ? null : str4, (i8 & 16) != 0 ? null : media, (i8 & 32) != 0 ? null : date, (i8 & 64) != 0 ? null : date2, i, i2, (i8 & 512) != 0 ? null : str5, (i8 & 1024) != 0 ? -1 : i3, (i8 & 2048) != 0 ? -1 : i4, (i8 & 4096) != 0 ? 0 : i5, (i8 & 8192) != 0 ? false : z, (i8 & 16384) != 0 ? -1 : i6, (32768 & i8) != 0 ? 0 : i7, (65536 & i8) != 0 ? null : str6, (131072 & i8) != 0 ? null : map, (i8 & 262144) != 0 ? null : str7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Message(@NotNull JSONObject json) throws JSONException {
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json.getString("id");
        String stringOrNull = PushExtensionsKt.getStringOrNull(json, "title");
        String string2 = json.getString("alert");
        String stringOrNull2 = PushExtensionsKt.getStringOrNull(json, "sound");
        Media mediaA = Media.Companion.a(json.optJSONObject("media"));
        String stringOrNull3 = PushExtensionsKt.getStringOrNull(json, "startDateUtc");
        Date dateA = stringOrNull3 != null ? o.a(stringOrNull3) : null;
        String stringOrNull4 = PushExtensionsKt.getStringOrNull(json, "endDateUtc");
        Date dateA2 = stringOrNull4 != null ? o.a(stringOrNull4) : null;
        int i = json.getInt("messageType");
        int i2 = json.getInt("contentType");
        String stringOrNull5 = PushExtensionsKt.getStringOrNull(json, "url");
        String stringOrNull6 = PushExtensionsKt.getStringOrNull(json, "openDirect");
        int iOptInt = json.optInt("messageObjectPerPeriod", -1);
        int iOptInt2 = json.optInt("numberOfPeriods", -1);
        int iOptInt3 = json.optInt("periodType", 0);
        boolean zOptBoolean = json.optBoolean("isRollingPeriod");
        int iOptInt4 = json.optInt("messageLimit", -1);
        int iOptInt5 = json.optInt(i.a.x, 0);
        JSONArray jSONArrayOptJSONArray = json.optJSONArray("keys");
        Map<String, String> mapB = jSONArrayOptJSONArray != null ? o.b(jSONArrayOptJSONArray) : null;
        String stringOrNull7 = PushExtensionsKt.getStringOrNull(json, "custom");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNull(string2);
        this(string, stringOrNull, string2, stringOrNull2, mediaA, dateA, dateA2, i, i2, stringOrNull5, iOptInt, iOptInt2, iOptInt3, zOptBoolean, iOptInt4, iOptInt5, stringOrNull6, mapB, stringOrNull7);
    }
}
