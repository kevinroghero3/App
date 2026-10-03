package com.facebook.share.model;

import android.os.Parcel;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShareMessengerActionButton implements ShareModel {
    private final String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getTitle() {
        return this.title;
    }

    protected ShareMessengerActionButton(@NotNull Builder<?, ?> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.title = builder.getTitle$facebook_common_release();
    }

    public ShareMessengerActionButton(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.title = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.title);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        private String title;

        public final String getTitle$facebook_common_release() {
            return this.title;
        }

        public final void setTitle$facebook_common_release(@Nullable String str) {
            this.title = str;
        }

        public final B setTitle(@Nullable String str) {
            this.title = str;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareMessengerActionButton.Builder");
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public B readFrom(@Nullable M m) {
            if (m == null) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareMessengerActionButton.Builder");
                return this;
            }
            return (B) setTitle(m.getTitle());
        }
    }
}
