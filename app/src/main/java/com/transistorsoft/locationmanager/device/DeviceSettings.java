package com.transistorsoft.locationmanager.device;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import com.transistorsoft.locationmanager.event.PowerSaveModeChangeEvent;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.util.Calendar;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class DeviceSettings {
    public static final String IGNORE_BATTERY_OPTIMIZATION = "IGNORE_BATTERY_OPTIMIZATIONS";
    public static final String POWER_MANAGER = "POWER_MANAGER";
    private static final String b = "DeviceSettings";
    private static final String d = "huawei.intent.action.POWER_MODE_CHANGED_ACTION";
    private static final int e = 2;
    private static final int f = 1;
    private static final String g = "SmartModeStatus";
    private static final int h = 4;
    private BroadcastReceiver a;
    private static Intent[] c = {new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity")), new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")), new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity")), new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager")), new Intent().setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")), new Intent().setComponent(new ComponentName("com.samsung.android.lool", "com.samsung.android.sm.battery.ui.BatteryActivity")), new Intent().setComponent(new ComponentName("com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity")), new Intent().setComponent(new ComponentName("com.htc.pitroad", "com.htc.pitroad.landingpage.activity.LandingPageActivity")), new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.MainActivity")), new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.entry.FunctionActivity")).setData(Uri.parse("mobilemanager://function/entry/AutoStart")), new Intent().setComponent(new ComponentName("com.transsion.phonemanager", "com.itel.autobootmanager.activity.AutoBootMgrActivity")), new Intent().setComponent(new ComponentName("com.dewav.dwappmanager", "com.dewav.dwappmanager.memory.SmartClearupWhiteList"))};
    private static DeviceSettings i = null;

    /* JADX INFO: loaded from: classes3.dex */
    static class a extends BroadcastReceiver {
        a() {
        }

        /* JADX WARN: Code duplicated, block: B:18:0x008b  */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean zIsPowerSaveMode;
            if (intent.getAction().equals(DeviceSettings.d)) {
                Bundle extras = intent.getExtras();
                TSLog.logger.debug(TSLog.info(DeviceInfo.MANUFACTURER_HUAWEI + " detected: " + intent));
                if (extras == null || !extras.containsKey("state")) {
                    zIsPowerSaveMode = false;
                } else {
                    for (String str : extras.keySet()) {
                        TSLog.logger.debug("[extras] " + str + ": " + extras.get(str));
                    }
                    int i = intent.getExtras().getInt("state");
                    zIsPowerSaveMode = true;
                    if (i != 1) {
                        zIsPowerSaveMode = false;
                    }
                }
            } else {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    zIsPowerSaveMode = powerManager.isPowerSaveMode();
                } else {
                    zIsPowerSaveMode = false;
                }
            }
            TSLog.logger.info(zIsPowerSaveMode ? TSLog.on("PowerSaveMode") : TSLog.off("PowerSaveMode"));
            EventBus.getDefault().post(new PowerSaveModeChangeEvent(Boolean.valueOf(zIsPowerSaveMode)));
        }
    }

    private DeviceSettings() {
    }

    private Intent a(Context context, String str) {
        Intent intentA;
        if (str.equalsIgnoreCase(IGNORE_BATTERY_OPTIMIZATION)) {
            intentA = a();
        } else {
            intentA = str.equalsIgnoreCase(POWER_MANAGER) ? a(context) : null;
        }
        if (intentA == null || context.getPackageManager().resolveActivity(intentA, 65536) == null) {
            return null;
        }
        intentA.setFlags(268435456);
        return intentA;
    }

    private static DeviceSettings b() {
        DeviceSettings deviceSettings;
        synchronized (DeviceSettings.class) {
            if (i == null) {
                i = new DeviceSettings();
            }
            deviceSettings = i;
        }
        return deviceSettings;
    }

    private Boolean c(Context context) {
        TSLog.logger.info(TSLog.info("[isPowerSaveMode] " + DeviceInfo.MANUFACTURER_HUAWEI + " detected"));
        try {
            return Boolean.valueOf(Settings.System.getInt(context.getContentResolver(), g) == 4);
        } catch (Settings.SettingNotFoundException unused) {
            TSLog.logger.warn(TSLog.warn(DeviceInfo.MANUFACTURER_HUAWEI + " System setting '" + g + "' not found"));
            return b(context);
        }
    }

    public static DeviceSettings getInstance() {
        if (i == null) {
            i = b();
        }
        return i;
    }

    public Boolean isPowerSaveMode(Context context) {
        return Build.MANUFACTURER.equalsIgnoreCase(DeviceInfo.MANUFACTURER_HUAWEI) ? c(context) : b(context);
    }

    public DeviceSettingsRequest request(Context context, String str) {
        if (a(context, str) != null) {
            return new DeviceSettingsRequest(str, b(context, str));
        }
        TSLog.logger.debug(TSLog.info("Failed to find " + str + " screen for device " + Build.MANUFACTURER + StringUtils.SPACE + Build.MODEL + "@" + Build.VERSION.RELEASE));
        return null;
    }

    public void setPowermanagerIntents(Intent[] intentArr) {
        c = intentArr;
    }

    public boolean show(Context context, String str) {
        Intent intentA = a(context, str);
        if (intentA != null) {
            c(context, str);
            try {
                context.startActivity(intentA);
                return true;
            } catch (SecurityException e2) {
                TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
                return false;
            }
        }
        TSLog.logger.debug(TSLog.info("Failed to find " + str + " screen for device " + Build.MANUFACTURER + StringUtils.SPACE + Build.MODEL + "@" + Build.VERSION.RELEASE));
        return false;
    }

    public void startMonitoringPowerSaveChanges(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        TSLog.logger.debug(TSLog.on("Start monitoring powersave changes"));
        if (this.a != null) {
            return;
        }
        this.a = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        intentFilter.addAction(d);
        intentFilter.addAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        if (i2 >= 26) {
            context.registerReceiver(this.a, intentFilter, 4);
        } else {
            context.registerReceiver(this.a, intentFilter);
        }
    }

    public void stopMonitoringPowerSaveChanges(Context context) {
        if (this.a != null) {
            TSLog.logger.debug(TSLog.off("Stop monitoring powersave changes"));
            try {
                context.unregisterReceiver(this.a);
            } catch (IllegalArgumentException e2) {
                TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
            }
            this.a = null;
        }
    }

    private Boolean b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return Boolean.valueOf(powerManager != null ? powerManager.isPowerSaveMode() : false);
    }

    public Boolean isIgnoringBatteryOptimization(Context context) {
        return Boolean.valueOf(((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName()));
    }

    private long b(Context context, String str) {
        return context.getSharedPreferences("TSLocationManagerDeviceSettings", 0).getLong(str, 0L);
    }

    private void c(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("TSLocationManagerDeviceSettings", 0).edit();
        editorEdit.putLong(str, Calendar.getInstance().getTime().getTime());
        editorEdit.apply();
    }

    private Intent a() {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        return intent;
    }

    private Intent a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        for (Intent intent : c) {
            if (packageManager.resolveActivity(intent, 65536) != null) {
                return intent;
            }
        }
        return null;
    }
}
