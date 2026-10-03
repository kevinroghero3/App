package com.alpha0010.fs;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import io.sentry.Session;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.SocketFactory;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class NetworkHandler {
    private final ReactContext context;
    private final DeviceEventManagerModule.RCTDeviceEventEmitter emitter;

    /* JADX INFO: renamed from: com.alpha0010.fs.NetworkHandler$fetch$1, reason: invalid class name */
    @DebugMetadata(c = "com.alpha0010.fs.NetworkHandler", f = "NetworkHandler.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = RemoteConfigComponent.FETCH_FILE_NAME, n = {"this", Session.JsonKeys.INIT, "onComplete", "request", "requestId"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkHandler.this.fetch(0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.alpha0010.fs.NetworkHandler$getClient$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.alpha0010.fs.NetworkHandler", f = "NetworkHandler.kt", i = {}, l = {SyslogConstants.LOG_LOCAL6}, m = "getClient", n = {}, s = {})
    static final class C03101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03101(Continuation<? super C03101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkHandler.this.getClient(false, null, this);
        }
    }

    public NetworkHandler(@NotNull ReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object fetch(final int i, @NotNull String str, @NotNull final ReadableMap readableMap, @NotNull final Function0<Unit> function0, @NotNull Continuation<? super Call> continuation) {
        AnonymousClass1 anonymousClass1;
        Request requestBuildRequest;
        final NetworkHandler networkHandler;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object client = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(client);
            try {
                requestBuildRequest = buildRequest(str, readableMap);
                try {
                    boolean z = readableMap.hasKey("network") && Intrinsics.areEqual(readableMap.getString("network"), "unmetered");
                    Function3<? super Long, ? super Long, ? super Boolean, Unit> function3 = new Function3() { // from class: com.alpha0010.fs.NetworkHandler$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NetworkHandler.fetch$lambda$0(this.f$0, i, ((Long) obj).longValue(), ((Long) obj2).longValue(), ((Boolean) obj3).booleanValue());
                        }
                    };
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = readableMap;
                    anonymousClass1.L$2 = function0;
                    anonymousClass1.L$3 = requestBuildRequest;
                    anonymousClass1.I$0 = i;
                    anonymousClass1.label = 1;
                    client = getClient(z, function3, anonymousClass1);
                    if (client == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    networkHandler = this;
                } catch (Throwable th) {
                    th = th;
                    networkHandler = this;
                    function0.invoke();
                    networkHandler.onFetchError(i, th);
                    return null;
                }
            } catch (Throwable th2) {
                function0.invoke();
                onFetchError(i, th2);
                return null;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = anonymousClass1.I$0;
            requestBuildRequest = (Request) anonymousClass1.L$3;
            function0 = (Function0) anonymousClass1.L$2;
            readableMap = (ReadableMap) anonymousClass1.L$1;
            networkHandler = (NetworkHandler) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(client);
            } catch (Throwable th3) {
                th = th3;
                function0.invoke();
                networkHandler.onFetchError(i, th);
                return null;
            }
        }
        Call callNewCall = ((OkHttpClient) client).newCall(requestBuildRequest);
        FirebasePerfOkHttpClient.enqueue(callNewCall, new Callback() { // from class: com.alpha0010.fs.NetworkHandler.fetch.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                function0.invoke();
                networkHandler.onFetchError(i, e);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    ReadableMap readableMap2 = readableMap;
                    Function0<Unit> function1 = function0;
                    NetworkHandler networkHandler2 = networkHandler;
                    int i4 = i;
                    try {
                        if (readableMap2.hasKey("path")) {
                            String string = readableMap2.getString("path");
                            Intrinsics.checkNotNull(string);
                            File pathToFile = UtilKt.parsePathToFile(string);
                            FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(pathToFile), pathToFile);
                            try {
                                ResponseBody responseBodyBody = response.body();
                                Intrinsics.checkNotNull(responseBodyBody);
                                ByteStreamsKt.copyTo$default(responseBodyBody.byteStream(), fileOutputStreamCreate, 0, 2, null);
                                CloseableKt.closeFinally(fileOutputStreamCreate, null);
                            } catch (Throwable th4) {
                                try {
                                    throw th4;
                                } catch (Throwable th5) {
                                    CloseableKt.closeFinally(fileOutputStreamCreate, th4);
                                    throw th5;
                                }
                            }
                        }
                        function1.invoke();
                        Set<String> setNames = response.headers().names();
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(setNames, 10));
                        for (String str2 : setNames) {
                            arrayList.add(TuplesKt.to(str2, Response.header$default(response, str2, null, 2, null)));
                        }
                        networkHandler2.emitter.emit(NetworkHandlerKt.FETCH_EVENT, Arguments.makeNativeMap((Map<String, Object>) MapsKt__MapsKt.mapOf(TuplesKt.to("requestId", Integer.valueOf(i4)), TuplesKt.to("state", "complete"), TuplesKt.to("headers", Arguments.makeNativeMap((Map<String, Object>) MapsKt__MapsKt.toMap(arrayList))), TuplesKt.to("ok", Boolean.valueOf(response.isSuccessful())), TuplesKt.to("redirected", Boolean.valueOf(response.isRedirect())), TuplesKt.to("status", Integer.valueOf(response.code())), TuplesKt.to("statusText", response.message()), TuplesKt.to("url", response.request().url().toString()))));
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(response, null);
                    } catch (Throwable th6) {
                        try {
                            throw th6;
                        } catch (Throwable th7) {
                            CloseableKt.closeFinally(response, th6);
                            throw th7;
                        }
                    }
                } catch (Throwable th8) {
                    function0.invoke();
                    networkHandler.onFetchError(i, th8);
                }
            }
        });
        return callNewCall;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetch$lambda$0(NetworkHandler networkHandler, int i, long j, long j2, boolean z) {
        networkHandler.emitter.emit(NetworkHandlerKt.FETCH_EVENT, Arguments.makeNativeMap((Map<String, Object>) MapsKt__MapsKt.mapOf(TuplesKt.to("requestId", Integer.valueOf(i)), TuplesKt.to("state", "progress"), TuplesKt.to("bytesRead", Long.valueOf(j)), TuplesKt.to("contentLength", Long.valueOf(j2)), TuplesKt.to("done", Boolean.valueOf(z)))));
        return Unit.INSTANCE;
    }

    private final Request buildRequest(String str, ReadableMap readableMap) {
        Request.Builder builderCacheControl = new Request.Builder().url(str).cacheControl(new CacheControl.Builder().noStore().build());
        if (readableMap.hasKey("method")) {
            if (readableMap.hasKey("body")) {
                String string = readableMap.getString("method");
                Intrinsics.checkNotNull(string);
                RequestBody.Companion companion = RequestBody.Companion;
                String string2 = readableMap.getString("body");
                Intrinsics.checkNotNull(string2);
                builderCacheControl.method(string, companion.create(string2, (MediaType) null));
            } else {
                String string3 = readableMap.getString("method");
                Intrinsics.checkNotNull(string3);
                builderCacheControl.method(string3, null);
            }
        }
        if (readableMap.hasKey("headers")) {
            ReadableMap map = readableMap.getMap("headers");
            Intrinsics.checkNotNull(map);
            Iterator<Map.Entry<String, Object>> entryIterator = map.getEntryIterator();
            while (entryIterator.hasNext()) {
                Map.Entry<String, Object> next = entryIterator.next();
                String key = next.getKey();
                Object value = next.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                builderCacheControl.header(key, (String) value);
            }
        }
        return builderCacheControl.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getUnmeteredNetwork(Continuation<? super SocketFactory> continuation) throws Throwable {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        Object systemService = this.context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        final ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addCapability(11).build(), new ConnectivityManager.NetworkCallback() { // from class: com.alpha0010.fs.NetworkHandler$getUnmeteredNetwork$2$cb$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                connectivityManager.unregisterNetworkCallback(this);
                Continuation<SocketFactory> continuation2 = safeContinuation;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.m5472constructorimpl(network.getSocketFactory()));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                connectivityManager.unregisterNetworkCallback(this);
                Continuation<SocketFactory> continuation2 = safeContinuation;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.m5472constructorimpl(ResultKt.createFailure(new Exception("Unmetered network unavailable."))));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getClient(boolean z, final Function3<? super Long, ? super Long, ? super Boolean, Unit> function3, Continuation<? super OkHttpClient> continuation) throws Throwable {
        C03101 c03101;
        OkHttpClient.Builder builderAddNetworkInterceptor;
        OkHttpClient.Builder builder;
        if (continuation instanceof C03101) {
            c03101 = (C03101) continuation;
            int i = c03101.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03101.label = i - Integer.MIN_VALUE;
            } else {
                c03101 = new C03101(continuation);
            }
        } else {
            c03101 = new C03101(continuation);
        }
        Object unmeteredNetwork = c03101.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c03101.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(unmeteredNetwork);
            builderAddNetworkInterceptor = OkHttpClientProvider.getOkHttpClient().newBuilder().addNetworkInterceptor(new Interceptor() { // from class: com.alpha0010.fs.NetworkHandler$getClient$$inlined$-addNetworkInterceptor$1
                @Override // okhttp3.Interceptor
                public final Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
                    Response responseBuild;
                    Intrinsics.checkNotNullParameter(chain, "chain");
                    Response responseProceed = chain.proceed(chain.request());
                    ResponseBody responseBodyBody = responseProceed.body();
                    return (responseBodyBody == null || (responseBuild = responseProceed.newBuilder().body(new ProgressResponseBody(responseBodyBody, function3)).build()) == null) ? responseProceed : responseBuild;
                }
            });
            if (z) {
                c03101.L$0 = builderAddNetworkInterceptor;
                c03101.L$1 = builderAddNetworkInterceptor;
                c03101.label = 1;
                unmeteredNetwork = getUnmeteredNetwork(c03101);
                if (unmeteredNetwork == coroutine_suspended) {
                    return coroutine_suspended;
                }
                builder = builderAddNetworkInterceptor;
            }
            return builderAddNetworkInterceptor.build();
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        builder = (OkHttpClient.Builder) c03101.L$1;
        builderAddNetworkInterceptor = (OkHttpClient.Builder) c03101.L$0;
        ResultKt.throwOnFailure(unmeteredNetwork);
        builder.socketFactory((SocketFactory) unmeteredNetwork);
        return builderAddNetworkInterceptor.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFetchError(int i, Throwable th) {
        this.emitter.emit(NetworkHandlerKt.FETCH_EVENT, Arguments.makeNativeMap((Map<String, Object>) MapsKt__MapsKt.mapOf(TuplesKt.to("requestId", Integer.valueOf(i)), TuplesKt.to("state", "error"), TuplesKt.to("message", th.getLocalizedMessage()))));
    }
}
