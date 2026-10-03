package com.salesforce.marketingcloud.sfmcsdk.components.events;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface EventSubscriber {
    void onEventPublished(@NotNull Event... eventArr);
}
