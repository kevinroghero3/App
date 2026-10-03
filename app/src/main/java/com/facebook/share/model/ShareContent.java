package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ShareContent<M extends ShareContent<M, B>, B extends Builder<M, B>> implements ShareModel {
    private final Uri contentUrl;
    private final String pageId;
    private final List<String> peopleIds;
    private final String placeId;
    private final String ref;
    private final ShareHashtag shareHashtag;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Uri getContentUrl() {
        return this.contentUrl;
    }

    public final List<String> getPeopleIds() {
        return this.peopleIds;
    }

    public final String getPlaceId() {
        return this.placeId;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getRef() {
        return this.ref;
    }

    public final ShareHashtag getShareHashtag() {
        return this.shareHashtag;
    }

    public ShareContent(@NotNull Builder<M, B> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.contentUrl = builder.getContentUrl$facebook_common_release();
        this.peopleIds = builder.getPeopleIds$facebook_common_release();
        this.placeId = builder.getPlaceId$facebook_common_release();
        this.pageId = builder.getPageId$facebook_common_release();
        this.ref = builder.getRef$facebook_common_release();
        this.shareHashtag = builder.getHashtag$facebook_common_release();
    }

    public ShareContent(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.contentUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.peopleIds = readUnmodifiableStringList(parcel);
        this.placeId = parcel.readString();
        this.pageId = parcel.readString();
        this.ref = parcel.readString();
        this.shareHashtag = new ShareHashtag.Builder().readFrom$facebook_common_release(parcel).build();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeParcelable(this.contentUrl, 0);
        out.writeStringList(this.peopleIds);
        out.writeString(this.placeId);
        out.writeString(this.pageId);
        out.writeString(this.ref);
        out.writeParcelable(this.shareHashtag, 0);
    }

    private final List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static abstract class Builder<M extends ShareContent<M, B>, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        private Uri contentUrl;
        private ShareHashtag hashtag;
        private String pageId;
        private List<String> peopleIds;
        private String placeId;
        private String ref;

        public final Uri getContentUrl$facebook_common_release() {
            return this.contentUrl;
        }

        public final void setContentUrl$facebook_common_release(@Nullable Uri uri) {
            this.contentUrl = uri;
        }

        public final List<String> getPeopleIds$facebook_common_release() {
            return this.peopleIds;
        }

        public final void setPeopleIds$facebook_common_release(@Nullable List<String> list) {
            this.peopleIds = list;
        }

        public final String getPlaceId$facebook_common_release() {
            return this.placeId;
        }

        public final void setPlaceId$facebook_common_release(@Nullable String str) {
            this.placeId = str;
        }

        public final String getPageId$facebook_common_release() {
            return this.pageId;
        }

        public final void setPageId$facebook_common_release(@Nullable String str) {
            this.pageId = str;
        }

        public final String getRef$facebook_common_release() {
            return this.ref;
        }

        public final void setRef$facebook_common_release(@Nullable String str) {
            this.ref = str;
        }

        public final ShareHashtag getHashtag$facebook_common_release() {
            return this.hashtag;
        }

        public final void setHashtag$facebook_common_release(@Nullable ShareHashtag shareHashtag) {
            this.hashtag = shareHashtag;
        }

        public final B setContentUrl(@Nullable Uri uri) {
            this.contentUrl = uri;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareContent.Builder");
            return this;
        }

        public final B setPeopleIds(@Nullable List<String> list) {
            this.peopleIds = list == null ? null : Collections.unmodifiableList(list);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareContent.Builder");
            return this;
        }

        public final B setPlaceId(@Nullable String str) {
            this.placeId = str;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareContent.Builder");
            return this;
        }

        public final B setPageId(@Nullable String str) {
            this.pageId = str;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareContent.Builder");
            return this;
        }

        public final B setRef(@Nullable String str) {
            this.ref = str;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareContent.Builder");
            return this;
        }

        public final B setShareHashtag(@Nullable ShareHashtag shareHashtag) {
            this.hashtag = shareHashtag;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareContent.Builder");
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public B readFrom(@Nullable M m) {
            if (m == null) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareContent.Builder");
                return this;
            }
            return (B) setContentUrl(m.getContentUrl()).setPeopleIds(m.getPeopleIds()).setPlaceId(m.getPlaceId()).setPageId(m.getPageId()).setRef(m.getRef()).setShareHashtag(m.getShareHashtag());
        }
    }
}
