package com.salesforce.marketingcloud.sfmcsdk.components.events;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CustomEvent extends Event {
    private final Map<String, Object> attributes;
    private final Event.Category category;
    private final String name;
    private final Event.Producer producer;

    public /* synthetic */ CustomEvent(String str, Map map, Event.Producer producer, Event.Category category, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i & 4) != 0 ? Event.Producer.SFMC_SDK : producer, (i & 8) != 0 ? Event.Category.ENGAGEMENT : category);
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public Event.Producer getProducer() {
        return this.producer;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public Event.Category getCategory() {
        return this.category;
    }

    public CustomEvent(@NotNull String name, @NotNull Map<String, ? extends Object> attributes, @NotNull Event.Producer producer, @NotNull Event.Category category) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(producer, "producer");
        Intrinsics.checkNotNullParameter(category, "category");
        this.name = name;
        this.attributes = attributes;
        this.producer = producer;
        this.category = category;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public String name() {
        return this.name;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public Map<String, Object> attributes() {
        return this.attributes;
    }

    public String toString() {
        return "CustomEvent(name='" + this.name + "', producer=" + getProducer() + ", category=" + getCategory() + ", attributes=" + this.attributes + ")";
    }
}
