package com.facebook.imagepipeline.backends.okhttp3;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class OkHttpNetworkFetcherException extends Exception {
    public static final Companion Companion = new Companion(null);
    private final Integer responseCode;
    private final Headers responseHeaders;

    public OkHttpNetworkFetcherException() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @JvmStatic
    public static final OkHttpNetworkFetcherException fromResponse(@NotNull Response response) {
        return Companion.fromResponse(response);
    }

    public /* synthetic */ OkHttpNetworkFetcherException(Integer num, Headers headers, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : headers);
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public final Headers getResponseHeaders() {
        return this.responseHeaders;
    }

    public OkHttpNetworkFetcherException(@Nullable Integer num, @Nullable Headers headers) {
        this.responseCode = num;
        this.responseHeaders = headers;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OkHttpNetworkFetcherException fromResponse(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            Response responseNetworkResponse = response.networkResponse();
            Integer numValueOf = responseNetworkResponse != null ? Integer.valueOf(responseNetworkResponse.code()) : null;
            Response responseNetworkResponse2 = response.networkResponse();
            return new OkHttpNetworkFetcherException(numValueOf, responseNetworkResponse2 != null ? responseNetworkResponse2.headers() : null);
        }
    }
}
