package io.sentry;

import io.sentry.cache.EnvelopeCache;
import io.sentry.protocol.Feedback;

/* JADX INFO: loaded from: classes3.dex */
public enum DataCategory {
    All("__all__"),
    Default("default"),
    Error("error"),
    Feedback(Feedback.TYPE),
    Session(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE),
    Attachment("attachment"),
    LogItem("log_item"),
    Monitor("monitor"),
    Profile("profile"),
    ProfileChunkUi("profile_chunk_ui"),
    Transaction("transaction"),
    Replay("replay"),
    Span("span"),
    Security("security"),
    UserReport("user_report"),
    Unknown("unknown");

    private final String category;

    DataCategory(String str) {
        this.category = str;
    }

    public String getCategory() {
        return this.category;
    }
}
