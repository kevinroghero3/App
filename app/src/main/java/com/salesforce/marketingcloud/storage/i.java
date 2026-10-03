package com.salesforce.marketingcloud.storage;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface i {
    int a(@NonNull String str);

    int a(@NonNull String str, int i);

    Message a(@NonNull String str, @NonNull Crypto crypto);

    List<Message> a(@NonNull Crypto crypto);

    void a(@NonNull Message message, @NonNull Crypto crypto) throws Exception;

    List<Message> b(@NonNull Crypto crypto);

    int e(int i);
}
