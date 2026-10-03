package com.salesforce.marketingcloud.sfmcsdk;

/* JADX INFO: loaded from: classes3.dex */
public final class SFMCSdkInitializationStatus implements InitializationStatus {
    private final boolean success;

    public SFMCSdkInitializationStatus(boolean z) {
        this.success = z;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.InitializationStatus
    public int getStatus() {
        return this.success ? 1 : -1;
    }
}
