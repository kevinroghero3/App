package com.salesforce.marketingcloud.storage;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface j {
    Region a(String str, @NonNull Crypto crypto);

    List<Region> a(int i, Crypto crypto);

    void a(@NonNull Region region, @NonNull Crypto crypto) throws Exception;

    void a(@NonNull String str, boolean z);

    List<String> c(@NonNull String str, int i);

    List<String> d(int i);

    int f(int i);

    Region l(@NonNull Crypto crypto);

    void l();
}
