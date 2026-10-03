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
public final class SweepGradient extends ShaderBrush {
    private final long center;
    private final List<Color> colors;
    private final List<Float> stops;

    public /* synthetic */ SweepGradient(long j, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, list, list2);
    }

    public /* synthetic */ SweepGradient(long j, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, list, (i & 4) != 0 ? null : list2, null);
    }

    private SweepGradient(long j, List<Color> list, List<Float> list2) {
        this.center = j;
        this.colors = list;
        this.stops = list2;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo1138createShaderuvyYCjk(long j) {
        long jOffset;
        if (OffsetKt.m949isUnspecifiedk4lQ0M(this.center)) {
            jOffset = SizeKt.m1007getCenteruvyYCjk(j);
        } else {
            jOffset = OffsetKt.Offset(Offset.m928getXimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m997getWidthimpl(j) : Offset.m928getXimpl(this.center), Offset.m929getYimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m994getHeightimpl(j) : Offset.m929getYimpl(this.center));
        }
        return ShaderKt.m1490SweepGradientShader9KIMszo(jOffset, this.colors, this.stops);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SweepGradient)) {
            return false;
        }
        SweepGradient sweepGradient = (SweepGradient) obj;
        return Offset.m925equalsimpl0(this.center, sweepGradient.center) && Intrinsics.areEqual(this.colors, sweepGradient.colors) && Intrinsics.areEqual(this.stops, sweepGradient.stops);
    }

    public int hashCode() {
        int iM930hashCodeimpl = Offset.m930hashCodeimpl(this.center);
        int iHashCode = this.colors.hashCode();
        List<Float> list = this.stops;
        return (((iM930hashCodeimpl * 31) + iHashCode) * 31) + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str;
        if (OffsetKt.m947isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.m936toStringimpl(this.center)) + ", ";
        } else {
            str = "";
        }
        return "SweepGradient(" + str + "colors=" + this.colors + ", stops=" + this.stops + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
