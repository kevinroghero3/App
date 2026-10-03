package com.transistorsoft.locationmanager.scheduler;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.facebook.react.uimanager.ViewProps;
import com.transistorsoft.locationmanager.Constants;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.event.ConfigChangeEvent;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.service.TrackingService;
import com.transistorsoft.locationmanager.util.Util;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes.dex */
public class TSScheduleManager {
    public static final String ACTION_NAME = "action";
    public static final String ACTION_ONESHOT = "ONESHOT";
    private static TSScheduleManager e = null;
    private static final int f = 666;
    private final Context a;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final List<Schedule> c = new ArrayList();
    private final SimpleDateFormat b = new SimpleDateFormat("HH:mm", Locale.US);

    public TSScheduleManager(Context context) {
        this.a = context;
        EventBus eventBus = EventBus.getDefault();
        if (eventBus.isRegistered(this)) {
            return;
        }
        eventBus.register(this);
    }

    private static TSScheduleManager a(Context context) {
        TSScheduleManager tSScheduleManager;
        synchronized (TSScheduleManager.class) {
            if (e == null) {
                e = new TSScheduleManager(context);
            }
            tSScheduleManager = e;
        }
        return tSScheduleManager;
    }

    public static TSScheduleManager getInstance(Context context) {
        if (e == null) {
            TSConfig.getInstance(context.getApplicationContext());
            e = a(context);
        }
        return e;
    }

    void b() {
        if (!TSConfig.getInstance(this.a).getScheduleUseAlarmManager().booleanValue()) {
            ((JobScheduler) this.a.getSystemService("jobscheduler")).cancel(f);
            return;
        }
        ((AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(ScheduleService.b(this.a, new Intent(this.a, (Class<?>) ScheduleService.class)));
    }

    public boolean canScheduleExactAlarms() {
        AlarmManager alarmManager = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (Build.VERSION.SDK_INT >= 31) {
            return alarmManager.canScheduleExactAlarms();
        }
        return true;
    }

    public void cancelOneShot(String str) {
        if (a(str)) {
            TSLog.logger.info(TSLog.alarm("Cancel OneShot: " + str));
            JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
            if (jobScheduler != null) {
                jobScheduler.cancel(str.hashCode());
            }
            Intent intent = new Intent(this.a, (Class<?>) ScheduleAlarmReceiver.class);
            intent.setAction(str);
            intent.putExtra(ACTION_ONESHOT, true);
            intent.putExtra("action", str);
            PendingIntent broadcast = PendingIntent.getBroadcast(this.a, str.hashCode(), intent, Util.getPendingIntentFlags(134217728));
            AlarmManager alarmManager = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
        }
    }

    public void destroy() {
        if (TSConfig.getInstance(this.a).getStopOnTerminate().booleanValue()) {
            stop();
        }
        EventBus eventBus = EventBus.getDefault();
        if (eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConfigChange(ConfigChangeEvent configChangeEvent) {
        TSConfig.getInstance(this.a);
        if (configChangeEvent.isDirty("schedule")) {
            restart(configChangeEvent.getContext());
        }
    }

    public void oneShot(String str, long j) {
        oneShot(str, j, false, false);
    }

    public void restart(Context context) {
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        synchronized (this.c) {
            this.c.clear();
        }
        if (tSConfig.getSchedulerEnabled().booleanValue()) {
            TSLog.logger.debug(TSLog.calendar("Schedule changed:  restarting..."));
            b();
            tSConfig.setSchedulerEnabled(Boolean.FALSE);
            start();
        }
    }

    public void start() {
        if (this.d.get()) {
            return;
        }
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        synchronized (this.c) {
            if (this.c.isEmpty()) {
                if (!a()) {
                    stop();
                    return;
                }
            } else if (tSConfig.getSchedulerEnabled().booleanValue()) {
                TSLog.logger.warn("Scheduler already started.  IGNORED");
                return;
            }
            tSConfig.setSchedulerEnabled(Boolean.TRUE);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(TSLog.header("🎾  Scheduler ON"));
            synchronized (this.c) {
                Iterator<Schedule> it2 = this.c.iterator();
                while (it2.hasNext()) {
                    stringBuffer.append(TSLog.boxRow(it2.next().toString()));
                }
            }
            stringBuffer.append(TSLog.BOX_BOTTOM);
            TSLog.logger.info(stringBuffer.toString());
            a(Calendar.getInstance(Locale.US), tSConfig.getEnabled());
        }
    }

    public void stop() {
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        TSLog.logger.info(TSLog.off("Scheduler OFF"));
        tSConfig.setSchedulerEnabled(Boolean.FALSE);
        b();
    }

    public void oneShot(String str, long j, boolean z) {
        oneShot(str, j, z, false);
    }

    void a(Calendar calendar, Boolean bool) {
        Schedule next;
        synchronized (this.c) {
            if (this.c.isEmpty() && !a()) {
                stop();
                return;
            }
            if (TimeUnit.MILLISECONDS.toDays(calendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis()) >= 7) {
                TSLog.logger.warn(TSLog.warn("Failed to find a schedule.  Giving up."));
                return;
            }
            int i = calendar.get(7);
            TSLog.logger.debug(TSLog.calendar("Day #" + i + ": Searching schedule for alarms..."));
            synchronized (this.c) {
                Iterator<Schedule> it2 = this.c.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!next.isNext(calendar));
            }
            if (next != null) {
                if (calendar.after(next.onTime) && calendar.before(next.offTime)) {
                    if (!bool.booleanValue()) {
                        TSLog.logger.debug(TSLog.calendar("Scheduler says we should be ENABLED but we are NOT"));
                        a(Boolean.TRUE, calendar, next.trackingMode);
                        return;
                    } else {
                        a(Boolean.FALSE, next.offTime, next.trackingMode);
                        TrackingService.start(this.a);
                        return;
                    }
                }
                if (calendar.before(next.onTime)) {
                    if (bool.booleanValue()) {
                        TSLog.logger.debug(TSLog.calendar("Scheduler says we should be DISABLED but we are NOT"));
                        a(Boolean.FALSE, calendar, next.trackingMode);
                        return;
                    } else {
                        a(Boolean.TRUE, next.onTime, next.trackingMode);
                        return;
                    }
                }
                if (calendar.after(next.offTime)) {
                    if (bool.booleanValue()) {
                        TSLog.logger.debug(TSLog.calendar("Scheduler says we should be DISABLED but we are NOT"));
                        a(Boolean.FALSE, calendar, next.trackingMode);
                        return;
                    }
                    TSLog.logger.debug(TSLog.calendar("Scheduler failed to find any alarms today.  Checking tomorrow..."));
                    calendar.add(6, 1);
                    calendar.set(11, 0);
                    calendar.set(12, 0);
                    a(calendar, bool);
                    return;
                }
                TSLog.logger.warn(TSLog.warn("Failed to find next alarm"));
                return;
            }
            if (bool.booleanValue()) {
                TSLog.logger.debug(TSLog.calendar("Scheduler says we should be DISABLED but we are NOT"));
                a(Boolean.FALSE, calendar, 1);
                return;
            }
            TSLog.logger.debug(TSLog.calendar("Day #" + i + ": Failed to find alarms on this day.  Trying tomorrow..."));
            calendar.add(6, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            a(calendar, bool);
        }
    }

    public void oneShot(String str, long j, boolean z, boolean z2) {
        if (a(str)) {
            TSLog.logger.info(TSLog.alarm("Oneshot " + str + " is already pending"));
            return;
        }
        TSLog.logger.info(TSLog.alarm("Scheduled OneShot: " + str + " in " + j + "ms (jobID: " + str.hashCode() + ")"));
        int i = Build.VERSION.SDK_INT;
        if (!z) {
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putBoolean(ACTION_ONESHOT, true);
            persistableBundle.putString("action", str);
            JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                TSLog.logger.warn(TSLog.warn("JobScheduler is null.  Cannot fire oneshot: " + str));
                return;
            }
            jobScheduler.schedule(new JobInfo.Builder(str.hashCode(), new ComponentName(this.a, (Class<?>) ScheduleJobService.class)).setRequiredNetworkType(0).setOverrideDeadline(j).setMinimumLatency(j).setRequiresDeviceIdle(false).setRequiresCharging(false).setExtras(persistableBundle).setPersisted(false).build());
            return;
        }
        if (i <= 33 && z) {
            z2 = true;
        }
        Intent intent = new Intent(this.a, (Class<?>) ScheduleAlarmReceiver.class);
        intent.setAction(str);
        intent.putExtra(ACTION_ONESHOT, true);
        intent.putExtra("action", str);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.a, str.hashCode(), intent, Util.getPendingIntentFlags(134217728));
        AlarmManager alarmManager = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            TSLog.logger.warn(TSLog.warn("AlarmManager is null.  Cannot fire oneshot: " + str));
            return;
        }
        long jCurrentTimeMillis = j + System.currentTimeMillis();
        if (i >= 31) {
            if (alarmManager.canScheduleExactAlarms() && z2) {
                alarmManager.setExactAndAllowWhileIdle(0, jCurrentTimeMillis, broadcast);
                return;
            }
            if (!alarmManager.canScheduleExactAlarms() && z2) {
                TSLog.logger.warn(TSLog.info("Scheduling exact alarms requires android.permission.USE_EXACT_ALARM with SDK >= 34.  Oneshot using in-exact Alarm"));
            }
            alarmManager.setAndAllowWhileIdle(0, jCurrentTimeMillis, broadcast);
            return;
        }
        alarmManager.setExactAndAllowWhileIdle(0, jCurrentTimeMillis, broadcast);
    }

    private void a(Boolean bool, Calendar calendar, int i) {
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        Locale locale = Locale.getDefault();
        Logger logger = TSLog.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("Scheduled Alarm: ");
        sb.append(bool.booleanValue() ? Constants.a.a : Constants.a.b);
        sb.append(" at ");
        sb.append(this.b.format(calendar.getTime()));
        sb.append(" on ");
        sb.append(calendar.getDisplayName(7, 2, locale));
        logger.info(TSLog.calendar(sb.toString()));
        if (!tSConfig.getScheduleUseAlarmManager().booleanValue()) {
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putBoolean(ViewProps.ENABLED, bool.booleanValue());
            persistableBundle.putInt("trackingMode", i);
            Calendar calendar2 = Calendar.getInstance(Locale.US);
            long timeInMillis = calendar.after(calendar2) ? calendar.getTimeInMillis() - calendar2.getTimeInMillis() : 0L;
            TSLog.logger.debug(TSLog.info("JobScheduler triggerDelay: " + timeInMillis));
            ((JobScheduler) this.a.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(f, new ComponentName(this.a, (Class<?>) ScheduleJobService.class)).setRequiredNetworkType(0).setOverrideDeadline(timeInMillis).setMinimumLatency(timeInMillis).setRequiresDeviceIdle(false).setRequiresCharging(false).setExtras(persistableBundle).setPersisted(false).build());
            return;
        }
        TSLog.logger.debug(TSLog.info("Schedule with AlarmManager"));
        Intent intent = new Intent(this.a, (Class<?>) ScheduleService.class);
        intent.putExtra("schedule_enabled", bool);
        intent.putExtra("trackingMode", i);
        PendingIntent pendingIntentB = ScheduleService.b(this.a, intent);
        AlarmManager alarmManager = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 30) {
            if (alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExactAndAllowWhileIdle(0, calendar.getTimeInMillis(), pendingIntentB);
                return;
            }
            if (i2 > 33) {
                TSLog.logger.warn(TSLog.info("Scheduling exact alarms requires android.permission.USE_EXACT_ALARM with SDK >= 34.  Using in-exact Alarm"));
                Intent intent2 = new Intent(this.a, (Class<?>) ScheduleAlarmReceiver.class);
                intent2.putExtra("schedule_enabled", bool);
                intent2.putExtra("trackingMode", i);
                pendingIntentB = PendingIntent.getBroadcast(this.a, 0, intent2, Util.getPendingIntentFlags(134217728));
            }
            alarmManager.setAndAllowWhileIdle(0, calendar.getTimeInMillis(), pendingIntentB);
            return;
        }
        alarmManager.setExactAndAllowWhileIdle(0, calendar.getTimeInMillis(), pendingIntentB);
    }

    private boolean a(String str) {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putBoolean(ACTION_ONESHOT, true);
        persistableBundle.putString("action", str);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        boolean z = (jobScheduler == null || jobScheduler.getPendingJob(str.hashCode()) == null) ? false : true;
        if (z) {
            return z;
        }
        Intent intent = new Intent(this.a, (Class<?>) ScheduleAlarmReceiver.class);
        intent.setAction(str);
        intent.putExtra(ACTION_ONESHOT, true);
        intent.putExtra("action", str);
        return PendingIntent.getBroadcast(this.a, str.hashCode(), intent, Util.getPendingIntentFlags(536870912)) != null;
    }

    private boolean a() {
        boolean zIsEmpty;
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        List<String> schedule = tSConfig.getSchedule();
        if (!tSConfig.hasSchedule()) {
            TSLog.logger.warn(TSLog.warn("Received an empty schedule"));
            return false;
        }
        this.d.set(true);
        synchronized (this.c) {
            Iterator<String> it2 = schedule.iterator();
            while (it2.hasNext()) {
                Schedule schedule2 = new Schedule(it2.next());
                if (!schedule2.isLiteralDate() || !schedule2.isExpired()) {
                    this.c.add(schedule2);
                }
            }
            Collections.sort(this.c, new Comparator() { // from class: com.transistorsoft.locationmanager.scheduler.TSScheduleManager$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return TSScheduleManager.a((Schedule) obj, (Schedule) obj2);
                }
            });
            this.d.set(false);
            zIsEmpty = this.c.isEmpty();
        }
        return !zIsEmpty;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(Schedule schedule, Schedule schedule2) {
        if (schedule.onTime.before(schedule2.onTime)) {
            return -1;
        }
        return schedule.onTime.after(schedule2.onTime) ? 1 : 0;
    }
}
