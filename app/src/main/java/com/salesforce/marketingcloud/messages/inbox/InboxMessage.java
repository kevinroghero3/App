package com.salesforce.marketingcloud.messages.inbox;

import android.os.Bundle;
import android.text.TextUtils;
import com.salesforce.marketingcloud.internal.o;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InboxMessage {
    public final String alert;
    public final String custom;
    public final Map<String, String> customKeys;
    private boolean deleted;
    private boolean dirty;
    public final Date endDateUtc;
    public final String id;
    public final String inboxMessage;
    public final String inboxSubtitle;
    public final Media media;
    private final String messageHash;
    public final Integer messageType;
    public NotificationMessage notificationMessage;
    private boolean read;
    private final String requestId;
    public final Date sendDateUtc;
    public final String sound;
    public final Date startDateUtc;
    public final String subject;
    public final String subtitle;
    public final String title;
    public final String url;
    private final int viewCount;

    public enum InboxMessageType {
        LEGACY(0),
        ADV(1),
        PCTI(2);

        private final int index;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        public static final a Companion = new a(null);

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final InboxMessageType a(int i) {
                InboxMessageType next;
                Iterator<InboxMessageType> it2 = InboxMessageType.getEntries().iterator();
                while (it2.hasNext()) {
                    next = it2.next();
                    if (next.getIndex() == i) {
                        return next;
                    }
                }
                next = null;
                return next;
            }

            private a() {
            }
        }

        InboxMessageType(int i) {
            this.index = i;
        }

        public static EnumEntries<InboxMessageType> getEntries() {
            return $ENTRIES;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    public static final class Media {
        private final String altText;
        private final String url;

        public Media(@Nullable String str, @Nullable String str2) {
            this.url = str;
            this.altText = str2;
        }

        public static /* synthetic */ Media copy$default(Media media, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = media.url;
            }
            if ((i & 2) != 0) {
                str2 = media.altText;
            }
            return media.copy(str, str2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "altText", imports = {}))
        public final String altText() {
            return this.altText;
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.altText;
        }

        public final Media copy(@Nullable String str, @Nullable String str2) {
            return new Media(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Media)) {
                return false;
            }
            Media media = (Media) obj;
            return Intrinsics.areEqual(this.url, media.url) && Intrinsics.areEqual(this.altText, media.altText);
        }

        public final String getAltText() {
            return this.altText;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = str == null ? 0 : str.hashCode();
            String str2 = this.altText;
            return (iHashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Media(url=" + this.url + ", altText=" + this.altText + ")";
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
        public final String url() {
            return this.url;
        }
    }

    public enum a {
        INBOX_NO_URL(0),
        ALERT_INBOX_NO_URL(1),
        INBOX_CLOUDPAGE(2),
        ALERT_INBOX_CLOUDPAGE(3),
        INBOX_NON_CLOUDPAGE(4),
        ALERT_INBOX_NON_CLOUDPAGE(5);

        private final int b;
        private static final /* synthetic */ EnumEntries k = EnumEntriesKt.enumEntries(a());
        public static final C0086a c = new C0086a(null);

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.InboxMessage$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes3.dex */
        public static final class C0086a {
            public /* synthetic */ C0086a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a(int i) {
                a next;
                Iterator<a> it2 = a.b().iterator();
                while (it2.hasNext()) {
                    next = it2.next();
                    if (next.c() == i) {
                        return next;
                    }
                }
                next = null;
                return next;
            }

            private C0086a() {
            }
        }

        a(int i) {
            this.b = i;
        }

        public static EnumEntries<a> b() {
            return k;
        }

        public final int c() {
            return this.b;
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.valueOf(this.b);
        }
    }

    public enum b {
        PUSH(1),
        ALERT_INBOX(3);

        private final int b;
        private static final /* synthetic */ EnumEntries g = EnumEntriesKt.enumEntries(a());
        public static final a c = new a(null);

        /* JADX INFO: loaded from: classes3.dex */
        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b a(int i) {
                b next;
                Iterator<b> it2 = b.b().iterator();
                while (it2.hasNext()) {
                    next = it2.next();
                    if (next.c() == i) {
                        return next;
                    }
                }
                next = null;
                return next;
            }

            private a() {
            }
        }

        b(int i) {
            this.b = i;
        }

        public static EnumEntries<b> b() {
            return g;
        }

        public final int c() {
            return this.b;
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.valueOf(this.b);
        }
    }

    public InboxMessage(@NotNull String id, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Media media, @Nullable Date date, @Nullable Date date2, @Nullable Date date3, @Nullable String str7, @Nullable String str8, @Nullable Map<String, String> map, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable NotificationMessage notificationMessage, int i, @Nullable Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.requestId = str;
        this.messageHash = str2;
        this.subject = str3;
        this.title = str4;
        this.alert = str5;
        this.sound = str6;
        this.media = media;
        this.startDateUtc = date;
        this.endDateUtc = date2;
        this.sendDateUtc = date3;
        this.url = str7;
        this.custom = str8;
        this.customKeys = map;
        this.subtitle = str9;
        this.inboxMessage = str10;
        this.inboxSubtitle = str11;
        this.notificationMessage = notificationMessage;
        this.viewCount = i;
        this.messageType = num;
        this.deleted = z;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "alert", imports = {}))
    public final String alert() {
        return this.alert;
    }

    public final String component1() {
        return this.id;
    }

    public final Date component10() {
        return this.endDateUtc;
    }

    public final Date component11() {
        return this.sendDateUtc;
    }

    public final String component12() {
        return this.url;
    }

    public final String component13() {
        return this.custom;
    }

    public final Map<String, String> component14() {
        return this.customKeys;
    }

    public final String component15() {
        return this.subtitle;
    }

    public final String component16() {
        return this.inboxMessage;
    }

    public final String component17() {
        return this.inboxSubtitle;
    }

    public final NotificationMessage component18() {
        return this.notificationMessage;
    }

    public final int component19$sdk_release() {
        return this.viewCount;
    }

    public final String component2$sdk_release() {
        return this.requestId;
    }

    public final Integer component20() {
        return this.messageType;
    }

    public final boolean component21() {
        return this.deleted;
    }

    public final String component3$sdk_release() {
        return this.messageHash;
    }

    public final String component4() {
        return this.subject;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.alert;
    }

    public final String component7() {
        return this.sound;
    }

    public final Media component8() {
        return this.media;
    }

    public final Date component9() {
        return this.startDateUtc;
    }

    public final InboxMessage copy(@NotNull String id, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Media media, @Nullable Date date, @Nullable Date date2, @Nullable Date date3, @Nullable String str7, @Nullable String str8, @Nullable Map<String, String> map, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable NotificationMessage notificationMessage, int i, @Nullable Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new InboxMessage(id, str, str2, str3, str4, str5, str6, media, date, date2, date3, str7, str8, map, str9, str10, str11, notificationMessage, i, num, z);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "custom", imports = {}))
    public final String custom() {
        return this.custom;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "customKeys", imports = {}))
    public final Map<String, String> customKeys() {
        return this.customKeys;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to getter", replaceWith = @ReplaceWith(expression = "getDeleted()", imports = {}))
    public final boolean deleted() {
        return this.deleted;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "endDateUtc", imports = {}))
    public final Date endDateUtc() {
        return this.endDateUtc;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InboxMessage)) {
            return false;
        }
        InboxMessage inboxMessage = (InboxMessage) obj;
        return Intrinsics.areEqual(this.id, inboxMessage.id) && Intrinsics.areEqual(this.requestId, inboxMessage.requestId) && Intrinsics.areEqual(this.messageHash, inboxMessage.messageHash) && Intrinsics.areEqual(this.subject, inboxMessage.subject) && Intrinsics.areEqual(this.title, inboxMessage.title) && Intrinsics.areEqual(this.alert, inboxMessage.alert) && Intrinsics.areEqual(this.sound, inboxMessage.sound) && Intrinsics.areEqual(this.media, inboxMessage.media) && Intrinsics.areEqual(this.startDateUtc, inboxMessage.startDateUtc) && Intrinsics.areEqual(this.endDateUtc, inboxMessage.endDateUtc) && Intrinsics.areEqual(this.sendDateUtc, inboxMessage.sendDateUtc) && Intrinsics.areEqual(this.url, inboxMessage.url) && Intrinsics.areEqual(this.custom, inboxMessage.custom) && Intrinsics.areEqual(this.customKeys, inboxMessage.customKeys) && Intrinsics.areEqual(this.subtitle, inboxMessage.subtitle) && Intrinsics.areEqual(this.inboxMessage, inboxMessage.inboxMessage) && Intrinsics.areEqual(this.inboxSubtitle, inboxMessage.inboxSubtitle) && Intrinsics.areEqual(this.notificationMessage, inboxMessage.notificationMessage) && this.viewCount == inboxMessage.viewCount && Intrinsics.areEqual(this.messageType, inboxMessage.messageType) && this.deleted == inboxMessage.deleted;
    }

    public final boolean getDeleted() {
        return this.deleted;
    }

    public final boolean getDirty$sdk_release() {
        return this.dirty;
    }

    public final String getMessageHash$sdk_release() {
        return this.messageHash;
    }

    public final boolean getRead() {
        return this.read;
    }

    public final String getRequestId$sdk_release() {
        return this.requestId;
    }

    public final int getViewCount$sdk_release() {
        return this.viewCount;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode();
        String str = this.requestId;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.messageHash;
        int iHashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.subject;
        int iHashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.title;
        int iHashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.alert;
        int iHashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.sound;
        int iHashCode7 = str6 == null ? 0 : str6.hashCode();
        Media media = this.media;
        int iHashCode8 = media == null ? 0 : media.hashCode();
        Date date = this.startDateUtc;
        int iHashCode9 = date == null ? 0 : date.hashCode();
        Date date2 = this.endDateUtc;
        int iHashCode10 = date2 == null ? 0 : date2.hashCode();
        Date date3 = this.sendDateUtc;
        int iHashCode11 = date3 == null ? 0 : date3.hashCode();
        String str7 = this.url;
        int iHashCode12 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.custom;
        int iHashCode13 = str8 == null ? 0 : str8.hashCode();
        Map<String, String> map = this.customKeys;
        int iHashCode14 = map == null ? 0 : map.hashCode();
        String str9 = this.subtitle;
        int iHashCode15 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.inboxMessage;
        int iHashCode16 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.inboxSubtitle;
        int iHashCode17 = str11 == null ? 0 : str11.hashCode();
        NotificationMessage notificationMessage = this.notificationMessage;
        int iHashCode18 = notificationMessage == null ? 0 : notificationMessage.hashCode();
        int iHashCode19 = Integer.hashCode(this.viewCount);
        Integer num = this.messageType;
        return (((((((((((((((((((((((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode11) * 31) + iHashCode12) * 31) + iHashCode13) * 31) + iHashCode14) * 31) + iHashCode15) * 31) + iHashCode16) * 31) + iHashCode17) * 31) + iHashCode18) * 31) + iHashCode19) * 31) + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.deleted);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "id", imports = {}))
    public final String id() {
        return this.id;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "media", imports = {}))
    public final Media media() {
        return this.media;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to getter", replaceWith = @ReplaceWith(expression = "getRead()", imports = {}))
    public final boolean read() {
        return this.read;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sendDateUtc", imports = {}))
    public final Date sendDateUtc() {
        return this.sendDateUtc;
    }

    public final void setDeleted(boolean z) {
        this.deleted = z;
    }

    public final void setDirty$sdk_release(boolean z) {
        this.dirty = z;
    }

    public final /* synthetic */ void setRead(boolean z) {
        this.read = z;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sound", imports = {}))
    public final String sound() {
        return this.sound;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "startDateUtc", imports = {}))
    public final Date startDateUtc() {
        return this.startDateUtc;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "subject", imports = {}))
    public final String subject() {
        return this.subject;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "title", imports = {}))
    public final String title() {
        return this.title;
    }

    public final JSONObject toJson$sdk_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        jSONObject.put("calculatedType", this.messageType);
        jSONObject.put("viewCount", this.viewCount);
        jSONObject.put("isDeleted", this.deleted);
        jSONObject.put("messageType", this.messageType);
        String str = this.url;
        if (str != null) {
            jSONObject.put("url", str);
        }
        String str2 = this.messageHash;
        if (str2 != null) {
            jSONObject.put("hash", str2);
        }
        String str3 = this.requestId;
        if (str3 != null) {
            jSONObject.put("requestId", str3);
        }
        String str4 = this.subject;
        if (str4 != null) {
            jSONObject.put("subject", str4);
        }
        String str5 = this.title;
        if (str5 != null) {
            jSONObject.put("title", str5);
        }
        String str6 = this.alert;
        if (str6 != null) {
            jSONObject.put("alert", str6);
        }
        String str7 = this.sound;
        if (str7 != null) {
            jSONObject.put("sound", str7);
        }
        Media media = this.media;
        if (media != null) {
            jSONObject.put("media", com.salesforce.marketingcloud.messages.inbox.b.a(media));
        }
        Date date = this.startDateUtc;
        if (date != null) {
            jSONObject.put("startDateUtc", o.a(date));
        }
        Date date2 = this.endDateUtc;
        if (date2 != null) {
            jSONObject.put("endDateUtc", o.a(date2));
        }
        Date date3 = this.sendDateUtc;
        if (date3 != null) {
            jSONObject.put("sendDateUtc", o.a(date3));
        }
        String str8 = this.custom;
        if (str8 != null) {
            jSONObject.put("custom", str8);
        }
        Map<String, String> map = this.customKeys;
        if (map != null) {
            jSONObject.put("keys", o.a(map));
        }
        String str9 = this.subtitle;
        if (str9 != null) {
            jSONObject.put("subtitle", str9);
        }
        String str10 = this.inboxSubtitle;
        if (str10 != null) {
            jSONObject.put(NotificationMessage.NOTIF_KEY_INBOX_SUB_TITLE, str10);
        }
        String str11 = this.inboxMessage;
        if (str11 != null) {
            jSONObject.put(NotificationMessage.NOTIF_KEY_INBOX_MESSAGE, str11);
        }
        NotificationMessage notificationMessage = this.notificationMessage;
        if (notificationMessage != null) {
            jSONObject.put("notificationMessage", notificationMessage.toJson$sdk_release());
        }
        return jSONObject;
    }

    public final String toJsonString() throws JSONException {
        JSONObject json$sdk_release = toJson$sdk_release();
        Integer num = this.messageType;
        if (num != null) {
            InboxMessageType inboxMessageTypeA = InboxMessageType.Companion.a(num.intValue());
            json$sdk_release.put("messageType", inboxMessageTypeA != null ? inboxMessageTypeA.name() : null);
        }
        String string = json$sdk_release.toString(2);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public String toString() {
        return "InboxMessage(id=" + this.id + ", requestId=" + this.requestId + ", messageHash=" + this.messageHash + ", subject=" + this.subject + ", title=" + this.title + ", alert=" + this.alert + ", sound=" + this.sound + ", media=" + this.media + ", startDateUtc=" + this.startDateUtc + ", endDateUtc=" + this.endDateUtc + ", sendDateUtc=" + this.sendDateUtc + ", url=" + this.url + ", custom=" + this.custom + ", customKeys=" + this.customKeys + ", subtitle=" + this.subtitle + ", inboxMessage=" + this.inboxMessage + ", inboxSubtitle=" + this.inboxSubtitle + ", notificationMessage=" + this.notificationMessage + ", viewCount=" + this.viewCount + ", messageType=" + this.messageType + ", deleted=" + this.deleted + ")";
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    public final String url() {
        return this.url;
    }

    public /* synthetic */ InboxMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, Media media, Date date, Date date2, Date date3, String str8, String str9, Map map, String str10, String str11, String str12, NotificationMessage notificationMessage, int i, Integer num, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? null : media, (i2 & 256) != 0 ? null : date, (i2 & 512) != 0 ? null : date2, (i2 & 1024) != 0 ? null : date3, str8, (i2 & 4096) != 0 ? null : str9, (i2 & 8192) != 0 ? null : map, (i2 & 16384) != 0 ? null : str10, (32768 & i2) != 0 ? null : str11, (65536 & i2) != 0 ? null : str12, (131072 & i2) != 0 ? null : notificationMessage, (262144 & i2) != 0 ? 0 : i, num, (i2 & 1048576) != 0 ? false : z);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x016d  */
    public InboxMessage(@NotNull Bundle bundle) {
        Integer num;
        String strB;
        Date dateA;
        Integer numValueOf;
        int index;
        Iterator it2;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString(NotificationMessage.NOTIF_KEY_ID);
        if (string != null) {
            String string2 = bundle.getString(NotificationMessage.NOTIF_KEY_REQUEST_ID);
            String string3 = bundle.getString(NotificationMessage.NOTIF_KEY_MESSAGE_HASH);
            String string4 = bundle.getString("title");
            String string5 = bundle.getString("alert");
            String string6 = bundle.getString("sound");
            String string7 = bundle.getString(NotificationMessage.NOTIF_KEY_MEDIA_URL);
            Media media = !TextUtils.isEmpty(string7) ? new Media(string7, bundle.getString(NotificationMessage.NOTIF_KEY_MEDIA_ALT)) : null;
            String string8 = bundle.getString(NotificationMessage.NOTIF_KEY_CLOUD_PAGE_URL);
            String string9 = string8 == null ? bundle.getString(NotificationMessage.NOTIF_KEY_OPEN_DIRECT_URL) : string8;
            Set<String> setKeySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
            ArrayList arrayList = new ArrayList();
            Iterator it3 = setKeySet.iterator();
            while (it3.hasNext()) {
                Object next = it3.next();
                String str = (String) next;
                if (ArraysKt___ArraysKt.contains(NotificationMessage.Companion.a(), str)) {
                    Intrinsics.checkNotNull(str);
                    it2 = it3;
                    if (StringsKt__StringsJVMKt.startsWith$default(str, ".google", false, 2, null)) {
                    }
                    it3 = it2;
                } else {
                    it2 = it3;
                }
                arrayList.add(next);
                it3 = it2;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj : arrayList) {
                linkedHashMap.put(obj, String.valueOf(bundle.getString((String) obj)));
            }
            String string10 = bundle.getString("subtitle");
            String string11 = bundle.getString(NotificationMessage.NOTIF_KEY_INBOX_MESSAGE);
            String string12 = bundle.getString(NotificationMessage.NOTIF_KEY_INBOX_SUB_TITLE);
            if (Intrinsics.areEqual("8", bundle.getString(NotificationMessage.NOTIF_KEY_MESSAGE_TYPE))) {
                String string13 = bundle.getString(NotificationMessage.NOTIF_KEY_CONTENT_TYPE);
                if (Intrinsics.areEqual(string13, a.INBOX_NO_URL.toString()) || Intrinsics.areEqual(string13, a.ALERT_INBOX_NO_URL.toString()) || Intrinsics.areEqual(string13, a.INBOX_NON_CLOUDPAGE.toString()) || Intrinsics.areEqual(string13, a.ALERT_INBOX_NON_CLOUDPAGE.toString())) {
                    numValueOf = Integer.valueOf(InboxMessageType.ADV.getIndex());
                } else if (Intrinsics.areEqual(string13, a.INBOX_CLOUDPAGE.toString()) || Intrinsics.areEqual(string13, a.ALERT_INBOX_CLOUDPAGE.toString()) || string13 == null) {
                    if (!bundle.containsKey(NotificationMessage.NOTIF_KEY_INBOX_SUB_TITLE) && !bundle.containsKey(NotificationMessage.NOTIF_KEY_INBOX_MESSAGE)) {
                        index = InboxMessageType.LEGACY.getIndex();
                    } else {
                        index = InboxMessageType.ADV.getIndex();
                    }
                    numValueOf = Integer.valueOf(index);
                } else {
                    num = null;
                }
                num = numValueOf;
            } else {
                num = null;
            }
            if (num != null) {
                String string14 = bundle.getString(NotificationMessage.NOTIF_KEY_END_DATE);
                if (string14 != null && (strB = o.b(string14)) != null && (dateA = o.a(strB)) != null) {
                    Intrinsics.checkNotNull(string);
                    this(string, string2, string3, null, string4, string5, string6, media, null, dateA, null, string9, null, linkedHashMap, string10, string11, string12, null, 0, num, false, 1316104, null);
                    return;
                }
                throw new IllegalArgumentException("Missing or empty _endDt");
            }
            throw new IllegalArgumentException("Unknown Message- or Content Type.");
        }
        throw new IllegalStateException("Required value was null.");
    }

    public /* synthetic */ InboxMessage(JSONObject jSONObject, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) throws JSONException {
        this(jSONObject, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0245  */
    /* JADX WARN: Code duplicated, block: B:54:0x012e  */
    /* JADX WARN: Illegal instructions before constructor call */
    public InboxMessage(@NotNull JSONObject json, boolean z) throws JSONException {
        int index;
        String strB;
        String strB2;
        String strB3;
        String strB4;
        String strB5;
        String strB6;
        String strB7;
        String strB8;
        String strB9;
        int i;
        NotificationMessage notificationMessageA;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        int i2;
        Integer numValueOf;
        InboxMessageType inboxMessageType;
        Date dateA;
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json.getString("id");
        String strOptString = json.optString("requestId");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strB10 = o.b(strOptString);
        String strOptString2 = json.optString("hash");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strB11 = o.b(strOptString2);
        boolean zOptBoolean = json.optBoolean("isDeleted");
        String strOptString3 = json.optString("startDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strB12 = o.b(strOptString3);
        Date date = (strB12 == null || (dateA = o.a(strB12)) == null) ? new Date() : dateA;
        String strOptString4 = json.optString("endDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strB13 = o.b(strOptString4);
        Date dateA2 = strB13 != null ? o.a(strB13) : null;
        String strOptString5 = json.optString("sendDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        String strB14 = o.b(strOptString5);
        Date dateA3 = strB14 != null ? o.a(strB14) : null;
        int iOptInt = json.optInt("viewCount", 0);
        try {
            if (json.optInt("calculatedType", -1) != -1) {
                numValueOf = Integer.valueOf(json.getInt("calculatedType"));
            } else if (Integer.parseInt("8") == json.getInt("messageType")) {
                int i3 = json.getInt("contentType");
                if (i3 == a.INBOX_NO_URL.c() || i3 == a.ALERT_INBOX_NO_URL.c() || i3 == a.INBOX_NON_CLOUDPAGE.c() || i3 == a.ALERT_INBOX_NON_CLOUDPAGE.c()) {
                    numValueOf = Integer.valueOf(InboxMessageType.ADV.getIndex());
                } else if (i3 == a.INBOX_CLOUDPAGE.c() || i3 == a.ALERT_INBOX_CLOUDPAGE.c()) {
                    if (!json.has(NotificationMessage.NOTIF_KEY_INBOX_SUB_TITLE) && !json.has(NotificationMessage.NOTIF_KEY_INBOX_MESSAGE)) {
                        inboxMessageType = InboxMessageType.LEGACY;
                    } else {
                        inboxMessageType = InboxMessageType.ADV;
                    }
                    numValueOf = Integer.valueOf(inboxMessageType.getIndex());
                } else {
                    numValueOf = null;
                }
            } else if (1 == json.getInt("messageType") && ((i2 = json.getInt("contentType")) == b.PUSH.c() || i2 == b.ALERT_INBOX.c())) {
                numValueOf = Integer.valueOf(InboxMessageType.PCTI.getIndex());
            } else {
                numValueOf = null;
            }
            if (numValueOf != null) {
                index = numValueOf.intValue();
                if (z) {
                    strB = null;
                } else {
                    String strOptString6 = json.optString("subject");
                    Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                    strB = o.b(strOptString6);
                }
                if (z) {
                    strB2 = null;
                } else {
                    String strOptString7 = json.optString("title");
                    Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                    strB2 = o.b(strOptString7);
                }
                if (z) {
                    strB3 = null;
                } else {
                    String strOptString8 = json.optString("alert");
                    Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                    strB3 = o.b(strOptString8);
                }
                if (z) {
                    strB4 = null;
                } else {
                    String strOptString9 = json.optString("sound");
                    Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                    strB4 = o.b(strOptString9);
                }
                Media mediaA = (z || (jSONObjectOptJSONObject = json.optJSONObject("media")) == null) ? null : com.salesforce.marketingcloud.messages.inbox.b.a(jSONObjectOptJSONObject);
                if (z) {
                    strB5 = null;
                } else {
                    String strOptString10 = json.optString("url");
                    Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
                    strB5 = o.b(strOptString10);
                }
                if (z) {
                    strB6 = null;
                } else {
                    String strOptString11 = json.optString("custom");
                    Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
                    strB6 = o.b(strOptString11);
                }
                Map<String, String> mapB = (z || (jSONArrayOptJSONArray = json.optJSONArray("keys")) == null) ? null : o.b(jSONArrayOptJSONArray);
                if (z) {
                    strB7 = null;
                } else {
                    String strOptString12 = json.optString("subtitle");
                    Intrinsics.checkNotNullExpressionValue(strOptString12, "optString(...)");
                    strB7 = o.b(strOptString12);
                }
                if (z) {
                    strB8 = null;
                } else {
                    String strOptString13 = json.optString(NotificationMessage.NOTIF_KEY_INBOX_MESSAGE);
                    Intrinsics.checkNotNullExpressionValue(strOptString13, "optString(...)");
                    strB8 = o.b(strOptString13);
                }
                if (z) {
                    strB9 = null;
                } else {
                    String strOptString14 = json.optString(NotificationMessage.NOTIF_KEY_INBOX_SUB_TITLE);
                    Intrinsics.checkNotNullExpressionValue(strOptString14, "optString(...)");
                    strB9 = o.b(strOptString14);
                }
                if (z) {
                    notificationMessageA = null;
                } else {
                    try {
                        if (InboxMessageType.PCTI.getIndex() == json.optInt("calculatedType")) {
                            notificationMessageA = NotificationMessage.Companion.a(json);
                        } else if (1 == json.getInt("messageType") && ((i = json.getInt("contentType")) == b.PUSH.c() || i == b.ALERT_INBOX.c())) {
                            notificationMessageA = NotificationMessage.Companion.a(json);
                        } else {
                            notificationMessageA = null;
                        }
                    } catch (Exception unused) {
                    }
                }
                Intrinsics.checkNotNull(string);
                this(string, strB10, strB11, strB, strB2, strB3, strB4, mediaA, date, dateA2, dateA3, strB5, strB6, mapB, strB7, strB8, strB9, notificationMessageA, iOptInt, Integer.valueOf(index), zOptBoolean);
                return;
            }
            throw new IllegalArgumentException("Unknown Message/Content Type combination.");
        } catch (JSONException unused2) {
            index = InboxMessageType.LEGACY.getIndex();
        }
    }
}
