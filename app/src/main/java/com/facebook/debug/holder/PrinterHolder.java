package com.facebook.debug.holder;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class PrinterHolder {
    public static final PrinterHolder INSTANCE = new PrinterHolder();
    private static Printer printer = NoopPrinter.INSTANCE;

    @JvmStatic
    public static /* synthetic */ void getPrinter$annotations() {
    }

    private PrinterHolder() {
    }

    public static final Printer getPrinter() {
        return printer;
    }

    public static final void setPrinter(@NotNull Printer printer2) {
        Intrinsics.checkNotNullParameter(printer2, "<set-?>");
        printer = printer2;
    }
}
