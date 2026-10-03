package com.salesforce.marketingcloud.media;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> {
    final t a;
    final WeakReference<T> b;
    final w<T> c;
    private final o d;
    private boolean e;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.media.a$a, reason: collision with other inner class name */
    static class C0082a<M> extends WeakReference<M> {
        final a a;

        C0082a(a aVar, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.a = aVar;
        }
    }

    a(o oVar, w<T> wVar, t tVar) {
        this.d = oVar;
        this.a = tVar;
        if (wVar == null) {
            this.b = null;
        } else {
            this.b = new C0082a(this, wVar.a, oVar.h);
            wVar.a = null;
        }
        this.c = wVar;
    }

    void a() {
        this.e = true;
    }

    abstract void a(v.b bVar);

    abstract void a(Exception exc);

    o b() {
        return this.d;
    }

    public String c() {
        return this.a.b;
    }

    public o.c d() {
        return this.a.c;
    }

    t e() {
        return this.a;
    }

    T f() {
        WeakReference<T> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean g() {
        return this.e;
    }
}
