package org.joda.time;

import android.os.Process;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DurationField implements Comparable<DurationField> {
    public static int onPrepareFromSearch;
    public static int onRemoveQueueItemAt;

    public abstract long add(long j, int i);

    public abstract long add(long j, long j2);

    public abstract int getDifference(long j, long j2);

    public abstract long getDifferenceAsLong(long j, long j2);

    public abstract long getMillis(int i);

    public abstract long getMillis(int i, long j);

    public abstract long getMillis(long j);

    public abstract long getMillis(long j, long j2);

    public abstract String getName();

    public abstract DurationFieldType getType();

    public abstract long getUnitMillis();

    public abstract int getValue(long j);

    public abstract int getValue(long j, long j2);

    public abstract long getValueAsLong(long j);

    public abstract long getValueAsLong(long j, long j2);

    public abstract boolean isPrecise();

    public abstract boolean isSupported();

    public abstract String toString();

    public long subtract(long j, int i) {
        if (i == Integer.MIN_VALUE) {
            return subtract(j, i);
        }
        return add(j, -i);
    }

    public long subtract(long j, long j2) {
        if (j2 == Long.MIN_VALUE) {
            throw new ArithmeticException("Long.MIN_VALUE cannot be negated");
        }
        return add(j, -j2);
    }

    public static int onServiceDisconnected() {
        int i = onRemoveQueueItemAt;
        int i2 = i % 7943085;
        onRemoveQueueItemAt = i + 1;
        if (i2 != 0) {
            return onPrepareFromSearch;
        }
        int iMyPid = Process.myPid();
        onPrepareFromSearch = iMyPid;
        return iMyPid;
    }
}
