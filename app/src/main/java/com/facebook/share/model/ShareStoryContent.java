package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ShareStoryContent extends ShareContent<ShareStoryContent, Builder> {
    private final String attributionLink;
    private final ShareMedia<?, ?> backgroundAsset;
    private final List<String> backgroundColorList;
    private final SharePhoto stickerAsset;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ShareStoryContent> CREATOR = new Parcelable.Creator<ShareStoryContent>() { // from class: com.facebook.share.model.ShareStoryContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareStoryContent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareStoryContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareStoryContent[] newArray(int i) {
            return new ShareStoryContent[i];
        }
    };

    public /* synthetic */ ShareStoryContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final ShareMedia<?, ?> getBackgroundAsset() {
        return this.backgroundAsset;
    }

    public final SharePhoto getStickerAsset() {
        return this.stickerAsset;
    }

    public final List<String> getBackgroundColorList() {
        List<String> list = this.backgroundColorList;
        if (list != null) {
            return CollectionsKt___CollectionsKt.toList(list);
        }
        return null;
    }

    public final String getAttributionLink() {
        return this.attributionLink;
    }

    private ShareStoryContent(Builder builder) {
        super(builder);
        this.backgroundAsset = builder.getBackgroundAsset$facebook_common_release();
        this.stickerAsset = builder.getStickerAsset$facebook_common_release();
        this.backgroundColorList = builder.getBackgroundColorList$facebook_common_release();
        this.attributionLink = builder.getAttributionLink$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareStoryContent(@NotNull Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.backgroundAsset = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.stickerAsset = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        this.backgroundColorList = readUnmodifiableStringList(parcel);
        this.attributionLink = parcel.readString();
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i);
        out.writeParcelable(this.backgroundAsset, 0);
        out.writeParcelable(this.stickerAsset, 0);
        out.writeStringList(getBackgroundColorList());
        out.writeString(this.attributionLink);
    }

    private final List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Builder extends ShareContent.Builder<ShareStoryContent, Builder> {
        private String attributionLink;
        private ShareMedia<?, ?> backgroundAsset;
        private List<String> backgroundColorList;
        private SharePhoto stickerAsset;

        public final ShareMedia<?, ?> getBackgroundAsset$facebook_common_release() {
            return this.backgroundAsset;
        }

        public final void setBackgroundAsset$facebook_common_release(@Nullable ShareMedia<?, ?> shareMedia) {
            this.backgroundAsset = shareMedia;
        }

        public final SharePhoto getStickerAsset$facebook_common_release() {
            return this.stickerAsset;
        }

        public final void setStickerAsset$facebook_common_release(@Nullable SharePhoto sharePhoto) {
            this.stickerAsset = sharePhoto;
        }

        public final List<String> getBackgroundColorList$facebook_common_release() {
            return this.backgroundColorList;
        }

        public final void setBackgroundColorList$facebook_common_release(@Nullable List<String> list) {
            this.backgroundColorList = list;
        }

        public final String getAttributionLink$facebook_common_release() {
            return this.attributionLink;
        }

        public final void setAttributionLink$facebook_common_release(@Nullable String str) {
            this.attributionLink = str;
        }

        public final Builder setBackgroundAsset(@Nullable ShareMedia<?, ?> shareMedia) {
            this.backgroundAsset = shareMedia;
            return this;
        }

        public final Builder setStickerAsset(@Nullable SharePhoto sharePhoto) {
            this.stickerAsset = sharePhoto;
            return this;
        }

        public final Builder setBackgroundColorList(@Nullable List<String> list) {
            this.backgroundColorList = list != null ? CollectionsKt___CollectionsKt.toList(list) : null;
            return this;
        }

        public final Builder setAttributionLink(@Nullable String str) {
            this.attributionLink = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareStoryContent build() {
            return new ShareStoryContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(@Nullable ShareStoryContent shareStoryContent) {
            return shareStoryContent == null ? this : ((Builder) super.readFrom(shareStoryContent)).setBackgroundAsset(shareStoryContent.getBackgroundAsset()).setStickerAsset(shareStoryContent.getStickerAsset()).setBackgroundColorList(shareStoryContent.getBackgroundColorList()).setAttributionLink(shareStoryContent.getAttributionLink());
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
