package okio;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class Okio__OkioKt {
    public static final BufferedSource buffer(@NotNull Source buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$buffer");
        return new RealBufferedSource(buffer);
    }

    public static final BufferedSink buffer(@NotNull Sink buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$buffer");
        return new RealBufferedSink(buffer);
    }

    public static final Sink blackhole() {
        return new BlackholeSink();
    }
}
