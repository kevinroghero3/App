package io.legere.pdfiumandroid;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class PdfPasswordException extends IOException {
    public PdfPasswordException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ PdfPasswordException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public PdfPasswordException(@Nullable String str) {
        super(str);
    }
}
