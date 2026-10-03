package com.facebook.systrace;

import androidx.tracing.Trace;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class Systrace {
    public static final Systrace INSTANCE = new Systrace();
    public static final long TRACE_TAG_REACT_APPS = 0;
    public static final long TRACE_TAG_REACT_FRESCO = 0;
    public static final long TRACE_TAG_REACT_JAVA_BRIDGE = 0;
    public static final long TRACE_TAG_REACT_JS_VM_CALLS = 0;
    public static final long TRACE_TAG_REACT_VIEW = 0;

    @JvmStatic
    public static final boolean isTracing(long j) {
        return false;
    }

    @JvmStatic
    public static final void registerListener(@Nullable TraceListener traceListener) {
    }

    @JvmStatic
    public static final void stepAsyncFlow(long j, @NotNull String sectionName, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
    }

    @JvmStatic
    public static final void traceInstant(long j, @Nullable String str, @Nullable EventScope eventScope) {
    }

    @JvmStatic
    public static final void unregisterListener(@Nullable TraceListener traceListener) {
    }

    private Systrace() {
    }

    @JvmStatic
    public static final void traceSection(long j, @NotNull String sectionName, @NotNull Runnable block) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Intrinsics.checkNotNullParameter(block, "block");
        beginSection(j, sectionName);
        try {
            block.run();
        } finally {
            endSection(j);
        }
    }

    @JvmStatic
    public static final void beginSection(long j, @NotNull String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.beginSection(sectionName);
    }

    @JvmStatic
    public static final void beginSection(long j, @NotNull String sectionName, @NotNull String[] args, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Intrinsics.checkNotNullParameter(args, "args");
        Trace.beginSection(sectionName + "|" + INSTANCE.convertArgsToText(args, i));
    }

    private final String convertArgsToText(String[] strArr, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 < i; i2 += 2) {
            String str = strArr[i2 - 1];
            String str2 = strArr[i2];
            sb.append(str);
            sb.append('=');
            sb.append(str2);
            if (i2 < i - 1) {
                sb.append(';');
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    public static final void endSection(long j) {
        Trace.endSection();
    }

    @JvmStatic
    public static final void beginAsyncSection(long j, @NotNull String sectionName, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.beginAsyncSection(sectionName, i);
    }

    @JvmStatic
    public static final void beginAsyncSection(long j, @NotNull String sectionName, int i, long j2) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        beginAsyncSection(j, sectionName, i);
    }

    @JvmStatic
    public static final void endAsyncSection(long j, @NotNull String sectionName, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.endAsyncSection(sectionName, i);
    }

    @JvmStatic
    public static final void endAsyncSection(long j, @NotNull String sectionName, int i, long j2) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        endAsyncSection(j, sectionName, i);
    }

    @JvmStatic
    public static final void traceCounter(long j, @NotNull String counterName, int i) {
        Intrinsics.checkNotNullParameter(counterName, "counterName");
        Trace.setCounter(counterName, i);
    }

    @JvmStatic
    public static final void startAsyncFlow(long j, @NotNull String sectionName, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        beginAsyncSection(j, sectionName, i);
    }

    @JvmStatic
    public static final void endAsyncFlow(long j, @NotNull String sectionName, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        endAsyncSection(j, sectionName, i);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public enum EventScope {
        THREAD('t'),
        PROCESS('p'),
        GLOBAL('g');

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final char code;

        public static EnumEntries<EventScope> getEntries() {
            return $ENTRIES;
        }

        EventScope(char c) {
            this.code = c;
        }

        public final char getCode() {
            return this.code;
        }
    }
}
