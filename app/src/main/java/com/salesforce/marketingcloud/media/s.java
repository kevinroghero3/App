package com.salesforce.marketingcloud.media;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class s {
    private static final int d = 20971520;
    private final File a;
    private final Object b = new Object();
    private com.salesforce.marketingcloud.util.d c;

    s(File file) {
        this.a = file;
    }

    private static String c(String str) {
        return com.salesforce.marketingcloud.util.j.e(str);
    }

    void a(String str, InputStream inputStream) throws IOException {
        b();
        String strC = c(str);
        synchronized (this.b) {
            com.salesforce.marketingcloud.util.d.c cVarA = this.c.a(strC);
            try {
                com.salesforce.marketingcloud.util.e.a(inputStream, cVarA.c(0));
                cVarA.c();
                com.salesforce.marketingcloud.util.e.a((Closeable) inputStream);
            } catch (Throwable th) {
                com.salesforce.marketingcloud.util.e.a((Closeable) inputStream);
                throw th;
            }
        }
    }

    void b(String str) throws IOException {
        b();
        this.c.d(c(str));
    }

    private void b() throws IOException {
        synchronized (this.b) {
            if (this.c == null) {
                this.c = com.salesforce.marketingcloud.util.d.a(this.a, 0, 1, 20971520L);
                this.b.notifyAll();
            }
        }
    }

    InputStream a(String str) throws IOException {
        InputStream inputStreamA;
        b();
        String strC = c(str);
        synchronized (this.b) {
            com.salesforce.marketingcloud.util.d.e eVarB = this.c.b(strC);
            inputStreamA = eVarB != null ? eVarB.a(0) : null;
        }
        return inputStreamA;
    }

    void a() throws IOException {
        b();
        this.c.c();
    }
}
