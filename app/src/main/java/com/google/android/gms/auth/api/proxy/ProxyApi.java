package com.google.android.gms.auth.api.proxy;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes4.dex */
public interface ProxyApi {

    public interface ProxyResult extends Result {
        ProxyResponse getResponse();
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface SpatulaHeaderResult extends Result {
        String getSpatulaHeader();
    }

    @Deprecated
    PendingResult<SpatulaHeaderResult> getSpatulaHeader(@NonNull GoogleApiClient googleApiClient);

    @Deprecated
    PendingResult<ProxyResult> performProxyRequest(@NonNull GoogleApiClient googleApiClient, @NonNull ProxyRequest proxyRequest);
}
