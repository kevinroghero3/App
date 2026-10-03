package io.sentry.android.replay.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface SimpleFrameMuxer {
    long getVideoTime();

    boolean isStarted();

    void muxVideoFrame(@NotNull ByteBuffer byteBuffer, @NotNull MediaCodec.BufferInfo bufferInfo);

    void release();

    void start(@NotNull MediaFormat mediaFormat);
}
