package com.google.android.gms.auth.api.identity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class zbc implements Api.ApiOptions.Optional {
    private final String zba;

    public zbc(String str) {
        this.zba = str;
    }

    public final boolean equals(@Nullable Object obj) {
        return obj instanceof zbc;
    }

    public final int hashCode() {
        return Objects.hashCode(zbc.class);
    }

    public final Bundle zba() {
        Bundle bundle = new Bundle();
        bundle.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, this.zba);
        return bundle;
    }

    public final String zbb() {
        return this.zba;
    }
}
