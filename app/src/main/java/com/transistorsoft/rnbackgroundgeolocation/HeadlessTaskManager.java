package com.transistorsoft.rnbackgroundgeolocation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class HeadlessTaskManager implements HeadlessJsTaskEventListener {
    private static final String TAG = "TSLocationManager";
    private static HeadlessTaskManager sInstance;
    private final Set<Task> mTaskQueue = new CopyOnWriteArraySet();
    private final AtomicBoolean mIsReactContextInitialized = new AtomicBoolean(false);
    private final AtomicBoolean mWillDrainTaskQueue = new AtomicBoolean(false);
    private final AtomicBoolean mIsInitializingReactContext = new AtomicBoolean(false);
    private final AtomicBoolean mIsHeadlessJsTaskListenerRegistered = new AtomicBoolean(false);

    /* JADX INFO: loaded from: classes6.dex */
    public interface OnErrorCallback {
        void onError(Task task, Exception exc);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface OnFinishCallback {
        void onFinish(int i);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface OnInvokeCallback {
        void onInvoke(ReactContext reactContext, Task task);
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskStart(int i) {
    }

    public static HeadlessTaskManager getInstance() {
        if (sInstance == null) {
            sInstance = getInstanceSynchronized();
        }
        return sInstance;
    }

    private static HeadlessTaskManager getInstanceSynchronized() {
        HeadlessTaskManager headlessTaskManager;
        synchronized (HeadlessTaskManager.class) {
            if (sInstance == null) {
                sInstance = new HeadlessTaskManager();
            }
            headlessTaskManager = sInstance;
        }
        return headlessTaskManager;
    }

    public void startTask(Context context, Task task) throws AssertionError {
        UiThreadUtil.assertOnUiThread();
        addTask(task);
        if (!this.mIsReactContextInitialized.get()) {
            createReactContextAndScheduleTask(context);
        } else {
            if (invokeStartTask(getReactContext(context), task)) {
                return;
            }
            removeTask(task);
        }
    }

    public void finishTask(Context context, int i) throws TaskNotFoundError, ContextError {
        if (!this.mIsReactContextInitialized.get()) {
            throw new ContextError(getClass().getName() + ".finishTask:  ReactContext not initialized");
        }
        ReactContext reactContext = getReactContext(context.getApplicationContext());
        if (reactContext != null) {
            Task taskFindTask = findTask(i);
            if (taskFindTask != null) {
                HeadlessJsTaskContext headlessJsTaskContext = HeadlessJsTaskContext.getInstance(reactContext);
                if (headlessJsTaskContext.isTaskRunning(taskFindTask.getReactTaskId())) {
                    headlessJsTaskContext.finishTask(taskFindTask.getReactTaskId());
                    return;
                }
                return;
            }
            throw new TaskNotFoundError(i);
        }
        throw new ContextError(getClass().getName() + ".finishTask ReactContext is null");
    }

    private boolean invokeStartTask(ReactContext reactContext, Task task) {
        HeadlessJsTaskContext headlessJsTaskContext = HeadlessJsTaskContext.getInstance(reactContext);
        if (this.mIsHeadlessJsTaskListenerRegistered.compareAndSet(false, true)) {
            headlessJsTaskContext.addTaskEventListener(this);
        }
        try {
            return task.invoke(reactContext);
        } catch (Exception e) {
            task.onError(e);
            return false;
        }
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskFinish(int i) {
        Task taskFindTaskByReactId = findTaskByReactId(i);
        if (taskFindTaskByReactId == null) {
            return;
        }
        removeTask(taskFindTaskByReactId);
        taskFindTaskByReactId.onFinish();
        TSLog.logger.debug("[onHeadlessJsTaskFinish] taskId: " + i);
    }

    private ReactNativeHost getReactNativeHost(Context context) {
        return ((ReactApplication) context.getApplicationContext()).getReactNativeHost();
    }

    private Object getReactHost(Context context) {
        Context applicationContext = context.getApplicationContext();
        try {
            return applicationContext.getClass().getMethod("getReactHost", null).invoke(applicationContext, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private ReactContext getReactContext(Context context) {
        if (isBridglessArchitectureEnabled()) {
            Object reactHost = getReactHost(context);
            Assertions.assertNotNull(reactHost, "getReactHost() is null in New Architecture");
            try {
                return (ReactContext) reactHost.getClass().getMethod("getCurrentReactContext", null).invoke(reactHost, null);
            } catch (Exception e) {
                TSLog.logger.error(TSLog.error("Reflection error getCurrentReactContext: " + e.getMessage()), (Throwable) e);
            }
        }
        return getReactNativeHost(context).getReactInstanceManager().getCurrentReactContext();
    }

    private void createReactContextAndScheduleTask(Context context) {
        ReactContext reactContext = getReactContext(context);
        if (reactContext != null && !this.mIsInitializingReactContext.get()) {
            this.mIsReactContextInitialized.set(true);
            drainTaskQueue(reactContext);
            return;
        }
        if (this.mIsInitializingReactContext.compareAndSet(false, true)) {
            TSLog.logger.debug("[createReactContextAndScheduleTask] initialize ReactContext");
            final Object reactHost = getReactHost(context);
            if (isBridglessArchitectureEnabled()) {
                try {
                    reactHost.getClass().getMethod("addReactInstanceEventListener", ReactInstanceEventListener.class).invoke(reactHost, new ReactInstanceEventListener() { // from class: com.transistorsoft.rnbackgroundgeolocation.HeadlessTaskManager.1
                        @Override // com.facebook.react.ReactInstanceEventListener
                        public void onReactContextInitialized(@NonNull ReactContext reactContext2) {
                            HeadlessTaskManager.this.mIsReactContextInitialized.set(true);
                            HeadlessTaskManager.this.drainTaskQueue(reactContext2);
                            try {
                                reactHost.getClass().getMethod("removeReactInstanceEventListener", ReactInstanceEventListener.class).invoke(reactHost, this);
                            } catch (Exception e) {
                                TSLog.logger.error(TSLog.error("HeadlessTask reflection error removeReactInstanceEventListener: ") + e);
                            }
                        }
                    });
                    reactHost.getClass().getMethod("start", null).invoke(reactHost, null);
                    return;
                } catch (Exception e) {
                    TSLog.logger.error(TSLog.error("HeadlessTask reflection error ReactHost start: " + e.getMessage()), (Throwable) e);
                    return;
                }
            }
            final ReactInstanceManager reactInstanceManager = getReactNativeHost(context).getReactInstanceManager();
            reactInstanceManager.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: com.transistorsoft.rnbackgroundgeolocation.HeadlessTaskManager.2
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(@NonNull ReactContext reactContext2) {
                    HeadlessTaskManager.this.mIsReactContextInitialized.set(true);
                    HeadlessTaskManager.this.drainTaskQueue(reactContext2);
                    reactInstanceManager.removeReactInstanceEventListener(this);
                }
            });
            reactInstanceManager.createReactContextInBackground();
        }
    }

    private boolean isBridglessArchitectureEnabled() {
        try {
            return Class.forName("com.facebook.react.defaults.DefaultNewArchitectureEntryPoint").getMethod("getBridgelessEnabled", null).invoke(null, null) == Boolean.TRUE;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drainTaskQueue(final ReactContext reactContext) {
        if (this.mWillDrainTaskQueue.compareAndSet(false, true)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transistorsoft.rnbackgroundgeolocation.HeadlessTaskManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$drainTaskQueue$1(reactContext);
                }
            }, 250L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$drainTaskQueue$1(final ReactContext reactContext) {
        synchronized (this.mTaskQueue) {
            this.mTaskQueue.forEach(new Consumer() { // from class: com.transistorsoft.rnbackgroundgeolocation.HeadlessTaskManager$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$drainTaskQueue$0(reactContext, (HeadlessTaskManager.Task) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$drainTaskQueue$0(ReactContext reactContext, Task task) {
        if (invokeStartTask(reactContext, task)) {
            return;
        }
        removeTask(task);
    }

    public Task findTask(int i) {
        Task next;
        synchronized (this.mTaskQueue) {
            Iterator<Task> it2 = this.mTaskQueue.iterator();
            while (it2.hasNext()) {
                next = it2.next();
                if (next.getId() == i) {
                }
            }
            next = null;
        }
        return next;
    }

    private Task findTaskByReactId(int i) {
        Task next;
        synchronized (this.mTaskQueue) {
            Iterator<Task> it2 = this.mTaskQueue.iterator();
            while (it2.hasNext()) {
                next = it2.next();
                if (next.getReactTaskId() == i) {
                }
            }
            next = null;
        }
        return next;
    }

    private void addTask(Task task) {
        synchronized (this.mTaskQueue) {
            this.mTaskQueue.add(task);
        }
    }

    private void removeTask(Task task) {
        synchronized (this.mTaskQueue) {
            this.mTaskQueue.remove(task);
        }
    }

    private boolean hasTasks() {
        boolean zIsEmpty;
        synchronized (this.mTaskQueue) {
            zIsEmpty = this.mTaskQueue.isEmpty();
        }
        return !zIsEmpty;
    }

    public static class Task {
        private static final AtomicInteger sLastTaskId = new AtomicInteger(0);
        private final int mId;
        private final OnErrorCallback mOnErrorCallback;
        private final OnFinishCallback mOnFinishCallback;
        private final OnInvokeCallback mOnInvokeCallback;
        private final WritableMap mParams;
        private int mReactTaskId;
        private final String mTaskName;
        private final int mTimeout;

        static int getNextTaskId() {
            int iIncrementAndGet;
            synchronized (Task.class) {
                iIncrementAndGet = sLastTaskId.incrementAndGet();
            }
            return iIncrementAndGet;
        }

        Task(Builder builder) {
            this.mTaskName = builder.name;
            int nextTaskId = getNextTaskId();
            this.mId = nextTaskId;
            this.mOnInvokeCallback = builder.onInvokeCallback;
            this.mOnFinishCallback = builder.onFinishCallback;
            this.mOnErrorCallback = builder.onErrorCallback;
            this.mTimeout = builder.timeout;
            WritableMap writableMap = builder.params;
            this.mParams = writableMap;
            writableMap.putInt("_transistorHeadlessTaskId", nextTaskId);
        }

        boolean invoke(ReactContext reactContext) throws IllegalStateException {
            if (this.mReactTaskId > 0) {
                TSLog.logger.warn(TSLog.warn("Task already invoked <IGNORED>: " + this));
                return true;
            }
            this.mReactTaskId = HeadlessJsTaskContext.getInstance(reactContext).startTask(buildTaskConfig());
            OnInvokeCallback onInvokeCallback = this.mOnInvokeCallback;
            if (onInvokeCallback != null) {
                onInvokeCallback.onInvoke(reactContext, this);
            }
            return true;
        }

        public int getId() {
            return this.mId;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getReactTaskId() {
            return this.mReactTaskId;
        }

        private HeadlessJsTaskConfig buildTaskConfig() {
            return new HeadlessJsTaskConfig(this.mTaskName, this.mParams, this.mTimeout);
        }

        void onFinish() {
            OnFinishCallback onFinishCallback = this.mOnFinishCallback;
            if (onFinishCallback != null) {
                onFinishCallback.onFinish(this.mId);
            }
        }

        void onError(Exception exc) {
            OnErrorCallback onErrorCallback = this.mOnErrorCallback;
            if (onErrorCallback != null) {
                onErrorCallback.onError(this, exc);
            }
        }

        public String toString() {
            return "[HeadlessTaskManager.Task name: " + this.mTaskName + " id: " + this.mId + "]";
        }

        public static class Builder {
            private static final int DEFAULT_TIMEOUT = 60000;
            private String name;
            private OnErrorCallback onErrorCallback;
            private OnFinishCallback onFinishCallback;
            private OnInvokeCallback onInvokeCallback;
            private WritableMap params;
            private int timeout = 60000;

            public Builder setName(String str) {
                this.name = str;
                return this;
            }

            public Builder setOnInvokeCallback(OnInvokeCallback onInvokeCallback) {
                this.onInvokeCallback = onInvokeCallback;
                return this;
            }

            public Builder setOnFinishCallback(OnFinishCallback onFinishCallback) {
                this.onFinishCallback = onFinishCallback;
                return this;
            }

            public Builder setOnErrorCallback(OnErrorCallback onErrorCallback) {
                this.onErrorCallback = onErrorCallback;
                return this;
            }

            public Builder setParams(WritableMap writableMap) {
                this.params = writableMap;
                return this;
            }

            public Builder setTimeout(int i) {
                this.timeout = i;
                return this;
            }

            public Task build() {
                return new Task(this);
            }
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class TaskNotFoundError extends Exception {
        public TaskNotFoundError(int i) {
            super(HeadlessTaskManager.class.getName() + " failed to find task: " + i);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ContextError extends Exception {
        public ContextError(String str) {
            super(str);
        }
    }
}
