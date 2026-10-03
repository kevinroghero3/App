package androidx.compose.ui.unit;

import ch.qos.logback.core.CoreConstants;
import kotlin.KotlinNothingValueException;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class ConstraintsKt {
    private static final long FocusMask = 3;
    private static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxAllowedForMaxFocusBits = 8190;
    private static final int MaxAllowedForMaxNonFocusBits = 262142;
    private static final int MaxAllowedForMinFocusBits = 32766;
    private static final int MaxAllowedForMinNonFocusBits = 65534;
    private static final int MaxFocusBits = 18;
    private static final int MaxFocusHeight = 0;
    private static final int MaxFocusMask = 262143;
    private static final int MaxFocusWidth = 3;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final int MinFocusHeight = 1;
    private static final int MinFocusMask = 65535;
    private static final int MinFocusWidth = 2;
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;

    private static final int bitsNeedForSizeUnchecked(int i) {
        if (i < MaxNonFocusMask) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < MaxFocusMask ? 18 : 255;
    }

    private static final int heightMask(int i) {
        return (1 << (18 - i)) - 1;
    }

    private static final int indexToBitOffset(int i) {
        return ((i & 1) << 1) + (((i & 2) >> 1) * 3);
    }

    private static final int minHeightOffsets(int i) {
        return i + 15;
    }

    private static final int widthMask(int i) {
        return (1 << (i + 13)) - 1;
    }

    private static final void invalidConstraint(int i, int i2) {
        throw new IllegalArgumentException("Can't represent a width of " + i + " and height of " + i2 + " in Constraints");
    }

    private static final Void invalidSize(int i) {
        throw new IllegalArgumentException("Can't represent a size of " + i + " in Constraints");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0039  */
    public static final long createConstraints(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i4 == Integer.MAX_VALUE ? i3 : i4;
        int iBitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i6);
        int i7 = i2 == Integer.MAX_VALUE ? i : i2;
        int iBitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i7);
        if (iBitsNeedForSizeUnchecked + iBitsNeedForSizeUnchecked2 > 31) {
            invalidConstraint(i7, i6);
        }
        int i8 = i2 + 1;
        int i9 = i4 + 1;
        if (iBitsNeedForSizeUnchecked2 == 13) {
            i5 = 0;
        } else if (iBitsNeedForSizeUnchecked2 == 18) {
            i5 = 3;
        } else if (iBitsNeedForSizeUnchecked2 == 15) {
            i5 = 1;
        } else if (iBitsNeedForSizeUnchecked2 != 16) {
            i5 = 0;
        } else {
            i5 = 2;
        }
        int i10 = ((i5 & 1) << 1) + (((i5 & 2) >> 1) * 3);
        return Constraints.m3592constructorimpl((((long) ((~(i8 >> 31)) & i8)) << 33) | ((long) i5) | (((long) i) << 2) | (((long) i3) << (i10 + 15)) | (((long) ((~(i9 >> 31)) & i9)) << (i10 + 46)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxAllowedForSize(int i) {
        if (i < MaxNonFocusMask) {
            return MaxAllowedForMaxNonFocusBits;
        }
        if (i < 32767) {
            return MaxAllowedForMinNonFocusBits;
        }
        if (i < 65535) {
            return MaxAllowedForMinFocusBits;
        }
        if (i < MaxFocusMask) {
            return MaxAllowedForMaxFocusBits;
        }
        invalidSize(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (i2 < i) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth(" + i2 + ") must be >= than minWidth(" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        if (i4 < i3) {
            InlineClassHelperKt.throwIllegalArgumentException("maxHeight(" + i4 + ") must be >= than minHeight(" + i3 + CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        if (i < 0 || i3 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("minWidth(" + i + ") and minHeight(" + i3 + ") must be >= 0");
        }
        return createConstraints(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m3618constrainN9IONVI(long j, long j2) {
        return Constraints(RangesKt___RangesKt.coerceIn(Constraints.m3605getMinWidthimpl(j2), Constraints.m3605getMinWidthimpl(j), Constraints.m3603getMaxWidthimpl(j)), RangesKt___RangesKt.coerceIn(Constraints.m3603getMaxWidthimpl(j2), Constraints.m3605getMinWidthimpl(j), Constraints.m3603getMaxWidthimpl(j)), RangesKt___RangesKt.coerceIn(Constraints.m3604getMinHeightimpl(j2), Constraints.m3604getMinHeightimpl(j), Constraints.m3602getMaxHeightimpl(j)), RangesKt___RangesKt.coerceIn(Constraints.m3602getMaxHeightimpl(j2), Constraints.m3604getMinHeightimpl(j), Constraints.m3602getMaxHeightimpl(j)));
    }

    /* JADX INFO: renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m3617constrain4WqzIAM(long j, long j2) {
        return IntSizeKt.IntSize(RangesKt___RangesKt.coerceIn(IntSize.m3820getWidthimpl(j2), Constraints.m3605getMinWidthimpl(j), Constraints.m3603getMaxWidthimpl(j)), RangesKt___RangesKt.coerceIn(IntSize.m3819getHeightimpl(j2), Constraints.m3604getMinHeightimpl(j), Constraints.m3602getMaxHeightimpl(j)));
    }

    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m3620constrainWidthK40F9xA(long j, int i) {
        return RangesKt___RangesKt.coerceIn(i, Constraints.m3605getMinWidthimpl(j), Constraints.m3603getMaxWidthimpl(j));
    }

    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m3619constrainHeightK40F9xA(long j, int i) {
        return RangesKt___RangesKt.coerceIn(i, Constraints.m3604getMinHeightimpl(j), Constraints.m3602getMaxHeightimpl(j));
    }

    /* JADX INFO: renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m3621isSatisfiedBy4WqzIAM(long j, long j2) {
        int iM3605getMinWidthimpl = Constraints.m3605getMinWidthimpl(j);
        int iM3603getMaxWidthimpl = Constraints.m3603getMaxWidthimpl(j);
        int iM3820getWidthimpl = IntSize.m3820getWidthimpl(j2);
        if (iM3605getMinWidthimpl <= iM3820getWidthimpl && iM3820getWidthimpl <= iM3603getMaxWidthimpl) {
            int iM3604getMinHeightimpl = Constraints.m3604getMinHeightimpl(j);
            int iM3602getMaxHeightimpl = Constraints.m3602getMaxHeightimpl(j);
            int iM3819getHeightimpl = IntSize.m3819getHeightimpl(j2);
            if (iM3604getMinHeightimpl <= iM3819getHeightimpl && iM3819getHeightimpl <= iM3602getMaxHeightimpl) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m3623offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m3622offsetNN6EwU(j, i, i2);
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m3622offsetNN6EwU(long j, int i, int i2) {
        return Constraints(RangesKt___RangesKt.coerceAtLeast(Constraints.m3605getMinWidthimpl(j) + i, 0), addMaxWithMinimum(Constraints.m3603getMaxWidthimpl(j), i), RangesKt___RangesKt.coerceAtLeast(Constraints.m3604getMinHeightimpl(j) + i2, 0), addMaxWithMinimum(Constraints.m3602getMaxHeightimpl(j), i2));
    }

    private static final int addMaxWithMinimum(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : RangesKt___RangesKt.coerceAtLeast(i + i2, 0);
    }
}
