package com.salesforce.marketingcloud.storage;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    int a();

    void a(@NonNull com.salesforce.marketingcloud.analytics.stats.b bVar, @NonNull Crypto crypto) throws Exception;

    void a(@NonNull String[] strArr, @NonNull Boolean bool);

    void c(@NonNull String[] strArr);

    int f();

    List<com.salesforce.marketingcloud.analytics.stats.b> i(@NonNull Crypto crypto);

    List<com.salesforce.marketingcloud.analytics.stats.b> j(@NonNull Crypto crypto);

    List<com.salesforce.marketingcloud.analytics.stats.b> n(@NonNull Crypto crypto);
}
