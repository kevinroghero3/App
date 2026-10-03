package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbm extends Api.AbstractClientBuilder {
    public static int disconnect;
    public static int getExtras;

    zzbm() {
    }

    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzda(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    public static int receiveFile() {
        int i = disconnect;
        int i2 = i % 8694140;
        disconnect = i + 1;
        if (i2 != 0) {
            return getExtras;
        }
        int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
        getExtras = iFreeMemory;
        return iFreeMemory;
    }
}
