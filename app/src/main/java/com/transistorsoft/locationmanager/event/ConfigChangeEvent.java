package com.transistorsoft.locationmanager.event;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConfigChangeEvent {
    private final Context a;
    private final List<String> b;

    public ConfigChangeEvent(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.addAll(list);
        this.a = context;
    }

    public Context getContext() {
        return this.a;
    }

    public boolean isDirty(String str) {
        boolean zContains;
        synchronized (this.b) {
            zContains = this.b.contains(str);
        }
        return zContains;
    }

    public String toString() {
        return "Dirty: " + this.b.toString();
    }
}
