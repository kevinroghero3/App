package com.salesforce.marketingcloud.media;

/* JADX INFO: loaded from: classes3.dex */
public class j extends a<Object> {
    private f f;

    j(o oVar, t tVar, f fVar) {
        super(oVar, null, tVar);
        this.f = fVar;
    }

    @Override // com.salesforce.marketingcloud.media.a
    void a(v.b bVar) {
        f fVar = this.f;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // com.salesforce.marketingcloud.media.a
    void a(Exception exc) {
        f fVar = this.f;
        if (fVar != null) {
            fVar.a(exc);
        }
    }

    @Override // com.salesforce.marketingcloud.media.a
    void a() {
        super.a();
        this.f = null;
    }
}
