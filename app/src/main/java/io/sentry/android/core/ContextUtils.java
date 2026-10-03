package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.DisplayMetrics;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.util.AndroidLazyEvaluator;
import io.sentry.protocol.App;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ContextUtils {
    private static final AndroidLazyEvaluator<String> applicationName;
    private static int artificialFrame = 1;
    private static byte extraCallback;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final AndroidLazyEvaluator<ApplicationInfo> staticAppInfo;
    private static final AndroidLazyEvaluator<ApplicationInfo> staticAppInfo33;
    private static final AndroidLazyEvaluator<PackageInfo> staticPackageInfo;
    private static final AndroidLazyEvaluator<PackageInfo> staticPackageInfo33;

    private static void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class SideLoadedInfo {
        private final String installerStore;
        private final boolean isSideLoaded;

        public SideLoadedInfo(boolean z, @Nullable String str) {
            this.isSideLoaded = z;
            this.installerStore = str;
        }

        public boolean isSideLoaded() {
            return this.isSideLoaded;
        }

        public String getInstallerStore() {
            return this.installerStore;
        }

        public Map<String, String> asTags() {
            HashMap map = new HashMap();
            map.put("isSideLoaded", String.valueOf(this.isSideLoaded));
            String str = this.installerStore;
            if (str != null) {
                map.put("installerStore", str);
            }
            return map;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class SplitApksInfo {
        static final String SPLITS_REQUIRED = "com.android.vending.splits.required";
        private final boolean isSplitApks;
        private final String[] splitNames;

        public SplitApksInfo(boolean z, String[] strArr) {
            this.isSplitApks = z;
            this.splitNames = strArr;
        }

        public boolean isSplitApks() {
            return this.isSplitApks;
        }

        public String[] getSplitNames() {
            return this.splitNames;
        }
    }

    private ContextUtils() {
    }

    static {
        accessartificialFrame();
        staticPackageInfo33 = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda5
            @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
            public final Object evaluate(Context context) {
                return ContextUtils.lambda$static$0(context);
            }
        });
        staticPackageInfo = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda6
            @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
            public final Object evaluate(Context context) {
                return ContextUtils.lambda$static$1(context);
            }
        });
        applicationName = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda7
            @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
            public final Object evaluate(Context context) {
                return ContextUtils.lambda$static$2(context);
            }
        });
        staticAppInfo33 = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda8
            @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
            public final Object evaluate(Context context) {
                return ContextUtils.lambda$static$3(context);
            }
        });
        staticAppInfo = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda9
            @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
            public final Object evaluate(Context context) {
                return ContextUtils.lambda$static$4(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PackageInfo lambda$static$0(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PackageInfo lambda$static$1(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$2(Context context) {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i4 = applicationInfo.labelRes;
            if (i4 == 0) {
                CharSequence charSequence = applicationInfo.nonLocalizedLabel;
                if (charSequence != null) {
                    return charSequence.toString();
                }
                return context.getPackageManager().getApplicationLabel(applicationInfo).toString();
            }
            String string = context.getString(i4);
            if (!(!string.startsWith(".,.%"))) {
                Object[] objArr = new Object[1];
                a(string.substring(4), objArr);
                string = ((String) objArr[0]).intern();
                int i5 = artificialFrame + 117;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                int i6 = i5 % 2;
            }
            return string;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ApplicationInfo lambda$static$3(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ApplicationInfo lambda$static$4(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable unused) {
            return null;
        }
    }

    static PackageInfo getPackageInfo(@NotNull Context context, @NotNull BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            return staticPackageInfo33.getValue(context);
        }
        return staticPackageInfo.getValue(context);
    }

    static PackageInfo getPackageInfo(@NotNull Context context, int i, @NotNull ILogger iLogger, @NotNull BuildInfoProvider buildInfoProvider) {
        try {
            if (buildInfoProvider.getSdkInfoVersion() >= 33) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(i));
            }
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i);
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting package info.", th);
            return null;
        }
    }

    static ApplicationInfo getApplicationInfo(@NotNull Context context, @NotNull BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            return staticAppInfo33.getValue(context);
        }
        return staticAppInfo.getValue(context);
    }

    static String getVersionCode(@NotNull PackageInfo packageInfo, @NotNull BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return getVersionCodeDep(packageInfo);
    }

    static String getVersionName(@NotNull PackageInfo packageInfo) {
        return packageInfo.versionName;
    }

    private static String getVersionCodeDep(@NotNull PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }

    public static boolean isForegroundImportance() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            return runningAppProcessInfo.importance == 100;
        } catch (Throwable unused) {
        }
    }

    public static boolean appIsLibraryForComposePreview(@NotNull Context context) {
        if (!context.getPackageName().endsWith(".test")) {
            return false;
        }
        try {
            Iterator<ActivityManager.AppTask> it2 = ((ActivityManager) context.getSystemService("activity")).getAppTasks().iterator();
            while (it2.hasNext()) {
                ComponentName component = it2.next().getTaskInfo().baseIntent.getComponent();
                if (component != null && component.getClassName().equals("androidx.compose.ui.tooling.PreviewActivity")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    static String getKernelVersion(@NotNull ILogger iLogger) {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                return line;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            iLogger.log(SentryLevel.ERROR, "Exception while attempting to read kernel information", e);
            return property;
        }
    }

    static SideLoadedInfo retrieveSideLoadedInfo(@NotNull Context context, @NotNull ILogger iLogger, @NotNull BuildInfoProvider buildInfoProvider) {
        String str;
        try {
            PackageInfo packageInfo = getPackageInfo(context, buildInfoProvider);
            PackageManager packageManager = context.getPackageManager();
            if (packageInfo != null && packageManager != null) {
                str = packageInfo.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    return new SideLoadedInfo(installerPackageName == null, installerPackageName);
                } catch (IllegalArgumentException unused) {
                    iLogger.log(SentryLevel.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
        }
        return null;
    }

    static SplitApksInfo retrieveSplitApksInfo(@NotNull Context context, @NotNull BuildInfoProvider buildInfoProvider) {
        Bundle bundle;
        ApplicationInfo applicationInfo = getApplicationInfo(context, buildInfoProvider);
        PackageInfo packageInfo = getPackageInfo(context, buildInfoProvider);
        if (packageInfo == null) {
            return null;
        }
        return new SplitApksInfo((applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? false : bundle.getBoolean("com.android.vending.splits.required"), packageInfo.splitNames);
    }

    static String getApplicationName(@NotNull Context context) {
        return applicationName.getValue(context);
    }

    static DisplayMetrics getDisplayMetrics(@NotNull Context context, @NotNull ILogger iLogger) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting DisplayMetrics.", th);
            return null;
        }
    }

    static String getFamily(@NotNull ILogger iLogger) {
        try {
            return Build.MODEL.split(StringUtils.SPACE, -1)[0];
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting device family.", th);
            return null;
        }
    }

    static String[] getArchitectures() {
        return Build.SUPPORTED_ABIS;
    }

    static ActivityManager.MemoryInfo getMemInfo(@NotNull Context context, @NotNull ILogger iLogger) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager == null) {
                iLogger.log(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
                return null;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    static Intent registerReceiver(@NotNull Context context, @NotNull SentryOptions sentryOptions, @Nullable BroadcastReceiver broadcastReceiver, @NotNull IntentFilter intentFilter, @Nullable Handler handler) {
        return registerReceiver(context, new BuildInfoProvider(sentryOptions.getLogger()), broadcastReceiver, intentFilter, handler);
    }

    static Intent registerReceiver(@NotNull Context context, @NotNull BuildInfoProvider buildInfoProvider, @Nullable BroadcastReceiver broadcastReceiver, @NotNull IntentFilter intentFilter, @Nullable Handler handler) {
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, null, handler, 4);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, null, handler);
    }

    static void setAppPackageInfo(@NotNull PackageInfo packageInfo, @NotNull BuildInfoProvider buildInfoProvider, @Nullable DeviceInfoUtil deviceInfoUtil, @NotNull App app2) {
        app2.setAppIdentifier(packageInfo.packageName);
        app2.setAppVersion(packageInfo.versionName);
        app2.setAppBuild(getVersionCode(packageInfo, buildInfoProvider));
        HashMap map = new HashMap();
        String[] strArr = packageInfo.requestedPermissions;
        int[] iArr = packageInfo.requestedPermissionsFlags;
        if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                map.put(str.substring(str.lastIndexOf(46) + 1), (iArr[i] & 2) == 2 ? "granted" : "not_granted");
            }
        }
        app2.setPermissions(map);
        if (deviceInfoUtil != null) {
            try {
                SplitApksInfo splitApksInfo = deviceInfoUtil.getSplitApksInfo();
                if (splitApksInfo != null) {
                    app2.setSplitApks(Boolean.valueOf(splitApksInfo.isSplitApks()));
                    if (splitApksInfo.getSplitNames() != null) {
                        app2.setSplitNames(Arrays.asList(splitApksInfo.getSplitNames()));
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Context getApplicationContext(@NotNull Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    static void resetInstance() {
        staticPackageInfo33.resetValue();
        staticPackageInfo.resetValue();
        applicationName.resetValue();
        staticAppInfo33.resetValue();
        staticAppInfo.resetValue();
    }

    static void accessartificialFrame() {
        extraCallback = (byte) -124;
    }
}
