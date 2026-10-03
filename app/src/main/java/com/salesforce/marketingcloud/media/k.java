package com.salesforce.marketingcloud.media;

/* JADX INFO: loaded from: classes3.dex */
public class k extends IllegalStateException {
    final t b;

    k(t tVar) {
        super("Cannot handle request: " + tVar);
        this.b = tVar;
    }
}
