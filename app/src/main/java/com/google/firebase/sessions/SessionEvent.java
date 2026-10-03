package com.google.firebase.sessions;

import ch.qos.logback.core.CoreConstants;
import com.google.firebase.encoders.annotations.Encodable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Encodable
public final class SessionEvent {
    private final ApplicationInfo applicationInfo;
    private final EventType eventType;
    private final SessionInfo sessionData;

    public static /* synthetic */ SessionEvent copy$default(SessionEvent sessionEvent, EventType eventType, SessionInfo sessionInfo, ApplicationInfo applicationInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            eventType = sessionEvent.eventType;
        }
        if ((i & 2) != 0) {
            sessionInfo = sessionEvent.sessionData;
        }
        if ((i & 4) != 0) {
            applicationInfo = sessionEvent.applicationInfo;
        }
        return sessionEvent.copy(eventType, sessionInfo, applicationInfo);
    }

    public final EventType component1() {
        return this.eventType;
    }

    public final SessionInfo component2() {
        return this.sessionData;
    }

    public final ApplicationInfo component3() {
        return this.applicationInfo;
    }

    public final SessionEvent copy(@NotNull EventType eventType, @NotNull SessionInfo sessionData, @NotNull ApplicationInfo applicationInfo) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        return new SessionEvent(eventType, sessionData, applicationInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionEvent)) {
            return false;
        }
        SessionEvent sessionEvent = (SessionEvent) obj;
        return this.eventType == sessionEvent.eventType && Intrinsics.areEqual(this.sessionData, sessionEvent.sessionData) && Intrinsics.areEqual(this.applicationInfo, sessionEvent.applicationInfo);
    }

    public int hashCode() {
        return (((this.eventType.hashCode() * 31) + this.sessionData.hashCode()) * 31) + this.applicationInfo.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.eventType + ", sessionData=" + this.sessionData + ", applicationInfo=" + this.applicationInfo + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public SessionEvent(@NotNull EventType eventType, @NotNull SessionInfo sessionData, @NotNull ApplicationInfo applicationInfo) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        this.eventType = eventType;
        this.sessionData = sessionData;
        this.applicationInfo = applicationInfo;
    }

    public final EventType getEventType() {
        return this.eventType;
    }

    public final SessionInfo getSessionData() {
        return this.sessionData;
    }

    public final ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }
}
