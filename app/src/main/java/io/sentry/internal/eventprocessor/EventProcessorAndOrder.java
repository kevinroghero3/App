package io.sentry.internal.eventprocessor;

import io.sentry.EventProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class EventProcessorAndOrder implements Comparable<EventProcessorAndOrder> {
    private final EventProcessor eventProcessor;
    private final Long order;

    public EventProcessorAndOrder(@NotNull EventProcessor eventProcessor, @Nullable Long l) {
        this.eventProcessor = eventProcessor;
        if (l == null) {
            this.order = Long.valueOf(System.nanoTime());
        } else {
            this.order = l;
        }
    }

    public EventProcessor getEventProcessor() {
        return this.eventProcessor;
    }

    public Long getOrder() {
        return this.order;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull EventProcessorAndOrder eventProcessorAndOrder) {
        return this.order.compareTo(eventProcessorAndOrder.order);
    }
}
