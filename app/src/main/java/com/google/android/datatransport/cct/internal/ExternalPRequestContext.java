package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExternalPRequestContext {

    public static abstract class Builder {
        public abstract ExternalPRequestContext build();

        public abstract Builder setOriginAssociatedProductId(@Nullable Integer num);
    }

    public abstract Integer getOriginAssociatedProductId();

    public static Builder builder() {
        return new AutoValue_ExternalPRequestContext.Builder();
    }
}
