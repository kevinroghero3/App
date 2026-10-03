package com.salesforce.marketingcloud.storage;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface a {
    int a();

    int a(int i);

    int a(String[] strArr);

    List<com.salesforce.marketingcloud.analytics.b> a(@NonNull Crypto crypto, int i);

    void a(com.salesforce.marketingcloud.analytics.b bVar, @NonNull Crypto crypto) throws Exception;

    int b(int i);

    int b(com.salesforce.marketingcloud.analytics.b bVar, @NonNull Crypto crypto) throws Exception;

    List<com.salesforce.marketingcloud.analytics.b> b(@NonNull Region region, @NonNull Crypto crypto);

    List<com.salesforce.marketingcloud.analytics.b> b(@NonNull Crypto crypto, int i);

    boolean c(int i);

    int d();

    int e();

    List<com.salesforce.marketingcloud.analytics.b> f(@NonNull Crypto crypto);

    int g(int i);

    List<com.salesforce.marketingcloud.analytics.b> g(@NonNull Crypto crypto);

    List<com.salesforce.marketingcloud.analytics.b> h(@NonNull Crypto crypto);
}
