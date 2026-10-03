package com.salesforce.marketingcloud.analytics.stats;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.analytics.AnalyticsManager;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.i;
import com.salesforce.marketingcloud.util.Crypto;

/* JADX INFO: loaded from: classes3.dex */
public class a extends i {
    private final com.salesforce.marketingcloud.storage.c c;
    private final Crypto d;
    private final b e;

    public a(@NonNull com.salesforce.marketingcloud.storage.c cVar, @NonNull Crypto crypto, @NonNull b bVar) {
        super("add_device_stat", new Object[0]);
        this.c = cVar;
        this.d = crypto;
        this.e = bVar;
    }

    @Override // com.salesforce.marketingcloud.internal.i
    public void a() {
        try {
            this.c.a(this.e, this.d);
        } catch (Exception e) {
            g.b(AnalyticsManager.TAG, e, "Unable to record device stat [%d].", Integer.valueOf(this.e.d()));
        }
    }
}
