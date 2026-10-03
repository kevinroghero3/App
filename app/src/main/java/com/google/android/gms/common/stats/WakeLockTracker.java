package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class WakeLockTracker {
    private static final WakeLockTracker zza = new WakeLockTracker();

    public static WakeLockTracker getInstance() {
        return zza;
    }

    public void registerAcquireEvent(@NonNull Context context, @NonNull Intent intent, @NonNull String str, @NonNull String str2, @NonNull String str3, int i, @NonNull String str4) {
    }

    public void registerDeadlineEvent(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, int i, @NonNull List<String> list, boolean z, long j) {
    }

    public void registerEvent(@NonNull Context context, @NonNull String str, int i, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i2, @NonNull List<String> list) {
    }

    public void registerEvent(@NonNull Context context, @NonNull String str, int i, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i2, @NonNull List<String> list, long j) {
    }

    public void registerReleaseEvent(@NonNull Context context, @NonNull Intent intent) {
    }
}
