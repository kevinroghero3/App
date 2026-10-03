package com.salesforce.marketingcloud.sfmcsdk.modules.cdp;

import com.salesforce.marketingcloud.sfmcsdk.modules.Module;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class CdpModule extends Module {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "~$CdpSdkModule";

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.Module
    public String getName() {
        return "CDP";
    }
}
