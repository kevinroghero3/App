package com.google.android.gms.auth.api.proxy;

import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.AuthProxyOptions;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes4.dex */
public interface ProxyClient extends HasApiKey<AuthProxyOptions> {
    Task<String> getSpatulaHeader();

    Task<ProxyResponse> performProxyRequest(@NonNull ProxyRequest proxyRequest);
}
