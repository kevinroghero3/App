package androidx.compose.ui.node;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class MyersDiffKt {
    private static final IntStack calculateDiff(int i, int i2, DiffCallback diffCallback) {
        int i3 = ((i + i2) + 1) / 2;
        IntStack intStack = new IntStack(i3 * 3);
        IntStack intStack2 = new IntStack(i3 * 4);
        intStack2.pushRange(0, i, 0, i2);
        int i4 = (i3 * 2) + 1;
        int[] iArrM2635constructorimpl = CenteredArray.m2635constructorimpl(new int[i4]);
        int[] iArrM2635constructorimpl2 = CenteredArray.m2635constructorimpl(new int[i4]);
        int[] iArrM2821constructorimpl = Snake.m2821constructorimpl(new int[5]);
        while (intStack2.isNotEmpty()) {
            int iPop = intStack2.pop();
            int iPop2 = intStack2.pop();
            int iPop3 = intStack2.pop();
            int iPop4 = intStack2.pop();
            int[] iArr = iArrM2635constructorimpl;
            int[] iArr2 = iArrM2635constructorimpl2;
            if (m2720midPointq5eDKzI(iPop4, iPop3, iPop2, iPop, diffCallback, iArrM2635constructorimpl, iArrM2635constructorimpl2, iArrM2821constructorimpl)) {
                if (Snake.m2824getDiagonalSizeimpl(iArrM2821constructorimpl) > 0) {
                    Snake.m2819addDiagonalToStackimpl(iArrM2821constructorimpl, intStack);
                }
                intStack2.pushRange(iPop4, Snake.m2829getStartXimpl(iArrM2821constructorimpl), iPop2, Snake.m2830getStartYimpl(iArrM2821constructorimpl));
                intStack2.pushRange(Snake.m2825getEndXimpl(iArrM2821constructorimpl), iPop3, Snake.m2826getEndYimpl(iArrM2821constructorimpl), iPop);
            }
            iArrM2635constructorimpl = iArr;
            iArrM2635constructorimpl2 = iArr2;
        }
        intStack.sortDiagonals();
        intStack.pushDiagonal(i, i2, 0);
        return intStack;
    }

    private static final void applyDiff(IntStack intStack, DiffCallback diffCallback) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < intStack.getSize()) {
            int i4 = intStack.get(i);
            int i5 = i + 2;
            int i6 = intStack.get(i5);
            int i7 = intStack.get(i + 1);
            int i8 = intStack.get(i5);
            i += 3;
            while (i3 < i4 - i6) {
                diffCallback.remove(i2, i3);
                i3++;
            }
            while (i2 < i7 - i8) {
                diffCallback.insert(i2);
                i2++;
            }
            for (int i9 = intStack.get(i5); i9 > 0; i9--) {
                diffCallback.same(i3, i2);
                i3++;
                i2++;
            }
        }
    }

    public static final void executeDiff(int i, int i2, @NotNull DiffCallback diffCallback) {
        applyDiff(calculateDiff(i, i2, diffCallback), diffCallback);
    }

    /* JADX INFO: renamed from: midPoint-q5eDKzI, reason: not valid java name */
    private static final boolean m2720midPointq5eDKzI(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int[] iArr3) {
        int i5 = i2 - i;
        int i6 = i4 - i3;
        if (i5 >= 1 && i6 >= 1) {
            int i7 = ((i5 + i6) + 1) / 2;
            CenteredArray.m2641setimpl(iArr, 1, i);
            CenteredArray.m2641setimpl(iArr2, 1, i2);
            int i8 = 0;
            while (i8 < i7) {
                int i9 = i8;
                if (m2719forward4l5_RBY(i, i2, i3, i4, diffCallback, iArr, iArr2, i8, iArr3) || m2718backward4l5_RBY(i, i2, i3, i4, diffCallback, iArr, iArr2, i9, iArr3)) {
                    return true;
                }
                i8 = i9 + 1;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: forward-4l5_RBY, reason: not valid java name */
    private static final boolean m2719forward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int iM2638getimpl;
        int i6;
        int i7;
        int i8 = (i2 - i) - (i4 - i3);
        boolean z = Math.abs(i8) % 2 == 1;
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && CenteredArray.m2638getimpl(iArr, i10 + 1) > CenteredArray.m2638getimpl(iArr, i10 - 1))) {
                iM2638getimpl = CenteredArray.m2638getimpl(iArr, i10 + 1);
                i6 = iM2638getimpl;
            } else {
                iM2638getimpl = CenteredArray.m2638getimpl(iArr, i10 - 1);
                i6 = iM2638getimpl + 1;
            }
            int i11 = (i3 + (i6 - i)) - i10;
            if (i5 != 0 && i6 == iM2638getimpl) {
                i11--;
            }
            while (true) {
                if (i6 >= i2 || i11 >= i4) {
                    break;
                }
                if (!diffCallback.areItemsTheSame(i6, i11)) {
                    break;
                }
                i6++;
                i11++;
            }
            CenteredArray.m2641setimpl(iArr, i10, i6);
            if (z && (i7 = i8 - i10) >= i9 + 1 && i7 <= i5 - 1) {
                if (CenteredArray.m2638getimpl(iArr2, i7) <= i6) {
                    fillSnake(iM2638getimpl, i11, i6, i11, false, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: backward-4l5_RBY, reason: not valid java name */
    private static final boolean m2718backward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int iM2638getimpl;
        int i6;
        int i7;
        int i8 = (i2 - i) - (i4 - i3);
        boolean z = i8 % 2 == 0;
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && CenteredArray.m2638getimpl(iArr2, i10 + 1) < CenteredArray.m2638getimpl(iArr2, i10 - 1))) {
                iM2638getimpl = CenteredArray.m2638getimpl(iArr2, i10 + 1);
                i6 = iM2638getimpl;
            } else {
                iM2638getimpl = CenteredArray.m2638getimpl(iArr2, i10 - 1);
                i6 = iM2638getimpl - 1;
            }
            int i11 = i4 - ((i2 - i6) - i10);
            int i12 = (i5 == 0 || i6 != iM2638getimpl) ? i11 : i11 + 1;
            while (true) {
                if (i6 <= i || i11 <= i3) {
                    break;
                }
                if (!diffCallback.areItemsTheSame(i6 - 1, i11 - 1)) {
                    break;
                }
                i6--;
                i11--;
            }
            CenteredArray.m2641setimpl(iArr2, i10, i6);
            if (z && (i7 = i8 - i10) >= i9 && i7 <= i5) {
                if (CenteredArray.m2638getimpl(iArr, i7) >= i6) {
                    fillSnake(i6, i11, iM2638getimpl, i12, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    public static final void fillSnake(int i, int i2, int i3, int i4, boolean z, @NotNull int[] iArr) {
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        iArr[4] = z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void swap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }
}
