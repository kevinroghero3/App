package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ShareMediaContent extends ShareContent<ShareMediaContent, Builder> {
    private final List<ShareMedia<?, ?>> media;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ShareMediaContent> CREATOR = new Parcelable.Creator<ShareMediaContent>() { // from class: com.facebook.share.model.ShareMediaContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareMediaContent createFromParcel(@NotNull Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new ShareMediaContent(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareMediaContent[] newArray(int i) {
            return new ShareMediaContent[i];
        }
    };

    public /* synthetic */ ShareMediaContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<ShareMedia<?, ?>> getMedia() {
        return this.media;
    }

    private ShareMediaContent(Builder builder) {
        super(builder);
        this.media = CollectionsKt___CollectionsKt.toList(builder.getMedia$facebook_common_release());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareMediaContent(@NotNull Parcel source) {
        List<ShareMedia<?, ?>> listEmptyList;
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        Parcelable[] parcelableArray = source.readParcelableArray(ShareMedia.class.getClassLoader());
        if (parcelableArray == null) {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            listEmptyList = new ArrayList<>();
            for (Parcelable parcelable : parcelableArray) {
                ShareMedia<?, ?> shareMedia = (ShareMedia) parcelable;
                if (shareMedia != null) {
                    listEmptyList.add(shareMedia);
                }
            }
        }
        this.media = listEmptyList;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i);
        out.writeParcelableArray((Parcelable[]) this.media.toArray(new ShareMedia[0]), i);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Builder extends ShareContent.Builder<ShareMediaContent, Builder> {
        private final List<ShareMedia<?, ?>> media = new ArrayList();

        public final List<ShareMedia<?, ?>> getMedia$facebook_common_release() {
            return this.media;
        }

        public final Builder addMedium(@Nullable ShareMedia<?, ?> shareMedia) {
            ShareMedia<?, ?> shareMediaBuild;
            if (shareMedia != null) {
                if (shareMedia instanceof SharePhoto) {
                    shareMediaBuild = new SharePhoto.Builder().readFrom((SharePhoto) shareMedia).build();
                } else if (shareMedia instanceof ShareVideo) {
                    shareMediaBuild = new ShareVideo.Builder().readFrom((ShareVideo) shareMedia).build();
                } else {
                    throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                }
                this.media.add(shareMediaBuild);
            }
            return this;
        }

        public final Builder addMedia(@Nullable List<? extends ShareMedia<?, ?>> list) {
            if (list != null) {
                Iterator<? extends ShareMedia<?, ?>> it2 = list.iterator();
                while (it2.hasNext()) {
                    addMedium(it2.next());
                }
            }
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMediaContent build() {
            return new ShareMediaContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(@Nullable ShareMediaContent shareMediaContent) {
            return shareMediaContent == null ? this : ((Builder) super.readFrom(shareMediaContent)).addMedia(shareMediaContent.getMedia());
        }

        public final Builder setMedia(@Nullable List<? extends ShareMedia<?, ?>> list) {
            this.media.clear();
            addMedia(list);
            return this;
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
