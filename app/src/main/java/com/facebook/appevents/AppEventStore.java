package com.facebook.appevents;

import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class AppEventStore {
    public static final AppEventStore INSTANCE = new AppEventStore();
    private static final String TAG = AppEventStore.class.getName();

    private AppEventStore() {
    }

    @JvmStatic
    public static final void persistEvents(@NotNull AccessTokenAppIdPair accessTokenAppIdPair, @NotNull SessionEventsState appEvents) {
        synchronized (AppEventStore.class) {
            if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
                Intrinsics.checkNotNullParameter(appEvents, "appEvents");
                AppEventUtility.assertIsNotMainThread();
                PersistedEvents andClearStore = AppEventDiskStore.readAndClearStore();
                andClearStore.addEvents(accessTokenAppIdPair, appEvents.getEventsToPersist());
                AppEventDiskStore.saveEventsToDisk$facebook_core_release(andClearStore);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, AppEventStore.class);
            }
        }
    }

    @JvmStatic
    public static final void persistEvents(@NotNull AppEventCollection eventsToPersist) {
        synchronized (AppEventStore.class) {
            if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(eventsToPersist, "eventsToPersist");
                AppEventUtility.assertIsNotMainThread();
                PersistedEvents andClearStore = AppEventDiskStore.readAndClearStore();
                for (AccessTokenAppIdPair accessTokenAppIdPair : eventsToPersist.keySet()) {
                    SessionEventsState sessionEventsState = eventsToPersist.get(accessTokenAppIdPair);
                    if (sessionEventsState == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    andClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                }
                AppEventDiskStore.saveEventsToDisk$facebook_core_release(andClearStore);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, AppEventStore.class);
            }
        }
    }
}
