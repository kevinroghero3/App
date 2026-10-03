package com.google.firebase.sessions;

import android.util.Log;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class EventGDTLogger implements EventGDTLoggerInterface {
    private static final String AQS_LOG_SOURCE = "FIREBASE_APPQUALITY_SESSION";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "EventGDTLogger";
    private final Provider<TransportFactory> transportFactoryProvider;

    public EventGDTLogger(@NotNull Provider<TransportFactory> transportFactoryProvider) {
        Intrinsics.checkNotNullParameter(transportFactoryProvider, "transportFactoryProvider");
        this.transportFactoryProvider = transportFactoryProvider;
    }

    @Override // com.google.firebase.sessions.EventGDTLoggerInterface
    public void log(@NotNull SessionEvent sessionEvent) {
        Intrinsics.checkNotNullParameter(sessionEvent, "sessionEvent");
        this.transportFactoryProvider.get().getTransport(AQS_LOG_SOURCE, SessionEvent.class, Encoding.of("json"), new Transformer() { // from class: com.google.firebase.sessions.EventGDTLogger$$ExternalSyntheticLambda0
            @Override // com.google.android.datatransport.Transformer
            public final Object apply(Object obj) {
                return this.f$0.encode((SessionEvent) obj);
            }
        }).send(Event.ofData(sessionEvent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] encode(SessionEvent sessionEvent) {
        String strEncode = SessionEvents.INSTANCE.getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions().encode(sessionEvent);
        Intrinsics.checkNotNullExpressionValue(strEncode, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        Log.d(TAG, "Session Event: " + strEncode);
        byte[] bytes = strEncode.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
