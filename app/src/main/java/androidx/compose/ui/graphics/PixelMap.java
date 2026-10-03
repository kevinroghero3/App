package androidx.compose.ui.graphics;

import androidx.annotation.IntRange;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PixelMap {
    private final int[] buffer;
    private final int bufferOffset;
    private final int height;
    private final int stride;
    private final int width;

    public PixelMap(@NotNull int[] iArr, int i, int i2, int i3, int i4) {
        this.buffer = iArr;
        this.width = i;
        this.height = i2;
        this.bufferOffset = i3;
        this.stride = i4;
    }

    public final int[] getBuffer() {
        return this.buffer;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getBufferOffset() {
        return this.bufferOffset;
    }

    public final int getStride() {
        return this.stride;
    }

    /* JADX INFO: renamed from: get-WaAFU9c, reason: not valid java name */
    public final long m1467getWaAFU9c(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        return ColorKt.Color(this.buffer[this.bufferOffset + (i2 * this.stride) + i]);
    }
}
