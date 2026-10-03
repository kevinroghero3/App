package com.google.crypto.tink.streamingaead.internal;

import com.google.crypto.tink.StreamingAead;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class InputStreamDecrypter extends InputStream {
    byte[] associatedData;
    InputStream ciphertextStream;
    List<StreamingAead> primitives;
    boolean attemptedMatching = false;
    InputStream matchingStream = null;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public InputStreamDecrypter(List<StreamingAead> list, InputStream inputStream, byte[] bArr) {
        this.primitives = list;
        if (inputStream.markSupported()) {
            this.ciphertextStream = inputStream;
        } else {
            this.ciphertextStream = new BufferedInputStream(inputStream);
        }
        this.ciphertextStream.mark(Integer.MAX_VALUE);
        this.associatedData = (byte[]) bArr.clone();
    }

    private void rewind() throws IOException {
        this.ciphertextStream.reset();
    }

    private void disableRewinding() throws IOException {
        this.ciphertextStream.mark(0);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        synchronized (this) {
            InputStream inputStream = this.matchingStream;
            if (inputStream == null) {
                return 0;
            }
            return inputStream.available();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        synchronized (this) {
            byte[] bArr = new byte[1];
            if (read(bArr) != 1) {
                return -1;
            }
            return bArr[0] & 255;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i;
        synchronized (this) {
            i = read(bArr, 0, bArr.length);
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        synchronized (this) {
            if (i2 == 0) {
                return 0;
            }
            InputStream inputStream = this.matchingStream;
            if (inputStream != null) {
                return inputStream.read(bArr, i, i2);
            }
            if (this.attemptedMatching) {
                throw new IOException("No matching key found for the ciphertext in the stream.");
            }
            this.attemptedMatching = true;
            Iterator<StreamingAead> it2 = this.primitives.iterator();
            while (it2.hasNext()) {
                try {
                    InputStream inputStreamNewDecryptingStream = it2.next().newDecryptingStream(this.ciphertextStream, this.associatedData);
                    int i3 = inputStreamNewDecryptingStream.read(bArr, i, i2);
                    if (i3 == 0) {
                        throw new IOException("Could not read bytes from the ciphertext stream");
                    }
                    this.matchingStream = inputStreamNewDecryptingStream;
                    disableRewinding();
                    return i3;
                } catch (IOException unused) {
                    rewind();
                } catch (GeneralSecurityException unused2) {
                    rewind();
                }
            }
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.ciphertextStream.close();
        }
    }
}
