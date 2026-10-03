package com.google.firebase.perf;

import com.google.firebase.Firebase;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class PerformanceKt {
    public static final FirebasePerformance getPerformance(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebasePerformance firebasePerformance = FirebasePerformance.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebasePerformance, "getInstance()");
        return firebasePerformance;
    }

    public static final void trace(@NotNull HttpMetric httpMetric, @NotNull Function1<? super HttpMetric, Unit> block) {
        Intrinsics.checkNotNullParameter(httpMetric, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        httpMetric.start();
        try {
            block.invoke(httpMetric);
        } finally {
            InlineMarker.finallyStart(1);
            httpMetric.stop();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <T> T trace(@NotNull Trace trace, @NotNull Function1<? super Trace, ? extends T> block) {
        Intrinsics.checkNotNullParameter(trace, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        trace.start();
        try {
            return block.invoke(trace);
        } finally {
            InlineMarker.finallyStart(1);
            trace.stop();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <T> T trace(@NotNull String name, @NotNull Function1<? super Trace, ? extends T> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        Trace traceCreate = Trace.create(name);
        Intrinsics.checkNotNullExpressionValue(traceCreate, "create(name)");
        traceCreate.start();
        try {
            return block.invoke(traceCreate);
        } finally {
            InlineMarker.finallyStart(1);
            traceCreate.stop();
            InlineMarker.finallyEnd(1);
        }
    }
}
