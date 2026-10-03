package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
final class MultiInputStream extends InputStream {

    @CheckForNull
    private InputStream in;

    /* JADX INFO: renamed from: it, reason: collision with root package name */
    private Iterator<? extends ByteSource> f18it;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public MultiInputStream(Iterator<? extends ByteSource> it2) throws IOException {
        this.f18it = (Iterator) Preconditions.checkNotNull(it2);
        advance();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.in = null;
            }
        }
    }

    private void advance() throws IOException {
        close();
        if (this.f18it.hasNext()) {
            this.in = this.f18it.next().openStream();
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                return -1;
            }
            int i = inputStream.read();
            if (i != -1) {
                return i;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Preconditions.checkNotNull(bArr);
        while (true) {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                return -1;
            }
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 != -1) {
                return i3;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.in;
        if (inputStream == null || j <= 0) {
            return 0L;
        }
        long jSkip = inputStream.skip(j);
        if (jSkip != 0) {
            return jSkip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.in.skip(j - 1) + 1;
    }
}
