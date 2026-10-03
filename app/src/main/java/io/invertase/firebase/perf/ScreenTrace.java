package io.invertase.firebase.perf;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.util.Constants;

/* JADX INFO: loaded from: classes6.dex */
public class ScreenTrace {
    private static final String FRAME_METRICS_AGGREGATOR_CLASSNAME = "androidx.core.app.FrameMetricsAggregator";
    private static final String TAG = "RNFirebasePerf";
    private final Activity activity;
    private final FrameMetricsAggregator frameMetricsAggregator;
    private Trace perfScreenTrace;
    private final String traceName;

    private static boolean checkFrameMetricsAggregatorClass() {
        return true;
    }

    public ScreenTrace(Activity activity, String str) throws IllegalStateException {
        this.activity = activity;
        this.traceName = str;
        if (!checkScreenTraceSupport(activity)) {
            throw new IllegalStateException("Device does not support screen traces. Hardware acceleration must be enabled and Android must not be 8.0 or 8.1.");
        }
        this.frameMetricsAggregator = new FrameMetricsAggregator();
    }

    public void recordScreenTrace() {
        Log.d(TAG, "Recording screen trace " + this.traceName);
        this.frameMetricsAggregator.add(this.activity);
        this.perfScreenTrace = FirebasePerformance.startTrace(getScreenTraceName());
    }

    public void sendScreenTrace() {
        int i;
        int i2;
        SparseIntArray sparseIntArray;
        if (this.perfScreenTrace == null) {
            return;
        }
        SparseIntArray[] sparseIntArrayArrReset = this.frameMetricsAggregator.reset();
        int i3 = 0;
        if (sparseIntArrayArrReset == null || (sparseIntArray = sparseIntArrayArrReset[0]) == null) {
            i = 0;
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
            int i4 = 0;
            while (i3 < sparseIntArray.size()) {
                int iKeyAt = sparseIntArray.keyAt(i3);
                int iValueAt = sparseIntArray.valueAt(i3);
                i4 += iValueAt;
                if (iKeyAt > 700) {
                    i += iValueAt;
                }
                if (iKeyAt > 16) {
                    i2 += iValueAt;
                }
                i3++;
            }
            i3 = i4;
        }
        if (i3 > 0) {
            this.perfScreenTrace.putMetric(Constants.CounterNames.FRAMES_TOTAL.toString(), i3);
        }
        if (i2 > 0) {
            this.perfScreenTrace.putMetric(Constants.CounterNames.FRAMES_SLOW.toString(), i2);
        }
        if (i > 0) {
            this.perfScreenTrace.putMetric(Constants.CounterNames.FRAMES_FROZEN.toString(), i);
        }
        Log.d(TAG, "sendScreenTrace " + this.traceName + ", name: " + getScreenTraceName() + ", total_frames: " + i3 + ", slow_frames: " + i2 + ", frozen_frames: " + i);
        this.perfScreenTrace.stop();
    }

    private static boolean checkScreenTraceSupport(Activity activity) {
        boolean zCheckSDKVersion = checkSDKVersion();
        boolean zCheckFrameMetricsAggregatorClass = checkFrameMetricsAggregatorClass();
        boolean z = (activity.getWindow() == null || (activity.getWindow().getAttributes().flags & 16777216) == 0) ? false : true;
        boolean z2 = zCheckSDKVersion && zCheckFrameMetricsAggregatorClass && z;
        Log.d(TAG, "isValidSDKVersion: " + zCheckSDKVersion + "isScreenTraceSupported(" + activity + "): " + z2 + " [hasFrameMetricsAggregatorClass: " + zCheckFrameMetricsAggregatorClass + ", isActivityHardwareAccelerated: " + z + "]");
        return z2;
    }

    private static boolean checkSDKVersion() {
        int i = Build.VERSION.SDK_INT;
        return (i == 26 || i == 27) ? false : true;
    }

    private String getScreenTraceName() {
        return Constants.SCREEN_TRACE_PREFIX + this.traceName;
    }
}
