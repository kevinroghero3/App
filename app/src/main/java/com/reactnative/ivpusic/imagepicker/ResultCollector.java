package com.reactnative.ivpusic.imagepicker;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
class ResultCollector {
    private WritableArray arrayResult;
    private boolean multiple;
    private Promise promise;
    private boolean resultSent;
    private int waitCount;
    private AtomicInteger waitCounter;

    ResultCollector() {
    }

    void setup(Promise promise, boolean z) {
        synchronized (this) {
            this.promise = promise;
            this.multiple = z;
            this.resultSent = false;
            this.waitCount = 0;
            this.waitCounter = new AtomicInteger(0);
            if (z) {
                this.arrayResult = new WritableNativeArray();
            }
        }
    }

    void setWaitCount(int i) {
        synchronized (this) {
            this.waitCount = i;
            this.waitCounter = new AtomicInteger(0);
        }
    }

    private boolean isRequestValid() {
        synchronized (this) {
            if (this.resultSent) {
                SentryLogcatAdapter.w("image-crop-picker", "Skipping result, already sent...");
                return false;
            }
            if (this.promise != null) {
                return true;
            }
            SentryLogcatAdapter.w("image-crop-picker", "Trying to notify success but promise is not set");
            return false;
        }
    }

    void notifySuccess(WritableMap writableMap) {
        synchronized (this) {
            if (isRequestValid()) {
                if (this.multiple) {
                    this.arrayResult.pushMap(writableMap);
                    if (this.waitCounter.addAndGet(1) == this.waitCount) {
                        this.promise.resolve(this.arrayResult);
                        this.resultSent = true;
                    }
                } else {
                    this.promise.resolve(writableMap);
                    this.resultSent = true;
                }
            }
        }
    }

    void notifyProblem(String str, String str2) {
        synchronized (this) {
            if (isRequestValid()) {
                SentryLogcatAdapter.e("image-crop-picker", "Promise rejected. " + str2);
                this.promise.reject(str, str2);
                this.resultSent = true;
            }
        }
    }

    void notifyProblem(String str, Throwable th) {
        synchronized (this) {
            if (isRequestValid()) {
                SentryLogcatAdapter.e("image-crop-picker", "Promise rejected. " + th.getMessage());
                this.promise.reject(str, th);
                this.resultSent = true;
            }
        }
    }
}
