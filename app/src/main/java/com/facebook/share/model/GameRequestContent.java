package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import ch.qos.logback.core.CoreConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class GameRequestContent implements ShareModel {
    private final ActionType actionType;
    private final String cta;
    private final String data;
    private final Filters filters;
    private final String message;
    private final String objectId;
    private final List<String> recipients;
    private final List<String> suggestions;
    private final String title;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new Parcelable.Creator<GameRequestContent>() { // from class: com.facebook.share.model.GameRequestContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameRequestContent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GameRequestContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameRequestContent[] newArray(int i) {
            return new GameRequestContent[i];
        }
    };

    public enum ActionType {
        SEND,
        ASKFOR,
        TURN,
        INVITE
    }

    public enum Filters {
        APP_USERS,
        APP_NON_USERS,
        EVERYBODY
    }

    public /* synthetic */ GameRequestContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getCta() {
        return this.cta;
    }

    public final List<String> getRecipients() {
        return this.recipients;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getData() {
        return this.data;
    }

    public final ActionType getActionType() {
        return this.actionType;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final Filters getFilters() {
        return this.filters;
    }

    public final List<String> getSuggestions() {
        return this.suggestions;
    }

    private GameRequestContent(Builder builder) {
        this.message = builder.getMessage$facebook_common_release();
        this.cta = builder.getCta$facebook_common_release();
        this.recipients = builder.getRecipients$facebook_common_release();
        this.title = builder.getTitle$facebook_common_release();
        this.data = builder.getData$facebook_common_release();
        this.actionType = builder.getActionType$facebook_common_release();
        this.objectId = builder.getObjectId$facebook_common_release();
        this.filters = builder.getFilters$facebook_common_release();
        this.suggestions = builder.getSuggestions$facebook_common_release();
    }

    public GameRequestContent(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.message = parcel.readString();
        this.cta = parcel.readString();
        this.recipients = parcel.createStringArrayList();
        this.title = parcel.readString();
        this.data = parcel.readString();
        this.actionType = (ActionType) parcel.readSerializable();
        this.objectId = parcel.readString();
        this.filters = (Filters) parcel.readSerializable();
        this.suggestions = parcel.createStringArrayList();
    }

    @Deprecated(message = "Replaced by [getRecipients()]", replaceWith = @ReplaceWith(expression = "getRecipients", imports = {}))
    public final String getTo() {
        List<String> list = this.recipients;
        if (list != null) {
            return TextUtils.join(",", list);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.message);
        out.writeString(this.cta);
        out.writeStringList(this.recipients);
        out.writeString(this.title);
        out.writeString(this.data);
        out.writeSerializable(this.actionType);
        out.writeString(this.objectId);
        out.writeSerializable(this.filters);
        out.writeStringList(this.suggestions);
    }

    public static final class Builder implements ShareModelBuilder<GameRequestContent, Builder> {
        private ActionType actionType;
        private String cta;
        private String data;
        private Filters filters;
        private String message;
        private String objectId;
        private List<String> recipients;
        private List<String> suggestions;
        private String title;

        public final String getMessage$facebook_common_release() {
            return this.message;
        }

        public final void setMessage$facebook_common_release(@Nullable String str) {
            this.message = str;
        }

        public final String getCta$facebook_common_release() {
            return this.cta;
        }

        public final void setCta$facebook_common_release(@Nullable String str) {
            this.cta = str;
        }

        public final List<String> getRecipients$facebook_common_release() {
            return this.recipients;
        }

        public final void setRecipients$facebook_common_release(@Nullable List<String> list) {
            this.recipients = list;
        }

        public final String getData$facebook_common_release() {
            return this.data;
        }

        public final void setData$facebook_common_release(@Nullable String str) {
            this.data = str;
        }

        public final String getTitle$facebook_common_release() {
            return this.title;
        }

        public final void setTitle$facebook_common_release(@Nullable String str) {
            this.title = str;
        }

        public final ActionType getActionType$facebook_common_release() {
            return this.actionType;
        }

        public final void setActionType$facebook_common_release(@Nullable ActionType actionType) {
            this.actionType = actionType;
        }

        public final String getObjectId$facebook_common_release() {
            return this.objectId;
        }

        public final void setObjectId$facebook_common_release(@Nullable String str) {
            this.objectId = str;
        }

        public final Filters getFilters$facebook_common_release() {
            return this.filters;
        }

        public final void setFilters$facebook_common_release(@Nullable Filters filters) {
            this.filters = filters;
        }

        public final List<String> getSuggestions$facebook_common_release() {
            return this.suggestions;
        }

        public final void setSuggestions$facebook_common_release(@Nullable List<String> list) {
            this.suggestions = list;
        }

        public final Builder setMessage(@Nullable String str) {
            this.message = str;
            return this;
        }

        public final Builder setCta(@Nullable String str) {
            this.cta = str;
            return this;
        }

        @Deprecated(message = "Replaced by {@link #setRecipients(List)}")
        public final Builder setTo(@Nullable String str) {
            if (str != null) {
                this.recipients = CollectionsKt___CollectionsKt.toList(StringsKt__StringsKt.split$default((CharSequence) str, new char[]{CoreConstants.COMMA_CHAR}, false, 0, 6, (Object) null));
            }
            return this;
        }

        public final Builder setRecipients(@Nullable List<String> list) {
            this.recipients = list;
            return this;
        }

        public final Builder setData(@Nullable String str) {
            this.data = str;
            return this;
        }

        public final Builder setTitle(@Nullable String str) {
            this.title = str;
            return this;
        }

        public final Builder setActionType(@Nullable ActionType actionType) {
            this.actionType = actionType;
            return this;
        }

        public final Builder setObjectId(@Nullable String str) {
            this.objectId = str;
            return this;
        }

        public final Builder setFilters(@Nullable Filters filters) {
            this.filters = filters;
            return this;
        }

        public final Builder setSuggestions(@Nullable List<String> list) {
            this.suggestions = list;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public GameRequestContent build() {
            return new GameRequestContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(@Nullable GameRequestContent gameRequestContent) {
            return gameRequestContent == null ? this : setMessage(gameRequestContent.getMessage()).setCta(gameRequestContent.getCta()).setRecipients(gameRequestContent.getRecipients()).setTitle(gameRequestContent.getTitle()).setData(gameRequestContent.getData()).setActionType(gameRequestContent.getActionType()).setObjectId(gameRequestContent.getObjectId()).setFilters(gameRequestContent.getFilters()).setSuggestions(gameRequestContent.getSuggestions());
        }

        public final Builder readFrom$facebook_common_release(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((GameRequestContent) parcel.readParcelable(GameRequestContent.class.getClassLoader()));
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
