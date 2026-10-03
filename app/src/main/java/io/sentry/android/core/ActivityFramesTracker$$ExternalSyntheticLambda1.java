package io.sentry.android.core;

import android.os.Process;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ActivityFramesTracker$$ExternalSyntheticLambda1 implements Runnable {
    public static int j;
    public static int k;
    public final /* synthetic */ ActivityFramesTracker f$0;
    public final /* synthetic */ Runnable f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ ActivityFramesTracker$$ExternalSyntheticLambda1(ActivityFramesTracker activityFramesTracker, Runnable runnable, String str) {
        this.f$0 = activityFramesTracker;
        this.f$1 = runnable;
        this.f$2 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.lambda$runSafelyOnUiThread$3(this.f$1, this.f$2);
    }

    public static int l() {
        int i = j;
        int i2 = i % 6158741;
        j = i + 1;
        if (i2 != 0) {
            return k;
        }
        int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
        k = startElapsedRealtime;
        return startElapsedRealtime;
    }
}
