package com.google.crypto.tink.streamingaead.internal;

import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class SeekableByteChannelDecrypter implements SeekableByteChannel {
    byte[] associatedData;
    long cachedPosition;
    SeekableByteChannel ciphertextChannel;
    long startingPosition;
    SeekableByteChannel attemptingChannel = null;
    SeekableByteChannel matchingChannel = null;
    Deque<StreamingAead> remainingPrimitives = new ArrayDeque();

    public SeekableByteChannelDecrypter(List<StreamingAead> list, SeekableByteChannel seekableByteChannel, byte[] bArr) throws IOException {
        Iterator<StreamingAead> it2 = list.iterator();
        while (it2.hasNext()) {
            this.remainingPrimitives.add(it2.next());
        }
        this.ciphertextChannel = seekableByteChannel;
        this.cachedPosition = -1L;
        this.startingPosition = seekableByteChannel.position();
        this.associatedData = (byte[]) bArr.clone();
    }

    private SeekableByteChannel nextAttemptingChannel() throws IOException {
        SeekableByteChannel seekableByteChannelNewSeekableDecryptingChannel;
        synchronized (this) {
            while (!this.remainingPrimitives.isEmpty()) {
                this.ciphertextChannel.position(this.startingPosition);
                try {
                    seekableByteChannelNewSeekableDecryptingChannel = this.remainingPrimitives.removeFirst().newSeekableDecryptingChannel(this.ciphertextChannel, this.associatedData);
                    long j = this.cachedPosition;
                    if (j >= 0) {
                        seekableByteChannelNewSeekableDecryptingChannel.position(j);
                    }
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
        return seekableByteChannelNewSeekableDecryptingChannel;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        synchronized (this) {
            if (byteBuffer.remaining() == 0) {
                return 0;
            }
            SeekableByteChannel seekableByteChannel = this.matchingChannel;
            if (seekableByteChannel != null) {
                return seekableByteChannel.read(byteBuffer);
            }
            if (this.attemptingChannel == null) {
                this.attemptingChannel = nextAttemptingChannel();
            }
            while (true) {
                try {
                    int i = this.attemptingChannel.read(byteBuffer);
                    if (i == 0) {
                        return 0;
                    }
                    this.matchingChannel = this.attemptingChannel;
                    this.attemptingChannel = null;
                    return i;
                } catch (IOException unused) {
                    this.attemptingChannel = nextAttemptingChannel();
                }
                throw th;
            }
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel position(long j) throws IOException {
        synchronized (this) {
            SeekableByteChannel seekableByteChannel = this.matchingChannel;
            if (seekableByteChannel != null) {
                seekableByteChannel.position(j);
            } else {
                if (j < 0) {
                    throw new IllegalArgumentException("Position must be non-negative");
                }
                this.cachedPosition = j;
                SeekableByteChannel seekableByteChannel2 = this.attemptingChannel;
                if (seekableByteChannel2 != null) {
                    seekableByteChannel2.position(j);
                }
            }
        }
        return this;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long position() throws IOException {
        synchronized (this) {
            SeekableByteChannel seekableByteChannel = this.matchingChannel;
            if (seekableByteChannel != null) {
                return seekableByteChannel.position();
            }
            return this.cachedPosition;
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() throws IOException {
        long size;
        synchronized (this) {
            SeekableByteChannel seekableByteChannel = this.matchingChannel;
            if (seekableByteChannel != null) {
                size = seekableByteChannel.size();
            } else {
                throw new IOException("Cannot determine size before first read()-call.");
            }
        }
        return size;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j) throws IOException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.ciphertextChannel.close();
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        boolean zIsOpen;
        synchronized (this) {
            zIsOpen = this.ciphertextChannel.isOpen();
        }
        return zIsOpen;
    }
}
