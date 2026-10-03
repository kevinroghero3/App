package androidx.compose.ui.graphics;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class Interval<T> {
    private final T data;
    private final float end;
    private final float start;

    public Interval(float f, float f2, @Nullable T t) {
        this.start = f;
        this.end = f2;
        this.data = t;
    }

    public /* synthetic */ Interval(float f, float f2, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, (i & 4) != 0 ? null : obj);
    }

    public final T getData() {
        return this.data;
    }

    public final float getEnd() {
        return this.end;
    }

    public final float getStart() {
        return this.start;
    }

    public final boolean overlaps(@NotNull Interval<T> interval) {
        return this.start <= interval.end && this.end >= interval.start;
    }

    public final boolean overlaps(float f, float f2) {
        return this.start <= f2 && this.end >= f;
    }

    public final boolean contains(float f) {
        return f <= this.end && this.start <= f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Interval interval = (Interval) obj;
            return this.start == interval.start && this.end == interval.end && Intrinsics.areEqual(this.data, interval.data);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = Float.hashCode(this.start);
        int iHashCode2 = Float.hashCode(this.end);
        T t = this.data;
        return (((iHashCode * 31) + iHashCode2) * 31) + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "Interval(start=" + this.start + ", end=" + this.end + ", data=" + this.data + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
