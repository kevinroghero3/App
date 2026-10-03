package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultByteArrayPoolParams {
    private static final int DEFAULT_BUCKET_SIZE = 5;
    private static final int DEFAULT_IO_BUFFER_SIZE = 16384;
    public static final DefaultByteArrayPoolParams INSTANCE = new DefaultByteArrayPoolParams();
    private static final int MAX_SIZE_HARD_CAP = 1048576;
    private static final int MAX_SIZE_SOFT_CAP = 81920;

    private DefaultByteArrayPoolParams() {
    }

    @JvmStatic
    public static final PoolParams get() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(16384, 5);
        return new PoolParams(MAX_SIZE_SOFT_CAP, 1048576, sparseIntArray);
    }
}
