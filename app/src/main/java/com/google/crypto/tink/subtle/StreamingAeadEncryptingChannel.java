package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class StreamingAeadEncryptingChannel implements WritableByteChannel {
    private WritableByteChannel ciphertextChannel;
    ByteBuffer ctBuffer;
    private StreamSegmentEncrypter encrypter;
    boolean open = true;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;

    private int writeWithCheck(WritableByteChannel writableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        int iWrite = writableByteChannel.write(byteBuffer);
        if (iWrite < 0 || iWrite > iRemaining) {
            throw new IOException("Invalid return value from dst.write: n = " + iWrite + ", r = " + iRemaining);
        }
        if (byteBuffer.remaining() == iRemaining - iWrite) {
            return iWrite;
        }
        throw new IOException("Unexpected state after of src after writing to dst:  src.remaining() = " + byteBuffer.remaining() + " != r - n = " + iRemaining + " - " + iWrite);
    }

    public StreamingAeadEncryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, WritableByteChannel writableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        this.ciphertextChannel = writableByteChannel;
        this.encrypter = nonceBasedStreamingAead.newStreamSegmentEncrypter(bArr);
        int plaintextSegmentSize = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(plaintextSegmentSize);
        this.ptBuffer = byteBufferAllocate;
        byteBufferAllocate.limit(this.plaintextSegmentSize - nonceBasedStreamingAead.getCiphertextOffset());
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(nonceBasedStreamingAead.getCiphertextSegmentSize());
        this.ctBuffer = byteBufferAllocate2;
        byteBufferAllocate2.put(this.encrypter.getHeader());
        this.ctBuffer.flip();
        writeWithCheck(writableByteChannel, this.ctBuffer);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        int iPosition;
        int iPosition2;
        synchronized (this) {
            if (!this.open) {
                throw new ClosedChannelException();
            }
            if (this.ctBuffer.remaining() > 0) {
                writeWithCheck(this.ciphertextChannel, this.ctBuffer);
            }
            iPosition = byteBuffer.position();
            while (byteBuffer.remaining() > this.ptBuffer.remaining()) {
                if (this.ctBuffer.remaining() > 0) {
                    iPosition2 = byteBuffer.position();
                } else {
                    int iRemaining = this.ptBuffer.remaining();
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.limit(iRemaining);
                    byteBuffer.position(byteBuffer.position() + iRemaining);
                    try {
                        this.ptBuffer.flip();
                        this.ctBuffer.clear();
                        if (byteBufferSlice.remaining() != 0) {
                            this.encrypter.encryptSegment(this.ptBuffer, byteBufferSlice, false, this.ctBuffer);
                        } else {
                            this.encrypter.encryptSegment(this.ptBuffer, false, this.ctBuffer);
                        }
                        this.ctBuffer.flip();
                        writeWithCheck(this.ciphertextChannel, this.ctBuffer);
                        this.ptBuffer.clear();
                        this.ptBuffer.limit(this.plaintextSegmentSize);
                    } catch (GeneralSecurityException e) {
                        throw new IOException(e);
                    }
                }
            }
            this.ptBuffer.put(byteBuffer);
            iPosition2 = byteBuffer.position();
        }
        return iPosition2 - iPosition;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            if (this.open) {
                while (this.ctBuffer.remaining() > 0) {
                    if (writeWithCheck(this.ciphertextChannel, this.ctBuffer) <= 0) {
                        throw new IOException("Failed to write ciphertext before closing");
                    }
                }
                try {
                    this.ctBuffer.clear();
                    this.ptBuffer.flip();
                    this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);
                    this.ctBuffer.flip();
                    while (this.ctBuffer.remaining() > 0) {
                        if (writeWithCheck(this.ciphertextChannel, this.ctBuffer) <= 0) {
                            throw new IOException("Failed to write ciphertext before closing");
                        }
                    }
                    this.ciphertextChannel.close();
                    this.open = false;
                } catch (GeneralSecurityException e) {
                    throw new IOException(e);
                }
            }
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.open;
    }
}
