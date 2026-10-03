package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes6.dex */
public class TimedSemaphore {
    public static final int NO_LIMIT = 0;
    private static final int THREAD_POOL_SIZE = 1;
    private int acquireCount;
    private final ScheduledExecutorService executorService;
    private int lastCallsPerPeriod;
    private int limit;
    private final boolean ownExecutor;
    private final long period;
    private long periodCount;
    private boolean shutdown;
    private ScheduledFuture<?> task;
    private long totalAcquireCount;
    private final TimeUnit unit;

    public TimedSemaphore(long j, TimeUnit timeUnit, int i) {
        this(null, j, timeUnit, i);
    }

    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long j, TimeUnit timeUnit, int i) {
        Validate.inclusiveBetween(1L, Long.MAX_VALUE, j, "Time period must be greater than 0!");
        this.period = j;
        this.unit = timeUnit;
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            this.ownExecutor = false;
        } else {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.executorService = scheduledThreadPoolExecutor;
            this.ownExecutor = true;
        }
        setLimit(i);
    }

    public final int getLimit() {
        int i;
        synchronized (this) {
            i = this.limit;
        }
        return i;
    }

    public final void setLimit(int i) {
        synchronized (this) {
            this.limit = i;
        }
    }

    public void shutdown() {
        synchronized (this) {
            if (!this.shutdown) {
                if (this.ownExecutor) {
                    getExecutorService().shutdownNow();
                }
                ScheduledFuture<?> scheduledFuture = this.task;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.shutdown = true;
            }
        }
    }

    public boolean isShutdown() {
        boolean z;
        synchronized (this) {
            z = this.shutdown;
        }
        return z;
    }

    public void acquire() throws InterruptedException {
        boolean zAcquirePermit;
        synchronized (this) {
            prepareAcquire();
            do {
                zAcquirePermit = acquirePermit();
                if (!zAcquirePermit) {
                    wait();
                }
            } while (!zAcquirePermit);
        }
    }

    public boolean tryAcquire() {
        boolean zAcquirePermit;
        synchronized (this) {
            prepareAcquire();
            zAcquirePermit = acquirePermit();
        }
        return zAcquirePermit;
    }

    public int getLastAcquiresPerPeriod() {
        int i;
        synchronized (this) {
            i = this.lastCallsPerPeriod;
        }
        return i;
    }

    public int getAcquireCount() {
        int i;
        synchronized (this) {
            i = this.acquireCount;
        }
        return i;
    }

    public int getAvailablePermits() {
        int limit;
        int acquireCount;
        synchronized (this) {
            limit = getLimit();
            acquireCount = getAcquireCount();
        }
        return limit - acquireCount;
    }

    public double getAverageCallsPerPeriod() {
        double d;
        synchronized (this) {
            long j = this.periodCount;
            d = j == 0 ? 0.0d : this.totalAcquireCount / j;
        }
        return d;
    }

    public long getPeriod() {
        return this.period;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    protected ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    protected ScheduledFuture<?> startTimer() {
        return getExecutorService().scheduleAtFixedRate(new Runnable() { // from class: org.apache.commons.lang3.concurrent.TimedSemaphore.1
            @Override // java.lang.Runnable
            public void run() {
                TimedSemaphore.this.endOfPeriod();
            }
        }, getPeriod(), getPeriod(), getUnit());
    }

    void endOfPeriod() {
        synchronized (this) {
            int i = this.acquireCount;
            this.lastCallsPerPeriod = i;
            this.totalAcquireCount += (long) i;
            this.periodCount++;
            this.acquireCount = 0;
            notifyAll();
        }
    }

    private void prepareAcquire() {
        if (isShutdown()) {
            throw new IllegalStateException("TimedSemaphore is shut down!");
        }
        if (this.task == null) {
            this.task = startTimer();
        }
    }

    private boolean acquirePermit() {
        if (getLimit() > 0 && this.acquireCount >= getLimit()) {
            return false;
        }
        this.acquireCount++;
        return true;
    }
}
