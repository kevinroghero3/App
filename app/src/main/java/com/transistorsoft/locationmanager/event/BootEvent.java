package com.transistorsoft.locationmanager.event;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class BootEvent {
    private final Context a;
    private final Intent b;

    public BootEvent(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    Context a() {
        return this.a;
    }
}
