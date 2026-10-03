package com.salesforce.marketingcloud.media;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class b implements f {
    private static final String g = com.salesforce.marketingcloud.g.a("BatchRequestHandler");
    private final AtomicInteger a;
    private final o b;
    private final List<String> c;
    private a d;
    private boolean e;
    private boolean f;

    public interface a {
        void a(boolean z);
    }

    public b(o oVar, List<String> list) {
        this.b = oVar;
        this.c = list;
        this.a = new AtomicInteger(list.size());
    }

    private void c() {
        a aVar;
        if (this.a.decrementAndGet() > 0 || (aVar = this.d) == null || this.e) {
            return;
        }
        aVar.a(!this.f);
    }

    public void a(a aVar, boolean z) {
        this.d = aVar;
        if (this.a.get() == 0) {
            if (aVar != null) {
                aVar.a(true);
            }
        } else {
            for (String str : this.c) {
                if (z) {
                    this.b.b(str).a(t.b.NO_MEMORY_CACHE, t.b.NO_MEMORY_STORE).a(this);
                } else {
                    this.b.b(str).a(this);
                }
            }
        }
    }

    public void b() {
        this.e = true;
    }

    @Override // com.salesforce.marketingcloud.media.f
    public void a() {
        c();
    }

    @Override // com.salesforce.marketingcloud.media.f
    public void a(Exception exc) {
        if (exc instanceof k) {
            com.salesforce.marketingcloud.g.b(g, exc, "Failed to pre-fetch image, but will be ignored since the url cannot be handled.", new Object[0]);
        } else {
            this.f = true;
            com.salesforce.marketingcloud.g.b(g, exc, "Failed to pre-fetch image.", new Object[0]);
        }
        c();
    }
}
