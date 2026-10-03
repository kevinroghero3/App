package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraEffectTextures implements ShareModel {
    private final Bundle textures;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<CameraEffectTextures> CREATOR = new Parcelable.Creator<CameraEffectTextures>() { // from class: com.facebook.share.model.CameraEffectTextures$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraEffectTextures createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CameraEffectTextures(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraEffectTextures[] newArray(int i) {
            return new CameraEffectTextures[i];
        }
    };

    public /* synthetic */ CameraEffectTextures(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private CameraEffectTextures(Builder builder) {
        this.textures = builder.getTextures$facebook_common_release();
    }

    public CameraEffectTextures(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.textures = parcel.readBundle(CameraEffectTextures.class.getClassLoader());
    }

    public final Bitmap getTextureBitmap(@Nullable String str) {
        Bundle bundle = this.textures;
        Object obj = bundle != null ? bundle.get(str) : null;
        if (obj instanceof Bitmap) {
            return (Bitmap) obj;
        }
        return null;
    }

    public final Uri getTextureUri(@Nullable String str) {
        Bundle bundle = this.textures;
        Object obj = bundle != null ? bundle.get(str) : null;
        if (obj instanceof Uri) {
            return (Uri) obj;
        }
        return null;
    }

    public final Object get(@Nullable String str) {
        Bundle bundle = this.textures;
        if (bundle != null) {
            return bundle.get(str);
        }
        return null;
    }

    public final Set<String> keySet() {
        Bundle bundle = this.textures;
        Set<String> setKeySet = bundle != null ? bundle.keySet() : null;
        return setKeySet == null ? SetsKt__SetsKt.emptySet() : setKeySet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeBundle(this.textures);
    }

    public static final class Builder implements ShareModelBuilder<CameraEffectTextures, Builder> {
        private final Bundle textures = new Bundle();

        public final Bundle getTextures$facebook_common_release() {
            return this.textures;
        }

        public final Builder putTexture(@NotNull String key, @Nullable Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(key, "key");
            return putParcelableTexture(key, bitmap);
        }

        public final Builder putTexture(@NotNull String key, @Nullable Uri uri) {
            Intrinsics.checkNotNullParameter(key, "key");
            return putParcelableTexture(key, uri);
        }

        private final Builder putParcelableTexture(String str, Parcelable parcelable) {
            if (str.length() > 0 && parcelable != null) {
                this.textures.putParcelable(str, parcelable);
            }
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(@Nullable CameraEffectTextures cameraEffectTextures) {
            if (cameraEffectTextures != null) {
                this.textures.putAll(cameraEffectTextures.textures);
            }
            return this;
        }

        public final Builder readFrom(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
        }

        @Override // com.facebook.share.ShareBuilder
        public CameraEffectTextures build() {
            return new CameraEffectTextures(this, null);
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
