package com.transistorsoft.locationmanager.event;

import android.content.Context;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.http.HttpService;

/* JADX INFO: loaded from: classes3.dex */
public class HttpFlushEvent {
    public static final String ACTION = "http_flush";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context) {
        HttpService.getInstance(context).flush(true);
    }

    public static void run(final Context context) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (tSConfig.getEnabled().booleanValue() && tSConfig.getAutoSync().booleanValue() && tSConfig.hasUrl() && !tSConfig.getIsMoving().booleanValue()) {
            BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.event.HttpFlushEvent$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HttpFlushEvent.a(context);
                }
            });
        }
    }
}
