package it.aep_italia.vts.sdk.core;

import android.content.Intent;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSyncWorkerManager {
    private static VtsSyncWorkerManager a;
    public static Intent intent;
    public static VtsSyncService syncService;

    VtsSyncWorkerManager(VtsSyncService vtsSyncService, Intent intent2) {
        syncService = vtsSyncService;
    }

    public static VtsSyncWorkerManager getInstance() {
        if (a == null) {
            a = new VtsSyncWorkerManager(syncService, intent);
        }
        return a;
    }

    public Intent getIntent() {
        return intent;
    }

    public VtsSyncService getSyncService() {
        return syncService;
    }
}
