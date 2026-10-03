package kotlin.ranges;

import ch.qos.logback.classic.pattern.CallerDataConverter;
import kotlin.Deprecated;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {
    public static final Companion Companion = new Companion(null);
    private static final ULongRange EMPTY = new ULongRange(-1, 0, null);

    public /* synthetic */ ULongRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    /* JADX INFO: renamed from: getEndExclusive-s-VKNKU$annotations, reason: not valid java name */
    public static /* synthetic */ void m6728getEndExclusivesVKNKU$annotations() {
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ boolean contains(Comparable comparable) {
        return m6729containsVKZWuLQ(((ULong) comparable).m5698unboximpl());
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* synthetic */ Comparable getEndExclusive() {
        return ULong.m5640boximpl(m6730getEndExclusivesVKNKU());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ Comparable getEndInclusive() {
        return ULong.m5640boximpl(m6731getEndInclusivesVKNKU());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ Comparable getStart() {
        return ULong.m5640boximpl(m6732getStartsVKNKU());
    }

    private ULongRange(long j, long j2) {
        super(j, j2, 1L, null);
    }

    /* JADX INFO: renamed from: getStart-s-VKNKU, reason: not valid java name */
    public long m6732getStartsVKNKU() {
        return m6724getFirstsVKNKU();
    }

    /* JADX INFO: renamed from: getEndInclusive-s-VKNKU, reason: not valid java name */
    public long m6731getEndInclusivesVKNKU() {
        return m6725getLastsVKNKU();
    }

    /* JADX INFO: renamed from: getEndExclusive-s-VKNKU, reason: not valid java name */
    public long m6730getEndExclusivesVKNKU() {
        if (m6725getLastsVKNKU() == -1) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
        }
        return ULong.m5646constructorimpl(m6725getLastsVKNKU() + ULong.m5646constructorimpl(((long) 1) & 4294967295L));
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m6729containsVKZWuLQ(long j) {
        return Long.compare(m6724getFirstsVKNKU() ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE) <= 0 && Long.compare(j ^ Long.MIN_VALUE, m6725getLastsVKNKU() ^ Long.MIN_VALUE) <= 0;
    }

    @Override // kotlin.ranges.ULongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return Long.compare(m6724getFirstsVKNKU() ^ Long.MIN_VALUE, m6725getLastsVKNKU() ^ Long.MIN_VALUE) > 0;
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ULongRange) {
            if (!isEmpty() || !((ULongRange) obj).isEmpty()) {
                ULongRange uLongRange = (ULongRange) obj;
                if (m6724getFirstsVKNKU() != uLongRange.m6724getFirstsVKNKU() || m6725getLastsVKNKU() != uLongRange.m6725getLastsVKNKU()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ULongProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((int) ULong.m5646constructorimpl(m6724getFirstsVKNKU() ^ ULong.m5646constructorimpl(m6724getFirstsVKNKU() >>> 32))) * 31) + ((int) ULong.m5646constructorimpl(m6725getLastsVKNKU() ^ ULong.m5646constructorimpl(m6725getLastsVKNKU() >>> 32)));
    }

    @Override // kotlin.ranges.ULongProgression
    public String toString() {
        return ((Object) ULong.m5692toStringimpl(m6724getFirstsVKNKU())) + CallerDataConverter.DEFAULT_RANGE_DELIMITER + ((Object) ULong.m5692toStringimpl(m6725getLastsVKNKU()));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ULongRange getEMPTY() {
            return ULongRange.EMPTY;
        }
    }
}
