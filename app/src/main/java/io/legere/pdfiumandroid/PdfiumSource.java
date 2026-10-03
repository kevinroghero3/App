package io.legere.pdfiumandroid;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface PdfiumSource extends AutoCloseable {
    long getLength();

    int read(long j, @NotNull byte[] bArr, int i);
}
