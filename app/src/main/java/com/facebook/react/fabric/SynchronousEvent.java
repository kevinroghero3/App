package com.facebook.react.fabric;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class SynchronousEvent {
    private final String eventName;
    private final int surfaceId;
    private final int viewTag;

    public static /* synthetic */ SynchronousEvent copy$default(SynchronousEvent synchronousEvent, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = synchronousEvent.surfaceId;
        }
        if ((i3 & 2) != 0) {
            i2 = synchronousEvent.viewTag;
        }
        if ((i3 & 4) != 0) {
            str = synchronousEvent.eventName;
        }
        return synchronousEvent.copy(i, i2, str);
    }

    public final int component1() {
        return this.surfaceId;
    }

    public final int component2() {
        return this.viewTag;
    }

    public final String component3() {
        return this.eventName;
    }

    public final SynchronousEvent copy(int i, int i2, @NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new SynchronousEvent(i, i2, eventName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SynchronousEvent)) {
            return false;
        }
        SynchronousEvent synchronousEvent = (SynchronousEvent) obj;
        return this.surfaceId == synchronousEvent.surfaceId && this.viewTag == synchronousEvent.viewTag && Intrinsics.areEqual(this.eventName, synchronousEvent.eventName);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.surfaceId) * 31) + Integer.hashCode(this.viewTag)) * 31) + this.eventName.hashCode();
    }

    public String toString() {
        return "SynchronousEvent(surfaceId=" + this.surfaceId + ", viewTag=" + this.viewTag + ", eventName=" + this.eventName + ")";
    }

    public SynchronousEvent(int i, int i2, @NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.surfaceId = i;
        this.viewTag = i2;
        this.eventName = eventName;
    }

    public final int getSurfaceId() {
        return this.surfaceId;
    }

    public final int getViewTag() {
        return this.viewTag;
    }

    public final String getEventName() {
        return this.eventName;
    }
}
