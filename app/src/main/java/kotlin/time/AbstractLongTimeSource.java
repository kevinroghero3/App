package kotlin.time;

import ch.qos.logback.core.CoreConstants;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;
    private final Lazy zero$delegate;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long read();

    public AbstractLongTimeSource(@NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
        this.zero$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kotlin.time.AbstractLongTimeSource$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(this.f$0.read());
            }
        });
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    private final long getZero() {
        return ((Number) this.zero$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long adjustedRead() {
        return read() - getZero();
    }

    static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        private LongTimeMark(long j, AbstractLongTimeSource timeSource, long j2) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.startedAt = j;
            this.timeSource = timeSource;
            this.offset = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo6822minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m6826minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
        public long mo6821elapsedNowUwyO8pc() {
            return Duration.m6859minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.timeSource.adjustedRead(), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo6824plusLRDsOJo(long j) {
            DurationUnit unit = this.timeSource.getUnit();
            if (Duration.m6856isInfiniteimpl(j)) {
                return new LongTimeMark(LongSaturatedMathKt.m6936saturatingAddNuflL3o(this.startedAt, unit, j), this.timeSource, Duration.Companion.m6922getZEROUwyO8pc(), null);
            }
            long jM6874truncateToUwyO8pc$kotlin_stdlib = Duration.m6874truncateToUwyO8pc$kotlin_stdlib(j, unit);
            long jM6860plusLRDsOJo = Duration.m6860plusLRDsOJo(Duration.m6859minusLRDsOJo(j, jM6874truncateToUwyO8pc$kotlin_stdlib), this.offset);
            long jM6936saturatingAddNuflL3o = LongSaturatedMathKt.m6936saturatingAddNuflL3o(this.startedAt, unit, jM6874truncateToUwyO8pc$kotlin_stdlib);
            long jM6874truncateToUwyO8pc$kotlin_stdlib2 = Duration.m6874truncateToUwyO8pc$kotlin_stdlib(jM6860plusLRDsOJo, unit);
            long jM6936saturatingAddNuflL3o2 = LongSaturatedMathKt.m6936saturatingAddNuflL3o(jM6936saturatingAddNuflL3o, unit, jM6874truncateToUwyO8pc$kotlin_stdlib2);
            long jM6859minusLRDsOJo = Duration.m6859minusLRDsOJo(jM6860plusLRDsOJo, jM6874truncateToUwyO8pc$kotlin_stdlib2);
            long jM6844getInWholeNanosecondsimpl = Duration.m6844getInWholeNanosecondsimpl(jM6859minusLRDsOJo);
            if (jM6936saturatingAddNuflL3o2 != 0 && jM6844getInWholeNanosecondsimpl != 0 && (jM6936saturatingAddNuflL3o2 ^ jM6844getInWholeNanosecondsimpl) < 0) {
                long duration = DurationKt.toDuration(MathKt__MathJVMKt.getSign(jM6844getInWholeNanosecondsimpl), unit);
                jM6936saturatingAddNuflL3o2 = LongSaturatedMathKt.m6936saturatingAddNuflL3o(jM6936saturatingAddNuflL3o2, unit, duration);
                jM6859minusLRDsOJo = Duration.m6859minusLRDsOJo(jM6859minusLRDsOJo, duration);
            }
            if ((1 | (jM6936saturatingAddNuflL3o2 - 1)) == Long.MAX_VALUE) {
                jM6859minusLRDsOJo = Duration.Companion.m6922getZEROUwyO8pc();
            }
            return new LongTimeMark(jM6936saturatingAddNuflL3o2, this.timeSource, jM6859minusLRDsOJo, null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc */
        public long mo6823minusUwyO8pc(@NotNull ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, longTimeMark.timeSource)) {
                    return Duration.m6860plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, longTimeMark.startedAt, this.timeSource.getUnit()), Duration.m6859minusLRDsOJo(this.offset, longTimeMark.offset));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(@Nullable Object obj) {
            return (obj instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) obj).timeSource) && Duration.m6836equalsimpl0(mo6823minusUwyO8pc((ComparableTimeMark) obj), Duration.Companion.m6922getZEROUwyO8pc());
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return (Duration.m6852hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt__DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m6871toStringimpl(this.offset)) + ", " + this.timeSource + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Override // kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.Companion.m6922getZEROUwyO8pc(), null);
    }
}
