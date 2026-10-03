package com.salesforce.marketingcloud.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements Runnable {
    public final String b;

    public i(@NonNull String str, @Nullable Object... objArr) {
        this.b = "mcsdk_" + String.format(Locale.US, str, objArr);
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.b);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
