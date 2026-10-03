package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes5.dex */
public class URLWrapper {
    private final URL zza;

    public URLWrapper(@NonNull String str) throws MalformedURLException {
        this.zza = new URL(str);
    }

    public URLConnection openConnection() throws IOException {
        return (URLConnection) FirebasePerfUrlConnection.instrument(this.zza.openConnection());
    }
}
