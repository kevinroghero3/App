package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public enum RRWebEventType implements JsonSerializable {
    DomContentLoaded,
    Load,
    FullSnapshot,
    IncrementalSnapshot,
    Meta,
    Custom,
    Plugin;

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.value(ordinal());
    }

    public static final class Deserializer implements JsonDeserializer<RRWebEventType> {
        public static int setMetadata;
        public static int setPlaybackToLocal;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public RRWebEventType deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception {
            return RRWebEventType.values()[objectReader.nextInt()];
        }

        public static int MediaBrowserCompatMediaBrowserImplApi217() {
            int i = setPlaybackToLocal;
            int i2 = i % 6213414;
            setPlaybackToLocal = i + 1;
            if (i2 != 0) {
                return setMetadata;
            }
            int i3 = (int) Runtime.getRuntime().totalMemory();
            setMetadata = i3;
            return i3;
        }
    }
}
