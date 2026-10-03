package io.invertase.firebase.perf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import io.invertase.firebase.common.UniversalFirebaseModule;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class UniversalFirebasePerfModule extends UniversalFirebaseModule {
    private static SparseArray<Trace> traces = new SparseArray<>();
    private static SparseArray<ScreenTrace> screenTraces = new SparseArray<>();
    private static SparseArray<HttpMetric> httpMetrics = new SparseArray<>();

    UniversalFirebasePerfModule(Context context, String str) {
        super(context, str);
    }

    @Override // io.invertase.firebase.common.UniversalFirebaseModule
    public void onTearDown() {
        super.onTearDown();
        traces.clear();
        httpMetrics.clear();
        screenTraces.clear();
    }

    @Override // io.invertase.firebase.common.UniversalFirebaseModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("isPerformanceCollectionEnabled", Boolean.valueOf(FirebasePerformance.getInstance().isPerformanceCollectionEnabled()));
        map.put("isInstrumentationEnabled", Boolean.TRUE);
        return map;
    }

    Task<Boolean> setPerformanceCollectionEnabled(final Boolean bool) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.perf.UniversalFirebasePerfModule$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebasePerfModule.lambda$setPerformanceCollectionEnabled$0(bool);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$setPerformanceCollectionEnabled$0(Boolean bool) throws Exception {
        FirebasePerformance.getInstance().setPerformanceCollectionEnabled(bool);
        return bool;
    }

    Task<Void> startTrace(final int i, final String str) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.perf.UniversalFirebasePerfModule$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebasePerfModule.lambda$startTrace$1(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$startTrace$1(String str, int i) throws Exception {
        Trace traceNewTrace = FirebasePerformance.getInstance().newTrace(str);
        traceNewTrace.start();
        traces.put(i, traceNewTrace);
        return null;
    }

    Task<Void> stopTrace(final int i, final Bundle bundle, final Bundle bundle2) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.perf.UniversalFirebasePerfModule$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebasePerfModule.lambda$stopTrace$2(i, bundle, bundle2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$stopTrace$2(int i, Bundle bundle, Bundle bundle2) throws Exception {
        Trace trace = traces.get(i);
        Set<String> setKeySet = bundle.keySet();
        Set<String> setKeySet2 = bundle2.keySet();
        for (String str : setKeySet) {
            Double d = (Double) bundle.get(str);
            d.doubleValue();
            trace.putMetric(str, d.intValue());
        }
        for (String str2 : setKeySet2) {
            Object obj = bundle2.get(str2);
            Objects.requireNonNull(obj);
            trace.putAttribute(str2, (String) obj);
        }
        trace.stop();
        traces.remove(i);
        return null;
    }

    Task<Void> startScreenTrace(final Activity activity, final int i, final String str) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.perf.UniversalFirebasePerfModule$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebasePerfModule.lambda$startScreenTrace$3(activity, str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$startScreenTrace$3(Activity activity, String str, int i) throws Exception {
        ScreenTrace screenTrace = new ScreenTrace(activity, str);
        screenTrace.recordScreenTrace();
        screenTraces.put(i, screenTrace);
        return null;
    }

    Task<Void> stopScreenTrace(final int i) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.perf.UniversalFirebasePerfModule$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebasePerfModule.lambda$stopScreenTrace$4(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$stopScreenTrace$4(int i) throws Exception {
        screenTraces.get(i).sendScreenTrace();
        screenTraces.remove(i);
        return null;
    }

    Task<Void> startHttpMetric(final int i, final String str, final String str2) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.perf.UniversalFirebasePerfModule$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebasePerfModule.lambda$startHttpMetric$5(str, str2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$startHttpMetric$5(String str, String str2, int i) throws Exception {
        HttpMetric httpMetricNewHttpMetric = FirebasePerformance.getInstance().newHttpMetric(str, str2);
        httpMetricNewHttpMetric.start();
        httpMetrics.put(i, httpMetricNewHttpMetric);
        return null;
    }

    Task<Void> stopHttpMetric(final int i, final Bundle bundle, final Bundle bundle2) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.perf.UniversalFirebasePerfModule$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebasePerfModule.lambda$stopHttpMetric$6(i, bundle, bundle2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$stopHttpMetric$6(int i, Bundle bundle, Bundle bundle2) throws Exception {
        HttpMetric httpMetric = httpMetrics.get(i);
        if (bundle.containsKey("httpResponseCode")) {
            httpMetric.setHttpResponseCode((int) bundle.getDouble("httpResponseCode"));
        }
        if (bundle.containsKey("requestPayloadSize")) {
            httpMetric.setRequestPayloadSize((int) bundle.getDouble("requestPayloadSize"));
        }
        if (bundle.containsKey("responsePayloadSize")) {
            httpMetric.setResponsePayloadSize((int) bundle.getDouble("responsePayloadSize"));
        }
        if (bundle.containsKey("responseContentType")) {
            httpMetric.setResponseContentType(bundle.getString("responseContentType"));
        }
        for (String str : bundle2.keySet()) {
            String string = bundle2.getString(str);
            Objects.requireNonNull(string);
            httpMetric.putAttribute(str, string);
        }
        httpMetric.stop();
        httpMetrics.remove(i);
        return null;
    }
}
