package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class RowColumnMeasurePolicyKt {
    public static final MeasureResult measure(@NotNull RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, int i5, @NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, @NotNull Placeable[] placeableArr, int i6, int i7, @Nullable int[] iArr, int i8) {
        int[] iArr2;
        float f;
        long j;
        String str;
        String str2;
        String str3;
        int i9;
        String str4;
        RowColumnMeasurePolicy rowColumnMeasurePolicy2;
        int i10;
        int i11;
        int i12;
        long j2;
        String str5;
        String str6;
        float f2;
        String str7;
        int i13;
        String str8;
        String str9;
        long j3;
        FlowLayoutData flowLayoutData;
        float f3;
        String str10;
        long j4;
        long j5;
        String str11;
        String str12;
        int i14;
        String str13;
        int i15;
        int i16;
        int i17;
        int[] iArr3;
        FlowLayoutData flowLayoutData2;
        List<? extends Measurable> list2 = list;
        int i18 = i7;
        int i19 = i18 - i6;
        int[] iArr4 = new int[i19];
        int i20 = i6;
        long j6 = i5;
        float f4 = 0.0f;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        boolean z = false;
        int i24 = 0;
        while (i20 < i18) {
            int[] iArr5 = iArr4;
            Measurable measurable = list2.get(i20);
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable);
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            z = z || RowColumnImplKt.isRelative(rowColumnParentData);
            if (weight > 0.0f) {
                i22++;
                float f5 = f4 + weight;
                i20 = i20;
                j6 = j6;
                i19 = i19;
                f4 = f5;
                iArr3 = iArr5;
            } else {
                Integer numValueOf = (i4 == Integer.MAX_VALUE || rowColumnParentData == null || (flowLayoutData2 = rowColumnParentData.getFlowLayoutData()) == null) ? null : Integer.valueOf(Math.round(flowLayoutData2.getFillCrossAxisFraction() * i4));
                int i25 = i3 - i23;
                Placeable placeableMo2525measureBRTryo0 = placeableArr[i20];
                if (placeableMo2525measureBRTryo0 == null) {
                    placeableMo2525measureBRTryo0 = measurable.mo2525measureBRTryo0(RowColumnMeasurePolicy.m546createConstraintsxF2OJ5Q$default(rowColumnMeasurePolicy, 0, numValueOf != null ? numValueOf.intValue() : 0, i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : RangesKt___RangesKt.coerceAtLeast(i25, 0), numValueOf != null ? numValueOf.intValue() : i4, false, 16, null));
                }
                Placeable placeable = placeableMo2525measureBRTryo0;
                int iMainAxisSize = rowColumnMeasurePolicy.mainAxisSize(placeable);
                int iCrossAxisSize = rowColumnMeasurePolicy.crossAxisSize(placeable);
                iArr3 = iArr5;
                iArr3[i20 - i6] = iMainAxisSize;
                int iMin = Math.min(i5, RangesKt___RangesKt.coerceAtLeast(i25 - iMainAxisSize, 0));
                int i26 = iMainAxisSize + iMin + i23;
                int iMax = Math.max(i21, iCrossAxisSize);
                placeableArr[i20] = placeable;
                i21 = iMax;
                i24 = iMin;
                i23 = i26;
                i22 = i22;
            }
            i20++;
            iArr4 = iArr3;
            f4 = f4;
            i19 = i19;
            j6 = j6;
        }
        int i27 = i22;
        int i28 = i23;
        long j7 = j6;
        int i29 = i19;
        float f6 = f4;
        int[] iArr6 = iArr4;
        int iCoerceIn = 0;
        if (i27 == 0) {
            i11 = i28 - i24;
            rowColumnMeasurePolicy2 = rowColumnMeasurePolicy;
            i10 = 0;
            iArr2 = iArr6;
        } else {
            int i30 = i3 != Integer.MAX_VALUE ? i3 : i;
            long j8 = ((long) (i27 - 1)) * j7;
            int i31 = i21;
            long j9 = j8;
            long jCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((long) (i30 - i28)) - j8, 0L);
            float f7 = jCoerceAtLeast / f6;
            int i32 = i6;
            long jRound = jCoerceAtLeast;
            iArr2 = iArr6;
            while (true) {
                f = f6;
                j = jCoerceAtLeast;
                str = "targetSpace ";
                str2 = "weightChildrenCount ";
                str3 = "fixedSpace ";
                i9 = i28;
                str4 = "arrangementSpacingTotal ";
                if (i32 >= i18) {
                    break;
                }
                float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(list2.get(i32)));
                float f8 = f7 * weight2;
                try {
                    jRound -= (long) Math.round(f8);
                    i32++;
                    list2 = list;
                    i18 = i7;
                    f6 = f;
                    jCoerceAtLeast = j;
                    i28 = i9;
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax " + i3 + "mainAxisMin " + i + "targetSpace " + i30 + "arrangementSpacingPx " + j7 + "weightChildrenCount " + i27 + "fixedSpace " + i9 + "arrangementSpacingTotal " + j9 + "remainingToTarget " + j + "totalWeight " + f + "weightUnitSpace " + f7 + "itemWeight " + weight2 + "weightedSize " + f8).initCause(e);
                }
            }
            String str14 = "totalWeight ";
            float f9 = f;
            String str15 = "weightUnitSpace ";
            String str16 = "weightedSize ";
            String str17 = "remainingToTarget ";
            long j10 = j;
            int i33 = i9;
            long j11 = j7;
            int iMax2 = i31;
            int i34 = 0;
            int i35 = i6;
            while (i35 < i7) {
                if (placeableArr[i35] == null) {
                    Measurable measurable2 = list.get(i35);
                    RowColumnParentData rowColumnParentData2 = RowColumnImplKt.getRowColumnParentData(measurable2);
                    float weight3 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    String str18 = str;
                    int i36 = i33;
                    String str19 = str17;
                    String str20 = str16;
                    Integer numValueOf2 = (i4 == Integer.MAX_VALUE || rowColumnParentData2 == null || (flowLayoutData = rowColumnParentData2.getFlowLayoutData()) == null) ? null : Integer.valueOf(Math.round(flowLayoutData.getFillCrossAxisFraction() * i4));
                    if (weight3 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables");
                    }
                    int sign = MathKt__MathJVMKt.getSign(jRound);
                    int i37 = i27;
                    String str21 = str4;
                    jRound -= (long) sign;
                    float f10 = f7 * weight3;
                    int iMax3 = Math.max(0, Math.round(f10) + sign);
                    try {
                        f3 = f7;
                        j4 = j9;
                        j5 = j10;
                        str11 = str18;
                        str12 = str2;
                        i14 = i37;
                        str13 = str19;
                        str10 = str3;
                        i15 = i36;
                        j3 = j11;
                        try {
                            Placeable placeableMo2525measureBRTryo1 = measurable2.mo2525measureBRTryo0(rowColumnMeasurePolicy.mo436createConstraintsxF2OJ5Q((!RowColumnImplKt.getFill(rowColumnParentData2) || iMax3 == Integer.MAX_VALUE) ? 0 : iMax3, numValueOf2 != null ? numValueOf2.intValue() : 0, iMax3, numValueOf2 != null ? numValueOf2.intValue() : i4, true));
                            int iMainAxisSize2 = rowColumnMeasurePolicy.mainAxisSize(placeableMo2525measureBRTryo1);
                            int iCrossAxisSize2 = rowColumnMeasurePolicy.crossAxisSize(placeableMo2525measureBRTryo1);
                            iArr2[i35 - i6] = iMainAxisSize2;
                            i34 += iMainAxisSize2;
                            iMax2 = Math.max(iMax2, iCrossAxisSize2);
                            placeableArr[i35] = placeableMo2525measureBRTryo1;
                            str3 = str10;
                            str9 = str20;
                            str6 = str13;
                            i13 = i15;
                            str8 = str21;
                            f2 = f3;
                            j9 = j4;
                            j2 = j5;
                            str7 = str11;
                            str5 = str12;
                            i12 = i14;
                        } catch (IllegalArgumentException e2) {
                            e = e2;
                            throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + i3 + "mainAxisMin " + i + str11 + i30 + "arrangementSpacingPx " + j3 + str12 + i14 + str10 + i15 + str21 + j4 + str13 + j5 + str14 + f9 + str15 + f3 + "weight " + weight3 + str20 + f10 + "crossAxisDesiredSize " + numValueOf2 + "remainderUnit " + sign + "childMainAxisSize " + iMax3).initCause(e);
                        }
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        f3 = f7;
                        str10 = str3;
                        j4 = j9;
                        j5 = j10;
                        str11 = str18;
                        str12 = str2;
                        i14 = i37;
                        str13 = str19;
                        j3 = j11;
                        i15 = i36;
                    }
                } else {
                    i12 = i27;
                    j2 = j10;
                    str5 = str2;
                    str6 = str17;
                    f2 = f7;
                    str7 = str;
                    i13 = i33;
                    long j12 = j11;
                    str8 = str4;
                    str9 = str16;
                    j3 = j12;
                }
                i35++;
                str = str7;
                str2 = str5;
                i27 = i12;
                f9 = f9;
                str14 = str14;
                str15 = str15;
                str4 = str8;
                long j13 = j3;
                i33 = i13;
                f7 = f2;
                str17 = str6;
                str16 = str9;
                j11 = j13;
                j10 = j2;
            }
            rowColumnMeasurePolicy2 = rowColumnMeasurePolicy;
            int i38 = i33;
            i10 = 0;
            iCoerceIn = RangesKt___RangesKt.coerceIn((int) (((long) i34) + j9), 0, i3 - i38);
            i11 = i38;
            i21 = iMax2;
        }
        if (z) {
            int iMax4 = i10;
            int iMax5 = iMax4;
            for (int i39 = i6; i39 < i7; i39++) {
                Placeable placeable2 = placeableArr[i39];
                Intrinsics.checkNotNull(placeable2);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(placeable2));
                Integer numCalculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable2) : null;
                if (numCalculateAlignmentLinePosition$foundation_layout_release != null) {
                    int iIntValue = numCalculateAlignmentLinePosition$foundation_layout_release.intValue();
                    int iCrossAxisSize3 = rowColumnMeasurePolicy2.crossAxisSize(placeable2);
                    iMax4 = Math.max(iMax4, iIntValue != Integer.MIN_VALUE ? numCalculateAlignmentLinePosition$foundation_layout_release.intValue() : i10);
                    if (iIntValue == Integer.MIN_VALUE) {
                        iIntValue = iCrossAxisSize3;
                    }
                    iMax5 = Math.max(iMax5, iCrossAxisSize3 - iIntValue);
                }
            }
            int i40 = iMax5;
            i17 = iMax4;
            i16 = i40;
        } else {
            i16 = i10;
            i17 = i16;
        }
        int iMax6 = Math.max(RangesKt___RangesKt.coerceAtLeast(i11 + iCoerceIn, i10), i);
        int iMax7 = Math.max(i21, Math.max(i2, i16 + i17));
        int[] iArr7 = new int[i29];
        for (int i41 = i10; i41 < i29; i41++) {
            iArr7[i41] = i10;
        }
        rowColumnMeasurePolicy2.populateMainAxisPositions(iMax6, iArr2, iArr7, measureScope);
        return rowColumnMeasurePolicy.placeHelper(placeableArr, measureScope, i17, iArr7, iMax6, iMax7, iArr, i8, i6, i7);
    }
}
