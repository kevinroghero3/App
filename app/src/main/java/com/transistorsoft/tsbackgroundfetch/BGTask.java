package com.transistorsoft.tsbackgroundfetch;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import io.sentry.ProfilingTraceData;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BGTask {
    static int MAX_TIME = 60000;
    private static final List<BGTask> mTasks = new ArrayList();
    private FetchJobService.CompletionHandler mCompletionHandler;
    private final List<FetchJobService.CompletionHandler> mCompletionHandlers;
    private int mJobId;
    private String mTaskId;
    private boolean mTimedout;
    private Runnable mTimeoutTask;

    static BGTask getTask(String str) {
        List<BGTask> list = mTasks;
        synchronized (list) {
            for (BGTask bGTask : list) {
                if (bGTask.hasTaskId(str)) {
                    return bGTask;
                }
            }
            return null;
        }
    }

    static void addTask(BGTask bGTask) {
        List<BGTask> list = mTasks;
        synchronized (list) {
            list.add(bGTask);
        }
    }

    static void removeTask(String str) {
        BGTask next;
        List<BGTask> list = mTasks;
        synchronized (list) {
            Iterator<BGTask> it2 = list.iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!next.hasTaskId(str));
            if (next != null) {
                mTasks.remove(next);
            }
        }
    }

    static void clear() {
        List<BGTask> list = mTasks;
        synchronized (list) {
            list.clear();
        }
    }

    BGTask(final Context context, String str, FetchJobService.CompletionHandler completionHandler, int i) {
        ArrayList arrayList = new ArrayList();
        this.mCompletionHandlers = arrayList;
        this.mTimedout = false;
        this.mTaskId = str;
        arrayList.add(completionHandler);
        this.mJobId = i;
        this.mTimeoutTask = new Runnable() { // from class: com.transistorsoft.tsbackgroundfetch.BGTask.1
            @Override // java.lang.Runnable
            public void run() {
                BGTask.this.onTimeout(context);
            }
        };
        BackgroundFetch.getUiHandler().postDelayed(this.mTimeoutTask, MAX_TIME);
    }

    public boolean getTimedOut() {
        return this.mTimedout;
    }

    public String getTaskId() {
        return this.mTaskId;
    }

    int getJobId() {
        return this.mJobId;
    }

    boolean hasTaskId(String str) {
        String str2 = this.mTaskId;
        return str2 != null && str2.equalsIgnoreCase(str);
    }

    public void setCompletionHandler(FetchJobService.CompletionHandler completionHandler) {
        synchronized (this.mCompletionHandlers) {
            this.mCompletionHandlers.add(completionHandler);
        }
    }

    void finish() {
        synchronized (this.mCompletionHandlers) {
            Iterator<FetchJobService.CompletionHandler> it2 = this.mCompletionHandlers.iterator();
            while (it2.hasNext()) {
                it2.next().finish();
            }
            this.mCompletionHandlers.clear();
        }
        if (this.mTimeoutTask != null) {
            BackgroundFetch.getUiHandler().removeCallbacks(this.mTimeoutTask);
        }
        removeTask(this.mTaskId);
    }

    static void reschedule(Context context, BackgroundFetchConfig backgroundFetchConfig, BackgroundFetchConfig backgroundFetchConfig2) {
        BGTask task = getTask(backgroundFetchConfig.getTaskId());
        if (task != null) {
            task.finish();
        }
        cancel(context, backgroundFetchConfig.getTaskId(), backgroundFetchConfig.getJobId());
        schedule(context, backgroundFetchConfig2);
    }

    static void schedule(Context context, BackgroundFetchConfig backgroundFetchConfig) {
        Log.d(BackgroundFetch.TAG, backgroundFetchConfig.toString());
        long millis = backgroundFetchConfig.isFetchTask() ? TimeUnit.MINUTES.toMillis(backgroundFetchConfig.getMinimumFetchInterval()) : backgroundFetchConfig.getDelay();
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (!backgroundFetchConfig.getForceAlarmManager()) {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            JobInfo.Builder requiresCharging = new JobInfo.Builder(backgroundFetchConfig.getJobId(), new ComponentName(context, (Class<?>) FetchJobService.class)).setRequiredNetworkType(backgroundFetchConfig.getRequiredNetworkType()).setRequiresDeviceIdle(backgroundFetchConfig.getRequiresDeviceIdle()).setRequiresCharging(backgroundFetchConfig.getRequiresCharging());
            if (backgroundFetchConfig.getStartOnBoot() && !backgroundFetchConfig.getStopOnTerminate()) {
                z = true;
            }
            JobInfo.Builder persisted = requiresCharging.setPersisted(z);
            if (backgroundFetchConfig.getPeriodic()) {
                persisted.setPeriodic(millis, millis);
            } else {
                persisted.setMinimumLatency(millis);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(BackgroundFetchConfig.FIELD_TASK_ID, backgroundFetchConfig.getTaskId());
            persistableBundle.putLong("scheduled_at", System.currentTimeMillis());
            persisted.setExtras(persistableBundle);
            if (i >= 26) {
                persisted.setRequiresStorageNotLow(backgroundFetchConfig.getRequiresStorageNotLow());
                persisted.setRequiresBatteryNotLow(backgroundFetchConfig.getRequiresBatteryNotLow());
            }
            if (jobScheduler != null) {
                jobScheduler.schedule(persisted.build());
                return;
            }
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            PendingIntent alarmPI = getAlarmPI(context, backgroundFetchConfig.getTaskId());
            long jCurrentTimeMillis = System.currentTimeMillis() + millis;
            if (backgroundFetchConfig.getPeriodic()) {
                alarmManager.setRepeating(0, jCurrentTimeMillis, millis, alarmPI);
                return;
            }
            if (i >= 31) {
                if (alarmManager.canScheduleExactAlarms()) {
                    alarmManager.setExactAndAllowWhileIdle(0, jCurrentTimeMillis, alarmPI);
                    return;
                } else {
                    alarmManager.setAndAllowWhileIdle(0, jCurrentTimeMillis, alarmPI);
                    return;
                }
            }
            alarmManager.setExactAndAllowWhileIdle(0, jCurrentTimeMillis, alarmPI);
        }
    }

    void onTimeout(Context context) {
        this.mTimedout = true;
        Log.d(BackgroundFetch.TAG, "[BGTask] timeout: " + this.mTaskId);
        BackgroundFetch backgroundFetch = BackgroundFetch.getInstance(context);
        if (!LifecycleManager.getInstance().isHeadless()) {
            BackgroundFetch.Callback fetchCallback = backgroundFetch.getFetchCallback();
            if (fetchCallback != null) {
                fetchCallback.onTimeout(this.mTaskId);
                return;
            }
            return;
        }
        BackgroundFetchConfig config = backgroundFetch.getConfig(this.mTaskId);
        if (config != null) {
            if (config.getJobService() != null) {
                try {
                    fireHeadlessEvent(context, config);
                    return;
                } catch (Error e) {
                    SentryLogcatAdapter.e(BackgroundFetch.TAG, "Headless task error: " + e.getMessage());
                    return;
                }
            }
            backgroundFetch.finish(this.mTaskId);
            return;
        }
        SentryLogcatAdapter.e(BackgroundFetch.TAG, "[BGTask] failed to load config for taskId: " + this.mTaskId);
        backgroundFetch.finish(this.mTaskId);
    }

    void fireHeadlessEvent(Context context, BackgroundFetchConfig backgroundFetchConfig) throws Error {
        try {
            try {
                Class<?> cls = Class.forName(backgroundFetchConfig.getJobService());
                Class<?>[] clsArr = {Context.class, BGTask.class};
                Object[] objArr = {context, this};
                try {
                    cls.getDeclaredConstructor(clsArr).newInstance(objArr);
                } catch (NoSuchMethodException unused) {
                    Object objNewInstance = cls.getConstructor(null).newInstance(null);
                    objNewInstance.getClass().getDeclaredMethod("onFetch", clsArr).invoke(objNewInstance, objArr);
                }
            } catch (ClassNotFoundException e) {
                throw new Error(e.getMessage());
            } catch (IllegalAccessException e2) {
                throw new Error(e2.getMessage());
            } catch (InstantiationException e3) {
                throw new Error(e3.getMessage());
            } catch (InvocationTargetException e4) {
                throw new Error(e4.getMessage());
            }
        } catch (NoSuchMethodException e5) {
            throw new Error(e5.getMessage());
        }
    }

    static void cancel(Context context, String str, int i) {
        Log.i(BackgroundFetch.TAG, "- cancel taskId=" + str + ", jobId=" + i);
        if (i != 0) {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler != null) {
                jobScheduler.cancel(i);
                return;
            }
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            alarmManager.cancel(getAlarmPI(context, str));
        }
    }

    static PendingIntent getAlarmPI(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) FetchAlarmReceiver.class);
        intent.setAction(str);
        return PendingIntent.getBroadcast(context, 0, intent, 201326592);
    }

    public String toString() {
        return "[BGTask taskId=" + this.mTaskId + "]";
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put(BackgroundFetchConfig.FIELD_TASK_ID, this.mTaskId);
        map.put(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, Boolean.valueOf(this.mTimedout));
        return map;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BackgroundFetchConfig.FIELD_TASK_ID, this.mTaskId);
            jSONObject.put(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, this.mTimedout);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static class Error extends RuntimeException {
        public Error(String str) {
            super(str);
        }
    }
}
