package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryPooledByteBuffer implements PooledByteBuffer {

    @Nullable
    CloseableReference<MemoryChunk> mBufRef;
    private final int mSize;

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> closeableReference, int i) {
        Preconditions.checkNotNull(closeableReference);
        Preconditions.checkArgument(Boolean.valueOf(i >= 0 && i <= closeableReference.get().getSize()));
        this.mBufRef = closeableReference.mo4256clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public int size() {
        int i;
        synchronized (this) {
            ensureValid();
            i = this.mSize;
        }
        return i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public byte read(int i) {
        byte b;
        synchronized (this) {
            ensureValid();
            boolean z = true;
            Preconditions.checkArgument(Boolean.valueOf(i >= 0));
            if (i >= this.mSize) {
                z = false;
            }
            Preconditions.checkArgument(Boolean.valueOf(z));
            Preconditions.checkNotNull(this.mBufRef);
            b = this.mBufRef.get().read(i);
        }
        return b;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public int read(int i, byte[] bArr, int i2, int i3) {
        int i4;
        synchronized (this) {
            ensureValid();
            Preconditions.checkArgument(Boolean.valueOf(i + i3 <= this.mSize));
            Preconditions.checkNotNull(this.mBufRef);
            i4 = this.mBufRef.get().read(i, bArr, i2, i3);
        }
        return i4;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public long getNativePtr() throws UnsupportedOperationException {
        long nativePtr;
        synchronized (this) {
            ensureValid();
            Preconditions.checkNotNull(this.mBufRef);
            nativePtr = this.mBufRef.get().getNativePtr();
        }
        return nativePtr;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    @Nullable
    public ByteBuffer getByteBuffer() {
        ByteBuffer byteBuffer;
        synchronized (this) {
            Preconditions.checkNotNull(this.mBufRef);
            byteBuffer = this.mBufRef.get().getByteBuffer();
        }
        return byteBuffer;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public boolean isClosed() {
        boolean zIsValid;
        synchronized (this) {
            zIsValid = CloseableReference.isValid(this.mBufRef);
        }
        return !zIsValid;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            CloseableReference.closeSafely(this.mBufRef);
            this.mBufRef = null;
        }
    }

    void ensureValid() {
        synchronized (this) {
            if (isClosed()) {
                throw new PooledByteBuffer.ClosedException();
            }
        }
    }

    @Nullable
    CloseableReference<MemoryChunk> getCloseableReference() {
        return this.mBufRef;
    }
}
