package com.hitachiapp.utils;

import android.util.Log;
import com.facebook.react.modules.network.OkHttpClientFactory;
import com.facebook.react.modules.network.OkHttpClientProvider;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public class OkHttpCustomClientFactory implements OkHttpClientFactory {
    private static final String TAG = "OkHttpCustomClientFactory";

    @Override // com.facebook.react.modules.network.OkHttpClientFactory
    public OkHttpClient createNewNetworkModuleClient() {
        Log.v(TAG, "Creating custom OkHttpClient");
        return OkHttpClientProvider.createClientBuilder().certificatePinner(new CertificatePinner.Builder().add("*.superdriver.it", "sha256/j7DMP+owF2YEMPJZnynzg+cWDnTt8YGGgARaIXwNR5Y=").add("*.autobus.it", "sha256/V1vHaS7CJiQ3014yFILlJCOgbwLU+522IWm83T4kI1A=").add("be.atm.it", "sha256/Is7EDnnxFPnd6gGSo4r1tOY4UiulcGoF4Psu2pNiHTM=").build()).build();
    }
}
