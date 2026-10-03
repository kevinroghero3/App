package io.legere.pdfiumandroid.util;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ConfigKt {
    private static Config pdfiumConfig = new Config(null, null, 3, null);

    /* JADX INFO: loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlreadyClosedBehavior.values().length];
            try {
                iArr[AlreadyClosedBehavior.EXCEPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AlreadyClosedBehavior.IGNORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Config getPdfiumConfig() {
        return pdfiumConfig;
    }

    public static final void setPdfiumConfig(@NotNull Config config) {
        Intrinsics.checkNotNullParameter(config, "<set-?>");
        pdfiumConfig = config;
    }

    public static final boolean handleAlreadyClosed(boolean z) {
        if (z) {
            int i = WhenMappings.$EnumSwitchMapping$0[pdfiumConfig.getAlreadyClosedBehavior().ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Already closed");
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            pdfiumConfig.getLogger().d("PdfiumCore", "Already closed");
        }
        return z;
    }
}
