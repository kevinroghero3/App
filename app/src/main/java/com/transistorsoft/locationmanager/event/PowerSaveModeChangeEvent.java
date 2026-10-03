package com.transistorsoft.locationmanager.event;

/* JADX INFO: loaded from: classes.dex */
public class PowerSaveModeChangeEvent {
    Boolean a;

    public PowerSaveModeChangeEvent(Boolean bool) {
        this.a = bool;
    }

    public Boolean isPowerSaveMode() {
        return this.a;
    }
}
