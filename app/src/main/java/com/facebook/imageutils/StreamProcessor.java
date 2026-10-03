package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class StreamProcessor {
    public static final StreamProcessor INSTANCE = new StreamProcessor();

    private StreamProcessor() {
    }

    @JvmStatic
    public static final int readPackedInt(@NotNull InputStream stream, int i, boolean z) throws IOException {
        int i2;
        Intrinsics.checkNotNullParameter(stream, "stream");
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = stream.read();
            if (i5 == -1) {
                throw new IOException("no more bytes");
            }
            if (z) {
                i2 = (i5 & 255) << (i4 * 8);
            } else {
                i3 <<= 8;
                i2 = i5 & 255;
            }
            i3 |= i2;
        }
        return i3;
    }
}
