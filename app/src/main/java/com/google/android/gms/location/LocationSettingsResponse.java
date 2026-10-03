package com.google.android.gms.location;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Response;

/* JADX INFO: loaded from: classes2.dex */
public class LocationSettingsResponse extends Response<LocationSettingsResult> {
    public LocationSettingsResponse(@NonNull LocationSettingsResult locationSettingsResult) {
        super(locationSettingsResult);
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return getResult().getLocationSettingsStates();
    }
}
