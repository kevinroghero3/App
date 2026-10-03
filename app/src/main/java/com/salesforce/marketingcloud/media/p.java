package com.salesforce.marketingcloud.media;

import android.widget.ImageView;
import java.lang.ref.Reference;

/* JADX INFO: loaded from: classes3.dex */
public class p extends a<ImageView> {
    f f;

    public p(o oVar, w<ImageView> wVar, t tVar, f fVar) {
        super(oVar, wVar, tVar);
        this.f = fVar;
    }

    @Override // com.salesforce.marketingcloud.media.a
    void a(v.b bVar) {
        Reference reference = this.b;
        ImageView imageView = reference != null ? (ImageView) reference.get() : null;
        if (imageView == null) {
            return;
        }
        l.a(imageView, b().a, bVar);
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
