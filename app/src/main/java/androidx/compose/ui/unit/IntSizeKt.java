package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;

/* JADX INFO: loaded from: classes.dex */
public final class IntSizeKt {
    /* JADX INFO: renamed from: getCenter-ozmzZPI$annotations, reason: not valid java name */
    public static /* synthetic */ void m3827getCenterozmzZPI$annotations(long j) {
    }

    public static final long IntSize(int i, int i2) {
        return IntSize.m3815constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }

    /* JADX INFO: renamed from: times-O0kMr_c, reason: not valid java name */
    public static final long m3829timesO0kMr_c(int i, long j) {
        return IntSize.m3822timesYEO4UFw(j, i);
    }

    /* JADX INFO: renamed from: toIntRect-ozmzZPI, reason: not valid java name */
    public static final IntRect m3830toIntRectozmzZPI(long j) {
        return IntRectKt.m3810IntRectVbeCjmY(IntOffset.Companion.m3788getZeronOccac(), j);
    }

    /* JADX INFO: renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m3826getCenterozmzZPI(long j) {
        return IntOffset.m3772constructorimpl(((j >> 33) << 32) | (((j << 32) >> 33) & 4294967295L));
    }

    /* JADX INFO: renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m3832toSizeozmzZPI(long j) {
        return SizeKt.Size(IntSize.m3820getWidthimpl(j), IntSize.m3819getHeightimpl(j));
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m3831toIntSizeuvyYCjk(long j) {
        return IntSize.m3815constructorimpl((((long) ((int) Size.m994getHeightimpl(j))) & 4294967295L) | (((long) ((int) Size.m997getWidthimpl(j))) << 32));
    }

    /* JADX INFO: renamed from: roundToIntSize-uvyYCjk, reason: not valid java name */
    public static final long m3828roundToIntSizeuvyYCjk(long j) {
        return IntSize.m3815constructorimpl((((long) Math.round(Size.m994getHeightimpl(j))) & 4294967295L) | (((long) Math.round(Size.m997getWidthimpl(j))) << 32));
    }
}
