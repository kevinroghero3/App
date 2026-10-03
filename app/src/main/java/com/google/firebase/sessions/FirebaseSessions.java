package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseKt;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class FirebaseSessions {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "FirebaseSessions";
    private final FirebaseApp firebaseApp;
    private final SessionsSettings settings;

    public FirebaseSessions(@NotNull FirebaseApp firebaseApp, @NotNull SessionsSettings settings, @NotNull CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.firebaseApp = firebaseApp;
        this.settings = settings;
        Log.d(TAG, "Initializing Firebase Sessions SDK.");
        Context applicationContext = firebaseApp.getApplicationContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(SessionsActivityLifecycleCallbacks.INSTANCE);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(backgroundDispatcher), null, null, new AnonymousClass1(backgroundDispatcher, null), 3, null);
            return;
        }
        SentryLogcatAdapter.e(TAG, "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.FirebaseSessions$1, reason: invalid class name */
    @DebugMetadata(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", i = {}, l = {44, 48}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $backgroundDispatcher;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineContext coroutineContext, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$backgroundDispatcher = coroutineContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return FirebaseSessions.this.new AnonymousClass1(this.$backgroundDispatcher, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0075  */
        /* JADX WARN: Code duplicated, block: B:29:0x007b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (!FirebaseSessions.this.settings.getSessionsEnabled()) {
                    Log.d(FirebaseSessions.TAG, "Sessions SDK disabled. Not listening to lifecycle events.");
                } else {
                    SessionLifecycleClient sessionLifecycleClient = new SessionLifecycleClient(this.$backgroundDispatcher);
                    sessionLifecycleClient.bindToService();
                    SessionsActivityLifecycleCallbacks.INSTANCE.setLifecycleClient(sessionLifecycleClient);
                    FirebaseSessions.this.firebaseApp.addLifecycleEventListener(new FirebaseAppLifecycleListener() { // from class: com.google.firebase.sessions.FirebaseSessions$1$$ExternalSyntheticLambda0
                        @Override // com.google.firebase.FirebaseAppLifecycleListener
                        public final void onDeleted(String str, FirebaseOptions firebaseOptions) {
                            FirebaseSessions.AnonymousClass1.m5007invokeSuspend$lambda1(str, firebaseOptions);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.INSTANCE;
            this.label = 1;
            obj = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            Collection collectionValues = ((Map) obj).values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator it2 = collectionValues.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((SessionSubscriber) it2.next()).isDataCollectionEnabled()) {
                            SessionsSettings sessionsSettings = FirebaseSessions.this.settings;
                            this.label = 2;
                            if (sessionsSettings.updateSettings(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (!FirebaseSessions.this.settings.getSessionsEnabled()) {
                                Log.d(FirebaseSessions.TAG, "Sessions SDK disabled. Not listening to lifecycle events.");
                            } else {
                                SessionLifecycleClient sessionLifecycleClient2 = new SessionLifecycleClient(this.$backgroundDispatcher);
                                sessionLifecycleClient2.bindToService();
                                SessionsActivityLifecycleCallbacks.INSTANCE.setLifecycleClient(sessionLifecycleClient2);
                                FirebaseSessions.this.firebaseApp.addLifecycleEventListener(new FirebaseAppLifecycleListener() { // from class: com.google.firebase.sessions.FirebaseSessions$1$$ExternalSyntheticLambda0
                                    @Override // com.google.firebase.FirebaseAppLifecycleListener
                                    public final void onDeleted(String str, FirebaseOptions firebaseOptions) {
                                        FirebaseSessions.AnonymousClass1.m5007invokeSuspend$lambda1(str, firebaseOptions);
                                    }
                                });
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
            Log.d(FirebaseSessions.TAG, "No Sessions subscribers. Not listening to lifecycle events.");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invokeSuspend$lambda-1, reason: not valid java name */
        public static final void m5007invokeSuspend$lambda1(String str, FirebaseOptions firebaseOptions) {
            SentryLogcatAdapter.w(FirebaseSessions.TAG, "FirebaseApp instance deleted. Sessions library will stop collecting data.");
            SessionsActivityLifecycleCallbacks.INSTANCE.setLifecycleClient(null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FirebaseSessions getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(FirebaseSessions.class);
            Intrinsics.checkNotNullExpressionValue(obj, "Firebase.app[FirebaseSessions::class.java]");
            return (FirebaseSessions) obj;
        }
    }
}
