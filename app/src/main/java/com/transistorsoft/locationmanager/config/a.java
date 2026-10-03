package com.transistorsoft.locationmanager.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class a {
    private final List<String> a = new ArrayList();
    private final String b;

    a(String str) {
        this.b = str;
    }

    void a(String str) {
        this.a.add(this.b + "." + str);
    }

    public List<String> getDirtyFields() {
        return this.a;
    }

    void a() {
        this.a.clear();
    }
}
