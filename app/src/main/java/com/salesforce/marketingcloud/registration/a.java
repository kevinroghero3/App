package com.salesforce.marketingcloud.registration;

import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.i;
import com.salesforce.marketingcloud.storage.k;
import com.salesforce.marketingcloud.util.Crypto;

/* JADX INFO: loaded from: classes3.dex */
public class a extends i {
    private final k c;
    private final Crypto d;
    private final Registration e;
    private final boolean f;

    a(k kVar, Crypto crypto, Registration registration, boolean z) {
        super(z ? "update_registration" : "add_registration", new Object[0]);
        this.c = kVar;
        this.d = crypto;
        this.e = registration;
        this.f = z;
    }

    @Override // com.salesforce.marketingcloud.internal.i
    public void a() {
        try {
            if (this.f) {
                this.c.b(this.e, this.d);
            } else {
                this.c.a(this.e, this.d);
            }
        } catch (Exception e) {
            g.b(RegistrationManager.a, e, "Unable to %s registration", this.f ? "update" : "add");
        }
    }
}
