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
public final class RadialGradient extends ShaderBrush {
    private final long center;
    private final List<Color> colors;
    private final float radius;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, f, i);
    }

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, j, f, (i2 & 16) != 0 ? TileMode.Companion.m1544getClamp3opZhB0() : i, null);
    }

    private RadialGradient(List<Color> list, List<Float> list2, long j, float f, int i) {
        this.colors = list;
        this.stops = list2;
        this.center = j;
        this.radius = f;
        this.tileMode = i;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo1117getIntrinsicSizeNHjbRc() {
        float f = this.radius;
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return Size.Companion.m1005getUnspecifiedNHjbRc();
        }
        float f2 = this.radius * 2;
        return SizeKt.Size(f2, f2);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo1138createShaderuvyYCjk(long j) {
        float fM997getWidthimpl;
        float fM994getHeightimpl;
        if (OffsetKt.m949isUnspecifiedk4lQ0M(this.center)) {
            long jM1007getCenteruvyYCjk = SizeKt.m1007getCenteruvyYCjk(j);
            fM997getWidthimpl = Offset.m928getXimpl(jM1007getCenteruvyYCjk);
            fM994getHeightimpl = Offset.m929getYimpl(jM1007getCenteruvyYCjk);
        } else {
            fM997getWidthimpl = Offset.m928getXimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m997getWidthimpl(j) : Offset.m928getXimpl(this.center);
            fM994getHeightimpl = Offset.m929getYimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m994getHeightimpl(j) : Offset.m929getYimpl(this.center);
        }
        List<Color> list = this.colors;
        List<Float> list2 = this.stops;
        long jOffset = OffsetKt.Offset(fM997getWidthimpl, fM994getHeightimpl);
        float f = this.radius;
        return ShaderKt.m1488RadialGradientShader8uybcMk(jOffset, f == Float.POSITIVE_INFINITY ? Size.m996getMinDimensionimpl(j) / 2 : f, list, list2, this.tileMode);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) obj;
        return Intrinsics.areEqual(this.colors, radialGradient.colors) && Intrinsics.areEqual(this.stops, radialGradient.stops) && Offset.m925equalsimpl0(this.center, radialGradient.center) && this.radius == radialGradient.radius && TileMode.m1540equalsimpl0(this.tileMode, radialGradient.tileMode);
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode();
        List<Float> list = this.stops;
        return (((((((iHashCode * 31) + (list != null ? list.hashCode() : 0)) * 31) + Offset.m930hashCodeimpl(this.center)) * 31) + Float.hashCode(this.radius)) * 31) + TileMode.m1541hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m947isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.m936toStringimpl(this.center)) + ", ";
        } else {
            str = "";
        }
        float f = this.radius;
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            str2 = "radius=" + this.radius + ", ";
        }
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) TileMode.m1542toStringimpl(this.tileMode)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
