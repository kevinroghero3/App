package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import ch.qos.logback.core.CoreConstants;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LinearGradient extends ShaderBrush {
    private final List<Color> colors;
    private final long end;
    private final long start;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, j2, i);
    }

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, j, j2, (i2 & 16) != 0 ? TileMode.Companion.m1544getClamp3opZhB0() : i, null);
    }

    private LinearGradient(List<Color> list, List<Float> list2, long j, long j2, int i) {
        this.colors = list;
        this.stops = list2;
        this.start = j;
        this.end = j2;
        this.tileMode = i;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0038  */
    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo1117getIntrinsicSizeNHjbRc() {
        float fAbs;
        float fM928getXimpl = Offset.m928getXimpl(this.start);
        float fAbs2 = Float.NaN;
        if (Float.isInfinite(fM928getXimpl) || Float.isNaN(fM928getXimpl)) {
            fAbs = Float.NaN;
        } else {
            float fM928getXimpl2 = Offset.m928getXimpl(this.end);
            if (Float.isInfinite(fM928getXimpl2) || Float.isNaN(fM928getXimpl2)) {
                fAbs = Float.NaN;
            } else {
                fAbs = Math.abs(Offset.m928getXimpl(this.start) - Offset.m928getXimpl(this.end));
            }
        }
        float fM929getYimpl = Offset.m929getYimpl(this.start);
        if (!Float.isInfinite(fM929getYimpl) && !Float.isNaN(fM929getYimpl)) {
            float fM929getYimpl2 = Offset.m929getYimpl(this.end);
            if (!Float.isInfinite(fM929getYimpl2) && !Float.isNaN(fM929getYimpl2)) {
                fAbs2 = Math.abs(Offset.m929getYimpl(this.start) - Offset.m929getYimpl(this.end));
            }
        }
        return SizeKt.Size(fAbs, fAbs2);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo1138createShaderuvyYCjk(long j) {
        return ShaderKt.m1486LinearGradientShaderVjE6UOU(OffsetKt.Offset(Offset.m928getXimpl(this.start) == Float.POSITIVE_INFINITY ? Size.m997getWidthimpl(j) : Offset.m928getXimpl(this.start), Offset.m929getYimpl(this.start) == Float.POSITIVE_INFINITY ? Size.m994getHeightimpl(j) : Offset.m929getYimpl(this.start)), OffsetKt.Offset(Offset.m928getXimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m997getWidthimpl(j) : Offset.m928getXimpl(this.end), Offset.m929getYimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m994getHeightimpl(j) : Offset.m929getYimpl(this.end)), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        return Intrinsics.areEqual(this.colors, linearGradient.colors) && Intrinsics.areEqual(this.stops, linearGradient.stops) && Offset.m925equalsimpl0(this.start, linearGradient.start) && Offset.m925equalsimpl0(this.end, linearGradient.end) && TileMode.m1540equalsimpl0(this.tileMode, linearGradient.tileMode);
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode();
        List<Float> list = this.stops;
        return (((((((iHashCode * 31) + (list != null ? list.hashCode() : 0)) * 31) + Offset.m930hashCodeimpl(this.start)) * 31) + Offset.m930hashCodeimpl(this.end)) * 31) + TileMode.m1541hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m945isFinitek4lQ0M(this.start)) {
            str = "start=" + ((Object) Offset.m936toStringimpl(this.start)) + ", ";
        } else {
            str = "";
        }
        if (OffsetKt.m945isFinitek4lQ0M(this.end)) {
            str2 = "end=" + ((Object) Offset.m936toStringimpl(this.end)) + ", ";
        }
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) TileMode.m1542toStringimpl(this.tileMode)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
