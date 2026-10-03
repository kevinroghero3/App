package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMedia.Builder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShareMedia<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModel {
    private final Bundle params;

    public enum Type {
        PHOTO,
        VIDEO
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract Type getMediaType();

    @Deprecated(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
    public final Bundle getParameters() {
        return new Bundle(this.params);
    }

    protected ShareMedia(@NotNull Builder<M, B> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.params = new Bundle(builder.getParams$facebook_common_release());
    }

    public ShareMedia(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Bundle bundle = parcel.readBundle(getClass().getClassLoader());
        this.params = bundle == null ? new Bundle() : bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeBundle(this.params);
    }

    public static abstract class Builder<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        public static final Companion Companion = new Companion(null);
        private Bundle params = new Bundle();

        public final Bundle getParams$facebook_common_release() {
            return this.params;
        }

        public final void setParams$facebook_common_release(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "<set-?>");
            this.params = bundle;
        }

        @Deprecated(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
        public final B setParameter(@NotNull String key, @NotNull String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.params.putString(key, value);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareMedia.Builder");
            return this;
        }

        @Deprecated(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
        public final B setParameters(@NotNull Bundle parameters) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.params.putAll(parameters);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareMedia.Builder");
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public B readFrom(@Nullable M m) {
            if (m != null) {
                return (B) setParameters(((ShareMedia) m).params);
            }
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareMedia.Builder");
            return this;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final void writeListTo$facebook_common_release(@NotNull Parcel out, int i, @NotNull List<? extends ShareMedia<?, ?>> media) {
                Intrinsics.checkNotNullParameter(out, "out");
                Intrinsics.checkNotNullParameter(media, "media");
                out.writeParcelableArray((Parcelable[]) media.toArray(new ShareMedia[0]), i);
            }

            @JvmStatic
            public final List<ShareMedia<?, ?>> readListFrom$facebook_common_release(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Parcelable[] parcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
                if (parcelableArray == null) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    if (parcelable instanceof ShareMedia) {
                        arrayList.add(parcelable);
                    }
                }
                return arrayList;
            }
        }
    }
}
