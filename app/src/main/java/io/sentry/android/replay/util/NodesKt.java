package io.sentry.android.replay.util;

import android.graphics.Rect;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntSize;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class NodesKt {
    private static final float fastCoerceAtLeast(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    private static final float fastCoerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    private static final float fastCoerceIn(float f, float f2, float f3) {
        if (f < f2) {
            f = f2;
        }
        return f > f3 ? f3 : f;
    }

    public static final Painter findPainter(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        List<ModifierInfo> modifierInfo = layoutNode.getModifierInfo();
        int size = modifierInfo.size();
        for (int i = 0; i < size; i++) {
            Modifier modifier = modifierInfo.get(i).getModifier();
            String name = modifier.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "modifier::class.java.name");
            if (StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "Painter", false, 2, (Object) null)) {
                try {
                    Field declaredField = modifier.getClass().getDeclaredField("painter");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(modifier);
                    if (obj instanceof Painter) {
                        return (Painter) obj;
                    }
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }
        return null;
    }

    public static final boolean isMaskable(@NotNull Painter painter) {
        Intrinsics.checkNotNullParameter(painter, "<this>");
        String className = painter.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(className, "className");
        return (StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) "Vector", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) "Color", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) "Brush", false, 2, (Object) null)) ? false : true;
    }

    public static final TextAttributes findTextAttributes(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        List<ModifierInfo> modifierInfo = layoutNode.getModifierInfo();
        int size = modifierInfo.size();
        Color colorM1159boximpl = null;
        boolean z = false;
        for (int i = 0; i < size; i++) {
            Modifier modifier = modifierInfo.get(i).getModifier();
            String modifierClassName = modifier.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(modifierClassName, "modifierClassName");
            if (StringsKt__StringsKt.contains$default((CharSequence) modifierClassName, (CharSequence) "Text", false, 2, (Object) null)) {
                try {
                    Field declaredField = modifier.getClass().getDeclaredField("color");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(modifier);
                    ColorProducer colorProducer = obj instanceof ColorProducer ? (ColorProducer) obj : null;
                    colorM1159boximpl = colorProducer != null ? Color.m1159boximpl(colorProducer.m1250invoke0d7_KjU()) : null;
                } catch (Throwable unused) {
                }
            } else if (StringsKt__StringsKt.contains$default((CharSequence) modifierClassName, (CharSequence) "Fill", false, 2, (Object) null)) {
                z = true;
            }
        }
        return new TextAttributes(colorM1159boximpl, z, null);
    }

    private static final float fastMinOf(float f, float f2, float f3, float f4) {
        return Math.min(f, Math.min(f2, Math.min(f3, f4)));
    }

    private static final float fastMaxOf(float f, float f2, float f3, float f4) {
        return Math.max(f, Math.max(f2, Math.max(f3, f4)));
    }

    public static final Rect boundsInWindow(@NotNull LayoutCoordinates layoutCoordinates, @Nullable LayoutCoordinates layoutCoordinates2) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        if (layoutCoordinates2 == null) {
            layoutCoordinates2 = LayoutCoordinatesKt.findRootCoordinates(layoutCoordinates);
        }
        float fM3820getWidthimpl = IntSize.m3820getWidthimpl(layoutCoordinates2.mo2533getSizeYbymL2g());
        float fM3819getHeightimpl = IntSize.m3819getHeightimpl(layoutCoordinates2.mo2533getSizeYbymL2g());
        androidx.compose.ui.geometry.Rect rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(layoutCoordinates2, layoutCoordinates, false, 2, null);
        float left = rectLocalBoundingBoxOf$default.getLeft();
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > fM3820getWidthimpl) {
            left = fM3820getWidthimpl;
        }
        float top = rectLocalBoundingBoxOf$default.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > fM3819getHeightimpl) {
            top = fM3819getHeightimpl;
        }
        float right = rectLocalBoundingBoxOf$default.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= fM3820getWidthimpl) {
            fM3820getWidthimpl = right;
        }
        float bottom = rectLocalBoundingBoxOf$default.getBottom();
        float f = bottom >= 0.0f ? bottom : 0.0f;
        if (f <= fM3819getHeightimpl) {
            fM3819getHeightimpl = f;
        }
        if (left == fM3820getWidthimpl || top == fM3819getHeightimpl) {
            return new Rect();
        }
        long jMo2538localToWindowMKHz9U = layoutCoordinates2.mo2538localToWindowMKHz9U(OffsetKt.Offset(left, top));
        long jMo2538localToWindowMKHz9U2 = layoutCoordinates2.mo2538localToWindowMKHz9U(OffsetKt.Offset(fM3820getWidthimpl, top));
        long jMo2538localToWindowMKHz9U3 = layoutCoordinates2.mo2538localToWindowMKHz9U(OffsetKt.Offset(fM3820getWidthimpl, fM3819getHeightimpl));
        long jMo2538localToWindowMKHz9U4 = layoutCoordinates2.mo2538localToWindowMKHz9U(OffsetKt.Offset(left, fM3819getHeightimpl));
        float fM928getXimpl = Offset.m928getXimpl(jMo2538localToWindowMKHz9U);
        float fM928getXimpl2 = Offset.m928getXimpl(jMo2538localToWindowMKHz9U2);
        float fM928getXimpl3 = Offset.m928getXimpl(jMo2538localToWindowMKHz9U4);
        float fM928getXimpl4 = Offset.m928getXimpl(jMo2538localToWindowMKHz9U3);
        float fMin = Math.min(fM928getXimpl, Math.min(fM928getXimpl2, Math.min(fM928getXimpl3, fM928getXimpl4)));
        float fMax = Math.max(fM928getXimpl, Math.max(fM928getXimpl2, Math.max(fM928getXimpl3, fM928getXimpl4)));
        float fM929getYimpl = Offset.m929getYimpl(jMo2538localToWindowMKHz9U);
        float fM929getYimpl2 = Offset.m929getYimpl(jMo2538localToWindowMKHz9U2);
        float fM929getYimpl3 = Offset.m929getYimpl(jMo2538localToWindowMKHz9U4);
        float fM929getYimpl4 = Offset.m929getYimpl(jMo2538localToWindowMKHz9U3);
        return new Rect((int) fMin, (int) Math.min(fM929getYimpl, Math.min(fM929getYimpl2, Math.min(fM929getYimpl3, fM929getYimpl4))), (int) fMax, (int) Math.max(fM929getYimpl, Math.max(fM929getYimpl2, Math.max(fM929getYimpl3, fM929getYimpl4))));
    }
}
