package com.facebook.react.fabric;

import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class LongStreamingStats {
    private double average;
    private int len;
    private long max;
    private final Queue<Long> minHeap = new PriorityQueue(11);
    private final Queue<Long> maxHeap = new PriorityQueue(11, ComparisonsKt__ComparisonsKt.reverseOrder());

    public final double getAverage() {
        return this.average;
    }

    public final long getMax() {
        return this.max;
    }

    public final void add(long j) {
        if (j != 0) {
            if (this.minHeap.size() == this.maxHeap.size()) {
                this.maxHeap.offer(Long.valueOf(j));
                this.minHeap.offer(this.maxHeap.poll());
            } else {
                this.minHeap.offer(Long.valueOf(j));
                this.maxHeap.offer(this.minHeap.poll());
            }
        }
        int i = this.len;
        int i2 = i + 1;
        this.len = i2;
        if (i2 == 1) {
            this.average = j;
        } else {
            this.average = (this.average / ((double) (i2 / i))) + (j / ((long) i2));
        }
        long j2 = this.max;
        if (j <= j2) {
            j = j2;
        }
        this.max = j;
    }

    public final double getMedian() {
        long jLongValue;
        Long lValueOf;
        if (this.minHeap.size() == 0 && this.maxHeap.size() == 0) {
            return 0.0d;
        }
        if (this.minHeap.size() > this.maxHeap.size()) {
            lValueOf = this.minHeap.peek();
        } else {
            Long lPeek = this.minHeap.peek();
            if (lPeek != null) {
                jLongValue = lPeek.longValue();
            } else {
                Long lPeek2 = this.maxHeap.peek();
                Intrinsics.checkNotNull(lPeek2);
                jLongValue = lPeek2.longValue();
            }
            lValueOf = Long.valueOf(jLongValue / ((long) 2));
        }
        return lValueOf.longValue();
    }
}
