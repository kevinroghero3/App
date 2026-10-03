package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okio.BufferedSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Response.Builder responseHeaders;
        boolean z;
        Response responseBuild;
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange$okhttp = realInterceptorChain.getExchange$okhttp();
        if (exchange$okhttp == null) {
            Intrinsics.throwNpe();
        }
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RequestBody requestBodyBody = request$okhttp.body();
        long jCurrentTimeMillis = System.currentTimeMillis();
        exchange$okhttp.writeRequestHeaders(request$okhttp);
        if (HttpMethod.permitsRequestBody(request$okhttp.method()) && requestBodyBody != null) {
            if (StringsKt__StringsJVMKt.equals("100-continue", request$okhttp.header(com.google.common.net.HttpHeaders.EXPECT), true)) {
                exchange$okhttp.flushRequest();
                responseHeaders = exchange$okhttp.readResponseHeaders(true);
                exchange$okhttp.responseHeadersStart();
                z = false;
            } else {
                responseHeaders = null;
                z = true;
            }
            if (responseHeaders == null) {
                if (requestBodyBody.isDuplex()) {
                    exchange$okhttp.flushRequest();
                    requestBodyBody.writeTo(Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, true)));
                } else {
                    BufferedSink bufferedSinkBuffer = Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, false));
                    requestBodyBody.writeTo(bufferedSinkBuffer);
                    bufferedSinkBuffer.close();
                }
            } else {
                exchange$okhttp.noRequestBody();
                if (!exchange$okhttp.getConnection$okhttp().isMultiplexed()) {
                    exchange$okhttp.noNewExchangesOnConnection();
                }
            }
        } else {
            exchange$okhttp.noRequestBody();
            responseHeaders = null;
            z = true;
        }
        if (requestBodyBody == null || !requestBodyBody.isDuplex()) {
            exchange$okhttp.finishRequest();
        }
        if (responseHeaders == null) {
            responseHeaders = exchange$okhttp.readResponseHeaders(false);
            if (responseHeaders == null) {
                Intrinsics.throwNpe();
            }
            if (z) {
                exchange$okhttp.responseHeadersStart();
                z = false;
            }
        }
        Response responseBuild2 = responseHeaders.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int iCode = responseBuild2.code();
        if (iCode == 100) {
            Response.Builder responseHeaders2 = exchange$okhttp.readResponseHeaders(false);
            if (responseHeaders2 == null) {
                Intrinsics.throwNpe();
            }
            if (z) {
                exchange$okhttp.responseHeadersStart();
            }
            responseBuild2 = responseHeaders2.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            iCode = responseBuild2.code();
        }
        exchange$okhttp.responseHeadersEnd(responseBuild2);
        if (this.forWebSocket && iCode == 101) {
            responseBuild = responseBuild2.newBuilder().body(Util.EMPTY_RESPONSE).build();
        } else {
            responseBuild = responseBuild2.newBuilder().body(exchange$okhttp.openResponseBody(responseBuild2)).build();
        }
        if (StringsKt__StringsJVMKt.equals("close", responseBuild.request().header(com.google.common.net.HttpHeaders.CONNECTION), true) || StringsKt__StringsJVMKt.equals("close", Response.header$default(responseBuild, com.google.common.net.HttpHeaders.CONNECTION, null, 2, null), true)) {
            exchange$okhttp.noNewExchangesOnConnection();
        }
        if (iCode == 204 || iCode == 205) {
            ResponseBody responseBodyBody = responseBuild.body();
            if ((responseBodyBody != null ? responseBodyBody.contentLength() : -1L) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(iCode);
                sb.append(" had non-zero Content-Length: ");
                ResponseBody responseBodyBody2 = responseBuild.body();
                sb.append(responseBodyBody2 != null ? Long.valueOf(responseBodyBody2.contentLength()) : null);
                throw new ProtocolException(sb.toString());
            }
        }
        return responseBuild;
    }
}
