package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Builder> {
    private CameraEffectArguments arguments;
    private String effectId;
    private CameraEffectTextures textures;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new Parcelable.Creator<ShareCameraEffectContent>() { // from class: com.facebook.share.model.ShareCameraEffectContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareCameraEffectContent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareCameraEffectContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareCameraEffectContent[] newArray(int i) {
            return new ShareCameraEffectContent[i];
        }
    };

    public /* synthetic */ ShareCameraEffectContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final String getEffectId() {
        return this.effectId;
    }

    public final CameraEffectArguments getArguments() {
        return this.arguments;
    }

    public final CameraEffectTextures getTextures() {
        return this.textures;
    }

    private ShareCameraEffectContent(Builder builder) {
        super(builder);
        this.effectId = builder.getEffectId$facebook_common_release();
        this.arguments = builder.getArguments$facebook_common_release();
        this.textures = builder.getTextures$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareCameraEffectContent(@NotNull Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.effectId = parcel.readString();
        this.arguments = new CameraEffectArguments.Builder().readFrom(parcel).build();
        this.textures = new CameraEffectTextures.Builder().readFrom(parcel).build();
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i);
        out.writeString(this.effectId);
        out.writeParcelable(this.arguments, 0);
        out.writeParcelable(this.textures, 0);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Builder extends ShareContent.Builder<ShareCameraEffectContent, Builder> {
        private CameraEffectArguments arguments;
        private String effectId;
        private CameraEffectTextures textures;

        public final String getEffectId$facebook_common_release() {
            return this.effectId;
        }

        public final void setEffectId$facebook_common_release(@Nullable String str) {
            this.effectId = str;
        }

        public final CameraEffectArguments getArguments$facebook_common_release() {
            return this.arguments;
        }

        public final void setArguments$facebook_common_release(@Nullable CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
        }

        public final CameraEffectTextures getTextures$facebook_common_release() {
            return this.textures;
        }

        public final void setTextures$facebook_common_release(@Nullable CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
        }

        public final Builder setEffectId(@Nullable String str) {
            this.effectId = str;
            return this;
        }

        public final Builder setArguments(@Nullable CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
            return this;
        }

        public final Builder setTextures(@Nullable CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareCameraEffectContent build() {
            return new ShareCameraEffectContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(@Nullable ShareCameraEffectContent shareCameraEffectContent) {
            return shareCameraEffectContent == null ? this : ((Builder) super.readFrom(shareCameraEffectContent)).setEffectId(shareCameraEffectContent.getEffectId()).setArguments(shareCameraEffectContent.getArguments()).setTextures(shareCameraEffectContent.getTextures());
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
