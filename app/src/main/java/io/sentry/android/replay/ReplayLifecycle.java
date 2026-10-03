package io.sentry.android.replay;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ReplayLifecycle {
    public static final int $stable = 8;
    private volatile ReplayState currentState = ReplayState.INITIAL;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReplayState.values().length];
            try {
                iArr[ReplayState.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReplayState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReplayState.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReplayState.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReplayState.STOPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReplayState.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final ReplayState getCurrentState$sentry_android_replay_release() {
        return this.currentState;
    }

    public final void setCurrentState$sentry_android_replay_release(@NotNull ReplayState replayState) {
        Intrinsics.checkNotNullParameter(replayState, "<set-?>");
        this.currentState = replayState;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:37:0x0051 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0053 A[ORIG_RETURN, RETURN] */
    public final boolean isAllowed(@NotNull ReplayState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        switch (WhenMappings.$EnumSwitchMapping$0[this.currentState.ordinal()]) {
            case 1:
                if (newState == ReplayState.STARTED || newState == ReplayState.CLOSED) {
                    return true;
                }
                return false;
            case 2:
                if (newState == ReplayState.PAUSED || newState == ReplayState.STOPPED || newState == ReplayState.CLOSED) {
                    return true;
                }
                return false;
            case 3:
                if (newState == ReplayState.PAUSED || newState == ReplayState.STOPPED || newState == ReplayState.CLOSED) {
                    return true;
                }
                return false;
            case 4:
                if (newState == ReplayState.RESUMED || newState == ReplayState.STOPPED || newState == ReplayState.CLOSED) {
                    return true;
                }
                return false;
            case 5:
                if (newState == ReplayState.STARTED || newState == ReplayState.CLOSED) {
                    return true;
                }
                return false;
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isTouchRecordingAllowed() {
        return this.currentState == ReplayState.STARTED || this.currentState == ReplayState.RESUMED;
    }
}
