package com.salesforce.marketingcloud.sfmcsdk.components.http;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutors;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutorsKt;
import com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt;
import com.salesforce.marketingcloud.sfmcsdk.util.NetworkUtils;
import io.sentry.HttpStatusCodeRange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class NetworkManager {
    public static final Companion Companion = new Companion(null);
    public static final long MAX_SERVER_RETRY = 86400000;
    public static final String TAG = "~$NetworkManager";
    private final Authenticator authenticator;
    private final Context context;
    private final SdkExecutors executors;
    private final SharedPreferences networkPreferences;
    private final Map<String, AtomicBoolean> requestsInFlight;

    public static /* synthetic */ void getRequestsInFlight$sfmcsdk_release$annotations() {
    }

    public NetworkManager(@NotNull Context context, @NotNull SdkExecutors executors, @NotNull SharedPreferences networkPreferences, @Nullable Authenticator authenticator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executors, "executors");
        Intrinsics.checkNotNullParameter(networkPreferences, "networkPreferences");
        this.context = context;
        this.executors = executors;
        this.networkPreferences = networkPreferences;
        this.authenticator = authenticator;
        this.requestsInFlight = new LinkedHashMap();
    }

    public /* synthetic */ NetworkManager(Context context, SdkExecutors sdkExecutors, SharedPreferences sharedPreferences, Authenticator authenticator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, sdkExecutors, sharedPreferences, (i & 8) != 0 ? null : authenticator);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getServerRetryKey$sfmcsdk_release(@NotNull String requestName) {
            Intrinsics.checkNotNullParameter(requestName, "requestName");
            return "retry_server_" + requestName;
        }

        public final String getDeviceRetryKey$sfmcsdk_release(@NotNull String requestName) {
            Intrinsics.checkNotNullParameter(requestName, "requestName");
            return "retry_device_" + requestName;
        }
    }

    public final Map<String, AtomicBoolean> getRequestsInFlight$sfmcsdk_release() {
        return this.requestsInFlight;
    }

    public final void executeAsync(@NotNull final Request request, @NotNull final Callback callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SdkExecutorsKt.namedRunnable(this.executors.getNetworkIO(), "network_manager_execute", new Function0<Unit>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager.executeAsync.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Callback callback2 = callback;
                Request request2 = request;
                callback2.onResponse(request2, this.executeSync(request2));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v30, types: [T, com.salesforce.marketingcloud.sfmcsdk.components.http.Request] */
    /* JADX WARN: Type inference failed for: r3v19, types: [T, com.salesforce.marketingcloud.sfmcsdk.components.http.Request] */
    /* JADX WARN: Type inference failed for: r3v20, types: [T, com.salesforce.marketingcloud.sfmcsdk.components.http.Response] */
    /* JADX WARN: Type inference failed for: r3v6, types: [T, com.salesforce.marketingcloud.sfmcsdk.components.http.Response] */
    public final Response executeSync(@NotNull Request request) {
        Authenticator authenticator;
        Intrinsics.checkNotNullParameter(request, "request");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = request;
        try {
            AtomicBoolean atomicBoolean = this.requestsInFlight.get(request.getName());
            if (atomicBoolean == null || !atomicBoolean.get()) {
                this.requestsInFlight.put(((Request) objectRef.element).getName(), new AtomicBoolean(true));
            } else if (atomicBoolean.get()) {
                return Response.Companion.error$sfmcsdk_release(((Request) objectRef.element).getName() + " request already in-flight", 429);
            }
            AtomicBoolean atomicBoolean2 = this.requestsInFlight.get(((Request) objectRef.element).getName());
            if (atomicBoolean2 != null) {
                atomicBoolean2.set(true);
            }
            if (!NetworkUtils.hasConnectivity(this.context)) {
                AtomicBoolean atomicBoolean3 = this.requestsInFlight.get(((Request) objectRef.element).getName());
                if (atomicBoolean3 != null) {
                    atomicBoolean3.set(false);
                }
                return Response.Companion.error$sfmcsdk_release("Device has no network connectivity", HttpStatusCodeRange.DEFAULT_MAX);
            }
            if (isBlockedByRetryAfter$sfmcsdk_release(((Request) objectRef.element).getName())) {
                AtomicBoolean atomicBoolean4 = this.requestsInFlight.get(((Request) objectRef.element).getName());
                if (atomicBoolean4 != null) {
                    atomicBoolean4.set(false);
                }
                return Response.Companion.error$sfmcsdk_release("Too many requests. " + ((Request) objectRef.element).getName() + " request aborted.", 429);
            }
            NetworkUtils.installProvidersIfNeeded(this.context);
            recordDeviceRetryAfter$sfmcsdk_release$default(this, (Request) objectRef.element, 0L, 2, null);
            Authenticator authenticator2 = this.authenticator;
            if (authenticator2 != null) {
                Pair authTokenHeader$sfmcsdk_release$default = Authenticator.getAuthTokenHeader$sfmcsdk_release$default(authenticator2, false, 1, null);
                if (authTokenHeader$sfmcsdk_release$default == null) {
                    Response responseError$sfmcsdk_release = Response.Companion.error$sfmcsdk_release("Expectation Failed", 417);
                    SFMCSdkLogger.INSTANCE.w(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$executeSync$authHeader$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to get AuthToken header.";
                        }
                    });
                    this.authenticator.deleteCachedToken();
                    AtomicBoolean atomicBoolean5 = this.requestsInFlight.get(((Request) objectRef.element).getName());
                    if (atomicBoolean5 != null) {
                        atomicBoolean5.set(false);
                    }
                    return responseError$sfmcsdk_release;
                }
                objectRef.element = ((Request) objectRef.element).toBuilder$sfmcsdk_release().addOrReplaceHeader((String) authTokenHeader$sfmcsdk_release$default.getFirst(), (String) authTokenHeader$sfmcsdk_release$default.getSecond()).build();
            }
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ?? MakeRequest$sfmcsdk_release = makeRequest$sfmcsdk_release((Request) objectRef.element);
            objectRef2.element = MakeRequest$sfmcsdk_release;
            if (MakeRequest$sfmcsdk_release.getCode() == 401 && (authenticator = this.authenticator) != null) {
                authenticator.deleteCachedToken();
                Pair<String, String> pairRefreshAuthTokenHeader = authenticator.refreshAuthTokenHeader();
                if (pairRefreshAuthTokenHeader != null) {
                    ?? Build = ((Request) objectRef.element).toBuilder$sfmcsdk_release().addOrReplaceHeader(pairRefreshAuthTokenHeader.getFirst(), pairRefreshAuthTokenHeader.getSecond()).build();
                    objectRef.element = Build;
                    ?? MakeRequest$sfmcsdk_release2 = makeRequest$sfmcsdk_release(Build);
                    if (MakeRequest$sfmcsdk_release2.getCode() == 401) {
                        this.authenticator.deleteCachedToken();
                    }
                    objectRef2.element = MakeRequest$sfmcsdk_release2;
                }
            }
            recordRetryAfter$sfmcsdk_release((Request) objectRef.element, (Response) objectRef2.element);
            AtomicBoolean atomicBoolean6 = this.requestsInFlight.get(((Request) objectRef.element).getName());
            if (atomicBoolean6 != null) {
                atomicBoolean6.set(false);
            }
            SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager.executeSync.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return objectRef.element.getName() + " request to " + objectRef.element.getUrl() + " took " + objectRef2.element.timeToExecute() + "ms and resulted in a " + objectRef2.element.getCode() + " - " + objectRef2.element.getMessage() + " response.";
                }
            });
            return (Response) objectRef2.element;
        } catch (Exception e) {
            SFMCSdkLogger.INSTANCE.e(TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager.executeSync.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Could not complete request.";
                }
            });
            AtomicBoolean atomicBoolean7 = this.requestsInFlight.get(((Request) objectRef.element).getName());
            if (atomicBoolean7 != null) {
                atomicBoolean7.set(false);
            }
            return Response.Companion.error$sfmcsdk_release("An unknown error occurred. The " + ((Request) objectRef.element).getName() + " request to " + ((Request) objectRef.element).getUrl() + " could not be completed.", -999);
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0173 A[PHI: r1 r13
  0x0173: PHI (r1v6 com.salesforce.marketingcloud.sfmcsdk.components.http.Response) = 
  (r1v5 com.salesforce.marketingcloud.sfmcsdk.components.http.Response)
  (r1v9 com.salesforce.marketingcloud.sfmcsdk.components.http.Response)
 binds: [B:44:0x0171, B:34:0x0145] A[DONT_GENERATE, DONT_INLINE]
  0x0173: PHI (r13v11 java.net.HttpURLConnection) = (r13v10 java.net.HttpURLConnection), (r13v16 java.net.HttpURLConnection) binds: [B:44:0x0171, B:34:0x0145] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.net.HttpURLConnection] */
    public final Response makeRequest$sfmcsdk_release(@NotNull final Request request) {
        final Response responseError$sfmcsdk_release;
        HttpURLConnection httpURLConnection;
        Intrinsics.checkNotNullParameter(request, "request");
        long jCurrentTimeMillis = System.currentTimeMillis();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            try {
                URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(request.getUrl()).openConnection());
                Intrinsics.checkNotNull(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                ?? r5 = (HttpURLConnection) uRLConnection;
                objectRef.element = r5;
                r5.setRequestMethod(request.getMethod());
                ((HttpURLConnection) objectRef.element).setDoInput(true);
                ((HttpURLConnection) objectRef.element).setUseCaches(false);
                ((HttpURLConnection) objectRef.element).setAllowUserInteraction(false);
                ((HttpURLConnection) objectRef.element).setConnectTimeout(request.getConnectionTimeout());
                int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, request.getHeaders().size() - 1, 2);
                if (progressionLastElement >= 0) {
                    int i = 0;
                    while (true) {
                        ((HttpURLConnection) objectRef.element).setRequestProperty(request.getHeaders().get(i), request.getHeaders().get(i + 1));
                        if (i == progressionLastElement) {
                            break;
                        }
                        i += 2;
                    }
                }
                String requestBody = request.getRequestBody();
                if (requestBody != null) {
                    ((HttpURLConnection) objectRef.element).setDoOutput(true);
                    SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$makeRequest$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return request.getName() + StringUtils.SPACE + objectRef.element.getRequestMethod() + " initiated\nwith request properties " + objectRef.element.getRequestProperties() + "\nand body " + request.getRequestBody();
                        }
                    });
                    OutputStream outputStream = ((HttpURLConnection) objectRef.element).getOutputStream();
                    try {
                        byte[] bytes = requestBody.getBytes(RequestKt.getUTF_8());
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        outputStream.write(bytes);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(outputStream, th);
                            throw th2;
                        }
                    }
                }
                Response.Builder builder = new Response.Builder();
                builder.code(((HttpURLConnection) objectRef.element).getResponseCode());
                String responseMessage = ((HttpURLConnection) objectRef.element).getResponseMessage();
                Intrinsics.checkNotNullExpressionValue(responseMessage, "getResponseMessage(...)");
                builder.message(responseMessage);
                Map<String, List<String>> headerFields = ((HttpURLConnection) objectRef.element).getHeaderFields();
                Intrinsics.checkNotNullExpressionValue(headerFields, "getHeaderFields(...)");
                builder.headers(headerFields);
                try {
                    String all = FileUtilsKt.readAll(((HttpURLConnection) objectRef.element).getInputStream());
                    if (all != null) {
                        builder.body(all);
                    }
                } catch (IOException unused) {
                    String all2 = FileUtilsKt.readAll(((HttpURLConnection) objectRef.element).getErrorStream());
                    if (all2 != null) {
                        builder.body(all2);
                    }
                }
                builder.startTimeMillis(jCurrentTimeMillis);
                builder.endTimeMillis(System.currentTimeMillis());
                responseError$sfmcsdk_release = builder.build();
                SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$makeRequest$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "HTTP response " + responseError$sfmcsdk_release.getCode() + " for " + request.getName() + " request. Request took " + responseError$sfmcsdk_release.timeToExecute() + "ms.";
                    }
                });
                AtomicBoolean atomicBoolean = this.requestsInFlight.get(request.getName());
                if (atomicBoolean != null) {
                    atomicBoolean.set(false);
                }
                httpURLConnection = (HttpURLConnection) objectRef.element;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Exception e) {
                SFMCSdkLogger.INSTANCE.e(TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$makeRequest$4
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to complete request";
                    }
                });
                responseError$sfmcsdk_release = Response.Companion.error$sfmcsdk_release("ERROR", -100);
                AtomicBoolean atomicBoolean2 = this.requestsInFlight.get(request.getName());
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(false);
                }
                httpURLConnection = (HttpURLConnection) objectRef.element;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
            return responseError$sfmcsdk_release;
        } catch (Throwable th3) {
            AtomicBoolean atomicBoolean3 = this.requestsInFlight.get(request.getName());
            if (atomicBoolean3 != null) {
                atomicBoolean3.set(false);
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) objectRef.element;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th3;
        }
    }

    public final boolean isBlockedByRetryAfter$sfmcsdk_release(@NotNull final String requestName) {
        Intrinsics.checkNotNullParameter(requestName, "requestName");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jServerRetryAfterTime$sfmcsdk_release = serverRetryAfterTime$sfmcsdk_release(requestName);
        long jDeviceRetryAfterTime$sfmcsdk_release = deviceRetryAfterTime$sfmcsdk_release(requestName);
        if (jCurrentTimeMillis > jServerRetryAfterTime$sfmcsdk_release && jCurrentTimeMillis > jDeviceRetryAfterTime$sfmcsdk_release) {
            return false;
        }
        SFMCSdkLogger.INSTANCE.w(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$isBlockedByRetryAfter$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Route " + requestName + " _blocked_ by Retry-After.";
            }
        });
        return true;
    }

    public final boolean canMakeRequest(@NotNull String... requestNames) {
        Intrinsics.checkNotNullParameter(requestNames, "requestNames");
        if (!NetworkUtils.hasConnectivity(this.context)) {
            return false;
        }
        for (String str : requestNames) {
            if (isBlockedByRetryAfter$sfmcsdk_release(str)) {
                return false;
            }
        }
        return true;
    }

    public final long serverRetryAfterTime$sfmcsdk_release(@NotNull String requestName) {
        Intrinsics.checkNotNullParameter(requestName, "requestName");
        return this.networkPreferences.getLong(Companion.getServerRetryKey$sfmcsdk_release(requestName), 0L);
    }

    public final long deviceRetryAfterTime$sfmcsdk_release(@NotNull String requestName) {
        Intrinsics.checkNotNullParameter(requestName, "requestName");
        return this.networkPreferences.getLong(Companion.getDeviceRetryKey$sfmcsdk_release(requestName), 0L);
    }

    public static /* synthetic */ void recordDeviceRetryAfter$sfmcsdk_release$default(NetworkManager networkManager, Request request, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        networkManager.recordDeviceRetryAfter$sfmcsdk_release(request, j);
    }

    public final void recordDeviceRetryAfter$sfmcsdk_release(@NotNull Request request, long j) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.getRateLimit() > 0) {
            SharedPreferences.Editor editorEdit = this.networkPreferences.edit();
            editorEdit.putLong(Companion.getDeviceRetryKey$sfmcsdk_release(request.getName()), request.getRateLimit() + j);
            editorEdit.apply();
        }
    }

    public final void recordRetryAfter$sfmcsdk_release(@NotNull Request request, @NotNull Response response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        SharedPreferences.Editor editorEdit = this.networkPreferences.edit();
        recordDeviceRetryAfter$sfmcsdk_release(request, response.getEndTimeMillis());
        List<String> list = response.getHeaders().get(HttpHeaders.RETRY_AFTER);
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            long j = Long.parseLong(list.get(0)) * 1000;
            String serverRetryKey$sfmcsdk_release = Companion.getServerRetryKey$sfmcsdk_release(request.getName());
            long endTimeMillis = response.getEndTimeMillis();
            if (j > 86400000) {
                j = 86400000;
            }
            editorEdit.putLong(serverRetryKey$sfmcsdk_release, endTimeMillis + j);
            editorEdit.apply();
        } catch (Exception e) {
            SFMCSdkLogger.INSTANCE.d(TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager$recordRetryAfter$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to parse Retry-After value.";
                }
            });
        }
    }
}
