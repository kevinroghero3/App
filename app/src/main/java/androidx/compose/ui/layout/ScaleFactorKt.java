package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ScaleFactorKt {
    /* JADX INFO: renamed from: isSpecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m2625isSpecifiedFK8aYYs$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m2627isUnspecifiedFK8aYYs$annotations(long j) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float roundToTenths(float f) {
        float f2 = 10;
        float f3 = f * f2;
        int i = (int) f3;
        if (f3 - i >= 0.5f) {
            i++;
        }
        return i / f2;
    }

    /* JADX INFO: renamed from: isSpecified-FK8aYYs, reason: not valid java name */
    public static final boolean m2624isSpecifiedFK8aYYs(long j) {
        return j != ScaleFactor.Companion.m2622getUnspecified_hLwfpc();
    }

    /* JADX INFO: renamed from: isUnspecified-FK8aYYs, reason: not valid java name */
    public static final boolean m2626isUnspecifiedFK8aYYs(long j) {
        return j == ScaleFactor.Companion.m2622getUnspecified_hLwfpc();
    }

    /* JADX INFO: renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m2630timesUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m997getWidthimpl(j) * ScaleFactor.m2615getScaleXimpl(j2), Size.m994getHeightimpl(j) * ScaleFactor.m2616getScaleYimpl(j2));
    }

    /* JADX INFO: renamed from: times-m-w2e94, reason: not valid java name */
    public static final long m2631timesmw2e94(long j, long j2) {
        return m2630timesUQTWf7w(j2, j);
    }

    /* JADX INFO: renamed from: div-UQTWf7w, reason: not valid java name */
    public static final long m2623divUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m997getWidthimpl(j) / ScaleFactor.m2615getScaleXimpl(j2), Size.m994getHeightimpl(j) / ScaleFactor.m2616getScaleYimpl(j2));
    }

    /* JADX INFO: renamed from: lerp--bDIf60, reason: not valid java name */
    public static final long m2628lerpbDIf60(long j, long j2, float f) {
        return ScaleFactor(MathHelpersKt.lerp(ScaleFactor.m2615getScaleXimpl(j), ScaleFactor.m2615getScaleXimpl(j2), f), MathHelpersKt.lerp(ScaleFactor.m2616getScaleYimpl(j), ScaleFactor.m2616getScaleYimpl(j2), f));
    }

    public static final long ScaleFactor(float f, float f2) {
        return ScaleFactor.m2609constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32));
    }

    /* JADX INFO: renamed from: takeOrElse-oyDd2qo, reason: not valid java name */
    public static final long m2629takeOrElseoyDd2qo(long j, @NotNull Function0<ScaleFactor> function0) {
        return j != ScaleFactor.Companion.m2622getUnspecified_hLwfpc() ? j : function0.invoke().m2620unboximpl();
    }
}
