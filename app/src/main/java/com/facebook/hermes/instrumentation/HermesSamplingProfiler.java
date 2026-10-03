package com.facebook.hermes.instrumentation;

import com.facebook.soloader.SoLoader;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class HermesSamplingProfiler {
    public static final HermesSamplingProfiler INSTANCE = new HermesSamplingProfiler();

    @JvmStatic
    public static final native void disable();

    @JvmStatic
    public static final native void dumpSampledTraceToFile(@NotNull String str);

    @JvmStatic
    public static final native void enable();

    private HermesSamplingProfiler() {
    }

    static {
        SoLoader.loadLibrary("jsijniprofiler");
    }
}
