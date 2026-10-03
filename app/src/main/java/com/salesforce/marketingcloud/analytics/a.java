package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.util.Crypto;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.salesforce.marketingcloud.internal.i {
    private final com.salesforce.marketingcloud.storage.a c;
    private final Crypto d;
    private final b e;

    public a(@NonNull com.salesforce.marketingcloud.storage.a aVar, @NonNull Crypto crypto, @NonNull b bVar) {
        super("add_analytic", new Object[0]);
        this.c = aVar;
        this.d = crypto;
        this.e = bVar;
    }

    @Override // com.salesforce.marketingcloud.internal.i
    public void a() {
        try {
            this.c.a(this.e, this.d);
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.b(AnalyticsManager.TAG, e, "Unable to record analytic [%d].", Integer.valueOf(this.e.a()));
        }
    }
}
