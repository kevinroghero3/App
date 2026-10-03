package com.transistorsoft.locationmanager.util;

import android.content.Context;
import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class BuildConfigUtils {
    private static Class<?> a = null;
    private static int artificialFrame = 1;
    private static final AtomicBoolean b;
    private static final String c = "BuildConfig";
    private static byte extraCallback;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

    static {
        accessartificialFrame();
        b = new AtomicBoolean(false);
    }

    static Class<?> a(Context context) {
        AtomicBoolean atomicBoolean = b;
        if (!atomicBoolean.get()) {
            synchronized (atomicBoolean) {
                Class<?> clsC = c(context);
                a = clsC;
                if (clsC != null) {
                    atomicBoolean.set(true);
                }
            }
        }
        return a;
    }

    private static Class<?> c(Context context) {
        Class<?> cls;
        synchronized (BuildConfigUtils.class) {
            String strB = b(context);
            try {
                cls = Class.forName(strB + "." + c);
            } catch (ClassNotFoundException e) {
                String[] strArrSplit = strB.split("\\.");
                String strJoinString = Util.joinString(Arrays.asList((String[]) Arrays.copyOf(strArrSplit, strArrSplit.length - 1)), ".");
                try {
                    return Class.forName(strJoinString + "." + c);
                } catch (ClassNotFoundException unused) {
                    TSLog.logger.error(TSLog.error("Failed to deduce Application's BuildConfig class for package name:" + b(context) + " or " + strJoinString));
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return cls;
    }

    public static String getBuildConfigPackageName(Context context) {
        Class<?> clsA = a(context);
        return (clsA == null || clsA.getPackage() == null) ? context.getPackageName() : clsA.getPackage().getName();
    }

    public static Object getBuildConfigValue(Context context, String str) {
        return a(context, str);
    }

    private static String b(Context context) {
        int i = 2 % 2;
        int i2 = artificialFrame + 53;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        Object obj = null;
        if (i2 % 2 != 0) {
            context.getResources().getIdentifier("build_config_package", TypedValues.Custom.S_STRING, context.getPackageName());
            obj.hashCode();
            throw null;
        }
        int identifier = context.getResources().getIdentifier("build_config_package", TypedValues.Custom.S_STRING, context.getPackageName());
        if (identifier == 0) {
            return context.getPackageName();
        }
        String string = context.getString(identifier);
        if (string.startsWith(".,.%")) {
            int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 9;
            artificialFrame = i3 % 128;
            if (i3 % 2 == 0) {
                Object[] objArr = new Object[1];
                d(string.substring(4), objArr);
                ((String) objArr[0]).intern();
                obj.hashCode();
                throw null;
            }
            Object[] objArr2 = new Object[1];
            d(string.substring(4), objArr2);
            string = ((String) objArr2[0]).intern();
        }
        int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
        artificialFrame = i4 % 128;
        if (i4 % 2 != 0) {
            return string;
        }
        obj.hashCode();
        throw null;
    }

    private static Object a(Context context, String str) {
        try {
            return a(context).getField(str).get(null);
        } catch (IllegalAccessException e) {
            TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
            return null;
        } catch (NoSuchFieldException e2) {
            TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
            return null;
        }
    }

    private static void d(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    static void accessartificialFrame() {
        extraCallback = (byte) -124;
    }
}
