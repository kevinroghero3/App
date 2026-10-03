package com.salesforce.marketingcloud.events;

import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Event {
    private final String a;
    private final Map<String, Object> b;
    private final com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer c;

    public b(@NotNull String name, @NotNull Map<String, ? extends Object> attributes, @NotNull com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer producer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(producer, "producer");
        this.a = name;
        this.b = attributes;
        this.c = producer;
    }

    public final Map<String, Object> a() {
        return this.b;
    }

    @Override // com.salesforce.marketingcloud.events.Event
    public Map<String, Object> attributes() {
        return this.b;
    }

    @Override // com.salesforce.marketingcloud.events.Event
    public com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer getProducer() {
        return this.c;
    }

    @Override // com.salesforce.marketingcloud.events.Event
    public String name() {
        return this.a;
    }

    public /* synthetic */ b(String str, Map map, com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer producer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i & 4) != 0 ? com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer.PUSH : producer);
    }
}
