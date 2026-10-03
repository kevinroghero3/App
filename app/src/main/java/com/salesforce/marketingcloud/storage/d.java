package com.salesforce.marketingcloud.storage;

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

/* JADX INFO: loaded from: classes3.dex */
public class d {
    final File b;
    private final Context d;
    private final SharedPreferences e;
    private final String f;
    private final com.salesforce.marketingcloud.internal.n g;
    private String h;
    final Object a = new Object();
    private final Object c = new Object();
    private boolean i = false;

    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            d.this.b();
        }
    }

    class b extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.c = str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r2v7 */
        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            ?? fileOutputStream;
            Throwable th;
            ?? r2;
            synchronized (d.this.a) {
                ?? r1 = 0;
                ?? r3 = 0;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(d.this.b);
                        try {
                            String str = this.c;
                            fileOutputStream.write(str != null ? str.getBytes(com.salesforce.marketingcloud.util.j.b) : new byte[0]);
                            String str2 = l.f;
                            com.salesforce.marketingcloud.g.d(str2, "Gdpr mode [%s] written to file.", this.c);
                            r1 = str2;
                            r2 = fileOutputStream;
                        } catch (Exception unused) {
                            r3 = fileOutputStream;
                            com.salesforce.marketingcloud.g.b(l.f, "Failed to write gdpr mode to file: ", d.this.b.getAbsolutePath());
                            r2 = r3;
                            r1 = r3;
                        } catch (Throwable th2) {
                            th = th2;
                            com.salesforce.marketingcloud.util.e.a((Closeable) fileOutputStream);
                            throw th;
                        }
                    } catch (Exception unused2) {
                    }
                    com.salesforce.marketingcloud.util.e.a((Closeable) r2);
                } catch (Throwable th3) {
                    fileOutputStream = r1;
                    th = th3;
                }
            }
        }
    }

    d(Context context, SharedPreferences sharedPreferences, String str, com.salesforce.marketingcloud.internal.n nVar) {
        this.d = context;
        this.e = sharedPreferences;
        this.g = nVar;
        String str2 = str + "_SFMC_PrivacyMode";
        this.f = str2;
        this.b = new File(context.getNoBackupFilesDir(), str2);
        c();
    }

    private static String a(@NonNull File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String line = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    line = new BufferedReader(new InputStreamReader(fileInputStream, com.salesforce.marketingcloud.util.j.b)).readLine();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    com.salesforce.marketingcloud.util.e.a((Closeable) fileInputStream2);
                    throw th;
                }
            } catch (Exception unused) {
                com.salesforce.marketingcloud.g.b(l.f, "Failed to read gdpr mode from file: ", file.getAbsolutePath());
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.salesforce.marketingcloud.util.e.a((Closeable) fileInputStream2);
            throw th;
        }
        com.salesforce.marketingcloud.util.e.a((Closeable) fileInputStream);
        return line;
    }

    private void c() {
        synchronized (this.c) {
            this.i = false;
        }
        new a("gdpr_file_load").start();
    }

    void b() throws Throwable {
        synchronized (this.c) {
            if (this.i) {
                return;
            }
            String string = null;
            if (this.b.exists()) {
                String strA = a(this.b);
                if (!TextUtils.isEmpty(strA)) {
                    string = strA;
                }
            } else {
                String str = l.f;
                com.salesforce.marketingcloud.g.a(str, "Checking SharedPreferences for gdpr mode", new Object[0]);
                string = this.e.getString("cc_state", null);
                if (string != null) {
                    this.e.edit().remove("cc_state").apply();
                } else {
                    com.salesforce.marketingcloud.g.a(str, "Checking pre-lollipop location for gdpr mode", new Object[0]);
                    File file = new File(this.d.getFilesDir(), this.f);
                    if (file.exists()) {
                        string = a(file);
                        com.salesforce.marketingcloud.util.e.b(file);
                    }
                }
                c(string);
            }
            synchronized (this.c) {
                this.h = string;
                this.i = true;
                this.c.notifyAll();
            }
        }
    }

    void c(@Nullable String str) {
        this.g.b().execute(new b("storing_gdpr", new Object[0], str));
    }

    public String a(@Nullable String str) {
        synchronized (this.c) {
            a();
            String str2 = this.h;
            if (str2 != null) {
                str = str2;
            }
        }
        return str;
    }

    private void a() {
        while (!this.i) {
            try {
                this.c.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void b(@Nullable String str) {
        synchronized (this.c) {
            com.salesforce.marketingcloud.g.d(l.f, "Updating gdpr mode: %s", str);
            this.h = str;
            c(str);
        }
    }
}
