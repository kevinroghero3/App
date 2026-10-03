package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
class StreamingAeadSeekableDecryptingChannel implements SeekableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final SeekableByteChannel ciphertextChannel;
    private final long ciphertextChannelSize;
    private final int ciphertextOffset;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private int currentSegmentNr;
    private final StreamSegmentDecrypter decrypter;
    private final int firstSegmentOffset;
    private final ByteBuffer header;
    private boolean headerRead;
    private boolean isCurrentSegmentDecrypted;
    private boolean isopen;
    private final int lastCiphertextSegmentSize;
    private final int numberOfSegments;
    private long plaintextPosition;
    private final ByteBuffer plaintextSegment;
    private final int plaintextSegmentSize;
    private long plaintextSize;

    public StreamingAeadSeekableDecryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, SeekableByteChannel seekableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        this.decrypter = nonceBasedStreamingAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = seekableByteChannel;
        this.header = ByteBuffer.allocate(nonceBasedStreamingAead.getHeaderLength());
        int ciphertextSegmentSize = nonceBasedStreamingAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        this.ciphertextSegment = ByteBuffer.allocate(ciphertextSegmentSize);
        int plaintextSegmentSize = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        this.plaintextSegment = ByteBuffer.allocate(plaintextSegmentSize + 16);
        this.plaintextPosition = 0L;
        this.headerRead = false;
        this.currentSegmentNr = -1;
        this.isCurrentSegmentDecrypted = false;
        long size = seekableByteChannel.size();
        this.ciphertextChannelSize = size;
        this.aad = Arrays.copyOf(bArr, bArr.length);
        this.isopen = seekableByteChannel.isOpen();
        long j = ciphertextSegmentSize;
        int i = (int) (size / j);
        int i2 = (int) (size % j);
        int ciphertextOverhead = nonceBasedStreamingAead.getCiphertextOverhead();
        if (i2 > 0) {
            this.numberOfSegments = i + 1;
            if (i2 < ciphertextOverhead) {
                throw new IOException("Invalid ciphertext size");
            }
            this.lastCiphertextSegmentSize = i2;
        } else {
            this.numberOfSegments = i;
            this.lastCiphertextSegmentSize = ciphertextSegmentSize;
        }
        int ciphertextOffset = nonceBasedStreamingAead.getCiphertextOffset();
        this.ciphertextOffset = ciphertextOffset;
        int headerLength = ciphertextOffset - nonceBasedStreamingAead.getHeaderLength();
        this.firstSegmentOffset = headerLength;
        if (headerLength < 0) {
            throw new IOException("Invalid ciphertext offset or header length");
        }
        long j2 = (((long) this.numberOfSegments) * ((long) ciphertextOverhead)) + ((long) ciphertextOffset);
        if (j2 > size) {
            throw new IOException("Ciphertext is too short");
        }
        this.plaintextSize = size - j2;
    }

    public String toString() {
        String str;
        String string;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            try {
                str = "position:" + this.ciphertextChannel.position();
            } catch (IOException unused) {
                str = "position: n/a";
            }
            sb.append("StreamingAeadSeekableDecryptingChannel");
            sb.append("\nciphertextChannel");
            sb.append(str);
            sb.append("\nciphertextChannelSize:");
            sb.append(this.ciphertextChannelSize);
            sb.append("\nplaintextSize:");
            sb.append(this.plaintextSize);
            sb.append("\nciphertextSegmentSize:");
            sb.append(this.ciphertextSegmentSize);
            sb.append("\nnumberOfSegments:");
            sb.append(this.numberOfSegments);
            sb.append("\nheaderRead:");
            sb.append(this.headerRead);
            sb.append("\nplaintextPosition:");
            sb.append(this.plaintextPosition);
            sb.append("\nHeader");
            sb.append(" position:");
            sb.append(this.header.position());
            sb.append(" limit:");
            sb.append(this.header.limit());
            sb.append("\ncurrentSegmentNr:");
            sb.append(this.currentSegmentNr);
            sb.append("\nciphertextSgement");
            sb.append(" position:");
            sb.append(this.ciphertextSegment.position());
            sb.append(" limit:");
            sb.append(this.ciphertextSegment.limit());
            sb.append("\nisCurrentSegmentDecrypted:");
            sb.append(this.isCurrentSegmentDecrypted);
            sb.append("\nplaintextSegment");
            sb.append(" position:");
            sb.append(this.plaintextSegment.position());
            sb.append(" limit:");
            sb.append(this.plaintextSegment.limit());
            string = sb.toString();
        }
        return string;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long position() {
        long j;
        synchronized (this) {
            j = this.plaintextPosition;
        }
        return j;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel position(long j) {
        synchronized (this) {
            this.plaintextPosition = j;
        }
        return this;
    }

    private boolean tryReadHeader() throws IOException {
        this.ciphertextChannel.position(this.header.position() + this.firstSegmentOffset);
        int iRemaining = this.header.remaining();
        int i = this.ciphertextChannel.read(this.header);
        if (i == -1) {
            throw new IOException("Unexpected end-of-stream: ciphertextChannel.read(header) returned -1");
        }
        if (i != iRemaining - this.header.remaining()) {
            throw new IOException("Unexpected return value from ciphertextChannel.read(header). headerSize = " + iRemaining + ", header.remaining() = " + this.header.remaining() + ", but read returned " + i);
        }
        if (this.header.remaining() > 0) {
            return false;
        }
        this.header.flip();
        try {
            this.decrypter.init(this.header, this.aad);
            this.headerRead = true;
            return true;
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
    }

    private int getSegmentNr(long j) {
        return (int) ((j + ((long) this.ciphertextOffset)) / ((long) this.plaintextSegmentSize));
    }

    private boolean tryLoadSegment(int i) throws IOException {
        int i2;
        if (i < 0 || i >= (i2 = this.numberOfSegments)) {
            throw new IOException("Invalid position");
        }
        boolean z = i == i2 - 1;
        if (i == this.currentSegmentNr) {
            if (this.isCurrentSegmentDecrypted) {
                return true;
            }
        } else {
            int i3 = this.ciphertextSegmentSize;
            long j = ((long) i) * ((long) i3);
            if (z) {
                i3 = this.lastCiphertextSegmentSize;
            }
            if (i == 0) {
                int i4 = this.ciphertextOffset;
                i3 -= i4;
                j = i4;
            }
            this.ciphertextChannel.position(j);
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(i3);
            this.currentSegmentNr = i;
            this.isCurrentSegmentDecrypted = false;
        }
        if (this.ciphertextSegment.remaining() > 0) {
            int iRemaining = this.ciphertextSegment.remaining();
            int i5 = this.ciphertextChannel.read(this.ciphertextSegment);
            if (i5 == -1) {
                throw new IOException("Unexpected end-of-stream: ciphertextChannel.read(ciphertextSegment) returned -1");
            }
            if (i5 != iRemaining - this.ciphertextSegment.remaining()) {
                throw new IOException("Unexpected return value from ciphertextChannel.read(ciphertextSegment). remainingDataBeforeRead = " + iRemaining + ", ciphertextSegment.remaining() = " + this.ciphertextSegment.remaining() + ", but read returned " + i5);
            }
        }
        if (this.ciphertextSegment.remaining() > 0) {
            return false;
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, i, z, this.plaintextSegment);
            this.plaintextSegment.flip();
            this.isCurrentSegmentDecrypted = true;
            return true;
        } catch (GeneralSecurityException e) {
            this.currentSegmentNr = -1;
            throw new IOException("Failed to decrypt", e);
        }
    }

    private boolean reachedEnd() {
        return this.plaintextPosition == this.plaintextSize && this.isCurrentSegmentDecrypted && this.currentSegmentNr == this.numberOfSegments - 1 && this.plaintextSegment.remaining() == 0;
    }

    public int read(ByteBuffer byteBuffer, long j) throws IOException {
        int i;
        synchronized (this) {
            long jPosition = position();
            try {
                position(j);
                i = read(byteBuffer);
                position(jPosition);
            } catch (Throwable th) {
                position(jPosition);
                throw th;
            }
        }
        return i;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        long j;
        synchronized (this) {
            if (!this.isopen) {
                throw new ClosedChannelException();
            }
            if (!this.headerRead && !tryReadHeader()) {
                return 0;
            }
            int iPosition = byteBuffer.position();
            while (byteBuffer.remaining() > 0) {
                long j2 = this.plaintextPosition;
                if (j2 < this.plaintextSize) {
                    int segmentNr = getSegmentNr(j2);
                    if (segmentNr == 0) {
                        j = this.plaintextPosition;
                    } else {
                        j = (this.plaintextPosition + ((long) this.ciphertextOffset)) % ((long) this.plaintextSegmentSize);
                    }
                    int i = (int) j;
                    if (!tryLoadSegment(segmentNr)) {
                        break;
                    }
                    this.plaintextSegment.position(i);
                    if (this.plaintextSegment.remaining() <= byteBuffer.remaining()) {
                        this.plaintextPosition += (long) this.plaintextSegment.remaining();
                        byteBuffer.put(this.plaintextSegment);
                    } else {
                        int iRemaining = byteBuffer.remaining();
                        ByteBuffer byteBufferDuplicate = this.plaintextSegment.duplicate();
                        byteBufferDuplicate.limit(byteBufferDuplicate.position() + iRemaining);
                        byteBuffer.put(byteBufferDuplicate);
                        this.plaintextPosition += (long) iRemaining;
                        ByteBuffer byteBuffer2 = this.plaintextSegment;
                        byteBuffer2.position(byteBuffer2.position() + iRemaining);
                    }
                } else {
                    break;
                }
            }
            int iPosition2 = byteBuffer.position() - iPosition;
            if (iPosition2 == 0 && reachedEnd()) {
                return -1;
            }
            return iPosition2;
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        return this.plaintextSize;
    }

    public long verifiedSize() throws IOException {
        long j;
        synchronized (this) {
            if (tryLoadSegment(this.numberOfSegments - 1)) {
                j = this.plaintextSize;
            } else {
                throw new IOException("could not verify the size");
            }
        }
        return j;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.ciphertextChannel.close();
            this.isopen = false;
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        boolean z;
        synchronized (this) {
            z = this.isopen;
        }
        return z;
    }
}
