package com.alpha0010.fs;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ProgressResponseBody extends ResponseBody {
    private BufferedSource bufferedSource;
    private long lastEventTime;
    private final Function3<Long, Long, Boolean, Unit> listener;
    private final ResponseBody responseBody;

    /* JADX WARN: Multi-variable type inference failed */
    public ProgressResponseBody(@NotNull ResponseBody responseBody, @NotNull Function3<? super Long, ? super Long, ? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.responseBody = responseBody;
        this.listener = listener;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.responseBody.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.responseBody.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        BufferedSource bufferedSource = this.bufferedSource;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        BufferedSource bufferedSourceBuffer = Okio.buffer(new ForwardingSource(this.responseBody.source()) { // from class: com.alpha0010.fs.ProgressResponseBody.source.1
            private long totalBytesRead;

            public final long getTotalBytesRead() {
                return this.totalBytesRead;
            }

            public final void setTotalBytesRead(long j) {
                this.totalBytesRead = j;
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer sink, long j) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                long j2 = super.read(sink, j);
                boolean z = j2 == -1;
                this.totalBytesRead += z ? 0L : j2;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - ProgressResponseBody.this.lastEventTime > 150 || z) {
                    ProgressResponseBody.this.lastEventTime = jCurrentTimeMillis;
                    ProgressResponseBody.this.listener.invoke(Long.valueOf(this.totalBytesRead), Long.valueOf(ProgressResponseBody.this.contentLength()), Boolean.valueOf(z));
                }
                return j2;
            }
        });
        this.bufferedSource = bufferedSourceBuffer;
        return bufferedSourceBuffer;
    }
}
