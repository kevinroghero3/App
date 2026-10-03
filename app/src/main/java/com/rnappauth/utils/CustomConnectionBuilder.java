package com.rnappauth.utils;

import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.openid.appauth.connectivity.ConnectionBuilder;

/* JADX INFO: loaded from: classes3.dex */
public final class CustomConnectionBuilder implements ConnectionBuilder {
    private ConnectionBuilder connectionBuilder;
    private int connectionTimeoutMs;
    private Map<String, String> headers = null;
    private int readTimeoutMs;

    public CustomConnectionBuilder(ConnectionBuilder connectionBuilder) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.connectionTimeoutMs = (int) timeUnit.toMillis(15L);
        this.readTimeoutMs = (int) timeUnit.toMillis(10L);
        this.connectionBuilder = connectionBuilder;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeoutMs = i;
        this.readTimeoutMs = i;
    }

    @Override // net.openid.appauth.connectivity.ConnectionBuilder
    public HttpURLConnection openConnection(@NonNull Uri uri) throws IOException {
        HttpURLConnection httpURLConnectionOpenConnection = this.connectionBuilder.openConnection(uri);
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnectionOpenConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        httpURLConnectionOpenConnection.setConnectTimeout(this.connectionTimeoutMs);
        httpURLConnectionOpenConnection.setReadTimeout(this.readTimeoutMs);
        return httpURLConnectionOpenConnection;
    }
}
