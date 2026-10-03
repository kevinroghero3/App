package com.facebook.react.jstasks;

/* JADX INFO: loaded from: classes4.dex */
public final class LinearCountingRetryPolicy implements HeadlessJsTaskRetryPolicy {
    private final int delay;
    private final int delayBetweenAttemptsInMs;
    private final int retryAttempts;

    public LinearCountingRetryPolicy(int i, int i2) {
        this.retryAttempts = i;
        this.delayBetweenAttemptsInMs = i2;
        this.delay = i2;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public boolean canRetry() {
        return this.retryAttempts > 0;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public int getDelay() {
        return this.delay;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public HeadlessJsTaskRetryPolicy update() {
        int i = this.retryAttempts - 1;
        if (i > 0) {
            return new LinearCountingRetryPolicy(i, this.delayBetweenAttemptsInMs);
        }
        return NoRetryPolicy.INSTANCE;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public HeadlessJsTaskRetryPolicy copy() {
        return new LinearCountingRetryPolicy(this.retryAttempts, this.delayBetweenAttemptsInMs);
    }
}
