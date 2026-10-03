package com.salesforce.marketingcloud.storage;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.util.Crypto;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public interface e {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    int a(@NonNull InAppMessage inAppMessage, @NonNull Crypto crypto) throws Exception;

    int a(@NonNull Collection<String> collection);

    InAppMessage a(@NonNull String str, @NonNull Crypto crypto);

    InAppMessage a(@NonNull Collection<String> collection, @NonNull Crypto crypto);

    void a(@NonNull InAppMessage inAppMessage);

    void b(@NonNull String str, int i);

    JSONArray c(@NonNull Crypto crypto);

    List<String> d(@NonNull Crypto crypto);
}
