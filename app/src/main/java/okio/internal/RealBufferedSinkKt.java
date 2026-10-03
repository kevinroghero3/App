package okio.internal;

import ch.qos.logback.core.CoreConstants;
import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class RealBufferedSinkKt {
    public static final void commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull Buffer source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        if (commonWrite.closed) {
            throw new IllegalStateException("closed");
        }
        commonWrite.bufferField.write(source, j);
        commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (commonWrite.closed) {
            throw new IllegalStateException("closed");
        }
        commonWrite.bufferField.write(byteString);
        return commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (commonWrite.closed) {
            throw new IllegalStateException("closed");
        }
        commonWrite.bufferField.write(byteString, i, i2);
        return commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink commonWriteUtf8, @NotNull String string) {
        Intrinsics.checkNotNullParameter(commonWriteUtf8, "$this$commonWriteUtf8");
        Intrinsics.checkNotNullParameter(string, "string");
        if (commonWriteUtf8.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteUtf8.bufferField.writeUtf8(string);
        return commonWriteUtf8.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink commonWriteUtf8, @NotNull String string, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWriteUtf8, "$this$commonWriteUtf8");
        Intrinsics.checkNotNullParameter(string, "string");
        if (commonWriteUtf8.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteUtf8.bufferField.writeUtf8(string, i, i2);
        return commonWriteUtf8.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8CodePoint(@NotNull RealBufferedSink commonWriteUtf8CodePoint, int i) {
        Intrinsics.checkNotNullParameter(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (commonWriteUtf8CodePoint.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteUtf8CodePoint.bufferField.writeUtf8CodePoint(i);
        return commonWriteUtf8CodePoint.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull byte[] source) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        if (commonWrite.closed) {
            throw new IllegalStateException("closed");
        }
        commonWrite.bufferField.write(source);
        return commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        if (commonWrite.closed) {
            throw new IllegalStateException("closed");
        }
        commonWrite.bufferField.write(source, i, i2);
        return commonWrite.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteByte(@NotNull RealBufferedSink commonWriteByte, int i) {
        Intrinsics.checkNotNullParameter(commonWriteByte, "$this$commonWriteByte");
        if (commonWriteByte.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteByte.bufferField.writeByte(i);
        return commonWriteByte.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShort(@NotNull RealBufferedSink commonWriteShort, int i) {
        Intrinsics.checkNotNullParameter(commonWriteShort, "$this$commonWriteShort");
        if (commonWriteShort.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteShort.bufferField.writeShort(i);
        return commonWriteShort.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShortLe(@NotNull RealBufferedSink commonWriteShortLe, int i) {
        Intrinsics.checkNotNullParameter(commonWriteShortLe, "$this$commonWriteShortLe");
        if (commonWriteShortLe.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteShortLe.bufferField.writeShortLe(i);
        return commonWriteShortLe.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteInt(@NotNull RealBufferedSink commonWriteInt, int i) {
        Intrinsics.checkNotNullParameter(commonWriteInt, "$this$commonWriteInt");
        if (commonWriteInt.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteInt.bufferField.writeInt(i);
        return commonWriteInt.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteIntLe(@NotNull RealBufferedSink commonWriteIntLe, int i) {
        Intrinsics.checkNotNullParameter(commonWriteIntLe, "$this$commonWriteIntLe");
        if (commonWriteIntLe.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteIntLe.bufferField.writeIntLe(i);
        return commonWriteIntLe.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLong(@NotNull RealBufferedSink commonWriteLong, long j) {
        Intrinsics.checkNotNullParameter(commonWriteLong, "$this$commonWriteLong");
        if (commonWriteLong.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteLong.bufferField.writeLong(j);
        return commonWriteLong.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLongLe(@NotNull RealBufferedSink commonWriteLongLe, long j) {
        Intrinsics.checkNotNullParameter(commonWriteLongLe, "$this$commonWriteLongLe");
        if (commonWriteLongLe.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteLongLe.bufferField.writeLongLe(j);
        return commonWriteLongLe.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteDecimalLong(@NotNull RealBufferedSink commonWriteDecimalLong, long j) {
        Intrinsics.checkNotNullParameter(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (commonWriteDecimalLong.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteDecimalLong.bufferField.writeDecimalLong(j);
        return commonWriteDecimalLong.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@NotNull RealBufferedSink commonWriteHexadecimalUnsignedLong, long j) {
        Intrinsics.checkNotNullParameter(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (commonWriteHexadecimalUnsignedLong.closed) {
            throw new IllegalStateException("closed");
        }
        commonWriteHexadecimalUnsignedLong.bufferField.writeHexadecimalUnsignedLong(j);
        return commonWriteHexadecimalUnsignedLong.emitCompleteSegments();
    }

    public static final BufferedSink commonEmitCompleteSegments(@NotNull RealBufferedSink commonEmitCompleteSegments) throws IOException {
        Intrinsics.checkNotNullParameter(commonEmitCompleteSegments, "$this$commonEmitCompleteSegments");
        if (commonEmitCompleteSegments.closed) {
            throw new IllegalStateException("closed");
        }
        long jCompleteSegmentByteCount = commonEmitCompleteSegments.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            commonEmitCompleteSegments.sink.write(commonEmitCompleteSegments.bufferField, jCompleteSegmentByteCount);
        }
        return commonEmitCompleteSegments;
    }

    public static final BufferedSink commonEmit(@NotNull RealBufferedSink commonEmit) throws IOException {
        Intrinsics.checkNotNullParameter(commonEmit, "$this$commonEmit");
        if (commonEmit.closed) {
            throw new IllegalStateException("closed");
        }
        long size = commonEmit.bufferField.size();
        if (size > 0) {
            commonEmit.sink.write(commonEmit.bufferField, size);
        }
        return commonEmit;
    }

    public static final void commonFlush(@NotNull RealBufferedSink commonFlush) throws IOException {
        Intrinsics.checkNotNullParameter(commonFlush, "$this$commonFlush");
        if (commonFlush.closed) {
            throw new IllegalStateException("closed");
        }
        if (commonFlush.bufferField.size() > 0) {
            Sink sink = commonFlush.sink;
            Buffer buffer = commonFlush.bufferField;
            sink.write(buffer, buffer.size());
        }
        commonFlush.sink.flush();
    }

    public static final void commonClose(@NotNull RealBufferedSink commonClose) throws Throwable {
        Intrinsics.checkNotNullParameter(commonClose, "$this$commonClose");
        if (commonClose.closed) {
            return;
        }
        if (commonClose.bufferField.size() > 0) {
            Sink sink = commonClose.sink;
            Buffer buffer = commonClose.bufferField;
            sink.write(buffer, buffer.size());
        }
        th = null;
        try {
            commonClose.sink.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        commonClose.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public static final Timeout commonTimeout(@NotNull RealBufferedSink commonTimeout) {
        Intrinsics.checkNotNullParameter(commonTimeout, "$this$commonTimeout");
        return commonTimeout.sink.timeout();
    }

    public static final String commonToString(@NotNull RealBufferedSink commonToString) {
        Intrinsics.checkNotNullParameter(commonToString, "$this$commonToString");
        return "buffer(" + commonToString.sink + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public static final long commonWriteAll(@NotNull RealBufferedSink commonWriteAll, @NotNull Source source) throws IOException {
        Intrinsics.checkNotNullParameter(commonWriteAll, "$this$commonWriteAll");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long j2 = source.read(commonWriteAll.bufferField, 8192);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            commonWriteAll.emitCompleteSegments();
        }
    }

    public static final BufferedSink commonWrite(@NotNull RealBufferedSink commonWrite, @NotNull Source source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long j2 = source.read(commonWrite.bufferField, j);
            if (j2 == -1) {
                throw new EOFException();
            }
            j -= j2;
            commonWrite.emitCompleteSegments();
        }
        return commonWrite;
    }
}
