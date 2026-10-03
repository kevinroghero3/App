package androidx.camera.core.impl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class MetadataHolderService extends Service {
    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        throw new UnsupportedOperationException();
    }

    private MetadataHolderService() {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }
}
