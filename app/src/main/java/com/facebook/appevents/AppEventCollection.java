package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AppEventCollection {
    private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap = new HashMap<>();

    public final void addPersistedEvents(@Nullable PersistedEvents persistedEvents) {
        synchronized (this) {
            if (persistedEvents == null) {
                return;
            }
            for (Map.Entry<AccessTokenAppIdPair, List<AppEvent>> entry : persistedEvents.entrySet()) {
                SessionEventsState sessionEventsState = getSessionEventsState(entry.getKey());
                if (sessionEventsState != null) {
                    Iterator<AppEvent> it2 = entry.getValue().iterator();
                    while (it2.hasNext()) {
                        sessionEventsState.addEvent(it2.next());
                    }
                }
            }
        }
    }

    public final void addEvent(@NotNull AccessTokenAppIdPair accessTokenAppIdPair, @NotNull AppEvent appEvent) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
            Intrinsics.checkNotNullParameter(appEvent, "appEvent");
            SessionEventsState sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
            if (sessionEventsState != null) {
                sessionEventsState.addEvent(appEvent);
            }
        }
    }

    public final Set<AccessTokenAppIdPair> keySet() {
        Set<AccessTokenAppIdPair> setKeySet;
        synchronized (this) {
            setKeySet = this.stateMap.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "stateMap.keys");
        }
        return setKeySet;
    }

    public final SessionEventsState get(@NotNull AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        synchronized (this) {
            Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
            sessionEventsState = this.stateMap.get(accessTokenAppIdPair);
        }
        return sessionEventsState;
    }

    public final int getEventCount() {
        int accumulatedEventCount;
        synchronized (this) {
            Iterator<SessionEventsState> it2 = this.stateMap.values().iterator();
            accumulatedEventCount = 0;
            while (it2.hasNext()) {
                accumulatedEventCount += it2.next().getAccumulatedEventCount();
            }
        }
        return accumulatedEventCount;
    }

    private final SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        Context applicationContext;
        AttributionIdentifiers attributionIdentifiers;
        synchronized (this) {
            SessionEventsState sessionEventsState = this.stateMap.get(accessTokenAppIdPair);
            if (sessionEventsState == null && (attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers((applicationContext = FacebookSdk.getApplicationContext()))) != null) {
                sessionEventsState = new SessionEventsState(attributionIdentifiers, AppEventsLogger.Companion.getAnonymousAppDeviceGUID(applicationContext));
            }
            if (sessionEventsState == null) {
                return null;
            }
            this.stateMap.put(accessTokenAppIdPair, sessionEventsState);
            return sessionEventsState;
        }
    }
}
