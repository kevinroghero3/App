package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0174  */
    /* JADX WARN: Code duplicated, block: B:104:0x0195  */
    /* JADX WARN: Code duplicated, block: B:198:0x0347  */
    /* JADX WARN: Code duplicated, block: B:219:0x039e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0044 A[PHI: r8 r16
  0x0044: PHI (r8v3 boolean) = (r8v1 boolean), (r8v45 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
  0x0044: PHI (r16v3 boolean) = (r16v1 boolean), (r16v7 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0048 A[PHI: r8 r16
  0x0048: PHI (r8v43 boolean) = (r8v1 boolean), (r8v45 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
  0x0048: PHI (r16v5 boolean) = (r16v1 boolean), (r16v7 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:322:0x03a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x016b  */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        float f;
        int size;
        ConstraintAnchor constraintAnchor3;
        int i5;
        int i6 = i;
        ConstraintWidget constraintWidget = chainHead.mFirst;
        ConstraintWidget constraintWidget2 = chainHead.mLast;
        ConstraintWidget constraintWidget3 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget4 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget5 = chainHead.mHead;
        float f2 = chainHead.mTotalWeight;
        boolean z5 = constraintWidgetContainer.mListDimensionBehaviors[i6] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i6 == 0) {
            int i7 = constraintWidget5.mHorizontalChainStyle;
            z = i7 == 0;
            z2 = i7 == 1;
            if (i7 == 2) {
                z3 = true;
                z4 = z2;
            } else {
                z4 = z2;
                z3 = false;
            }
        } else {
            int i8 = constraintWidget5.mVerticalChainStyle;
            z = i8 == 0;
            z2 = i8 == 1;
            if (i8 == 2) {
                z3 = true;
                z4 = z2;
            } else {
                z4 = z2;
                z3 = false;
            }
        }
        boolean z6 = z;
        ConstraintWidget constraintWidget6 = constraintWidget;
        boolean z7 = false;
        while (true) {
            ConstraintWidget constraintWidget7 = null;
            if (z7) {
                break;
            }
            ConstraintAnchor constraintAnchor4 = constraintWidget6.mListAnchors[i2];
            int i9 = z3 ? 1 : 4;
            int margin = constraintAnchor4.getMargin();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget6.mListDimensionBehaviors[i6];
            float f3 = f2;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z8 = dimensionBehaviour == dimensionBehaviour2 && constraintWidget6.mResolvedMatchConstraintDefault[i6] == 0;
            ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
            if (constraintAnchor5 != null && constraintWidget6 != constraintWidget) {
                margin += constraintAnchor5.getMargin();
            }
            int i10 = margin;
            if (z3 && constraintWidget6 != constraintWidget && constraintWidget6 != constraintWidget3) {
                i9 = 8;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchor4.mTarget;
            if (constraintAnchor6 != null) {
                if (constraintWidget6 == constraintWidget3) {
                    linearSystem.addGreaterThan(constraintAnchor4.mSolverVariable, constraintAnchor6.mSolverVariable, i10, 6);
                } else {
                    linearSystem.addGreaterThan(constraintAnchor4.mSolverVariable, constraintAnchor6.mSolverVariable, i10, 8);
                }
                if (z8 && !z3) {
                    i9 = 5;
                }
                linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor4.mTarget.mSolverVariable, i10, (constraintWidget6 == constraintWidget3 && z3 && constraintWidget6.isInBarrier(i6)) ? 5 : i9);
            } else {
                constraintWidget = constraintWidget;
            }
            if (z5) {
                if (constraintWidget6.getVisibility() == 8 || constraintWidget6.mListDimensionBehaviors[i6] != dimensionBehaviour2) {
                    i5 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget6.mListAnchors;
                    i5 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget6.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i5, 8);
            }
            ConstraintAnchor constraintAnchor7 = constraintWidget6.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor7 != null) {
                ConstraintWidget constraintWidget8 = constraintAnchor7.mOwner;
                ConstraintAnchor constraintAnchor8 = constraintWidget8.mListAnchors[i2].mTarget;
                if (constraintAnchor8 != null && constraintAnchor8.mOwner == constraintWidget6) {
                    constraintWidget7 = constraintWidget8;
                }
            }
            if (constraintWidget7 != null) {
                constraintWidget6 = constraintWidget7;
                z7 = z7;
            } else {
                z7 = true;
            }
            constraintWidget5 = constraintWidget5;
            f2 = f3;
            constraintWidget = constraintWidget;
        }
        ConstraintWidget constraintWidget9 = constraintWidget5;
        float f4 = f2;
        ConstraintWidget constraintWidget10 = constraintWidget;
        if (constraintWidget4 != null) {
            int i11 = i2 + 1;
            if (constraintWidget2.mListAnchors[i11].mTarget != null) {
                ConstraintAnchor constraintAnchor9 = constraintWidget4.mListAnchors[i11];
                if (constraintWidget4.mListDimensionBehaviors[i6] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget4.mResolvedMatchConstraintDefault[i6] == 0 && !z3) {
                    ConstraintAnchor constraintAnchor10 = constraintAnchor9.mTarget;
                    if (constraintAnchor10.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor10.mSolverVariable, -constraintAnchor9.getMargin(), 5);
                    } else if (z3) {
                        constraintAnchor3 = constraintAnchor9.mTarget;
                        if (constraintAnchor3.mOwner == constraintWidgetContainer) {
                            linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor9.getMargin(), 4);
                        }
                    }
                } else if (z3) {
                    constraintAnchor3 = constraintAnchor9.mTarget;
                    if (constraintAnchor3.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor9.getMargin(), 4);
                    }
                }
                linearSystem.addLowerThan(constraintAnchor9.mSolverVariable, constraintWidget2.mListAnchors[i11].mTarget.mSolverVariable, -constraintAnchor9.getMargin(), 6);
            }
        }
        if (z5) {
            int i12 = i2 + 1;
            SolverVariable solverVariable4 = constraintWidgetContainer.mListAnchors[i12].mSolverVariable;
            ConstraintAnchor constraintAnchor11 = constraintWidget2.mListAnchors[i12];
            linearSystem.addGreaterThan(solverVariable4, constraintAnchor11.mSolverVariable, constraintAnchor11.getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f5 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f4 : chainHead.mWidgetsMatchCount;
            float f6 = 0.0f;
            float f7 = 0.0f;
            ConstraintWidget constraintWidget11 = null;
            int i13 = 0;
            while (i13 < size) {
                ConstraintWidget constraintWidget12 = arrayList.get(i13);
                float f8 = constraintWidget12.mWeight[i6];
                if (f8 < f6) {
                    if (chainHead.mHasComplexMatchWeights) {
                        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget12.mListAnchors;
                        linearSystem.addEquality(constraintAnchorArr2[i2 + 1].mSolverVariable, constraintAnchorArr2[i2].mSolverVariable, 0, 4);
                    } else {
                        f8 = 1.0f;
                        f6 = 0.0f;
                    }
                    arrayList = arrayList;
                    size = size;
                    i13++;
                    size = size;
                    arrayList = arrayList;
                    f6 = 0.0f;
                }
                if (f8 == f6) {
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget12.mListAnchors;
                    linearSystem.addEquality(constraintAnchorArr3[i2 + 1].mSolverVariable, constraintAnchorArr3[i2].mSolverVariable, 0, 8);
                    arrayList = arrayList;
                    size = size;
                } else {
                    if (constraintWidget11 != null) {
                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget11.mListAnchors;
                        SolverVariable solverVariable5 = constraintAnchorArr4[i2].mSolverVariable;
                        int i14 = i2 + 1;
                        SolverVariable solverVariable6 = constraintAnchorArr4[i14].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr5 = constraintWidget12.mListAnchors;
                        SolverVariable solverVariable7 = constraintAnchorArr5[i2].mSolverVariable;
                        SolverVariable solverVariable8 = constraintAnchorArr5[i14].mSolverVariable;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f7, f5, f8, solverVariable5, solverVariable6, solverVariable7, solverVariable8);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    }
                    constraintWidget11 = constraintWidget12;
                    f7 = f8;
                }
                i13++;
                size = size;
                arrayList = arrayList;
                f6 = 0.0f;
            }
        }
        if (constraintWidget3 != null && (constraintWidget3 == constraintWidget4 || z3)) {
            ConstraintAnchor constraintAnchor12 = constraintWidget10.mListAnchors[i2];
            int i15 = i2 + 1;
            ConstraintAnchor constraintAnchor13 = constraintWidget2.mListAnchors[i15];
            ConstraintAnchor constraintAnchor14 = constraintAnchor12.mTarget;
            SolverVariable solverVariable9 = constraintAnchor14 != null ? constraintAnchor14.mSolverVariable : null;
            ConstraintAnchor constraintAnchor15 = constraintAnchor13.mTarget;
            SolverVariable solverVariable10 = constraintAnchor15 != null ? constraintAnchor15.mSolverVariable : null;
            ConstraintAnchor constraintAnchor16 = constraintWidget3.mListAnchors[i2];
            if (constraintWidget4 != null) {
                constraintAnchor13 = constraintWidget4.mListAnchors[i15];
            }
            if (solverVariable9 != null && solverVariable10 != null) {
                if (i6 == 0) {
                    f = constraintWidget9.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget9.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor16.mSolverVariable, solverVariable9, constraintAnchor16.getMargin(), f, solverVariable10, constraintAnchor13.mSolverVariable, constraintAnchor13.getMargin(), 7);
            }
        } else if (!z6 || constraintWidget3 == null) {
            int i16 = 8;
            if (z4 && constraintWidget3 != null) {
                int i17 = chainHead.mWidgetsMatchCount;
                boolean z9 = i17 > 0 && chainHead.mWidgetsCount == i17;
                ConstraintWidget constraintWidget13 = constraintWidget3;
                ConstraintWidget constraintWidget14 = constraintWidget13;
                while (constraintWidget14 != null) {
                    ConstraintWidget constraintWidget15 = constraintWidget14.mNextChainWidget[i6];
                    while (constraintWidget15 != null && constraintWidget15.getVisibility() == i16) {
                        constraintWidget15 = constraintWidget15.mNextChainWidget[i6];
                    }
                    if (constraintWidget14 == constraintWidget3 || constraintWidget14 == constraintWidget4 || constraintWidget15 == null) {
                        constraintWidget13 = constraintWidget13;
                        i4 = i16;
                    } else {
                        ConstraintWidget constraintWidget16 = constraintWidget15 == constraintWidget4 ? null : constraintWidget15;
                        ConstraintAnchor constraintAnchor17 = constraintWidget14.mListAnchors[i2];
                        SolverVariable solverVariable11 = constraintAnchor17.mSolverVariable;
                        ConstraintAnchor constraintAnchor18 = constraintAnchor17.mTarget;
                        if (constraintAnchor18 != null) {
                            SolverVariable solverVariable12 = constraintAnchor18.mSolverVariable;
                        }
                        int i18 = i2 + 1;
                        SolverVariable solverVariable13 = constraintWidget13.mListAnchors[i18].mSolverVariable;
                        int margin2 = constraintAnchor17.getMargin();
                        int margin3 = constraintWidget14.mListAnchors[i18].getMargin();
                        if (constraintWidget16 != null) {
                            constraintAnchor = constraintWidget16.mListAnchors[i2];
                            SolverVariable solverVariable14 = constraintAnchor.mSolverVariable;
                            ConstraintAnchor constraintAnchor19 = constraintAnchor.mTarget;
                            solverVariable2 = constraintAnchor19 != null ? constraintAnchor19.mSolverVariable : null;
                            solverVariable = solverVariable14;
                        } else {
                            constraintAnchor = constraintWidget4.mListAnchors[i2];
                            solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                            solverVariable2 = constraintWidget14.mListAnchors[i18].mSolverVariable;
                        }
                        if (constraintAnchor != null) {
                            margin3 += constraintAnchor.getMargin();
                        }
                        int i19 = margin3;
                        int margin4 = constraintWidget13.mListAnchors[i18].getMargin();
                        int i20 = z9 ? 8 : 4;
                        if (solverVariable11 == null || solverVariable13 == null || solverVariable == null || solverVariable2 == null) {
                            i4 = 8;
                        } else {
                            i4 = 8;
                            linearSystem.addCentering(solverVariable11, solverVariable13, margin4 + margin2, 0.5f, solverVariable, solverVariable2, i19, i20);
                        }
                        constraintWidget15 = constraintWidget16;
                    }
                    constraintWidget13 = constraintWidget14.getVisibility() != i4 ? constraintWidget14 : constraintWidget13;
                    constraintWidget14 = constraintWidget15;
                    i16 = i4;
                    i6 = i;
                }
                ConstraintAnchor constraintAnchor20 = constraintWidget3.mListAnchors[i2];
                ConstraintAnchor constraintAnchor21 = constraintWidget10.mListAnchors[i2].mTarget;
                int i21 = i2 + 1;
                ConstraintAnchor constraintAnchor22 = constraintWidget4.mListAnchors[i21];
                ConstraintAnchor constraintAnchor23 = constraintWidget2.mListAnchors[i21].mTarget;
                if (constraintAnchor21 == null) {
                    i3 = 5;
                } else if (constraintWidget3 != constraintWidget4) {
                    i3 = 5;
                    linearSystem.addEquality(constraintAnchor20.mSolverVariable, constraintAnchor21.mSolverVariable, constraintAnchor20.getMargin(), 5);
                } else {
                    i3 = 5;
                    if (constraintAnchor23 != null) {
                        linearSystem.addCentering(constraintAnchor20.mSolverVariable, constraintAnchor21.mSolverVariable, constraintAnchor20.getMargin(), 0.5f, constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, constraintAnchor22.getMargin(), 5);
                    }
                }
                if (constraintAnchor23 != null && constraintWidget3 != constraintWidget4) {
                    linearSystem.addEquality(constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, -constraintAnchor22.getMargin(), i3);
                }
            }
        } else {
            int i22 = chainHead.mWidgetsMatchCount;
            boolean z10 = i22 > 0 && chainHead.mWidgetsCount == i22;
            ConstraintWidget constraintWidget17 = constraintWidget3;
            ConstraintWidget constraintWidget18 = constraintWidget17;
            while (constraintWidget18 != null) {
                ConstraintWidget constraintWidget19 = constraintWidget18.mNextChainWidget[i6];
                while (constraintWidget19 != null && constraintWidget19.getVisibility() == 8) {
                    constraintWidget19 = constraintWidget19.mNextChainWidget[i6];
                }
                if (constraintWidget19 != null || constraintWidget18 == constraintWidget4) {
                    ConstraintAnchor constraintAnchor24 = constraintWidget18.mListAnchors[i2];
                    SolverVariable solverVariable15 = constraintAnchor24.mSolverVariable;
                    ConstraintAnchor constraintAnchor25 = constraintAnchor24.mTarget;
                    SolverVariable solverVariable16 = constraintAnchor25 != null ? constraintAnchor25.mSolverVariable : null;
                    if (constraintWidget17 != constraintWidget18) {
                        solverVariable16 = constraintWidget17.mListAnchors[i2 + 1].mSolverVariable;
                    } else if (constraintWidget18 == constraintWidget3) {
                        ConstraintAnchor constraintAnchor26 = constraintWidget10.mListAnchors[i2].mTarget;
                        solverVariable16 = constraintAnchor26 != null ? constraintAnchor26.mSolverVariable : null;
                    }
                    int margin5 = constraintAnchor24.getMargin();
                    int i23 = i2 + 1;
                    int margin6 = constraintWidget18.mListAnchors[i23].getMargin();
                    if (constraintWidget19 != null) {
                        constraintAnchor2 = constraintWidget19.mListAnchors[i2];
                        solverVariable3 = constraintAnchor2.mSolverVariable;
                    } else {
                        constraintAnchor2 = constraintWidget2.mListAnchors[i23].mTarget;
                        if (constraintAnchor2 != null) {
                            solverVariable3 = constraintAnchor2.mSolverVariable;
                        } else {
                            solverVariable3 = null;
                        }
                        SolverVariable solverVariable17 = constraintWidget18.mListAnchors[i23].mSolverVariable;
                        if (constraintAnchor2 != null) {
                            margin6 += constraintAnchor2.getMargin();
                        }
                        int margin7 = margin5 + constraintWidget17.mListAnchors[i23].getMargin();
                        if (solverVariable15 == null && solverVariable16 != null && solverVariable3 != null && solverVariable17 != null) {
                            if (constraintWidget18 == constraintWidget3) {
                                margin7 = constraintWidget3.mListAnchors[i2].getMargin();
                            }
                            constraintWidget19 = constraintWidget19;
                            linearSystem.addCentering(solverVariable15, solverVariable16, margin7, 0.5f, solverVariable3, solverVariable17, constraintWidget18 == constraintWidget4 ? constraintWidget4.mListAnchors[i23].getMargin() : margin6, z10 ? 8 : 5);
                        }
                        if (constraintWidget18.getVisibility() != 8) {
                            constraintWidget18 = constraintWidget17;
                        }
                        constraintWidget17 = constraintWidget18;
                        constraintWidget18 = constraintWidget19;
                    }
                    SolverVariable solverVariable18 = constraintWidget18.mListAnchors[i23].mSolverVariable;
                    if (constraintAnchor2 != null) {
                        margin6 += constraintAnchor2.getMargin();
                    }
                    int margin8 = margin5 + constraintWidget17.mListAnchors[i23].getMargin();
                    if (solverVariable15 == null) {
                    }
                }
                if (constraintWidget18.getVisibility() != 8) {
                    constraintWidget18 = constraintWidget17;
                }
                constraintWidget17 = constraintWidget18;
                constraintWidget18 = constraintWidget19;
            }
        }
        if ((!z6 && !z4) || constraintWidget3 == null || constraintWidget3 == constraintWidget4) {
            return;
        }
        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget3.mListAnchors;
        ConstraintAnchor constraintAnchor27 = constraintAnchorArr6[i2];
        if (constraintWidget4 == null) {
            constraintWidget4 = constraintWidget3;
        }
        int i24 = i2 + 1;
        ConstraintAnchor constraintAnchor28 = constraintWidget4.mListAnchors[i24];
        ConstraintAnchor constraintAnchor29 = constraintAnchor27.mTarget;
        SolverVariable solverVariable19 = constraintAnchor29 != null ? constraintAnchor29.mSolverVariable : null;
        ConstraintAnchor constraintAnchor30 = constraintAnchor28.mTarget;
        SolverVariable solverVariable20 = constraintAnchor30 != null ? constraintAnchor30.mSolverVariable : null;
        if (constraintWidget2 != constraintWidget4) {
            ConstraintAnchor constraintAnchor31 = constraintWidget2.mListAnchors[i24].mTarget;
            solverVariable20 = constraintAnchor31 != null ? constraintAnchor31.mSolverVariable : null;
        }
        if (constraintWidget3 == constraintWidget4) {
            constraintAnchor28 = constraintAnchorArr6[i24];
        }
        if (solverVariable19 == null || solverVariable20 == null) {
            return;
        }
        linearSystem.addCentering(constraintAnchor27.mSolverVariable, solverVariable19, constraintAnchor27.getMargin(), 0.5f, solverVariable20, constraintAnchor28.mSolverVariable, constraintWidget4.mListAnchors[i24].getMargin(), 5);
    }
}
