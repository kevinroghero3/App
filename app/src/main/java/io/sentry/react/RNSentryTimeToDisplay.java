package io.sentry.react;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.facebook.react.bridge.Promise;
import io.sentry.SentryDateProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class RNSentryTimeToDisplay {
    public static final int ENTRIES_MAX_SIZE = 50;
    private static final Map<String, Double> screenIdToRenderDuration = new LinkedHashMap<String, Double>(51, 0.75f, true) { // from class: io.sentry.react.RNSentryTimeToDisplay.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Double> entry) {
            return size() > 50;
        }
    };
    private static String activeSpanId = null;

    private RNSentryTimeToDisplay() {
    }

    public static void setActiveSpanId(@Nullable String str) {
        activeSpanId = str;
    }

    public static Double popTimeToDisplayFor(String str) {
        return screenIdToRenderDuration.remove(str);
    }

    public static void putTimeToInitialDisplayForActiveSpan(Double d) {
        if (activeSpanId != null) {
            putTimeToDisplayFor("ttid-navigation-" + activeSpanId, d);
        }
    }

    public static void putTimeToDisplayFor(String str, Double d) {
        screenIdToRenderDuration.put(str, d);
    }

    public static void getTimeToDisplay(final Promise promise, final SentryDateProvider sentryDateProvider) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            promise.reject("GetTimeToDisplay is not able to measure the time to display: Main looper not available.");
        } else {
            new Handler(mainLooper).post(new Runnable() { // from class: io.sentry.react.RNSentryTimeToDisplay$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    RNSentryTimeToDisplay.lambda$getTimeToDisplay$1(sentryDateProvider, promise);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getTimeToDisplay$1(final SentryDateProvider sentryDateProvider, final Promise promise) {
        try {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: io.sentry.react.RNSentryTimeToDisplay$$ExternalSyntheticLambda0
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    RNSentryTimeToDisplay.lambda$getTimeToDisplay$0(sentryDateProvider, promise, j);
                }
            });
        } catch (Exception e) {
            promise.reject("Failed to receive the instance of Choreographer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getTimeToDisplay$0(SentryDateProvider sentryDateProvider, Promise promise, long j) {
        promise.resolve(Double.valueOf(sentryDateProvider.now().nanoTimestamp() / 1.0E9d));
    }
}
