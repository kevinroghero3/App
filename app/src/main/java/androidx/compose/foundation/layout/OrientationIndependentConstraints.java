package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@JvmInline
public final class OrientationIndependentConstraints {
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OrientationIndependentConstraints m487boximpl(long j) {
        return new OrientationIndependentConstraints(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m489constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m493equalsimpl(long j, Object obj) {
        return (obj instanceof OrientationIndependentConstraints) && Constraints.m3596equalsimpl0(j, ((OrientationIndependentConstraints) obj).m505unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m494equalsimpl0(long j, long j2) {
        return Constraints.m3596equalsimpl0(j, j2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m499hashCodeimpl(long j) {
        return Constraints.m3606hashCodeimpl(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m504toStringimpl(long j) {
        return "OrientationIndependentConstraints(value=" + ((Object) Constraints.m3608toStringimpl(j)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m493equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m499hashCodeimpl(this.value);
    }

    public String toString() {
        return m504toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m505unboximpl() {
        return this.value;
    }

    private /* synthetic */ OrientationIndependentConstraints(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: getMainAxisMin-impl, reason: not valid java name */
    public static final int m498getMainAxisMinimpl(long j) {
        return Constraints.m3605getMinWidthimpl(j);
    }

    /* JADX INFO: renamed from: getMainAxisMax-impl, reason: not valid java name */
    public static final int m497getMainAxisMaximpl(long j) {
        return Constraints.m3603getMaxWidthimpl(j);
    }

    /* JADX INFO: renamed from: getCrossAxisMin-impl, reason: not valid java name */
    public static final int m496getCrossAxisMinimpl(long j) {
        return Constraints.m3604getMinHeightimpl(j);
    }

    /* JADX INFO: renamed from: getCrossAxisMax-impl, reason: not valid java name */
    public static final int m495getCrossAxisMaximpl(long j) {
        return Constraints.m3602getMaxHeightimpl(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m488constructorimpl(int i, int i2, int i3, int i4) {
        return m489constructorimpl(ConstraintsKt.Constraints(i, i2, i3, i4));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m490constructorimpl(long j, @NotNull LayoutOrientation layoutOrientation) {
        LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
        return m488constructorimpl(layoutOrientation == layoutOrientation2 ? Constraints.m3605getMinWidthimpl(j) : Constraints.m3604getMinHeightimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m3603getMaxWidthimpl(j) : Constraints.m3602getMaxHeightimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m3604getMinHeightimpl(j) : Constraints.m3605getMinWidthimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m3602getMaxHeightimpl(j) : Constraints.m3603getMaxWidthimpl(j));
    }

    /* JADX INFO: renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m503toBoxConstraintsOenEA2s(long j, @NotNull LayoutOrientation layoutOrientation) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return ConstraintsKt.Constraints(Constraints.m3605getMinWidthimpl(j), Constraints.m3603getMaxWidthimpl(j), Constraints.m3604getMinHeightimpl(j), Constraints.m3602getMaxHeightimpl(j));
        }
        return ConstraintsKt.Constraints(Constraints.m3604getMinHeightimpl(j), Constraints.m3602getMaxHeightimpl(j), Constraints.m3605getMinWidthimpl(j), Constraints.m3603getMaxWidthimpl(j));
    }

    /* JADX INFO: renamed from: maxWidth-impl, reason: not valid java name */
    public static final int m501maxWidthimpl(long j, @NotNull LayoutOrientation layoutOrientation) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return Constraints.m3603getMaxWidthimpl(j);
        }
        return Constraints.m3602getMaxHeightimpl(j);
    }

    /* JADX INFO: renamed from: maxHeight-impl, reason: not valid java name */
    public static final int m500maxHeightimpl(long j, @NotNull LayoutOrientation layoutOrientation) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return Constraints.m3602getMaxHeightimpl(j);
        }
        return Constraints.m3603getMaxWidthimpl(j);
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0, reason: not valid java name */
    public static final long m491copyyUG9Ft0(long j, int i, int i2, int i3, int i4) {
        return m488constructorimpl(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: stretchCrossAxis-q4ezo7Y, reason: not valid java name */
    public static final long m502stretchCrossAxisq4ezo7Y(long j) {
        return m488constructorimpl(Constraints.m3605getMinWidthimpl(j), Constraints.m3603getMaxWidthimpl(j), Constraints.m3602getMaxHeightimpl(j) != Integer.MAX_VALUE ? Constraints.m3602getMaxHeightimpl(j) : Constraints.m3604getMinHeightimpl(j), Constraints.m3602getMaxHeightimpl(j));
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0$default, reason: not valid java name */
    public static /* synthetic */ long m492copyyUG9Ft0$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = Constraints.m3605getMinWidthimpl(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = Constraints.m3603getMaxWidthimpl(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = Constraints.m3604getMinHeightimpl(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = Constraints.m3602getMaxHeightimpl(j);
        }
        return m491copyyUG9Ft0(j, i6, i7, i8, i4);
    }
}
