package com.facebook.appevents.ml;

import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ModelManager$$ExternalSyntheticLambda1 implements Runnable {
    public static int newSessionWithExtras;
    public static int receiveFile;

    @Override // java.lang.Runnable
    public final void run() {
        ModelManager.enableMTML$lambda$2();
    }

    public static int artificialFrame() {
        int i = receiveFile;
        int i2 = i % 9702216;
        receiveFile = i + 1;
        if (i2 != 0) {
            return newSessionWithExtras;
        }
        int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
        newSessionWithExtras = startElapsedRealtime;
        return startElapsedRealtime;
    }
}
