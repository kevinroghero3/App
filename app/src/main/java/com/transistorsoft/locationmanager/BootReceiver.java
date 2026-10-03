package com.transistorsoft.locationmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.event.BootEvent;
import com.transistorsoft.locationmanager.lifecycle.LifecycleManager;
import com.transistorsoft.locationmanager.logger.TSLog;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes6.dex */
public class BootReceiver extends BroadcastReceiver {
    private void a(Context context, Intent intent) {
        TSConfig tSConfig = TSConfig.getInstance(context.getApplicationContext());
        BackgroundGeolocation backgroundGeolocation = BackgroundGeolocation.getInstance(context);
        EventBus.getDefault().post(new BootEvent(context, intent));
        if (LifecycleManager.getInstance().isHeadless()) {
            if (tSConfig.getEnabled().booleanValue() && (tSConfig.getStopOnTerminate().booleanValue() || !tSConfig.getStartOnBoot().booleanValue())) {
                tSConfig.setEnabled(Boolean.FALSE);
            }
            if (tSConfig.getStopOnTerminate().booleanValue()) {
                TSLog.logger.warn(TSLog.warn("Plugin is configured to stopOnTerminate: true.  Refusing to start BackgroundGeolocation on boot"));
                return;
            }
            if (tSConfig.getStartOnBoot().booleanValue()) {
                if (tSConfig.getSchedulerEnabled().booleanValue()) {
                    backgroundGeolocation.startSchedule();
                }
                if (tSConfig.getEnabled().booleanValue()) {
                    backgroundGeolocation.startOnBoot();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Context context, Intent intent) {
        TSConfig tSConfig = TSConfig.getInstance(context.getApplicationContext());
        String action = intent.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append(TSLog.header("BootReceiver: " + context.getPackageName()));
        sb.append(TSLog.boxRow(action));
        TSLog.logger.info(sb.toString());
        if (action == null) {
            TSLog.warn(TSLog.warn("BootReceiver executed with no Intent action!"));
            return;
        }
        if (action.equalsIgnoreCase("android.intent.action.BOOT_COMPLETED") || action.equalsIgnoreCase("android.intent.action.LOCKED_BOOT_COMPLETED")) {
            tSConfig.setDidDeviceReboot(true);
            a(context, intent);
        } else if (action.equalsIgnoreCase("android.intent.action.MY_PACKAGE_REPLACED")) {
            a(context, intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.BootReceiver$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(context, intent);
            }
        });
    }
}
