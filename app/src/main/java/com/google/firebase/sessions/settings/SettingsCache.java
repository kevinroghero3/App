package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SettingsCache {

    @Deprecated
    public static final String TAG = "SettingsCache";
    private final DataStore<Preferences> dataStore;
    private SessionConfigs sessionConfigs;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final Preferences.Key<Boolean> SESSIONS_ENABLED = PreferencesKeys.booleanKey(LocalOverrideSettings.SESSIONS_ENABLED);

    @Deprecated
    private static final Preferences.Key<Double> SAMPLING_RATE = PreferencesKeys.doubleKey(LocalOverrideSettings.SAMPLING_RATE);

    @Deprecated
    private static final Preferences.Key<Integer> RESTART_TIMEOUT_SECONDS = PreferencesKeys.intKey("firebase_sessions_restart_timeout");

    @Deprecated
    private static final Preferences.Key<Integer> CACHE_DURATION_SECONDS = PreferencesKeys.intKey("firebase_sessions_cache_duration");

    @Deprecated
    private static final Preferences.Key<Long> CACHE_UPDATED_TIME = PreferencesKeys.longKey("firebase_sessions_cache_updated_time");

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", i = {}, l = {112}, m = "updateConfigValue", n = {}, s = {})
    static final class C03341<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C03341(Continuation<? super C03341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SettingsCache.this.updateConfigValue(null, null, this);
        }
    }

    public SettingsCache(@NotNull DataStore<Preferences> dataStore) throws InterruptedException {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.dataStore = dataStore;
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCache$1, reason: invalid class name */
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SettingsCache.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            SettingsCache settingsCache;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SettingsCache settingsCache2 = SettingsCache.this;
                Flow data = settingsCache2.dataStore.getData();
                this.L$0 = settingsCache2;
                this.label = 1;
                Object objFirst = FlowKt.first(data, this);
                if (objFirst == coroutine_suspended) {
                    return coroutine_suspended;
                }
                settingsCache = settingsCache2;
                obj = objFirst;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                settingsCache = (SettingsCache) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            settingsCache.updateSessionConfigs(((Preferences) obj).toPreferences());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSessionConfigs(Preferences preferences) {
        this.sessionConfigs = new SessionConfigs((Boolean) preferences.get(SESSIONS_ENABLED), (Double) preferences.get(SAMPLING_RATE), (Integer) preferences.get(RESTART_TIMEOUT_SECONDS), (Integer) preferences.get(CACHE_DURATION_SECONDS), (Long) preferences.get(CACHE_UPDATED_TIME));
    }

    public final boolean hasCacheExpired$com_google_firebase_firebase_sessions() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        SessionConfigs sessionConfigs2 = null;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        Long cacheUpdatedTime = sessionConfigs.getCacheUpdatedTime();
        SessionConfigs sessionConfigs3 = this.sessionConfigs;
        if (sessionConfigs3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
        } else {
            sessionConfigs2 = sessionConfigs3;
        }
        Integer cacheDuration = sessionConfigs2.getCacheDuration();
        return cacheUpdatedTime == null || cacheDuration == null || (System.currentTimeMillis() - cacheUpdatedTime.longValue()) / ((long) 1000) >= ((long) cacheDuration.intValue());
    }

    public final Boolean sessionsEnabled() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionEnabled();
    }

    public final Double sessionSamplingRate() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionSamplingRate();
    }

    public final Integer sessionRestartTimeout() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionRestartTimeout();
    }

    public final Object updateSettingsEnabled(@Nullable Boolean bool, @NotNull Continuation<? super Unit> continuation) {
        Object objUpdateConfigValue = updateConfigValue(SESSIONS_ENABLED, bool, continuation);
        return objUpdateConfigValue == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSamplingRate(@Nullable Double d, @NotNull Continuation<? super Unit> continuation) {
        Object objUpdateConfigValue = updateConfigValue(SAMPLING_RATE, d, continuation);
        return objUpdateConfigValue == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSessionRestartTimeout(@Nullable Integer num, @NotNull Continuation<? super Unit> continuation) {
        Object objUpdateConfigValue = updateConfigValue(RESTART_TIMEOUT_SECONDS, num, continuation);
        return objUpdateConfigValue == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSessionCacheDuration(@Nullable Integer num, @NotNull Continuation<? super Unit> continuation) {
        Object objUpdateConfigValue = updateConfigValue(CACHE_DURATION_SECONDS, num, continuation);
        return objUpdateConfigValue == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSessionCacheUpdatedTime(@Nullable Long l, @NotNull Continuation<? super Unit> continuation) {
        Object objUpdateConfigValue = updateConfigValue(CACHE_UPDATED_TIME, l, continuation);
        return objUpdateConfigValue == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigValue : Unit.INSTANCE;
    }

    public final Object removeConfigs$com_google_firebase_firebase_sessions(@NotNull Continuation<? super Unit> continuation) {
        Object objEdit = PreferencesKt.edit(this.dataStore, new SettingsCache$removeConfigs$2(this, null), continuation);
        return objEdit == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEdit : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final <T> Object updateConfigValue(Preferences.Key<T> key, T t, Continuation<? super Unit> continuation) {
        C03341 c03341;
        if (continuation instanceof C03341) {
            c03341 = (C03341) continuation;
            int i = c03341.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03341.label = i - Integer.MIN_VALUE;
            } else {
                c03341 = new C03341(continuation);
            }
        } else {
            c03341 = new C03341(continuation);
        }
        Object obj = c03341.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c03341.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                DataStore<Preferences> dataStore = this.dataStore;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(t, key, this, null);
                c03341.label = 1;
                if (PreferencesKt.edit(dataStore, anonymousClass2, c03341) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (IOException e) {
            SentryLogcatAdapter.w(TAG, "Failed to update cache config value: " + e);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2, reason: invalid class name */
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2", f = "SettingsCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        final /* synthetic */ Preferences.Key<T> $key;
        final /* synthetic */ T $value;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SettingsCache this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(T t, Preferences.Key<T> key, SettingsCache settingsCache, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$value = t;
            this.$key = key;
            this.this$0 = settingsCache;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$value, this.$key, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(@NotNull MutablePreferences mutablePreferences, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            T t = this.$value;
            if (t != 0) {
                mutablePreferences.set(this.$key, t);
            } else {
                mutablePreferences.remove(this.$key);
            }
            this.this$0.updateSessionConfigs(mutablePreferences);
            return Unit.INSTANCE;
        }
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Preferences.Key<Boolean> getSESSIONS_ENABLED() {
            return SettingsCache.SESSIONS_ENABLED;
        }

        public final Preferences.Key<Double> getSAMPLING_RATE() {
            return SettingsCache.SAMPLING_RATE;
        }

        public final Preferences.Key<Integer> getRESTART_TIMEOUT_SECONDS() {
            return SettingsCache.RESTART_TIMEOUT_SECONDS;
        }

        public final Preferences.Key<Integer> getCACHE_DURATION_SECONDS() {
            return SettingsCache.CACHE_DURATION_SECONDS;
        }

        public final Preferences.Key<Long> getCACHE_UPDATED_TIME() {
            return SettingsCache.CACHE_UPDATED_TIME;
        }
    }
}
