package com.facebook.imagepipeline.memory;

import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class BitmapCounterProvider {
    public static final BitmapCounterProvider INSTANCE;
    private static final long KB = 1024;
    public static final int MAX_BITMAP_TOTAL_SIZE;
    private static final long MB = 1048576;
    private static volatile BitmapCounter bitmapCounter;
    private static int maxBitmapCount;

    private BitmapCounterProvider() {
    }

    static {
        BitmapCounterProvider bitmapCounterProvider = new BitmapCounterProvider();
        INSTANCE = bitmapCounterProvider;
        MAX_BITMAP_TOTAL_SIZE = bitmapCounterProvider.getMaxSizeHardCap();
        maxBitmapCount = BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
    }

    private final int getMaxSizeHardCap() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (iMin > 16777216) {
            return (iMin / 4) * 3;
        }
        return iMin / 2;
    }

    @JvmStatic
    public static final void initialize(@NotNull BitmapCounterConfig bitmapCounterConfig) {
        Intrinsics.checkNotNullParameter(bitmapCounterConfig, "bitmapCounterConfig");
        if (bitmapCounter != null) {
            throw new IllegalStateException("BitmapCounter has already been created! `BitmapCounterProvider.initialize(...)` should only be called before `BitmapCounterProvider.get()` or not at all!");
        }
        maxBitmapCount = bitmapCounterConfig.getMaxBitmapCount();
    }

    @JvmStatic
    public static final BitmapCounter get() {
        if (bitmapCounter == null) {
            synchronized (BitmapCounterProvider.class) {
                if (bitmapCounter == null) {
                    bitmapCounter = new BitmapCounter(maxBitmapCount, MAX_BITMAP_TOTAL_SIZE);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        BitmapCounter bitmapCounter2 = bitmapCounter;
        Intrinsics.checkNotNull(bitmapCounter2);
        return bitmapCounter2;
    }
}
