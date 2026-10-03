package com.google.crypto.tink;

import android.os.Process;
import com.google.crypto.tink.internal.MonitoringAnnotations;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class KeysetHandle$$ExternalSyntheticLambda0 implements KeysetHandle.Entry.EntryConsumer {
    public static int MediaBrowserCompatCustomActionResultReceiver;
    public static int MediaBrowserCompatItemCallback;
    public final /* synthetic */ KeysetHandle f$0;
    public final /* synthetic */ MonitoringAnnotations f$1;

    public /* synthetic */ KeysetHandle$$ExternalSyntheticLambda0(KeysetHandle keysetHandle, MonitoringAnnotations monitoringAnnotations) {
        this.f$0 = keysetHandle;
        this.f$1 = monitoringAnnotations;
    }

    @Override // com.google.crypto.tink.KeysetHandle.Entry.EntryConsumer
    public final void accept(KeysetHandle.Entry entry) {
        KeysetHandle.lambda$addMonitoringIfNeeded$0(this.f$0, this.f$1, entry);
    }

    public static int onExtraCallback() {
        int i = MediaBrowserCompatCustomActionResultReceiver;
        int i2 = i % 5731756;
        MediaBrowserCompatCustomActionResultReceiver = i + 1;
        if (i2 != 0) {
            return MediaBrowserCompatItemCallback;
        }
        int iMyTid = Process.myTid();
        MediaBrowserCompatItemCallback = iMyTid;
        return iMyTid;
    }
}
