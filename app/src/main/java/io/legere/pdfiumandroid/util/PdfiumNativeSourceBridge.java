package io.legere.pdfiumandroid.util;

import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfiumSource;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class PdfiumNativeSourceBridge {
    private byte[] buffer;
    private final PdfiumSource source;

    public PdfiumNativeSourceBridge(@NotNull PdfiumSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    public final int read(long j, long j2) {
        try {
            if (j2 > 2147483647L) {
                throw new IllegalArgumentException("size is too large");
            }
            int i = (int) j2;
            byte[] bArr = this.buffer;
            if (bArr == null || bArr.length < j2) {
                bArr = new byte[i];
                this.buffer = bArr;
            }
            int i2 = this.source.read(j, bArr, i);
            if (i2 <= 0) {
                return 0;
            }
            return i2;
        } catch (Throwable th) {
            Logger.INSTANCE.e("PdfiumNativeSourceBridge", th, "read failed");
        }
    }
}
