package com.facebook.imagepipeline.memory;

import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface MemoryChunk {
    void close();

    void copy(int i, @NotNull MemoryChunk memoryChunk, int i2, int i3);

    ByteBuffer getByteBuffer();

    long getNativePtr() throws UnsupportedOperationException;

    int getSize();

    long getUniqueId();

    boolean isClosed();

    byte read(int i);

    int read(int i, @NotNull byte[] bArr, int i2, int i3);

    int write(int i, @NotNull byte[] bArr, int i2, int i3);
}
