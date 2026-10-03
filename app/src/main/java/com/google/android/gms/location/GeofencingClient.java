package com.google.android.gms.location;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface GeofencingClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    Task<Void> addGeofences(@NonNull GeofencingRequest geofencingRequest, @NonNull PendingIntent pendingIntent);

    Task<Void> removeGeofences(@NonNull PendingIntent pendingIntent);

    Task<Void> removeGeofences(@NonNull List<String> list);
}
