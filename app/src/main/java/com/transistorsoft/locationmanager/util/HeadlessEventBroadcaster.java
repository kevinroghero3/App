package com.transistorsoft.locationmanager.util;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.event.HeadlessEvent;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeadlessEventBroadcaster {
    public static final String DEFAULT_HEADLESS_TASK_CLASSNAME = "BackgroundGeolocationHeadlessTask";

    private static Class<?> a(Context context, String str) throws ClassNotFoundException {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return Class.forName(context.getPackageName() + "." + DEFAULT_HEADLESS_TASK_CLASSNAME);
        }
    }

    private static boolean b(Context context, String str) {
        EventBus eventBus = EventBus.getDefault();
        if (eventBus.hasSubscriberForEvent(HeadlessEvent.class)) {
            return true;
        }
        try {
            try {
                Object objNewInstance = a(context, str).getConstructor(null).newInstance(null);
                if (!eventBus.isRegistered(objNewInstance)) {
                    eventBus.register(objNewInstance);
                }
                return true;
            } catch (EventBusException e) {
                TSLog.logger.error(TSLog.error("Failed to register headlessJobService: " + str + ": " + e.getMessage()));
                return false;
            }
        } catch (ClassNotFoundException e2) {
            TSLog.logger.error("HeadlessTask failed to find " + str + ".java.  If you've configured enableHeadless: true, you must provide a custom BackgroundGeolocationHeadlessTask.java.  See Wiki: https://github.com/transistorsoft/cordova-background-geolocation-lt/wiki/Android-Headless-Mode");
            a(e2);
            return false;
        } catch (IllegalAccessException e3) {
            a(e3);
            return false;
        } catch (InstantiationException e4) {
            a(e4);
            return false;
        } catch (NoSuchMethodException e5) {
            a(e5);
            return false;
        } catch (InvocationTargetException e6) {
            a(e6);
            return false;
        }
    }

    public static void broadcast(Context context, String str, JSONObject jSONObject) {
    }

    public static void post(HeadlessEvent headlessEvent) {
        TSConfig tSConfig = TSConfig.getInstance(headlessEvent.getContext().getApplicationContext());
        if (tSConfig.getEnableHeadless().booleanValue()) {
            EventBus eventBus = EventBus.getDefault();
            if (!eventBus.hasSubscriberForEvent(HeadlessEvent.class)) {
                b(headlessEvent.getContext(), tSConfig.getHeadlessJobService());
            }
            if (eventBus.hasSubscriberForEvent(HeadlessEvent.class)) {
                eventBus.post(headlessEvent);
                return;
            }
            TSLog.logger.warn(TSLog.warn("Attempted to post headless event " + headlessEvent.getName() + " but there are no listeners."));
        }
    }

    private static void a(Exception exc) {
        TSLog.logger.error(TSLog.error(exc.getMessage()));
        exc.printStackTrace();
    }

    private static void a(Context context, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(context.getPackageName() + ".tslocationmanager.event." + str.toUpperCase());
        Bundle bundle = new Bundle();
        bundle.putString(NotificationCompat.CATEGORY_EVENT, str);
        bundle.putString("params", jSONObject.toString());
        intent.putExtras(bundle);
        context.sendBroadcast(intent);
    }

    private static int a(String str, String str2) {
        if (!str2.equalsIgnoreCase("location") && !str2.equalsIgnoreCase("http") && !str2.equalsIgnoreCase("geofence")) {
            return (str + "-" + str2).hashCode();
        }
        return new Date().hashCode();
    }

    private static void b(Context context, String str, JSONObject jSONObject) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        TSConfig tSConfig = TSConfig.getInstance(context.getApplicationContext());
        try {
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(NotificationCompat.CATEGORY_EVENT, str);
            persistableBundle.putString("params", jSONObject.toString());
            JobInfo.Builder persisted = new JobInfo.Builder(a(context.getPackageName(), str), new ComponentName(context, tSConfig.getHeadlessJobService())).setRequiredNetworkType(0).setRequiresDeviceIdle(false).setRequiresCharging(false).setOverrideDeadline(0L).setExtras(persistableBundle).setMinimumLatency(0L).setPersisted(false);
            if (jobScheduler != null) {
                jobScheduler.schedule(persisted.build());
            }
        } catch (IllegalArgumentException e) {
            TSLog.logger.error(TSLog.error("Failure broadcasting headless event to headlessJobService: " + tSConfig.getHeadlessJobService() + "\n" + e.getMessage()));
        }
    }
}
