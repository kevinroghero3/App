package com.google.crypto.tink.streamingaead.internal;

import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.subtle.RewindableReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class ReadableByteChannelDecrypter implements ReadableByteChannel {
    byte[] associatedData;
    RewindableReadableByteChannel ciphertextChannel;
    ReadableByteChannel attemptingChannel = null;
    ReadableByteChannel matchingChannel = null;
    Deque<StreamingAead> remainingPrimitives = new ArrayDeque();

    public ReadableByteChannelDecrypter(List<StreamingAead> list, ReadableByteChannel readableByteChannel, byte[] bArr) {
        Iterator<StreamingAead> it2 = list.iterator();
        while (it2.hasNext()) {
            this.remainingPrimitives.add(it2.next());
        }
        this.ciphertextChannel = new RewindableReadableByteChannel(readableByteChannel);
        this.associatedData = (byte[]) bArr.clone();
    }

    private ReadableByteChannel nextAttemptingChannel() throws IOException {
        ReadableByteChannel readableByteChannelNewDecryptingChannel;
        synchronized (this) {
            while (!this.remainingPrimitives.isEmpty()) {
                try {
                    readableByteChannelNewDecryptingChannel = this.remainingPrimitives.removeFirst().newDecryptingChannel(this.ciphertextChannel, this.associatedData);
                } catch (GeneralSecurityException unused) {
                    this.ciphertextChannel.rewind();
                }
            }
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
        return readableByteChannelNewDecryptingChannel;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        synchronized (this) {
            if (byteBuffer.remaining() == 0) {
                return 0;
            }
            ReadableByteChannel readableByteChannel = this.matchingChannel;
            if (readableByteChannel != null) {
                return readableByteChannel.read(byteBuffer);
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
                    this.ciphertextChannel.disableRewinding();
                    return i;
                } catch (IOException unused) {
                    this.ciphertextChannel.rewind();
                    this.attemptingChannel = nextAttemptingChannel();
                }
                throw th;
            }
        }
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
