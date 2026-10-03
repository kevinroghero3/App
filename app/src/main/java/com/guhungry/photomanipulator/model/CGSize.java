package com.guhungry.photomanipulator.model;

import ch.qos.logback.core.CoreConstants;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class CGSize {
    private final int height;
    private final int width;

    public static /* synthetic */ CGSize copy$default(CGSize cGSize, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = cGSize.width;
        }
        if ((i3 & 2) != 0) {
            i2 = cGSize.height;
        }
        return cGSize.copy(i, i2);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final CGSize copy(int i, int i2) {
        return new CGSize(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CGSize)) {
            return false;
        }
        CGSize cGSize = (CGSize) obj;
        return this.width == cGSize.width && this.height == cGSize.height;
    }

    public int hashCode() {
        return (Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "CGSize(width=" + this.width + ", height=" + this.height + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public CGSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final float ratio() {
        int i = this.height;
        if (i != 0) {
            return this.width / i;
        }
        return 0.0f;
    }
}
