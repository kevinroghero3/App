package com.salesforce.marketingcloud.sfmcsdk.components.http;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class Request {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_CONNECTION_TIMEOUT = 30000;
    public static final String GET = "GET";
    public static final String PATCH = "PATCH";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final int RESPONSE_REQUEST_FAILED = -100;
    private final int connectionTimeout;
    private final List<String> headers;
    private final String method;
    private final String name;
    private final long rateLimit;
    private final String requestBody;
    private String tag;
    private final String url;

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Method {
    }

    public Request(@NotNull String method, @Nullable String str, int i, @NotNull String url, @NotNull List<String> headers, @NotNull String name, long j, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(name, "name");
        this.method = method;
        this.requestBody = str;
        this.connectionTimeout = i;
        this.url = url;
        this.headers = headers;
        this.name = name;
        this.rateLimit = j;
        this.tag = str2;
    }

    public /* synthetic */ Request(String str, String str2, int i, String str3, List list, String str4, long j, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, str3, list, str4, j, (i2 & 128) != 0 ? null : str5);
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getRequestBody() {
        return this.requestBody;
    }

    public final int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<String> getHeaders() {
        return this.headers;
    }

    public final String getName() {
        return this.name;
    }

    public final long getRateLimit() {
        return this.rateLimit;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(@Nullable String str) {
        this.tag = str;
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Builder toBuilder$sfmcsdk_release() {
        Builder builderHeaders = new Builder().method(this.method).url(this.url).connectionTimeout(this.connectionTimeout).name(this.name).headers(this.headers);
        String str = this.requestBody;
        if (str != null) {
            builderHeaders.requestBody(str);
        }
        return builderHeaders;
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Builder {
        private List<String> headers;
        private String method;
        private String name;
        private long rateLimit;
        private String requestBody;
        private String tag;
        private String url;
        private int connectionTimeout = 30000;
        private Map<String, String> headersMap = new LinkedHashMap();

        public final Builder method(@NotNull String method) {
            Intrinsics.checkNotNullParameter(method, "method");
            this.method = method;
            return this;
        }

        public final Builder requestBody(@Nullable String str) {
            this.requestBody = str;
            return this;
        }

        public final Builder url(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            return this;
        }

        public final Builder url(@NotNull String baseUrl, @NotNull String path) {
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            Intrinsics.checkNotNullParameter(path, "path");
            if (StringsKt__StringsJVMKt.endsWith$default(baseUrl, RemoteSettings.FORWARD_SLASH_STRING, false, 2, null)) {
                baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
                Intrinsics.checkNotNullExpressionValue(baseUrl, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            this.url = new URL(baseUrl + path).toString();
            return this;
        }

        public final Builder name(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            return this;
        }

        public final Builder rateLimit(long j) {
            this.rateLimit = TimeUnit.SECONDS.toMillis(j);
            return this;
        }

        public final Builder connectionTimeout(int i) {
            this.connectionTimeout = i;
            return this;
        }

        public final Builder headers(@NotNull List<String> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers = headers;
            return this;
        }

        public final Builder addOrReplaceHeader(@NotNull String key, @NotNull String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.headersMap.put(key, StringsKt__StringsKt.trim((CharSequence) value).toString());
            return this;
        }

        public final Builder tag(@Nullable String str) {
            this.tag = str;
            return this;
        }

        public final Request build() {
            List arrayList;
            List<String> list = this.headers;
            if (list == null || (arrayList = CollectionsKt___CollectionsKt.toMutableList((Collection) list)) == null) {
                arrayList = new ArrayList();
            }
            for (Map.Entry<String, String> entry : this.headersMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                arrayList.add(key);
                arrayList.add(value);
            }
            String str = this.method;
            if (str == null) {
                throw new IllegalStateException("Required value was null.");
            }
            String str2 = this.url;
            if (str2 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            int i = this.connectionTimeout;
            String str3 = this.requestBody;
            List list2 = CollectionsKt___CollectionsKt.toList(arrayList);
            if (list2 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            String str4 = this.name;
            if (str4 != null) {
                return new Request(str, str3, i, str2, list2, str4, this.rateLimit, this.tag);
            }
            throw new IllegalStateException("Required value was null.");
        }
    }
}
