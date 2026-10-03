package com.salesforce.marketingcloud.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public class i implements Closeable {
    private static final byte f = 13;
    private static final byte g = 10;
    final Charset a;
    private final InputStream b;
    private byte[] c;
    private int d;
    private int e;

    class a extends ByteArrayOutputStream {
        a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0) {
                int i2 = i - 1;
                if (((ByteArrayOutputStream) this).buf[i2] == 13) {
                    i = i2;
                }
            }
            return new String(((ByteArrayOutputStream) this).buf, 0, i, i.this.a);
        }
    }

    public i(InputStream inputStream) {
        this(inputStream, 8192);
    }

    private void a() throws IOException {
        InputStream inputStream = this.b;
        byte[] bArr = this.c;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = i;
    }

    public boolean b() {
        return this.e == -1;
    }

    public int c() throws IOException {
        String strD = d();
        try {
            return Integer.parseInt(strD);
        } catch (NumberFormatException unused) {
            throw new IOException("expected an int but was \"" + strD + "\"");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.b) {
            if (this.c != null) {
                this.c = null;
                this.b.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public String d() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.b) {
            if (this.c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.d >= this.e) {
                a();
            }
            for (int i3 = this.d; i3 != this.e; i3++) {
                byte[] bArr2 = this.c;
                if (bArr2[i3] == 10) {
                    int i4 = this.d;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    String str = new String(bArr2, i4, i2 - i4, this.a);
                    this.d = i3 + 1;
                    return str;
                }
            }
            a aVar = new a((this.e - this.d) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.c;
                int i5 = this.d;
                aVar.write(bArr3, i5, this.e - i5);
                this.e = -1;
                a();
                i = this.d;
                while (i != this.e) {
                    bArr = this.c;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.d;
            if (i != i6) {
                aVar.write(bArr, i6, i - i6);
            }
            this.d = i + 1;
            return aVar.toString();
        }
    }

    public i(InputStream inputStream, int i) {
        this(inputStream, i, e.a);
    }

    public i(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public i(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        }
        if (charset == null) {
            throw new NullPointerException("charset == null");
        }
        if (i >= 0) {
            if (!charset.equals(e.a) && !charset.equals(e.c) && !charset.equals(e.b)) {
                throw new IllegalArgumentException("Unsupported encoding");
            }
            this.b = inputStream;
            this.a = charset;
            this.c = new byte[i];
            return;
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
