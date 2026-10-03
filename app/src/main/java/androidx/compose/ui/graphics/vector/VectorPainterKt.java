package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    /* JADX INFO: renamed from: rememberVectorPainter-mlNsNFs, reason: not valid java name */
    public static final VectorPainter m1890rememberVectorPaintermlNsNFs(float f, float f2, float f3, float f4, @Nullable String str, long j, int i, @NotNull Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i2, int i3) {
        float f5 = (i3 & 4) != 0 ? Float.NaN : f3;
        float f6 = (i3 & 8) != 0 ? Float.NaN : f4;
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long jM1205getUnspecified0d7_KjU = (i3 & 32) != 0 ? Color.Companion.m1205getUnspecified0d7_KjU() : j;
        int iM1109getSrcIn0nO6VwU = (i3 & 64) != 0 ? BlendMode.Companion.m1109getSrcIn0nO6VwU() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:86)");
        }
        VectorPainter vectorPainterM1891rememberVectorPaintervIP8VLU = m1891rememberVectorPaintervIP8VLU(f, f2, f5, f6, str2, jM1205getUnspecified0d7_KjU, iM1109getSrcIn0nO6VwU, false, function4, composer, (i2 & 14) | 12582912 | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | ((i2 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return vectorPainterM1891rememberVectorPaintervIP8VLU;
    }

    /* JADX WARN: Code duplicated, block: B:78:0x0128 A[PHI: r6
  0x0128: PHI (r6v14 kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
  (r6v12 kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
  (r6v15 kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
 binds: [B:77:0x0126, B:73:0x0120] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:83:0x0137  */
    /* JADX WARN: Code duplicated, block: B:85:0x013d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0143  */
    /* JADX WARN: Code duplicated, block: B:91:0x0175  */
    /* JADX INFO: renamed from: rememberVectorPainter-vIP8VLU, reason: not valid java name */
    public static final VectorPainter m1891rememberVectorPaintervIP8VLU(float f, float f2, float f3, float f4, @Nullable String str, long j, int i, boolean z, @NotNull Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i2, int i3) {
        boolean z2;
        final Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function5;
        boolean z3;
        Object objRememberedValue;
        Composition composition$ui_release;
        Object obj;
        float f5 = (i3 & 4) != 0 ? Float.NaN : f3;
        float f6 = (i3 & 8) == 0 ? f4 : Float.NaN;
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long jM1205getUnspecified0d7_KjU = (i3 & 32) != 0 ? Color.Companion.m1205getUnspecified0d7_KjU() : j;
        int iM1109getSrcIn0nO6VwU = (i3 & 64) != 0 ? BlendMode.Companion.m1109getSrcIn0nO6VwU() : i;
        boolean z4 = (i3 & 128) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1068590786, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:130)");
        }
        long jM1888obtainSizePxVpY3zN4 = m1888obtainSizePxVpY3zN4((Density) composer.consume(CompositionLocalsKt.getLocalDensity()), f, f2);
        final long jM1889obtainViewportSizePq9zytI = m1889obtainViewportSizePq9zytI(jM1888obtainSizePxVpY3zN4, f5, f6);
        boolean z5 = (((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(jM1205getUnspecified0d7_KjU)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072;
        boolean z6 = (((3670016 & i2) ^ 1572864) > 1048576 && composer.changed(iM1109getSrcIn0nO6VwU)) || (i2 & 1572864) == 1048576;
        Object objRememberedValue2 = composer.rememberedValue();
        if ((z6 | z5) || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = m1887createColorFilterxETnrds(jM1205getUnspecified0d7_KjU, iM1109getSrcIn0nO6VwU);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ColorFilter colorFilter = (ColorFilter) objRememberedValue2;
        composer.startReplaceGroup(-1837510348);
        Object objRememberedValue3 = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue3 == companion.getEmpty()) {
            z2 = true;
            objRememberedValue3 = new VectorPainter(null, 1, null);
            composer.updateRememberedValue(objRememberedValue3);
        } else {
            z2 = true;
        }
        VectorPainter vectorPainter = (VectorPainter) objRememberedValue3;
        m1885configureVectorPainterT4PVSW8(vectorPainter, jM1888obtainSizePxVpY3zN4, jM1889obtainViewportSizePq9zytI, str2, colorFilter, z4);
        CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        boolean z7 = ((((i2 & 896) ^ BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) <= 256 || !composer.changed(f5)) && (i2 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) != 256) ? false : z2;
        boolean z8 = ((((i2 & 7168) ^ 3072) <= 2048 || !composer.changed(f6)) && (i2 & 3072) != 2048) ? false : z2;
        if (((234881024 & i2) ^ 100663296) > 67108864) {
            function5 = function4;
            if (!composer.changed(function5)) {
            }
            objRememberedValue = composer.rememberedValue();
            if (!(z3 | z7 | z8) || objRememberedValue == companion.getEmpty()) {
                obj = objRememberedValue;
                composition$ui_release = vectorPainter.getComposition$ui_release();
                if (composition$ui_release != null || composition$ui_release.isDisposed()) {
                    composition$ui_release = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector$ui_release().getRoot()), compositionContextRememberCompositionContext);
                }
                Composition composition = composition$ui_release;
                composition.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, z2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
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

                    public final void invoke(@Nullable Composer composer2, int i4) {
                        if ((i4 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-824421385, i4, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:157)");
                        }
                        function5.invoke(Float.valueOf(Size.m997getWidthimpl(jM1889obtainViewportSizePq9zytI)), Float.valueOf(Size.m994getHeightimpl(jM1889obtainViewportSizePq9zytI)), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                composer.updateRememberedValue(composition);
                obj = composition;
            }
            obj = objRememberedValue;
            vectorPainter.setComposition$ui_release((Composition) obj);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return vectorPainter;
        }
        function5 = function4;
        z3 = (i2 & 100663296) == 67108864 ? z2 : false;
        objRememberedValue = composer.rememberedValue();
        if (!(z3 | z7 | z8)) {
            obj = objRememberedValue;
            composition$ui_release = vectorPainter.getComposition$ui_release();
            if (composition$ui_release != null) {
                composition$ui_release = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector$ui_release().getRoot()), compositionContextRememberCompositionContext);
            } else {
                composition$ui_release = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector$ui_release().getRoot()), compositionContextRememberCompositionContext);
            }
            Composition composition2 = composition$ui_release;
            composition2.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, z2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-824421385, i4, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:157)");
                    }
                    function5.invoke(Float.valueOf(Size.m997getWidthimpl(jM1889obtainViewportSizePq9zytI)), Float.valueOf(Size.m994getHeightimpl(jM1889obtainViewportSizePq9zytI)), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            composer.updateRememberedValue(composition2);
            obj = composition2;
        } else {
            obj = objRememberedValue;
            composition$ui_release = vectorPainter.getComposition$ui_release();
            if (composition$ui_release != null) {
                composition$ui_release = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector$ui_release().getRoot()), compositionContextRememberCompositionContext);
            } else {
                composition$ui_release = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector$ui_release().getRoot()), compositionContextRememberCompositionContext);
            }
            Composition composition3 = composition$ui_release;
            composition3.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, z2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-824421385, i4, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:157)");
                    }
                    function5.invoke(Float.valueOf(Size.m997getWidthimpl(jM1889obtainViewportSizePq9zytI)), Float.valueOf(Size.m994getHeightimpl(jM1889obtainViewportSizePq9zytI)), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            composer.updateRememberedValue(composition3);
            obj = composition3;
        }
        obj = objRememberedValue;
        vectorPainter.setComposition$ui_release((Composition) obj);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return vectorPainter;
    }

    public static final VectorPainter rememberVectorPainter(@NotNull ImageVector imageVector, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:171)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        boolean zChanged = composer.changed((((long) Float.floatToRawIntBits(density.getDensity())) & 4294967295L) | (((long) Float.floatToRawIntBits(imageVector.getGenId$ui_release())) << 32));
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            GroupComponent groupComponent = new GroupComponent();
            createGroupComponent(groupComponent, imageVector.getRoot());
            Unit unit = Unit.INSTANCE;
            objRememberedValue = createVectorPainterFromImageVector(density, imageVector, groupComponent);
            composer.updateRememberedValue(objRememberedValue);
        }
        VectorPainter vectorPainter = (VectorPainter) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return vectorPainter;
    }

    /* JADX INFO: renamed from: obtainSizePx-VpY3zN4, reason: not valid java name */
    private static final long m1888obtainSizePxVpY3zN4(Density density, float f, float f2) {
        return SizeKt.Size(density.mo2483toPx0680j_4(f), density.mo2483toPx0680j_4(f2));
    }

    /* JADX INFO: renamed from: obtainViewportSize-Pq9zytI, reason: not valid java name */
    private static final long m1889obtainViewportSizePq9zytI(long j, float f, float f2) {
        if (Float.isNaN(f)) {
            f = Size.m997getWidthimpl(j);
        }
        if (Float.isNaN(f2)) {
            f2 = Size.m994getHeightimpl(j);
        }
        return SizeKt.Size(f, f2);
    }

    /* JADX INFO: renamed from: createColorFilter-xETnrds, reason: not valid java name */
    private static final ColorFilter m1887createColorFilterxETnrds(long j, int i) {
        if (j != 16) {
            return ColorFilter.Companion.m1213tintxETnrds(j, i);
        }
        return null;
    }

    /* JADX INFO: renamed from: configureVectorPainter-T4PVSW8, reason: not valid java name */
    public static final VectorPainter m1885configureVectorPainterT4PVSW8(@NotNull VectorPainter vectorPainter, long j, long j2, @NotNull String str, @Nullable ColorFilter colorFilter, boolean z) {
        vectorPainter.m1883setSizeuvyYCjk$ui_release(j);
        vectorPainter.setAutoMirror$ui_release(z);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter);
        vectorPainter.m1884setViewportSizeuvyYCjk$ui_release(j2);
        vectorPainter.setName$ui_release(str);
        return vectorPainter;
    }

    public static final VectorPainter createVectorPainterFromImageVector(@NotNull Density density, @NotNull ImageVector imageVector, @NotNull GroupComponent groupComponent) {
        long jM1888obtainSizePxVpY3zN4 = m1888obtainSizePxVpY3zN4(density, imageVector.m1859getDefaultWidthD9Ej5fM(), imageVector.m1858getDefaultHeightD9Ej5fM());
        return m1885configureVectorPainterT4PVSW8(new VectorPainter(groupComponent), jM1888obtainSizePxVpY3zN4, m1889obtainViewportSizePq9zytI(jM1888obtainSizePxVpY3zN4, imageVector.getViewportWidth(), imageVector.getViewportHeight()), imageVector.getName(), m1887createColorFilterxETnrds(imageVector.m1861getTintColor0d7_KjU(), imageVector.m1860getTintBlendMode0nO6VwU()), imageVector.getAutoMirror());
    }

    public static final GroupComponent createGroupComponent(@NotNull GroupComponent groupComponent, @NotNull VectorGroup vectorGroup) {
        int size = vectorGroup.getSize();
        for (int i = 0; i < size; i++) {
            VectorNode vectorNode = vectorGroup.get(i);
            if (vectorNode instanceof VectorPath) {
                PathComponent pathComponent = new PathComponent();
                VectorPath vectorPath = (VectorPath) vectorNode;
                pathComponent.setPathData(vectorPath.getPathData());
                pathComponent.m1869setPathFillTypeoQ8Xj4U(vectorPath.m1892getPathFillTypeRgk1Os());
                pathComponent.setName(vectorPath.getName());
                pathComponent.setFill(vectorPath.getFill());
                pathComponent.setFillAlpha(vectorPath.getFillAlpha());
                pathComponent.setStroke(vectorPath.getStroke());
                pathComponent.setStrokeAlpha(vectorPath.getStrokeAlpha());
                pathComponent.setStrokeLineWidth(vectorPath.getStrokeLineWidth());
                pathComponent.m1870setStrokeLineCapBeK7IIE(vectorPath.m1893getStrokeLineCapKaPHkGw());
                pathComponent.m1871setStrokeLineJoinWw9F2mQ(vectorPath.m1894getStrokeLineJoinLxFBmk8());
                pathComponent.setStrokeLineMiter(vectorPath.getStrokeLineMiter());
                pathComponent.setTrimPathStart(vectorPath.getTrimPathStart());
                pathComponent.setTrimPathEnd(vectorPath.getTrimPathEnd());
                pathComponent.setTrimPathOffset(vectorPath.getTrimPathOffset());
                groupComponent.insertAt(i, pathComponent);
            } else if (vectorNode instanceof VectorGroup) {
                GroupComponent groupComponent2 = new GroupComponent();
                VectorGroup vectorGroup2 = (VectorGroup) vectorNode;
                groupComponent2.setName(vectorGroup2.getName());
                groupComponent2.setRotation(vectorGroup2.getRotation());
                groupComponent2.setScaleX(vectorGroup2.getScaleX());
                groupComponent2.setScaleY(vectorGroup2.getScaleY());
                groupComponent2.setTranslationX(vectorGroup2.getTranslationX());
                groupComponent2.setTranslationY(vectorGroup2.getTranslationY());
                groupComponent2.setPivotX(vectorGroup2.getPivotX());
                groupComponent2.setPivotY(vectorGroup2.getPivotY());
                groupComponent2.setClipPathData(vectorGroup2.getClipPathData());
                createGroupComponent(groupComponent2, vectorGroup2);
                groupComponent.insertAt(i, groupComponent2);
            }
        }
        return groupComponent;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x007f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0095  */
    /* JADX WARN: Code duplicated, block: B:45:0x016b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0174  */
    /* JADX WARN: Code duplicated, block: B:49:0x018b  */
    /* JADX WARN: Code duplicated, block: B:51:0x024c  */
    /* JADX WARN: Code duplicated, block: B:55:0x026b  */
    /* JADX WARN: Code duplicated, block: B:58:0x0274  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    public static final void RenderVectorGroup(@NotNull final VectorGroup vectorGroup, @Nullable Map<String, ? extends VectorConfig> map, @Nullable Composer composer, final int i, final int i2) {
        int i3;
        Map<String, ? extends VectorConfig> map2;
        Map<String, ? extends VectorConfig> mapEmptyMap;
        Iterator<VectorNode> it2;
        final Map<String, ? extends VectorConfig> map3;
        Composer composer2;
        final VectorNode next;
        Iterator<VectorNode> it3;
        Map<String, ? extends VectorConfig> map4;
        Composer composer3;
        final Map<String, ? extends VectorConfig> map5;
        VectorConfig vectorConfig;
        VectorConfig vectorConfig2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-446179233);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(vectorGroup) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                map2 = map;
                i3 |= composerStartRestartGroup.changedInstance(map2) ? 32 : 16;
            }
            if ((i3 & 19) == 18 || !composerStartRestartGroup.getSkipping()) {
                if (i4 != 0) {
                    mapEmptyMap = MapsKt__MapsKt.emptyMap();
                } else {
                    mapEmptyMap = map2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-446179233, i3, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:430)");
                }
                it2 = vectorGroup.iterator();
                while (it2.hasNext()) {
                    next = it2.next();
                    if (next instanceof VectorPath) {
                        composerStartRestartGroup.startReplaceGroup(-23647808);
                        VectorPath vectorPath = (VectorPath) next;
                        vectorConfig2 = mapEmptyMap.get(vectorPath.getName());
                        if (vectorConfig2 == null) {
                            vectorConfig2 = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
                            };
                        }
                        VectorConfig vectorConfig3 = vectorConfig2;
                        it3 = it2;
                        composer3 = composerStartRestartGroup;
                        VectorComposeKt.m1875Path9cdaXJ4((List) vectorConfig3.getOrDefault(VectorProperty.PathData.INSTANCE, vectorPath.getPathData()), vectorPath.m1892getPathFillTypeRgk1Os(), vectorPath.getName(), (Brush) vectorConfig3.getOrDefault(VectorProperty.Fill.INSTANCE, vectorPath.getFill()), ((Number) vectorConfig3.getOrDefault(VectorProperty.FillAlpha.INSTANCE, Float.valueOf(vectorPath.getFillAlpha()))).floatValue(), (Brush) vectorConfig3.getOrDefault(VectorProperty.Stroke.INSTANCE, vectorPath.getStroke()), ((Number) vectorConfig3.getOrDefault(VectorProperty.StrokeAlpha.INSTANCE, Float.valueOf(vectorPath.getStrokeAlpha()))).floatValue(), ((Number) vectorConfig3.getOrDefault(VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf(vectorPath.getStrokeLineWidth()))).floatValue(), vectorPath.m1893getStrokeLineCapKaPHkGw(), vectorPath.m1894getStrokeLineJoinLxFBmk8(), vectorPath.getStrokeLineMiter(), ((Number) vectorConfig3.getOrDefault(VectorProperty.TrimPathStart.INSTANCE, Float.valueOf(vectorPath.getTrimPathStart()))).floatValue(), ((Number) vectorConfig3.getOrDefault(VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf(vectorPath.getTrimPathEnd()))).floatValue(), ((Number) vectorConfig3.getOrDefault(VectorProperty.TrimPathOffset.INSTANCE, Float.valueOf(vectorPath.getTrimPathOffset()))).floatValue(), composer3, 0, 0, 0);
                        composer3.endReplaceGroup();
                        map5 = mapEmptyMap;
                    } else {
                        it3 = it2;
                        map4 = mapEmptyMap;
                        composer3 = composerStartRestartGroup;
                        if (next instanceof VectorGroup) {
                            composer3.startReplaceGroup(-21815553);
                            VectorGroup vectorGroup2 = (VectorGroup) next;
                            map5 = map4;
                            vectorConfig = map5.get(vectorGroup2.getName());
                            if (vectorConfig == null) {
                                vectorConfig = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
                                };
                            }
                            VectorComposeKt.Group(vectorGroup2.getName(), ((Number) vectorConfig.getOrDefault(VectorProperty.Rotation.INSTANCE, Float.valueOf(vectorGroup2.getRotation()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.PivotX.INSTANCE, Float.valueOf(vectorGroup2.getPivotX()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.PivotY.INSTANCE, Float.valueOf(vectorGroup2.getPivotY()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.ScaleX.INSTANCE, Float.valueOf(vectorGroup2.getScaleX()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.ScaleY.INSTANCE, Float.valueOf(vectorGroup2.getScaleY()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.TranslateX.INSTANCE, Float.valueOf(vectorGroup2.getTranslationX()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.TranslateY.INSTANCE, Float.valueOf(vectorGroup2.getTranslationY()))).floatValue(), (List) vectorConfig.getOrDefault(VectorProperty.PathData.INSTANCE, vectorGroup2.getClipPathData()), ComposableLambdaKt.rememberComposableLambda(1450046638, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer4, int i5) {
                                    if ((i5 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1450046638, i5, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup.<anonymous> (VectorPainter.kt:514)");
                                    }
                                    VectorPainterKt.RenderVectorGroup((VectorGroup) next, map5, composer4, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 805306368, 0);
                            composer3.endReplaceGroup();
                        } else {
                            map5 = map4;
                            composer3.startReplaceGroup(-20402883);
                            composer3.endReplaceGroup();
                        }
                    }
                    composerStartRestartGroup = composer3;
                    mapEmptyMap = map5;
                    it2 = it3;
                }
                map3 = mapEmptyMap;
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                map3 = map2;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer4, int i5) {
                        VectorPainterKt.RenderVectorGroup(vectorGroup, map3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        map2 = map;
        if ((i3 & 19) == 18) {
            if (i4 != 0) {
                mapEmptyMap = MapsKt__MapsKt.emptyMap();
            } else {
                mapEmptyMap = map2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446179233, i3, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:430)");
            }
            it2 = vectorGroup.iterator();
            while (it2.hasNext()) {
                next = it2.next();
                if (next instanceof VectorPath) {
                    composerStartRestartGroup.startReplaceGroup(-23647808);
                    VectorPath vectorPath2 = (VectorPath) next;
                    vectorConfig2 = mapEmptyMap.get(vectorPath2.getName());
                    if (vectorConfig2 == null) {
                        vectorConfig2 = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
                        };
                    }
                    VectorConfig vectorConfig4 = vectorConfig2;
                    it3 = it2;
                    composer3 = composerStartRestartGroup;
                    VectorComposeKt.m1875Path9cdaXJ4((List) vectorConfig4.getOrDefault(VectorProperty.PathData.INSTANCE, vectorPath2.getPathData()), vectorPath2.m1892getPathFillTypeRgk1Os(), vectorPath2.getName(), (Brush) vectorConfig4.getOrDefault(VectorProperty.Fill.INSTANCE, vectorPath2.getFill()), ((Number) vectorConfig4.getOrDefault(VectorProperty.FillAlpha.INSTANCE, Float.valueOf(vectorPath2.getFillAlpha()))).floatValue(), (Brush) vectorConfig4.getOrDefault(VectorProperty.Stroke.INSTANCE, vectorPath2.getStroke()), ((Number) vectorConfig4.getOrDefault(VectorProperty.StrokeAlpha.INSTANCE, Float.valueOf(vectorPath2.getStrokeAlpha()))).floatValue(), ((Number) vectorConfig4.getOrDefault(VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf(vectorPath2.getStrokeLineWidth()))).floatValue(), vectorPath2.m1893getStrokeLineCapKaPHkGw(), vectorPath2.m1894getStrokeLineJoinLxFBmk8(), vectorPath2.getStrokeLineMiter(), ((Number) vectorConfig4.getOrDefault(VectorProperty.TrimPathStart.INSTANCE, Float.valueOf(vectorPath2.getTrimPathStart()))).floatValue(), ((Number) vectorConfig4.getOrDefault(VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf(vectorPath2.getTrimPathEnd()))).floatValue(), ((Number) vectorConfig4.getOrDefault(VectorProperty.TrimPathOffset.INSTANCE, Float.valueOf(vectorPath2.getTrimPathOffset()))).floatValue(), composer3, 0, 0, 0);
                    composer3.endReplaceGroup();
                    map5 = mapEmptyMap;
                } else {
                    it3 = it2;
                    map4 = mapEmptyMap;
                    composer3 = composerStartRestartGroup;
                    if (next instanceof VectorGroup) {
                        composer3.startReplaceGroup(-21815553);
                        VectorGroup vectorGroup3 = (VectorGroup) next;
                        map5 = map4;
                        vectorConfig = map5.get(vectorGroup3.getName());
                        if (vectorConfig == null) {
                            vectorConfig = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
                            };
                        }
                        VectorComposeKt.Group(vectorGroup3.getName(), ((Number) vectorConfig.getOrDefault(VectorProperty.Rotation.INSTANCE, Float.valueOf(vectorGroup3.getRotation()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.PivotX.INSTANCE, Float.valueOf(vectorGroup3.getPivotX()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.PivotY.INSTANCE, Float.valueOf(vectorGroup3.getPivotY()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.ScaleX.INSTANCE, Float.valueOf(vectorGroup3.getScaleX()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.ScaleY.INSTANCE, Float.valueOf(vectorGroup3.getScaleY()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.TranslateX.INSTANCE, Float.valueOf(vectorGroup3.getTranslationX()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.TranslateY.INSTANCE, Float.valueOf(vectorGroup3.getTranslationY()))).floatValue(), (List) vectorConfig.getOrDefault(VectorProperty.PathData.INSTANCE, vectorGroup3.getClipPathData()), ComposableLambdaKt.rememberComposableLambda(1450046638, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer4, int i5) {
                                if ((i5 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1450046638, i5, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup.<anonymous> (VectorPainter.kt:514)");
                                }
                                VectorPainterKt.RenderVectorGroup((VectorGroup) next, map5, composer4, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 805306368, 0);
                        composer3.endReplaceGroup();
                    } else {
                        map5 = map4;
                        composer3.startReplaceGroup(-20402883);
                        composer3.endReplaceGroup();
                    }
                }
                composerStartRestartGroup = composer3;
                mapEmptyMap = map5;
                it2 = it3;
            }
            map3 = mapEmptyMap;
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i4 != 0) {
                mapEmptyMap = MapsKt__MapsKt.emptyMap();
            } else {
                mapEmptyMap = map2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446179233, i3, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:430)");
            }
            it2 = vectorGroup.iterator();
            while (it2.hasNext()) {
                next = it2.next();
                if (next instanceof VectorPath) {
                    composerStartRestartGroup.startReplaceGroup(-23647808);
                    VectorPath vectorPath3 = (VectorPath) next;
                    vectorConfig2 = mapEmptyMap.get(vectorPath3.getName());
                    if (vectorConfig2 == null) {
                        vectorConfig2 = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
                        };
                    }
                    VectorConfig vectorConfig5 = vectorConfig2;
                    it3 = it2;
                    composer3 = composerStartRestartGroup;
                    VectorComposeKt.m1875Path9cdaXJ4((List) vectorConfig5.getOrDefault(VectorProperty.PathData.INSTANCE, vectorPath3.getPathData()), vectorPath3.m1892getPathFillTypeRgk1Os(), vectorPath3.getName(), (Brush) vectorConfig5.getOrDefault(VectorProperty.Fill.INSTANCE, vectorPath3.getFill()), ((Number) vectorConfig5.getOrDefault(VectorProperty.FillAlpha.INSTANCE, Float.valueOf(vectorPath3.getFillAlpha()))).floatValue(), (Brush) vectorConfig5.getOrDefault(VectorProperty.Stroke.INSTANCE, vectorPath3.getStroke()), ((Number) vectorConfig5.getOrDefault(VectorProperty.StrokeAlpha.INSTANCE, Float.valueOf(vectorPath3.getStrokeAlpha()))).floatValue(), ((Number) vectorConfig5.getOrDefault(VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf(vectorPath3.getStrokeLineWidth()))).floatValue(), vectorPath3.m1893getStrokeLineCapKaPHkGw(), vectorPath3.m1894getStrokeLineJoinLxFBmk8(), vectorPath3.getStrokeLineMiter(), ((Number) vectorConfig5.getOrDefault(VectorProperty.TrimPathStart.INSTANCE, Float.valueOf(vectorPath3.getTrimPathStart()))).floatValue(), ((Number) vectorConfig5.getOrDefault(VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf(vectorPath3.getTrimPathEnd()))).floatValue(), ((Number) vectorConfig5.getOrDefault(VectorProperty.TrimPathOffset.INSTANCE, Float.valueOf(vectorPath3.getTrimPathOffset()))).floatValue(), composer3, 0, 0, 0);
                    composer3.endReplaceGroup();
                    map5 = mapEmptyMap;
                } else {
                    it3 = it2;
                    map4 = mapEmptyMap;
                    composer3 = composerStartRestartGroup;
                    if (next instanceof VectorGroup) {
                        composer3.startReplaceGroup(-21815553);
                        VectorGroup vectorGroup4 = (VectorGroup) next;
                        map5 = map4;
                        vectorConfig = map5.get(vectorGroup4.getName());
                        if (vectorConfig == null) {
                            vectorConfig = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
                            };
                        }
                        VectorComposeKt.Group(vectorGroup4.getName(), ((Number) vectorConfig.getOrDefault(VectorProperty.Rotation.INSTANCE, Float.valueOf(vectorGroup4.getRotation()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.PivotX.INSTANCE, Float.valueOf(vectorGroup4.getPivotX()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.PivotY.INSTANCE, Float.valueOf(vectorGroup4.getPivotY()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.ScaleX.INSTANCE, Float.valueOf(vectorGroup4.getScaleX()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.ScaleY.INSTANCE, Float.valueOf(vectorGroup4.getScaleY()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.TranslateX.INSTANCE, Float.valueOf(vectorGroup4.getTranslationX()))).floatValue(), ((Number) vectorConfig.getOrDefault(VectorProperty.TranslateY.INSTANCE, Float.valueOf(vectorGroup4.getTranslationY()))).floatValue(), (List) vectorConfig.getOrDefault(VectorProperty.PathData.INSTANCE, vectorGroup4.getClipPathData()), ComposableLambdaKt.rememberComposableLambda(1450046638, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer4, int i5) {
                                if ((i5 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1450046638, i5, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup.<anonymous> (VectorPainter.kt:514)");
                                }
                                VectorPainterKt.RenderVectorGroup((VectorGroup) next, map5, composer4, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 805306368, 0);
                        composer3.endReplaceGroup();
                    } else {
                        map5 = map4;
                        composer3.startReplaceGroup(-20402883);
                        composer3.endReplaceGroup();
                    }
                }
                composerStartRestartGroup = composer3;
                mapEmptyMap = map5;
                it2 = it3;
            }
            map3 = mapEmptyMap;
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer4, int i5) {
                    VectorPainterKt.RenderVectorGroup(vectorGroup, map3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    private static final void mirror(DrawScope drawScope, Function1<? super DrawScope, Unit> function1) {
        long jMo1726getCenterF1C5BW0 = drawScope.mo1726getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo1648getSizeNHjbRc = drawContext.mo1648getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo1655scale0AR0LA0(-1.0f, 1.0f, jMo1726getCenterF1C5BW0);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo1649setSizeuvyYCjk(jMo1648getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }
}
