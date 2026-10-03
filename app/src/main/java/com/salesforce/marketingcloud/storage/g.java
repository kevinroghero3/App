package com.salesforce.marketingcloud.storage;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.util.Crypto;

/* JADX INFO: loaded from: classes3.dex */
public interface g {
    void a(@NonNull LatLon latLon, @NonNull Crypto crypto) throws Exception;

    LatLon e(@NonNull Crypto crypto);

    int g();
}
