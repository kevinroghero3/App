package com.facebook.internal;

import android.os.Process;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class FileLruCache$BufferFile$$ExternalSyntheticLambda1 implements FilenameFilter {
    public static int IPostMessageServiceStubProxy;
    public static int s;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return FileLruCache.BufferFile.filterExcludeNonBufferFiles$lambda$1(file, str);
    }

    public static int onNavigationEvent() {
        int i = s;
        int i2 = i % 8803015;
        s = i + 1;
        if (i2 != 0) {
            return IPostMessageServiceStubProxy;
        }
        int iMyTid = Process.myTid();
        IPostMessageServiceStubProxy = iMyTid;
        return iMyTid;
    }
}
