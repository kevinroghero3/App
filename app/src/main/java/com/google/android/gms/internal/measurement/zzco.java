package com.google.android.gms.internal.measurement;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: loaded from: classes4.dex */
public final class zzco {
    public static final int zza;
    private static final int zzb;

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, 0, intent, i2);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        zzb = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zza = i >= 31 ? 33554432 : 0;
    }
}
