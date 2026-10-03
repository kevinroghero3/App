package com.salesforce.marketingcloud.events.predicates;

import com.facebook.hermes.intl.Constants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final f b = new a();
    public static final f c = new b();
    private static final String d = com.salesforce.marketingcloud.g.a("Predicate");
    private Boolean a;

    class a extends f {
        a() {
        }

        @Override // com.salesforce.marketingcloud.events.predicates.f
        protected boolean a() {
            return true;
        }

        @Override // com.salesforce.marketingcloud.events.predicates.f
        protected String c() {
            return "true";
        }
    }

    class b extends f {
        b() {
        }

        @Override // com.salesforce.marketingcloud.events.predicates.f
        protected boolean a() {
            return false;
        }

        @Override // com.salesforce.marketingcloud.events.predicates.f
        protected String c() {
            return Constants.CASEFIRST_FALSE;
        }
    }

    protected abstract boolean a();

    public final boolean b() {
        if (this.a == null) {
            this.a = Boolean.valueOf(a());
        }
        com.salesforce.marketingcloud.g.d(d, "%s %s", c(), this.a.booleanValue() ? "passed" : "failed");
        return this.a.booleanValue();
    }

    protected abstract String c();
}
