package androidx.compose.ui.graphics;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LightingColorFilter extends ColorFilter {
    private final long add;
    private final long multiply;

    public /* synthetic */ LightingColorFilter(long j, long j2, android.graphics.ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, colorFilter);
    }

    public /* synthetic */ LightingColorFilter(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    /* JADX INFO: renamed from: getMultiply-0d7_KjU, reason: not valid java name */
    public final long m1398getMultiply0d7_KjU() {
        return this.multiply;
    }

    /* JADX INFO: renamed from: getAdd-0d7_KjU, reason: not valid java name */
    public final long m1397getAdd0d7_KjU() {
        return this.add;
    }

    private LightingColorFilter(long j, long j2, android.graphics.ColorFilter colorFilter) {
        super(colorFilter);
        this.multiply = j;
        this.add = j2;
    }

    private LightingColorFilter(long j, long j2) {
        this(j, j2, AndroidColorFilter_androidKt.m1034actualLightingColorFilterOWjLjI(j, j2), null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LightingColorFilter)) {
            return false;
        }
        LightingColorFilter lightingColorFilter = (LightingColorFilter) obj;
        return Color.m1170equalsimpl0(this.multiply, lightingColorFilter.multiply) && Color.m1170equalsimpl0(this.add, lightingColorFilter.add);
    }

    public int hashCode() {
        return (Color.m1176hashCodeimpl(this.multiply) * 31) + Color.m1176hashCodeimpl(this.add);
    }

    public String toString() {
        return "LightingColorFilter(multiply=" + ((Object) Color.m1177toStringimpl(this.multiply)) + ", add=" + ((Object) Color.m1177toStringimpl(this.add)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
