package com.swmansion.worklets;

import android.os.Process;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class WorkletsMessageQueueThreadBase$$ExternalSyntheticLambda0 implements QueueThreadExceptionHandler {
    public static int MediaControllerCompatApi23;
    public static int getLegacyAudioStream;

    @Override // com.facebook.react.bridge.queue.QueueThreadExceptionHandler
    public final void handleException(Exception exc) {
        WorkletsMessageQueueThreadBase.lambda$new$0(exc);
    }

    public static int MediaBrowserCompatMediaBrowserImpl() {
        int i = MediaControllerCompatApi23;
        int i2 = i % 9943081;
        MediaControllerCompatApi23 = i + 1;
        if (i2 != 0) {
            return getLegacyAudioStream;
        }
        int iMyUid = Process.myUid();
        getLegacyAudioStream = iMyUid;
        return iMyUid;
    }
}
