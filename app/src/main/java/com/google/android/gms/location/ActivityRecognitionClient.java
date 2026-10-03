package com.google.android.gms.location;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
public interface ActivityRecognitionClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    Task<Void> removeActivityTransitionUpdates(@NonNull PendingIntent pendingIntent);

    Task<Void> removeActivityUpdates(@NonNull PendingIntent pendingIntent);

    Task<Void> removeSleepSegmentUpdates(@NonNull PendingIntent pendingIntent);

    Task<Void> requestActivityTransitionUpdates(@NonNull ActivityTransitionRequest activityTransitionRequest, @NonNull PendingIntent pendingIntent);

    Task<Void> requestActivityUpdates(long j, @NonNull PendingIntent pendingIntent);

    Task<Void> requestSleepSegmentUpdates(@NonNull PendingIntent pendingIntent, @NonNull SleepSegmentRequest sleepSegmentRequest);
}
