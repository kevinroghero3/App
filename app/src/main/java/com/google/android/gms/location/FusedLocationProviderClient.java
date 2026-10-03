package com.google.android.gms.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface FusedLocationProviderClient extends HasApiKey<Api.ApiOptions.NoOptions> {

    @Deprecated
    public static final String KEY_MOCK_LOCATION = "mockLocation";

    @Deprecated
    public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";

    Task<Void> flushLocations();

    Task<Location> getCurrentLocation(int i, @Nullable CancellationToken cancellationToken);

    Task<Location> getCurrentLocation(@NonNull CurrentLocationRequest currentLocationRequest, @Nullable CancellationToken cancellationToken);

    Task<Location> getLastLocation();

    Task<Location> getLastLocation(@NonNull LastLocationRequest lastLocationRequest);

    Task<LocationAvailability> getLocationAvailability();

    Task<Void> removeLocationUpdates(@NonNull PendingIntent pendingIntent);

    Task<Void> removeLocationUpdates(@NonNull LocationCallback locationCallback);

    Task<Void> removeLocationUpdates(@NonNull LocationListener locationListener);

    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull PendingIntent pendingIntent);

    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull LocationCallback locationCallback, @Nullable Looper looper);

    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull LocationListener locationListener, @Nullable Looper looper);

    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationCallback locationCallback);

    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationListener locationListener);

    Task<Void> setMockLocation(@NonNull Location location);

    Task<Void> setMockMode(boolean z);
}
