package com.salesforce.marketingcloud.sfmcsdk.components.events;

import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class EngagementEvent extends Event {
    private Event.Category category;
    private final String name;

    public /* synthetic */ EngagementEvent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private EngagementEvent(String str) {
        this.name = str;
        this.category = Event.Category.ENGAGEMENT;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public Map<String, Object> attributes() {
        return MapsKt__MapsKt.emptyMap();
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public String name() {
        return this.name;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.Event
    public Event.Category getCategory() {
        return this.category;
    }

    public void setCategory(@NotNull Event.Category category) {
        Intrinsics.checkNotNullParameter(category, "<set-?>");
        this.category = category;
    }
}
