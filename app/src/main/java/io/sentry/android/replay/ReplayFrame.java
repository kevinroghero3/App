package io.sentry.android.replay;

import ch.qos.logback.core.CoreConstants;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ReplayFrame {
    public static final int $stable = 8;
    private final String screen;
    private final File screenshot;
    private final long timestamp;

    public static /* synthetic */ ReplayFrame copy$default(ReplayFrame replayFrame, File file, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            file = replayFrame.screenshot;
        }
        if ((i & 2) != 0) {
            j = replayFrame.timestamp;
        }
        if ((i & 4) != 0) {
            str = replayFrame.screen;
        }
        return replayFrame.copy(file, j, str);
    }

    public final File component1() {
        return this.screenshot;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.screen;
    }

    public final ReplayFrame copy(@NotNull File screenshot, long j, @Nullable String str) {
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        return new ReplayFrame(screenshot, j, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReplayFrame)) {
            return false;
        }
        ReplayFrame replayFrame = (ReplayFrame) obj;
        return Intrinsics.areEqual(this.screenshot, replayFrame.screenshot) && this.timestamp == replayFrame.timestamp && Intrinsics.areEqual(this.screen, replayFrame.screen);
    }

    public int hashCode() {
        int iHashCode = this.screenshot.hashCode();
        int iHashCode2 = Long.hashCode(this.timestamp);
        String str = this.screen;
        return (((iHashCode * 31) + iHashCode2) * 31) + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ReplayFrame(screenshot=" + this.screenshot + ", timestamp=" + this.timestamp + ", screen=" + this.screen + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ReplayFrame(@NotNull File screenshot, long j, @Nullable String str) {
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        this.screenshot = screenshot;
        this.timestamp = j;
        this.screen = str;
    }

    public /* synthetic */ ReplayFrame(File file, long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, j, (i & 4) != 0 ? null : str);
    }

    public final File getScreenshot() {
        return this.screenshot;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getScreen() {
        return this.screen;
    }
}
