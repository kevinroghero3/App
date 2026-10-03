package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface BillingOrBuilder extends MessageLiteOrBuilder {
    Billing.BillingDestination getConsumerDestinations(int i);

    int getConsumerDestinationsCount();

    List<Billing.BillingDestination> getConsumerDestinationsList();
}
