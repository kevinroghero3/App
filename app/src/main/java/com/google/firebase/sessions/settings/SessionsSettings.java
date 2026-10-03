package com.google.firebase.sessions.settings;

import android.content.Context;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseKt;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.ProcessDetailsProvider;
import com.google.firebase.sessions.SessionDataStoreConfigs;
import com.google.firebase.sessions.SessionEvents;
import io.sentry.android.core.SentryLogcatAdapter;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class SessionsSettings {
    private static final String TAG = "SessionsSettings";
    private final SettingsProvider localOverrideSettings;
    private final SettingsProvider remoteSettings;
    public static final Companion Companion = new Companion(null);
    private static final ReadOnlyProperty<Context, DataStore<Preferences>> dataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default(SessionDataStoreConfigs.INSTANCE.getSETTINGS_CONFIG_NAME(), new ReplaceFileCorruptionHandler(new Function1<CorruptionException, Preferences>() { // from class: com.google.firebase.sessions.settings.SessionsSettings$Companion$dataStore$2
        @Override // kotlin.jvm.functions.Function1
        public final Preferences invoke(@NotNull CorruptionException ex) {
            Intrinsics.checkNotNullParameter(ex, "ex");
            SentryLogcatAdapter.w("SessionsSettings", "CorruptionException in settings DataStore in " + ProcessDetailsProvider.INSTANCE.getProcessName$com_google_firebase_firebase_sessions() + '.', ex);
            return PreferencesFactory.createEmpty();
        }
    }), null, null, 12, null);

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1, reason: invalid class name */
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SessionsSettings", f = "SessionsSettings.kt", i = {0}, l = {138, 139}, m = "updateSettings", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionsSettings.this.updateSettings(this);
        }
    }

    private final boolean isValidSamplingRate(double d) {
        return 0.0d <= d && d <= 1.0d;
    }

    public SessionsSettings(@NotNull SettingsProvider localOverrideSettings, @NotNull SettingsProvider remoteSettings) {
        Intrinsics.checkNotNullParameter(localOverrideSettings, "localOverrideSettings");
        Intrinsics.checkNotNullParameter(remoteSettings, "remoteSettings");
        this.localOverrideSettings = localOverrideSettings;
        this.remoteSettings = remoteSettings;
    }

    private SessionsSettings(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo applicationInfo) {
        this(new LocalOverrideSettings(context), new RemoteSettings(coroutineContext2, firebaseInstallationsApi, applicationInfo, new RemoteSettingsFetcher(applicationInfo, coroutineContext, null, 4, null), Companion.getDataStore(context)));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SessionsSettings(@NotNull FirebaseApp firebaseApp, @NotNull CoroutineContext blockingDispatcher, @NotNull CoroutineContext backgroundDispatcher, @NotNull FirebaseInstallationsApi firebaseInstallationsApi) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(blockingDispatcher, "blockingDispatcher");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Context applicationContext = firebaseApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "firebaseApp.applicationContext");
        this(applicationContext, blockingDispatcher, backgroundDispatcher, firebaseInstallationsApi, SessionEvents.INSTANCE.getApplicationInfo(firebaseApp));
    }

    public final boolean getSessionsEnabled() {
        Boolean sessionEnabled = this.localOverrideSettings.getSessionEnabled();
        if (sessionEnabled != null) {
            return sessionEnabled.booleanValue();
        }
        Boolean sessionEnabled2 = this.remoteSettings.getSessionEnabled();
        if (sessionEnabled2 != null) {
            return sessionEnabled2.booleanValue();
        }
        return true;
    }

    public final double getSamplingRate() {
        Double samplingRate = this.localOverrideSettings.getSamplingRate();
        if (samplingRate != null) {
            double dDoubleValue = samplingRate.doubleValue();
            if (isValidSamplingRate(dDoubleValue)) {
                return dDoubleValue;
            }
        }
        Double samplingRate2 = this.remoteSettings.getSamplingRate();
        if (samplingRate2 == null) {
            return 1.0d;
        }
        double dDoubleValue2 = samplingRate2.doubleValue();
        if (isValidSamplingRate(dDoubleValue2)) {
            return dDoubleValue2;
        }
        return 1.0d;
    }

    /* JADX INFO: renamed from: getSessionRestartTimeout-UwyO8pc, reason: not valid java name */
    public final long m5019getSessionRestartTimeoutUwyO8pc() {
        Duration durationMo5017getSessionRestartTimeoutFghU774 = this.localOverrideSettings.mo5017getSessionRestartTimeoutFghU774();
        if (durationMo5017getSessionRestartTimeoutFghU774 != null) {
            long jM6877unboximpl = durationMo5017getSessionRestartTimeoutFghU774.m6877unboximpl();
            if (m5018isValidSessionRestartTimeoutLRDsOJo(jM6877unboximpl)) {
                return jM6877unboximpl;
            }
        }
        Duration durationMo5017getSessionRestartTimeoutFghU775 = this.remoteSettings.mo5017getSessionRestartTimeoutFghU774();
        if (durationMo5017getSessionRestartTimeoutFghU775 != null) {
            long jM6877unboximpl2 = durationMo5017getSessionRestartTimeoutFghU775.m6877unboximpl();
            if (m5018isValidSessionRestartTimeoutLRDsOJo(jM6877unboximpl2)) {
                return jM6877unboximpl2;
            }
        }
        Duration.Companion companion = Duration.Companion;
        return DurationKt.toDuration(30, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: isValidSessionRestartTimeout-LRDsOJo, reason: not valid java name */
    private final boolean m5018isValidSessionRestartTimeoutLRDsOJo(long j) {
        return Duration.m6858isPositiveimpl(j) && Duration.m6853isFiniteimpl(j);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object updateSettings(@NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        SessionsSettings sessionsSettings;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            SettingsProvider settingsProvider = this.localOverrideSettings;
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            if (settingsProvider.updateSettings(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            sessionsSettings = this;
        } else {
            if (i2 == 1) {
                sessionsSettings = (SessionsSettings) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        SettingsProvider settingsProvider2 = sessionsSettings.remoteSettings;
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 2;
        if (settingsProvider2.updateSettings(anonymousClass1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property2(new PropertyReference2Impl(Companion.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SessionsSettings getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(SessionsSettings.class);
            Intrinsics.checkNotNullExpressionValue(obj, "Firebase.app[SessionsSettings::class.java]");
            return (SessionsSettings) obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DataStore<Preferences> getDataStore(Context context) {
            return (DataStore) SessionsSettings.dataStore$delegate.getValue(context, $$delegatedProperties[0]);
        }
    }
}
