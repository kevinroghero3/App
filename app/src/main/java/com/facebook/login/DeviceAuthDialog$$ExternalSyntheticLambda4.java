package com.facebook.login;

import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DeviceAuthDialog$$ExternalSyntheticLambda4 implements Runnable {
    public static int ITrustedWebActivityService;
    public static int getActiveNotifications;
    public final /* synthetic */ DeviceAuthDialog f$0;

    public /* synthetic */ DeviceAuthDialog$$ExternalSyntheticLambda4(DeviceAuthDialog deviceAuthDialog) {
        this.f$0 = deviceAuthDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeviceAuthDialog.schedulePoll$lambda$3(this.f$0);
    }

    public static int onPostMessage() {
        int i = ITrustedWebActivityService;
        int i2 = i % 8306215;
        ITrustedWebActivityService = i + 1;
        if (i2 != 0) {
            return getActiveNotifications;
        }
        int iMyTid = Process.myTid();
        getActiveNotifications = iMyTid;
        return iMyTid;
    }
}
