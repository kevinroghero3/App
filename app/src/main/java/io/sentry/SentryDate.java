package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SentryDate implements Comparable<SentryDate> {
    public abstract long nanoTimestamp();

    public long laterDateNanosTimestampByDiff(@Nullable SentryDate sentryDate) {
        if (sentryDate != null && compareTo(sentryDate) < 0) {
            return sentryDate.nanoTimestamp();
        }
        return nanoTimestamp();
    }

    public long diff(@NotNull SentryDate sentryDate) {
        return nanoTimestamp() - sentryDate.nanoTimestamp();
    }

    public final boolean isBefore(@NotNull SentryDate sentryDate) {
        return diff(sentryDate) < 0;
    }

    public final boolean isAfter(@NotNull SentryDate sentryDate) {
        return diff(sentryDate) > 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull SentryDate sentryDate) {
        return Long.valueOf(nanoTimestamp()).compareTo(Long.valueOf(sentryDate.nanoTimestamp()));
    }
}
