package com.google.firebase.messaging;

import android.os.Process;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FirebaseMessaging$$ExternalSyntheticLambda14 implements Runnable {
    public static int getStateLabel;
    public static int isCurrent;
    public final /* synthetic */ FirebaseMessaging f$0;

    public /* synthetic */ FirebaseMessaging$$ExternalSyntheticLambda14(FirebaseMessaging firebaseMessaging) {
        this.f$0 = firebaseMessaging;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.lambda$new$4();
    }

    public static int j_() {
        int i = isCurrent;
        int i2 = i % 9771094;
        isCurrent = i + 1;
        if (i2 != 0) {
            return getStateLabel;
        }
        int iMyPid = Process.myPid();
        getStateLabel = iMyPid;
        return iMyPid;
    }
}
