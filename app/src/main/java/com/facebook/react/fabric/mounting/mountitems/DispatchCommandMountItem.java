package com.facebook.react.fabric.mounting.mountitems;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DispatchCommandMountItem implements MountItem {
    private int numRetries;

    public final void incrementRetries() {
        this.numRetries++;
    }

    public final int getRetries() {
        return this.numRetries;
    }
}
