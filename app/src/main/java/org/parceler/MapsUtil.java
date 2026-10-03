package org.parceler;

/* JADX INFO: loaded from: classes6.dex */
public final class MapsUtil {
    public static final String INITIAL_HASH_MAP_CAPACITY_METHOD = "initialHashMapCapacity";
    private static final int MAX_POWER_OF_TWO = 1073741824;

    private MapsUtil() {
    }

    public static int initialHashMapCapacity(int i) {
        if (i < 0) {
            throw new ParcelerRuntimeException("Expected size must be non-negative");
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
