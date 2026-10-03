package okhttp3.internal.ws;

import ch.qos.logback.core.CoreConstants;
import com.google.common.net.HttpHeaders;
import com.hitachiapp.exceptions.RunningOnRootedDeviceException;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;
    public static final Companion Companion = new Companion(null);
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt__CollectionsJVMKt.listOf(Protocol.HTTP_1_1);

    public RealWebSocket(@NotNull TaskRunner taskRunner, @NotNull Request originalRequest, @NotNull WebSocketListener listener, @NotNull Random random, long j) {
        Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics.checkParameterIsNotNull(originalRequest, "originalRequest");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        Intrinsics.checkParameterIsNotNull(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = j;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!Intrinsics.areEqual("GET", originalRequest.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + originalRequest.method()).toString());
        }
        ByteString.Companion companion = ByteString.Companion;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, null).base64();
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public final class WriterTask extends Task {
        public static void $$a(long j, long j2) throws Throwable {
            try {
                Constructor declaredConstructor = RunningOnRootedDeviceException.class.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                throw ((Throwable) declaredConstructor.newInstance(null));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                return RealWebSocket.this.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e) {
                RealWebSocket.this.failWebSocket(e, null);
                return -1L;
            }
        }
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public long queueSize() {
        long j;
        synchronized (this) {
            j = this.queueSize;
        }
        return j;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        if (call == null) {
            Intrinsics.throwNpe();
        }
        call.cancel();
    }

    public final void connect(@NotNull OkHttpClient client) {
        Intrinsics.checkParameterIsNotNull(client, "client");
        OkHttpClient okHttpClientBuild = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request requestBuild = this.originalRequest.newBuilder().header(HttpHeaders.UPGRADE, "websocket").header(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE).header(HttpHeaders.SEC_WEBSOCKET_KEY, this.key).header(HttpHeaders.SEC_WEBSOCKET_VERSION, "13").build();
        RealCall realCall = new RealCall(okHttpClientBuild, requestBuild, true);
        this.call = realCall;
        realCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket.connect.1
            @Override // okhttp3.Callback
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                Intrinsics.checkParameterIsNotNull(call, "call");
                Intrinsics.checkParameterIsNotNull(response, "response");
                Exchange exchange = response.exchange();
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    if (exchange == null) {
                        Intrinsics.throwNpe();
                    }
                    try {
                        RealWebSocket.this.initReaderAndWriter(Util.okHttpName + " WebSocket " + requestBuild.url().redact(), exchange.newWebSocketStreams());
                        RealWebSocket.this.getListener$okhttp().onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (IOException e2) {
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                    RealWebSocket.this.failWebSocket(e2, response);
                    Util.closeQuietly(response);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Intrinsics.checkParameterIsNotNull(call, "call");
                Intrinsics.checkParameterIsNotNull(e, "e");
                RealWebSocket.this.failWebSocket(e, null);
            }
        });
    }

    public final void checkUpgradeSuccess$okhttp(@NotNull Response response, @Nullable Exchange exchange) throws IOException {
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        String strHeader$default = Response.header$default(response, HttpHeaders.CONNECTION, null, 2, null);
        if (!StringsKt__StringsJVMKt.equals(HttpHeaders.UPGRADE, strHeader$default, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strHeader$default + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        String strHeader$default2 = Response.header$default(response, HttpHeaders.UPGRADE, null, 2, null);
        if (!StringsKt__StringsJVMKt.equals("websocket", strHeader$default2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strHeader$default2 + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        String strHeader$default3 = Response.header$default(response, HttpHeaders.SEC_WEBSOCKET_ACCEPT, null, 2, null);
        String strBase64 = ByteString.Companion.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if (Intrinsics.areEqual(strBase64, strHeader$default3)) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strHeader$default3 + CoreConstants.SINGLE_QUOTE_CHAR);
    }

    public final void initReaderAndWriter(@NotNull final String name, @NotNull final Streams streams) throws IOException {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(streams, "streams");
        synchronized (this) {
            this.name = name;
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random);
            this.writerTask = new WriterTask();
            long j = this.pingIntervalMillis;
            if (j != 0) {
                final long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                final String str = name + " ping";
                this.taskQueue.schedule(new Task(str) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1
                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        this.writePingFrame$okhttp();
                        return nanos;
                    }
                }, nanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this);
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            if (webSocketReader == null) {
                Intrinsics.throwNpe();
            }
            webSocketReader.processNextFrame();
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            if (webSocketReader == null) {
                Intrinsics.throwNpe();
            }
            webSocketReader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e) {
            failWebSocket(e, null);
        }
    }

    public final void awaitTermination(long j, @NotNull TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(j, timeUnit);
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    public final int sentPingCount() {
        int i;
        synchronized (this) {
            i = this.sentPingCount;
        }
        return i;
    }

    public final int receivedPingCount() {
        int i;
        synchronized (this) {
            i = this.receivedPingCount;
        }
        return i;
    }

    public final int receivedPongCount() {
        int i;
        synchronized (this) {
            i = this.receivedPongCount;
        }
        return i;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull String text) throws IOException {
        Intrinsics.checkParameterIsNotNull(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull ByteString bytes) throws IOException {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadPing(@NotNull ByteString payload) {
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                this.receivedPingCount++;
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadPong(@NotNull ByteString payload) {
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(payload, "payload");
            this.receivedPongCount++;
            this.awaitingPong = false;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, @NotNull String reason) {
        Streams streams;
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        if (i == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new IllegalStateException("already closed");
            }
            this.receivedCloseCode = i;
            this.receivedCloseReason = reason;
            streams = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                Streams streams2 = this.streams;
                this.streams = null;
                this.taskQueue.shutdown();
                streams = streams2;
            }
            Unit unit = Unit.INSTANCE;
        }
        try {
            this.listener.onClosing(this, i, reason);
            if (streams != null) {
                this.listener.onClosed(this, i, reason);
            }
        } finally {
            if (streams != null) {
                Util.closeQuietly(streams);
            }
        }
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull String text) {
        Intrinsics.checkParameterIsNotNull(text, "text");
        return send(ByteString.Companion.encodeUtf8(text), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull ByteString bytes) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        return send(bytes, 2);
    }

    private final boolean send(ByteString byteString, int i) {
        synchronized (this) {
            if (!this.failed && !this.enqueuedClose) {
                if (this.queueSize + ((long) byteString.size()) > MAX_QUEUE_SIZE) {
                    close(1001, null);
                    return false;
                }
                this.queueSize += (long) byteString.size();
                this.messageAndCloseQueue.add(new Message(i, byteString));
                runWriter();
                return true;
            }
            return false;
        }
    }

    public final boolean pong(@NotNull ByteString payload) {
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                return true;
            }
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, @Nullable String str) {
        return close(i, str, 60000L);
    }

    public final boolean close(int i, @Nullable String str, long j) {
        ByteString byteStringEncodeUtf8;
        synchronized (this) {
            WebSocketProtocol.INSTANCE.validateCloseCode(i);
            if (str != null) {
                byteStringEncodeUtf8 = ByteString.Companion.encodeUtf8(str);
                if (byteStringEncodeUtf8.size() > 123) {
                    throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                }
            } else {
                byteStringEncodeUtf8 = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i, byteStringEncodeUtf8, j));
                runWriter();
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0156  */
    /* JADX WARN: Code duplicated, block: B:84:0x0178  */
    /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v6, types: [okhttp3.internal.ws.WebSocketWriter] */
    /* JADX WARN: Type inference failed for: r2v12, types: [T, okhttp3.internal.ws.RealWebSocket$Streams] */
    /* JADX WARN: Type inference failed for: r3v10, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
    public final boolean writeOneFrame$okhttp() throws Throwable {
        Ref.ObjectRef objectRef;
        Streams streams;
        Ref.ObjectRef objectRef2;
        Streams streams2;
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = null;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        objectRef4.element = null;
        final Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
        objectRef5.element = null;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            final WebSocketWriter webSocketWriter = this.writer;
            final ByteString byteStringPoll = this.pongQueue.poll();
            if (byteStringPoll == null) {
                ?? Poll = this.messageAndCloseQueue.poll();
                objectRef3.element = Poll;
                if (Poll instanceof Close) {
                    int i = this.receivedCloseCode;
                    intRef.element = i;
                    objectRef4.element = this.receivedCloseReason;
                    if (i != -1) {
                        objectRef5.element = this.streams;
                        this.streams = null;
                        this.taskQueue.shutdown();
                    } else {
                        T t = objectRef3.element;
                        if (t == 0) {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                        }
                        long cancelAfterCloseMillis = ((Close) t).getCancelAfterCloseMillis();
                        TaskQueue taskQueue = this.taskQueue;
                        final String str = this.name + " cancel";
                        final boolean z = true;
                        final boolean z2 = true;
                        taskQueue.schedule(new Task(str, z2) { // from class: okhttp3.internal.ws.RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1
                            @Override // okhttp3.internal.concurrent.Task
                            public long runOnce() {
                                this.cancel();
                                return -1L;
                            }
                        }, TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis));
                    }
                } else if (Poll == 0) {
                    return false;
                }
            }
            Unit unit = Unit.INSTANCE;
            try {
                if (byteStringPoll == null) {
                    objectRef = webSocketWriter;
                    T t2 = objectRef3.element;
                    if (!(t2 instanceof Message)) {
                        try {
                            if (!(t2 instanceof Close)) {
                                throw new AssertionError();
                            }
                            if (t2 != 0) {
                                Close close = (Close) t2;
                                if (objectRef == 0) {
                                    Intrinsics.throwNpe();
                                }
                                objectRef.writeClose(close.getCode(), close.getReason());
                                objectRef2 = objectRef5;
                                if (((Streams) objectRef2.element) != null) {
                                    WebSocketListener webSocketListener = this.listener;
                                    int i2 = intRef.element;
                                    String str2 = (String) objectRef4.element;
                                    if (str2 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    webSocketListener.onClosed(this, i2, str2);
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                            }
                        } catch (Throwable th) {
                            th = th;
                            streams = (Streams) objectRef.element;
                            if (streams != null) {
                                Util.closeQuietly(streams);
                            }
                            throw th;
                        }
                    } else if (t2 != 0) {
                        ByteString data = ((Message) t2).getData();
                        if (objectRef == 0) {
                            Intrinsics.throwNpe();
                        }
                        T t3 = objectRef3.element;
                        if (t3 != 0) {
                            BufferedSink bufferedSinkBuffer = Okio.buffer(objectRef.newMessageSink(((Message) t3).getFormatOpcode(), data.size()));
                            bufferedSinkBuffer.write(data);
                            bufferedSinkBuffer.close();
                            synchronized (this) {
                                this.queueSize -= (long) data.size();
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                    }
                    streams2 = (Streams) objectRef2.element;
                    if (streams2 != null) {
                        return true;
                    }
                    Util.closeQuietly(streams2);
                    return true;
                }
                if (webSocketWriter == null) {
                    Intrinsics.throwNpe();
                }
                webSocketWriter.writePong(byteStringPoll);
                objectRef2 = objectRef5;
                streams2 = (Streams) objectRef2.element;
                if (streams2 != null) {
                    return true;
                }
                Util.closeQuietly(streams2);
                return true;
            } catch (Throwable th2) {
                th = th2;
                objectRef = objectRef5;
                streams = (Streams) objectRef.element;
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                throw th;
            }
        }
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            WebSocketWriter webSocketWriter = this.writer;
            int i = this.awaitingPong ? this.sentPingCount : -1;
            this.sentPingCount++;
            this.awaitingPong = true;
            Unit unit = Unit.INSTANCE;
            if (i == -1) {
                if (webSocketWriter == null) {
                    try {
                        Intrinsics.throwNpe();
                    } catch (IOException e) {
                        failWebSocket(e, null);
                        return;
                    }
                }
                webSocketWriter.writePing(ByteString.EMPTY);
                return;
            }
            failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        }
    }

    public final void failWebSocket(@NotNull Exception e, @Nullable Response response) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            this.taskQueue.shutdown();
            Unit unit = Unit.INSTANCE;
            try {
                this.listener.onFailure(this, e, response);
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i, @NotNull ByteString data) {
            Intrinsics.checkParameterIsNotNull(data, "data");
            this.formatOpcode = i;
            this.data = data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        public final ByteString getData() {
            return this.data;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int i, @Nullable ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean z, @NotNull BufferedSource source, @NotNull BufferedSink sink) {
            Intrinsics.checkParameterIsNotNull(source, "source");
            Intrinsics.checkParameterIsNotNull(sink, "sink");
            this.client = z;
            this.source = source;
            this.sink = sink;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSource getSource() {
            return this.source;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }
}
