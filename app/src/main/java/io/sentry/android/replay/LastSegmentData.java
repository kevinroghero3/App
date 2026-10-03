package io.sentry.android.replay;

import ch.qos.logback.core.CoreConstants;
import io.sentry.SentryReplayEvent;
import io.sentry.rrweb.RRWebEvent;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class LastSegmentData {
    public static final int $stable = 8;
    private final ReplayCache cache;
    private final long duration;
    private final List<RRWebEvent> events;
    private final int id;
    private final ScreenshotRecorderConfig recorderConfig;
    private final SentryReplayEvent.ReplayType replayType;
    private final String screenAtStart;
    private final Date timestamp;

    public final ScreenshotRecorderConfig component1() {
        return this.recorderConfig;
    }

    public final ReplayCache component2() {
        return this.cache;
    }

    public final Date component3() {
        return this.timestamp;
    }

    public final int component4() {
        return this.id;
    }

    public final long component5() {
        return this.duration;
    }

    public final SentryReplayEvent.ReplayType component6() {
        return this.replayType;
    }

    public final String component7() {
        return this.screenAtStart;
    }

    public final List<RRWebEvent> component8() {
        return this.events;
    }

    public final LastSegmentData copy(@NotNull ScreenshotRecorderConfig recorderConfig, @NotNull ReplayCache cache, @NotNull Date timestamp, int i, long j, @NotNull SentryReplayEvent.ReplayType replayType, @Nullable String str, @NotNull List<? extends RRWebEvent> events) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(replayType, "replayType");
        Intrinsics.checkNotNullParameter(events, "events");
        return new LastSegmentData(recorderConfig, cache, timestamp, i, j, replayType, str, events);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LastSegmentData)) {
            return false;
        }
        LastSegmentData lastSegmentData = (LastSegmentData) obj;
        return Intrinsics.areEqual(this.recorderConfig, lastSegmentData.recorderConfig) && Intrinsics.areEqual(this.cache, lastSegmentData.cache) && Intrinsics.areEqual(this.timestamp, lastSegmentData.timestamp) && this.id == lastSegmentData.id && this.duration == lastSegmentData.duration && this.replayType == lastSegmentData.replayType && Intrinsics.areEqual(this.screenAtStart, lastSegmentData.screenAtStart) && Intrinsics.areEqual(this.events, lastSegmentData.events);
    }

    public int hashCode() {
        int iHashCode = this.recorderConfig.hashCode();
        int iHashCode2 = this.cache.hashCode();
        int iHashCode3 = this.timestamp.hashCode();
        int iHashCode4 = Integer.hashCode(this.id);
        int iHashCode5 = Long.hashCode(this.duration);
        int iHashCode6 = this.replayType.hashCode();
        String str = this.screenAtStart;
        return (((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.events.hashCode();
    }

    public String toString() {
        return "LastSegmentData(recorderConfig=" + this.recorderConfig + ", cache=" + this.cache + ", timestamp=" + this.timestamp + ", id=" + this.id + ", duration=" + this.duration + ", replayType=" + this.replayType + ", screenAtStart=" + this.screenAtStart + ", events=" + this.events + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LastSegmentData(@NotNull ScreenshotRecorderConfig recorderConfig, @NotNull ReplayCache cache, @NotNull Date timestamp, int i, long j, @NotNull SentryReplayEvent.ReplayType replayType, @Nullable String str, @NotNull List<? extends RRWebEvent> events) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(replayType, "replayType");
        Intrinsics.checkNotNullParameter(events, "events");
        this.recorderConfig = recorderConfig;
        this.cache = cache;
        this.timestamp = timestamp;
        this.id = i;
        this.duration = j;
        this.replayType = replayType;
        this.screenAtStart = str;
        this.events = events;
    }

    public final ScreenshotRecorderConfig getRecorderConfig() {
        return this.recorderConfig;
    }

    public final ReplayCache getCache() {
        return this.cache;
    }

    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final int getId() {
        return this.id;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final SentryReplayEvent.ReplayType getReplayType() {
        return this.replayType;
    }

    public final String getScreenAtStart() {
        return this.screenAtStart;
    }

    public final List<RRWebEvent> getEvents() {
        return this.events;
    }
}
