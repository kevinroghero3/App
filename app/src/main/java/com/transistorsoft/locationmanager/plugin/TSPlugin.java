package com.transistorsoft.locationmanager.plugin;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TSPlugin {
    public static final int FIREBASE = 1;
    private static final Map<Integer, String> b;
    private static TSPlugin c;
    private AtomicBoolean a = new AtomicBoolean(false);

    static {
        HashMap map = new HashMap();
        b = map;
        System.loadLibrary("tslocationmanager");
        map.put(1, h());
    }

    private String a(Context context, String str) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
            if (string == null) {
                return null;
            }
            return string;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private void b(Context context, String str) {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod("subscribe", null).invoke(cls.getMethod("getInstance", Context.class).invoke(cls, context), null);
        } catch (ClassNotFoundException e) {
            Log.e("TSLocationManager", e.toString());
        } catch (IllegalAccessException e2) {
            Log.e("TSLocationManager", e2.toString());
        } catch (NoSuchMethodException e3) {
            Log.e("TSLocationManager", e3.toString());
        } catch (InvocationTargetException e4) {
            Log.e("TSLocationManager", e4.toString());
        } catch (Exception e5) {
            Log.e("TSLocationManager", e5.toString());
        }
    }

    private boolean c(Context context, String str) {
        String packageName = context.getPackageName();
        String strA = a(context, str);
        if (strA == null) {
            a(m() + " - " + str, "\n" + k().replace("{NAME}", e()));
            return false;
        }
        try {
            if (b(packageName, str, strA)) {
                return true;
            }
            String[] strArrSplit = packageName.split("\\.");
            if (Arrays.asList(a().split(",")).contains(strArrSplit[strArrSplit.length - 1])) {
                packageName = a((List<String>) Arrays.asList((String[]) Arrays.copyOf(strArrSplit, strArrSplit.length - 1)), ".");
                if (b(packageName, str, strA)) {
                    return true;
                }
            }
        } catch (Exception unused) {
            TSLog.logger.error(TSLog.error(m()));
        }
        a(m() + " - " + str, packageName);
        return false;
    }

    private String e() {
        return b();
    }

    public static TSPlugin getInstance() {
        if (c == null) {
            c = j();
        }
        return c;
    }

    private static String h() {
        return i();
    }

    public static native String i();

    private static TSPlugin j() {
        TSPlugin tSPlugin;
        synchronized (TSPlugin.class) {
            if (c == null) {
                c = new TSPlugin();
            }
            tSPlugin = c;
        }
        return tSPlugin;
    }

    private String k() {
        return g();
    }

    private String l() {
        return c();
    }

    private String m() {
        return f();
    }

    public native boolean a(String str, String str2, String str3);

    public native String b();

    public native String c();

    public boolean canUsePersistEvent(Context context) {
        if (this.a.get()) {
            return true;
        }
        int pluginForEvent = TSConfig.getInstance(context).getPluginForEvent(l());
        if (pluginForEvent > 0) {
            String strE = pluginForEvent != 1 ? null : e();
            if (strE != null) {
                this.a.set(c(context, strE));
            }
        }
        if (!this.a.get() && a(context)) {
            this.a.set(true);
        }
        return this.a.get();
    }

    public native String d();

    public native String f();

    public native String g();

    public void register(Context context, int i) {
        if (i != 1) {
            return;
        }
        TSConfig.getInstance(context).setPluginForEvent(1, l());
        canUsePersistEvent(context);
    }

    public void subscribe(Context context, JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                b(context, b.get(Integer.valueOf(jSONObject.getInt(itKeys.next()))));
            } catch (JSONException e) {
                TSLog.logger.debug(e.getMessage(), (Throwable) e);
                e.printStackTrace();
            }
        }
    }

    private boolean a(Context context) {
        try {
            return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) == 2;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private void a(String str, String str2) {
        TSLog.logger.error(TSLog.error(str + ": " + str2));
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

    private String a() {
        return d();
    }

    private boolean b(String str, String str2, String str3) {
        return a(str, str2, str3);
    }
}
