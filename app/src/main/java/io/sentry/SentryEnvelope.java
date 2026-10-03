package io.sentry;

import android.os.Process;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import java.io.IOException;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryEnvelope {
    public static int getController;
    public static int removeOnActiveChangeListener;
    private final SentryEnvelopeHeader header;
    private final Iterable<SentryEnvelopeItem> items;

    public Iterable<SentryEnvelopeItem> getItems() {
        return this.items;
    }

    public SentryEnvelopeHeader getHeader() {
        return this.header;
    }

    public SentryEnvelope(@NotNull SentryEnvelopeHeader sentryEnvelopeHeader, @NotNull Iterable<SentryEnvelopeItem> iterable) {
        this.header = (SentryEnvelopeHeader) Objects.requireNonNull(sentryEnvelopeHeader, "SentryEnvelopeHeader is required.");
        this.items = (Iterable) Objects.requireNonNull(iterable, "SentryEnvelope items are required.");
    }

    public SentryEnvelope(@Nullable SentryId sentryId, @Nullable SdkVersion sdkVersion, @NotNull Iterable<SentryEnvelopeItem> iterable) {
        this.header = new SentryEnvelopeHeader(sentryId, sdkVersion);
        this.items = (Iterable) Objects.requireNonNull(iterable, "SentryEnvelope items are required.");
    }

    public SentryEnvelope(@Nullable SentryId sentryId, @Nullable SdkVersion sdkVersion, @NotNull SentryEnvelopeItem sentryEnvelopeItem) {
        Objects.requireNonNull(sentryEnvelopeItem, "SentryEnvelopeItem is required.");
        this.header = new SentryEnvelopeHeader(sentryId, sdkVersion);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(sentryEnvelopeItem);
        this.items = arrayList;
    }

    public static SentryEnvelope from(@NotNull ISerializer iSerializer, @NotNull Session session, @Nullable SdkVersion sdkVersion) throws IOException {
        Objects.requireNonNull(iSerializer, "Serializer is required.");
        Objects.requireNonNull(session, "session is required.");
        return new SentryEnvelope((SentryId) null, sdkVersion, SentryEnvelopeItem.fromSession(iSerializer, session));
    }

    public static SentryEnvelope from(@NotNull ISerializer iSerializer, @NotNull SentryBaseEvent sentryBaseEvent, @Nullable SdkVersion sdkVersion) throws IOException {
        Objects.requireNonNull(iSerializer, "Serializer is required.");
        Objects.requireNonNull(sentryBaseEvent, "item is required.");
        return new SentryEnvelope(sentryBaseEvent.getEventId(), sdkVersion, SentryEnvelopeItem.fromEvent(iSerializer, sentryBaseEvent));
    }

    public static SentryEnvelope from(@NotNull ISerializer iSerializer, @NotNull ProfilingTraceData profilingTraceData, long j, @Nullable SdkVersion sdkVersion) throws SentryEnvelopeException {
        Objects.requireNonNull(iSerializer, "Serializer is required.");
        Objects.requireNonNull(profilingTraceData, "Profiling trace data is required.");
        return new SentryEnvelope(new SentryId(profilingTraceData.getProfileId()), sdkVersion, SentryEnvelopeItem.fromProfilingTrace(profilingTraceData, j, iSerializer));
    }

    public static int MediaBrowserCompatMediaBrowserImplApi212() {
        int i = getController;
        int i2 = i % 5164461;
        getController = i + 1;
        if (i2 != 0) {
            return removeOnActiveChangeListener;
        }
        int iMyPid = Process.myPid();
        removeOnActiveChangeListener = iMyPid;
        return iMyPid;
    }
}
