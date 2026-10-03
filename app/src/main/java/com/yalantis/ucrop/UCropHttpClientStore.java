package com.yalantis.ucrop;

import androidx.annotation.NonNull;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public class UCropHttpClientStore {
    public static final UCropHttpClientStore INSTANCE = new UCropHttpClientStore();
    private OkHttpClient client;

    private UCropHttpClientStore() {
    }

    public OkHttpClient getClient() {
        if (this.client == null) {
            this.client = new OkHttpClient();
        }
        return this.client;
    }

    public void setClient(@NonNull OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }
}
