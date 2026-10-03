package com.google.firebase.sessions.settings;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public interface SettingsProvider {
    Double getSamplingRate();

    Boolean getSessionEnabled();

    /* JADX INFO: renamed from: getSessionRestartTimeout-FghU774 */
    Duration mo5017getSessionRestartTimeoutFghU774();

    boolean isSettingsStale();

    Object updateSettings(@NotNull Continuation<? super Unit> continuation);

    public static final class DefaultImpls {
        public static boolean isSettingsStale(@NotNull SettingsProvider settingsProvider) {
            return false;
        }

        public static Object updateSettings(@NotNull SettingsProvider settingsProvider, @NotNull Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }
    }
}
