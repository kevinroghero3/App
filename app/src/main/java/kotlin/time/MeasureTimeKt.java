package kotlin.time;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class MeasureTimeKt {
    public static final long measureTime(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long jM6946markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m6946markNowz9LOYto();
        block.invoke();
        return TimeSource.Monotonic.ValueTimeMark.m6951elapsedNowUwyO8pc(jM6946markNowz9LOYto);
    }

    public static final long measureTime(@NotNull TimeSource timeSource, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(timeSource, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        TimeMark timeMarkMarkNow = timeSource.markNow();
        block.invoke();
        return timeMarkMarkNow.mo6821elapsedNowUwyO8pc();
    }

    public static final long measureTime(@NotNull TimeSource.Monotonic monotonic, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(monotonic, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        long jM6946markNowz9LOYto = monotonic.m6946markNowz9LOYto();
        block.invoke();
        return TimeSource.Monotonic.ValueTimeMark.m6951elapsedNowUwyO8pc(jM6946markNowz9LOYto);
    }

    public static final <T> TimedValue<T> measureTimedValue(@NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new TimedValue<>(block.invoke(), TimeSource.Monotonic.ValueTimeMark.m6951elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m6946markNowz9LOYto()), null);
    }

    public static final <T> TimedValue<T> measureTimedValue(@NotNull TimeSource timeSource, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(timeSource, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return new TimedValue<>(block.invoke(), timeSource.markNow().mo6821elapsedNowUwyO8pc(), null);
    }

    public static final <T> TimedValue<T> measureTimedValue(@NotNull TimeSource.Monotonic monotonic, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(monotonic, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return new TimedValue<>(block.invoke(), TimeSource.Monotonic.ValueTimeMark.m6951elapsedNowUwyO8pc(monotonic.m6946markNowz9LOYto()), null);
    }
}
