package io.legere.pdfiumandroid.util;

import ch.qos.logback.core.CoreConstants;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class Size {
    private final int height;
    private final int width;

    public static /* synthetic */ Size copy$default(Size size, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = size.width;
        }
        if ((i3 & 2) != 0) {
            i2 = size.height;
        }
        return size.copy(i, i2);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final Size copy(int i, int i2) {
        return new Size(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.width == size.width && this.height == size.height;
    }

    public int hashCode() {
        return (Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Size(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
