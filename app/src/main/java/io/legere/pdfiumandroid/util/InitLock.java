package io.legere.pdfiumandroid.util;

import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
public final class InitLock {
    private boolean isInitialized;
    private final Semaphore semaphore = new Semaphore(0);

    public final void markReady() {
        this.isInitialized = true;
        this.semaphore.release();
    }

    public final void waitForReady() {
        synchronized (this) {
            if (!this.isInitialized) {
                this.semaphore.acquire();
            }
        }
    }
}
