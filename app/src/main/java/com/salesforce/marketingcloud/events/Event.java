package com.salesforce.marketingcloud.events;

import com.salesforce.marketingcloud.MarketingCloudSdk;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public interface Event {
    /* JADX INFO: Access modifiers changed from: private */
    static void track$lambda$0(Event this$0, MarketingCloudSdk it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        it2.getEventManager().track(this$0);
    }

    Map<String, Object> attributes();

    default com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer getProducer() {
        return com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer.PUSH;
    }

    String name();

    default void track() {
        MarketingCloudSdk.requestSdk(new MarketingCloudSdk.WhenReadyListener() { // from class: com.salesforce.marketingcloud.events.Event$$ExternalSyntheticLambda0
            @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
            public final void ready(MarketingCloudSdk marketingCloudSdk) {
                Event.track$lambda$0(this.f$0, marketingCloudSdk);
            }
        });
    }
}
