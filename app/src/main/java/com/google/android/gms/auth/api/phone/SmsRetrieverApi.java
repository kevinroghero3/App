package com.google.android.gms.auth.api.phone;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes4.dex */
public interface SmsRetrieverApi {
    Task<Void> startSmsRetriever();

    Task<Void> startSmsUserConsent(@Nullable String str);
}
