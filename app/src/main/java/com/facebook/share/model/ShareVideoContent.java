package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements ShareModel {
    private final String contentDescription;
    private final String contentTitle;
    private final SharePhoto previewPhoto;
    private final ShareVideo video;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator<ShareVideoContent>() { // from class: com.facebook.share.model.ShareVideoContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareVideoContent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareVideoContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareVideoContent[] newArray(int i) {
            return new ShareVideoContent[i];
        }
    };

    public /* synthetic */ ShareVideoContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final String getContentTitle() {
        return this.contentTitle;
    }

    public final SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    public final ShareVideo getVideo() {
        return this.video;
    }

    private ShareVideoContent(Builder builder) {
        super(builder);
        this.contentDescription = builder.getContentDescription$facebook_common_release();
        this.contentTitle = builder.getContentTitle$facebook_common_release();
        this.previewPhoto = builder.getPreviewPhoto$facebook_common_release();
        this.video = builder.getVideo$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareVideoContent(@NotNull Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        SharePhoto.Builder from$facebook_common_release = new SharePhoto.Builder().readFrom$facebook_common_release(parcel);
        this.previewPhoto = (from$facebook_common_release.getImageUrl$facebook_common_release() == null && from$facebook_common_release.getBitmap$facebook_common_release() == null) ? null : from$facebook_common_release.build();
        this.video = new ShareVideo.Builder().readFrom$facebook_common_release(parcel).build();
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i);
        out.writeString(this.contentDescription);
        out.writeString(this.contentTitle);
        out.writeParcelable(this.previewPhoto, 0);
        out.writeParcelable(this.video, 0);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Builder extends ShareContent.Builder<ShareVideoContent, Builder> {
        private String contentDescription;
        private String contentTitle;
        private SharePhoto previewPhoto;
        private ShareVideo video;

        public final String getContentDescription$facebook_common_release() {
            return this.contentDescription;
        }

        public final void setContentDescription$facebook_common_release(@Nullable String str) {
            this.contentDescription = str;
        }

        public final String getContentTitle$facebook_common_release() {
            return this.contentTitle;
        }

        public final void setContentTitle$facebook_common_release(@Nullable String str) {
            this.contentTitle = str;
        }

        public final SharePhoto getPreviewPhoto$facebook_common_release() {
            return this.previewPhoto;
        }

        public final void setPreviewPhoto$facebook_common_release(@Nullable SharePhoto sharePhoto) {
            this.previewPhoto = sharePhoto;
        }

        public final ShareVideo getVideo$facebook_common_release() {
            return this.video;
        }

        public final void setVideo$facebook_common_release(@Nullable ShareVideo shareVideo) {
            this.video = shareVideo;
        }

        public final Builder setContentDescription(@Nullable String str) {
            this.contentDescription = str;
            return this;
        }

        public final Builder setContentTitle(@Nullable String str) {
            this.contentTitle = str;
            return this;
        }

        public final Builder setPreviewPhoto(@Nullable SharePhoto sharePhoto) {
            this.previewPhoto = sharePhoto != null ? new SharePhoto.Builder().readFrom(sharePhoto).build() : null;
            return this;
        }

        public final Builder setVideo(@Nullable ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            this.video = new ShareVideo.Builder().readFrom(shareVideo).build();
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareVideoContent build() {
            return new ShareVideoContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(@Nullable ShareVideoContent shareVideoContent) {
            return shareVideoContent == null ? this : ((Builder) super.readFrom(shareVideoContent)).setContentDescription(shareVideoContent.getContentDescription()).setContentTitle(shareVideoContent.getContentTitle()).setPreviewPhoto(shareVideoContent.getPreviewPhoto()).setVideo(shareVideoContent.getVideo());
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
