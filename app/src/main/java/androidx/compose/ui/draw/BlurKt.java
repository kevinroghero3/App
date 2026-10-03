package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurKt {
    /* JADX INFO: renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m804blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m807boximpl(BlurredEdgeTreatment.Companion.m814getRectangleGoahg());
        }
        return m803blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m813unboximpl());
    }

    /* JADX INFO: renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m803blur1fqSgw(@NotNull Modifier modifier, final float f, final float f2, @NotNull final Shape shape) {
        final boolean z;
        final int iM1545getDecal3opZhB0;
        if (shape != null) {
            iM1545getDecal3opZhB0 = TileMode.Companion.m1544getClamp3opZhB0();
            z = true;
        } else {
            z = false;
            iM1545getDecal3opZhB0 = TileMode.Companion.m1545getDecal3opZhB0();
        }
        float f3 = 0;
        return ((Dp.m3649compareTo0680j_4(f, Dp.m3650constructorimpl(f3)) <= 0 || Dp.m3649compareTo0680j_4(f2, Dp.m3650constructorimpl(f3)) <= 0) && !z) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GraphicsLayerScope graphicsLayerScope) {
                float fMo2483toPx0680j_4 = graphicsLayerScope.mo2483toPx0680j_4(f);
                float fMo2483toPx0680j_5 = graphicsLayerScope.mo2483toPx0680j_4(f2);
                graphicsLayerScope.setRenderEffect((fMo2483toPx0680j_4 <= 0.0f || fMo2483toPx0680j_5 <= 0.0f) ? null : RenderEffectKt.m1479BlurEffect3YTHUZs(fMo2483toPx0680j_4, fMo2483toPx0680j_5, iM1545getDecal3opZhB0));
                Shape rectangleShape = shape;
                if (rectangleShape == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                graphicsLayerScope.setShape(rectangleShape);
                graphicsLayerScope.setClip(z);
            }
        });
    }

    /* JADX INFO: renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m806blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m807boximpl(BlurredEdgeTreatment.Companion.m814getRectangleGoahg());
        }
        return m805blurF8QBwvs(modifier, f, blurredEdgeTreatment.m813unboximpl());
    }

    /* JADX INFO: renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m805blurF8QBwvs(@NotNull Modifier modifier, float f, @NotNull Shape shape) {
        return m803blur1fqSgw(modifier, f, f, shape);
    }
}
