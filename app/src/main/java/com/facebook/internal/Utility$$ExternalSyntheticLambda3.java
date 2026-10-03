package com.facebook.internal;

import android.os.Process;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Utility$$ExternalSyntheticLambda3 implements FilenameFilter {
    public static int ITrustedWebActivityCallbackStubProxy;
    public static int areNotificationsEnabled;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return Utility.refreshBestGuessNumberOfCPUCores$lambda$4(file, str);
    }

    public static int ICustomTabsCallbackDefault() {
        int i = areNotificationsEnabled;
        int i2 = i % 5967696;
        areNotificationsEnabled = i + 1;
        if (i2 != 0) {
            return ITrustedWebActivityCallbackStubProxy;
        }
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        ITrustedWebActivityCallbackStubProxy = elapsedCpuTime;
        return elapsedCpuTime;
    }
}
