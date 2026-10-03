package com.transistorsoft.tsbackgroundfetch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class FetchAlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        final PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "TSBackgroundFetch::" + intent.getAction());
        wakeLockNewWakeLock.acquire((long) (BGTask.MAX_TIME + 4000));
        BackgroundFetch.getInstance(context.getApplicationContext()).onFetch(new BGTask(context, intent.getAction(), new FetchJobService.CompletionHandler() { // from class: com.transistorsoft.tsbackgroundfetch.FetchAlarmReceiver.1
            @Override // com.transistorsoft.tsbackgroundfetch.FetchJobService.CompletionHandler
            public void finish() {
                if (wakeLockNewWakeLock.isHeld()) {
                    wakeLockNewWakeLock.release();
                    Log.d(BackgroundFetch.TAG, "- FetchAlarmReceiver finish");
                }
            }
        }, 0));
    }
}
