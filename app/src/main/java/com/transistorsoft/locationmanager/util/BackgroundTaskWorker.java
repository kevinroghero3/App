package com.transistorsoft.locationmanager.util;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.common.util.concurrent.ListenableFuture;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.service.ForegroundNotification;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;

/* JADX INFO: loaded from: classes3.dex */
public class BackgroundTaskWorker extends ListenableWorker {
    final int a;
    private CallbackToFutureAdapter.Completer<ListenableWorker.Result> b;

    public BackgroundTaskWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.a = getInputData().getInt(BackgroundFetchConfig.FIELD_TASK_ID, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(CallbackToFutureAdapter.Completer completer) {
        completer.set(ListenableWorker.Result.success());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object b(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.b = completer;
        BackgroundTaskManager.getInstance().onStartJob(getApplicationContext(), this.a, new BackgroundTaskManager.Callback() { // from class: com.transistorsoft.locationmanager.util.BackgroundTaskWorker$$ExternalSyntheticLambda0
            @Override // com.transistorsoft.locationmanager.util.BackgroundTaskManager.Callback
            public final void onFinish() {
                BackgroundTaskWorker.a(completer);
            }
        });
        return "[BackgroundTaskWorker id=" + this.a + ", workId: " + getId() + "]";
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        if (Build.VERSION.SDK_INT >= 31) {
            return super.getForegroundInfoAsync();
        }
        final Notification notificationBuild = ForegroundNotification.build(getApplicationContext());
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: com.transistorsoft.locationmanager.util.BackgroundTaskWorker$$ExternalSyntheticLambda2
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return BackgroundTaskWorker.a(notificationBuild, completer);
            }
        });
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        CallbackToFutureAdapter.Completer<ListenableWorker.Result> completer = this.b;
        if (completer != null) {
            completer.setCancelled();
        }
        TSLog.logger.warn(TSLog.warn("[BackgroundTaskWorker] System stopped taskId: " + this.a));
        BackgroundTaskManager.getInstance().cancelBackgroundTask(getApplicationContext(), this.a);
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: com.transistorsoft.locationmanager.util.BackgroundTaskWorker$$ExternalSyntheticLambda1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.b(completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a(Notification notification, CallbackToFutureAdapter.Completer completer) throws Exception {
        completer.set(new ForegroundInfo(ForegroundNotification.NOTIFICATION_ID, notification));
        return "getForegroundInfoAsync";
    }
}
