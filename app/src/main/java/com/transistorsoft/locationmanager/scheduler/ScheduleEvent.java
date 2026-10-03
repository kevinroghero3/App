package com.transistorsoft.locationmanager.scheduler;

import android.content.Context;
import android.content.Intent;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.event.HttpFlushEvent;
import com.transistorsoft.locationmanager.event.LaunchForegroundServiceEvent;
import com.transistorsoft.locationmanager.event.MotionActivityCheckEvent;
import com.transistorsoft.locationmanager.event.MotionTriggerDelayEvent;
import com.transistorsoft.locationmanager.event.StartGeofencesEvent;
import com.transistorsoft.locationmanager.event.StopAfterElapsedMinutesEvent;
import com.transistorsoft.locationmanager.event.StopTimeoutEvent;
import com.transistorsoft.locationmanager.event.TerminateEvent;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.service.HeartbeatService;
import java.util.Calendar;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ScheduleEvent {
    private final Boolean a;
    private final JSONObject b;

    /* JADX INFO: loaded from: classes3.dex */
    public interface Callback {
        void onFinish();
    }

    public ScheduleEvent(Boolean bool, JSONObject jSONObject) {
        this.b = jSONObject;
        this.a = bool;
    }

    static void a(Context context, boolean z, int i) {
        TSLog.logger.debug("");
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (!tSConfig.getSchedulerEnabled().booleanValue()) {
            TSScheduleManager.getInstance(context).b();
            TSLog.logger.warn(TSLog.warn("Ignored schedule alarm event (scheduler is disabled)"));
            return;
        }
        BackgroundGeolocation backgroundGeolocation = BackgroundGeolocation.getInstance(context, new Intent());
        TSLog.logger.info(TSLog.header("📅  Schedule alarm fired!  enabled: " + z + ", trackingMode: " + i));
        tSConfig.setTrackingMode(Integer.valueOf(i));
        if (z) {
            backgroundGeolocation.startOnSchedule();
        } else {
            backgroundGeolocation.stopOnSchedule();
        }
        EventBus.getDefault().post(new ScheduleEvent(Boolean.valueOf(z), tSConfig.toJson()));
        TSScheduleManager.getInstance(context).a(Calendar.getInstance(Locale.US), tSConfig.getEnabled());
    }

    public Boolean getEnabled() {
        return this.a;
    }

    public JSONObject getState() {
        return this.b;
    }

    static void a(Context context, String str, Callback callback) {
        TSLog.logger.info(TSLog.header("⏰ OneShot event fired: " + str));
        Context applicationContext = context.getApplicationContext();
        BackgroundGeolocation.getInstance(applicationContext);
        if (str.equalsIgnoreCase(TerminateEvent.ACTION)) {
            new TerminateEvent(applicationContext);
            callback.onFinish();
        } else if (str.equalsIgnoreCase(MotionActivityCheckEvent.ACTION)) {
            new MotionActivityCheckEvent(applicationContext);
            callback.onFinish();
        } else if (str.equalsIgnoreCase(StopAfterElapsedMinutesEvent.ACTION)) {
            new StopAfterElapsedMinutesEvent(applicationContext);
            callback.onFinish();
        } else if (str.equalsIgnoreCase(StopTimeoutEvent.ACTION)) {
            new StopTimeoutEvent(applicationContext);
            callback.onFinish();
        } else if (str.equalsIgnoreCase(MotionTriggerDelayEvent.ACTION)) {
            new MotionTriggerDelayEvent(applicationContext);
            callback.onFinish();
        } else if (str.equalsIgnoreCase(StartGeofencesEvent.ACTION)) {
            new StartGeofencesEvent(applicationContext);
        } else if (str.equalsIgnoreCase(LaunchForegroundServiceEvent.ACTION)) {
            new LaunchForegroundServiceEvent(applicationContext);
        } else if (str.equalsIgnoreCase(HttpFlushEvent.ACTION)) {
            HttpFlushEvent.run(applicationContext);
        } else if (str.equalsIgnoreCase(HeartbeatService.ACTION)) {
            HeartbeatService.onHeartbeat(applicationContext);
        } else {
            TSLog.logger.warn(TSLog.warn("Unknown OneShot event: " + str + " <IGNORED>"));
        }
        callback.onFinish();
    }
}
