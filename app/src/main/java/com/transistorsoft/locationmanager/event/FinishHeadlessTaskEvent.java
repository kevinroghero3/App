package com.transistorsoft.locationmanager.event;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class FinishHeadlessTaskEvent {
    private Context a;
    private int b;

    public FinishHeadlessTaskEvent(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    public Context getContext() {
        return this.a;
    }

    public int getTaskId() {
        return this.b;
    }
}
