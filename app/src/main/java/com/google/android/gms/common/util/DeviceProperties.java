package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import io.sentry.SentryBaseEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceProperties {
    private static Boolean zza;
    private static Boolean zzb;
    private static Boolean zzc;
    private static Boolean zzd;
    private static Boolean zze;
    private static Boolean zzf;
    private static Boolean zzg;
    private static Boolean zzh;
    private static Boolean zzi;
    private static Boolean zzj;
    private static Boolean zzk;
    private static Boolean zzl;
    private static Boolean zzm;
    private static Boolean zzn;

    private DeviceProperties() {
    }

    public static boolean isAuto(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzj == null) {
            zzj = Boolean.valueOf(PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        return zzj.booleanValue();
    }

    public static boolean isBstar(@NonNull Context context) {
        if (zzm == null) {
            zzm = Boolean.valueOf(PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE"));
        }
        return zzm.booleanValue();
    }

    public static boolean isFoldable(@NonNull Context context) {
        if (zzc == null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            zzc = Boolean.valueOf((!PlatformVersion.isAtLeastR() || sensorManager == null || sensorManager.getDefaultSensor(36) == null) ? false : true);
        }
        return zzc.booleanValue();
    }

    public static boolean isLatchsky(@NonNull Context context) {
        if (zzg == null) {
            PackageManager packageManager = context.getPackageManager();
            zzg = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return zzg.booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006f  */
    public static boolean isPhone(@NonNull Context context) {
        boolean z;
        if (zza == null) {
            if (isFoldable(context)) {
                z = true;
            } else {
                if (!isTablet(context) && !isWearable(context) && !zzb(context)) {
                    if (zzi == null) {
                        zzi = Boolean.valueOf(context.getPackageManager().hasSystemFeature("org.chromium.arc"));
                    }
                    if (!zzi.booleanValue() && !isAuto(context) && !isTv(context)) {
                        if (zzl == null) {
                            zzl = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                        }
                        if (!zzl.booleanValue() && !isBstar(context) && !isXr(context)) {
                            z = true;
                        }
                    }
                }
                z = false;
            }
            zza = Boolean.valueOf(z);
        }
        return zza.booleanValue();
    }

    public static boolean isSevenInchTablet(@NonNull Context context) {
        return zzc(context.getResources());
    }

    public static boolean isSidewinder(@NonNull Context context) {
        return zza(context);
    }

    public static boolean isTablet(@NonNull Context context) {
        return isTablet(context.getResources());
    }

    public static boolean isTv(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzk == null) {
            zzk = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return zzk.booleanValue();
    }

    public static boolean isUserBuild() {
        int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return SentryBaseEvent.JsonKeys.USER.equals(Build.TYPE);
    }

    public static boolean isWearable(@NonNull Context context) {
        return zzd(context.getPackageManager());
    }

    public static boolean isWearableWithoutPlayStore(@NonNull Context context) {
        if (isWearable(context) && !PlatformVersion.isAtLeastN()) {
            return true;
        }
        if (zza(context)) {
            return !PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR();
        }
        return false;
    }

    public static boolean isXr(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzn == null) {
            zzn = Boolean.valueOf(packageManager.hasSystemFeature("android.software.xr.immersive"));
        }
        return zzn.booleanValue();
    }

    public static boolean zza(@NonNull Context context) {
        if (zzf == null) {
            zzf = Boolean.valueOf(PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzf.booleanValue();
    }

    public static boolean zzb(@NonNull Context context) {
        if (zzh == null) {
            zzh = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzh.booleanValue();
    }

    public static boolean zzc(@NonNull Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (zzd == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z = true;
            }
            zzd = Boolean.valueOf(z);
        }
        return zzd.booleanValue();
    }

    public static boolean zzd(@NonNull PackageManager packageManager) {
        if (zze == null) {
            zze = Boolean.valueOf(PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return zze.booleanValue();
    }

    public static boolean isTablet(@NonNull Resources resources) {
        if (resources == null) {
            return false;
        }
        if (zzb == null) {
            zzb = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || zzc(resources));
        }
        return zzb.booleanValue();
    }
}
