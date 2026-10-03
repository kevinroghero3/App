package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class Spacing {
    public static final int ALL = 8;
    public static final int BLOCK = 9;
    public static final int BLOCK_END = 10;
    public static final int BLOCK_START = 11;
    public static final int BOTTOM = 3;
    public static final int END = 5;
    public static final int HORIZONTAL = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int START = 4;
    public static final int TOP = 1;
    public static final int VERTICAL = 7;
    private final float defaultValue;
    private boolean hasAliasesSet;
    private final float[] spacing;
    private int valueFlags;
    public static final Companion Companion = new Companion(null);
    private static final int[] flagsMap = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};

    public Spacing(float f, @NotNull float[] spacing) {
        Intrinsics.checkNotNullParameter(spacing, "spacing");
        this.defaultValue = f;
        this.spacing = spacing;
    }

    public Spacing() {
        this(0.0f, Companion.newFullSpacingArray());
    }

    public Spacing(float f) {
        this(f, Companion.newFullSpacingArray());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Spacing(@NotNull Spacing original) {
        Intrinsics.checkNotNullParameter(original, "original");
        float f = original.defaultValue;
        float[] fArr = original.spacing;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
        this(f, fArrCopyOf);
        this.valueFlags = original.valueFlags;
        this.hasAliasesSet = original.hasAliasesSet;
    }

    public final boolean set(int i, float f) {
        int i2;
        if (FloatUtil.floatsEqual(this.spacing[i], f)) {
            return false;
        }
        this.spacing[i] = f;
        if (YogaConstants.isUndefined(f)) {
            i2 = (~flagsMap[i]) & this.valueFlags;
        } else {
            i2 = flagsMap[i] | this.valueFlags;
        }
        this.valueFlags = i2;
        int[] iArr = flagsMap;
        this.hasAliasesSet = ((iArr[8] & i2) == 0 && (iArr[7] & i2) == 0 && (iArr[6] & i2) == 0 && (i2 & iArr[9]) == 0) ? false : true;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x000c  */
    public final float get(int i) {
        float f;
        if (i != 4 && i != 5) {
            switch (i) {
                case 9:
                case 10:
                case 11:
                    f = Float.NaN;
                    break;
                default:
                    f = this.defaultValue;
                    break;
            }
        } else {
            f = Float.NaN;
        }
        int i2 = this.valueFlags;
        if (i2 == 0) {
            return f;
        }
        int[] iArr = flagsMap;
        if ((iArr[i] & i2) != 0) {
            return this.spacing[i];
        }
        if (this.hasAliasesSet) {
            char c = (i == 1 || i == 3) ? (char) 7 : (char) 6;
            if ((iArr[c] & i2) != 0) {
                return this.spacing[c];
            }
            if ((i2 & iArr[8]) != 0) {
                return this.spacing[8];
            }
        }
        return f;
    }

    public final float getRaw(int i) {
        return this.spacing[i];
    }

    public final void reset() {
        ArraysKt___ArraysJvmKt.fill$default(this.spacing, Float.NaN, 0, 0, 6, (Object) null);
        this.hasAliasesSet = false;
        this.valueFlags = 0;
    }

    public final float getWithFallback(int i, int i2) {
        if ((this.valueFlags & flagsMap[i]) != 0) {
            return this.spacing[i];
        }
        return get(i2);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] newFullSpacingArray() {
            return new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        }
    }
}
