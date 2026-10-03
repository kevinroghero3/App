package com.transistorsoft.locationmanager.util;

import android.content.Context;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class TSNotification implements Runnable {
    private static final String d = "android.widget.Toast";
    private static final String e = "makeText";
    private static final String f = "show";
    private static final int g = 1;
    private String a;
    private final String b;
    private final Context c;

    public TSNotification(Context context, String str, String str2) {
        this.b = str + "\n" + str2;
        this.c = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Class<?> cls = Class.forName(d);
            cls.getMethod(f, null).invoke(cls.getMethod(e, Context.class, CharSequence.class, Integer.TYPE).invoke(cls, this.c, this.b, 1), null);
        } catch (ClassNotFoundException e2) {
            TSLog.logger.error(TSLog.error(e2.getMessage()));
        } catch (IllegalAccessException e3) {
            TSLog.logger.error(TSLog.error(e3.getMessage()));
        } catch (NoSuchMethodException e4) {
            TSLog.logger.error(TSLog.error(e4.getMessage()));
        } catch (InvocationTargetException e5) {
            TSLog.logger.error(TSLog.error(e5.getMessage()));
        }
    }
}
