package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    @Deprecated(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @ReplaceWith(expression = "buffer", imports = {}))
    Buffer buffer();

    BufferedSink emit() throws IOException;

    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    Buffer getBuffer();

    OutputStream outputStream();

    BufferedSink write(@NotNull ByteString byteString) throws IOException;

    BufferedSink write(@NotNull ByteString byteString, int i, int i2) throws IOException;

    BufferedSink write(@NotNull Source source, long j) throws IOException;

    BufferedSink write(@NotNull byte[] bArr) throws IOException;

    BufferedSink write(@NotNull byte[] bArr, int i, int i2) throws IOException;

    long writeAll(@NotNull Source source) throws IOException;

    BufferedSink writeByte(int i) throws IOException;

    BufferedSink writeDecimalLong(long j) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long j) throws IOException;

    BufferedSink writeInt(int i) throws IOException;

    BufferedSink writeIntLe(int i) throws IOException;

    BufferedSink writeLong(long j) throws IOException;

    BufferedSink writeLongLe(long j) throws IOException;

    BufferedSink writeShort(int i) throws IOException;

    BufferedSink writeShortLe(int i) throws IOException;

    BufferedSink writeString(@NotNull String str, int i, int i2, @NotNull Charset charset) throws IOException;

    BufferedSink writeString(@NotNull String str, @NotNull Charset charset) throws IOException;

    BufferedSink writeUtf8(@NotNull String str) throws IOException;

    BufferedSink writeUtf8(@NotNull String str, int i, int i2) throws IOException;

    BufferedSink writeUtf8CodePoint(int i) throws IOException;
}
