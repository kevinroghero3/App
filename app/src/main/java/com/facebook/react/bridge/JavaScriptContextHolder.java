package com.facebook.react.bridge;

/* JADX INFO: loaded from: classes.dex */
public class JavaScriptContextHolder {
    private long mContext;

    public JavaScriptContextHolder(long j) {
        this.mContext = j;
    }

    public long get() {
        return this.mContext;
    }

    public void clear() {
        synchronized (this) {
            this.mContext = 0L;
        }
    }
}
