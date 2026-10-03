package com.facebook.imagepipeline.memory;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class BitmapCounterConfig {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_MAX_BITMAP_COUNT = 384;
    private final int maxBitmapCount;

    public BitmapCounterConfig() {
        this(0, 1, null);
    }

    public BitmapCounterConfig(int i) {
        this.maxBitmapCount = i;
    }

    public /* synthetic */ BitmapCounterConfig(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? DEFAULT_MAX_BITMAP_COUNT : i);
    }

    public final int getMaxBitmapCount() {
        return this.maxBitmapCount;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
