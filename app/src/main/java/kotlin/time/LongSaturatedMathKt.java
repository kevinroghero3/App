package kotlin.time;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class LongSaturatedMathKt {
    public static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == Long.MAX_VALUE;
    }

    /* JADX INFO: renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m6936saturatingAddNuflL3o(long j, @NotNull DurationUnit unit, long j2) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long jM6870toLongimpl = Duration.m6870toLongimpl(j2, unit);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return m6935checkInfiniteSumDefinedPjuGub4(j, j2, jM6870toLongimpl);
        }
        if ((1 | (jM6870toLongimpl - 1)) == Long.MAX_VALUE) {
            return m6937saturatingAddInHalvesNuflL3o(j, unit, j2);
        }
        long j3 = j + jM6870toLongimpl;
        if (((j ^ j3) & (jM6870toLongimpl ^ j3)) < 0) {
            return j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return j3;
    }

    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m6935checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m6856isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m6937saturatingAddInHalvesNuflL3o(long j, DurationUnit durationUnit, long j2) {
        long jM6834divUwyO8pc = Duration.m6834divUwyO8pc(j2, 2);
        long jM6870toLongimpl = Duration.m6870toLongimpl(jM6834divUwyO8pc, durationUnit);
        return (1 | (jM6870toLongimpl - 1)) == Long.MAX_VALUE ? jM6870toLongimpl : m6936saturatingAddNuflL3o(m6936saturatingAddNuflL3o(j, durationUnit, jM6834divUwyO8pc), durationUnit, Duration.m6859minusLRDsOJo(j2, jM6834divUwyO8pc));
    }

    private static final long infinityOfSign(long j) {
        return j < 0 ? Duration.Companion.m6921getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.Companion.m6920getINFINITEUwyO8pc();
    }

    public static final long saturatingDiff(long j, long j2, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if ((1 | (j2 - 1)) == Long.MAX_VALUE) {
            return Duration.m6875unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        return saturatingFiniteDiff(j, j2, unit);
    }

    public static final long saturatingOriginsDiff(long j, long j2, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            if (j == j2) {
                return Duration.Companion.m6922getZEROUwyO8pc();
            }
            return Duration.m6875unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        if ((1 | (j - 1)) == Long.MAX_VALUE) {
            return infinityOfSign(j);
        }
        return saturatingFiniteDiff(j, j2, unit);
    }

    private static final long saturatingFiniteDiff(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) < 0) {
            DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
            if (durationUnit.compareTo(durationUnit2) < 0) {
                long jConvertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1L, durationUnit2, durationUnit);
                Duration.Companion companion = Duration.Companion;
                return Duration.m6860plusLRDsOJo(DurationKt.toDuration((j / jConvertDurationUnit) - (j2 / jConvertDurationUnit), durationUnit2), DurationKt.toDuration((j % jConvertDurationUnit) - (j2 % jConvertDurationUnit), durationUnit));
            }
            return Duration.m6875unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        return DurationKt.toDuration(j3, durationUnit);
    }
}
