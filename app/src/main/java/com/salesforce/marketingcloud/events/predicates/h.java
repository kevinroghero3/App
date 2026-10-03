package com.salesforce.marketingcloud.events.predicates;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h<T> extends f {
    private static final String i = com.salesforce.marketingcloud.g.a("ValuePredicate");
    private final Object e;
    private final com.salesforce.marketingcloud.events.g.a f;
    private final Object g;
    private final String h;

    h(@Nullable Object obj, @NonNull com.salesforce.marketingcloud.events.g.a aVar, @Nullable Object obj2) {
        this.e = obj;
        this.f = aVar;
        this.g = obj2;
        this.h = String.format("%s %s %s", obj, aVar, obj2);
    }

    protected abstract T a(Object obj);

    @Override // com.salesforce.marketingcloud.events.predicates.f
    protected final boolean a() {
        try {
            return a(a(this.e), this.f, a(this.g));
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.b(i, e, "Unable to evaluate predicate.  Returning default value of 'false'", new Object[0]);
            return false;
        }
    }

    protected abstract boolean a(@Nullable T t, @NonNull com.salesforce.marketingcloud.events.g.a aVar, @Nullable T t2) throws UnsupportedOperationException;

    @Override // com.salesforce.marketingcloud.events.predicates.f
    protected String c() {
        return this.h;
    }
}
