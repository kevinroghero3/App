package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class d extends com.salesforce.marketingcloud.internal.i {
    private final com.salesforce.marketingcloud.storage.a c;
    private final String[] d;

    public d(@NonNull com.salesforce.marketingcloud.storage.a aVar, @NonNull String[] strArr) {
        super("delete_analytics", new Object[0]);
        this.c = aVar;
        this.d = strArr;
    }

    @Override // com.salesforce.marketingcloud.internal.i
    public void a() {
        this.c.a(this.d);
    }
}
