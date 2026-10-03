package com.salesforce.marketingcloud.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static final String a = com.salesforce.marketingcloud.g.a("DeviceData");
    private static final String b = "SFMCDeviceUUID";
    static volatile String c;

    private c() {
    }

    public static String a(@NonNull Context context, @Nullable String str) {
        if (c == null) {
            synchronized (c.class) {
                c = b(context, str);
            }
        }
        return c;
    }

    private static String b(@NonNull Context context, @Nullable String str) throws Throwable {
        File file = new File(context.getNoBackupFilesDir(), b);
        String strA = file.exists() ? a(file) : null;
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String str2 = a;
        com.salesforce.marketingcloud.g.a(str2, "Checking SharedPreferences for deviceId", new Object[0]);
        String strA2 = a(context);
        if (TextUtils.isEmpty(strA2)) {
            com.salesforce.marketingcloud.g.a(str2, "Checking pre-lollipop location for deviceId", new Object[0]);
            File file2 = new File(context.getFilesDir(), b);
            if (file2.exists()) {
                strA2 = a(file2);
                e.b(file2);
            }
        }
        if (!TextUtils.isEmpty(strA2)) {
            str = strA2;
        } else if (str != null) {
            com.salesforce.marketingcloud.g.a(str2, "Using registrationId as deviceId", new Object[0]);
        } else {
            com.salesforce.marketingcloud.g.a(str2, "Generating/Storing new deviceId", new Object[0]);
            str = a();
        }
        a(file, str);
        return str;
    }

    private static String a(@NonNull File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String line = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    line = new BufferedReader(new InputStreamReader(fileInputStream, j.b)).readLine();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    e.a((Closeable) fileInputStream2);
                    throw th;
                }
            } catch (Exception unused) {
                com.salesforce.marketingcloud.g.b(a, "Failed to read device id from file: ", file.getAbsolutePath());
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            e.a((Closeable) fileInputStream2);
            throw th;
        }
        e.a((Closeable) fileInputStream);
        return line;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static void a(File file, String str) throws Throwable {
        ?? fileOutputStream;
        ?? r1;
        ?? r0 = 0;
        ?? r2 = 0;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    Charset charset = j.b;
                    fileOutputStream.write(str.getBytes(charset));
                    r0 = charset;
                    r1 = fileOutputStream;
                } catch (Exception unused) {
                    r2 = fileOutputStream;
                    com.salesforce.marketingcloud.g.b(a, "Failed to write device id to file: ", file.getAbsolutePath());
                    r1 = r2;
                    r0 = r2;
                } catch (Throwable th) {
                    th = th;
                    e.a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            }
            e.a((Closeable) r1);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = r0;
        }
    }

    private static String a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("_et_default_shared_preferences", 0);
        String string = sharedPreferences.getString("id", null);
        if (string != null) {
            sharedPreferences.edit().remove("id").apply();
        }
        return string;
    }

    private static String a() {
        return j.a(String.format(Locale.ENGLISH, "%s%d", UUID.randomUUID().toString(), Long.valueOf(System.currentTimeMillis())));
    }
}
