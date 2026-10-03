package kotlin.time;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface TimeMark {
    /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
    long mo6821elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    /* JADX INFO: renamed from: minus-LRDsOJo */
    TimeMark mo6822minusLRDsOJo(long j);

    /* JADX INFO: renamed from: plus-LRDsOJo */
    TimeMark mo6824plusLRDsOJo(long j);

    /* JADX INFO: loaded from: classes6.dex */
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
        public static TimeMark m6945plusLRDsOJo(@NotNull TimeMark timeMark, long j) {
            return new AdjustedTimeMark(timeMark, j, null);
        }

        /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
        public static TimeMark m6944minusLRDsOJo(@NotNull TimeMark timeMark, long j) {
            return timeMark.mo6824plusLRDsOJo(Duration.m6875unaryMinusUwyO8pc(j));
        }

        public static boolean hasPassedNow(@NotNull TimeMark timeMark) {
            return !Duration.m6857isNegativeimpl(timeMark.mo6821elapsedNowUwyO8pc());
        }

        public static boolean hasNotPassedNow(@NotNull TimeMark timeMark) {
            return Duration.m6857isNegativeimpl(timeMark.mo6821elapsedNowUwyO8pc());
        }
    }
}
