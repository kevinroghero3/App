package kotlin;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes6.dex */
final class KotlinVersionCurrentValue {
    public static final KotlinVersionCurrentValue INSTANCE = new KotlinVersionCurrentValue();

    private KotlinVersionCurrentValue() {
    }

    @JvmStatic
    public static final KotlinVersion get() {
        return new KotlinVersion(2, 1, 20);
    }
}
