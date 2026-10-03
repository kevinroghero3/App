package com.google.android.gms.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface FusedLocationProviderApi {

    @Deprecated
    public static final String KEY_LOCATION_CHANGED = "com.google.android.location.LOCATION";

    @Deprecated
    public static final String KEY_MOCK_LOCATION = "mockLocation";

    PendingResult<Status> flushLocations(@NonNull GoogleApiClient googleApiClient);

    Location getLastLocation(@NonNull GoogleApiClient googleApiClient);

    LocationAvailability getLocationAvailability(@NonNull GoogleApiClient googleApiClient);

    PendingResult<Status> removeLocationUpdates(@NonNull GoogleApiClient googleApiClient, @NonNull PendingIntent pendingIntent);

    PendingResult<Status> removeLocationUpdates(@NonNull GoogleApiClient googleApiClient, @NonNull LocationCallback locationCallback);

    PendingResult<Status> removeLocationUpdates(@NonNull GoogleApiClient googleApiClient, @NonNull LocationListener locationListener);

    PendingResult<Status> requestLocationUpdates(@NonNull GoogleApiClient googleApiClient, @NonNull LocationRequest locationRequest, @NonNull PendingIntent pendingIntent);

    PendingResult<Status> requestLocationUpdates(@NonNull GoogleApiClient googleApiClient, @NonNull LocationRequest locationRequest, @NonNull LocationCallback locationCallback, @NonNull Looper looper);

    PendingResult<Status> requestLocationUpdates(@NonNull GoogleApiClient googleApiClient, @NonNull LocationRequest locationRequest, @NonNull LocationListener locationListener);

    PendingResult<Status> requestLocationUpdates(@NonNull GoogleApiClient googleApiClient, @NonNull LocationRequest locationRequest, @NonNull LocationListener locationListener, @NonNull Looper looper);

    PendingResult<Status> setMockLocation(@NonNull GoogleApiClient googleApiClient, @NonNull Location location);

    PendingResult<Status> setMockMode(@NonNull GoogleApiClient googleApiClient, boolean z);
}
