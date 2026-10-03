package com.facebook.appevents.gps.topics;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.os.OutcomeReceiver;
import androidx.core.os.OutcomeReceiverKt$$ExternalSyntheticApiModelOutline0;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class GpsTopicsManager {
    public static final GpsTopicsManager INSTANCE = new GpsTopicsManager();
    private static final boolean RECORD_OBSERVATION = true;
    private static final String TAG;
    private static final Lazy executor$delegate;
    private static final AtomicBoolean isTopicsObservationEnabled;

    private GpsTopicsManager() {
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
            return null;
        }
    }

    public static final /* synthetic */ List access$processObservedTopics(GpsTopicsManager gpsTopicsManager, GetTopicsResponse getTopicsResponse) {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return null;
        }
        try {
            return gpsTopicsManager.processObservedTopics(getTopicsResponse);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
            return null;
        }
    }

    static {
        String string = GpsTopicsManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(string, "GpsTopicsManager::class.java.toString()");
        TAG = string;
        executor$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ExecutorService>() { // from class: com.facebook.appevents.gps.topics.GpsTopicsManager$executor$2
            @Override // kotlin.jvm.functions.Function0
            public final ExecutorService invoke() {
                return Executors.newCachedThreadPool();
            }
        });
        isTopicsObservationEnabled = new AtomicBoolean(false);
    }

    private final Executor getExecutor() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object value = executor$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-executor>(...)");
            return (Executor) value;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final void enableTopicsObservation() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return;
        }
        try {
            isTopicsObservationEnabled.set(true);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
        }
    }

    @JvmStatic
    public static final CompletableFuture<List<TopicData>> getTopics() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return null;
        }
        try {
            if (!shouldObserveTopics()) {
                CompletableFuture<List<TopicData>> completableFutureCompletedFuture = CompletableFuture.completedFuture(CollectionsKt__CollectionsKt.emptyList());
                Intrinsics.checkNotNullExpressionValue(completableFutureCompletedFuture, "completedFuture(emptyList())");
                return completableFutureCompletedFuture;
            }
            final CompletableFuture<List<TopicData>> completableFuture = new CompletableFuture<>();
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                OutcomeReceiver outcomeReceiverM = OutcomeReceiverKt$$ExternalSyntheticApiModelOutline0.m(new OutcomeReceiver() { // from class: com.facebook.appevents.gps.topics.GpsTopicsManager$getTopics$callback$1
                    public void onResult(@NotNull GetTopicsResponse response) {
                        Intrinsics.checkNotNullParameter(response, "response");
                        try {
                            completableFuture.complete(GpsTopicsManager.access$processObservedTopics(GpsTopicsManager.INSTANCE, response));
                        } catch (Throwable th) {
                            SentryLogcatAdapter.w(GpsTopicsManager.access$getTAG$p(), "GPS_TOPICS_PROCESSING_FAILURE", th);
                            completableFuture.completeExceptionally(th);
                        }
                    }

                    public void onError(@NotNull Exception error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        SentryLogcatAdapter.w(GpsTopicsManager.access$getTAG$p(), "GPS_TOPICS_OBSERVATION_FAILURE", error);
                        completableFuture.completeExceptionally(error);
                    }
                });
                GetTopicsRequest.Builder builder = new GetTopicsRequest.Builder();
                builder.setShouldRecordObservation(true);
                builder.setAdsSdkName(applicationContext.getPackageName());
                TopicsManager topicsManager = (TopicsManager) applicationContext.getSystemService(TopicsManager.class);
                if (topicsManager != null) {
                    topicsManager.getTopics(builder.build(), INSTANCE.getExecutor(), outcomeReceiverM);
                }
            } catch (Throwable th) {
                SentryLogcatAdapter.w(TAG, "GPS_TOPICS_OBSERVATION_FAILURE", th);
                completableFuture.completeExceptionally(th);
            }
            return completableFuture;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, GpsTopicsManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean shouldObserveTopics() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return false;
        }
        try {
            return isTopicsObservationEnabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
            return false;
        }
    }

    private final List<TopicData> processObservedTopics(GetTopicsResponse getTopicsResponse) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List<Topic> topics = getTopicsResponse.getTopics();
            Intrinsics.checkNotNullExpressionValue(topics, "response.topics");
            List<Topic> list = topics;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (Topic topic : list) {
                arrayList.add(new TopicData(topic.getTaxonomyVersion(), topic.getModelVersion(), topic.getTopicId()));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
