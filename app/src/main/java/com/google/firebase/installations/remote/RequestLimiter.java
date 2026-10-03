package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
class RequestLimiter {
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    private int attemptCount;
    private long nextRequestTime;
    private final Utils utils;

    private static boolean isRetryableError(int i) {
        return i == 429 || (i >= 500 && i < 600);
    }

    private static boolean isSuccessfulOrRequiresNewFidCreation(int i) {
        return (i >= 200 && i < 300) || i == 401 || i == 404;
    }

    RequestLimiter(Utils utils) {
        this.utils = utils;
    }

    RequestLimiter() {
        this.utils = Utils.getInstance();
    }

    public void setNextRequestTime(int i) {
        synchronized (this) {
            if (isSuccessfulOrRequiresNewFidCreation(i)) {
                resetBackoffStrategy();
                return;
            }
            this.attemptCount++;
            this.nextRequestTime = this.utils.currentTimeInMillis() + getBackoffDuration(i);
        }
    }

    private void resetBackoffStrategy() {
        synchronized (this) {
            this.attemptCount = 0;
        }
    }

    private long getBackoffDuration(int i) {
        synchronized (this) {
            if (!isRetryableError(i)) {
                return MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
            }
            return (long) Math.min(Math.pow(2.0d, this.attemptCount) + this.utils.getRandomDelayForSyncPrevention(), MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
        }
    }

    public boolean isRequestAllowed() {
        boolean z;
        synchronized (this) {
            z = this.attemptCount == 0 || this.utils.currentTimeInMillis() > this.nextRequestTime;
        }
        return z;
    }
}
