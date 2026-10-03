package com.facebook.react.common;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public final class SystemClock {
    public static final SystemClock INSTANCE = new SystemClock();

    private SystemClock() {
    }

    @JvmStatic
    public static final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @JvmStatic
    public static final long nanoTime() {
        return System.nanoTime();
    }

    @JvmStatic
    public static final long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }
}
