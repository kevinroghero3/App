package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ContextualFlowLayoutKt {
    /* JADX WARN: Code duplicated, block: B:102:0x012c  */
    /* JADX WARN: Code duplicated, block: B:103:0x012e  */
    /* JADX WARN: Code duplicated, block: B:106:0x0132  */
    /* JADX WARN: Code duplicated, block: B:108:0x0136  */
    /* JADX WARN: Code duplicated, block: B:109:0x013d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0145  */
    /* JADX WARN: Code duplicated, block: B:115:0x0156  */
    /* JADX WARN: Code duplicated, block: B:116:0x0158  */
    /* JADX WARN: Code duplicated, block: B:119:0x015f  */
    /* JADX WARN: Code duplicated, block: B:121:0x0167  */
    /* JADX WARN: Code duplicated, block: B:124:0x0174  */
    /* JADX WARN: Code duplicated, block: B:125:0x0176  */
    /* JADX WARN: Code duplicated, block: B:128:0x017d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0185  */
    /* JADX WARN: Code duplicated, block: B:133:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:137:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x010f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0111  */
    /* JADX WARN: Code duplicated, block: B:96:0x0116  */
    /* JADX WARN: Code duplicated, block: B:98:0x011f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0126  */
    public static final void ContextualFlowRow(final int i, @Nullable Modifier modifier, @Nullable Arrangement.Horizontal horizontal, @Nullable Arrangement.Vertical vertical, int i2, int i3, @Nullable ContextualFlowRowOverflow contextualFlowRowOverflow, @NotNull final Function4<? super ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        Arrangement.Horizontal start;
        int i8;
        int i9;
        Arrangement.Vertical vertical2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Arrangement.Vertical top;
        int i19;
        ContextualFlowRowOverflow clip;
        int i20;
        boolean z;
        Object objRememberedValue;
        FlowLayoutOverflowState flowLayoutOverflowState;
        boolean z2;
        Object objRememberedValue2;
        Object obj;
        final Arrangement.Horizontal horizontal2;
        final ContextualFlowRowOverflow contextualFlowRowOverflow2;
        final int i21;
        final Modifier modifier3;
        final int i22;
        final Arrangement.Vertical vertical3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-341770689);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i23 = i5 & 2;
        if (i23 == 0) {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 != 0) {
                if ((i4 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 0) {
                    start = horizontal;
                    if (composerStartRestartGroup.changed(start)) {
                        i8 = 256;
                    } else {
                        i8 = 128;
                    }
                    i6 |= i8;
                }
                i9 = i5 & 8;
                if (i9 != 0) {
                    if ((i4 & 3072) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                            i10 = 2048;
                        } else {
                            i10 = 1024;
                        }
                        i6 |= i10;
                    }
                    i11 = i5 & 16;
                    if (i11 != 0) {
                        if ((i4 & 24576) == 0) {
                            i12 = i2;
                            if (composerStartRestartGroup.changed(i12)) {
                                i13 = 16384;
                            } else {
                                i13 = 8192;
                            }
                            i6 |= i13;
                        }
                        i14 = i5 & 32;
                        if (i14 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(i3)) {
                                i15 = 131072;
                            } else {
                                i15 = 65536;
                            }
                            i6 |= i15;
                        }
                        i16 = i5 & 64;
                        if (i16 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                                i17 = 1048576;
                            } else {
                                i17 = 524288;
                            }
                            i6 |= i17;
                        }
                        if ((i5 & 128) != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i18 = 8388608;
                            } else {
                                i18 = 4194304;
                            }
                            i6 |= i18;
                        }
                        if ((4793491 & i6) != 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            i21 = i3;
                            modifier3 = modifier2;
                            horizontal2 = start;
                            vertical3 = vertical2;
                            i22 = i12;
                            contextualFlowRowOverflow2 = contextualFlowRowOverflow;
                        } else {
                            if (i23 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i7 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if (i9 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if (i11 != 0) {
                                i19 = Integer.MAX_VALUE;
                            } else {
                                i19 = i12;
                            }
                            int i24 = i14 == 0 ? i3 : Integer.MAX_VALUE;
                            if (i16 != 0) {
                                clip = ContextualFlowRowOverflow.Companion.getClip();
                            } else {
                                clip = contextualFlowRowOverflow;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                            }
                            i20 = 3670016 & i6;
                            if (i20 == 1048576) {
                                z = true;
                            } else {
                                z = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            if (i20 == 1048576) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                obj = objRememberedValue2;
                                ArrayList arrayList = new ArrayList();
                                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList);
                                composerStartRestartGroup.updateRememberedValue(arrayList);
                                obj = arrayList;
                            }
                            obj = objRememberedValue2;
                            int i25 = i6 >> 6;
                            Arrangement.Vertical vertical4 = top;
                            SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                    invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i26, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i27) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-8464804, i27, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                                    }
                                    function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i26), composer2, Integer.valueOf((i27 << 3) & 112));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i25 & 896) | (i25 & 14) | 12582912 | (i25 & 112) | (i25 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            horizontal2 = start;
                            contextualFlowRowOverflow2 = clip;
                            i21 = i24;
                            modifier3 = modifier2;
                            i22 = i19;
                            vertical3 = vertical4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer2, int i26) {
                                    ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                }
                            });
                        }
                    }
                    i6 |= 24576;
                    i12 = i2;
                    i14 = i5 & 32;
                    if (i14 != 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i3)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i6 |= i15;
                    }
                    i16 = i5 & 64;
                    if (i16 != 0) {
                        i6 |= 1572864;
                    } else if ((i4 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                            i17 = 1048576;
                        } else {
                            i17 = 524288;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 128) != 0) {
                        i6 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i6 |= i18;
                    }
                    if ((4793491 & i6) != 4793490) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if (i9 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowRowOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList2 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList2);
                            composerStartRestartGroup.updateRememberedValue(arrayList2);
                            obj = arrayList2;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList3 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList3);
                            composerStartRestartGroup.updateRememberedValue(arrayList3);
                            obj = arrayList3;
                        }
                        obj = objRememberedValue2;
                        int i26 = i6 >> 6;
                        Arrangement.Vertical vertical5 = top;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i27, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i28) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-8464804, i28, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                                }
                                function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i27), composer2, Integer.valueOf((i28 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i26 & 896) | (i26 & 14) | 12582912 | (i26 & 112) | (i26 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal2 = start;
                        contextualFlowRowOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        vertical3 = vertical5;
                    } else {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if (i9 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowRowOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList4 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList4);
                            composerStartRestartGroup.updateRememberedValue(arrayList4);
                            obj = arrayList4;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList5 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList5);
                            composerStartRestartGroup.updateRememberedValue(arrayList5);
                            obj = arrayList5;
                        }
                        obj = objRememberedValue2;
                        int i27 = i6 >> 6;
                        Arrangement.Vertical vertical6 = top;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i28, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i29) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-8464804, i29, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                                }
                                function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i28), composer2, Integer.valueOf((i29 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i27 & 896) | (i27 & 14) | 12582912 | (i27 & 112) | (i27 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal2 = start;
                        contextualFlowRowOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        vertical3 = vertical6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i28) {
                                ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                            }
                        });
                    }
                }
                i6 |= 3072;
                vertical2 = vertical;
                i11 = i5 & 16;
                if (i11 != 0) {
                    if ((i4 & 24576) == 0) {
                        i12 = i2;
                        if (composerStartRestartGroup.changed(i12)) {
                            i13 = 16384;
                        } else {
                            i13 = 8192;
                        }
                        i6 |= i13;
                    }
                    i14 = i5 & 32;
                    if (i14 != 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i3)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i6 |= i15;
                    }
                    i16 = i5 & 64;
                    if (i16 != 0) {
                        i6 |= 1572864;
                    } else if ((i4 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                            i17 = 1048576;
                        } else {
                            i17 = 524288;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 128) != 0) {
                        i6 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i6 |= i18;
                    }
                    if ((4793491 & i6) != 4793490) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if (i9 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowRowOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList6 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList6);
                            composerStartRestartGroup.updateRememberedValue(arrayList6);
                            obj = arrayList6;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList7 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList7);
                            composerStartRestartGroup.updateRememberedValue(arrayList7);
                            obj = arrayList7;
                        }
                        obj = objRememberedValue2;
                        int i28 = i6 >> 6;
                        Arrangement.Vertical vertical7 = top;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i29, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i210) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-8464804, i210, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                                }
                                function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i29), composer2, Integer.valueOf((i210 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i28 & 896) | (i28 & 14) | 12582912 | (i28 & 112) | (i28 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal2 = start;
                        contextualFlowRowOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        vertical3 = vertical7;
                    } else {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if (i9 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowRowOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList8 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList8);
                            composerStartRestartGroup.updateRememberedValue(arrayList8);
                            obj = arrayList8;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList9 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList9);
                            composerStartRestartGroup.updateRememberedValue(arrayList9);
                            obj = arrayList9;
                        }
                        obj = objRememberedValue2;
                        int i29 = i6 >> 6;
                        Arrangement.Vertical vertical8 = top;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i210, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i211) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-8464804, i211, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                                }
                                function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i210), composer2, Integer.valueOf((i211 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i29 & 896) | (i29 & 14) | 12582912 | (i29 & 112) | (i29 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal2 = start;
                        contextualFlowRowOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        vertical3 = vertical8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i210) {
                                ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                            }
                        });
                    }
                }
                i6 |= 24576;
                i12 = i2;
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList10 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList10);
                        composerStartRestartGroup.updateRememberedValue(arrayList10);
                        obj = arrayList10;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList11 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11);
                        composerStartRestartGroup.updateRememberedValue(arrayList11);
                        obj = arrayList11;
                    }
                    obj = objRememberedValue2;
                    int i210 = i6 >> 6;
                    Arrangement.Vertical vertical9 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i211, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i212) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i212, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i211), composer2, Integer.valueOf((i212 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i210 & 896) | (i210 & 14) | 12582912 | (i210 & 112) | (i210 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical9;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList12 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList12);
                        composerStartRestartGroup.updateRememberedValue(arrayList12);
                        obj = arrayList12;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList13 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList13);
                        composerStartRestartGroup.updateRememberedValue(arrayList13);
                        obj = arrayList13;
                    }
                    obj = objRememberedValue2;
                    int i211 = i6 >> 6;
                    Arrangement.Vertical vertical10 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i212, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i213) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i213, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i212), composer2, Integer.valueOf((i213 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i211 & 896) | (i211 & 14) | 12582912 | (i211 & 112) | (i211 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i212) {
                            ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
            start = horizontal;
            i9 = i5 & 8;
            if (i9 != 0) {
                if ((i4 & 3072) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i10 = 2048;
                    } else {
                        i10 = 1024;
                    }
                    i6 |= i10;
                }
                i11 = i5 & 16;
                if (i11 != 0) {
                    if ((i4 & 24576) == 0) {
                        i12 = i2;
                        if (composerStartRestartGroup.changed(i12)) {
                            i13 = 16384;
                        } else {
                            i13 = 8192;
                        }
                        i6 |= i13;
                    }
                    i14 = i5 & 32;
                    if (i14 != 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i3)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i6 |= i15;
                    }
                    i16 = i5 & 64;
                    if (i16 != 0) {
                        i6 |= 1572864;
                    } else if ((i4 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                            i17 = 1048576;
                        } else {
                            i17 = 524288;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 128) != 0) {
                        i6 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i6 |= i18;
                    }
                    if ((4793491 & i6) != 4793490) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if (i9 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowRowOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList14 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList14);
                            composerStartRestartGroup.updateRememberedValue(arrayList14);
                            obj = arrayList14;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList15 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList15);
                            composerStartRestartGroup.updateRememberedValue(arrayList15);
                            obj = arrayList15;
                        }
                        obj = objRememberedValue2;
                        int i212 = i6 >> 6;
                        Arrangement.Vertical vertical11 = top;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i213, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i214) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-8464804, i214, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                                }
                                function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i213), composer2, Integer.valueOf((i214 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i212 & 896) | (i212 & 14) | 12582912 | (i212 & 112) | (i212 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal2 = start;
                        contextualFlowRowOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        vertical3 = vertical11;
                    } else {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if (i9 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowRowOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList16 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList16);
                            composerStartRestartGroup.updateRememberedValue(arrayList16);
                            obj = arrayList16;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList17 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList17);
                            composerStartRestartGroup.updateRememberedValue(arrayList17);
                            obj = arrayList17;
                        }
                        obj = objRememberedValue2;
                        int i213 = i6 >> 6;
                        Arrangement.Vertical vertical12 = top;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i214, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i215) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-8464804, i215, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                                }
                                function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i214), composer2, Integer.valueOf((i215 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i213 & 896) | (i213 & 14) | 12582912 | (i213 & 112) | (i213 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal2 = start;
                        contextualFlowRowOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        vertical3 = vertical12;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i214) {
                                ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                            }
                        });
                    }
                }
                i6 |= 24576;
                i12 = i2;
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList18 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList18);
                        composerStartRestartGroup.updateRememberedValue(arrayList18);
                        obj = arrayList18;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList19 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList19);
                        composerStartRestartGroup.updateRememberedValue(arrayList19);
                        obj = arrayList19;
                    }
                    obj = objRememberedValue2;
                    int i214 = i6 >> 6;
                    Arrangement.Vertical vertical13 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i215, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i216) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i216, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i215), composer2, Integer.valueOf((i216 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i214 & 896) | (i214 & 14) | 12582912 | (i214 & 112) | (i214 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical13;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList110 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList110);
                        composerStartRestartGroup.updateRememberedValue(arrayList110);
                        obj = arrayList110;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList111 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111);
                        composerStartRestartGroup.updateRememberedValue(arrayList111);
                        obj = arrayList111;
                    }
                    obj = objRememberedValue2;
                    int i215 = i6 >> 6;
                    Arrangement.Vertical vertical14 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i216, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i217) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i217, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i216), composer2, Integer.valueOf((i217 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i215 & 896) | (i215 & 14) | 12582912 | (i215 & 112) | (i215 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i216) {
                            ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= 3072;
            vertical2 = vertical;
            i11 = i5 & 16;
            if (i11 != 0) {
                if ((i4 & 24576) == 0) {
                    i12 = i2;
                    if (composerStartRestartGroup.changed(i12)) {
                        i13 = 16384;
                    } else {
                        i13 = 8192;
                    }
                    i6 |= i13;
                }
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList112 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList112);
                        composerStartRestartGroup.updateRememberedValue(arrayList112);
                        obj = arrayList112;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList113 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList113);
                        composerStartRestartGroup.updateRememberedValue(arrayList113);
                        obj = arrayList113;
                    }
                    obj = objRememberedValue2;
                    int i216 = i6 >> 6;
                    Arrangement.Vertical vertical15 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i217, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i218) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i218, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i217), composer2, Integer.valueOf((i218 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i216 & 896) | (i216 & 14) | 12582912 | (i216 & 112) | (i216 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical15;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList114 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList114);
                        composerStartRestartGroup.updateRememberedValue(arrayList114);
                        obj = arrayList114;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList115 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList115);
                        composerStartRestartGroup.updateRememberedValue(arrayList115);
                        obj = arrayList115;
                    }
                    obj = objRememberedValue2;
                    int i217 = i6 >> 6;
                    Arrangement.Vertical vertical16 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i218, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i219) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i219, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i218), composer2, Integer.valueOf((i219 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i217 & 896) | (i217 & 14) | 12582912 | (i217 & 112) | (i217 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i218) {
                            ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= 24576;
            i12 = i2;
            i14 = i5 & 32;
            if (i14 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i3)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i6 |= i15;
            }
            i16 = i5 & 64;
            if (i16 != 0) {
                i6 |= 1572864;
            } else if ((i4 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i6 |= i17;
            }
            if ((i5 & 128) != 0) {
                i6 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i6 |= i18;
            }
            if ((4793491 & i6) != 4793490) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if (i9 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowRowOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList116 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList116);
                    composerStartRestartGroup.updateRememberedValue(arrayList116);
                    obj = arrayList116;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList117 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList117);
                    composerStartRestartGroup.updateRememberedValue(arrayList117);
                    obj = arrayList117;
                }
                obj = objRememberedValue2;
                int i218 = i6 >> 6;
                Arrangement.Vertical vertical17 = top;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i219, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2110) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8464804, i2110, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                        }
                        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i219), composer2, Integer.valueOf((i2110 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i218 & 896) | (i218 & 14) | 12582912 | (i218 & 112) | (i218 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal2 = start;
                contextualFlowRowOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                vertical3 = vertical17;
            } else {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if (i9 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowRowOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList118 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList118);
                    composerStartRestartGroup.updateRememberedValue(arrayList118);
                    obj = arrayList118;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList119 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList119);
                    composerStartRestartGroup.updateRememberedValue(arrayList119);
                    obj = arrayList119;
                }
                obj = objRememberedValue2;
                int i219 = i6 >> 6;
                Arrangement.Vertical vertical18 = top;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2110, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2111) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8464804, i2111, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                        }
                        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2110), composer2, Integer.valueOf((i2111 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i219 & 896) | (i219 & 14) | 12582912 | (i219 & 112) | (i219 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal2 = start;
                contextualFlowRowOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                vertical3 = vertical18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i2110) {
                        ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
            }
        }
        i6 |= 48;
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 != 0) {
            if ((i4 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 0) {
                start = horizontal;
                if (composerStartRestartGroup.changed(start)) {
                    i8 = 256;
                } else {
                    i8 = 128;
                }
                i6 |= i8;
            }
            i9 = i5 & 8;
            if (i9 != 0) {
                if ((i4 & 3072) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i10 = 2048;
                    } else {
                        i10 = 1024;
                    }
                    i6 |= i10;
                }
                i11 = i5 & 16;
                if (i11 != 0) {
                    if ((i4 & 24576) == 0) {
                        i12 = i2;
                        if (composerStartRestartGroup.changed(i12)) {
                            i13 = 16384;
                        } else {
                            i13 = 8192;
                        }
                        i6 |= i13;
                    }
                    i14 = i5 & 32;
                    if (i14 != 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i3)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i6 |= i15;
                    }
                    i16 = i5 & 64;
                    if (i16 != 0) {
                        i6 |= 1572864;
                    } else if ((i4 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                            i17 = 1048576;
                        } else {
                            i17 = 524288;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 128) != 0) {
                        i6 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i6 |= i18;
                    }
                    if ((4793491 & i6) != 4793490) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if (i9 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowRowOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList1110 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1110);
                            composerStartRestartGroup.updateRememberedValue(arrayList1110);
                            obj = arrayList1110;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList1111 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1111);
                            composerStartRestartGroup.updateRememberedValue(arrayList1111);
                            obj = arrayList1111;
                        }
                        obj = objRememberedValue2;
                        int i2110 = i6 >> 6;
                        Arrangement.Vertical vertical19 = top;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i2111, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2112) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-8464804, i2112, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                                }
                                function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2111), composer2, Integer.valueOf((i2112 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2110 & 896) | (i2110 & 14) | 12582912 | (i2110 & 112) | (i2110 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal2 = start;
                        contextualFlowRowOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        vertical3 = vertical19;
                    } else {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if (i9 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowRowOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowRowOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList1112 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1112);
                            composerStartRestartGroup.updateRememberedValue(arrayList1112);
                            obj = arrayList1112;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList1113 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1113);
                            composerStartRestartGroup.updateRememberedValue(arrayList1113);
                            obj = arrayList1113;
                        }
                        obj = objRememberedValue2;
                        int i2111 = i6 >> 6;
                        Arrangement.Vertical vertical110 = top;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i2112, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2113) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-8464804, i2113, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                                }
                                function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2112), composer2, Integer.valueOf((i2113 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2111 & 896) | (i2111 & 14) | 12582912 | (i2111 & 112) | (i2111 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal2 = start;
                        contextualFlowRowOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        vertical3 = vertical110;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i2112) {
                                ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                            }
                        });
                    }
                }
                i6 |= 24576;
                i12 = i2;
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList1114 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1114);
                        composerStartRestartGroup.updateRememberedValue(arrayList1114);
                        obj = arrayList1114;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList1115 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1115);
                        composerStartRestartGroup.updateRememberedValue(arrayList1115);
                        obj = arrayList1115;
                    }
                    obj = objRememberedValue2;
                    int i2112 = i6 >> 6;
                    Arrangement.Vertical vertical111 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2113, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2114) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i2114, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2113), composer2, Integer.valueOf((i2114 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2112 & 896) | (i2112 & 14) | 12582912 | (i2112 & 112) | (i2112 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical111;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList1116 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1116);
                        composerStartRestartGroup.updateRememberedValue(arrayList1116);
                        obj = arrayList1116;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList1117 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1117);
                        composerStartRestartGroup.updateRememberedValue(arrayList1117);
                        obj = arrayList1117;
                    }
                    obj = objRememberedValue2;
                    int i2113 = i6 >> 6;
                    Arrangement.Vertical vertical112 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2114, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2115) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i2115, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2114), composer2, Integer.valueOf((i2115 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2113 & 896) | (i2113 & 14) | 12582912 | (i2113 & 112) | (i2113 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical112;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i2114) {
                            ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= 3072;
            vertical2 = vertical;
            i11 = i5 & 16;
            if (i11 != 0) {
                if ((i4 & 24576) == 0) {
                    i12 = i2;
                    if (composerStartRestartGroup.changed(i12)) {
                        i13 = 16384;
                    } else {
                        i13 = 8192;
                    }
                    i6 |= i13;
                }
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList1118 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1118);
                        composerStartRestartGroup.updateRememberedValue(arrayList1118);
                        obj = arrayList1118;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList1119 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1119);
                        composerStartRestartGroup.updateRememberedValue(arrayList1119);
                        obj = arrayList1119;
                    }
                    obj = objRememberedValue2;
                    int i2114 = i6 >> 6;
                    Arrangement.Vertical vertical113 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2115, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2116) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i2116, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2115), composer2, Integer.valueOf((i2116 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2114 & 896) | (i2114 & 14) | 12582912 | (i2114 & 112) | (i2114 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical113;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList11110 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11110);
                        composerStartRestartGroup.updateRememberedValue(arrayList11110);
                        obj = arrayList11110;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList11111 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11111);
                        composerStartRestartGroup.updateRememberedValue(arrayList11111);
                        obj = arrayList11111;
                    }
                    obj = objRememberedValue2;
                    int i2115 = i6 >> 6;
                    Arrangement.Vertical vertical114 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2116, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2117) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i2117, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2116), composer2, Integer.valueOf((i2117 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2115 & 896) | (i2115 & 14) | 12582912 | (i2115 & 112) | (i2115 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical114;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i2116) {
                            ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= 24576;
            i12 = i2;
            i14 = i5 & 32;
            if (i14 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i3)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i6 |= i15;
            }
            i16 = i5 & 64;
            if (i16 != 0) {
                i6 |= 1572864;
            } else if ((i4 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i6 |= i17;
            }
            if ((i5 & 128) != 0) {
                i6 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i6 |= i18;
            }
            if ((4793491 & i6) != 4793490) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if (i9 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowRowOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList11112 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11112);
                    composerStartRestartGroup.updateRememberedValue(arrayList11112);
                    obj = arrayList11112;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList11113 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11113);
                    composerStartRestartGroup.updateRememberedValue(arrayList11113);
                    obj = arrayList11113;
                }
                obj = objRememberedValue2;
                int i2116 = i6 >> 6;
                Arrangement.Vertical vertical115 = top;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2117, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2118) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8464804, i2118, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                        }
                        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2117), composer2, Integer.valueOf((i2118 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2116 & 896) | (i2116 & 14) | 12582912 | (i2116 & 112) | (i2116 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal2 = start;
                contextualFlowRowOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                vertical3 = vertical115;
            } else {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if (i9 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowRowOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList11114 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11114);
                    composerStartRestartGroup.updateRememberedValue(arrayList11114);
                    obj = arrayList11114;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList11115 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11115);
                    composerStartRestartGroup.updateRememberedValue(arrayList11115);
                    obj = arrayList11115;
                }
                obj = objRememberedValue2;
                int i2117 = i6 >> 6;
                Arrangement.Vertical vertical116 = top;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2118, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2119) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8464804, i2119, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                        }
                        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2118), composer2, Integer.valueOf((i2119 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2117 & 896) | (i2117 & 14) | 12582912 | (i2117 & 112) | (i2117 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal2 = start;
                contextualFlowRowOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                vertical3 = vertical116;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i2118) {
                        ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
            }
        }
        i6 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        start = horizontal;
        i9 = i5 & 8;
        if (i9 != 0) {
            if ((i4 & 3072) == 0) {
                vertical2 = vertical;
                if (composerStartRestartGroup.changed(vertical2)) {
                    i10 = 2048;
                } else {
                    i10 = 1024;
                }
                i6 |= i10;
            }
            i11 = i5 & 16;
            if (i11 != 0) {
                if ((i4 & 24576) == 0) {
                    i12 = i2;
                    if (composerStartRestartGroup.changed(i12)) {
                        i13 = 16384;
                    } else {
                        i13 = 8192;
                    }
                    i6 |= i13;
                }
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList11116 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11116);
                        composerStartRestartGroup.updateRememberedValue(arrayList11116);
                        obj = arrayList11116;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList11117 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11117);
                        composerStartRestartGroup.updateRememberedValue(arrayList11117);
                        obj = arrayList11117;
                    }
                    obj = objRememberedValue2;
                    int i2118 = i6 >> 6;
                    Arrangement.Vertical vertical117 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2119, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21110) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i21110, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2119), composer2, Integer.valueOf((i21110 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2118 & 896) | (i2118 & 14) | 12582912 | (i2118 & 112) | (i2118 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical117;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if (i9 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowRowOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowRowOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList11118 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11118);
                        composerStartRestartGroup.updateRememberedValue(arrayList11118);
                        obj = arrayList11118;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList11119 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11119);
                        composerStartRestartGroup.updateRememberedValue(arrayList11119);
                        obj = arrayList11119;
                    }
                    obj = objRememberedValue2;
                    int i2119 = i6 >> 6;
                    Arrangement.Vertical vertical118 = top;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i21110, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21111) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8464804, i21111, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                            }
                            function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21110), composer2, Integer.valueOf((i21111 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2119 & 896) | (i2119 & 14) | 12582912 | (i2119 & 112) | (i2119 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal2 = start;
                    contextualFlowRowOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    vertical3 = vertical118;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i21110) {
                            ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= 24576;
            i12 = i2;
            i14 = i5 & 32;
            if (i14 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i3)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i6 |= i15;
            }
            i16 = i5 & 64;
            if (i16 != 0) {
                i6 |= 1572864;
            } else if ((i4 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i6 |= i17;
            }
            if ((i5 & 128) != 0) {
                i6 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i6 |= i18;
            }
            if ((4793491 & i6) != 4793490) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if (i9 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowRowOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList111110 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111110);
                    composerStartRestartGroup.updateRememberedValue(arrayList111110);
                    obj = arrayList111110;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList111111 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111111);
                    composerStartRestartGroup.updateRememberedValue(arrayList111111);
                    obj = arrayList111111;
                }
                obj = objRememberedValue2;
                int i21110 = i6 >> 6;
                Arrangement.Vertical vertical119 = top;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i21111, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21112) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8464804, i21112, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                        }
                        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21111), composer2, Integer.valueOf((i21112 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21110 & 896) | (i21110 & 14) | 12582912 | (i21110 & 112) | (i21110 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal2 = start;
                contextualFlowRowOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                vertical3 = vertical119;
            } else {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if (i9 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowRowOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList111112 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111112);
                    composerStartRestartGroup.updateRememberedValue(arrayList111112);
                    obj = arrayList111112;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList111113 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111113);
                    composerStartRestartGroup.updateRememberedValue(arrayList111113);
                    obj = arrayList111113;
                }
                obj = objRememberedValue2;
                int i21111 = i6 >> 6;
                Arrangement.Vertical vertical1110 = top;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i21112, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21113) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8464804, i21113, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                        }
                        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21112), composer2, Integer.valueOf((i21113 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21111 & 896) | (i21111 & 14) | 12582912 | (i21111 & 112) | (i21111 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal2 = start;
                contextualFlowRowOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                vertical3 = vertical1110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i21112) {
                        ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
            }
        }
        i6 |= 3072;
        vertical2 = vertical;
        i11 = i5 & 16;
        if (i11 != 0) {
            if ((i4 & 24576) == 0) {
                i12 = i2;
                if (composerStartRestartGroup.changed(i12)) {
                    i13 = 16384;
                } else {
                    i13 = 8192;
                }
                i6 |= i13;
            }
            i14 = i5 & 32;
            if (i14 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i3)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i6 |= i15;
            }
            i16 = i5 & 64;
            if (i16 != 0) {
                i6 |= 1572864;
            } else if ((i4 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i6 |= i17;
            }
            if ((i5 & 128) != 0) {
                i6 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i6 |= i18;
            }
            if ((4793491 & i6) != 4793490) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if (i9 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowRowOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList111114 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111114);
                    composerStartRestartGroup.updateRememberedValue(arrayList111114);
                    obj = arrayList111114;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList111115 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111115);
                    composerStartRestartGroup.updateRememberedValue(arrayList111115);
                    obj = arrayList111115;
                }
                obj = objRememberedValue2;
                int i21112 = i6 >> 6;
                Arrangement.Vertical vertical1111 = top;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i21113, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21114) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8464804, i21114, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                        }
                        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21113), composer2, Integer.valueOf((i21114 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21112 & 896) | (i21112 & 14) | 12582912 | (i21112 & 112) | (i21112 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal2 = start;
                contextualFlowRowOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                vertical3 = vertical1111;
            } else {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if (i9 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowRowOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowRowOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList111116 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111116);
                    composerStartRestartGroup.updateRememberedValue(arrayList111116);
                    obj = arrayList111116;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList111117 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111117);
                    composerStartRestartGroup.updateRememberedValue(arrayList111117);
                    obj = arrayList111117;
                }
                obj = objRememberedValue2;
                int i21113 = i6 >> 6;
                Arrangement.Vertical vertical1112 = top;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i21114, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21115) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8464804, i21115, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                        }
                        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21114), composer2, Integer.valueOf((i21115 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21113 & 896) | (i21113 & 14) | 12582912 | (i21113 & 112) | (i21113 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal2 = start;
                contextualFlowRowOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                vertical3 = vertical1112;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i21114) {
                        ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
            }
        }
        i6 |= 24576;
        i12 = i2;
        i14 = i5 & 32;
        if (i14 != 0) {
            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(i3)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i6 |= i15;
        }
        i16 = i5 & 64;
        if (i16 != 0) {
            i6 |= 1572864;
        } else if ((i4 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(contextualFlowRowOverflow)) {
                i17 = 1048576;
            } else {
                i17 = 524288;
            }
            i6 |= i17;
        }
        if ((i5 & 128) != 0) {
            i6 |= 12582912;
        } else if ((i4 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i18 = 8388608;
            } else {
                i18 = 4194304;
            }
            i6 |= i18;
        }
        if ((4793491 & i6) != 4793490) {
            if (i23 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (i7 != 0) {
                start = Arrangement.INSTANCE.getStart();
            }
            if (i9 != 0) {
                top = Arrangement.INSTANCE.getTop();
            } else {
                top = vertical2;
            }
            if (i11 != 0) {
                i19 = Integer.MAX_VALUE;
            } else {
                i19 = i12;
            }
            if (i14 == 0) {
            }
            if (i16 != 0) {
                clip = ContextualFlowRowOverflow.Companion.getClip();
            } else {
                clip = contextualFlowRowOverflow;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
            }
            i20 = 3670016 & i6;
            if (i20 == 1048576) {
                z = true;
            } else {
                z = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
            if (i20 == 1048576) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                obj = objRememberedValue2;
                ArrayList arrayList111118 = new ArrayList();
                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111118);
                composerStartRestartGroup.updateRememberedValue(arrayList111118);
                obj = arrayList111118;
            } else {
                obj = objRememberedValue2;
                ArrayList arrayList111119 = new ArrayList();
                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111119);
                composerStartRestartGroup.updateRememberedValue(arrayList111119);
                obj = arrayList111119;
            }
            obj = objRememberedValue2;
            int i21114 = i6 >> 6;
            Arrangement.Vertical vertical1113 = top;
            SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                    invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i21115, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21116) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8464804, i21116, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                    }
                    function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21115), composer2, Integer.valueOf((i21116 << 3) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21114 & 896) | (i21114 & 14) | 12582912 | (i21114 & 112) | (i21114 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            horizontal2 = start;
            contextualFlowRowOverflow2 = clip;
            i21 = i24;
            modifier3 = modifier2;
            i22 = i19;
            vertical3 = vertical1113;
        } else {
            if (i23 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (i7 != 0) {
                start = Arrangement.INSTANCE.getStart();
            }
            if (i9 != 0) {
                top = Arrangement.INSTANCE.getTop();
            } else {
                top = vertical2;
            }
            if (i11 != 0) {
                i19 = Integer.MAX_VALUE;
            } else {
                i19 = i12;
            }
            if (i14 == 0) {
            }
            if (i16 != 0) {
                clip = ContextualFlowRowOverflow.Companion.getClip();
            } else {
                clip = contextualFlowRowOverflow;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-341770689, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
            }
            i20 = 3670016 & i6;
            if (i20 == 1048576) {
                z = true;
            } else {
                z = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
            if (i20 == 1048576) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                obj = objRememberedValue2;
                ArrayList arrayList1111110 = new ArrayList();
                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1111110);
                composerStartRestartGroup.updateRememberedValue(arrayList1111110);
                obj = arrayList1111110;
            } else {
                obj = objRememberedValue2;
                ArrayList arrayList1111111 = new ArrayList();
                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1111111);
                composerStartRestartGroup.updateRememberedValue(arrayList1111111);
                obj = arrayList1111111;
            }
            obj = objRememberedValue2;
            int i21115 = i6 >> 6;
            Arrangement.Vertical vertical1114 = top;
            SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                    invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i21116, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21117) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8464804, i21117, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                    }
                    function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21116), composer2, Integer.valueOf((i21117 << 3) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21115 & 896) | (i21115 & 14) | 12582912 | (i21115 & 112) | (i21115 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            horizontal2 = start;
            contextualFlowRowOverflow2 = clip;
            i21 = i24;
            modifier3 = modifier2;
            i22 = i19;
            vertical3 = vertical1114;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i21116) {
                    ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal2, vertical3, i22, i21, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x012c  */
    /* JADX WARN: Code duplicated, block: B:103:0x012e  */
    /* JADX WARN: Code duplicated, block: B:106:0x0132  */
    /* JADX WARN: Code duplicated, block: B:108:0x0136  */
    /* JADX WARN: Code duplicated, block: B:109:0x013d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0145  */
    /* JADX WARN: Code duplicated, block: B:115:0x0156  */
    /* JADX WARN: Code duplicated, block: B:116:0x0158  */
    /* JADX WARN: Code duplicated, block: B:119:0x015f  */
    /* JADX WARN: Code duplicated, block: B:121:0x0167  */
    /* JADX WARN: Code duplicated, block: B:124:0x0174  */
    /* JADX WARN: Code duplicated, block: B:125:0x0176  */
    /* JADX WARN: Code duplicated, block: B:128:0x017d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0185  */
    /* JADX WARN: Code duplicated, block: B:133:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:137:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x010f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0111  */
    /* JADX WARN: Code duplicated, block: B:96:0x0116  */
    /* JADX WARN: Code duplicated, block: B:98:0x011f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0126  */
    public static final void ContextualFlowColumn(final int i, @Nullable Modifier modifier, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, int i2, int i3, @Nullable ContextualFlowColumnOverflow contextualFlowColumnOverflow, @NotNull final Function4<? super ContextualFlowColumnScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        Arrangement.Vertical top;
        int i8;
        int i9;
        Arrangement.Horizontal horizontal2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Arrangement.Horizontal start;
        int i19;
        ContextualFlowColumnOverflow clip;
        int i20;
        boolean z;
        Object objRememberedValue;
        FlowLayoutOverflowState flowLayoutOverflowState;
        boolean z2;
        Object objRememberedValue2;
        Object obj;
        final Arrangement.Vertical vertical2;
        final ContextualFlowColumnOverflow contextualFlowColumnOverflow2;
        final int i21;
        final Modifier modifier3;
        final int i22;
        final Arrangement.Horizontal horizontal3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-588476895);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i23 = i5 & 2;
        if (i23 == 0) {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 != 0) {
                if ((i4 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 0) {
                    top = vertical;
                    if (composerStartRestartGroup.changed(top)) {
                        i8 = 256;
                    } else {
                        i8 = 128;
                    }
                    i6 |= i8;
                }
                i9 = i5 & 8;
                if (i9 != 0) {
                    if ((i4 & 3072) == 0) {
                        horizontal2 = horizontal;
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i10 = 2048;
                        } else {
                            i10 = 1024;
                        }
                        i6 |= i10;
                    }
                    i11 = i5 & 16;
                    if (i11 != 0) {
                        if ((i4 & 24576) == 0) {
                            i12 = i2;
                            if (composerStartRestartGroup.changed(i12)) {
                                i13 = 16384;
                            } else {
                                i13 = 8192;
                            }
                            i6 |= i13;
                        }
                        i14 = i5 & 32;
                        if (i14 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(i3)) {
                                i15 = 131072;
                            } else {
                                i15 = 65536;
                            }
                            i6 |= i15;
                        }
                        i16 = i5 & 64;
                        if (i16 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                                i17 = 1048576;
                            } else {
                                i17 = 524288;
                            }
                            i6 |= i17;
                        }
                        if ((i5 & 128) != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i18 = 8388608;
                            } else {
                                i18 = 4194304;
                            }
                            i6 |= i18;
                        }
                        if ((4793491 & i6) != 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            i21 = i3;
                            modifier3 = modifier2;
                            vertical2 = top;
                            horizontal3 = horizontal2;
                            i22 = i12;
                            contextualFlowColumnOverflow2 = contextualFlowColumnOverflow;
                        } else {
                            if (i23 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i7 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            }
                            if (i9 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if (i11 != 0) {
                                i19 = Integer.MAX_VALUE;
                            } else {
                                i19 = i12;
                            }
                            int i24 = i14 == 0 ? i3 : Integer.MAX_VALUE;
                            if (i16 != 0) {
                                clip = ContextualFlowColumnOverflow.Companion.getClip();
                            } else {
                                clip = contextualFlowColumnOverflow;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                            }
                            i20 = 3670016 & i6;
                            if (i20 == 1048576) {
                                z = true;
                            } else {
                                z = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            if (i20 == 1048576) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                obj = objRememberedValue2;
                                ArrayList arrayList = new ArrayList();
                                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList);
                                composerStartRestartGroup.updateRememberedValue(arrayList);
                                obj = arrayList;
                            }
                            obj = objRememberedValue2;
                            int i25 = i6 >> 6;
                            Arrangement.Horizontal horizontal4 = start;
                            SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                    invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i26, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i27) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(302435318, i27, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                                    }
                                    function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i26), composer2, Integer.valueOf((i27 << 3) & 112));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i25 & 896) | (i25 & 14) | 12582912 | (i25 & 112) | (i25 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            vertical2 = top;
                            contextualFlowColumnOverflow2 = clip;
                            i21 = i24;
                            modifier3 = modifier2;
                            i22 = i19;
                            horizontal3 = horizontal4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer2, int i26) {
                                    ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                }
                            });
                        }
                    }
                    i6 |= 24576;
                    i12 = i2;
                    i14 = i5 & 32;
                    if (i14 != 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i3)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i6 |= i15;
                    }
                    i16 = i5 & 64;
                    if (i16 != 0) {
                        i6 |= 1572864;
                    } else if ((i4 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                            i17 = 1048576;
                        } else {
                            i17 = 524288;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 128) != 0) {
                        i6 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i6 |= i18;
                    }
                    if ((4793491 & i6) != 4793490) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        }
                        if (i9 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowColumnOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList2 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList2);
                            composerStartRestartGroup.updateRememberedValue(arrayList2);
                            obj = arrayList2;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList3 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList3);
                            composerStartRestartGroup.updateRememberedValue(arrayList3);
                            obj = arrayList3;
                        }
                        obj = objRememberedValue2;
                        int i26 = i6 >> 6;
                        Arrangement.Horizontal horizontal5 = start;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i27, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i28) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(302435318, i28, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                                }
                                function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i27), composer2, Integer.valueOf((i28 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i26 & 896) | (i26 & 14) | 12582912 | (i26 & 112) | (i26 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical2 = top;
                        contextualFlowColumnOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        horizontal3 = horizontal5;
                    } else {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        }
                        if (i9 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowColumnOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList4 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList4);
                            composerStartRestartGroup.updateRememberedValue(arrayList4);
                            obj = arrayList4;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList5 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList5);
                            composerStartRestartGroup.updateRememberedValue(arrayList5);
                            obj = arrayList5;
                        }
                        obj = objRememberedValue2;
                        int i27 = i6 >> 6;
                        Arrangement.Horizontal horizontal6 = start;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i28, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i29) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(302435318, i29, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                                }
                                function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i28), composer2, Integer.valueOf((i29 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i27 & 896) | (i27 & 14) | 12582912 | (i27 & 112) | (i27 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical2 = top;
                        contextualFlowColumnOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        horizontal3 = horizontal6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i28) {
                                ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                            }
                        });
                    }
                }
                i6 |= 3072;
                horizontal2 = horizontal;
                i11 = i5 & 16;
                if (i11 != 0) {
                    if ((i4 & 24576) == 0) {
                        i12 = i2;
                        if (composerStartRestartGroup.changed(i12)) {
                            i13 = 16384;
                        } else {
                            i13 = 8192;
                        }
                        i6 |= i13;
                    }
                    i14 = i5 & 32;
                    if (i14 != 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i3)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i6 |= i15;
                    }
                    i16 = i5 & 64;
                    if (i16 != 0) {
                        i6 |= 1572864;
                    } else if ((i4 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                            i17 = 1048576;
                        } else {
                            i17 = 524288;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 128) != 0) {
                        i6 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i6 |= i18;
                    }
                    if ((4793491 & i6) != 4793490) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        }
                        if (i9 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowColumnOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList6 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList6);
                            composerStartRestartGroup.updateRememberedValue(arrayList6);
                            obj = arrayList6;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList7 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList7);
                            composerStartRestartGroup.updateRememberedValue(arrayList7);
                            obj = arrayList7;
                        }
                        obj = objRememberedValue2;
                        int i28 = i6 >> 6;
                        Arrangement.Horizontal horizontal7 = start;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i29, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i210) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(302435318, i210, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                                }
                                function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i29), composer2, Integer.valueOf((i210 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i28 & 896) | (i28 & 14) | 12582912 | (i28 & 112) | (i28 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical2 = top;
                        contextualFlowColumnOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        horizontal3 = horizontal7;
                    } else {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        }
                        if (i9 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowColumnOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList8 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList8);
                            composerStartRestartGroup.updateRememberedValue(arrayList8);
                            obj = arrayList8;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList9 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList9);
                            composerStartRestartGroup.updateRememberedValue(arrayList9);
                            obj = arrayList9;
                        }
                        obj = objRememberedValue2;
                        int i29 = i6 >> 6;
                        Arrangement.Horizontal horizontal8 = start;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i210, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i211) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(302435318, i211, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                                }
                                function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i210), composer2, Integer.valueOf((i211 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i29 & 896) | (i29 & 14) | 12582912 | (i29 & 112) | (i29 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical2 = top;
                        contextualFlowColumnOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        horizontal3 = horizontal8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i210) {
                                ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                            }
                        });
                    }
                }
                i6 |= 24576;
                i12 = i2;
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList10 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList10);
                        composerStartRestartGroup.updateRememberedValue(arrayList10);
                        obj = arrayList10;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList11 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11);
                        composerStartRestartGroup.updateRememberedValue(arrayList11);
                        obj = arrayList11;
                    }
                    obj = objRememberedValue2;
                    int i210 = i6 >> 6;
                    Arrangement.Horizontal horizontal9 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i211, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i212) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i212, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i211), composer2, Integer.valueOf((i212 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i210 & 896) | (i210 & 14) | 12582912 | (i210 & 112) | (i210 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal9;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList12 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList12);
                        composerStartRestartGroup.updateRememberedValue(arrayList12);
                        obj = arrayList12;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList13 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList13);
                        composerStartRestartGroup.updateRememberedValue(arrayList13);
                        obj = arrayList13;
                    }
                    obj = objRememberedValue2;
                    int i211 = i6 >> 6;
                    Arrangement.Horizontal horizontal10 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i212, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i213) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i213, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i212), composer2, Integer.valueOf((i213 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i211 & 896) | (i211 & 14) | 12582912 | (i211 & 112) | (i211 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i212) {
                            ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
            top = vertical;
            i9 = i5 & 8;
            if (i9 != 0) {
                if ((i4 & 3072) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i10 = 2048;
                    } else {
                        i10 = 1024;
                    }
                    i6 |= i10;
                }
                i11 = i5 & 16;
                if (i11 != 0) {
                    if ((i4 & 24576) == 0) {
                        i12 = i2;
                        if (composerStartRestartGroup.changed(i12)) {
                            i13 = 16384;
                        } else {
                            i13 = 8192;
                        }
                        i6 |= i13;
                    }
                    i14 = i5 & 32;
                    if (i14 != 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i3)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i6 |= i15;
                    }
                    i16 = i5 & 64;
                    if (i16 != 0) {
                        i6 |= 1572864;
                    } else if ((i4 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                            i17 = 1048576;
                        } else {
                            i17 = 524288;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 128) != 0) {
                        i6 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i6 |= i18;
                    }
                    if ((4793491 & i6) != 4793490) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        }
                        if (i9 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowColumnOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList14 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList14);
                            composerStartRestartGroup.updateRememberedValue(arrayList14);
                            obj = arrayList14;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList15 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList15);
                            composerStartRestartGroup.updateRememberedValue(arrayList15);
                            obj = arrayList15;
                        }
                        obj = objRememberedValue2;
                        int i212 = i6 >> 6;
                        Arrangement.Horizontal horizontal11 = start;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i213, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i214) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(302435318, i214, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                                }
                                function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i213), composer2, Integer.valueOf((i214 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i212 & 896) | (i212 & 14) | 12582912 | (i212 & 112) | (i212 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical2 = top;
                        contextualFlowColumnOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        horizontal3 = horizontal11;
                    } else {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        }
                        if (i9 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowColumnOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList16 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList16);
                            composerStartRestartGroup.updateRememberedValue(arrayList16);
                            obj = arrayList16;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList17 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList17);
                            composerStartRestartGroup.updateRememberedValue(arrayList17);
                            obj = arrayList17;
                        }
                        obj = objRememberedValue2;
                        int i213 = i6 >> 6;
                        Arrangement.Horizontal horizontal12 = start;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i214, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i215) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(302435318, i215, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                                }
                                function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i214), composer2, Integer.valueOf((i215 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i213 & 896) | (i213 & 14) | 12582912 | (i213 & 112) | (i213 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical2 = top;
                        contextualFlowColumnOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        horizontal3 = horizontal12;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i214) {
                                ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                            }
                        });
                    }
                }
                i6 |= 24576;
                i12 = i2;
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList18 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList18);
                        composerStartRestartGroup.updateRememberedValue(arrayList18);
                        obj = arrayList18;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList19 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList19);
                        composerStartRestartGroup.updateRememberedValue(arrayList19);
                        obj = arrayList19;
                    }
                    obj = objRememberedValue2;
                    int i214 = i6 >> 6;
                    Arrangement.Horizontal horizontal13 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i215, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i216) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i216, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i215), composer2, Integer.valueOf((i216 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i214 & 896) | (i214 & 14) | 12582912 | (i214 & 112) | (i214 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal13;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList110 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList110);
                        composerStartRestartGroup.updateRememberedValue(arrayList110);
                        obj = arrayList110;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList111 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111);
                        composerStartRestartGroup.updateRememberedValue(arrayList111);
                        obj = arrayList111;
                    }
                    obj = objRememberedValue2;
                    int i215 = i6 >> 6;
                    Arrangement.Horizontal horizontal14 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i216, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i217) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i217, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i216), composer2, Integer.valueOf((i217 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i215 & 896) | (i215 & 14) | 12582912 | (i215 & 112) | (i215 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i216) {
                            ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= 3072;
            horizontal2 = horizontal;
            i11 = i5 & 16;
            if (i11 != 0) {
                if ((i4 & 24576) == 0) {
                    i12 = i2;
                    if (composerStartRestartGroup.changed(i12)) {
                        i13 = 16384;
                    } else {
                        i13 = 8192;
                    }
                    i6 |= i13;
                }
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList112 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList112);
                        composerStartRestartGroup.updateRememberedValue(arrayList112);
                        obj = arrayList112;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList113 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList113);
                        composerStartRestartGroup.updateRememberedValue(arrayList113);
                        obj = arrayList113;
                    }
                    obj = objRememberedValue2;
                    int i216 = i6 >> 6;
                    Arrangement.Horizontal horizontal15 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i217, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i218) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i218, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i217), composer2, Integer.valueOf((i218 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i216 & 896) | (i216 & 14) | 12582912 | (i216 & 112) | (i216 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal15;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList114 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList114);
                        composerStartRestartGroup.updateRememberedValue(arrayList114);
                        obj = arrayList114;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList115 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList115);
                        composerStartRestartGroup.updateRememberedValue(arrayList115);
                        obj = arrayList115;
                    }
                    obj = objRememberedValue2;
                    int i217 = i6 >> 6;
                    Arrangement.Horizontal horizontal16 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i218, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i219) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i219, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i218), composer2, Integer.valueOf((i219 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i217 & 896) | (i217 & 14) | 12582912 | (i217 & 112) | (i217 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i218) {
                            ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= 24576;
            i12 = i2;
            i14 = i5 & 32;
            if (i14 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i3)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i6 |= i15;
            }
            i16 = i5 & 64;
            if (i16 != 0) {
                i6 |= 1572864;
            } else if ((i4 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i6 |= i17;
            }
            if ((i5 & 128) != 0) {
                i6 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i6 |= i18;
            }
            if ((4793491 & i6) != 4793490) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                }
                if (i9 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowColumnOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList116 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList116);
                    composerStartRestartGroup.updateRememberedValue(arrayList116);
                    obj = arrayList116;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList117 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList117);
                    composerStartRestartGroup.updateRememberedValue(arrayList117);
                    obj = arrayList117;
                }
                obj = objRememberedValue2;
                int i218 = i6 >> 6;
                Arrangement.Horizontal horizontal17 = start;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i219, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2110) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(302435318, i2110, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                        }
                        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i219), composer2, Integer.valueOf((i2110 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i218 & 896) | (i218 & 14) | 12582912 | (i218 & 112) | (i218 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical2 = top;
                contextualFlowColumnOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                horizontal3 = horizontal17;
            } else {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                }
                if (i9 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowColumnOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList118 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList118);
                    composerStartRestartGroup.updateRememberedValue(arrayList118);
                    obj = arrayList118;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList119 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList119);
                    composerStartRestartGroup.updateRememberedValue(arrayList119);
                    obj = arrayList119;
                }
                obj = objRememberedValue2;
                int i219 = i6 >> 6;
                Arrangement.Horizontal horizontal18 = start;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2110, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2111) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(302435318, i2111, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                        }
                        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2110), composer2, Integer.valueOf((i2111 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i219 & 896) | (i219 & 14) | 12582912 | (i219 & 112) | (i219 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical2 = top;
                contextualFlowColumnOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                horizontal3 = horizontal18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i2110) {
                        ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
            }
        }
        i6 |= 48;
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 != 0) {
            if ((i4 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 0) {
                top = vertical;
                if (composerStartRestartGroup.changed(top)) {
                    i8 = 256;
                } else {
                    i8 = 128;
                }
                i6 |= i8;
            }
            i9 = i5 & 8;
            if (i9 != 0) {
                if ((i4 & 3072) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i10 = 2048;
                    } else {
                        i10 = 1024;
                    }
                    i6 |= i10;
                }
                i11 = i5 & 16;
                if (i11 != 0) {
                    if ((i4 & 24576) == 0) {
                        i12 = i2;
                        if (composerStartRestartGroup.changed(i12)) {
                            i13 = 16384;
                        } else {
                            i13 = 8192;
                        }
                        i6 |= i13;
                    }
                    i14 = i5 & 32;
                    if (i14 != 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i3)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i6 |= i15;
                    }
                    i16 = i5 & 64;
                    if (i16 != 0) {
                        i6 |= 1572864;
                    } else if ((i4 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                            i17 = 1048576;
                        } else {
                            i17 = 524288;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 128) != 0) {
                        i6 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i6 |= i18;
                    }
                    if ((4793491 & i6) != 4793490) {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        }
                        if (i9 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowColumnOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList1110 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1110);
                            composerStartRestartGroup.updateRememberedValue(arrayList1110);
                            obj = arrayList1110;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList1111 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1111);
                            composerStartRestartGroup.updateRememberedValue(arrayList1111);
                            obj = arrayList1111;
                        }
                        obj = objRememberedValue2;
                        int i2110 = i6 >> 6;
                        Arrangement.Horizontal horizontal19 = start;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i2111, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2112) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(302435318, i2112, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                                }
                                function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2111), composer2, Integer.valueOf((i2112 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2110 & 896) | (i2110 & 14) | 12582912 | (i2110 & 112) | (i2110 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical2 = top;
                        contextualFlowColumnOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        horizontal3 = horizontal19;
                    } else {
                        if (i23 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i7 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        }
                        if (i9 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if (i11 != 0) {
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i12;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            clip = ContextualFlowColumnOverflow.Companion.getClip();
                        } else {
                            clip = contextualFlowColumnOverflow;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                        }
                        i20 = 3670016 & i6;
                        if (i20 == 1048576) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = clip.createOverflowState$foundation_layout_release();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                        if (i20 == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            obj = objRememberedValue2;
                            ArrayList arrayList1112 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1112);
                            composerStartRestartGroup.updateRememberedValue(arrayList1112);
                            obj = arrayList1112;
                        } else {
                            obj = objRememberedValue2;
                            ArrayList arrayList1113 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1113);
                            composerStartRestartGroup.updateRememberedValue(arrayList1113);
                            obj = arrayList1113;
                        }
                        obj = objRememberedValue2;
                        int i2111 = i6 >> 6;
                        Arrangement.Horizontal horizontal110 = start;
                        SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i2112, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2113) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(302435318, i2113, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                                }
                                function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2112), composer2, Integer.valueOf((i2113 << 3) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2111 & 896) | (i2111 & 14) | 12582912 | (i2111 & 112) | (i2111 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        vertical2 = top;
                        contextualFlowColumnOverflow2 = clip;
                        i21 = i24;
                        modifier3 = modifier2;
                        i22 = i19;
                        horizontal3 = horizontal110;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i2112) {
                                ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                            }
                        });
                    }
                }
                i6 |= 24576;
                i12 = i2;
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList1114 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1114);
                        composerStartRestartGroup.updateRememberedValue(arrayList1114);
                        obj = arrayList1114;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList1115 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1115);
                        composerStartRestartGroup.updateRememberedValue(arrayList1115);
                        obj = arrayList1115;
                    }
                    obj = objRememberedValue2;
                    int i2112 = i6 >> 6;
                    Arrangement.Horizontal horizontal111 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2113, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2114) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i2114, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2113), composer2, Integer.valueOf((i2114 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2112 & 896) | (i2112 & 14) | 12582912 | (i2112 & 112) | (i2112 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal111;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList1116 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1116);
                        composerStartRestartGroup.updateRememberedValue(arrayList1116);
                        obj = arrayList1116;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList1117 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1117);
                        composerStartRestartGroup.updateRememberedValue(arrayList1117);
                        obj = arrayList1117;
                    }
                    obj = objRememberedValue2;
                    int i2113 = i6 >> 6;
                    Arrangement.Horizontal horizontal112 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2114, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2115) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i2115, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2114), composer2, Integer.valueOf((i2115 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2113 & 896) | (i2113 & 14) | 12582912 | (i2113 & 112) | (i2113 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal112;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i2114) {
                            ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= 3072;
            horizontal2 = horizontal;
            i11 = i5 & 16;
            if (i11 != 0) {
                if ((i4 & 24576) == 0) {
                    i12 = i2;
                    if (composerStartRestartGroup.changed(i12)) {
                        i13 = 16384;
                    } else {
                        i13 = 8192;
                    }
                    i6 |= i13;
                }
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList1118 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1118);
                        composerStartRestartGroup.updateRememberedValue(arrayList1118);
                        obj = arrayList1118;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList1119 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1119);
                        composerStartRestartGroup.updateRememberedValue(arrayList1119);
                        obj = arrayList1119;
                    }
                    obj = objRememberedValue2;
                    int i2114 = i6 >> 6;
                    Arrangement.Horizontal horizontal113 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2115, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2116) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i2116, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2115), composer2, Integer.valueOf((i2116 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2114 & 896) | (i2114 & 14) | 12582912 | (i2114 & 112) | (i2114 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal113;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList11110 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11110);
                        composerStartRestartGroup.updateRememberedValue(arrayList11110);
                        obj = arrayList11110;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList11111 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11111);
                        composerStartRestartGroup.updateRememberedValue(arrayList11111);
                        obj = arrayList11111;
                    }
                    obj = objRememberedValue2;
                    int i2115 = i6 >> 6;
                    Arrangement.Horizontal horizontal114 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2116, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2117) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i2117, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2116), composer2, Integer.valueOf((i2117 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2115 & 896) | (i2115 & 14) | 12582912 | (i2115 & 112) | (i2115 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal114;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i2116) {
                            ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= 24576;
            i12 = i2;
            i14 = i5 & 32;
            if (i14 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i3)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i6 |= i15;
            }
            i16 = i5 & 64;
            if (i16 != 0) {
                i6 |= 1572864;
            } else if ((i4 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i6 |= i17;
            }
            if ((i5 & 128) != 0) {
                i6 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i6 |= i18;
            }
            if ((4793491 & i6) != 4793490) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                }
                if (i9 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowColumnOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList11112 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11112);
                    composerStartRestartGroup.updateRememberedValue(arrayList11112);
                    obj = arrayList11112;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList11113 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11113);
                    composerStartRestartGroup.updateRememberedValue(arrayList11113);
                    obj = arrayList11113;
                }
                obj = objRememberedValue2;
                int i2116 = i6 >> 6;
                Arrangement.Horizontal horizontal115 = start;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2117, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2118) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(302435318, i2118, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                        }
                        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2117), composer2, Integer.valueOf((i2118 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2116 & 896) | (i2116 & 14) | 12582912 | (i2116 & 112) | (i2116 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical2 = top;
                contextualFlowColumnOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                horizontal3 = horizontal115;
            } else {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                }
                if (i9 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowColumnOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList11114 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11114);
                    composerStartRestartGroup.updateRememberedValue(arrayList11114);
                    obj = arrayList11114;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList11115 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11115);
                    composerStartRestartGroup.updateRememberedValue(arrayList11115);
                    obj = arrayList11115;
                }
                obj = objRememberedValue2;
                int i2117 = i6 >> 6;
                Arrangement.Horizontal horizontal116 = start;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2118, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i2119) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(302435318, i2119, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                        }
                        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2118), composer2, Integer.valueOf((i2119 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2117 & 896) | (i2117 & 14) | 12582912 | (i2117 & 112) | (i2117 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical2 = top;
                contextualFlowColumnOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                horizontal3 = horizontal116;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i2118) {
                        ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
            }
        }
        i6 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        top = vertical;
        i9 = i5 & 8;
        if (i9 != 0) {
            if ((i4 & 3072) == 0) {
                horizontal2 = horizontal;
                if (composerStartRestartGroup.changed(horizontal2)) {
                    i10 = 2048;
                } else {
                    i10 = 1024;
                }
                i6 |= i10;
            }
            i11 = i5 & 16;
            if (i11 != 0) {
                if ((i4 & 24576) == 0) {
                    i12 = i2;
                    if (composerStartRestartGroup.changed(i12)) {
                        i13 = 16384;
                    } else {
                        i13 = 8192;
                    }
                    i6 |= i13;
                }
                i14 = i5 & 32;
                if (i14 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i3)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i6 |= i15;
                }
                i16 = i5 & 64;
                if (i16 != 0) {
                    i6 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                        i17 = 1048576;
                    } else {
                        i17 = 524288;
                    }
                    i6 |= i17;
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i6 |= i18;
                }
                if ((4793491 & i6) != 4793490) {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList11116 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11116);
                        composerStartRestartGroup.updateRememberedValue(arrayList11116);
                        obj = arrayList11116;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList11117 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11117);
                        composerStartRestartGroup.updateRememberedValue(arrayList11117);
                        obj = arrayList11117;
                    }
                    obj = objRememberedValue2;
                    int i2118 = i6 >> 6;
                    Arrangement.Horizontal horizontal117 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2119, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21110) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i21110, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i2119), composer2, Integer.valueOf((i21110 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2118 & 896) | (i2118 & 14) | 12582912 | (i2118 & 112) | (i2118 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal117;
                } else {
                    if (i23 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i7 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    }
                    if (i9 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if (i11 != 0) {
                        i19 = Integer.MAX_VALUE;
                    } else {
                        i19 = i12;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        clip = ContextualFlowColumnOverflow.Companion.getClip();
                    } else {
                        clip = contextualFlowColumnOverflow;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                    }
                    i20 = 3670016 & i6;
                    if (i20 == 1048576) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = clip.createOverflowState$foundation_layout_release();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                    if (i20 == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        obj = objRememberedValue2;
                        ArrayList arrayList11118 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11118);
                        composerStartRestartGroup.updateRememberedValue(arrayList11118);
                        obj = arrayList11118;
                    } else {
                        obj = objRememberedValue2;
                        ArrayList arrayList11119 = new ArrayList();
                        clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList11119);
                        composerStartRestartGroup.updateRememberedValue(arrayList11119);
                        obj = arrayList11119;
                    }
                    obj = objRememberedValue2;
                    int i2119 = i6 >> 6;
                    Arrangement.Horizontal horizontal118 = start;
                    SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                            invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i21110, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21111) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(302435318, i21111, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                            }
                            function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21110), composer2, Integer.valueOf((i21111 << 3) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2119 & 896) | (i2119 & 14) | 12582912 | (i2119 & 112) | (i2119 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    vertical2 = top;
                    contextualFlowColumnOverflow2 = clip;
                    i21 = i24;
                    modifier3 = modifier2;
                    i22 = i19;
                    horizontal3 = horizontal118;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer2, int i21110) {
                            ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                        }
                    });
                }
            }
            i6 |= 24576;
            i12 = i2;
            i14 = i5 & 32;
            if (i14 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i3)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i6 |= i15;
            }
            i16 = i5 & 64;
            if (i16 != 0) {
                i6 |= 1572864;
            } else if ((i4 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i6 |= i17;
            }
            if ((i5 & 128) != 0) {
                i6 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i6 |= i18;
            }
            if ((4793491 & i6) != 4793490) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                }
                if (i9 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowColumnOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList111110 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111110);
                    composerStartRestartGroup.updateRememberedValue(arrayList111110);
                    obj = arrayList111110;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList111111 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111111);
                    composerStartRestartGroup.updateRememberedValue(arrayList111111);
                    obj = arrayList111111;
                }
                obj = objRememberedValue2;
                int i21110 = i6 >> 6;
                Arrangement.Horizontal horizontal119 = start;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i21111, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21112) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(302435318, i21112, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                        }
                        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21111), composer2, Integer.valueOf((i21112 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21110 & 896) | (i21110 & 14) | 12582912 | (i21110 & 112) | (i21110 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical2 = top;
                contextualFlowColumnOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                horizontal3 = horizontal119;
            } else {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                }
                if (i9 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowColumnOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList111112 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111112);
                    composerStartRestartGroup.updateRememberedValue(arrayList111112);
                    obj = arrayList111112;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList111113 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111113);
                    composerStartRestartGroup.updateRememberedValue(arrayList111113);
                    obj = arrayList111113;
                }
                obj = objRememberedValue2;
                int i21111 = i6 >> 6;
                Arrangement.Horizontal horizontal1110 = start;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i21112, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21113) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(302435318, i21113, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                        }
                        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21112), composer2, Integer.valueOf((i21113 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21111 & 896) | (i21111 & 14) | 12582912 | (i21111 & 112) | (i21111 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical2 = top;
                contextualFlowColumnOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                horizontal3 = horizontal1110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i21112) {
                        ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
            }
        }
        i6 |= 3072;
        horizontal2 = horizontal;
        i11 = i5 & 16;
        if (i11 != 0) {
            if ((i4 & 24576) == 0) {
                i12 = i2;
                if (composerStartRestartGroup.changed(i12)) {
                    i13 = 16384;
                } else {
                    i13 = 8192;
                }
                i6 |= i13;
            }
            i14 = i5 & 32;
            if (i14 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i3)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i6 |= i15;
            }
            i16 = i5 & 64;
            if (i16 != 0) {
                i6 |= 1572864;
            } else if ((i4 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                    i17 = 1048576;
                } else {
                    i17 = 524288;
                }
                i6 |= i17;
            }
            if ((i5 & 128) != 0) {
                i6 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i6 |= i18;
            }
            if ((4793491 & i6) != 4793490) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                }
                if (i9 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowColumnOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList111114 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111114);
                    composerStartRestartGroup.updateRememberedValue(arrayList111114);
                    obj = arrayList111114;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList111115 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111115);
                    composerStartRestartGroup.updateRememberedValue(arrayList111115);
                    obj = arrayList111115;
                }
                obj = objRememberedValue2;
                int i21112 = i6 >> 6;
                Arrangement.Horizontal horizontal1111 = start;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i21113, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21114) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(302435318, i21114, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                        }
                        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21113), composer2, Integer.valueOf((i21114 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21112 & 896) | (i21112 & 14) | 12582912 | (i21112 & 112) | (i21112 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical2 = top;
                contextualFlowColumnOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                horizontal3 = horizontal1111;
            } else {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i7 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                }
                if (i9 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if (i11 != 0) {
                    i19 = Integer.MAX_VALUE;
                } else {
                    i19 = i12;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    clip = ContextualFlowColumnOverflow.Companion.getClip();
                } else {
                    clip = contextualFlowColumnOverflow;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
                }
                i20 = 3670016 & i6;
                if (i20 == 1048576) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = clip.createOverflowState$foundation_layout_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                if (i20 == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    obj = objRememberedValue2;
                    ArrayList arrayList111116 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111116);
                    composerStartRestartGroup.updateRememberedValue(arrayList111116);
                    obj = arrayList111116;
                } else {
                    obj = objRememberedValue2;
                    ArrayList arrayList111117 = new ArrayList();
                    clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111117);
                    composerStartRestartGroup.updateRememberedValue(arrayList111117);
                    obj = arrayList111117;
                }
                obj = objRememberedValue2;
                int i21113 = i6 >> 6;
                Arrangement.Horizontal horizontal1112 = start;
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                        invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i21114, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21115) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(302435318, i21115, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                        }
                        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21114), composer2, Integer.valueOf((i21115 << 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21113 & 896) | (i21113 & 14) | 12582912 | (i21113 & 112) | (i21113 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                vertical2 = top;
                contextualFlowColumnOverflow2 = clip;
                i21 = i24;
                modifier3 = modifier2;
                i22 = i19;
                horizontal3 = horizontal1112;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i21114) {
                        ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
            }
        }
        i6 |= 24576;
        i12 = i2;
        i14 = i5 & 32;
        if (i14 != 0) {
            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(i3)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i6 |= i15;
        }
        i16 = i5 & 64;
        if (i16 != 0) {
            i6 |= 1572864;
        } else if ((i4 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(contextualFlowColumnOverflow)) {
                i17 = 1048576;
            } else {
                i17 = 524288;
            }
            i6 |= i17;
        }
        if ((i5 & 128) != 0) {
            i6 |= 12582912;
        } else if ((i4 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i18 = 8388608;
            } else {
                i18 = 4194304;
            }
            i6 |= i18;
        }
        if ((4793491 & i6) != 4793490) {
            if (i23 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (i7 != 0) {
                top = Arrangement.INSTANCE.getTop();
            }
            if (i9 != 0) {
                start = Arrangement.INSTANCE.getStart();
            } else {
                start = horizontal2;
            }
            if (i11 != 0) {
                i19 = Integer.MAX_VALUE;
            } else {
                i19 = i12;
            }
            if (i14 == 0) {
            }
            if (i16 != 0) {
                clip = ContextualFlowColumnOverflow.Companion.getClip();
            } else {
                clip = contextualFlowColumnOverflow;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
            }
            i20 = 3670016 & i6;
            if (i20 == 1048576) {
                z = true;
            } else {
                z = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
            if (i20 == 1048576) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                obj = objRememberedValue2;
                ArrayList arrayList111118 = new ArrayList();
                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111118);
                composerStartRestartGroup.updateRememberedValue(arrayList111118);
                obj = arrayList111118;
            } else {
                obj = objRememberedValue2;
                ArrayList arrayList111119 = new ArrayList();
                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList111119);
                composerStartRestartGroup.updateRememberedValue(arrayList111119);
                obj = arrayList111119;
            }
            obj = objRememberedValue2;
            int i21114 = i6 >> 6;
            Arrangement.Horizontal horizontal1113 = start;
            SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                    invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i21115, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21116) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(302435318, i21116, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                    }
                    function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21115), composer2, Integer.valueOf((i21116 << 3) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21114 & 896) | (i21114 & 14) | 12582912 | (i21114 & 112) | (i21114 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            vertical2 = top;
            contextualFlowColumnOverflow2 = clip;
            i21 = i24;
            modifier3 = modifier2;
            i22 = i19;
            horizontal3 = horizontal1113;
        } else {
            if (i23 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (i7 != 0) {
                top = Arrangement.INSTANCE.getTop();
            }
            if (i9 != 0) {
                start = Arrangement.INSTANCE.getStart();
            } else {
                start = horizontal2;
            }
            if (i11 != 0) {
                i19 = Integer.MAX_VALUE;
            } else {
                i19 = i12;
            }
            if (i14 == 0) {
            }
            if (i16 != 0) {
                clip = ContextualFlowColumnOverflow.Companion.getClip();
            } else {
                clip = contextualFlowColumnOverflow;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-588476895, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
            }
            i20 = 3670016 & i6;
            if (i20 == 1048576) {
                z = true;
            } else {
                z = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = clip.createOverflowState$foundation_layout_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
            if (i20 == 1048576) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                obj = objRememberedValue2;
                ArrayList arrayList1111110 = new ArrayList();
                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1111110);
                composerStartRestartGroup.updateRememberedValue(arrayList1111110);
                obj = arrayList1111110;
            } else {
                obj = objRememberedValue2;
                ArrayList arrayList1111111 = new ArrayList();
                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList1111111);
                composerStartRestartGroup.updateRememberedValue(arrayList1111111);
                obj = arrayList1111111;
            }
            obj = objRememberedValue2;
            int i21115 = i6 >> 6;
            Arrangement.Horizontal horizontal1114 = start;
            SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start, i19, i24, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                    invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i21116, @NotNull FlowLineInfo flowLineInfo, @Nullable Composer composer2, int i21117) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(302435318, i21117, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                    }
                    function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m453getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m454getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21116), composer2, Integer.valueOf((i21117 << 3) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21115 & 896) | (i21115 & 14) | 12582912 | (i21115 & 112) | (i21115 & 7168) | ((i6 << 15) & 458752)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            vertical2 = top;
            contextualFlowColumnOverflow2 = clip;
            i21 = i24;
            modifier3 = modifier2;
            i22 = i19;
            horizontal3 = horizontal1114;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i21116) {
                    ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical2, horizontal3, i22, i21, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:47:0x0091  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ae  */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualRowMeasurementHelper(@NotNull Arrangement.Horizontal horizontal, @NotNull Arrangement.Vertical vertical, int i, int i2, @NotNull FlowLayoutOverflowState flowLayoutOverflowState, int i3, @NotNull List<? extends Function2<? super Composer, ? super Integer, Unit>> list, @NotNull Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i4) {
        boolean z;
        boolean z2;
        boolean z3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-43351224, i4, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:342)");
        }
        if (((i4 & 14) ^ 6) > 4 && composer.changed(horizontal)) {
            z = true;
        } else if ((i4 & 6) == 4) {
            z = true;
        } else {
            z = false;
        }
        boolean z4 = (((i4 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i4 & 48) == 32;
        boolean z5 = (((i4 & 896) ^ BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) > 256 && composer.changed(i)) || (i4 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 256;
        boolean z6 = (((i4 & 7168) ^ 3072) > 2048 && composer.changed(i2)) || (i4 & 3072) == 2048;
        boolean zChanged = composer.changed(flowLayoutOverflowState);
        if (((458752 & i4) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(i3)) {
            z2 = true;
        } else if ((196608 & i4) == 131072) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (((29360128 & i4) ^ 12582912) > 8388608 && composer.changed(function4)) {
            z3 = true;
        } else if ((i4 & 12582912) == 8388608) {
            z3 = true;
        } else {
            z3 = false;
        }
        Object objRememberedValue = composer.rememberedValue();
        if ((z | z4 | z5 | z6 | zChanged | z2 | z3) || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new FlowMeasureLazyPolicy(true, horizontal, vertical, horizontal.mo407getSpacingD9Ej5fM(), FlowLayoutKt.getCROSS_AXIS_ALIGNMENT_TOP(), vertical.mo407getSpacingD9Ej5fM(), i3, i2, i, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function2 = (Function2) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return function2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:47:0x0091  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ae  */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualColumnMeasureHelper(@NotNull Arrangement.Vertical vertical, @NotNull Arrangement.Horizontal horizontal, int i, int i2, @NotNull FlowLayoutOverflowState flowLayoutOverflowState, int i3, @NotNull List<? extends Function2<? super Composer, ? super Integer, Unit>> list, @NotNull Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i4) {
        boolean z;
        boolean z2;
        boolean z3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009762916, i4, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:382)");
        }
        if (((i4 & 14) ^ 6) > 4 && composer.changed(vertical)) {
            z = true;
        } else if ((i4 & 6) == 4) {
            z = true;
        } else {
            z = false;
        }
        boolean z4 = (((i4 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i4 & 48) == 32;
        boolean z5 = (((i4 & 896) ^ BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) > 256 && composer.changed(i)) || (i4 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 256;
        boolean z6 = (((i4 & 7168) ^ 3072) > 2048 && composer.changed(i2)) || (i4 & 3072) == 2048;
        boolean zChanged = composer.changed(flowLayoutOverflowState);
        if (((458752 & i4) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(i3)) {
            z2 = true;
        } else if ((196608 & i4) == 131072) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (((29360128 & i4) ^ 12582912) > 8388608 && composer.changed(function4)) {
            z3 = true;
        } else if ((i4 & 12582912) == 8388608) {
            z3 = true;
        } else {
            z3 = false;
        }
        Object objRememberedValue = composer.rememberedValue();
        if ((z | z4 | z5 | z6 | zChanged | z2 | z3) || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new FlowMeasureLazyPolicy(false, horizontal, vertical, vertical.mo407getSpacingD9Ej5fM(), FlowLayoutKt.getCROSS_AXIS_ALIGNMENT_START(), horizontal.mo407getSpacingD9Ej5fM(), i3, i2, i, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function2 = (Function2) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return function2;
    }
}
