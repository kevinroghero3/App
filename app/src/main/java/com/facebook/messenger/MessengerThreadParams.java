package com.facebook.messenger;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class MessengerThreadParams {
    private final String metadata;
    private final Origin origin;
    private final List<String> participants;
    private final String threadToken;

    public enum Origin {
        REPLY_FLOW,
        COMPOSE_FLOW,
        UNKNOWN
    }

    public MessengerThreadParams(@NotNull Origin origin, @NotNull String threadToken, @NotNull String metadata, @NotNull List<String> participants) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(threadToken, "threadToken");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(participants, "participants");
        this.origin = origin;
        this.threadToken = threadToken;
        this.metadata = metadata;
        this.participants = participants;
    }

    public final Origin getOrigin() {
        return this.origin;
    }

    public final String getThreadToken() {
        return this.threadToken;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final List<String> getParticipants() {
        return this.participants;
    }
}
