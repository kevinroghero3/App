package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Metadata {
    private String appVersionCode;
    private String appVersionName;
    private final Context context;
    private int gmsVersionCode;
    private int iidImplementation = 0;

    public Metadata(Context context) {
        this.context = context;
    }

    public static String getDefaultSenderId(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] strArrSplit = applicationId.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo getPackageInfo(String str) {
        try {
            return this.context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
            sb.append("Failed to find package ");
            sb.append(strValueOf);
            SentryLogcatAdapter.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    private void populateAppVersionInfo() {
        synchronized (this) {
            PackageInfo packageInfo = getPackageInfo(this.context.getPackageName());
            if (packageInfo != null) {
                this.appVersionCode = Integer.toString(packageInfo.versionCode);
                this.appVersionName = packageInfo.versionName;
            }
        }
    }

    public String getAppVersionCode() {
        String str;
        synchronized (this) {
            if (this.appVersionCode == null) {
                populateAppVersionInfo();
            }
            str = this.appVersionCode;
        }
        return str;
    }

    public String getAppVersionName() {
        String str;
        synchronized (this) {
            if (this.appVersionName == null) {
                populateAppVersionInfo();
            }
            str = this.appVersionName;
        }
        return str;
    }

    public int getGmsVersionCode() {
        int i;
        PackageInfo packageInfo;
        synchronized (this) {
            if (this.gmsVersionCode == 0 && (packageInfo = getPackageInfo("com.google.android.gms")) != null) {
                this.gmsVersionCode = packageInfo.versionCode;
            }
            i = this.gmsVersionCode;
        }
        return i;
    }

    public int getIidImplementation() {
        synchronized (this) {
            int i = this.iidImplementation;
            if (i != 0) {
                return i;
            }
            PackageManager packageManager = this.context.getPackageManager();
            if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                SentryLogcatAdapter.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
                return 0;
            }
            int i2 = 1;
            if (!PlatformVersion.isAtLeastO()) {
                Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage("com.google.android.gms");
                List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                    this.iidImplementation = 1;
                    return 1;
                }
            }
            Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
            intent2.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
            if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
                this.iidImplementation = 2;
                return 2;
            }
            SentryLogcatAdapter.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (PlatformVersion.isAtLeastO()) {
                this.iidImplementation = 2;
                i2 = 2;
            } else {
                this.iidImplementation = 1;
            }
            return i2;
        }
    }

    public boolean isGmscorePresent() {
        return getIidImplementation() != 0;
    }
}
