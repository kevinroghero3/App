package com.google.crypto.tink.subtle;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
class StreamingAeadDecryptingStream extends FilterInputStream {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private final StreamSegmentDecrypter decrypter;
    private boolean decryptionErrorOccured;
    private boolean endOfCiphertext;
    private boolean endOfPlaintext;
    private final int firstCiphertextSegmentSize;
    private final int headerLength;
    private boolean headerRead;
    private final ByteBuffer plaintextSegment;
    private int segmentNr;

    private static Buffer toBuffer(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public StreamingAeadDecryptingStream(NonceBasedStreamingAead nonceBasedStreamingAead, InputStream inputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        super(inputStream);
        this.decrypter = nonceBasedStreamingAead.newStreamSegmentDecrypter();
        this.headerLength = nonceBasedStreamingAead.getHeaderLength();
        this.aad = Arrays.copyOf(bArr, bArr.length);
        int ciphertextSegmentSize = nonceBasedStreamingAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(ciphertextSegmentSize + 1);
        this.ciphertextSegment = byteBufferAllocate;
        toBuffer(byteBufferAllocate).limit(0);
        this.firstCiphertextSegmentSize = ciphertextSegmentSize - nonceBasedStreamingAead.getCiphertextOffset();
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(nonceBasedStreamingAead.getPlaintextSegmentSize() + 16);
        this.plaintextSegment = byteBufferAllocate2;
        toBuffer(byteBufferAllocate2).limit(0);
        this.headerRead = false;
        this.endOfCiphertext = false;
        this.endOfPlaintext = false;
        this.segmentNr = 0;
        this.decryptionErrorOccured = false;
    }

    private void readHeader() throws IOException {
        if (this.headerRead) {
            setDecryptionErrorOccured();
            throw new IOException("Decryption failed.");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.headerLength);
        while (byteBufferAllocate.remaining() > 0) {
            int i = ((FilterInputStream) this).in.read(byteBufferAllocate.array(), toBuffer(byteBufferAllocate).position(), byteBufferAllocate.remaining());
            if (i < 0) {
                setDecryptionErrorOccured();
                throw new IOException("Ciphertext is too short");
            }
            if (i == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
            toBuffer(byteBufferAllocate).position(toBuffer(byteBufferAllocate).position() + i);
        }
        toBuffer(byteBufferAllocate).flip();
        try {
            this.decrypter.init(byteBufferAllocate, this.aad);
            this.headerRead = true;
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
    }

    private void setDecryptionErrorOccured() {
        this.decryptionErrorOccured = true;
        toBuffer(this.plaintextSegment).limit(0);
    }

    private void loadSegment() throws IOException {
        byte b;
        while (!this.endOfCiphertext && this.ciphertextSegment.remaining() > 0) {
            int i = ((FilterInputStream) this).in.read(this.ciphertextSegment.array(), this.ciphertextSegment.position(), this.ciphertextSegment.remaining());
            if (i > 0) {
                toBuffer(this.ciphertextSegment).position(toBuffer(this.ciphertextSegment).position() + i);
            } else {
                if (i != -1) {
                    if (i == 0) {
                        throw new IOException("Could not read bytes from the ciphertext stream");
                    }
                    throw new IOException("Unexpected return value from in.read");
                }
                this.endOfCiphertext = true;
            }
        }
        if (this.endOfCiphertext) {
            b = 0;
        } else {
            ByteBuffer byteBuffer = this.ciphertextSegment;
            b = byteBuffer.get(toBuffer(byteBuffer).position() - 1);
            toBuffer(this.ciphertextSegment).position(toBuffer(this.ciphertextSegment).position() - 1);
        }
        toBuffer(this.ciphertextSegment).flip();
        toBuffer(this.plaintextSegment).clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, this.segmentNr, this.endOfCiphertext, this.plaintextSegment);
            this.segmentNr++;
            toBuffer(this.plaintextSegment).flip();
            toBuffer(this.ciphertextSegment).clear();
            if (this.endOfCiphertext) {
                return;
            }
            toBuffer(this.ciphertextSegment).clear();
            toBuffer(this.ciphertextSegment).limit(this.ciphertextSegmentSize + 1);
            this.ciphertextSegment.put(b);
        } catch (GeneralSecurityException e) {
            setDecryptionErrorOccured();
            throw new IOException(e.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.segmentNr + " endOfCiphertext:" + this.endOfCiphertext, e);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int i = read(bArr, 0, 1);
        if (i == 1) {
            return bArr[0] & 255;
        }
        if (i == -1) {
            return i;
        }
        throw new IOException("Reading failed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        synchronized (this) {
            if (this.decryptionErrorOccured) {
                throw new IOException("Decryption failed.");
            }
            if (!this.headerRead) {
                readHeader();
                toBuffer(this.ciphertextSegment).clear();
                toBuffer(this.ciphertextSegment).limit(this.firstCiphertextSegmentSize + 1);
            }
            if (this.endOfPlaintext) {
                return -1;
            }
            int i3 = 0;
            while (i3 < i2) {
                if (this.plaintextSegment.remaining() == 0) {
                    if (this.endOfCiphertext) {
                        this.endOfPlaintext = true;
                        break;
                    }
                    loadSegment();
                }
                int iMin = Math.min(this.plaintextSegment.remaining(), i2 - i3);
                this.plaintextSegment.get(bArr, i3 + i, iMin);
                i3 += iMin;
            }
            if (i3 == 0 && this.endOfPlaintext) {
                return -1;
            }
            return i3;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            super.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int iRemaining;
        synchronized (this) {
            iRemaining = this.plaintextSegment.remaining();
        }
        return iRemaining;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        int i;
        long j2 = this.ciphertextSegmentSize;
        if (j <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(j2, j);
        byte[] bArr = new byte[iMin];
        long j3 = j;
        while (j3 > 0 && (i = read(bArr, 0, (int) Math.min(iMin, j3))) > 0) {
            j3 -= (long) i;
        }
        return j - j3;
    }

    public String toString() {
        String str;
        synchronized (this) {
            str = "StreamingAeadDecryptingStream\nsegmentNr:" + this.segmentNr + "\nciphertextSegmentSize:" + this.ciphertextSegmentSize + "\nheaderRead:" + this.headerRead + "\nendOfCiphertext:" + this.endOfCiphertext + "\nendOfPlaintext:" + this.endOfPlaintext + "\ndecryptionErrorOccured:" + this.decryptionErrorOccured + "\nciphertextSgement position:" + this.ciphertextSegment.position() + " limit:" + this.ciphertextSegment.limit() + "\nplaintextSegment position:" + this.plaintextSegment.position() + " limit:" + this.plaintextSegment.limit();
        }
        return str;
    }
}
