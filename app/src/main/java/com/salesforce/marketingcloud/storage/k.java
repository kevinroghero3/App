package com.salesforce.marketingcloud.storage;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.registration.Registration;
import com.salesforce.marketingcloud.util.Crypto;

/* JADX INFO: loaded from: classes3.dex */
public interface k {
    void a(Registration registration, @NonNull Crypto crypto) throws Exception;

    int b(Registration registration, @NonNull Crypto crypto) throws Exception;

    int c();

    Registration k(@NonNull Crypto crypto) throws Exception;

    int n();
}
