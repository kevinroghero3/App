package kotlin.ranges;

import ch.qos.logback.classic.pattern.CallerDataConverter;
import kotlin.Deprecated;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {
    public static final Companion Companion;
    private static final UIntRange EMPTY;

    public /* synthetic */ UIntRange(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    /* JADX INFO: renamed from: getEndExclusive-pVg5ArA$annotations, reason: not valid java name */
    public static /* synthetic */ void m6719getEndExclusivepVg5ArA$annotations() {
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ boolean contains(Comparable comparable) {
        return m6720containsWZ4Q5Ns(((UInt) comparable).m5619unboximpl());
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* synthetic */ Comparable getEndExclusive() {
        return UInt.m5561boximpl(m6721getEndExclusivepVg5ArA());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ Comparable getEndInclusive() {
        return UInt.m5561boximpl(m6722getEndInclusivepVg5ArA());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ Comparable getStart() {
        return UInt.m5561boximpl(m6723getStartpVg5ArA());
    }

    private UIntRange(int i, int i2) {
        super(i, i2, 1, null);
    }

    /* JADX INFO: renamed from: getStart-pVg5ArA, reason: not valid java name */
    public int m6723getStartpVg5ArA() {
        return m6715getFirstpVg5ArA();
    }

    /* JADX INFO: renamed from: getEndInclusive-pVg5ArA, reason: not valid java name */
    public int m6722getEndInclusivepVg5ArA() {
        return m6716getLastpVg5ArA();
    }

    /* JADX INFO: renamed from: getEndExclusive-pVg5ArA, reason: not valid java name */
    public int m6721getEndExclusivepVg5ArA() {
        if (m6716getLastpVg5ArA() == -1) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
        }
        return UInt.m5567constructorimpl(m6716getLastpVg5ArA() + 1);
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m6720containsWZ4Q5Ns(int i) {
        return Integer.compare(m6715getFirstpVg5ArA() ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE) <= 0 && Integer.compare(i ^ Integer.MIN_VALUE, m6716getLastpVg5ArA() ^ Integer.MIN_VALUE) <= 0;
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return Integer.compare(m6715getFirstpVg5ArA() ^ Integer.MIN_VALUE, m6716getLastpVg5ArA() ^ Integer.MIN_VALUE) > 0;
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof UIntRange) {
            if (!isEmpty() || !((UIntRange) obj).isEmpty()) {
                UIntRange uIntRange = (UIntRange) obj;
                if (m6715getFirstpVg5ArA() != uIntRange.m6715getFirstpVg5ArA() || m6716getLastpVg5ArA() != uIntRange.m6716getLastpVg5ArA()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m6715getFirstpVg5ArA() * 31) + m6716getLastpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        return ((Object) UInt.m5613toStringimpl(m6715getFirstpVg5ArA())) + CallerDataConverter.DEFAULT_RANGE_DELIMITER + ((Object) UInt.m5613toStringimpl(m6716getLastpVg5ArA()));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UIntRange getEMPTY() {
            return UIntRange.EMPTY;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new Companion(defaultConstructorMarker);
        EMPTY = new UIntRange(-1, 0, defaultConstructorMarker);
    }
}
