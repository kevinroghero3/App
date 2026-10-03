package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AndroidClientInfo {

    public static abstract class Builder {
        public abstract AndroidClientInfo build();

        public abstract Builder setApplicationBuild(@Nullable String str);

        public abstract Builder setCountry(@Nullable String str);

        public abstract Builder setDevice(@Nullable String str);

        public abstract Builder setFingerprint(@Nullable String str);

        public abstract Builder setHardware(@Nullable String str);

        public abstract Builder setLocale(@Nullable String str);

        public abstract Builder setManufacturer(@Nullable String str);

        public abstract Builder setMccMnc(@Nullable String str);

        public abstract Builder setModel(@Nullable String str);

        public abstract Builder setOsBuild(@Nullable String str);

        public abstract Builder setProduct(@Nullable String str);

        public abstract Builder setSdkVersion(@Nullable Integer num);
    }

    public abstract String getApplicationBuild();

    public abstract String getCountry();

    public abstract String getDevice();

    public abstract String getFingerprint();

    public abstract String getHardware();

    public abstract String getLocale();

    public abstract String getManufacturer();

    public abstract String getMccMnc();

    public abstract String getModel();

    public abstract String getOsBuild();

    public abstract String getProduct();

    public abstract Integer getSdkVersion();

    public static Builder builder() {
        return new AutoValue_AndroidClientInfo.Builder();
    }
}
