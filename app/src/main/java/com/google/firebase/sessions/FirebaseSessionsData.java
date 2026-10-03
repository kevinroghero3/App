package com.google.firebase.sessions;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class FirebaseSessionsData {
    private final String sessionId;

    public static /* synthetic */ FirebaseSessionsData copy$default(FirebaseSessionsData firebaseSessionsData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = firebaseSessionsData.sessionId;
        }
        return firebaseSessionsData.copy(str);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final FirebaseSessionsData copy(@Nullable String str) {
        return new FirebaseSessionsData(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FirebaseSessionsData) && Intrinsics.areEqual(this.sessionId, ((FirebaseSessionsData) obj).sessionId);
    }

    public int hashCode() {
        String str = this.sessionId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "FirebaseSessionsData(sessionId=" + this.sessionId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public FirebaseSessionsData(@Nullable String str) {
        this.sessionId = str;
    }

    public final String getSessionId() {
        return this.sessionId;
    }
}
