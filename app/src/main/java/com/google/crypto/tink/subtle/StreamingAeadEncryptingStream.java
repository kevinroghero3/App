package com.google.crypto.tink.subtle;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class StreamingAeadEncryptingStream extends FilterOutputStream {
    ByteBuffer ctBuffer;
    private StreamSegmentEncrypter encrypter;
    boolean open;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;

    private static Buffer toBuffer(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    public StreamingAeadEncryptingStream(NonceBasedStreamingAead nonceBasedStreamingAead, OutputStream outputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        super(outputStream);
        this.encrypter = nonceBasedStreamingAead.newStreamSegmentEncrypter(bArr);
        int plaintextSegmentSize = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        this.ptBuffer = ByteBuffer.allocate(plaintextSegmentSize);
        this.ctBuffer = ByteBuffer.allocate(nonceBasedStreamingAead.getCiphertextSegmentSize());
        toBuffer(this.ptBuffer).limit(this.plaintextSegmentSize - nonceBasedStreamingAead.getCiphertextOffset());
        ByteBuffer header = this.encrypter.getHeader();
        byte[] bArr2 = new byte[header.remaining()];
        header.get(bArr2);
        ((FilterOutputStream) this).out.write(bArr2);
        this.open = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        synchronized (this) {
            if (!this.open) {
                throw new IOException("Trying to write to closed stream");
            }
            while (i2 > this.ptBuffer.remaining()) {
                int iRemaining = this.ptBuffer.remaining();
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, iRemaining);
                i += iRemaining;
                i2 -= iRemaining;
                try {
                    toBuffer(this.ptBuffer).flip();
                    toBuffer(this.ctBuffer).clear();
                    this.encrypter.encryptSegment(this.ptBuffer, byteBufferWrap, false, this.ctBuffer);
                    toBuffer(this.ctBuffer).flip();
                    ((FilterOutputStream) this).out.write(this.ctBuffer.array(), toBuffer(this.ctBuffer).position(), this.ctBuffer.remaining());
                    toBuffer(this.ptBuffer).clear();
                    toBuffer(this.ptBuffer).limit(this.plaintextSegmentSize);
                } catch (GeneralSecurityException e) {
                    throw new IOException(e);
                }
            }
            this.ptBuffer.put(bArr, i, i2);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            if (this.open) {
                try {
                    toBuffer(this.ptBuffer).flip();
                    toBuffer(this.ctBuffer).clear();
                    this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);
                    toBuffer(this.ctBuffer).flip();
                    ((FilterOutputStream) this).out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());
                    this.open = false;
                    super.close();
                } catch (GeneralSecurityException e) {
                    throw new IOException("ptBuffer.remaining():" + this.ptBuffer.remaining() + " ctBuffer.remaining():" + this.ctBuffer.remaining(), e);
                }
            }
        }
    }
}
