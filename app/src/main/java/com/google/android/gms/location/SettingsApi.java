package com.google.android.gms.location;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface SettingsApi {
    PendingResult<LocationSettingsResult> checkLocationSettings(@NonNull GoogleApiClient googleApiClient, @NonNull LocationSettingsRequest locationSettingsRequest);
}
