package com.salesforce.marketingcloud.messages.iam;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.internal.o;
import io.sentry.protocol.SentryThread;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InAppMessage implements Parcelable {
    public static final Parcelable.Creator<InAppMessage> CREATOR = new a();
    private final String activityInstanceId;
    public final String backgroundColor;
    public final TextField body;
    public final String borderColor;
    public final Size borderWidth;
    public final ButtonConfig buttonConfiguration;
    public final List<Button> buttons;
    public final CloseButton closeButton;
    public final Size cornerRadius;
    public final long displayDuration;
    public final int displayLimit;
    public final boolean displayLimitOverride;
    public final Date endDateUtc;
    public final String id;
    public final LayoutOrder layoutOrder;
    public final Media media;
    public final int messageDelaySec;
    public final Date modifiedDateUtc;
    public final int priority;
    public final Date startDateUtc;
    public final TextField title;
    public final Type type;
    public final String windowColor;

    public enum Alignment {
        beginning,
        center,
        end;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Alignment> getEntries() {
            return $ENTRIES;
        }
    }

    public enum ButtonConfig {
        stacked,
        twoUp;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ButtonConfig> getEntries() {
            return $ENTRIES;
        }
    }

    public static final class CloseButton implements Parcelable {
        public final Alignment alignment;
        public static final a Companion = new a(null);
        public static final Parcelable.Creator<CloseButton> CREATOR = new b();

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final CloseButton a() {
                return new CloseButton(null, 1, 0 == true ? 1 : 0);
            }

            private a() {
            }
        }

        public static final class b implements Parcelable.Creator<CloseButton> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CloseButton createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CloseButton(Alignment.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CloseButton[] newArray(int i) {
                return new CloseButton[i];
            }
        }

        public CloseButton() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CloseButton copy$default(CloseButton closeButton, Alignment alignment, int i, Object obj) {
            if ((i & 1) != 0) {
                alignment = closeButton.alignment;
            }
            return closeButton.copy(alignment);
        }

        @JvmStatic
        public static final CloseButton defaultCloseButton() {
            return Companion.a();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "alignment", imports = {}))
        public final Alignment alignment() {
            return this.alignment;
        }

        public final Alignment component1() {
            return this.alignment;
        }

        public final CloseButton copy(@NotNull Alignment alignment) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            return new CloseButton(alignment);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CloseButton) && this.alignment == ((CloseButton) obj).alignment;
        }

        public int hashCode() {
            return this.alignment.hashCode();
        }

        public final JSONObject toJson$sdk_release() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("alignment", this.alignment.name());
            return jSONObject;
        }

        public String toString() {
            return "CloseButton(alignment=" + this.alignment + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.alignment.name());
        }

        public CloseButton(@NotNull Alignment alignment) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            this.alignment = alignment;
        }

        public /* synthetic */ CloseButton(Alignment alignment, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Alignment.end : alignment);
        }
    }

    public enum LayoutOrder {
        ImageTitleBody,
        TitleImageBody;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<LayoutOrder> getEntries() {
            return $ENTRIES;
        }
    }

    public enum Size {
        s,
        m,
        l;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Size> getEntries() {
            return $ENTRIES;
        }
    }

    public enum Type {
        bannerTop,
        bannerBottom,
        modal,
        full,
        fullImageFill;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }
    }

    public static final class a implements Parcelable.Creator<InAppMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InAppMessage createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            Date date = (Date) parcel.readSerializable();
            Date date2 = (Date) parcel.readSerializable();
            Date date3 = (Date) parcel.readSerializable();
            int i2 = parcel.readInt();
            Type typeValueOf = Type.valueOf(parcel.readString());
            String string3 = parcel.readString();
            long j = parcel.readLong();
            String string4 = parcel.readString();
            Size sizeValueOf = Size.valueOf(parcel.readString());
            String string5 = parcel.readString();
            Size sizeValueOf2 = Size.valueOf(parcel.readString());
            LayoutOrder layoutOrderValueOf = LayoutOrder.valueOf(parcel.readString());
            Media mediaCreateFromParcel = parcel.readInt() == 0 ? null : Media.CREATOR.createFromParcel(parcel);
            TextField textFieldCreateFromParcel = parcel.readInt() == 0 ? null : TextField.CREATOR.createFromParcel(parcel);
            TextField textFieldCreateFromParcel2 = parcel.readInt() == 0 ? null : TextField.CREATOR.createFromParcel(parcel);
            CloseButton closeButtonCreateFromParcel = parcel.readInt() == 0 ? null : CloseButton.CREATOR.createFromParcel(parcel);
            ButtonConfig buttonConfigValueOf = ButtonConfig.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i3 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i3);
                int i4 = 0;
                while (i4 != i3) {
                    arrayList2.add(Button.CREATOR.createFromParcel(parcel));
                    i4++;
                    i3 = i3;
                }
                arrayList = arrayList2;
            }
            return new InAppMessage(string, string2, i, date, date2, date3, i2, typeValueOf, string3, j, string4, sizeValueOf, string5, sizeValueOf2, layoutOrderValueOf, mediaCreateFromParcel, textFieldCreateFromParcel, textFieldCreateFromParcel2, closeButtonCreateFromParcel, buttonConfigValueOf, arrayList, parcel.readInt(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InAppMessage[] newArray(int i) {
            return new InAppMessage[i];
        }
    }

    public InAppMessage(@NotNull String id, @NotNull String activityInstanceId, int i, @Nullable Date date, @Nullable Date date2, @Nullable Date date3, int i2, @NotNull Type type, @Nullable String str, long j, @Nullable String str2, @NotNull Size borderWidth, @Nullable String str3, @NotNull Size cornerRadius, @NotNull LayoutOrder layoutOrder, @Nullable Media media, @Nullable TextField textField, @Nullable TextField textField2, @Nullable CloseButton closeButton, @NotNull ButtonConfig buttonConfiguration, @Nullable List<Button> list, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(activityInstanceId, "activityInstanceId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(layoutOrder, "layoutOrder");
        Intrinsics.checkNotNullParameter(buttonConfiguration, "buttonConfiguration");
        this.id = id;
        this.activityInstanceId = activityInstanceId;
        this.priority = i;
        this.startDateUtc = date;
        this.endDateUtc = date2;
        this.modifiedDateUtc = date3;
        this.displayLimit = i2;
        this.type = type;
        this.windowColor = str;
        this.displayDuration = j;
        this.backgroundColor = str2;
        this.borderWidth = borderWidth;
        this.borderColor = str3;
        this.cornerRadius = cornerRadius;
        this.layoutOrder = layoutOrder;
        this.media = media;
        this.title = textField;
        this.body = textField2;
        this.closeButton = closeButton;
        this.buttonConfiguration = buttonConfiguration;
        this.buttons = list;
        this.messageDelaySec = i3;
        this.displayLimitOverride = z;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ViewProps.BACKGROUND_COLOR, imports = {}))
    public final String backgroundColor() {
        return this.backgroundColor;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    public final TextField body() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ViewProps.BORDER_COLOR, imports = {}))
    public final String borderColor() {
        return this.borderColor;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ViewProps.BORDER_WIDTH, imports = {}))
    public final Size borderWidth() {
        return this.borderWidth;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "buttonConfiguration", imports = {}))
    public final ButtonConfig buttonConfiguration() {
        return this.buttonConfiguration;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "buttons", imports = {}))
    public final List<Button> buttons() {
        return this.buttons;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "closeButton", imports = {}))
    public final CloseButton closeButton() {
        return this.closeButton;
    }

    public final String component1() {
        return this.id;
    }

    public final long component10() {
        return this.displayDuration;
    }

    public final String component11() {
        return this.backgroundColor;
    }

    public final Size component12() {
        return this.borderWidth;
    }

    public final String component13() {
        return this.borderColor;
    }

    public final Size component14() {
        return this.cornerRadius;
    }

    public final LayoutOrder component15() {
        return this.layoutOrder;
    }

    public final Media component16() {
        return this.media;
    }

    public final TextField component17() {
        return this.title;
    }

    public final TextField component18() {
        return this.body;
    }

    public final CloseButton component19() {
        return this.closeButton;
    }

    public final String component2$sdk_release() {
        return this.activityInstanceId;
    }

    public final ButtonConfig component20() {
        return this.buttonConfiguration;
    }

    public final List<Button> component21() {
        return this.buttons;
    }

    public final int component22() {
        return this.messageDelaySec;
    }

    public final boolean component23() {
        return this.displayLimitOverride;
    }

    public final int component3() {
        return this.priority;
    }

    public final Date component4() {
        return this.startDateUtc;
    }

    public final Date component5() {
        return this.endDateUtc;
    }

    public final Date component6() {
        return this.modifiedDateUtc;
    }

    public final int component7() {
        return this.displayLimit;
    }

    public final Type component8() {
        return this.type;
    }

    public final String component9() {
        return this.windowColor;
    }

    public final InAppMessage copy(@NotNull String id, @NotNull String activityInstanceId, int i, @Nullable Date date, @Nullable Date date2, @Nullable Date date3, int i2, @NotNull Type type, @Nullable String str, long j, @Nullable String str2, @NotNull Size borderWidth, @Nullable String str3, @NotNull Size cornerRadius, @NotNull LayoutOrder layoutOrder, @Nullable Media media, @Nullable TextField textField, @Nullable TextField textField2, @Nullable CloseButton closeButton, @NotNull ButtonConfig buttonConfiguration, @Nullable List<Button> list, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(activityInstanceId, "activityInstanceId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(layoutOrder, "layoutOrder");
        Intrinsics.checkNotNullParameter(buttonConfiguration, "buttonConfiguration");
        return new InAppMessage(id, activityInstanceId, i, date, date2, date3, i2, type, str, j, str2, borderWidth, str3, cornerRadius, layoutOrder, media, textField, textField2, closeButton, buttonConfiguration, list, i3, z);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cornerRadius", imports = {}))
    public final Size cornerRadius() {
        return this.cornerRadius;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "displayDuration", imports = {}))
    public final long displayDuration() {
        return this.displayDuration;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "displayLimit", imports = {}))
    public final int displayLimit() {
        return this.displayLimit;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "displayLimitOverride", imports = {}))
    public final boolean displayLimitOverride() {
        return this.displayLimitOverride;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "endDateUtc", imports = {}))
    public final Date endDateUtc() {
        return this.endDateUtc;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InAppMessage)) {
            return false;
        }
        InAppMessage inAppMessage = (InAppMessage) obj;
        return Intrinsics.areEqual(this.id, inAppMessage.id) && Intrinsics.areEqual(this.activityInstanceId, inAppMessage.activityInstanceId) && this.priority == inAppMessage.priority && Intrinsics.areEqual(this.startDateUtc, inAppMessage.startDateUtc) && Intrinsics.areEqual(this.endDateUtc, inAppMessage.endDateUtc) && Intrinsics.areEqual(this.modifiedDateUtc, inAppMessage.modifiedDateUtc) && this.displayLimit == inAppMessage.displayLimit && this.type == inAppMessage.type && Intrinsics.areEqual(this.windowColor, inAppMessage.windowColor) && this.displayDuration == inAppMessage.displayDuration && Intrinsics.areEqual(this.backgroundColor, inAppMessage.backgroundColor) && this.borderWidth == inAppMessage.borderWidth && Intrinsics.areEqual(this.borderColor, inAppMessage.borderColor) && this.cornerRadius == inAppMessage.cornerRadius && this.layoutOrder == inAppMessage.layoutOrder && Intrinsics.areEqual(this.media, inAppMessage.media) && Intrinsics.areEqual(this.title, inAppMessage.title) && Intrinsics.areEqual(this.body, inAppMessage.body) && Intrinsics.areEqual(this.closeButton, inAppMessage.closeButton) && this.buttonConfiguration == inAppMessage.buttonConfiguration && Intrinsics.areEqual(this.buttons, inAppMessage.buttons) && this.messageDelaySec == inAppMessage.messageDelaySec && this.displayLimitOverride == inAppMessage.displayLimitOverride;
    }

    public final String getActivityInstanceId$sdk_release() {
        return this.activityInstanceId;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode();
        int iHashCode2 = this.activityInstanceId.hashCode();
        int iHashCode3 = Integer.hashCode(this.priority);
        Date date = this.startDateUtc;
        int iHashCode4 = date == null ? 0 : date.hashCode();
        Date date2 = this.endDateUtc;
        int iHashCode5 = date2 == null ? 0 : date2.hashCode();
        Date date3 = this.modifiedDateUtc;
        int iHashCode6 = date3 == null ? 0 : date3.hashCode();
        int iHashCode7 = Integer.hashCode(this.displayLimit);
        int iHashCode8 = this.type.hashCode();
        String str = this.windowColor;
        int iHashCode9 = str == null ? 0 : str.hashCode();
        int iHashCode10 = Long.hashCode(this.displayDuration);
        String str2 = this.backgroundColor;
        int iHashCode11 = str2 == null ? 0 : str2.hashCode();
        int iHashCode12 = this.borderWidth.hashCode();
        String str3 = this.borderColor;
        int iHashCode13 = str3 == null ? 0 : str3.hashCode();
        int iHashCode14 = this.cornerRadius.hashCode();
        int iHashCode15 = this.layoutOrder.hashCode();
        Media media = this.media;
        int iHashCode16 = media == null ? 0 : media.hashCode();
        TextField textField = this.title;
        int iHashCode17 = textField == null ? 0 : textField.hashCode();
        TextField textField2 = this.body;
        int iHashCode18 = textField2 == null ? 0 : textField2.hashCode();
        CloseButton closeButton = this.closeButton;
        int iHashCode19 = closeButton == null ? 0 : closeButton.hashCode();
        int iHashCode20 = this.buttonConfiguration.hashCode();
        List<Button> list = this.buttons;
        return (((((((((((((((((((((((((((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode11) * 31) + iHashCode12) * 31) + iHashCode13) * 31) + iHashCode14) * 31) + iHashCode15) * 31) + iHashCode16) * 31) + iHashCode17) * 31) + iHashCode18) * 31) + iHashCode19) * 31) + iHashCode20) * 31) + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.messageDelaySec)) * 31) + Boolean.hashCode(this.displayLimitOverride);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "id", imports = {}))
    public final String id() {
        return this.id;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "layoutOrder", imports = {}))
    public final LayoutOrder layoutOrder() {
        return this.layoutOrder;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "media", imports = {}))
    public final Media media() {
        return this.media;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "messageDelaySec", imports = {}))
    public final int messageDelaySec() {
        return this.messageDelaySec;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "modifiedDateUtc", imports = {}))
    public final Date modifiedDateUtc() {
        return this.modifiedDateUtc;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = SentryThread.JsonKeys.PRIORITY, imports = {}))
    public final int priority() {
        return this.priority;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "startDateUtc", imports = {}))
    public final Date startDateUtc() {
        return this.startDateUtc;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "title", imports = {}))
    public final TextField title() {
        return this.title;
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        jSONObject.put("activityInstanceId", this.activityInstanceId);
        jSONObject.put(SentryThread.JsonKeys.PRIORITY, this.priority);
        Date date = this.startDateUtc;
        if (date != null) {
            jSONObject.put("startDateUtc", o.a(date));
        }
        Date date2 = this.endDateUtc;
        if (date2 != null) {
            jSONObject.put("endDateUtc", o.a(date2));
        }
        Date date3 = this.modifiedDateUtc;
        if (date3 != null) {
            jSONObject.put("modifiedDateUtc", o.a(date3));
        }
        jSONObject.put("displayLimit", this.displayLimit);
        jSONObject.put("type", this.type.name());
        String str = this.windowColor;
        if (str != null) {
            jSONObject.put("windowColor", str);
        }
        jSONObject.put("displayDuration", this.displayDuration);
        String str2 = this.backgroundColor;
        if (str2 != null) {
            jSONObject.put(ViewProps.BACKGROUND_COLOR, str2);
        }
        jSONObject.put(ViewProps.BORDER_WIDTH, this.borderWidth.name());
        String str3 = this.borderColor;
        if (str3 != null) {
            jSONObject.put(ViewProps.BORDER_COLOR, str3);
        }
        jSONObject.put("cornerRadius", this.cornerRadius.name());
        jSONObject.put("layoutOrder", this.layoutOrder.name());
        Media media = this.media;
        if (media != null) {
            jSONObject.put("media", media.toJson$sdk_release());
        }
        TextField textField = this.title;
        if (textField != null) {
            jSONObject.put("title", textField.toJson$sdk_release());
        }
        TextField textField2 = this.body;
        if (textField2 != null) {
            jSONObject.put("body", textField2.toJson$sdk_release());
        }
        CloseButton closeButton = this.closeButton;
        if (closeButton != null) {
            jSONObject.put("closeButton", closeButton.toJson$sdk_release());
        }
        jSONObject.put("buttonConfiguration", this.buttonConfiguration.name());
        if (this.buttons != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it2 = this.buttons.iterator();
            while (it2.hasNext()) {
                jSONArray.put(((Button) it2.next()).toJson$sdk_release());
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put("buttons", jSONArray);
        }
        jSONObject.put("messageDelaySec", this.messageDelaySec);
        jSONObject.put("displayLimitOverride", this.displayLimitOverride);
        return jSONObject;
    }

    public String toString() {
        return "InAppMessage(id=" + this.id + ", activityInstanceId=" + this.activityInstanceId + ", priority=" + this.priority + ", startDateUtc=" + this.startDateUtc + ", endDateUtc=" + this.endDateUtc + ", modifiedDateUtc=" + this.modifiedDateUtc + ", displayLimit=" + this.displayLimit + ", type=" + this.type + ", windowColor=" + this.windowColor + ", displayDuration=" + this.displayDuration + ", backgroundColor=" + this.backgroundColor + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", cornerRadius=" + this.cornerRadius + ", layoutOrder=" + this.layoutOrder + ", media=" + this.media + ", title=" + this.title + ", body=" + this.body + ", closeButton=" + this.closeButton + ", buttonConfiguration=" + this.buttonConfiguration + ", buttons=" + this.buttons + ", messageDelaySec=" + this.messageDelaySec + ", displayLimitOverride=" + this.displayLimitOverride + ")";
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    public final Type type() {
        return this.type;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "windowColor", imports = {}))
    public final String windowColor() {
        return this.windowColor;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.id);
        out.writeString(this.activityInstanceId);
        out.writeInt(this.priority);
        out.writeSerializable(this.startDateUtc);
        out.writeSerializable(this.endDateUtc);
        out.writeSerializable(this.modifiedDateUtc);
        out.writeInt(this.displayLimit);
        out.writeString(this.type.name());
        out.writeString(this.windowColor);
        out.writeLong(this.displayDuration);
        out.writeString(this.backgroundColor);
        out.writeString(this.borderWidth.name());
        out.writeString(this.borderColor);
        out.writeString(this.cornerRadius.name());
        out.writeString(this.layoutOrder.name());
        Media media = this.media;
        if (media == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            media.writeToParcel(out, i);
        }
        TextField textField = this.title;
        if (textField == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            textField.writeToParcel(out, i);
        }
        TextField textField2 = this.body;
        if (textField2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            textField2.writeToParcel(out, i);
        }
        CloseButton closeButton = this.closeButton;
        if (closeButton == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            closeButton.writeToParcel(out, i);
        }
        out.writeString(this.buttonConfiguration.name());
        List<Button> list = this.buttons;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<Button> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(out, i);
            }
        }
        out.writeInt(this.messageDelaySec);
        out.writeInt(this.displayLimitOverride ? 1 : 0);
    }

    public static final class TextField implements Parcelable {
        public static final Parcelable.Creator<TextField> CREATOR = new a();
        public final Alignment alignment;
        public final String fontColor;
        public final Size fontSize;
        public final String text;

        public static final class a implements Parcelable.Creator<TextField> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final TextField createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TextField(parcel.readString(), Size.valueOf(parcel.readString()), parcel.readString(), Alignment.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final TextField[] newArray(int i) {
                return new TextField[i];
            }
        }

        public TextField(@NotNull String text, @NotNull Size fontSize, @Nullable String str, @NotNull Alignment alignment) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            this.text = text;
            this.fontSize = fontSize;
            this.fontColor = str;
            this.alignment = alignment;
        }

        public static /* synthetic */ TextField copy$default(TextField textField, String str, Size size, String str2, Alignment alignment, int i, Object obj) {
            if ((i & 1) != 0) {
                str = textField.text;
            }
            if ((i & 2) != 0) {
                size = textField.fontSize;
            }
            if ((i & 4) != 0) {
                str2 = textField.fontColor;
            }
            if ((i & 8) != 0) {
                alignment = textField.alignment;
            }
            return textField.copy(str, size, str2, alignment);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "alignment", imports = {}))
        public final Alignment alignment() {
            return this.alignment;
        }

        public final String component1() {
            return this.text;
        }

        public final Size component2() {
            return this.fontSize;
        }

        public final String component3() {
            return this.fontColor;
        }

        public final Alignment component4() {
            return this.alignment;
        }

        public final TextField copy(@NotNull String text, @NotNull Size fontSize, @Nullable String str, @NotNull Alignment alignment) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            return new TextField(text, fontSize, str, alignment);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextField)) {
                return false;
            }
            TextField textField = (TextField) obj;
            return Intrinsics.areEqual(this.text, textField.text) && this.fontSize == textField.fontSize && Intrinsics.areEqual(this.fontColor, textField.fontColor) && this.alignment == textField.alignment;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fontColor", imports = {}))
        public final String fontColor() {
            return this.fontColor;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ViewProps.FONT_SIZE, imports = {}))
        public final Size fontSize() {
            return this.fontSize;
        }

        public int hashCode() {
            int iHashCode = this.text.hashCode();
            int iHashCode2 = this.fontSize.hashCode();
            String str = this.fontColor;
            return (((((iHashCode * 31) + iHashCode2) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.alignment.hashCode();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "text", imports = {}))
        public final String text() {
            return this.text;
        }

        public final JSONObject toJson$sdk_release() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("text", this.text);
            jSONObject.put(ViewProps.FONT_SIZE, this.fontSize.name());
            String str = this.fontColor;
            if (str != null) {
                jSONObject.put("fontColor", str);
            }
            jSONObject.put("alignment", this.alignment.name());
            return jSONObject;
        }

        public String toString() {
            return "TextField(text=" + this.text + ", fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", alignment=" + this.alignment + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.text);
            out.writeString(this.fontSize.name());
            out.writeString(this.fontColor);
            out.writeString(this.alignment.name());
        }

        public /* synthetic */ TextField(String str, Size size, String str2, Alignment alignment, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? Size.s : size, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? Alignment.center : alignment);
        }
    }

    public static final class Media implements Parcelable {
        public static final Parcelable.Creator<Media> CREATOR = new a();
        public final String altText;
        public final String borderColor;
        public final Size borderWidth;
        public final Size cornerRadius;
        public final ImageSize size;
        public final String url;

        public enum ImageSize {
            full,
            e2e,
            inset;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<ImageSize> getEntries() {
                return $ENTRIES;
            }
        }

        public static final class a implements Parcelable.Creator<Media> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Media createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Media(parcel.readString(), ImageSize.valueOf(parcel.readString()), parcel.readString(), Size.valueOf(parcel.readString()), parcel.readString(), Size.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Media[] newArray(int i) {
                return new Media[i];
            }
        }

        public Media(@NotNull String url, @NotNull ImageSize size, @Nullable String str, @NotNull Size borderWidth, @Nullable String str2, @NotNull Size cornerRadius) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
            Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
            this.url = url;
            this.size = size;
            this.altText = str;
            this.borderWidth = borderWidth;
            this.borderColor = str2;
            this.cornerRadius = cornerRadius;
        }

        public static /* synthetic */ Media copy$default(Media media, String str, ImageSize imageSize, String str2, Size size, String str3, Size size2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = media.url;
            }
            if ((i & 2) != 0) {
                imageSize = media.size;
            }
            ImageSize imageSize2 = imageSize;
            if ((i & 4) != 0) {
                str2 = media.altText;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                size = media.borderWidth;
            }
            Size size3 = size;
            if ((i & 16) != 0) {
                str3 = media.borderColor;
            }
            String str5 = str3;
            if ((i & 32) != 0) {
                size2 = media.cornerRadius;
            }
            return media.copy(str, imageSize2, str4, size3, str5, size2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "altText", imports = {}))
        public final String altText() {
            return this.altText;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ViewProps.BORDER_COLOR, imports = {}))
        public final String borderColor() {
            return this.borderColor;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ViewProps.BORDER_WIDTH, imports = {}))
        public final Size borderWidth() {
            return this.borderWidth;
        }

        public final String component1() {
            return this.url;
        }

        public final ImageSize component2() {
            return this.size;
        }

        public final String component3() {
            return this.altText;
        }

        public final Size component4() {
            return this.borderWidth;
        }

        public final String component5() {
            return this.borderColor;
        }

        public final Size component6() {
            return this.cornerRadius;
        }

        public final Media copy(@NotNull String url, @NotNull ImageSize size, @Nullable String str, @NotNull Size borderWidth, @Nullable String str2, @NotNull Size cornerRadius) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
            Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
            return new Media(url, size, str, borderWidth, str2, cornerRadius);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cornerRadius", imports = {}))
        public final Size cornerRadius() {
            return this.cornerRadius;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Media)) {
                return false;
            }
            Media media = (Media) obj;
            return Intrinsics.areEqual(this.url, media.url) && this.size == media.size && Intrinsics.areEqual(this.altText, media.altText) && this.borderWidth == media.borderWidth && Intrinsics.areEqual(this.borderColor, media.borderColor) && this.cornerRadius == media.cornerRadius;
        }

        public int hashCode() {
            int iHashCode = this.url.hashCode();
            int iHashCode2 = this.size.hashCode();
            String str = this.altText;
            int iHashCode3 = str == null ? 0 : str.hashCode();
            int iHashCode4 = this.borderWidth.hashCode();
            String str2 = this.borderColor;
            return (((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + (str2 != null ? str2.hashCode() : 0)) * 31) + this.cornerRadius.hashCode();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = RRWebVideoEvent.JsonKeys.SIZE, imports = {}))
        public final ImageSize size() {
            return this.size;
        }

        public final JSONObject toJson$sdk_release() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", this.url);
            jSONObject.put(RRWebVideoEvent.JsonKeys.SIZE, this.size.name());
            String str = this.altText;
            if (str != null) {
                jSONObject.put("altText", str);
            }
            jSONObject.put(ViewProps.BORDER_WIDTH, this.borderWidth.name());
            String str2 = this.borderColor;
            if (str2 != null) {
                jSONObject.put(ViewProps.BORDER_COLOR, str2);
            }
            jSONObject.put("cornerRadius", this.cornerRadius);
            return jSONObject;
        }

        public String toString() {
            return "Media(url=" + this.url + ", size=" + this.size + ", altText=" + this.altText + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", cornerRadius=" + this.cornerRadius + ")";
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
        public final String url() {
            return this.url;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.url);
            out.writeString(this.size.name());
            out.writeString(this.altText);
            out.writeString(this.borderWidth.name());
            out.writeString(this.borderColor);
            out.writeString(this.cornerRadius.name());
        }

        public /* synthetic */ Media(String str, ImageSize imageSize, String str2, Size size, String str3, Size size2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? ImageSize.e2e : imageSize, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? Size.s : size, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? Size.s : size2);
        }
    }

    public static final class Button implements Parcelable {
        public static final Parcelable.Creator<Button> CREATOR = new a();
        public final String action;
        public final ActionType actionType;
        public final String backgroundColor;
        public final String borderColor;
        public final Size borderWidth;
        public final Size cornerRadius;
        public final String fontColor;
        public final Size fontSize;
        public final String id;
        public final int index;
        public final String text;

        public enum ActionType {
            close,
            url,
            pushSettings,
            locationSettings;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<ActionType> getEntries() {
                return $ENTRIES;
            }
        }

        public static final class a implements Parcelable.Creator<Button> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Button createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Button(parcel.readString(), parcel.readInt(), parcel.readString(), ActionType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), Size.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), Size.valueOf(parcel.readString()), Size.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Button[] newArray(int i) {
                return new Button[i];
            }
        }

        public Button(@NotNull String id, int i, @NotNull String text, @NotNull ActionType actionType, @Nullable String str, @Nullable String str2, @NotNull Size fontSize, @Nullable String str3, @Nullable String str4, @NotNull Size borderWidth, @NotNull Size cornerRadius) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
            Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
            this.id = id;
            this.index = i;
            this.text = text;
            this.actionType = actionType;
            this.action = str;
            this.fontColor = str2;
            this.fontSize = fontSize;
            this.backgroundColor = str3;
            this.borderColor = str4;
            this.borderWidth = borderWidth;
            this.cornerRadius = cornerRadius;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "action", imports = {}))
        public final String action() {
            return this.action;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, imports = {}))
        public final ActionType actionType() {
            return this.actionType;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ViewProps.BACKGROUND_COLOR, imports = {}))
        public final String backgroundColor() {
            return this.backgroundColor;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ViewProps.BORDER_COLOR, imports = {}))
        public final String borderColor() {
            return this.borderColor;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ViewProps.BORDER_WIDTH, imports = {}))
        public final Size borderWidth() {
            return this.borderWidth;
        }

        public final String component1() {
            return this.id;
        }

        public final Size component10() {
            return this.borderWidth;
        }

        public final Size component11() {
            return this.cornerRadius;
        }

        public final int component2() {
            return this.index;
        }

        public final String component3() {
            return this.text;
        }

        public final ActionType component4() {
            return this.actionType;
        }

        public final String component5() {
            return this.action;
        }

        public final String component6() {
            return this.fontColor;
        }

        public final Size component7() {
            return this.fontSize;
        }

        public final String component8() {
            return this.backgroundColor;
        }

        public final String component9() {
            return this.borderColor;
        }

        public final Button copy(@NotNull String id, int i, @NotNull String text, @NotNull ActionType actionType, @Nullable String str, @Nullable String str2, @NotNull Size fontSize, @Nullable String str3, @Nullable String str4, @NotNull Size borderWidth, @NotNull Size cornerRadius) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(borderWidth, "borderWidth");
            Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
            return new Button(id, i, text, actionType, str, str2, fontSize, str3, str4, borderWidth, cornerRadius);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cornerRadius", imports = {}))
        public final Size cornerRadius() {
            return this.cornerRadius;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Button)) {
                return false;
            }
            Button button = (Button) obj;
            return Intrinsics.areEqual(this.id, button.id) && this.index == button.index && Intrinsics.areEqual(this.text, button.text) && this.actionType == button.actionType && Intrinsics.areEqual(this.action, button.action) && Intrinsics.areEqual(this.fontColor, button.fontColor) && this.fontSize == button.fontSize && Intrinsics.areEqual(this.backgroundColor, button.backgroundColor) && Intrinsics.areEqual(this.borderColor, button.borderColor) && this.borderWidth == button.borderWidth && this.cornerRadius == button.cornerRadius;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fontColor", imports = {}))
        public final String fontColor() {
            return this.fontColor;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ViewProps.FONT_SIZE, imports = {}))
        public final Size fontSize() {
            return this.fontSize;
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode();
            int iHashCode2 = Integer.hashCode(this.index);
            int iHashCode3 = this.text.hashCode();
            int iHashCode4 = this.actionType.hashCode();
            String str = this.action;
            int iHashCode5 = str == null ? 0 : str.hashCode();
            String str2 = this.fontColor;
            int iHashCode6 = str2 == null ? 0 : str2.hashCode();
            int iHashCode7 = this.fontSize.hashCode();
            String str3 = this.backgroundColor;
            int iHashCode8 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.borderColor;
            return (((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + (str4 != null ? str4.hashCode() : 0)) * 31) + this.borderWidth.hashCode()) * 31) + this.cornerRadius.hashCode();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "id", imports = {}))
        public final String id() {
            return this.id;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.INDEX, imports = {}))
        public final int index() {
            return this.index;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "text", imports = {}))
        public final String text() {
            return this.text;
        }

        public final JSONObject toJson$sdk_release() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.id);
            jSONObject.put(FirebaseAnalytics.Param.INDEX, this.index);
            jSONObject.put("text", this.text);
            jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, this.actionType.name());
            String str = this.action;
            if (str != null) {
                jSONObject.put("actionAndroid", str);
            }
            String str2 = this.fontColor;
            if (str2 != null) {
                jSONObject.put("fontColor", str2);
            }
            jSONObject.put(ViewProps.FONT_SIZE, this.fontSize.name());
            String str3 = this.backgroundColor;
            if (str3 != null) {
                jSONObject.put(ViewProps.BACKGROUND_COLOR, str3);
            }
            String str4 = this.borderColor;
            if (str4 != null) {
                jSONObject.put(ViewProps.BORDER_COLOR, str4);
            }
            jSONObject.put(ViewProps.BORDER_WIDTH, this.borderWidth.name());
            jSONObject.put("cornerRadius", this.cornerRadius.name());
            return jSONObject;
        }

        public String toString() {
            return "Button(id=" + this.id + ", index=" + this.index + ", text=" + this.text + ", actionType=" + this.actionType + ", action=" + this.action + ", fontColor=" + this.fontColor + ", fontSize=" + this.fontSize + ", backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", cornerRadius=" + this.cornerRadius + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.id);
            out.writeInt(this.index);
            out.writeString(this.text);
            out.writeString(this.actionType.name());
            out.writeString(this.action);
            out.writeString(this.fontColor);
            out.writeString(this.fontSize.name());
            out.writeString(this.backgroundColor);
            out.writeString(this.borderColor);
            out.writeString(this.borderWidth.name());
            out.writeString(this.cornerRadius.name());
        }

        public /* synthetic */ Button(String str, int i, String str2, ActionType actionType, String str3, String str4, Size size, String str5, String str6, Size size2, Size size3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 0 : i, str2, (i2 & 8) != 0 ? ActionType.close : actionType, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? Size.s : size, (i2 & 128) != 0 ? null : str5, (i2 & 256) != 0 ? null : str6, (i2 & 512) != 0 ? Size.s : size2, (i2 & 1024) != 0 ? Size.s : size3);
        }
    }

    public /* synthetic */ InAppMessage(String str, String str2, int i, Date date, Date date2, Date date3, int i2, Type type, String str3, long j, String str4, Size size, String str5, Size size2, LayoutOrder layoutOrder, Media media, TextField textField, TextField textField2, CloseButton closeButton, ButtonConfig buttonConfig, List list, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i4 & 4) != 0 ? 999 : i, (i4 & 8) != 0 ? null : date, (i4 & 16) != 0 ? null : date2, (i4 & 32) != 0 ? null : date3, (i4 & 64) != 0 ? 1 : i2, type, (i4 & 256) != 0 ? null : str3, (i4 & 512) != 0 ? -1L : j, str4, (i4 & 2048) != 0 ? Size.s : size, (i4 & 4096) != 0 ? null : str5, (i4 & 8192) != 0 ? Size.s : size2, (i4 & 16384) != 0 ? LayoutOrder.ImageTitleBody : layoutOrder, (32768 & i4) != 0 ? null : media, (65536 & i4) != 0 ? null : textField, (131072 & i4) != 0 ? null : textField2, (262144 & i4) != 0 ? null : closeButton, (524288 & i4) != 0 ? ButtonConfig.twoUp : buttonConfig, (1048576 & i4) != 0 ? null : list, (2097152 & i4) != 0 ? 0 : i3, (i4 & 4194304) != 0 ? false : z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public InAppMessage(@NotNull JSONObject json) throws JSONException {
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = json.getString("activityInstanceId");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        int iOptInt = json.optInt(SentryThread.JsonKeys.PRIORITY, 999);
        String strOptString = json.optString("startDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strB = o.b(strOptString);
        Date dateA = strB != null ? o.a(strB) : null;
        String strOptString2 = json.optString("endDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strB2 = o.b(strOptString2);
        Date dateA2 = strB2 != null ? o.a(strB2) : null;
        String strOptString3 = json.optString("modifiedDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strB3 = o.b(strOptString3);
        Date dateA3 = strB3 != null ? o.a(strB3) : null;
        int iOptInt2 = json.optInt("displayLimit", 1);
        String string3 = json.getString("type");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        Type typeValueOf = Type.valueOf(string3);
        String strOptString4 = json.optString("windowColor");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strB4 = o.b(strOptString4);
        long jOptLong = json.optLong("displayDuration", -1L);
        String strOptString5 = json.optString(ViewProps.BACKGROUND_COLOR);
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        String strB5 = o.b(strOptString5);
        Size size = Size.s;
        String strOptString6 = json.optString(ViewProps.BORDER_WIDTH);
        Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
        String strB6 = o.b(strOptString6);
        Size sizeValueOf = strB6 != null ? Size.valueOf(strB6) : size;
        String strOptString7 = json.optString(ViewProps.BORDER_COLOR);
        Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
        String strB7 = o.b(strOptString7);
        String strOptString8 = json.optString("cornerRadius");
        Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
        String strB8 = o.b(strOptString8);
        Size sizeValueOf2 = strB8 != null ? Size.valueOf(strB8) : size;
        LayoutOrder layoutOrder = LayoutOrder.ImageTitleBody;
        String strOptString9 = json.optString("layoutOrder");
        Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
        String strB9 = o.b(strOptString9);
        LayoutOrder layoutOrderValueOf = strB9 != null ? LayoutOrder.valueOf(strB9) : layoutOrder;
        JSONObject jSONObjectOptJSONObject = json.optJSONObject("media");
        Media mediaB = jSONObjectOptJSONObject != null ? h.b(jSONObjectOptJSONObject) : null;
        JSONObject jSONObjectOptJSONObject2 = json.optJSONObject("title");
        TextField textFieldC = jSONObjectOptJSONObject2 != null ? h.c(jSONObjectOptJSONObject2) : null;
        JSONObject jSONObjectOptJSONObject3 = json.optJSONObject("body");
        TextField textFieldC2 = jSONObjectOptJSONObject3 != null ? h.c(jSONObjectOptJSONObject3) : null;
        JSONObject jSONObjectOptJSONObject4 = json.optJSONObject("closeButton");
        CloseButton closeButtonA = jSONObjectOptJSONObject4 != null ? h.a(jSONObjectOptJSONObject4) : null;
        ButtonConfig buttonConfig = ButtonConfig.twoUp;
        String strOptString10 = json.optString("buttonConfiguration");
        Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
        String strB10 = o.b(strOptString10);
        ButtonConfig buttonConfigValueOf = strB10 != null ? ButtonConfig.valueOf(strB10) : buttonConfig;
        JSONArray jSONArrayOptJSONArray = json.optJSONArray("buttons");
        this(string, string2, iOptInt, dateA, dateA2, dateA3, iOptInt2, typeValueOf, strB4, jOptLong, strB5, sizeValueOf, strB7, sizeValueOf2, layoutOrderValueOf, mediaB, textFieldC, textFieldC2, closeButtonA, buttonConfigValueOf, jSONArrayOptJSONArray != null ? h.a(jSONArrayOptJSONArray) : null, json.optInt("messageDelaySec", 0), json.optBoolean("displayLimitOverride", false));
    }
}
