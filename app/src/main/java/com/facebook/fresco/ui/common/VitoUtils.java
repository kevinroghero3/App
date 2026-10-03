package com.facebook.fresco.ui.common;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes4.dex */
public final class VitoUtils {
    public static final VitoUtils INSTANCE = new VitoUtils();
    private static final AtomicLong idCounter = new AtomicLong();

    private VitoUtils() {
    }

    @JvmStatic
    public static final long generateIdentifier() {
        return idCounter.incrementAndGet();
    }

    @JvmStatic
    public static final String getStringId(long j) {
        return "v" + j;
    }
}
