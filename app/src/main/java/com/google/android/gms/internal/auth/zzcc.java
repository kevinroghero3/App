package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public final class zzcc {
    private static UserManager zza;
    private static volatile boolean zzb = !zzb();

    private zzcc() {
    }

    public static boolean zzb() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0051 A[Catch: all -> 0x005b, TryCatch #1 {, blocks: (B:9:0x000f, B:11:0x0013, B:16:0x001b, B:18:0x001f, B:19:0x0029, B:33:0x0055, B:34:0x0057, B:22:0x002f, B:24:0x0035, B:31:0x0051, B:28:0x0042), top: B:43:0x000f, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0055 A[Catch: all -> 0x005b, TryCatch #1 {, blocks: (B:9:0x000f, B:11:0x0013, B:16:0x001b, B:18:0x001f, B:19:0x0029, B:33:0x0055, B:34:0x0057, B:22:0x002f, B:24:0x0035, B:31:0x0051, B:28:0x0042), top: B:43:0x000f, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x005a A[RETURN] */
    public static boolean zza(Context context) {
        boolean z;
        if (zzb() && !zzb) {
            synchronized (zzcc.class) {
                if (!zzb) {
                    int i = 1;
                    while (true) {
                        if (i <= 2) {
                            if (zza == null) {
                                zza = (UserManager) context.getSystemService(UserManager.class);
                            }
                            UserManager userManager = zza;
                            if (userManager == null) {
                                z = true;
                            } else {
                                try {
                                    if (userManager.isUserUnlocked() || !userManager.isUserRunning(Process.myUserHandle())) {
                                        z = true;
                                    }
                                    if (z) {
                                        zza = null;
                                    }
                                } catch (NullPointerException e) {
                                    Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e);
                                    zza = null;
                                    i++;
                                }
                            }
                            if (z) {
                                zzb = true;
                            }
                            if (!z) {
                                return true;
                            }
                        }
                        z = false;
                        if (z) {
                            zza = null;
                        }
                        if (z) {
                            zzb = true;
                        }
                        if (!z) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
