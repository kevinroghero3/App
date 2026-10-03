package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Process;
import android.os.UserManager;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes4.dex */
public class zzgr {
    private static UserManager zza;
    private static volatile boolean zzb = !zza();
    private static boolean zzc = false;

    public static boolean zza() {
        return true;
    }

    private zzgr() {
    }

    private static boolean zzc(Context context) {
        if (zzb) {
            return true;
        }
        synchronized (zzgr.class) {
            if (zzb) {
                return true;
            }
            boolean zZzd = zzd(context);
            if (zZzd) {
                zzb = zZzd;
            }
            return zZzd;
        }
    }

    private static boolean zzd(Context context) {
        boolean z;
        boolean z2 = true;
        int i = 1;
        while (true) {
            z = false;
            if (i > 2) {
                break;
            }
            if (zza == null) {
                zza = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = zza;
            if (userManager == null) {
                return true;
            }
            try {
                if (!userManager.isUserUnlocked() && userManager.isUserRunning(Process.myUserHandle())) {
                    z2 = false;
                }
                z = z2;
                break;
            } catch (NullPointerException e) {
                SentryLogcatAdapter.w("DirectBootUtils", "Failed to check if user is unlocked.", e);
                zza = null;
                i++;
            }
        }
        if (z) {
            zza = null;
        }
        return z;
    }

    public static boolean zza(Context context) {
        return zza() && !zzc(context);
    }

    public static boolean zzb(Context context) {
        return !zza() || zzc(context);
    }
}
