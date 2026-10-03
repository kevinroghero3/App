package com.facebook.react.jstasks;

import android.util.SparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.appregistry.AppRegistry;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class HeadlessJsTaskContext {
    public static final Companion Companion = new Companion(null);
    private static final WeakHashMap<ReactContext, HeadlessJsTaskContext> INSTANCES = new WeakHashMap<>();
    private final Map<Integer, HeadlessJsTaskConfig> activeTaskConfigs;
    private final Set<Integer> activeTasks;
    private final Set<HeadlessJsTaskEventListener> headlessJsTaskEventListeners;
    private final AtomicInteger lastTaskId;
    private final WeakReference<ReactContext> reactContext;
    private final SparseArray<Runnable> taskTimeouts;

    public /* synthetic */ HeadlessJsTaskContext(ReactContext reactContext, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactContext);
    }

    @JvmStatic
    public static final HeadlessJsTaskContext getInstance(@NotNull ReactContext reactContext) {
        return Companion.getInstance(reactContext);
    }

    private HeadlessJsTaskContext(ReactContext reactContext) {
        this.reactContext = new WeakReference<>(reactContext);
        this.headlessJsTaskEventListeners = new CopyOnWriteArraySet();
        this.lastTaskId = new AtomicInteger(0);
        this.activeTasks = new CopyOnWriteArraySet();
        this.activeTaskConfigs = new ConcurrentHashMap();
        this.taskTimeouts = new SparseArray<>();
    }

    public final void addTaskEventListener(@NotNull HeadlessJsTaskEventListener listener) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.headlessJsTaskEventListeners.add(listener);
            Iterator<Integer> it2 = this.activeTasks.iterator();
            while (it2.hasNext()) {
                listener.onHeadlessJsTaskStart(it2.next().intValue());
            }
        }
    }

    public final void removeTaskEventListener(@NotNull HeadlessJsTaskEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.headlessJsTaskEventListeners.remove(listener);
    }

    public final boolean hasActiveTasks() {
        return !this.activeTasks.isEmpty();
    }

    public final int startTask(@NotNull HeadlessJsTaskConfig taskConfig) {
        int iIncrementAndGet;
        synchronized (this) {
            Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
            iIncrementAndGet = this.lastTaskId.incrementAndGet();
            startTask(taskConfig, iIncrementAndGet);
        }
        return iIncrementAndGet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTask(HeadlessJsTaskConfig headlessJsTaskConfig, int i) {
        synchronized (this) {
            UiThreadUtil.assertOnUiThread();
            ReactContext reactContext = (ReactContext) Assertions.assertNotNull(this.reactContext.get(), "Tried to start a task on a react context that has already been destroyed");
            if (reactContext.getLifecycleState() == LifecycleState.RESUMED && !headlessJsTaskConfig.isAllowedInForeground()) {
                throw new IllegalStateException(("Tried to start task " + headlessJsTaskConfig.getTaskKey() + " while in foreground, but this is not allowed.").toString());
            }
            this.activeTasks.add(Integer.valueOf(i));
            this.activeTaskConfigs.put(Integer.valueOf(i), new HeadlessJsTaskConfig(headlessJsTaskConfig));
            if (reactContext.hasActiveReactInstance()) {
                ((AppRegistry) reactContext.getJSModule(AppRegistry.class)).startHeadlessTask(i, headlessJsTaskConfig.getTaskKey(), headlessJsTaskConfig.getData());
            } else {
                ReactSoftExceptionLogger.logSoftException("HeadlessJsTaskContext", new RuntimeException("Cannot start headless task, CatalystInstance not available"));
            }
            if (headlessJsTaskConfig.getTimeout() > 0) {
                scheduleTaskTimeout(i, headlessJsTaskConfig.getTimeout());
            }
            Iterator<HeadlessJsTaskEventListener> it2 = this.headlessJsTaskEventListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onHeadlessJsTaskStart(i);
            }
        }
    }

    public final boolean retryTask(final int i) {
        synchronized (this) {
            HeadlessJsTaskConfig headlessJsTaskConfig = this.activeTaskConfigs.get(Integer.valueOf(i));
            if (headlessJsTaskConfig == null) {
                throw new IllegalStateException(("Tried to retrieve non-existent task config with id " + i + ".").toString());
            }
            HeadlessJsTaskRetryPolicy retryPolicy = headlessJsTaskConfig.getRetryPolicy();
            if (retryPolicy != null && retryPolicy.canRetry()) {
                removeTimeout(i);
                final HeadlessJsTaskConfig headlessJsTaskConfig2 = new HeadlessJsTaskConfig(headlessJsTaskConfig.getTaskKey(), headlessJsTaskConfig.getData(), headlessJsTaskConfig.getTimeout(), headlessJsTaskConfig.isAllowedInForeground(), retryPolicy.update());
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.jstasks.HeadlessJsTaskContext$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.startTask(headlessJsTaskConfig2, i);
                    }
                }, retryPolicy.getDelay());
                return true;
            }
            return false;
        }
    }

    public final void finishTask(final int i) {
        synchronized (this) {
            boolean zRemove = this.activeTasks.remove(Integer.valueOf(i));
            this.activeTaskConfigs.remove(Integer.valueOf(i));
            removeTimeout(i);
            if (zRemove) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.jstasks.HeadlessJsTaskContext$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        HeadlessJsTaskContext.finishTask$lambda$4(this.f$0, i);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishTask$lambda$4(HeadlessJsTaskContext headlessJsTaskContext, int i) {
        Iterator<HeadlessJsTaskEventListener> it2 = headlessJsTaskContext.headlessJsTaskEventListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onHeadlessJsTaskFinish(i);
        }
    }

    private final void removeTimeout(int i) {
        Runnable runnable = this.taskTimeouts.get(i);
        if (runnable != null) {
            UiThreadUtil.removeOnUiThread(runnable);
            this.taskTimeouts.remove(i);
        }
    }

    public final boolean isTaskRunning(int i) {
        boolean zContains;
        synchronized (this) {
            zContains = this.activeTasks.contains(Integer.valueOf(i));
        }
        return zContains;
    }

    private final void scheduleTaskTimeout(final int i, long j) {
        Runnable runnable = new Runnable() { // from class: com.facebook.react.jstasks.HeadlessJsTaskContext$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.finishTask(i);
            }
        };
        this.taskTimeouts.append(i, runnable);
        UiThreadUtil.runOnUiThread(runnable, j);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HeadlessJsTaskContext getInstance(@NotNull ReactContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WeakHashMap weakHashMap = HeadlessJsTaskContext.INSTANCES;
            Object headlessJsTaskContext = weakHashMap.get(context);
            if (headlessJsTaskContext == null) {
                headlessJsTaskContext = new HeadlessJsTaskContext(context, null);
                weakHashMap.put(context, headlessJsTaskContext);
            }
            return (HeadlessJsTaskContext) headlessJsTaskContext;
        }
    }
}
