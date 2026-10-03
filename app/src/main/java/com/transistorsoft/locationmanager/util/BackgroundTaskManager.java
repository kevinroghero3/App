package com.transistorsoft.locationmanager.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkManager;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.callback.TSBackgroundTaskCallback;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class BackgroundTaskManager {
    public static String ACTION = "BackgroundTask";
    public static String TASK_ID_FIELD = "taskId";
    private static final long c = 180000;
    private static final AtomicInteger d = new AtomicInteger(0);
    private static BackgroundTaskManager e = null;
    private final List<Task> a = new ArrayList();
    private final Handler b = new Handler(Looper.getMainLooper());

    /* JADX INFO: loaded from: classes3.dex */
    public interface Callback {
        void onFinish();
    }

    /* JADX INFO: loaded from: classes3.dex */
    public class Task {
        private final int a;
        private final UUID b;
        private final TSBackgroundTaskCallback c;
        private Callback d;
        private Runnable e;
        private boolean f;
        private boolean g = false;

        Task(Context context, boolean z, TSBackgroundTaskCallback tSBackgroundTaskCallback) throws Throwable {
            this.f = false;
            int iC = BackgroundTaskManager.c();
            this.a = iC;
            this.f = z;
            this.c = tSBackgroundTaskCallback;
            Data dataBuild = new Data.Builder().putInt(BackgroundFetchConfig.FIELD_TASK_ID, iC).build();
            WorkManager workManager = WorkManager.getInstance(context);
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(BackgroundTaskWorker.class).setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST).setInputData(dataBuild).build();
            this.b = oneTimeWorkRequestBuild.getId();
            workManager.enqueue(oneTimeWorkRequestBuild);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            this.c.onStart(this.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            TSLog.logger.warn(TSLog.warn("FORCE STOP BACKGROUND TASK (max duration: 180000ms): " + this.a));
            stop();
            BackgroundTaskManager.getInstance().b(this);
            this.e = null;
        }

        private void c() {
            this.e = new Runnable() { // from class: com.transistorsoft.locationmanager.util.BackgroundTaskManager$Task$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            };
            BackgroundTaskManager.this.b.postDelayed(this.e, BackgroundTaskManager.c);
        }

        private void d() {
            if (this.e != null) {
                BackgroundTaskManager.this.b.removeCallbacks(this.e);
            }
            this.e = null;
        }

        public void cancel() {
            TSLog.logger.info("⏳⚠️   cancelBackgroundTask: " + this.a);
            Callback callback = this.d;
            if (callback != null) {
                callback.onFinish();
            }
            d();
            this.c.onCancel(this.a);
        }

        public int getId() {
            return this.a;
        }

        public void start(Callback callback) {
            if (this.g) {
                TSLog.warn(TSLog.warn("Calling BackgroundTaskManager.Task.start on an already started task was IGNORED"));
                return;
            }
            this.g = true;
            TSLog.logger.info("⏳ startBackgroundTask: " + this.a);
            this.d = callback;
            if (!this.f) {
                c();
            }
            BackgroundGeolocation.getUiHandler().post(new Runnable() { // from class: com.transistorsoft.locationmanager.util.BackgroundTaskManager$Task$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }

        public void stop() {
            TSLog.logger.info("⏳ stopBackgroundTask: " + this.a);
            Callback callback = this.d;
            if (callback != null) {
                callback.onFinish();
            }
            d();
        }
    }

    private BackgroundTaskManager() {
    }

    private static BackgroundTaskManager b() {
        BackgroundTaskManager backgroundTaskManager;
        synchronized (BackgroundTaskManager.class) {
            if (e == null) {
                e = new BackgroundTaskManager();
            }
            backgroundTaskManager = e;
        }
        return backgroundTaskManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c() {
        return d.incrementAndGet();
    }

    public static BackgroundTaskManager getInstance() {
        if (e == null) {
            e = b();
        }
        return e;
    }

    public void cancelBackgroundTask(Context context, int i) {
        Task taskA = a(i);
        if (taskA != null) {
            taskA.cancel();
            b(taskA);
        }
    }

    public void onStartJob(Context context, int i, Callback callback) {
        Task taskA = a(i);
        if (taskA != null) {
            taskA.start(callback);
            return;
        }
        TSLog.logger.warn(TSLog.warn("Failed to find Task: " + i));
        callback.onFinish();
    }

    public void startBackgroundTask(Context context, TSBackgroundTaskCallback tSBackgroundTaskCallback) {
        startBackgroundTask(context, false, tSBackgroundTaskCallback);
    }

    public void stopBackgroundTask(Context context, int i) {
        Task taskA = a(i);
        if (taskA != null) {
            taskA.stop();
            b(taskA);
            return;
        }
        TSLog.logger.warn(TSLog.warn("Failed to find find background task: " + i));
    }

    public void startBackgroundTask(Context context, boolean z, TSBackgroundTaskCallback tSBackgroundTaskCallback) {
        a(new Task(context, z, tSBackgroundTaskCallback));
    }

    private Task a(int i) {
        synchronized (this.a) {
            for (Task task : this.a) {
                if (task.getId() == i) {
                    return task;
                }
            }
            return null;
        }
    }

    boolean b(Task task) {
        boolean zRemove;
        synchronized (this.a) {
            zRemove = this.a.remove(task);
        }
        return zRemove;
    }

    private void a(Task task) {
        synchronized (this.a) {
            this.a.add(task);
        }
    }
}
