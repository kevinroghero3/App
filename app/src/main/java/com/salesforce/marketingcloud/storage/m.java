package com.salesforce.marketingcloud.storage;

import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public interface m {
    void a(@NonNull com.salesforce.marketingcloud.events.h hVar) throws Exception;

    int b(@NonNull com.salesforce.marketingcloud.events.h hVar);

    int b(@NonNull Collection<String> collection);

    com.salesforce.marketingcloud.events.h b(@NonNull String str);

    List<com.salesforce.marketingcloud.events.h> g(@NonNull String str);

    void k();

    JSONArray m();
}
