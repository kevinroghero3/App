package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
final class TopicsStore {
    private static final String DIVIDER_QUEUE_OPERATIONS = ",";
    static final String KEY_TOPIC_OPERATIONS_QUEUE = "topic_operation_queue";
    static final String PREFERENCES = "com.google.android.gms.appid";
    private static WeakReference<TopicsStore> topicsStoreWeakReference;
    private final SharedPreferences sharedPreferences;
    private final Executor syncExecutor;
    private SharedPreferencesQueue topicOperationsQueue;

    private TopicsStore(SharedPreferences sharedPreferences, Executor executor) {
        this.syncExecutor = executor;
        this.sharedPreferences = sharedPreferences;
    }

    private void initStore() {
        synchronized (this) {
            this.topicOperationsQueue = SharedPreferencesQueue.createInstance(this.sharedPreferences, KEY_TOPIC_OPERATIONS_QUEUE, DIVIDER_QUEUE_OPERATIONS, this.syncExecutor);
        }
    }

    public static TopicsStore getInstance(Context context, Executor executor) {
        TopicsStore topicsStore;
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
            topicsStore = weakReference != null ? weakReference.get() : null;
            if (topicsStore == null) {
                topicsStore = new TopicsStore(context.getSharedPreferences(PREFERENCES, 0), executor);
                topicsStore.initStore();
                topicsStoreWeakReference = new WeakReference<>(topicsStore);
            }
        }
        return topicsStore;
    }

    static void clearCaches() {
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
            if (weakReference != null) {
                weakReference.clear();
            }
        }
    }

    TopicOperation getNextTopicOperation() {
        TopicOperation topicOperationFrom;
        synchronized (this) {
            topicOperationFrom = TopicOperation.from(this.topicOperationsQueue.peek());
        }
        return topicOperationFrom;
    }

    boolean addTopicOperation(TopicOperation topicOperation) {
        boolean zAdd;
        synchronized (this) {
            zAdd = this.topicOperationsQueue.add(topicOperation.serialize());
        }
        return zAdd;
    }

    boolean removeTopicOperation(TopicOperation topicOperation) {
        boolean zRemove;
        synchronized (this) {
            zRemove = this.topicOperationsQueue.remove(topicOperation.serialize());
        }
        return zRemove;
    }

    TopicOperation pollTopicOperation() {
        TopicOperation topicOperationFrom;
        synchronized (this) {
            try {
                topicOperationFrom = TopicOperation.from(this.topicOperationsQueue.remove());
            } catch (NoSuchElementException unused) {
                SentryLogcatAdapter.e(Constants.TAG, "Polling operation queue failed");
                return null;
            }
        }
        return topicOperationFrom;
    }

    List<TopicOperation> getOperations() {
        ArrayList arrayList;
        synchronized (this) {
            List<String> list = this.topicOperationsQueue.toList();
            arrayList = new ArrayList(list.size());
            Iterator<String> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(TopicOperation.from(it2.next()));
            }
        }
        return arrayList;
    }

    void clearTopicOperations() {
        synchronized (this) {
            this.topicOperationsQueue.clear();
        }
    }
}
