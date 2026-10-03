package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ShareFeedContent extends ShareContent<ShareFeedContent, Builder> {
    private final String link;
    private final String linkCaption;
    private final String linkDescription;
    private final String linkName;
    private final String mediaSource;
    private final String picture;
    private final String toId;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator<ShareFeedContent>() { // from class: com.facebook.share.internal.ShareFeedContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareFeedContent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareFeedContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareFeedContent[] newArray(int i) {
            return new ShareFeedContent[i];
        }
    };

    public /* synthetic */ ShareFeedContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getToId() {
        return this.toId;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getLinkName() {
        return this.linkName;
    }

    public final String getLinkCaption() {
        return this.linkCaption;
    }

    public final String getLinkDescription() {
        return this.linkDescription;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final String getMediaSource() {
        return this.mediaSource;
    }

    private ShareFeedContent(Builder builder) {
        super(builder);
        this.toId = builder.getToId$facebook_common_release();
        this.link = builder.getLink$facebook_common_release();
        this.linkName = builder.getLinkName$facebook_common_release();
        this.linkCaption = builder.getLinkCaption$facebook_common_release();
        this.linkDescription = builder.getLinkDescription$facebook_common_release();
        this.picture = builder.getPicture$facebook_common_release();
        this.mediaSource = builder.getMediaSource$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFeedContent(@NotNull Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.toId = parcel.readString();
        this.link = parcel.readString();
        this.linkName = parcel.readString();
        this.linkCaption = parcel.readString();
        this.linkDescription = parcel.readString();
        this.picture = parcel.readString();
        this.mediaSource = parcel.readString();
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i);
        out.writeString(this.toId);
        out.writeString(this.link);
        out.writeString(this.linkName);
        out.writeString(this.linkCaption);
        out.writeString(this.linkDescription);
        out.writeString(this.picture);
        out.writeString(this.mediaSource);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Builder extends ShareContent.Builder<ShareFeedContent, Builder> {
        private String link;
        private String linkCaption;
        private String linkDescription;
        private String linkName;
        private String mediaSource;
        private String picture;
        private String toId;

        public final String getToId$facebook_common_release() {
            return this.toId;
        }

        public final void setToId$facebook_common_release(@Nullable String str) {
            this.toId = str;
        }

        public final String getLink$facebook_common_release() {
            return this.link;
        }

        public final void setLink$facebook_common_release(@Nullable String str) {
            this.link = str;
        }

        public final String getLinkName$facebook_common_release() {
            return this.linkName;
        }

        public final void setLinkName$facebook_common_release(@Nullable String str) {
            this.linkName = str;
        }

        public final String getLinkCaption$facebook_common_release() {
            return this.linkCaption;
        }

        public final void setLinkCaption$facebook_common_release(@Nullable String str) {
            this.linkCaption = str;
        }

        public final String getLinkDescription$facebook_common_release() {
            return this.linkDescription;
        }

        public final void setLinkDescription$facebook_common_release(@Nullable String str) {
            this.linkDescription = str;
        }

        public final String getPicture$facebook_common_release() {
            return this.picture;
        }

        public final void setPicture$facebook_common_release(@Nullable String str) {
            this.picture = str;
        }

        public final String getMediaSource$facebook_common_release() {
            return this.mediaSource;
        }

        public final void setMediaSource$facebook_common_release(@Nullable String str) {
            this.mediaSource = str;
        }

        public final Builder setToId(@Nullable String str) {
            this.toId = str;
            return this;
        }

        public final Builder setLink(@Nullable String str) {
            this.link = str;
            return this;
        }

        public final Builder setLinkName(@Nullable String str) {
            this.linkName = str;
            return this;
        }

        public final Builder setLinkCaption(@Nullable String str) {
            this.linkCaption = str;
            return this;
        }

        public final Builder setLinkDescription(@Nullable String str) {
            this.linkDescription = str;
            return this;
        }

        public final Builder setPicture(@Nullable String str) {
            this.picture = str;
            return this;
        }

        public final Builder setMediaSource(@Nullable String str) {
            this.mediaSource = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareFeedContent build() {
            return new ShareFeedContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(@Nullable ShareFeedContent shareFeedContent) {
            return shareFeedContent == null ? this : ((Builder) super.readFrom(shareFeedContent)).setToId(shareFeedContent.getToId()).setLink(shareFeedContent.getLink()).setLinkName(shareFeedContent.getLinkName()).setLinkCaption(shareFeedContent.getLinkCaption()).setLinkDescription(shareFeedContent.getLinkDescription()).setPicture(shareFeedContent.getPicture()).setMediaSource(shareFeedContent.getMediaSource());
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
