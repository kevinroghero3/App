package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityRecognition {

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API = com.google.android.gms.internal.location.zzag.zzb;

    @Deprecated
    public static final ActivityRecognitionApi ActivityRecognitionApi = new com.google.android.gms.internal.location.zzw();

    private ActivityRecognition() {
    }

    public static ActivityRecognitionClient getClient(@NonNull Activity activity) {
        return new com.google.android.gms.internal.location.zzag(activity);
    }

    public static ActivityRecognitionClient getClient(@NonNull Context context) {
        return new com.google.android.gms.internal.location.zzag(context);
    }
}
