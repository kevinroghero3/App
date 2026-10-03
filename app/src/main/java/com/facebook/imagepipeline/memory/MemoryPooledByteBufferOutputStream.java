package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    private CloseableReference<MemoryChunk> bufRef;
    private int count;
    private final MemoryChunkPool pool;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemoryPooledByteBufferOutputStream(@NotNull MemoryChunkPool pool) {
        this(pool, 0, 2, null);
        Intrinsics.checkNotNullParameter(pool, "pool");
    }

    public /* synthetic */ MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(memoryChunkPool, (i2 & 2) != 0 ? memoryChunkPool.getMinBufferSize() : i);
    }

    public MemoryPooledByteBufferOutputStream(@NotNull MemoryChunkPool pool, int i) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        if (i <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        this.pool = pool;
        this.count = 0;
        this.bufRef = CloseableReference.of(pool.get(i), pool);
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public MemoryPooledByteBuffer toByteBuffer() {
        ensureValid();
        CloseableReference<MemoryChunk> closeableReference = this.bufRef;
        if (closeableReference != null) {
            return new MemoryPooledByteBuffer(closeableReference, this.count);
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public int size() {
        return this.count;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(@NotNull byte[] buffer, int i, int i2) throws Throwable {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (i < 0 || i2 < 0 || i + i2 > buffer.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + buffer.length + "; regionStart=" + i + "; regionLength=" + i2);
        }
        ensureValid();
        realloc(this.count + i2);
        CloseableReference<MemoryChunk> closeableReference = this.bufRef;
        if (closeableReference == null) {
            throw new IllegalStateException("Required value was null.");
        }
        closeableReference.get().write(this.count, buffer, i, i2);
        this.count += i2;
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        CloseableReference.closeSafely(this.bufRef);
        this.bufRef = null;
        this.count = -1;
        super.close();
    }

    public final void realloc(int i) throws Throwable {
        ensureValid();
        CloseableReference<MemoryChunk> closeableReference = this.bufRef;
        if (closeableReference == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Intrinsics.checkNotNull(closeableReference);
        if (i <= closeableReference.get().getSize()) {
            return;
        }
        MemoryChunk memoryChunk = this.pool.get(i);
        Intrinsics.checkNotNullExpressionValue(memoryChunk, "get(...)");
        MemoryChunk memoryChunk2 = memoryChunk;
        CloseableReference<MemoryChunk> closeableReference2 = this.bufRef;
        if (closeableReference2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Intrinsics.checkNotNull(closeableReference2);
        closeableReference2.get().copy(0, memoryChunk2, 0, this.count);
        CloseableReference<MemoryChunk> closeableReference3 = this.bufRef;
        Intrinsics.checkNotNull(closeableReference3);
        closeableReference3.close();
        this.bufRef = CloseableReference.of(memoryChunk2, this.pool);
    }

    private final void ensureValid() {
        if (!CloseableReference.isValid(this.bufRef)) {
            throw new InvalidStreamException();
        }
    }

    public static final class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
