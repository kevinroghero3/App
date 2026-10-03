package com.transistorsoft.locationmanager.service;

import android.content.Context;
import android.location.Location;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.data.sqlite.SQLiteLocationDAO;
import com.transistorsoft.locationmanager.event.HeadlessEvent;
import com.transistorsoft.locationmanager.event.HeartbeatEvent;
import com.transistorsoft.locationmanager.http.HttpService;
import com.transistorsoft.locationmanager.lifecycle.LifecycleManager;
import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.logger.TSMediaPlayer;
import com.transistorsoft.locationmanager.scheduler.TSScheduleManager;
import com.transistorsoft.locationmanager.util.HeadlessEventBroadcaster;
import java.util.concurrent.ExecutorService;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class HeartbeatService {
    public static final String ACTION = "HEARTBEAT";

    class a implements TSLocationManager.LocationCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ HeartbeatEvent b;

        a(Context context, HeartbeatEvent heartbeatEvent) {
            this.a = context;
            this.b = heartbeatEvent;
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onFailure(String str) {
            ExecutorService threadPool = BackgroundGeolocation.getThreadPool();
            final Context context = this.a;
            final HeartbeatEvent heartbeatEvent = this.b;
            threadPool.execute(new Runnable() { // from class: com.transistorsoft.locationmanager.service.HeartbeatService$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    HeartbeatService.a(context, heartbeatEvent);
                }
            });
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onLocation(Location location) {
            TSLocation tSLocation = new TSLocation(this.a, location, ActivityRecognitionService.getMostProbableActivity());
            tSLocation.setEvent("heartbeat");
            this.b.setLocation(tSLocation);
            ExecutorService threadPool = BackgroundGeolocation.getThreadPool();
            final Context context = this.a;
            final HeartbeatEvent heartbeatEvent = this.b;
            threadPool.execute(new Runnable() { // from class: com.transistorsoft.locationmanager.service.HeartbeatService$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HeartbeatService.a(context, heartbeatEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, HeartbeatEvent heartbeatEvent) {
        b(context, heartbeatEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, HeartbeatEvent heartbeatEvent) {
        EventBus.getDefault().post(heartbeatEvent);
        if (LifecycleManager.getInstance().isHeadless()) {
            HeadlessEventBroadcaster.post(new HeadlessEvent(context, "heartbeat", heartbeatEvent));
        }
        SQLiteLocationDAO sQLiteLocationDAO = SQLiteLocationDAO.getInstance(context);
        HttpService httpService = HttpService.getInstance(context);
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (sQLiteLocationDAO.count() > 0 && tSConfig.hasUrl() && tSConfig.getAutoSync().booleanValue() && httpService.isNetworkAvailable()) {
            httpService.e();
        }
    }

    public static void onHeartbeat(Context context) {
        int iIntValue = TSConfig.getInstance(context).getHeartbeatInterval().intValue();
        if (iIntValue <= 0) {
            TSScheduleManager.getInstance(context).cancelOneShot(ACTION);
            return;
        }
        TSScheduleManager.getInstance(context).oneShot(ACTION, ((long) iIntValue) * 1000, true);
        TSLog.logger.debug("❤️");
        TSMediaPlayer.getInstance().debug(context, "tslocationmanager_peep_note1");
        TSLocationManager.getInstance(context).getLastLocation(new a(context, new HeartbeatEvent()));
    }

    public static void start(Context context) {
        int iIntValue = TSConfig.getInstance(context).getHeartbeatInterval().intValue();
        if (iIntValue <= 0) {
            stop(context);
            return;
        }
        TSLog.logger.info(TSLog.on("Start heartbeat (" + iIntValue + "s)"));
        TSScheduleManager.getInstance(context).cancelOneShot(ACTION);
        TSScheduleManager.getInstance(context).oneShot(ACTION, ((long) iIntValue) * 1000, true);
    }

    public static void stop(Context context) {
        TSLog.logger.info(TSLog.off("Stop heartbeat"));
        TSScheduleManager.getInstance(context).cancelOneShot(ACTION);
    }
}
