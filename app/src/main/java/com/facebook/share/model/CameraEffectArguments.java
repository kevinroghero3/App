package com.facebook.share.model;

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
public final class CameraEffectArguments implements ShareModel {
    private final Bundle params;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<CameraEffectArguments> CREATOR = new Parcelable.Creator<CameraEffectArguments>() { // from class: com.facebook.share.model.CameraEffectArguments$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraEffectArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CameraEffectArguments(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraEffectArguments[] newArray(int i) {
            return new CameraEffectArguments[i];
        }
    };

    public /* synthetic */ CameraEffectArguments(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private CameraEffectArguments(Builder builder) {
        this.params = builder.getParams$facebook_common_release();
    }

    public CameraEffectArguments(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.params = parcel.readBundle(CameraEffectArguments.class.getClassLoader());
    }

    public final String getString(@Nullable String str) {
        Bundle bundle = this.params;
        if (bundle != null) {
            return bundle.getString(str);
        }
        return null;
    }

    public final String[] getStringArray(@Nullable String str) {
        Bundle bundle = this.params;
        if (bundle != null) {
            return bundle.getStringArray(str);
        }
        return null;
    }

    public final Object get(@Nullable String str) {
        Bundle bundle = this.params;
        if (bundle != null) {
            return bundle.get(str);
        }
        return null;
    }

    public final Set<String> keySet() {
        Bundle bundle = this.params;
        Set<String> setKeySet = bundle != null ? bundle.keySet() : null;
        return setKeySet == null ? SetsKt__SetsKt.emptySet() : setKeySet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeBundle(this.params);
    }

    public static final class Builder implements ShareModelBuilder<CameraEffectArguments, Builder> {
        private final Bundle params = new Bundle();

        public final Bundle getParams$facebook_common_release() {
            return this.params;
        }

        public final Builder putArgument(@NotNull String key, @NotNull String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.params.putString(key, value);
            return this;
        }

        public final Builder putArgument(@NotNull String key, @NotNull String[] arrayValue) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(arrayValue, "arrayValue");
            this.params.putStringArray(key, arrayValue);
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(@Nullable CameraEffectArguments cameraEffectArguments) {
            if (cameraEffectArguments != null) {
                this.params.putAll(cameraEffectArguments.params);
            }
            return this;
        }

        public final Builder readFrom(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
        }

        @Override // com.facebook.share.ShareBuilder
        public CameraEffectArguments build() {
            return new CameraEffectArguments(this, null);
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
