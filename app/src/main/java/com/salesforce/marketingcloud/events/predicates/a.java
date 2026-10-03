package com.salesforce.marketingcloud.events.predicates;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class a extends f {
    private final f[] e;

    public a(@NonNull f... fVarArr) {
        this.e = fVarArr;
    }

    @Override // com.salesforce.marketingcloud.events.predicates.f
    protected boolean a() {
        for (f fVar : this.e) {
            if (!fVar.b()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.salesforce.marketingcloud.events.predicates.f
    protected String c() {
        return "And";
    }
}
