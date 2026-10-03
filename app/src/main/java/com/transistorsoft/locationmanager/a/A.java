package com.transistorsoft.locationmanager.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.util.TSNotification;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class A {
    private static Context a;
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static Handler d;
    private static final AtomicBoolean e;
    private static final AtomicBoolean f;

    static {
        System.loadLibrary("tslocationmanager");
        e = new AtomicBoolean(false);
        f = new AtomicBoolean(false);
    }

    private static String a() {
        return j();
    }

    public static native boolean a(String str, String str2, boolean z);

    public static native boolean b();

    private static boolean b(String str, String str2, boolean z) {
        return a(str, str2, z);
    }

    public static native String c();

    public static void c(Context context) {
        d(context);
    }

    public static native String d();

    public static boolean d(Context context) {
        if (!b.compareAndSet(false, true)) {
            return t();
        }
        boolean zF = f(context);
        if (zF) {
            e(context);
        }
        return zF;
    }

    public static native String e();

    private static void e(Context context) {
        String packageName = context.getPackageName();
        for (String str : getAccessories()) {
            String strA = a(context, str);
            if (strA != null) {
                boolean zValidateAccessory = validateAccessory(packageName, str, strA);
                if (!zValidateAccessory) {
                    String[] strArrSplit = packageName.split("\\.");
                    if (Arrays.asList(a().split(",")).contains(strArrSplit[strArrSplit.length - 1])) {
                        packageName = a((List<String>) Arrays.asList((String[]) Arrays.copyOf(strArrSplit, strArrSplit.length - 1)), ".");
                        if (validateAccessory(packageName, str, strA)) {
                            zValidateAccessory = true;
                        }
                    }
                }
                if (!zValidateAccessory) {
                    a(context, r(), str + ": " + strA);
                }
            }
        }
    }

    public static native String f();

    private static boolean f(Context context) {
        a = context;
        String packageName = context.getPackageName();
        String strA = a(context);
        boolean zB = b(context);
        s();
        if (strA == null) {
            a(context, r(), p().replace("{NAME}", m()));
            return b(packageName, "", true);
        }
        try {
            if (b(packageName, strA, true)) {
                return true;
            }
            String[] strArrSplit = packageName.split("\\.");
            if (Arrays.asList(a().split(",")).contains(strArrSplit[strArrSplit.length - 1]) && b(a((List<String>) Arrays.asList((String[]) Arrays.copyOf(strArrSplit, strArrSplit.length - 1)), "."), strA, true)) {
                return true;
            }
        } catch (Exception e2) {
            Log.e("TSLocationManager", TSLog.error(r() + ":" + e2.getMessage()));
        }
        a(context, r(), l() + ": " + strA);
        if (!zB) {
            b.set(false);
        }
        return false;
    }

    public static native String g();

    public static native String[] getAccessories();

    public static boolean getDBFlag() {
        Context context = a;
        if (context != null) {
            return b(context);
        }
        return false;
    }

    public static native String getPlatform();

    public static native String h();

    public static native String i();

    public static native String j();

    private static String k() {
        return i();
    }

    private static String l() {
        return g();
    }

    private static String m() {
        return c();
    }

    private static String n() {
        return e();
    }

    private static String o() {
        return d();
    }

    private static String p() {
        return h();
    }

    public static Handler q() {
        if (d == null) {
            d = new Handler(Looper.getMainLooper());
        }
        return d;
    }

    private static String r() {
        return f();
    }

    private static void s() {
        b.set(true);
    }

    private static boolean t() {
        return b() && e.get() && f.get();
    }

    public static native boolean validateAccessory(String str, String str2, String str3);

    private static String a(Context context, String str) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null && bundle.containsKey(str)) {
                return bundle.getString(str);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static boolean b(Context context) {
        try {
            return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) == 2;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void r(boolean z) {
        e.set(z);
        f.set(true);
    }

    private static String a(Context context) {
        String string;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            if (bundle.containsKey(m())) {
                string = bundle.getString(m());
            } else {
                string = bundle.containsKey(n()) ? bundle.getString(n()) : null;
            }
            if (string == null) {
                return null;
            }
            c.set(true);
            return string;
        } catch (PackageManager.NameNotFoundException e2) {
            a(context, r(), e2.getMessage());
            return null;
        }
    }

    private static void a(Context context, String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(TSLog.header(str + ": " + context.getPackageName()));
        stringBuffer.append(TSLog.boxRow(str2));
        if (b(context)) {
            stringBuffer.append(TSLog.boxRow(k()));
        }
        stringBuffer.append(TSLog.BOX_BOTTOM);
        Log.e("TSLocationManager", stringBuffer.toString());
        q().post(new TSNotification(context, str, str2));
    }

    private static String a(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str2 : list) {
            if (z) {
                z = false;
            } else {
                sb.append(str);
            }
            sb.append(str2);
        }
        return sb.toString();
    }
}
