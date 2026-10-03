package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultFlexByteArrayPoolParams {
    public static final int DEFAULT_MAX_BYTE_ARRAY_SIZE = 4194304;
    private static final int DEFAULT_MIN_BYTE_ARRAY_SIZE = 131072;
    public static final DefaultFlexByteArrayPoolParams INSTANCE = new DefaultFlexByteArrayPoolParams();
    private static final int DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();

    private DefaultFlexByteArrayPoolParams() {
    }

    public final int getDEFAULT_MAX_NUM_THREADS() {
        return DEFAULT_MAX_NUM_THREADS;
    }

    @JvmStatic
    public static final SparseIntArray generateBuckets(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    @JvmStatic
    public static final PoolParams get() {
        int i = DEFAULT_MAX_NUM_THREADS;
        return new PoolParams(4194304, i * 4194304, generateBuckets(131072, 4194304, i), 131072, 4194304, i);
    }
}
