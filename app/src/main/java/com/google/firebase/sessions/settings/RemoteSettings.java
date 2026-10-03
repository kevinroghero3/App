package com.google.firebase.sessions.settings;

import android.os.Build;
import android.util.Log;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.tasks.TasksKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String FORWARD_SLASH_STRING = "/";

    @Deprecated
    public static final String TAG = "SessionConfigFetcher";
    private final ApplicationInfo appInfo;
    private final CoroutineContext backgroundDispatcher;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final Mutex fetchInProgress;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final SettingsCache settingsCache;

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1, reason: invalid class name */
    @DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", i = {0, 0, 1, 1, 2}, l = {170, Base64.mimeLineLength, 94}, m = "updateSettings", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteSettings.this.updateSettings(this);
        }
    }

    public RemoteSettings(@NotNull CoroutineContext backgroundDispatcher, @NotNull FirebaseInstallationsApi firebaseInstallationsApi, @NotNull ApplicationInfo appInfo, @NotNull CrashlyticsSettingsFetcher configsFetcher, @NotNull DataStore<Preferences> dataStore) {
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(configsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.backgroundDispatcher = backgroundDispatcher;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.appInfo = appInfo;
        this.configsFetcher = configsFetcher;
        this.settingsCache = new SettingsCache(dataStore);
        this.fetchInProgress = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean getSessionEnabled() {
        return this.settingsCache.sessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /* JADX INFO: renamed from: getSessionRestartTimeout-FghU774 */
    public Duration mo5017getSessionRestartTimeoutFghU774() {
        Integer numSessionRestartTimeout = this.settingsCache.sessionRestartTimeout();
        if (numSessionRestartTimeout == null) {
            return null;
        }
        Duration.Companion companion = Duration.Companion;
        return Duration.m6829boximpl(DurationKt.toDuration(numSessionRestartTimeout.intValue(), DurationUnit.SECONDS));
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double getSamplingRate() {
        return this.settingsCache.sessionSamplingRate();
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00b4 A[Catch: all -> 0x0151, TRY_LEAVE, TryCatch #0 {all -> 0x0151, blocks: (B:21:0x004e, B:42:0x00b0, B:44:0x00b4, B:47:0x00bf, B:34:0x0085, B:36:0x008d, B:39:0x0098), top: B:58:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00bf A[Catch: all -> 0x0151, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0151, blocks: (B:21:0x004e, B:42:0x00b0, B:44:0x00b4, B:47:0x00bf, B:34:0x0085, B:36:0x008d, B:39:0x0098), top: B:58:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0147 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0148  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Object updateSettings(@NotNull Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
        RemoteSettings remoteSettings;
        String str;
        Map<String, String> mapMapOf;
        CrashlyticsSettingsFetcher crashlyticsSettingsFetcher;
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1;
        RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2;
        Mutex mutex2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = anonymousClass1.label;
        try {
            if (r4 == 0) {
                ResultKt.throwOnFailure(objAwait);
                if (!this.fetchInProgress.isLocked() && !this.settingsCache.hasCacheExpired$com_google_firebase_firebase_sessions()) {
                    return Unit.INSTANCE;
                }
                Mutex mutex3 = this.fetchInProgress;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = mutex3;
                anonymousClass1.label = 1;
                if (mutex3.lock(null, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex3;
                remoteSettings = this;
            } else {
                if (r4 != 1) {
                    if (r4 != 2) {
                        if (r4 == 3) {
                            mutex2 = (Mutex) anonymousClass1.L$0;
                            try {
                                ResultKt.throwOnFailure(objAwait);
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return unit;
                            } catch (Throwable th) {
                                th = th;
                                r4 = mutex2;
                                r4.unlock(null);
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex = (Mutex) anonymousClass1.L$1;
                    remoteSettings = (RemoteSettings) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objAwait);
                    str = (String) objAwait;
                    if (str == null) {
                        SentryLogcatAdapter.w(TAG, "Error getting Firebase Installation ID. Skipping this Session Event.");
                        Unit unit2 = Unit.INSTANCE;
                        mutex.unlock(null);
                        return unit2;
                    }
                    Pair pair = TuplesKt.to("X-Crashlytics-Installation-ID", str);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str2 = String.format("%s/%s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                    Pair pair2 = TuplesKt.to("X-Crashlytics-Device-Model", remoteSettings.removeForwardSlashesIn(str2));
                    String INCREMENTAL = Build.VERSION.INCREMENTAL;
                    Intrinsics.checkNotNullExpressionValue(INCREMENTAL, "INCREMENTAL");
                    Pair pair3 = TuplesKt.to("X-Crashlytics-OS-Build-Version", remoteSettings.removeForwardSlashesIn(INCREMENTAL));
                    String RELEASE = Build.VERSION.RELEASE;
                    Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
                    mapMapOf = MapsKt__MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to("X-Crashlytics-OS-Display-Version", remoteSettings.removeForwardSlashesIn(RELEASE)), TuplesKt.to("X-Crashlytics-API-Client-Version", remoteSettings.appInfo.getSessionSdkVersion()));
                    Log.d(TAG, "Fetching settings from server.");
                    crashlyticsSettingsFetcher = remoteSettings.configsFetcher;
                    remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(remoteSettings, null);
                    remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(null);
                    anonymousClass1.L$0 = mutex;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 3;
                    if (crashlyticsSettingsFetcher.doConfigFetch(mapMapOf, remoteSettings$updateSettings$2$1, remoteSettings$updateSettings$2$2, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex2 = mutex;
                    Unit unit3 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit3;
                }
                mutex = (Mutex) anonymousClass1.L$1;
                remoteSettings = (RemoteSettings) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objAwait);
            }
            if (!remoteSettings.settingsCache.hasCacheExpired$com_google_firebase_firebase_sessions()) {
                Log.d(TAG, "Remote settings cache not expired. Using cached values.");
                Unit unit4 = Unit.INSTANCE;
                mutex.unlock(null);
                return unit4;
            }
            Task<String> id = remoteSettings.firebaseInstallationsApi.getId();
            Intrinsics.checkNotNullExpressionValue(id, "firebaseInstallationsApi.id");
            anonymousClass1.L$0 = remoteSettings;
            anonymousClass1.L$1 = mutex;
            anonymousClass1.label = 2;
            objAwait = TasksKt.await(id, anonymousClass1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = (String) objAwait;
            if (str == null) {
                SentryLogcatAdapter.w(TAG, "Error getting Firebase Installation ID. Skipping this Session Event.");
                Unit unit5 = Unit.INSTANCE;
                mutex.unlock(null);
                return unit5;
            }
            Pair pair4 = TuplesKt.to("X-Crashlytics-Installation-ID", str);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str3 = String.format("%s/%s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
            Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
            Pair pair5 = TuplesKt.to("X-Crashlytics-Device-Model", remoteSettings.removeForwardSlashesIn(str3));
            String INCREMENTAL2 = Build.VERSION.INCREMENTAL;
            Intrinsics.checkNotNullExpressionValue(INCREMENTAL2, "INCREMENTAL");
            Pair pair6 = TuplesKt.to("X-Crashlytics-OS-Build-Version", remoteSettings.removeForwardSlashesIn(INCREMENTAL2));
            String RELEASE2 = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE2, "RELEASE");
            mapMapOf = MapsKt__MapsKt.mapOf(pair4, pair5, pair6, TuplesKt.to("X-Crashlytics-OS-Display-Version", remoteSettings.removeForwardSlashesIn(RELEASE2)), TuplesKt.to("X-Crashlytics-API-Client-Version", remoteSettings.appInfo.getSessionSdkVersion()));
            Log.d(TAG, "Fetching settings from server.");
            crashlyticsSettingsFetcher = remoteSettings.configsFetcher;
            remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(remoteSettings, null);
            remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(null);
            anonymousClass1.L$0 = mutex;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 3;
            if (crashlyticsSettingsFetcher.doConfigFetch(mapMapOf, remoteSettings$updateSettings$2$1, remoteSettings$updateSettings$2$2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
            Unit unit6 = Unit.INSTANCE;
            mutex2.unlock(null);
            return unit6;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public boolean isSettingsStale() {
        return this.settingsCache.hasCacheExpired$com_google_firebase_firebase_sessions();
    }

    public final void clearCachedSettings$com_google_firebase_firebase_sessions() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new RemoteSettings$clearCachedSettings$1(this, null), 3, null);
    }

    private final String removeForwardSlashesIn(String str) {
        return new Regex(FORWARD_SLASH_STRING).replace(str, "");
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
