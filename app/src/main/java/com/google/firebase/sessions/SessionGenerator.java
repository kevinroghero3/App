package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class SessionGenerator {
    public static final Companion Companion = new Companion(null);
    private SessionDetails currentSession;
    private final String firstSessionId;
    private int sessionIndex;
    private final TimeProvider timeProvider;
    private final Function0<UUID> uuidGenerator;

    public SessionGenerator(@NotNull TimeProvider timeProvider, @NotNull Function0<UUID> uuidGenerator) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(uuidGenerator, "uuidGenerator");
        this.timeProvider = timeProvider;
        this.uuidGenerator = uuidGenerator;
        this.firstSessionId = generateSessionId();
        this.sessionIndex = -1;
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionGenerator$1, reason: invalid class name */
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<UUID> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0, UUID.class, "randomUUID", "randomUUID()Ljava/util/UUID;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    public /* synthetic */ SessionGenerator(TimeProvider timeProvider, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeProvider, (i & 2) != 0 ? AnonymousClass1.INSTANCE : function0);
    }

    public final SessionDetails getCurrentSession() {
        SessionDetails sessionDetails = this.currentSession;
        if (sessionDetails != null) {
            return sessionDetails;
        }
        Intrinsics.throwUninitializedPropertyAccessException("currentSession");
        return null;
    }

    public final boolean getHasGenerateSession() {
        return this.currentSession != null;
    }

    public final SessionDetails generateNewSession() {
        int i = this.sessionIndex + 1;
        this.sessionIndex = i;
        this.currentSession = new SessionDetails(i == 0 ? this.firstSessionId : generateSessionId(), this.firstSessionId, this.sessionIndex, this.timeProvider.currentTimeUs());
        return getCurrentSession();
    }

    private final String generateSessionId() {
        String string = this.uuidGenerator.invoke().toString();
        Intrinsics.checkNotNullExpressionValue(string, "uuidGenerator().toString()");
        String lowerCase = StringsKt__StringsJVMKt.replace$default(string, "-", "", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SessionGenerator getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(SessionGenerator.class);
            Intrinsics.checkNotNullExpressionValue(obj, "Firebase.app[SessionGenerator::class.java]");
            return (SessionGenerator) obj;
        }
    }
}
