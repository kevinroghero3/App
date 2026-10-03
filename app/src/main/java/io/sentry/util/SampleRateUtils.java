package io.sentry.util;

import io.sentry.TracesSamplingDecision;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SampleRateUtils {
    public static boolean isValidSampleRate(@Nullable Double d) {
        return isValidRate(d, true);
    }

    public static boolean isValidTracesSampleRate(@Nullable Double d) {
        return isValidTracesSampleRate(d, true);
    }

    public static boolean isValidTracesSampleRate(@Nullable Double d, boolean z) {
        return isValidRate(d, z);
    }

    public static boolean isValidProfilesSampleRate(@Nullable Double d) {
        return isValidRate(d, true);
    }

    public static boolean isValidContinuousProfilesSampleRate(@Nullable Double d) {
        return isValidRate(d, true);
    }

    public static Double backfilledSampleRand(@Nullable Double d, @Nullable Double d2, @Nullable Boolean bool) {
        if (d != null) {
            return d;
        }
        double dNextDouble = SentryRandom.current().nextDouble();
        if (d2 != null && bool != null) {
            if (bool.booleanValue()) {
                return Double.valueOf(dNextDouble * d2.doubleValue());
            }
            return Double.valueOf(d2.doubleValue() + (dNextDouble * (1.0d - d2.doubleValue())));
        }
        return Double.valueOf(dNextDouble);
    }

    public static TracesSamplingDecision backfilledSampleRand(@NotNull TracesSamplingDecision tracesSamplingDecision) {
        if (tracesSamplingDecision.getSampleRand() != null) {
            return tracesSamplingDecision;
        }
        return new TracesSamplingDecision(tracesSamplingDecision.getSampled(), tracesSamplingDecision.getSampleRate(), backfilledSampleRand(null, tracesSamplingDecision.getSampleRate(), tracesSamplingDecision.getSampled()), tracesSamplingDecision.getProfileSampled(), tracesSamplingDecision.getProfileSampleRate());
    }

    private static boolean isValidRate(@Nullable Double d, boolean z) {
        if (d == null) {
            return z;
        }
        return !d.isNaN() && d.doubleValue() >= 0.0d && d.doubleValue() <= 1.0d;
    }
}
