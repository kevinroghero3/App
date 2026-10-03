package com.transistorsoft.locationmanager.event;

/* JADX INFO: loaded from: classes6.dex */
public class BatteryOptimizationEvent {
    private boolean a;

    public BatteryOptimizationEvent(boolean z) {
        this.a = z;
    }

    public boolean isIgnoringBatteryOptimizations() {
        return this.a;
    }
}
