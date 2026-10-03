package com.google.android.gms.location;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface GeofencingApi {
    PendingResult<Status> addGeofences(@NonNull GoogleApiClient googleApiClient, @NonNull GeofencingRequest geofencingRequest, @NonNull PendingIntent pendingIntent);

    @Deprecated
    PendingResult<Status> addGeofences(@NonNull GoogleApiClient googleApiClient, @NonNull List<Geofence> list, @NonNull PendingIntent pendingIntent);

    PendingResult<Status> removeGeofences(@NonNull GoogleApiClient googleApiClient, @NonNull PendingIntent pendingIntent);

    PendingResult<Status> removeGeofences(@NonNull GoogleApiClient googleApiClient, @NonNull List<String> list);
}
