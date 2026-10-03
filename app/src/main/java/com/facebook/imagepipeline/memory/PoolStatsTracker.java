package com.facebook.imagepipeline.memory;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface PoolStatsTracker {
    public static final String BUCKETS_USED_PREFIX = "buckets_used_";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String FREE_BYTES = "free_bytes";
    public static final String FREE_COUNT = "free_count";
    public static final String HARD_CAP = "hard_cap";
    public static final String SOFT_CAP = "soft_cap";
    public static final String USED_BYTES = "used_bytes";
    public static final String USED_COUNT = "used_count";

    void onAlloc(int i);

    void onFree(int i);

    void onHardCapReached();

    void onSoftCapReached();

    void onValueRelease(int i);

    void onValueReuse(int i);

    void setBasePool(@NotNull BasePool<?> basePool);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String BUCKETS_USED_PREFIX = "buckets_used_";
        public static final String FREE_BYTES = "free_bytes";
        public static final String FREE_COUNT = "free_count";
        public static final String HARD_CAP = "hard_cap";
        public static final String SOFT_CAP = "soft_cap";
        public static final String USED_BYTES = "used_bytes";
        public static final String USED_COUNT = "used_count";

        private Companion() {
        }
    }
}
