package io.sentry.android.core;

import io.sentry.EventProcessor;
import io.sentry.Hint;
import io.sentry.ISentryLifecycleToken;
import io.sentry.MeasurementUnit;
import io.sentry.SentryEvent;
import io.sentry.SpanContext;
import io.sentry.SpanDataConvention;
import io.sentry.SpanId;
import io.sentry.SpanStatus;
import io.sentry.android.core.internal.util.AndroidThreadChecker;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.protocol.App;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.SentryTransaction;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.Objects;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
final class PerformanceAndroidEventProcessor implements EventProcessor {
    private static final String APP_METRICS_ACTIVITIES_OP = "activity.load";
    private static final String APP_METRICS_APPLICATION_OP = "application.load";
    private static final String APP_METRICS_CONTENT_PROVIDER_OP = "contentprovider.load";
    private static final String APP_METRICS_ORIGIN = "auto.ui";
    private static final String APP_METRICS_PROCESS_INIT_OP = "process.load";
    private static final long MAX_PROCESS_INIT_APP_START_DIFF_MS = 10000;
    private final ActivityFramesTracker activityFramesTracker;
    private final SentryAndroidOptions options;
    private boolean sentStartMeasurement = false;
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();

    @Override // io.sentry.EventProcessor
    public SentryEvent process(@NotNull SentryEvent sentryEvent, @NotNull Hint hint) {
        return sentryEvent;
    }

    PerformanceAndroidEventProcessor(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull ActivityFramesTracker activityFramesTracker) {
        this.options = (SentryAndroidOptions) Objects.requireNonNull(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.activityFramesTracker = (ActivityFramesTracker) Objects.requireNonNull(activityFramesTracker, "ActivityFramesTracker is required");
    }

    @Override // io.sentry.EventProcessor
    public SentryTransaction process(@NotNull SentryTransaction sentryTransaction, @NotNull Hint hint) {
        Map<String, MeasurementValue> mapTakeMetrics;
        String str;
        String str2;
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (!this.options.isTracingEnabled()) {
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return sentryTransaction;
            }
            AppStartMetrics appStartMetrics = AppStartMetrics.getInstance();
            if (hasAppStartSpan(sentryTransaction)) {
                if (appStartMetrics.shouldSendStartMeasurements()) {
                    long durationMs = appStartMetrics.getAppStartTimeSpanWithFallback(this.options).getDurationMs();
                    if (durationMs != 0) {
                        MeasurementValue measurementValue = new MeasurementValue(Float.valueOf(durationMs), MeasurementUnit.Duration.MILLISECOND.apiName());
                        if (appStartMetrics.getAppStartType() == AppStartMetrics.AppStartType.COLD) {
                            str2 = MeasurementValue.KEY_APP_START_COLD;
                        } else {
                            str2 = MeasurementValue.KEY_APP_START_WARM;
                        }
                        sentryTransaction.getMeasurements().put(str2, measurementValue);
                        attachAppStartSpans(appStartMetrics, sentryTransaction);
                        appStartMetrics.onAppStartSpansSent();
                    }
                }
                App app2 = sentryTransaction.getContexts().getApp();
                if (app2 == null) {
                    app2 = new App();
                    sentryTransaction.getContexts().setApp(app2);
                }
                if (appStartMetrics.getAppStartType() == AppStartMetrics.AppStartType.COLD) {
                    str = "cold";
                } else {
                    str = "warm";
                }
                app2.setStartType(str);
            }
            setContributingFlags(sentryTransaction);
            SentryId eventId = sentryTransaction.getEventId();
            SpanContext trace = sentryTransaction.getContexts().getTrace();
            if (eventId != null && trace != null && trace.getOperation().contentEquals("ui.load") && (mapTakeMetrics = this.activityFramesTracker.takeMetrics(eventId)) != null) {
                sentryTransaction.getMeasurements().putAll(mapTakeMetrics);
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return sentryTransaction;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void setContributingFlags(SentryTransaction sentryTransaction) {
        Object obj;
        SentrySpan sentrySpan = null;
        SentrySpan sentrySpan2 = null;
        for (SentrySpan sentrySpan3 : sentryTransaction.getSpans()) {
            if ("ui.load.initial_display".equals(sentrySpan3.getOp())) {
                sentrySpan = sentrySpan3;
            } else if ("ui.load.full_display".equals(sentrySpan3.getOp())) {
                sentrySpan2 = sentrySpan3;
            }
            if (sentrySpan != null && sentrySpan2 != null) {
                break;
            }
        }
        if (sentrySpan == null && sentrySpan2 == null) {
            return;
        }
        for (SentrySpan sentrySpan4 : sentryTransaction.getSpans()) {
            if (sentrySpan4 != sentrySpan && sentrySpan4 != sentrySpan2) {
                Map<String, Object> data = sentrySpan4.getData();
                boolean z = sentrySpan != null && isTimestampWithinSpan(sentrySpan4.getStartTimestamp().doubleValue(), sentrySpan) && (data == null || (obj = data.get(SpanDataConvention.THREAD_NAME)) == null || SentryThread.JsonKeys.MAIN.equals(obj));
                boolean z2 = sentrySpan2 != null && isTimestampWithinSpan(sentrySpan4.getStartTimestamp().doubleValue(), sentrySpan2);
                if (z || z2) {
                    Map<String, Object> data2 = sentrySpan4.getData();
                    if (data2 == null) {
                        data2 = new ConcurrentHashMap<>();
                        sentrySpan4.setData(data2);
                    }
                    if (z) {
                        data2.put(SpanDataConvention.CONTRIBUTES_TTID, Boolean.TRUE);
                    }
                    if (z2) {
                        data2.put(SpanDataConvention.CONTRIBUTES_TTFD, Boolean.TRUE);
                    }
                }
            }
        }
    }

    private static boolean isTimestampWithinSpan(double d, @NotNull SentrySpan sentrySpan) {
        return d >= sentrySpan.getStartTimestamp().doubleValue() && (sentrySpan.getTimestamp() == null || d <= sentrySpan.getTimestamp().doubleValue());
    }

    private boolean hasAppStartSpan(@NotNull SentryTransaction sentryTransaction) {
        for (SentrySpan sentrySpan : sentryTransaction.getSpans()) {
            if (sentrySpan.getOp().contentEquals("app.start.cold") || sentrySpan.getOp().contentEquals("app.start.warm")) {
                return true;
            }
        }
        SpanContext trace = sentryTransaction.getContexts().getTrace();
        return trace != null && (trace.getOperation().equals("app.start.cold") || trace.getOperation().equals("app.start.warm"));
    }

    private void attachAppStartSpans(@NotNull AppStartMetrics appStartMetrics, @NotNull SentryTransaction sentryTransaction) {
        SpanContext trace;
        SpanId spanId;
        if (appStartMetrics.getAppStartType() == AppStartMetrics.AppStartType.COLD && (trace = sentryTransaction.getContexts().getTrace()) != null) {
            SentryId traceId = trace.getTraceId();
            Iterator<SentrySpan> it2 = sentryTransaction.getSpans().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    spanId = null;
                    break;
                }
                SentrySpan next = it2.next();
                if (next.getOp().contentEquals("app.start.cold")) {
                    spanId = next.getSpanId();
                    break;
                }
            }
            TimeSpan timeSpanCreateProcessInitSpan = appStartMetrics.createProcessInitSpan();
            if (timeSpanCreateProcessInitSpan.hasStarted() && Math.abs(timeSpanCreateProcessInitSpan.getDurationMs()) <= 10000) {
                sentryTransaction.getSpans().add(timeSpanToSentrySpan(timeSpanCreateProcessInitSpan, spanId, traceId, APP_METRICS_PROCESS_INIT_OP));
            }
            List<TimeSpan> contentProviderOnCreateTimeSpans = appStartMetrics.getContentProviderOnCreateTimeSpans();
            if (!contentProviderOnCreateTimeSpans.isEmpty()) {
                Iterator<TimeSpan> it3 = contentProviderOnCreateTimeSpans.iterator();
                while (it3.hasNext()) {
                    sentryTransaction.getSpans().add(timeSpanToSentrySpan(it3.next(), spanId, traceId, APP_METRICS_CONTENT_PROVIDER_OP));
                }
            }
            TimeSpan applicationOnCreateTimeSpan = appStartMetrics.getApplicationOnCreateTimeSpan();
            if (applicationOnCreateTimeSpan.hasStopped()) {
                sentryTransaction.getSpans().add(timeSpanToSentrySpan(applicationOnCreateTimeSpan, spanId, traceId, APP_METRICS_APPLICATION_OP));
            }
        }
    }

    private static SentrySpan timeSpanToSentrySpan(@NotNull TimeSpan timeSpan, @Nullable SpanId spanId, @NotNull SentryId sentryId, @NotNull String str) {
        HashMap map = new HashMap(2);
        map.put(SpanDataConvention.THREAD_ID, Long.valueOf(AndroidThreadChecker.mainThreadSystemId));
        map.put(SpanDataConvention.THREAD_NAME, SentryThread.JsonKeys.MAIN);
        Boolean bool = Boolean.TRUE;
        map.put(SpanDataConvention.CONTRIBUTES_TTID, bool);
        map.put(SpanDataConvention.CONTRIBUTES_TTFD, bool);
        double startTimestampSecs = timeSpan.getStartTimestampSecs();
        double projectedStopTimestampSecs = timeSpan.getProjectedStopTimestampSecs();
        return new SentrySpan(Double.valueOf(startTimestampSecs), Double.valueOf(projectedStopTimestampSecs), sentryId, new SpanId(), spanId, str, timeSpan.getDescription(), SpanStatus.OK, APP_METRICS_ORIGIN, new ConcurrentHashMap(), new ConcurrentHashMap(), map);
    }

    @Override // io.sentry.EventProcessor
    public Long getOrder() {
        return 9000L;
    }
}
