package com.google.firebase.sessions;

import android.util.Log;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.tasks.TasksKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {
    private static final String TAG = "SessionFirelogPublisher";
    private final CoroutineContext backgroundDispatcher;
    private final EventGDTLoggerInterface eventGDTLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final SessionsSettings sessionSettings;
    public static final Companion Companion = new Companion(null);
    private static final double randomValueForSampling = Math.random();

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$getFirebaseInstallationId$1, reason: invalid class name */
    @DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", i = {}, l = {b.f40o}, m = "getFirebaseInstallationId", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionFirelogPublisherImpl.this.getFirebaseInstallationId(this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", i = {0}, l = {93}, m = "shouldLogSession", n = {"this"}, s = {"L$0"})
    static final class C03331 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03331(Continuation<? super C03331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionFirelogPublisherImpl.this.shouldLogSession(this);
        }
    }

    public SessionFirelogPublisherImpl(@NotNull FirebaseApp firebaseApp, @NotNull FirebaseInstallationsApi firebaseInstallations, @NotNull SessionsSettings sessionSettings, @NotNull EventGDTLoggerInterface eventGDTLogger, @NotNull CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(firebaseInstallations, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(sessionSettings, "sessionSettings");
        Intrinsics.checkNotNullParameter(eventGDTLogger, "eventGDTLogger");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallations;
        this.sessionSettings = sessionSettings;
        this.eventGDTLogger = eventGDTLogger;
        this.backgroundDispatcher = backgroundDispatcher;
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", i = {}, l = {64, CoreConstants.OOS_RESET_FREQUENCY, 71}, m = "invokeSuspend", n = {}, s = {})
    static final class C03321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionDetails $sessionDetails;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03321(SessionDetails sessionDetails, Continuation<? super C03321> continuation) {
            super(2, continuation);
            this.$sessionDetails = sessionDetails;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SessionFirelogPublisherImpl.this.new C03321(this.$sessionDetails, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C03321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00b2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x00b3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            FirebaseApp firebaseApp;
            SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
            SessionDetails sessionDetails;
            SessionEvents sessionEvents;
            SessionsSettings sessionsSettings;
            Map<SessionSubscriber.Name, ? extends SessionSubscriber> map;
            Object firebaseInstallationId;
            SessionEvents sessionEvents2;
            Map<SessionSubscriber.Name, ? extends SessionSubscriber> map2;
            SessionDetails sessionDetails2;
            SessionsSettings sessionsSettings2;
            FirebaseApp firebaseApp2;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    sessionsSettings = (SessionsSettings) this.L$4;
                    sessionDetails = (SessionDetails) this.L$3;
                    firebaseApp = (FirebaseApp) this.L$2;
                    sessionEvents = (SessionEvents) this.L$1;
                    sessionFirelogPublisherImpl = (SessionFirelogPublisherImpl) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    map = (Map) obj;
                    SessionFirelogPublisherImpl sessionFirelogPublisherImpl2 = SessionFirelogPublisherImpl.this;
                    this.L$0 = sessionFirelogPublisherImpl;
                    this.L$1 = sessionEvents;
                    this.L$2 = firebaseApp;
                    this.L$3 = sessionDetails;
                    this.L$4 = sessionsSettings;
                    this.L$5 = map;
                    this.label = 3;
                    firebaseInstallationId = sessionFirelogPublisherImpl2.getFirebaseInstallationId(this);
                    if (firebaseInstallationId == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sessionEvents2 = sessionEvents;
                    FirebaseApp firebaseApp3 = firebaseApp;
                    map2 = map;
                    obj = firebaseInstallationId;
                    sessionDetails2 = sessionDetails;
                    sessionsSettings2 = sessionsSettings;
                    firebaseApp2 = firebaseApp3;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Map<SessionSubscriber.Name, ? extends SessionSubscriber> map3 = (Map) this.L$5;
                    SessionsSettings sessionsSettings3 = (SessionsSettings) this.L$4;
                    sessionDetails2 = (SessionDetails) this.L$3;
                    FirebaseApp firebaseApp4 = (FirebaseApp) this.L$2;
                    SessionEvents sessionEvents3 = (SessionEvents) this.L$1;
                    SessionFirelogPublisherImpl sessionFirelogPublisherImpl3 = (SessionFirelogPublisherImpl) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    sessionFirelogPublisherImpl = sessionFirelogPublisherImpl3;
                    map2 = map3;
                    sessionEvents2 = sessionEvents3;
                    sessionsSettings2 = sessionsSettings3;
                    firebaseApp2 = firebaseApp4;
                }
                Intrinsics.checkNotNullExpressionValue(obj, "getFirebaseInstallationId()");
                sessionFirelogPublisherImpl.attemptLoggingSessionEvent(sessionEvents2.buildSession(firebaseApp2, sessionDetails2, sessionsSettings2, map2, (String) obj));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            SessionFirelogPublisherImpl sessionFirelogPublisherImpl4 = SessionFirelogPublisherImpl.this;
            this.label = 1;
            obj = sessionFirelogPublisherImpl4.shouldLogSession(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((Boolean) obj).booleanValue()) {
                SessionFirelogPublisherImpl sessionFirelogPublisherImpl5 = SessionFirelogPublisherImpl.this;
                SessionEvents sessionEvents4 = SessionEvents.INSTANCE;
                firebaseApp = sessionFirelogPublisherImpl5.firebaseApp;
                SessionDetails sessionDetails3 = this.$sessionDetails;
                SessionsSettings sessionsSettings4 = SessionFirelogPublisherImpl.this.sessionSettings;
                FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.INSTANCE;
                this.L$0 = sessionFirelogPublisherImpl5;
                this.L$1 = sessionEvents4;
                this.L$2 = firebaseApp;
                this.L$3 = sessionDetails3;
                this.L$4 = sessionsSettings4;
                this.label = 2;
                Object registeredSubscribers$com_google_firebase_firebase_sessions = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
                if (registeredSubscribers$com_google_firebase_firebase_sessions == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sessionFirelogPublisherImpl = sessionFirelogPublisherImpl5;
                obj = registeredSubscribers$com_google_firebase_firebase_sessions;
                sessionDetails = sessionDetails3;
                sessionEvents = sessionEvents4;
                sessionsSettings = sessionsSettings4;
                map = (Map) obj;
                SessionFirelogPublisherImpl sessionFirelogPublisherImpl6 = SessionFirelogPublisherImpl.this;
                this.L$0 = sessionFirelogPublisherImpl;
                this.L$1 = sessionEvents;
                this.L$2 = firebaseApp;
                this.L$3 = sessionDetails;
                this.L$4 = sessionsSettings;
                this.L$5 = map;
                this.label = 3;
                firebaseInstallationId = sessionFirelogPublisherImpl6.getFirebaseInstallationId(this);
                if (firebaseInstallationId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sessionEvents2 = sessionEvents;
                FirebaseApp firebaseApp5 = firebaseApp;
                map2 = map;
                obj = firebaseInstallationId;
                sessionDetails2 = sessionDetails;
                sessionsSettings2 = sessionsSettings;
                firebaseApp2 = firebaseApp5;
                Intrinsics.checkNotNullExpressionValue(obj, "getFirebaseInstallationId()");
                sessionFirelogPublisherImpl.attemptLoggingSessionEvent(sessionEvents2.buildSession(firebaseApp2, sessionDetails2, sessionsSettings2, map2, (String) obj));
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.google.firebase.sessions.SessionFirelogPublisher
    public void logSession(@NotNull SessionDetails sessionDetails) {
        Intrinsics.checkNotNullParameter(sessionDetails, "sessionDetails");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new C03321(sessionDetails, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attemptLoggingSessionEvent(SessionEvent sessionEvent) {
        try {
            this.eventGDTLogger.log(sessionEvent);
            Log.d(TAG, "Successfully logged Session Start event: " + sessionEvent.getSessionData().getSessionId());
        } catch (RuntimeException e) {
            SentryLogcatAdapter.e(TAG, "Error logging Session Start event to DataTransport: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object shouldLogSession(Continuation<? super Boolean> continuation) {
        C03331 c03331;
        SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
        if (continuation instanceof C03331) {
            c03331 = (C03331) continuation;
            int i = c03331.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03331.label = i - Integer.MIN_VALUE;
            } else {
                c03331 = new C03331(continuation);
            }
        } else {
            c03331 = new C03331(continuation);
        }
        Object obj = c03331.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c03331.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Log.d(TAG, "Data Collection is enabled for at least one Subscriber");
            SessionsSettings sessionsSettings = this.sessionSettings;
            c03331.L$0 = this;
            c03331.label = 1;
            if (sessionsSettings.updateSettings(c03331) == coroutine_suspended) {
                return coroutine_suspended;
            }
            sessionFirelogPublisherImpl = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sessionFirelogPublisherImpl = (SessionFirelogPublisherImpl) c03331.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (!sessionFirelogPublisherImpl.sessionSettings.getSessionsEnabled()) {
            Log.d(TAG, "Sessions SDK disabled. Events will not be sent.");
            return Boxing.boxBoolean(false);
        }
        if (!sessionFirelogPublisherImpl.shouldCollectEvents()) {
            Log.d(TAG, "Sessions SDK has dropped this session due to sampling.");
            return Boxing.boxBoolean(false);
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getFirebaseInstallationId(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
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
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAwait);
                Task<String> id = this.firebaseInstallations.getId();
                Intrinsics.checkNotNullExpressionValue(id, "firebaseInstallations.id");
                anonymousClass1.label = 1;
                objAwait = TasksKt.await(id, anonymousClass1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objAwait);
            }
            return (String) objAwait;
        } catch (Exception e) {
            SentryLogcatAdapter.e(TAG, "Error getting Firebase Installation ID. Using an empty ID", e);
            return "";
        }
    }

    private final boolean shouldCollectEvents() {
        return randomValueForSampling <= this.sessionSettings.getSamplingRate();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
