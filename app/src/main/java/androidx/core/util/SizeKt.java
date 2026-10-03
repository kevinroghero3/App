package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class SizeKt {
    public static final int component1(@NotNull Size size) {
        return size.getWidth();
    }

    public static final int component2(@NotNull Size size) {
        return size.getHeight();
    }

    public static final float component1(@NotNull SizeF sizeF) {
        return sizeF.getWidth();
    }

    public static final float component2(@NotNull SizeF sizeF) {
        return sizeF.getHeight();
    }

    public static final float component1(@NotNull SizeFCompat sizeFCompat) {
        return sizeFCompat.getWidth();
    }

    public static final float component2(@NotNull SizeFCompat sizeFCompat) {
        return sizeFCompat.getHeight();
    }
}
